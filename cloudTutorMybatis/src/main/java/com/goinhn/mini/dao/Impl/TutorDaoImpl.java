package com.goinhn.mini.dao.Impl;

import com.goinhn.mini.dao.TutorDao;
import com.goinhn.mini.domain.Tutor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.goinhn.mini.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class TutorDaoImpl implements TutorDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有tutor的信息
     *
     * @return List<Tutor> tutor信息
     */
    @Override
    public List<Tutor> findAll() {
        List<Tutor> tutors = null;
        try {
            String sql = "select * from tab_tutor where 1 = 1";
            tutors = template.query(sql, new BeanPropertyRowMapper<>(Tutor.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutors;
    }

    /**
     * 根据userId查找tutor信息
     *
     * @param userId
     * @return List<Tutor> tutor信息
     */
    @Override
    public List<Tutor> findByUserId(int userId) {
        List<Tutor> tutors = null;
        try {
            String sql = "select * from tab_tutor where userId = ?";
            tutors = template.query(sql, new BeanPropertyRowMapper<>(Tutor.class), userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutors;
    }

    /**
     * 根据tutorId查找tutor信息
     *
     * @param tutorId
     * @return Tutor tutor信息
     */
    @Override
    public Tutor findByTutorId(int tutorId) {
        Tutor tutor = null;
        try {
            String sql = "select * from tab_tutor where tutorId = ?";
            tutor = template.queryForObject(sql, new BeanPropertyRowMapper<>(Tutor.class), tutorId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutor;
    }

    /**
     * 更新tutor点击的次数
     *
     * @param tutor tutor信息
     */
    @Override
    public void updateClick(Tutor tutor) {
        try {
            String sql = "update tab_tutor set click = ? where tutorId = ?";
            template.update(sql, tutor.getClick(), tutor.getTutorId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据性别查找tutor信息的总数
     *
     * @param sex
     * @return
     */
    @Override
    public int findSexCount(String sex) {
        String sql = "select count(*) from tab_tutor where 1 = 1";
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
     * 根据性别对tutor信息进行分页
     *
     * @param start
     * @param pageSize
     * @param sex
     * @return
     */
    @Override
    public List<Tutor> findSexByPage(int start, int pageSize, String sex) {
        String sql = " select * from tab_tutor where 1 = 1 ";
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

        List<Tutor> tutors = null;

        try {
            tutors = template.query(sql, new BeanPropertyRowMapper<>(Tutor.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutors;
    }

    /**
     * 根据认证信息查找tutor信息的总数
     *
     * @param certification
     * @return
     */
    @Override
    public int findCertificationCount(String certification) {
        String sql = "select count(*) from tab_tutor where 1 = 1";
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
     * 根据认证信息对tutor信息进行分页
     *
     * @param start
     * @param pageSize
     * @param certification
     * @return
     */
    @Override
    public List<Tutor> findCertificationByPage(int start, int pageSize, String certification) {
        String sql = " select * from tab_tutor where 1 = 1 ";
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

        List<Tutor> tutors = null;

        try {
            tutors = template.query(sql, new BeanPropertyRowMapper<>(Tutor.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutors;
    }

    /**
     * 根据地址查找tutor信息的总数
     *
     * @param address
     * @return
     */
    @Override
    public int findAddressCount(String address) {
        String sql = "select count(*) from tab_tutor where 1 = 1";
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
     * 根据地址对tutor信息进行分页
     *
     * @param start
     * @param pageSize
     * @param address
     * @return
     */
    @Override
    public List<Tutor> findAddressByPage(int start, int pageSize, String address) {
        String sql = " select * from tab_tutor where 1 = 1 ";
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

        List<Tutor> tutors = null;

        try {
            tutors = template.query(sql, new BeanPropertyRowMapper<>(Tutor.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tutors;
    }
}
