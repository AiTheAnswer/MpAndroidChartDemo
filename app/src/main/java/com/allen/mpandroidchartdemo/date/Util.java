package com.allen.mpandroidchartdemo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Allen on 2017/8/10.
 */

public class Util {
    private static String[] year = new String[18];

    public static String[] getYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String format = sdf.format(new Date());
        for (int i = 0; i < 18; ) {
            year[i] = format + "-" + ++i;
        }
        return year;
    }
}
