package com.jack.notepad.db;

import com.jack.notepad.utils.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MyBatisHelper {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "myBatis_config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            Log.i("mybatis 连接数据库成功");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("mybatis 连接数据库异常：" + e.getCause());
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * 获取数据库Session
     *
     * @return
     */
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }


}
