package service.Impl;

import dao.Impl.OfferDaoImpl;
import dao.OfferDao;
import domain.Offer;
import domain.PageBean;
import redis.clients.jedis.Jedis;
import service.OfferService;
import util.JedisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
            case "":
                totalCount = offerDao.findSexCount(searchName);
                pb.setTotalCount(totalCount);
                start = (currentPage - 1) * pageSize;
                lists = offerDao.findSexByPage(start, pageSize, searchName);
                break;

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
     * 使用redis来进行缓存
     * @param offerId
     * @return
     */
    @Override
    public Offer findOne(String offerId) {
        Jedis jedis = JedisUtils.getJedis();
        String id = jedis.hget(offerId, "offerId");
        Map<String, String> map = new HashMap<>();

        if(id == null || id.length() == 0){
            Offer offer = offerDao.findByOfferId(Integer.parseInt(offerId));
            offer.setClick(offer.getClick() + 1);


            map.put("userId", String.valueOf(offer.getUserId()));
            map.put("offerId", String.valueOf(offer.getOfferId()));
            map.put("certification", offer.getCertification());
            map.put("sex", offer.getSex());
            map.put("fee", offer.getFee());
            map.put("claim", offer.getClaim());
            map.put("address", offer.getAddress());
            map.put("time", offer.getTime());
            map.put("click", String.valueOf(offer.getClick()));
            jedis.hmset(offerId, map);

            return offer;
        }else{
            Offer offer = null;
            map = (Map<String, String>) jedis.hmget(offerId);
            int click = Integer.parseInt(map.get("click")) + 1;
            jedis.hset(offerId, "click", String.valueOf(click));

            offer.setUserId(Integer.parseInt(map.get("userId")));
            offer.setOfferId(Integer.parseInt(map.get("offerId")));
            offer.setCertification(map.get("certification"));
            offer.setSex(map.get("sex"));
            offer.setFee(map.get("fee"));
            offer.setClaim(map.get("claim"));
            offer.setAddress(map.get("address"));
            offer.setTime(map.get("time"));
            offer.setClick(click);

            offerDao.updateClick(offer);

            return offer;
        }
    }
}
