package com.jack.notepad.controller_test;


import com.jack.notepad.utils.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/12/17.
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    /**
     * http://localhost:8080/json/test0
     */
    @RequestMapping(value = "/test0", method = RequestMethod.GET)
    @ResponseBody
    public String test0() {
        return "json style,无参数接口";
    }

    /**
     *  http://localhost:8080/json/test1?param=jack
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(@RequestParam(value = "param",required = false,defaultValue = "no") String param) {
        return "json style,1参数接口,param=" + param;
    }


}
