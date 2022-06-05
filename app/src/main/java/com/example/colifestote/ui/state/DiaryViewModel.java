package com.example.colifestote.ui.state;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.repository.DiaryRepository;

import java.util.ArrayList;
import java.util.List;

public class DiaryViewModel extends AndroidViewModel {

    private final MutableLiveData<String> date = new MutableLiveData<>();
    public final MutableLiveData<List<Diary>> diaryListLiveData = new MutableLiveData<>();
    @SuppressLint("StaticFieldLeak")
    private final Context context;
    private final DiaryRepository diaryRepository;
    private ArrayList<String> dateList = new ArrayList<>();

    public DiaryViewModel(@NonNull Application application) {
        super(application);
        context = getApplication();
        diaryRepository = new DiaryRepository(application);
    }


    public ArrayList<String> getDateList() {
        return dateList;
    }

    public void setDateList(ArrayList<String> list) {
        this.dateList = list;
    }

    public Context getContext() {
        return context;
    }

    public String getDate() {
        return date.getValue();
    }

    public void setDate(String date) {
        this.date.setValue(date);
    }

    public LiveData<List<Diary>> getDiaryLiveData(){
        return diaryRepository.getDiaryByDate(getDate());
    }

    public void postDiaries() {
        List<Diary> diaries = diaryRepository.getDiariesByDate(getDate());
        diaries.add(0, new Diary());
        diaryListLiveData.setValue(diaries);
    }


    public LiveData<String> getDateLiveData() {
        return date;
    }
}