package com.goinhn.mini.dao;

import com.goinhn.mini.dao.Impl.UserDaoImpl;
import com.goinhn.mini.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private InputStream in;
    private UserDao userDao;

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destory() throws Exception {
        in.close();
    }
}
