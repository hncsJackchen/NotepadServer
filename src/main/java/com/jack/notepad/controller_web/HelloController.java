package com.jack.notepad.controller_web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/26.
 * 网站首页
 */
@Controller
@RequestMapping("/web")
public class HelloController {

    //该类运行时会去application.yml文件中查找对应的值并赋值
    @Value("${Author}")
    private String author;

    @Value("${Description}")
    private String description;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        //name-模板中使用这个名字来读取对应的值，userName-该类中的变量名
        map.addAttribute("author", author);
        map.addAttribute("description", description);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "index";
    }
}
