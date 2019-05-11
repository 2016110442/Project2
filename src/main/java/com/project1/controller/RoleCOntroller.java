package com.project1.controller;

import com.project1.dao.UserroleDOMapper;
import com.project1.dataobject.UserroleDO;
import com.project1.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("role")
@RequestMapping("/role")
public class RoleCOntroller extends BaseController {

    @Autowired
    private UserroleDOMapper userroleDOMapper;

    @Autowired
    private UserroleDO userroleDO;




    @RequestMapping("/addrole")
    @ResponseBody
    public CommonReturnType addrole(@RequestParam(name = "name")String name,
                                    @RequestParam(name = "info")String info
                                    ){

        userroleDOMapper.insertSelective();

    }


}
