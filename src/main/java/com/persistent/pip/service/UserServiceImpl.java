package com.persistent.pip.service;

import com.persistent.pip.dao.UserDaoRepository;
import com.persistent.pip.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserDaoRepository userDao;
    @Override
    public User saveUser(User user) {
        //userdao.save();
        return userDao.save(user);
    }
}
