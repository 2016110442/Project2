package com.project1.controller;

import com.project1.dao.UserinfoDOMapper;
import com.project1.dao.UserroleDOMapper;
import com.project1.dao.UserroleinfoDOMapper;
import com.project1.dataobject.UserinfoDO;
import com.project1.dataobject.UserroleDO;
import com.project1.dataobject.UserroleinfoDO;
import com.project1.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("role")
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private UserroleDOMapper userroleDOMapper;

    @Autowired
    private UserroleinfoDOMapper userroleinfoDOMapper;

    @Autowired
    private UserinfoDOMapper userinfoDOMapper;

    @RequestMapping(value = "/insertrole",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType insertrole(@RequestParam(name = "rolename")String name,
                                       @RequestParam(name = "roleinfo")String info
    ){
        UserroleDO userroleDO = new UserroleDO();
        userroleDO.setRoleName(name);
        userroleDO.setRoleInfo(info);
        userroleDOMapper.insertSelective(userroleDO);
        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/insertuserrole",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType insertuserrole(@RequestParam(name = "username")String username,
                                           @RequestParam(name = "rolename")String rolename
    ){

        UserinfoDO userinfoDO = userinfoDOMapper.selectByUserName(username);

        UserroleDO userroleDO = userroleDOMapper.selectByRoleName(rolename);

        UserroleinfoDO userroleinfoDO = new UserroleinfoDO();

        userroleinfoDO.setUserId(userinfoDO.getUserId());
        userroleinfoDO.setRoleId(userroleDO.getRoleId().toString());
        userroleinfoDOMapper.insertSelective(userroleinfoDO);

        return CommonReturnType.create(null);
    }


    @RequestMapping(value = "/deleterole",method = {RequestMethod.DELETE},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType deleterole(@RequestParam(name = "id")Integer id
    ){
        userroleDOMapper.deleteByPrimaryKey(id);
        return CommonReturnType.create(null);
    }



}
