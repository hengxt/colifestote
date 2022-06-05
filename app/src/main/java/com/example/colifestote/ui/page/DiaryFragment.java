package com.example.colifestote.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.ui.page.adapter.DiaryMonthAdapter;
import com.example.colifestote.ui.state.DiaryViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.ArrayList;

public class DiaryFragment extends BaseFragment {


    private DiaryViewModel mState;
    private String date;
    private ArrayList<String> dateList;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(DiaryViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        // adapter设置
        DiaryMonthAdapter adapter = new DiaryMonthAdapter(getContext());
        adapter.setOnItemClickListener((viewId, item, position) -> {
            Intent intent = new Intent(getContext(), DiaryDetailActivity.class);
            intent.putExtra("id", item.getId());
            startActivity(intent);
        });

        return new DataBindingConfig(R.layout.fragment_diary, BR.vm, mState)
                .addBindingParam(BR.adapter, adapter)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        assert bundle != null;
        date = bundle.getString("date");
        dateList = bundle.getStringArrayList("dateList");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mState.setDate(date);
        // 日期观察
        mState.getDateLiveData().observe(getViewLifecycleOwner(), s -> {
            Log.d("日期改变造成数据改变", "onViewCreated: " + s);
            mState.postDiaries();
        });
        mState.setDateList(dateList);

        // 日记变化观察，嵌套了日期的观察
        mState.getDiaryLiveData().observe(getViewLifecycleOwner(), diaries -> {
            for (Diary i : diaries) {
                Log.d("日期改变造成数据改变", "onViewCreated: " + i.toString());
            }
            diaries.add(0, new Diary());
            mState.diaryListLiveData.setValue(diaries);
        });
    }

    public class ClickProxy {

        public void back() {
            nav().navigateUp();
        }

    }

}