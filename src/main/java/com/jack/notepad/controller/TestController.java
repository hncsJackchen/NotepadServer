package com.jack.notepad.controller;

import com.jack.notepad.utils.Log;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/12/17.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * //@RequestParam的用法
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/param1", method = RequestMethod.GET)
    public String params1(@RequestParam("name") String userName) {
        String info = "name=" + userName;
        Log.i(info);
        return info;
    }

    /**
     * //@PathVariable的用法
     * @param userName
     * @return
     */
    @RequestMapping(value = "/param2/{name}", method = RequestMethod.GET)
    public String params2(@PathVariable("name") String userName) {
        String info = "name2=" + userName;
        Log.i(info);
        return info;
    }



}
