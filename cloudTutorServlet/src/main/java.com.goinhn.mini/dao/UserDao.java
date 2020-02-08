package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);

    void saveUser(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
