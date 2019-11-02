package com.yadu.example.demo.mapper.master;

import com.yadu.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAMapper {
    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    User getById(int id);



}

