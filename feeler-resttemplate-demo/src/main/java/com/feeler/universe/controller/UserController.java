package com.feeler.universe.controller;

import com.feeler.universe.entity.UserEntity;
import com.feeler.universe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wanglei1
 * @Date: 2018/09/15 0:22
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getAll")
    public List<UserEntity> getUser() {
        List<UserEntity> list = userService.getAll();
        return list;
    }

    @RequestMapping("get/{id}")
    public UserEntity getById(@PathVariable(name = "id") String id) {

        return userService.getById(id);
    }

    @RequestMapping(value = "save")
    public String save(UserEntity userEntity) {

        return "保存成功";
    }

    @RequestMapping(value = "saveByType/{type}")
    public String saveByType(UserEntity userEntity, @PathVariable("type")String type) {

        return "保存成功,type="+type;
    }
}
