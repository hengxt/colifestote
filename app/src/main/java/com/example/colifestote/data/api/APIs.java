package com.example.colifestote.data.api;

import com.example.architecture.utils.SPUtils;

/**
 */
public class APIs {

    public static String BASE_URL;

    static {
//        BASE_URL = SPUtils.getInstance().getString("BASE_URL", "http://10.0.2.2:9090");
        BASE_URL = SPUtils.getInstance().getString("BASE_URL", "http://59.110.106.180:9090");
    }


}
