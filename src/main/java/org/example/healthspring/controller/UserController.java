package org.example.healthspring.controller;


import org.example.healthspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/userCheck")
    @ResponseBody
    public Map<Object, Object> userCheck(@RequestBody Map<String, Object> params) {
        return userService.userCheck(params);
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public Map<Object, Object> userLogin(@RequestBody Map<String, Object> params) {
        return userService.userLogin(params);
    }

    @PostMapping("/teacherRegister")
    @ResponseBody
    public Map<Object, Object> teacherRegister(@RequestBody Map<String, Object> params) {
        return userService.teacherRegister(params);
    }
}
