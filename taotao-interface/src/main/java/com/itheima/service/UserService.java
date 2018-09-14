package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.pojo.User;

/*
 *  @项目名：  taotao-parent 
 *  @包名：    com.itheima.service
 *  @文件名:   UserService
 *  @创建者:   Administrator
 *  @创建时间:  2018/9/11 21:23
 *  @描述：    TODO
 */
public interface UserService {
    void save();

    User selectOne(long id);

    PageInfo<User> findByPage(int currentPage,int pageSize);
}
