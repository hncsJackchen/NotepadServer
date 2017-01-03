package com.jack.notepad.controller_test;

import com.jack.notepad.bean.User;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/12/30.
 * Restful风格controller
 */
@RestController
@RequestMapping(value = "/restful")
public class RestfulController {

    /**
     * http://localhost:8080/restful/test0
     *
     * @return
     */
    @ApiOperation(value = "添加用户", httpMethod = "GET", response = User.class, notes = "测试Restful接口，传递一个参数")
    @RequestMapping(value = "/test0",method = RequestMethod.GET)
    public User test0() {
        User user = new User();
        user.setUid(0);
        user.setUserName("请加参数");
        user.setPassword("restful style,无参数接口");
        return user;
    }

    /**
     * http://localhost:8080/restful/test0
     *
     * @param username
     * @return
     */
    @ApiOperation(value = "查询指定用户", httpMethod = "GET", response = User.class, notes = "测试Restful接口，传递一个参数")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User test1(@PathVariable String username) {
        User user = new User();
        user.setUid(0);
        user.setUserName(username);
        user.setPassword("restful style,1无参数接口");
        return user;
    }


}
