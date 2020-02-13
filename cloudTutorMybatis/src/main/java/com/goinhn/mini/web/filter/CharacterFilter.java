package com.goinhn.mini.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决全站乱码问题，处理所有的请求
 */
@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) rep;

        String method = request.getMethod();
        if(method.equalsIgnoreCase("post")){
            request.setCharacterEncoding("utf-8");
        }

        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
