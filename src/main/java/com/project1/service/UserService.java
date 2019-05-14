package com.project1.service;

import com.project1.error.BusinessException;
import com.project1.service.model.UserModel;

import java.util.BitSet;

public interface UserService {
    UserModel getUserById(Integer id);
    UserModel validateLogin(String tel,String pw) throws BusinessException;
    Boolean usersignup(UserModel userModel) throws  BusinessException;
    //UserModel findPermitByid(Integer id);
}
