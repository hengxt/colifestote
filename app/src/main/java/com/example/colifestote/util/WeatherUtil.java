package com.example.colifestote.util;

import java.util.ArrayList;
import java.util.List;

public class WeatherUtil {

    private static List<String> weathers = new ArrayList<>();

    static {
        weathers.add("晴朗");
        weathers.add("雨");
        weathers.add("多云");
    }

    public static String getWeather(int pos) {
        return weathers.get(pos);
    }

}
