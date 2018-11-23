package com.itmuch.controller;

import com.itmuch.dao.dao.UserRepository;
import com.itmuch.dao.entity.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public UserPo findById(@PathVariable Long id) {
        UserPo userPoForSel = new UserPo();
        userPoForSel.setId(id);
        Example<UserPo> userPoExample =  Example.of(userPoForSel);
        Optional<UserPo> findOne = userRepository.findOne(userPoExample);
        return  findOne.isPresent() == true ? findOne.get() : null;
    }

    @PostMapping("/getUserByPost")
    public UserPo getUserByPost(@RequestBody UserPo userPo) {
        Example<UserPo> userPoExample =  Example.of(userPo);
        Optional<UserPo> findOne = userRepository.findOne(userPoExample);
        return  findOne.isPresent() == true ? findOne.get() : null;
    }

}
