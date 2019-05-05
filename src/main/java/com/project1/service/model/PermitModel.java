package com.project1.service.model;

import java.util.HashSet;
import java.util.Set;

public class PermitModel {

    private Integer permitId;

    private String permitName;

    private String permitInfo;

    public String getPermitInfo() {
        return permitInfo;
    }

    public void setPermitInfo(String permitInfo) {
        this.permitInfo = permitInfo;
    }

    private Set<RoleModel> roleModels = new HashSet<>();


    public PermitModel(Integer permitId,String permitName){
        this.permitId = permitId;
        this.permitName = permitName;
    }

    public PermitModel(){
        super();
    }

    public Integer getPermitId() {
        return permitId;
    }

    public void setPermitId(Integer permitId) {
        this.permitId = permitId;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public Set<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(Set<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }
}
