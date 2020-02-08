package service;

import domain.User;

public interface UserService {
    boolean register(User user);

    boolean active(String code);

    User login(User user);
}
