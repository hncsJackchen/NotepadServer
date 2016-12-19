package com.jack.notepad.db;


import com.jack.notepad.bean.User;
import com.jack.notepad.inter.IUser;
import com.jack.notepad.utils.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/19.
 * s数据库帮助类
 */
//@Component
public class DbHelper {
    private static final String name = "com.mysql.jdbc.Driver";

//    private static final String url = "jdbc:mysql://23.83.233.171/notepad";
//    private static final String userName = "root";
//    private static final String password = "chenjie";

    private static final String url = "jdbc:mysql://localhost/notepad";
    private static final String userName = "root";
    private static final String password = "hncschen";

    private static Connection conn = null;

    /**
     * 连接数据库
     */
    static {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, userName, password);//获取连接
            System.out.println("jdbc 连接数据库成功");
        } catch (Exception e) {
            System.err.println("jdbc 连接数据库异常：" + e.getCause());
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库
     */
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入用户
     *
     * @param userName
     * @param password
     * @return
     */
    public User insert(int uid, String userName, String password) {
        String sql = "INSERT INTO user(u_id,u_name,u_password) VALUES (" + uid + ",'" + userName + "', '" + password + "');";
        System.out.println("insert--sql:" + sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句
            int i = pst.executeUpdate(sql);
            pst.close();
            User user = new User();
            user.setUid(uid);
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询
     *
     * @param userName
     * @return
     */
    public User query(String userName) {
        String sql = "SELECT * FROM user WHERE u_name='" + userName + "'";
        System.out.println("query--sql:" + sql);
        User user = querySql(sql);
        return user;
    }

    /**
     * 查询
     *
     * @param userName
     * @return
     */
    public User query(String userName, String password) {
        String sql = "SELECT * FROM user WHERE u_name='" + userName + "' and u_password='" + password + "'";
        System.out.println("query--sql:" + sql);
        User user = querySql(sql);
        return user;
    }

    private User querySql(String sql) {
        User user = new User();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句
            ResultSet reset = pst.executeQuery(sql);
            while (reset.next()) {
                int u_id = reset.getInt(2);
                String u_name = reset.getString(3);
                String u_password = reset.getString(4);

                user.setUid(u_id);
                user.setUserName(u_name);
                user.setPassword(u_password);
                return user;
            }//显示数据
            reset.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
