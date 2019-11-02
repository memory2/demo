package com.yadu.example.demo.service;

import com.yadu.example.demo.entity.User;

import java.util.List;

public interface UserService {

     User getById(int id);

     List<User> getUsers();
}

