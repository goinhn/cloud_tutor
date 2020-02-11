package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();

        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);

        //4.加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy");
    }
}
