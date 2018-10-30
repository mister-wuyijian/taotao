package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/*
 *  @项目名：  taotao-parent 
 *  @包名：    com.itheima.service.impl
 *  @文件名:   UserServiceImpl
 *  @创建者:   Administrator
 *  @创建时间:  2018/10/26 15:35
 *  @描述：    TODO
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean userCheck(String param, int type) {
        User user=new User();
        switch (type){
            case 1:
                user.setUsername(param);
                break;
            case 2:
                user.setPhone(param);
                break;
            case 3:
                user.setEmail(param);
                break;
            default:
                    user.setUsername(param);
                    break;
        }
        List<User> list=userMapper.select(user);
        System.out.println(list.size());
        return list.size()<=0;
    }

    @Override
    public String selectUser(String ticket) {

        String key = "iit_"+ticket;
        return redisTemplate.opsForValue().get(key);
    }
}
