package service;

import domain.Offer;
import domain.PageBean;

public interface OfferService {

    PageBean<Offer> pageQuery(int currentPage, int pageSize, String searchType, String searchName);

    Offer findOne(String offerId);
}
