package com.jack.notepad.service;

import com.jack.notepad.bean.User;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface IUserService {
    public User queryUser(String userName);

    public User insertUser(int uid, String userName, String password);

    public User queryUser(String userName, String password);
}
