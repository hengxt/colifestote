package com.example.colifestote.util;

import com.example.colifestote.R;

import java.util.ArrayList;
import java.util.List;

public class BannerUtil {

    private static final List<Integer> banners;

    static {
        banners = new ArrayList<>();
        banners.add(R.mipmap.home_banner_01);
        banners.add(R.mipmap.home_banner_02);
        banners.add(R.mipmap.home_banner_03);
        banners.add(R.mipmap.home_banner_04);
        banners.add(R.mipmap.home_banner_05);
    }

    public static int size() {
        return banners.size();
    }

    public static int getBanner(int pos) {
        return banners.get(pos);
    }

}
