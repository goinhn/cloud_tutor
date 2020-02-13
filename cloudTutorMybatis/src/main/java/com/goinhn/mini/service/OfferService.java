package com.goinhn.mini.service;

import com.goinhn.mini.domain.Offer;
import com.goinhn.mini.domain.PageBean;

public interface OfferService {

    PageBean<Offer> pageQuery(int currentPage, int pageSize, String searchType, String searchName);

    Offer findOne(String offerId);
}
