package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.healthspring.entity.UserEntity;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    UserEntity selectById(int id);

    @Select("select * from user")
    ArrayList<UserEntity> selectAll();

    @Select("select * from user where role=#{role}")
    ArrayList<UserEntity> selectByRole(String role);

    @Insert("insert into user(id, name, password, gender, intro, role, status, classroom) values (#{id}, #{name}, #{password}, #{gender}, #{intro}, #{role}, #{status}, #{classroom})")
    void insert(UserEntity user);
}
