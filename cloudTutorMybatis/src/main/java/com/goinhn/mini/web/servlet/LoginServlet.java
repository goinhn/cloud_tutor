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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        User u = service.login(user);

        ResultInfo info = new ResultInfo();

        if (u == null) {
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }

        if (u != null && !"Y".equals(u.getStatus())) {
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }

        if (u != null && "Y".equals(u.getStatus())) {
            request.getSession().setAttribute("user", u);
            info.setFlag(true);
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
