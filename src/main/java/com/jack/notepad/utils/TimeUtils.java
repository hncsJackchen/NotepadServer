package com.jack.notepad.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 */
public class TimeUtils {
    public static final long TIME_MINUTE = TimeUnit.MINUTES.toMillis(1);
    public static final long TIME_HOUR = TimeUnit.HOURS.toMillis(1);
    public static final long TIME_DAY = TimeUnit.DAYS.toMillis(1);

    private static final SimpleDateFormat sDefaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前精确时间，格式-[2016-12-28 16:04:22.401]
     * @return
     */
    public static String getCurrentTimeDetail(){
        long m = System.currentTimeMillis();
        String time = sDefaultFormat.format(new Date(m));
        return time + "." + m % 1000;
    }




}
