package org.example.healthspring.service;

import org.example.healthspring.entity.UserEntity;
import org.example.healthspring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Map<Object, Object> userCheck(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = (int) params.get("id");
        UserEntity userEntity = userMapper.selectById(id);
        if (userEntity == null) {
            response.put("email_status", 0);
        }
        else {
            response.put("email_status", 1);
        }
        return response;
    }

    public Map<Object, Object> userLogin(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = (int) params.get("id");
        String password = params.get("password").toString();
        UserEntity userEntity = userMapper.selectById(id);
        if (userEntity.getPassword().equals(password)) {
            response.put("status", 200);
            response.put("data", userEntity);
        }
        else {
            response.put("status", 400);
            response.put("msg", "账号或者密码不正确！");
        }
        return response;
    }

    public Map<Object, Object> studentRegister(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = (int) params.get("id");
        String name = params.get("name").toString();
        String password = params.get("password").toString();
        String gender = params.get("gender").toString();
        String intro = params.get("intro").toString();
        int classroom = (int) params.get("classroom");
        UserEntity userEntity = new UserEntity(id, name, password, gender, intro, "学生", "", classroom);
        try {
            userMapper.insert(userEntity);
            response.put("status", 200);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            response.put("status", 500);
        }
        return response;
    }

    public Map<Object, Object> teacherRegister(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = (int) params.get("id");
        String name = params.get("name").toString();
        String password = params.get("password").toString();
        String gender = params.get("gender").toString();
        String intro = params.get("intro").toString();
        UserEntity userEntity = new UserEntity(id, name, password, gender, intro, "老师", "在线", 0);
        try {
            userMapper.insert(userEntity);
            response.put("status", 200);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            response.put("status", 500);
        }
        return response;
    }
}
