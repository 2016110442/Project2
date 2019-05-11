package com.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("role")
@RequestMapping("/role")
public class RoleCOntroller extends BaseController {

    @Autowired
    private UserroleDOMapper userroleDOMapper;

    @Autowired
    private UserroleDO userroleDO;




//    @RequestMapping("/addrole")
//    @ResponseBody
//    public CommonReturnType addrole(@RequestBody UserroleDO userroleDO ){
//
//        userroleDOMapper.insertSelective();
//
//    }


}
