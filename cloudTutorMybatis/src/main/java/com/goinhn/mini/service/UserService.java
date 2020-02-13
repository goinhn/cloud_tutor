package com.goinhn.mini.service;

import com.goinhn.mini.domain.User;

public interface UserService {
    boolean register(User user);

    boolean active(String code);

    User login(User user);
}
