package com.itmuch.service;

import com.itmuch.configuration.FeignLogConfiguration;
import com.itmuch.pojo.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-provider-user", configuration = FeignLogConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public UserPo findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    public UserPo getUserByPost(@RequestBody UserPo userPo);

}
