package com.example.colifestote.util;

import com.example.colifestote.R;

import java.util.ArrayList;
import java.util.List;

public class IconUtil {

    private final static List<Integer> icons;
    private final static List<Integer> addIconsNormal;
    private final static List<Integer> addIconsSelected;

    static {
        icons = new ArrayList<>();
        icons.add(R.drawable.ic_taobao);
        icons.add(R.drawable.ic_jingdong);
        icons.add(R.drawable.ic_zhuanzhang);
        icons.add(R.drawable.ic_chaoshi);
        icons.add(R.drawable.ic_xitou);

        addIconsNormal = new ArrayList<>();
        addIconsNormal.add(R.drawable.ic_todo);
        addIconsNormal.add(R.drawable.ic_abook);
        addIconsNormal.add(R.drawable.ic_hole);
        addIconsNormal.add(R.drawable.ic_diary);

        addIconsSelected = new ArrayList<>();
        addIconsSelected.add(R.drawable.ic_todo_selected);
        addIconsSelected.add(R.drawable.ic_abook_selected);
        addIconsSelected.add(R.drawable.ic_hole_selected);
        addIconsSelected.add(R.drawable.ic_diary_selected);

    }

    public static int getIcon(int pos) {
        return icons.get(pos);
    }

    public static int size() {
        return icons.size();
    }

    public static int getAddIconSelected(int pos) {
        return addIconsSelected.get(pos);
    }

    public static int getAddIconNormal(int pos) {
        return addIconsNormal.get(pos);
    }

}
