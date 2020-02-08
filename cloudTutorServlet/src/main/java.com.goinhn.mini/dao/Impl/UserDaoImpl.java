package dao.Impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名来查询用户信息
     *
     * @param username 用户名
     * @return user 用户信息
     */
    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     */
    @Override
    public void saveUser(User user) {
        try {
            String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email, type, status, code) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(), user.getType(), user.getStatus(), user.getCode());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据激活码来查询用户信息
     *
     * @param code 激活码
     * @return user 用户信息
     */
    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    @Override
    public void updateStatus(User user) {
        try {
            String sql = "update tab_user set status = ? where userId = ?";
            template.update(sql, user.getStatus(), user.getUserId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据账号和密码来查询用户信息
     *
     * @param username 账号
     * @param password 密码
     * @return user 用户信息
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
