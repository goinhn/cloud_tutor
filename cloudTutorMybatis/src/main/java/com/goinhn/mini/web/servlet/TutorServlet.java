package com.goinhn.mini.web.servlet;

import com.goinhn.mini.domain.Tutor;
import com.goinhn.mini.domain.PageBean;
import com.goinhn.mini.service.Impl.TutorServiceImpl;
import com.goinhn.mini.service.TutorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tutor/*")
public class TutorServlet extends BaseServlet {
    private TutorService offerService = new TutorServiceImpl();

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String searchType = request.getParameter("searchType");
        String searchNameStr = request.getParameter("searchName");

        int currentPage = 0;
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            currentPage = 1;
        }

        int pageSize = 0;
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize = 5;
        }

        PageBean<Tutor> pb = offerService.pageQuery(currentPage, pageSize, searchType, searchNameStr);

        super.writeValue(pb,response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String tutorId = request.getParameter("tutorId");
        Tutor route = offerService.findOne(tutorId);
        super.writeValue(route,response);
    }
}
