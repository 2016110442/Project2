package com.project1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.project1"})
@RestController
@MapperScan("com.project1.dao")
public class App
{


//    @Autowired
//    private UserDOMapper userDOMapper;
//    @RequestMapping("/home")
//    public String home(){
//        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
//        if (userDO == null){
//            return "no sql";
//        }else {
//            return userDO.getName();
//        }
//
//    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }



}
