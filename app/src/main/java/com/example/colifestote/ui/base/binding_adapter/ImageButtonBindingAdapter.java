package com.example.colifestote.ui.base.binding_adapter;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.BindingAdapter;

import com.example.colifestote.util.IconUtil;

public class ImageButtonBindingAdapter {

    @BindingAdapter(value = {"switchImg", "pos"}, requireAll = true)
    public static void switchImg(AppCompatImageButton appCompatImageButton, boolean switchImg, int pos) {
        if (switchImg) {
            appCompatImageButton.setImageResource(IconUtil.getAddIconSelected(pos));
        } else {
            appCompatImageButton.setImageResource(IconUtil.getAddIconNormal(pos));
        }
    }


}
