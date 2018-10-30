package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/page/{pageName}")
    public String page(@PathVariable String pageName){
        return pageName;
    }

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("要获取首页的广告数据了~");
        int categoryId = 89;
        String json=contentService.selectByCategoryId(categoryId);

        model.addAttribute("list",json);
        return "index";

    }

}
