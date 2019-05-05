package com.project1.service.impl;

import com.project1.dao.userinfoDOMapper;
import com.project1.dao.userpasswordDOMapper;
import com.project1.dataobject.userinfoDO;

import com.project1.dataobject.userpasswordDO;
import com.project1.error.BusinessException;
import com.project1.error.EmBusinessError;
import com.project1.service.UserService;
import com.project1.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project1.controller.Usercontroller.getUserModel;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  userinfoDOMapper userinfoDOMapper;

    @Autowired
    private userpasswordDOMapper userpasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //UserDo不能直接给前端
        userinfoDO userinfoDO = userinfoDOMapper.selectByPrimaryKey(id);

        if (userinfoDO == null){
            return null;
        }
        userpasswordDO userPasswordDO = userpasswordDOMapper.selectByPrimaryKey(userinfoDO.getUserId());

        return comvertFromDataObject(userinfoDO,userPasswordDO);
    }

    @Override
    public UserModel validateLogin(String tel, String pw) throws BusinessException {
        //通过用户手机获取用户信息
        userinfoDO userinfoDO = userinfoDOMapper.selectByPhone(tel);

        if(userinfoDO == null){
//            userModel.setPassword("123");
            throw new BusinessException(EmBusinessError.USER_PASSWORD_ERROR);
        }
        userpasswordDO userPasswordDO = userpasswordDOMapper.selectByPrimaryKey(userinfoDO.getUserId());
        //将核心领域模型用户对象转换为可供UI使用的viewobject对象
        UserModel userModel = comvertFromDataObject(userinfoDO,userPasswordDO);
        //比对密码是否匹配

        if (!StringUtils.equals(pw,userModel.getUserPassword())){
            throw new BusinessException(EmBusinessError.USER_PASSWORD_ERROR);
        }
        return userModel;


    }

    @Override
    public void usersignup(UserModel userModel) throws BusinessException {
        if (userModel== null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        if (userModel.getUserId() == null
                || StringUtils.isEmpty(userModel.getUserName())
                ||userModel.getGender()==null
                ||StringUtils.isEmpty(userModel.getPhone())
                ||StringUtils.isEmpty(userModel.getUserPassword())){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        userinfoDO userinfoDO = new userinfoDO();
        userinfoDO = userinfoDOMapper.selectByPhone(userModel.getPhone());
        if (userinfoDO != null){
            throw new BusinessException(EmBusinessError.USER_IS_EXIST);
        }
        userinfoDO = comvertFromModel(userModel);
        userinfoDOMapper.insertSelective(userinfoDO);

        userpasswordDO userPasswordDO = comvertPasswordFromModel(userModel);
        userpasswordDOMapper.insertSelective(userPasswordDO);

        //UserModel userModel = comvertFromDataObject(userDO,userPasswordDO);

    }


//    @Override
//    public UserModel getUserByIdandpw(String tel, String pw) {
//        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserIdandPw(tel,pw);
//        if(userPasswordDO == null){
//            return null;
//        }
//        UserDO userDO = userDOMapper.selectByPrimaryKey(userPasswordDO.getId());
//
//        return comvertFromDataObject(userDO,userPasswordDO);
//    }

    private userpasswordDO comvertPasswordFromModel(UserModel userModel){
        if (userModel==null){
            return null;
        }
        userpasswordDO userPasswordDO = new userpasswordDO();
        userPasswordDO.setUserPassword(userModel.getUserPassword());
        userPasswordDO.setUserId(userModel.getUserId());
        return userPasswordDO;
    }

    private userinfoDO comvertFromModel(UserModel userModel){
        if (userModel==null){
            return null;
        }
        userinfoDO userDO = new userinfoDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }

    private UserModel comvertFromDataObject(userinfoDO userinfoDO, userpasswordDO userPasswordDO){
        return getUserModel(userinfoDO, userPasswordDO);
    }


}




