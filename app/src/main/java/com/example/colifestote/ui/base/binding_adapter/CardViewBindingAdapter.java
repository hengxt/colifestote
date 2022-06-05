package com.example.colifestote.ui.base.binding_adapter;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;

import com.example.architecture.utils.ScreenUtils;

public class CardViewBindingAdapter {

    private static final TranslateAnimation openAnimation = new TranslateAnimation(0,
            0, 0, ScreenUtils.getScreenHeight() * 7 / 8);

    private static final TranslateAnimation closeAnimation = new TranslateAnimation(0,
            0, ScreenUtils.getScreenHeight() * 7 / 8, 0);

    static {

        openAnimation.setDuration(500);
        openAnimation.setFillAfter(true);
        closeAnimation.setDuration(500);
        closeAnimation.setFillAfter(true);
    }

    private static boolean isRunning = false;

    @BindingAdapter(value = {"setAnimal"}, requireAll = false)
    public static void setAnimal(CardView cardView, boolean sw) {
        if (sw && isRunning) {
            Log.d("===", "setAnimal: 关闭");
            isRunning = false;
            cardView.startAnimation(openAnimation);
//            cardView.setVisibility(View.VISIBLE);
        } else if ((!isRunning) && (!sw)) {
            Log.d("===", "setAnimal: 打开");
            isRunning = true;
            cardView.startAnimation(closeAnimation);
//            cardView.setVisibility(View.GONE);
        }
    }


}
