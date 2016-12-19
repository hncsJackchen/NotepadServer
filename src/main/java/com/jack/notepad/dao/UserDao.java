package com.jack.notepad.dao;

import com.jack.notepad.bean.User;
import com.jack.notepad.db.MyBatisHelper;
import com.jack.notepad.inter.IUser;
import com.jack.notepad.utils.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
@Component
public class UserDao {
    private static final String TAG = "UserDao ";

    /**
     * 查询
     *
     * @param userName
     * @return
     */
    public User query(String userName) {
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        User user = mapper.selectUser(userName);
        session.close();
        Log.i(TAG + "query user:" + user);
        return user;
    }

    /**
     * 通过id查询用户信息
     */
    private void selectUserByID(int id) {
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        User user = mapper.selectUserByID(id);
        session.close();
        Log.i(TAG + "selectUserByID user:" + user);
    }

    /**
     * 查询
     *
     * @param userName
     * @return
     */
    public User query(String userName, String password) {
        User param = new User();
        param.setUserName(userName);
        param.setPassword(password);

        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        User user = mapper.selectUser2(param);
        session.close();
        Log.i(TAG + "query user:" + user);
        return user;
    }

    /**
     * 插入用户
     *
     * @param userName
     * @param password
     * @return
     */
    public User insert(int uid, String userName, String password) {
        User user = new User();
        user.setUid(uid);
        user.setUserName(userName);
        user.setPassword(password);

        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        mapper.addUser(user);
        session.commit();
        session.close();
        Log.i(TAG + "insert user:" + user);
        return user;
    }

    /**
     * 匹配相似信息用户
     * @param info
     */
    private void selectUsers(String info){
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        List<User> user_s = mapper.selectUsers(info);
        if (user_s != null && user_s.size() > 0) {
            for (int i = 0; i < user_s.size(); i++) {
                Log.i("i=" + i + ",user:" + user_s.get(i));
            }
        }
        session.close();
    }

    /**
     * 更新用户信息
     */
    private void updateUser(int id){
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        User user_ = mapper.selectUserByID(id);
        Log.i("updateUser user_="+user_);
        if (user_ != null) {
            user_.setUid(30);
            user_.setUserName("hah");
            user_.setPassword("aa");
            mapper.updateUser(user_);
            session.commit();
        }else {
            System.out.println("updateUser user==null");
        }
        session.close();
    }

    /**
     * 删除制定用户的信息
     */
    private void deleteUser(int id){
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        mapper.deleteUser(id);
        session.commit();
        session.close();
    }


}
