package com.goinhn.mini.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goinhn.mini.domain.ResultInfo;
import com.goinhn.mini.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import com.goinhn.mini.service.Impl.UserServiceImpl;
import com.goinhn.mini.service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService service = new UserServiceImpl();

    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        Map<String, String[]> map = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = service.register(user);
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }

        super.writeValue(info, response);
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User u  = service.login(user);
        ResultInfo info = new ResultInfo();

        if(u == null){
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        if(u != null && !"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }
        if(u != null && "Y".equals(u.getStatus())){
            request.getSession().setAttribute("user",u);

            info.setFlag(true);
        }

        this.writeValue(info, response);
    }

    /**
     * 查询单个对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        this.writeValue(user, response);
    }

    /**
     * 退出功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 返回验证码进行验证
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.cyan);
        g.drawRect(0, 0, width-1, height-1);

        String checkCode = this.getCheckCode();
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        Random ran = new Random();
        g.setColor(Color.black);
        for(int i = 0; i< 5;i++){
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if(code != null){
            boolean flag = service.active(code);
            String msg = null;
            if(flag){

                msg = "激活成功，请<a href='login.html'>登录</a>";
            }else{
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(size);
            char c = base.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}
