package com.goinhn.mini.dao;

import com.goinhn.mini.domain.Offer;

import java.util.List;

public interface OfferDao {

    List<Offer> findAll();

    List<Offer> findByUserId(int userId);

    Offer findByOfferId(int offerId);

    void updateClick(Offer offer);

    int findCount();

    List<Offer> findByPage(int start, int pageSize);

    int findSexCount(String sex);

    List<Offer> findSexByPage(int start, int pageSize, String sex);

    int findCertificationCount(String certification);

    List<Offer> findCertificationByPage(int start, int pageSize, String certification);

    int findAddressCount(String address);

    List<Offer> findAddressByPage(int start, int pageSize, String address);
}
