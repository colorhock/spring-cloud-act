package com.itmuch.controller;

import com.itmuch.pojo.UserPo;
import com.itmuch.service.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public UserPo findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }


    @GetMapping("/getUserByPost/{id}")
    public UserPo getUserByPost(@PathVariable Long id) {
        UserPo userPo = new UserPo();
        userPo.setId(id);
        return userFeignClient.getUserByPost(userPo);
    }

}
