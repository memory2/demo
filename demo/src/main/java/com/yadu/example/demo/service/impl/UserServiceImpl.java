package com.yadu.example.demo.service.impl;

import com.yadu.example.demo.entity.User;
import com.yadu.example.demo.mapper.slave.UserMapper;
import com.yadu.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
