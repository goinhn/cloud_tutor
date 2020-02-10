package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        for(int i = 0; i< 10;i++){
        	int x1 = ran.nextInt(width);
        	int x2 = ran.nextInt(width);
        	int y1 = ran.nextInt(height);
        	int y2 = ran.nextInt(height);
        	g.drawLine(x1, y1, x2, y2);
		}

        ImageIO.write(image, "PNG", response.getOutputStream());
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
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



