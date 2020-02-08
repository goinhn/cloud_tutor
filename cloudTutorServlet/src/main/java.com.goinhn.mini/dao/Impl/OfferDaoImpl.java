package dao.Impl;

import dao.OfferDao;
import domain.Offer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class OfferDaoImpl implements OfferDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有的offer信息
     *
     * @return List<Offer> 全体Offer信息
     */
    @Override
    public List<Offer> findAll() {
        List<Offer> offers = null;
        try {
            String sql = "select * from tab_offer where 1 = 1";
            offers = template.query(sql, new BeanPropertyRowMapper<>(Offer.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offers;
    }

    /**
     * 根据userId查找offer信息
     *
     * @param userId
     * @return List<Offer> 集合Offer信息
     */
    @Override
    public List<Offer> findByUserId(int userId) {
        List<Offer> offers = null;
        try {
            String sql = "select * from tab_offer where userId = ?";
            offers = template.query(sql, new BeanPropertyRowMapper<>(Offer.class), userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offers;
    }

    /**
     * 根据offerId查找offer信息
     *
     * @param offerId
     * @return Offer offer信息
     */
    @Override
    public Offer findByOfferId(int offerId) {
        Offer offer = null;
        try {
            String sql = "select * from tab_offer where offerId = ?";
            offer = template.queryForObject(sql, new BeanPropertyRowMapper<>(Offer.class), offerId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offer;
    }

    /**
     * 更新点击的次数
     *
     * @param offer offer信息
     */
    @Override
    public void updateClick(Offer offer) {
        try {
            String sql = "update tab_offer set click = ? where offerId = ?";
            template.update(sql, offer.getClick(), offer.getOfferId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据性别查找offer信息的总数
     *
     * @param sex
     * @return
     */
    @Override
    public int findSexCount(String sex) {
        String sql = "select count(*) from tab_offer where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (sex != null && sex.length() != 0) {
            sb.append(" and sex = ? ");
            params.add(sex);
        }

        sql = sb.toString();
        int count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * 根据性别对offer信息进行分页
     *
     * @param start
     * @param pageSize
     * @param sex
     * @return
     */
    @Override
    public List<Offer> findSexByPage(int start, int pageSize, String sex) {
        String sql = " select * from tab_offer where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (sex != null && sex.length() > 0) {
            sb.append(" and sex = ");
            params.add(sex);
        }

        sb.append(" limit ? , ? ");
        sql = sb.toString();
        params.add(start);
        params.add(pageSize);

        List<Offer> offers = null;

        try {
            offers = template.query(sql, new BeanPropertyRowMapper<>(Offer.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offers;
    }

    /**
     * 根据认证信息查找offer信息的总数
     *
     * @param certification
     * @return
     */
    @Override
    public int findCertificationCount(String certification) {
        String sql = "select count(*) from tab_offer where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (certification != null && certification.length() != 0) {
            sb.append(" and certification = ? ");
            params.add(certification);
        }

        sql = sb.toString();
        int count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * 根据认证信息对offer信息进行分页
     *
     * @param start
     * @param pageSize
     * @param certification
     * @return
     */
    @Override
    public List<Offer> findCertificationByPage(int start, int pageSize, String certification) {
        String sql = " select * from tab_offer where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (certification != null && certification.length() > 0) {
            sb.append(" and certification = ");
            params.add("%" + certification + "%");
        }

        sb.append(" limit ? , ? ");
        sql = sb.toString();
        params.add(start);
        params.add(pageSize);

        List<Offer> offers = null;

        try {
            offers = template.query(sql, new BeanPropertyRowMapper<>(Offer.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offers;
    }

    /**
     * 根据地址查找offer信息的总数
     *
     * @param address
     * @return
     */
    @Override
    public int findAddressCount(String address) {
        String sql = "select count(*) from tab_offer where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (address != null && address.length() != 0) {
            sb.append(" and address = ? ");
            params.add(address);
        }

        sql = sb.toString();

        int count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * 根据地址对offer信息进行分页
     *
     * @param start
     * @param pageSize
     * @param address
     * @return
     */
    @Override
    public List<Offer> findAddressByPage(int start, int pageSize, String address) {
        String sql = " select * from tab_offer where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (address != null && address.length() > 0) {
            sb.append(" and address = ");
            params.add("%" + address + "%");
        }

        sb.append(" limit ? , ? ");
        sql = sb.toString();
        params.add(start);
        params.add(pageSize);

        List<Offer> offers = null;

        try {
            offers = template.query(sql, new BeanPropertyRowMapper<>(Offer.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offers;
    }
}
