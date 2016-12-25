package com.jack.notepad.utils;

/**
 * Created by HH Date: 2015/6/11 0011 Time: 下午 13:56
 */
public class CommUtils {

    public static boolean isNotBlank(Object object) {
        return !isBlank(object);
    }

    public static boolean isBlank(Object object) {
        if (object == null) {
            return true;
        }
        int strLen;
        String str = object.toString();
        if ((strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}
