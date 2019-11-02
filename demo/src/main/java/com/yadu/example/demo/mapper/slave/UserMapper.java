package com.yadu.example.demo.mapper.slave;

import com.yadu.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 插入user表数据
     * @param name
     * @return
     */
    boolean insert(String name);

    /**
     * 查询用户列表
     * @return
     */
    List<User> getUsers();

    /**
     * 更新用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 删除所有用户
     * @return
     */
    boolean deleteAllUsers();


}

