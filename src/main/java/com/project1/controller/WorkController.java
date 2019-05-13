package com.project1.controller;

import com.project1.dao.UsertypeworkDOMapper;
import com.project1.dao.UserunitDOMapper;
import com.project1.dataobject.UserroleDO;
import com.project1.dataobject.UsertypeworkDO;
import com.project1.dataobject.UserunitDO;
import com.project1.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("work")
@RequestMapping("/work")
public class WorkController extends BaseController{

    @Autowired
    private UsertypeworkDOMapper usertypeworkDOMapper;

    @Autowired
    private UsertypeworkDO usertypeworkDO;

    @Autowired
    private UserunitDOMapper userunitDOMapper;

    @Autowired
    private UserunitDO userunitDO;

    @RequestMapping(value = "/inserttypework",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType inserttypework(@RequestBody UsertypeworkDO usertypeworkDO
    ){
        usertypeworkDOMapper.insertSelective(usertypeworkDO);

        return CommonReturnType.create(null);
    }




}
