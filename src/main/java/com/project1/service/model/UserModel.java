package com.project1.service.model;

import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.*;

public class UserModel implements Serializable {

    private Integer userId;
    private String unitId;
    private String userName;
    private String gender;
    private String birthday;
    private String nation;
    private String education;
    private String politicalStatus;
    private String wordTime;
    private String endTime;
    private String workId;
    private Integer wage;
    private String zipCode;
    private String homeAddress;
    private String phone;
    private String userPassword;

    private Set<RoleModel> roleModels = new HashSet<>();

    List<PermitModel2> permit = new ArrayList<>();

//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }
//
//    Session session = new Session() {
//        @Override
//        public Serializable getId() {
//            return null;
//        }
//
//        @Override
//        public Date getStartTimestamp() {
//            return null;
//        }
//
//        @Override
//        public Date getLastAccessTime() {
//            return null;
//        }
//
//        @Override
//        public long getTimeout() throws InvalidSessionException {
//            return 0;
//        }
//
//        @Override
//        public void setTimeout(long l) throws InvalidSessionException {
//
//        }
//
//        @Override
//        public String getHost() {
//            return null;
//        }
//
//        @Override
//        public void touch() throws InvalidSessionException {
//
//        }
//
//        @Override
//        public void stop() throws InvalidSessionException {
//
//        }
//
//        @Override
//        public Collection<Object> getAttributeKeys() throws InvalidSessionException {
//            return null;
//        }
//
//        @Override
//        public Object getAttribute(Object o) throws InvalidSessionException {
//            return null;
//        }
//
//        @Override
//        public void setAttribute(Object o, Object o1) throws InvalidSessionException {
//
//        }
//
//        @Override
//        public Object removeAttribute(Object o) throws InvalidSessionException {
//            return null;
//        }
//    };

    public List<PermitModel2> getPermit() {
        return permit;
    }

    public void setPermit(List<PermitModel2> permit) {
        this.permit = permit;
    }

    public Set<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(Set<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getWordTime() {
        return wordTime;
    }

    public void setWordTime(String wordTime) {
        this.wordTime = wordTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
