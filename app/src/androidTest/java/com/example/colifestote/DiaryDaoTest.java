package com.example.colifestote;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.config.MyDatabase;
import com.example.colifestote.data.dao.DiaryDao;
import com.example.colifestote.data.repository.DiaryRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class DiaryDaoTest {
    private Context appContext;
    private DiaryRepository repository;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        repository = new DiaryRepository(appContext);
        MyDatabase instance = MyDatabase.getInstance(appContext);
        DiaryDao diaryDao = instance.getDiaryDao();
        Log.d("包名字", "useAppContext: " + appContext.getPackageName());
        Log.d("初始化完成", "useAppContext: ");

        Diary diary = new Diary();
        diary.content = ("第一次日记");
        diary.date = ("2020/5/12");
        diary.mood = (2);
        diary.theme = ("学习android");
        diary.weather = (3);
        repository.insertDiary(diary);


        Log.d("浏览数据", "queryAll: ");
        List<Diary> allDiary = repository.getAllDiary();
        if (allDiary != null) {
            for (Diary i : allDiary) {
                System.out.println(i.toString());
            }
        }
    }

    @Test
    public void insertDiary() {

    }

    @Test
    public void queryAll() {

    }


}
