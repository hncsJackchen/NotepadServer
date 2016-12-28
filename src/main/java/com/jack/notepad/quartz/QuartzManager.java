package com.jack.notepad.quartz;

import com.jack.notepad.utils.Log;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Administrator on 2016/12/28.
 * 定时任务管理器
 */
public class QuartzManager {

    //开启定时任务
    public static void start() {
        DBConnQuartz.start();


    }
}
