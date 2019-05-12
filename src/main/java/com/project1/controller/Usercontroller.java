package com.project1.controller;

import com.project1.controller.viewobject.UserVO;
import com.project1.dao.*;

import com.project1.dataobject.*;
import com.project1.error.BusinessException;
import com.project1.error.EmBusinessError;
import com.project1.response.CommonReturnType;
import com.project1.service.UserService;
import com.project1.service.model.PermitModel2;
import com.project1.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller("user")
@RequestMapping("/user")
//@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class Usercontroller extends BaseController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserinfoDO UserinfoDO;
    @Autowired
    private RolepermitDOMapper rolepermitDOMapper;

    @Autowired
    private UserinfoDOMapper userinfoDOMapper;

    @Autowired
    private UserpasswordDOMapper userpasswordDOMapper;

    @Autowired
    private UserroleinfoDOMapper userroleinfoDOMapper;

    @Autowired
    private UserpermitDOMapper userpermitDOMapper;

    @Autowired
    private UserresumeDOMapper userresumeDOMapper;

    @Autowired
    private UsertypeworkDOMapper usertypeworkDOMapper;

    @Autowired
    private UserunitDOMapper userunitDOMapper;


//
//    @Autowired
//    private UserpasswordDO UserpasswordDO;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //y用户获取otp短信接口
    @RequestMapping("/getotp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone")String telphone){
        //需要按照一定规则生成OTP验证码
        Random random = new Random();
        random.nextInt(99999);
        int randomInt = random.nextInt(99999);
        randomInt +=10000;
        String otpCode = String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联,使用httpsession的方式
        httpServletRequest.getSession().setAttribute(telphone,otpCode);


        System.out.println("telphone = " + telphone + "&otpCode = " + otpCode);
        //
        return CommonReturnType.create(null);

    }




    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
//            userModel.setPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        //将核心领域模型用户对象转换为可供UI使用的viewobject对象
        //UserVO userVO = convertFromModel(userModel);

        //返回通用对象
        Integer unitid = Integer.valueOf(userModel.getUnitId()).intValue();
        Integer typeWorkid = Integer.valueOf(userModel.getWorkId()).intValue();
        userModel.setUnitId(userunitDOMapper.selectByPrimaryKey(unitid).getUnit());
        userModel.setWorkId(usertypeworkDOMapper.selectByPrimaryKey(typeWorkid).getWord());

        return CommonReturnType.create(userModel);

