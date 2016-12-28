package com.jack.notepad.quartz.job;

import com.jack.notepad.bean.User;
import com.jack.notepad.db.MyBatisHelper;
import com.jack.notepad.inter.IUser;
import com.jack.notepad.utils.Log;
import org.apache.ibatis.session.SqlSession;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Connection;

/**
 * Created by Administrator on 2016/12/28.
 * 数据库连接的任务
 */
public class DBConnJob implements Job {
    private static final String TAG = "DBConnJob ";

    public DBConnJob() {

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Log.i(TAG + System.currentTimeMillis() + ":执行数据库连接的任务 ");
        SqlSession session = MyBatisHelper.getSession();
        IUser mapper = session.getMapper(IUser.class);
        User user = mapper.selectUser("admin");
        session.close();
        if (user == null) {
            Log.i(TAG + "admin 用户不存在");
        } else {
            Log.i(TAG + "admin 用户存在：" + user);
        }
    }
}
