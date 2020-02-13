package com.goinhn.mini.web.servlet;

import com.goinhn.mini.domain.Offer;
import com.goinhn.mini.domain.PageBean;
import com.goinhn.mini.service.Impl.OfferServiceImpl;
import com.goinhn.mini.service.OfferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/offer/*")
public class OfferServlet extends BaseServlet {
    private OfferService offerService = new OfferServiceImpl();

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

        PageBean<Offer> pb = offerService.pageQuery(currentPage, pageSize, searchType, searchNameStr);

        super.writeValue(pb,response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String offerId = request.getParameter("offerId");
        Offer route = offerService.findOne(offerId);
        super.writeValue(route,response);
    }
}
