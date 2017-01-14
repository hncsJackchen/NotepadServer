package com.jack.notepad.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/14.
 * 网站主页Controller
 */
@Controller
@RequestMapping("/notepad")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value(value = "${Author}")
    private String author;

    @Value(value = "${Description}")
    private String description;

    @Value(value = "${IP}")
    private String ip;

    @Value(value = "${server.port}")
    private String port;

    @RequestMapping(value = "/index")
    @ApiOperation(value = "进入主页", httpMethod = "GET", response = String.class, hidden = true)
    public String test(Model model) {
        logger.info("访问主页-> " + ip + ":" + port);
        model.addAttribute("author", author);
        model.addAttribute("description", description);
        model.addAttribute("ip", ip);
        model.addAttribute("port", port);
        return "index";
    }

}
