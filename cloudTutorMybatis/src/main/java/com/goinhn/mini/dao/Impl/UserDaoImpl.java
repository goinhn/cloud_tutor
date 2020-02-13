package com.goinhn.mini.dao.Impl;

import com.goinhn.mini.dao.UserDao;
import com.goinhn.mini.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.goinhn.mini.dao.UserDao");
        session.close();
        return users;
    }

    @Override
    public User findByUserId(Integer userId) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.goinhn.mini.dao.UserDao", userId);
        session.close();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.goinhn.mini.dao.UserDao", username);
        session.close();
        return user;
    }

    @Override
    public User findByUsernameAndPassword(HashMap hashMap) {
        SqlSession session = factory.openSession();
        User user = (User) session.selectList("com.goinhn.mini.dao.UserDao", hashMap);
        session.close();
        return user;
    }

    @Override
    public User findByCode(String code) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.goinhn.mini.dao.UserDao", code);
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.goinhn.mini.dao.UserDao", name);
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession session = factory.openSession();
        int one = session.selectOne("com.goinhn.mini.dao.UserDao");
        session.close();
        return one;
    }

    @Override
    public int saveUser(User user) {
        SqlSession session = factory.openSession();
        int result = session.insert("com.goinhn.mini.dao.UserDao", user);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public int updateUser(User user) {
        SqlSession session = factory.openSession();
        int result = session.update("com.goinhn.mini.dao.UserDao", user);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public int updateStatus(User user) {
        SqlSession session = factory.openSession();
        int result = session.update("com.goinhn.mini.dao.UserDao", user);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public int deleteUser(User user) {
        SqlSession session = factory.openSession();
        int result = session.delete("com.goinhn.mini.dao.UserDao", user);
        session.commit();
        session.close();
        return result;
    }
}
