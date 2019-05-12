package com.project1.controller;

import com.project1.dao.UserroleDOMapper;
import com.project1.dataobject.UserroleDO;
import com.project1.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("role")
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private UserroleDOMapper userroleDOMapper;

    @RequestMapping(value = "/addrole",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType addrole(@RequestParam(name = "name")String name,
                                    @RequestParam(name = "info")String info
                                    ){
        UserroleDO userroleDO = new UserroleDO();
        userroleDO.setRoleName(name);
        userroleDO.setRoleInfo(info);
        userroleDOMapper.insertSelective(userroleDO);
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
