package com.example.colifestote.ui.state;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecture.utils.ToastUtils;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.data.repository.DiaryRepository;
import com.example.colifestote.util.WeekUtil;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class AddDiaryViewModel extends AndroidViewModel {

    private final MutableLiveData<Diary> diaryLiveData = new MutableLiveData<>();
    private final String chineseWeekName;
    private final DiaryRepository diaryRepository;

    {
        Diary diary = new Diary();
        Date date = DateUtil.date();
        diary.setDate(DateUtil.format(date, "yyyy/MM/dd"));
        diaryLiveData.setValue(diary);
        int i = DateUtil.dayOfWeek(date);
        Log.d("====星期====", "instance initializer: ");
        chineseWeekName = WeekUtil.getChineseWeekName(i);
    }

    public AddDiaryViewModel(@NonNull Application application) {
        super(application);
        diaryRepository = new DiaryRepository(application);
    }

    public String getChineseWeekName() {
        return chineseWeekName;
    }

    public Diary getDiaryLiveData() {
        return diaryLiveData.getValue();
    }

    public LiveData<Diary> getLiveData() {
        return  diaryLiveData;
    }

    public void setDiaryLiveData(Diary diary) {
        this.diaryLiveData.setValue(diary);
    }


    public void save() {
        Diary diary = getDiaryLiveData();
        Log.d("日记数据", "save: " + diary.toString());
        diaryRepository.insertDiary(diary);
        ToastUtils.showLongToast(getApplication(), "提交成功");
    }

}
