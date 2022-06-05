package com.example.colifestote.util;

import com.example.colifestote.R;

import java.util.ArrayList;
import java.util.List;

public class DiaryImgUtil {

    private final static List<Integer> images;

    static {
        images = new ArrayList<>(12);
        images.add(R.drawable.ic_diary_01);
        images.add(R.drawable.ic_diary_02);
        images.add(R.drawable.ic_diary_03);
        images.add(R.drawable.ic_diary_04);
        images.add(R.drawable.ic_diary_05);
        images.add(R.drawable.ic_diary_06);

        images.add(R.drawable.ic_diary_07);
        images.add(R.drawable.ic_diary_08);
        images.add(R.drawable.ic_diary_09);
        images.add(R.drawable.ic_diary_10);
        images.add(R.drawable.ic_diary_11);
        images.add(R.drawable.ic_diary_12);

    }

    public static int getImage(int pos) {
        return images.get(pos);
    }

}
