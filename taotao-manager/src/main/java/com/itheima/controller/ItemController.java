package com.itheima.controller;

/*
 *  @项目名：  taotao-parent 
 *  @包名：    com.itheima.controller
 *  @文件名:   ItemController
 *  @创建者:   Administrator
 *  @创建时间:  2018/9/19 9:45
 *  @描述：    TODO
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.Item;
import com.itheima.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Reference
    private ItemService itemService;


    @RequestMapping("/rest/item")
    @ResponseBody
    public  String addItem(Item item,String desc){
        int result=itemService.addItem(item,desc);
        System.out.println("result=" + result);
        return  "succeess";
    }
}
