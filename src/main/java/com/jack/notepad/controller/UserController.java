package com.jack.notepad.controller;

import com.alibaba.fastjson.JSON;
import com.jack.notepad.bean.User;
import com.jack.notepad.dao.UserDao;
import com.jack.notepad.response.Response;
import com.jack.notepad.service.UserService;
import com.jack.notepad.utils.Log;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by Administrator on 2016/11/19.
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册
     *
     * @param userName 用户名[系统内唯一]
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册", httpMethod = "POST", notes = "注册一个用户")
    public String register(@RequestParam String userName,@RequestParam String password) {
        //参数是否合法
        if (userName == null || userName.equals("")) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "用户名不能为空", null));
        }
        if (password == null || password.equals("")) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "密码不能为空", null));
        }
        //参数是否符合系统要求
        User user1 = userService.queryUser(userName);
        if (user1 != null) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "用户名已经存在", null));
        }

        //生成新的用户id
        Random random = new Random();
        int uid = random.nextInt(10000);

        //返回结果
        User user = userService.insertUser(uid, userName, password);
        if (user == null) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "注册错误", null));
        }
        return JSON.toJSONString(Response.writeResult(Response.STATUS_SUCCESS, "注册成功", user));
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login")
    @ApiOperation(value = "登录", httpMethod = "POST", notes = "用户登录")
    @ResponseBody
    public String login(@RequestParam String userName,@RequestParam String password) {
        //参数是否合法
        if (userName == null || userName.equals("")) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "用户名不能为空", null));
        }
        if (password == null || password.equals("")) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "密码不能为空", null));
        }

        User user = userService.queryUser(userName, password);
        if (user == null) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "登录账号或密码错误", null));
        }
        return JSON.toJSONString(Response.writeResult(Response.STATUS_SUCCESS, "登录成功", user));
    }


}


