package com.project1.controller;

import com.project1.dao.RolepermitDOMapper;
import com.project1.dao.UserpermitDOMapper;
import com.project1.response.CommonReturnType;
import com.project1.service.PermitService;
import com.project1.service.model.Addpermit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller("permit")
@RequestMapping("/permit")
public class PermitController {

    @Autowired
    private UserpermitDOMapper userpermitDOMapper;

    @Autowired
    private RolepermitDOMapper rolepermitDOMapper;

    @Autowired
    private PermitService permitService;

    @RequestMapping(value = "/insertrolepermit",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType insertrolepermit(@RequestBody Addpermit addpermit){
        permitService.addPermitById(addpermit.getUserName(), addpermit.getRoleName(), addpermit.getPermits());
        return CommonReturnType.create(null);
    }



}
