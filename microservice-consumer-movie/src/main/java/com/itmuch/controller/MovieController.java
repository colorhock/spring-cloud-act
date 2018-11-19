package com.itmuch.controller;


import com.itmuch.pojo.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("user.userServiceUrl")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public UserPo findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(userServiceUrl + id, UserPo.class);
    }

}
