package com.example.colifestote.ui.state;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.repository.DiaryRepository;

public class DiaryDetailActivityViewModel extends AndroidViewModel {

    public final MutableLiveData<Diary> diaryLiveData = new MutableLiveData<>();
    private final DiaryRepository diaryRepository;
    public int id = 0;

    public DiaryDetailActivityViewModel(@NonNull Application application) {
        super(application);
        diaryRepository = new DiaryRepository(application);
    }

    public Diary getDiaryLiveData() {
        return diaryLiveData.getValue();
    }

    public void save() {
        Diary diary = getDiaryLiveData();
        Log.d("日记数据", "save: " + diary.toString());
        diaryRepository.updateDiary(diary);
    }

    public void initDiary() {
        Diary diary = diaryRepository.getDiaryById(id);
        diaryLiveData.setValue(diary);
    }
}
