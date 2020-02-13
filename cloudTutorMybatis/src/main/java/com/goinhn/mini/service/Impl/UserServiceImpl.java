package com.goinhn.mini.service.Impl;

import com.goinhn.mini.dao.Impl.UserDaoImpl;
import com.goinhn.mini.dao.UserDao;
import com.goinhn.mini.domain.User;
import com.goinhn.mini.service.UserService;
import com.goinhn.mini.util.MailUtils;
import com.goinhn.mini.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户注册，发送激活邮件
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        User uTemp = userDao.findByUsername(user.getUsername());
        if (uTemp != null) {
            return false;
        }

        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        userDao.saveUser(user);

        String content = "<a href='http://localhost/mini/user/active?code=" + user.getCode() + "'>点击激活</a>";
        MailUtils.sendMail(user.getEmail(), content, "云家教激活邮件");

        return true;
    }

    /**
     * 用户账户激活
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if(user != null){
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
