package service.Impl;

import dao.Impl.OfferDaoImpl;
import dao.OfferDao;
import domain.Offer;
import domain.PageBean;
import service.OfferService;

import java.util.List;

public class OfferServiceImpl implements OfferService {

    private OfferDao offerDao = new OfferDaoImpl();

    /**
     * 查询单页的offer信息
     *
     * @param currentPage
     * @param pageSize
     * @param searchType
     * @param searchName
     * @return
     */
    @Override
    public PageBean<Offer> pageQuery(int currentPage, int pageSize, String searchType, String searchName) {
        PageBean<Offer> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = 0;
        int start = 0;
        List<Offer> lists = null;
        switch (searchType) {
            case "sex":
                totalCount = offerDao.findSexCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = offerDao.findSexByPage(start, pageSize, searchName);
                break;

            case "certification":
                totalCount = offerDao.findCertificationCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = offerDao.findCertificationByPage(start, pageSize, searchName);
                break;

            case "address":
                totalCount = offerDao.findAddressCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = offerDao.findAddressByPage(start, pageSize, searchName);
                break;
        }
        pb.setList(lists);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 根据offerId来查询offer信息
     *
     * @param offerId
     * @return
     */
    @Override
    public Offer findOne(String offerId) {
        return offerDao.findByOfferId(Integer.parseInt(offerId));
    }
}
