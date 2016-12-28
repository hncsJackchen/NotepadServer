package com.jack.notepad.utils;

/**
 * Created by Administrator on 2016/12/7.
 * 日志信息
 */
public class Log {
    private static final String PREFIX = "Notepad_";

    public static void i(String msg) {
        System.out.println(log("", msg));
    }

    public static void i(String tag, String msg) {
        System.out.println(log(tag, msg));
    }

    public static void e(String msg) {
        System.err.println(log("", msg));
    }

    public static void e(String tag, String msg) {
        System.err.println(log(tag, msg));
    }


    private static String log(String tag, String msg) {
        StackTraceElement e = Thread.currentThread().getStackTrace()[4];
        // 参考这里 http://stackoverflow.com/a/36469141/5324526
        if (tag == null || tag.length() == 0 || tag.trim().length() == 0) {
            String className = e.getClassName();
            int index = className.lastIndexOf('.') + 1;
            className = className.substring(index);
            tag = PREFIX + className;
        } else {
            tag = PREFIX + tag;
        }

        String methodName = e.getMethodName();
        String fileName = e.getFileName();
        int lineNum = e.getLineNumber();
        msg = methodName + '(' + fileName + ':' + lineNum + ')' + " " + msg;

        String result = TimeUtils.getCurrentTimeDetail() + " " + tag + " " + msg;
        return result;
    }

}
