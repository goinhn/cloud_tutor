package com.goinhn.mini.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goinhn.mini.domain.ResultInfo;
import com.goinhn.mini.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import com.goinhn.mini.service.Impl.UserServiceImpl;
import com.goinhn.mini.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");

        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if (checkCode == null || !checkCode.equalsIgnoreCase(check)) {
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
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);
        ResultInfo info = new ResultInfo();

        if (flag) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
