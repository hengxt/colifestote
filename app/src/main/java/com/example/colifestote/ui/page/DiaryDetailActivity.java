package com.example.colifestote.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.architecture.ui.page.BaseActivity;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.ui.state.DiaryDetailActivityViewModel;
import com.example.colifestote.ui.view.CustomDatePickerDialogFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.Calendar;

public class DiaryDetailActivity extends BaseActivity {


    private DiaryDetailActivityViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getActivityScopeViewModel(DiaryDetailActivityViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_diary_detail, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mState.id = intent.getIntExtra("id", 0);
        mState.initDiary();

    }

    public class ClickProxy {
        long day = 24 * 60 * 60 * 1000;

        public void save() {
            mState.save();
        }

        public void openDatePicker() {

            Log.d("点击日期选择器", "openDatePicker: ");
            CustomDatePickerDialogFragment fragment = new CustomDatePickerDialogFragment();
            // 处理放回结果
            fragment.setOnSelectedDateListener((year, monthOfYear, dayOfMonth) -> {
                String s = year + "/" + monthOfYear + "/" + dayOfMonth;
                mState.getDiaryLiveData().setDate(s);
            });
            Bundle bundle = new Bundle();
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTimeInMillis(System.currentTimeMillis());
            currentDate.set(Calendar.HOUR_OF_DAY, 0);
            currentDate.set(Calendar.MINUTE, 0);
            currentDate.set(Calendar.SECOND, 0);
            currentDate.set(Calendar.MILLISECOND, 0);
            bundle.putSerializable(CustomDatePickerDialogFragment.CURRENT_DATE, currentDate);

            long start = currentDate.getTimeInMillis() - day * 7;
            long end = currentDate.getTimeInMillis() - day;
            Calendar startDate = Calendar.getInstance();
            startDate.setTimeInMillis(start);
            Calendar endDate = Calendar.getInstance();
            endDate.setTimeInMillis(end);
            bundle.putSerializable(CustomDatePickerDialogFragment.START_DATE, startDate);
            bundle.putSerializable(CustomDatePickerDialogFragment.END_DATE, currentDate);

            fragment.setArguments(bundle);
            fragment.show(getSupportFragmentManager(), CustomDatePickerDialogFragment.class.getSimpleName());
        }

    }


}