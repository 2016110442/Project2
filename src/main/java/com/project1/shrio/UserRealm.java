package com.project1.shrio;

import com.project1.dao.UserinfoDOMapper;
import com.project1.dao.UserpasswordDOMapper;
import com.project1.dataobject.UserinfoDO;
import com.project1.dataobject.UserpasswordDO;
import com.project1.dataobject.UserpermitDO;
import com.project1.dataobject.UserroleDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserpasswordDOMapper userPasswordDOMapper;

    @Autowired
    private UserinfoDOMapper userinfoDOMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        UserinfoDO userinfoDO = (UserinfoDO)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions= new ArrayList<>();
        Set<UserroleDO> UserroleDOS = userinfoDO.getUserroleDOS();
        if(UserroleDOS.size()>0){
            for(UserroleDO userroleDO : UserroleDOS){
                Set<UserpermitDO> UserpermitDOS = userroleDO.getUserpermitDOS();
                if(UserpermitDOS.size()>0){
                    for (UserpermitDO userpermitDO : UserpermitDOS){

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
        UserinfoDO userinfoDO = userinfoDOMapper.findByUserName(Integer.valueOf(token.getUsername()).intValue());

        UserpasswordDO userPasswordDO = userPasswordDOMapper.selectByPrimaryKey(Integer.valueOf(token.getUsername()).intValue());

//        if (userPasswordDO==null){
//            return null;
//        }
 //       UserinfoDO UserinfoDO = UserinfoDOMapper.selectByPrimaryKey(userPasswordDO.getUserId());

//        if(!token.getUsername().equals(name)){
//            return null;
//        }
//        return new SimpleAuthenticationInfo(userPasswordDO,userPasswordDO.getUserPassword(),"");

        return new SimpleAuthenticationInfo(userinfoDO,userPasswordDO.getUserPassword(),this.getClass().getName());

    }
}
