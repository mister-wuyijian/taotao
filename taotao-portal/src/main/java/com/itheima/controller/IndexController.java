package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.itheima.pojo.Content;
import com.itheima.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  @项目名：  taotao-parent 
 *  @包名：    com.itheima.controller
 *  @文件名:   IndexController
 *  @创建者:   xiaomi
 *  @创建时间:  2018/9/25 13:54
 *  @描述：    TODO
 */
@Controller
public class IndexController {
    @Reference
    private ContentService contentService;

    @RequestMapping("/")
    public String index(Model model){

        int categoryId = 89;

        List<Content> list=contentService.selectByCategoryId(categoryId);
        List<Map<String,Object>> lists=new ArrayList<>();
        for(Content content:list){
            Map<String , Object> map = new HashMap<>();
            map.put("src" , content.getPic());
            map.put("width",670);
            map.put("height" , 240);
            map.put("href",content.getUrl());

            lists.add(map);
        }

        String json=new Gson().toJson(lists);
        model.addAttribute("list",json);

        return "index";
    }
}
