package com.goinhn.mini.service;

import com.goinhn.mini.domain.PageBean;
import com.goinhn.mini.domain.Tutor;

public interface TutorService {

    PageBean<Tutor> pageQuery(int currentPage, int pageSize, String searchType, String searchName);

    Tutor findOne(String tutorId);
}
