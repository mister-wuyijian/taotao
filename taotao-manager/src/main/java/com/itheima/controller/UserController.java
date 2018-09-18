package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @项目名：  taotao-parent 
 *  @包名：    com.itheima.controller
 *  @文件名:   UserController
 *  @创建者:   Administrator
 *  @创建时间:  2018/9/11 21:14
 *  @描述：    TODO
 */

//加一行注释
@RestController
public class UserController {

    //@Reference
    private UserService userService;

    @RequestMapping("save")
   public String save(){
        userService.save();
        System.out.println("调用了UserController的方法!");
        return "save -sucessful~";
   }
    @RequestMapping("selectOne")
    public User selectOne(){
       return userService.selectOne(7);
    }
    @RequestMapping("findByPage")
    public PageInfo<User> findByPage(int currentPage, int pageSize){
        return userService.findByPage(currentPage,pageSize);
    }
}
