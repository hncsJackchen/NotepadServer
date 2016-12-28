package com.jack.notepad;

import com.jack.notepad.quartz.QuartzManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2016/11/19.
 * 启动约束
 */
@SpringBootApplication
public class Bootstrap {

    //程序入口
    public static void main(String[] agrs) {
        //主程序
        SpringApplication.run(Bootstrap.class, agrs);

        //启动定时任务
        QuartzManager.start();

    }


}
