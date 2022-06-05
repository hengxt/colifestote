package com.example.colifestote.ui.base.binding_adapter;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerBindingAdapter {

    @BindingAdapter(value = {"setOffscreenPageLimit"}, requireAll = false)
    public static void setOffscreenPageLimit(ViewPager viewPager, int i) {
        viewPager.setOffscreenPageLimit(i);
    }

}
