package com.project1.service;

import com.project1.dataobject.RolepermitDO;

import java.util.Set;

public interface PermitService {

    void addPermitById(String username,String rolename,  Set<String> permits);
}
