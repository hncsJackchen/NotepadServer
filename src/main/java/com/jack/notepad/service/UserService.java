package com.jack.notepad.service;


import com.jack.notepad.bean.User;
import com.jack.notepad.dao.UserDao;
import com.jack.notepad.db.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/19.
 * 用户服务类
 */
@Service
public class UserService {
    //自动初始化一个实例
    @Autowired
    UserDao userDao;

//    @Autowired
//    DbHelper dbHelper;

    public User queryUser(String userName) {
//        User user = dbHelper.query(userName);
        User user = userDao.query(userName);
        return user;
    }

    /**
     * 插入用户
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return
     */
    public User insertUser(int uid, String userName, String password) {
//        User user = dbHelper.insert(uid, userName, password);
        User user = userDao.insert(uid, userName, password);
        return user;
    }

    /**
     * 查询用户
     *
     * @param userName
     * @return
     */
    public User queryUser(String userName, String password) {
//        User user = dbHelper.query(userName, password);
        User user = userDao.query(userName, password);
        return user;
    }


}
