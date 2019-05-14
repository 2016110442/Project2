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
    private UserunitDOMapper userunitDOMapper;


    @RequestMapping(value = "/inserttypework",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType inserttypework(@RequestBody UsertypeworkDO usertypeworkDO
    ){
        int i = usertypeworkDOMapper.insertSelective(usertypeworkDO);

        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/deletetypework",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deletetypework(@RequestBody UsertypeworkDO usertypeworkDO
    ){
        int i = usertypeworkDOMapper.deleteByPrimaryKey(usertypeworkDO.getWordId());

        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/insertunit",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType insertunit(@RequestBody UserunitDO userunitDO
    ){

        int i = userunitDOMapper.insertSelective(userunitDO);
        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/deleteunit",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteunit(@RequestBody UserunitDO userunitDO
    ){

        int i = userunitDOMapper.deleteByPrimaryKey(userunitDO.getUnitId());
        return CommonReturnType.create(i);
    }



}
