package com.yadu.example.demo.service.impl;

import com.yadu.example.demo.entity.User;
import com.yadu.example.demo.mapper.master.UserAMapper;
import com.yadu.example.demo.service.UserAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserAServiceImpl implements UserAService {
    @Autowired
    private UserAMapper userAMapper;

    @Override
    public User getById(int id) {
        return userAMapper.getById(id);
    }

}
