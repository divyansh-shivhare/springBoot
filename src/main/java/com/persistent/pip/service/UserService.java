package com.persistent.pip.service;

import com.persistent.pip.model.User;
import org.springframework.stereotype.Service;


public interface UserService {

    public User saveUser(User user);
}
