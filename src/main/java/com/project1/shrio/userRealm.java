package com.project1.shrio;

import com.project1.dao.userinfoDOMapper;
import com.project1.dao.userpasswordDOMapper;
import com.project1.dataobject.userinfoDO;
import com.project1.dataobject.userpasswordDO;
import com.project1.dataobject.userpermitDO;
import com.project1.dataobject.userroleDO;
import com.project1.service.model.PermitModel;
import com.project1.service.model.RoleModel;
import com.project1.service.model.UserModel;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class userRealm extends AuthorizingRealm {

    @Autowired
    private userpasswordDOMapper userPasswordDOMapper;

    @Autowired
    private userinfoDOMapper userinfoDOMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        userinfoDO userinfoDO = (userinfoDO)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions= new ArrayList<>();
        Set<userroleDO> userroleDOS = userinfoDO.getUserroleDOS();
        if(userroleDOS.size()>0){
            for(userroleDO userroleDO : userroleDOS){
                Set<userpermitDO> userpermitDOS = userroleDO.getUserpermitDOS();
                if(userpermitDOS.size()>0){
                    for (userpermitDO userpermitDO : userpermitDOS){

                        permissions.add(userpermitDO.getPermitName());
                    }
                }
            }
        }


        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        //Subject subject = SecurityUtils.getSubject();
        //UserModel userModel = (UserModel)subject.getPrincipal();


        //添加资源的授权字符串
        //info.addStringPermission("add");
        info.addStringPermissions(permissions);
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
//        String name ="wyy";
//        String password = "854856";
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        userinfoDO userinfoDO = userinfoDOMapper.findByUserName(Integer.valueOf(token.getUsername()).intValue());
        userpasswordDO userPasswordDO = userPasswordDOMapper.selectByPrimaryKey(Integer.valueOf(token.getUsername()).intValue());

//        if (userPasswordDO==null){
//            return null;
//        }
 //       userinfoDO userinfoDO = userinfoDOMapper.selectByPrimaryKey(userPasswordDO.getUserId());

//        if(!token.getUsername().equals(name)){
//            return null;
//        }
//        return new SimpleAuthenticationInfo(userPasswordDO,userPasswordDO.getUserPassword(),"");

        return new SimpleAuthenticationInfo(userinfoDO,userPasswordDO.getUserPassword(),this.getClass().getName());

    }
}
