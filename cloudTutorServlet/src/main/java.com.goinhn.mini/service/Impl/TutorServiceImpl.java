package service.Impl;

import dao.Impl.TutorDaoImpl;
import dao.TutorDao;
import domain.PageBean;
import domain.Tutor;
import service.TutorService;

import java.util.List;

public class TutorServiceImpl implements TutorService {

    private TutorDao tutorDao = new TutorDaoImpl();

    /**
     * 返回单页的tutor信息
     *
     * @param currentPage
     * @param pageSize
     * @param searchType
     * @param searchName
     * @return
     */
    @Override
    public PageBean<Tutor> pageQuery(int currentPage, int pageSize, String searchType, String searchName) {
        PageBean<Tutor> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = 0;
        int start = 0;
        List<Tutor> lists = null;
        switch (searchType) {
            case "sex":
                totalCount = tutorDao.findSexCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = tutorDao.findSexByPage(start, pageSize, searchName);
                break;

            case "certification":
                totalCount = tutorDao.findCertificationCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = tutorDao.findCertificationByPage(start, pageSize, searchName);
                break;

            case "address":
                totalCount = tutorDao.findAddressCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = tutorDao.findAddressByPage(start, pageSize, searchName);
                break;
        }
        pb.setList(lists);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 根据tutorId来查询tutor信息
     *
     * @param tutorId
     * @return
     */
    @Override
    public Tutor findOne(String tutorId) {
        return tutorDao.findByTutorId(Integer.parseInt(tutorId));
    }
}
