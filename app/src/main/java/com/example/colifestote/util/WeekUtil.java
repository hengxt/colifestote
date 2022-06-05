package com.example.colifestote.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeekUtil {

    private final static List<String> weekName;
    private final static ArrayList<String> dateList;

    static {
        weekName = new ArrayList<>(7);
        weekName.add("星期**");
        weekName.add("星期日");
        weekName.add("星期一");
        weekName.add("星期二");
        weekName.add("星期三");
        weekName.add("星期四");
        weekName.add("星期五");
        weekName.add("星期六");

        dateList = new ArrayList<>();
        dateList.add("2022/05");
        dateList.add("2022/06");
        dateList.add("2022/07");
        dateList.add("2022/08");
        dateList.add("2022/09");
        dateList.add("2022/10");
        dateList.add("2022/11");
        dateList.add("2022/12");
    }

    public static String getChineseWeekName(int i) {
        return weekName.get(i);
    }

    public static ArrayList<String> getDateList() {
        return dateList;
    }

}