//        return userModel;
    }

    @RequestMapping("/getresume")
    @ResponseBody
    public CommonReturnType getUserresumeByid(@RequestParam(name = "user_id")Integer id) throws BusinessException {
        //UserModel userModel = userService.getUserById(id);
        List<UserresumeDO> UserresumeDOS = userresumeDOMapper.selectResumeById(id);
        if(UserresumeDOS == null){
//            userModel.setPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        //将核心领域模型用户对象转换为可供UI使用的viewobject对象
        //UserVO userVO = convertFromModel(userModel);

        //返回通用对象s
        return CommonReturnType.create(UserresumeDOS);

//        return userModel;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "tel")String tel,
                                  @RequestParam(name = "pw")String pw) throws BusinessException{
        if (StringUtils.isEmpty(tel)|| StringUtils.isEmpty(pw)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        UserModel userModel = userService.validateLogin(tel,pw);
        if (!StringUtils.equals(pw,userModel.getUserPassword())){
            throw new BusinessException(EmBusinessError.USER_PASSWORD_ERROR);
        }
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);

        UserroleinfoDO userroleinfoDO = userroleinfoDOMapper.selectByPrimaryKey(userModel.getUserId());

        Set<RolepermitDO> RolepermitDOS = rolepermitDOMapper.selectByRoldId(userroleinfoDO.getRoleId());
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        System.out.println(session.getAttributeKeys());
//        Map<String,String> mappermit = new HashMap<>();
        List<PermitModel2> strings = new ArrayList<>();
//        for (RolepermitDO RolepermitDO : RolepermitDOS) {
//            strings.add(UserpermitDOMapper.selectByPrimaryKey(Integer.valueOf(RolepermitDO.getPermitId()).intValue()).getPermitName());
//        }
//        userModel.setStrings(strings);
        for (RolepermitDO rolepermitDO : RolepermitDOS) {
            PermitModel2 permitModel = new PermitModel2();
            permitModel.setPermitName(userpermitDOMapper.selectByPrimaryKey(Integer.valueOf(rolepermitDO.getPermitId()).intValue()).getPermitName());
            permitModel.setPermitInfo(userpermitDOMapper.selectByPrimaryKey(Integer.valueOf(rolepermitDO.getPermitId()).intValue()).getPermitInfo());
            strings.add(permitModel);
        }
//        userModel.setSession(session);
        userModel.setPermit(strings);
        return CommonReturnType.create(userModel);

        //返回通用对象
    }

    @RequestMapping(value = "/updatepassword",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType update(@RequestBody UserpasswordDO userpasswordDO){
        Integer i = userpasswordDOMapper.updateByPrimaryKeySelective(userpasswordDO);
        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/updateuserinfo",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType update(@RequestBody UserinfoDO userinfoDO){
        Integer i = userinfoDOMapper.updateByPrimaryKeySelective(userinfoDO);
        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/addresume",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType add(@RequestBody UserresumeDO userresumeDO){
        Integer i = userresumeDOMapper.updateByPrimaryKeySelective(userresumeDO);
        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/deletepassword",method = {RequestMethod.DELETE})
    @ResponseBody
    public CommonReturnType deletepassword(@RequestBody UserpasswordDO userpasswordDO){
        Integer i = userpasswordDOMapper.deleteByPrimaryKey(userpasswordDO.getUserId());
        return CommonReturnType.create(i);
    }

    @RequestMapping(value = "/updatepassword",method = {RequestMethod.PUT})
    @ResponseBody
    public CommonReturnType updatepassword(@RequestBody UserpasswordDO userpasswordDO){
        Integer i = userpasswordDOMapper.updateByPrimaryKeySelective(userpasswordDO);
        return CommonReturnType.create(i);
    }


    @RequestMapping(value = "/deleteuserinfo",method = {RequestMethod.DELETE})
    @ResponseBody
    public CommonReturnType deleteuserinfo(@RequestBody UserinfoDO userinfoDO){
        Integer i = userinfoDOMapper.deleteByPrimaryKey(userinfoDO.getUserId());
        return CommonReturnType.create(i);
    }









    //@RequiresPermissions(value = "user:add")
    @RequestMapping(value = "/insertuserinfo",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "userId")Integer userId,
                                     @RequestParam(name = "userName")String userName,
                                     @RequestParam(name = "phone")String phone,
                                     @RequestParam(name = "userPassword")String userPassword
                                     ) throws BusinessException {

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setUnitId("***");
        userModel.setUserName(userName);
        userModel.setGender("0");
        userModel.setBirthday("***");
        userModel.setNation("***");
        userModel.setEducation("***");
        userModel.setPoliticalStatus("***");
        userModel.setWordTime("***");
        userModel.setEndTime("***");
        userModel.setWorkId("***");
        userModel.setWage(0);
        userModel.setZipCode("***");
        userModel.setHomeAddress("***");
        userModel.setPhone(phone);
        userModel.setUserPassword(userPassword);
        userService.usersignup(userModel);

        return CommonReturnType.create(null);
    }


    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }


    private UserModel comvertFromDataObject(UserinfoDO userinfoDO, UserpasswordDO userpasswordDO){
        return getUserModel(userinfoDO, userpasswordDO);
    }

    public static UserModel getUserModel(UserinfoDO userinfoDO, UserpasswordDO userpasswordDO) {
        if (userinfoDO==null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userinfoDO,userModel);
        if (userpasswordDO!=null){
            userModel.setUserPassword(userpasswordDO.getUserPassword());
        }
        return userModel;
    }
    @RequiresPermissions(value = "user:add")
    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequiresPermissions(value = "user:update")
    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequiresPermissions(value = "user:select")
    @RequestMapping("/find")
    public String find(){
        return "/user/find";
    }


    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }


    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }


    @RequestMapping("/testlogin")
    public String testlogin(String name, String password, Model model){
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);


        try {
            subject.login(token);
            subject.getPrincipal();
            //Session session = subject.getSession();
            //System.out.println(session);
            return "redirect:/user/test";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
        }   return "login";


    }



    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name","wyy");
        return "test";
    }
}
