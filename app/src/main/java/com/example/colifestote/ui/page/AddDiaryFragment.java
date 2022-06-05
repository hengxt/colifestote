package com.example.colifestote.ui.page;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.domain.message.SharedViewModel;
import com.example.colifestote.ui.state.AddDiaryViewModel;
import com.example.colifestote.ui.view.CustomDatePickerDialogFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.Calendar;
import java.util.Objects;

public class AddDiaryFragment extends BaseFragment {

    private AddDiaryViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AddDiaryViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_add_diary, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                Diary data = mState.getDiaryLiveData();
                data.setDate(s);
                mState.setDiaryLiveData(data);
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
            fragment.show(requireFragmentManager(), CustomDatePickerDialogFragment.class.getSimpleName());
        }

    }

}