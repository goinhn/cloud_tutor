package com.goinhn.mini.dao;

import com.goinhn.mini.domain.Tutor;

import java.util.List;

public interface TutorDao {

    List<Tutor> findAll();

    List<Tutor> findByUserId(int userId);

    Tutor findByTutorId(int tutorId);

    void updateClick(Tutor tutor);


    int findSexCount(String sex);

    List<Tutor> findSexByPage(int start, int pageSize, String sex);

    int findCertificationCount(String certification);

    List<Tutor> findCertificationByPage(int start, int pageSize, String certification);

    int findAddressCount(String address);

    List<Tutor> findAddressByPage(int start, int pageSize, String address);
}
