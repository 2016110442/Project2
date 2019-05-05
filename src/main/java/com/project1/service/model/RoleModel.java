package com.project1.service.model;


import javax.management.relation.Role;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RoleModel implements Serializable {

    private Integer roleId;
    private String roleName;

    private Set<UserModel> userModels = new HashSet<>();

    private Set<PermitModel> permitModels = new HashSet<>();

    public RoleModel(Integer roleId,String roleName){
        this.roleId = roleId;
        this.roleName = roleName;

    }
    public RoleModel(){
        super();
    }

    public Set<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(Set<UserModel> userModels) {
        this.userModels = userModels;
    }

    public Set<PermitModel> getPermitModels() {
        return permitModels;
    }

    public void setPermitModels(Set<PermitModel> permitModels) {
        this.permitModels = permitModels;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
