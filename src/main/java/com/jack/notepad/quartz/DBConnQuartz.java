package com.jack.notepad.quartz;

import com.jack.notepad.quartz.job.DBConnJob;
import com.jack.notepad.utils.Log;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Administrator on 2016/12/28.
 * 数据库连接的定时任务
 */
public class DBConnQuartz {
    private static final long START_TIME_DELAY = TimeUnit.MINUTES.toMillis(5);//开始时间距离启动项目延迟时间(TimeUnit.MINUTES)
    private static final long INTERVAL = TimeUnit.HOURS.toMillis(1);//任务执行的间隔时间(TimeUnit.HOURS)

    public static void start() {
        Log.i("开始定时任务...current time is " + System.currentTimeMillis());
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //define the job and tie it to our DBConnJob class
            //定义一个任务并将它关联到我们的DBConnJob类
            JobDetail dbConnjob = newJob(DBConnJob.class).withIdentity("dbConn", "group1").build();

            //trigger the job to run now,and then repeat every 10 seconds
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                    .startAt(new Date(System.currentTimeMillis() + START_TIME_DELAY))
                    .withSchedule(simpleSchedule() //使用SimpleTrigger
                            .withIntervalInMilliseconds(INTERVAL)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(dbConnjob, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
