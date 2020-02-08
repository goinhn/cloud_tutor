package service;

import domain.PageBean;
import domain.Tutor;

public interface TutorService {

    PageBean<Tutor> pageQuery(int currentPage, int pageSize, String searchType, String searchName);

    Tutor findOne(String tutorId);
}
