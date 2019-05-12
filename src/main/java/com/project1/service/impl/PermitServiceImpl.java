package com.project1.service.impl;


import com.project1.dao.RolepermitDOMapper;
import com.project1.dao.UserpermitDOMapper;
import com.project1.dao.UserroleDOMapper;
import com.project1.dao.UserroleinfoDOMapper;
import com.project1.dataobject.RolepermitDO;
import com.project1.dataobject.UserpermitDO;
import com.project1.dataobject.UserroleDO;
import com.project1.dataobject.UserroleinfoDO;
import com.project1.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PermitServiceImpl implements PermitService {

    @Autowired
    private UserroleinfoDOMapper userroleinfoDOMapper;

    @Autowired
    private UserroleDOMapper userroleDOMapper;

    @Autowired
    private RolepermitDOMapper rolepermitDOMapper;

    @Autowired
    private UserpermitDOMapper userpermitDOMapper;



    @Override
    public void addPermitById(String username, String rolename, Set<String> permits) {

        String role_id = userroleDOMapper.selectByRoleName(rolename).getRoleId().toString();

        Integer i = rolepermitDOMapper.deleteByRoleId(role_id);

        for (String permit: permits){
            UserpermitDO userpermitDO = userpermitDOMapper.selectByPrtmitInfo(permit);
            RolepermitDO rolepermitDO = new RolepermitDO();
            rolepermitDO.setRoleId(role_id);
            rolepermitDO.setPermitId(userpermitDO.getPermitId().toString());

            rolepermitDO.setRightType(0);
            rolepermitDOMapper.insertSelective(rolepermitDO);
        }

    }
}
