package com.jack.notepad.inter;

import com.jack.notepad.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface IUser {
    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public User selectUserByID(int id);

    public User selectUser(String userName);

    public User selectUser2(User user);

    /**
     * 查询用户列表
     * @param userName
     * @return
     */
    public List<User> selectUsers(String userName);

    /**
     * 增加用户信息
     * @param user
     */
    public void addUser(User user);

    /**
     * 更新数据
     * @param user
     */
    public void updateUser(User user);


    /**
     * 删除数据
     * @param id
     */
    public void deleteUser(int id);

}
