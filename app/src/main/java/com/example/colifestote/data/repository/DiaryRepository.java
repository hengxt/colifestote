package com.example.colifestote.data.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.config.MyDatabase;
import com.example.colifestote.data.dao.DiaryDao;

import java.util.List;

public class DiaryRepository {

    private final DiaryDao diaryDao;

    public DiaryRepository(Context context) {
        MyDatabase instance = MyDatabase.getInstance(context);
        diaryDao = instance.getDiaryDao();
    }


    public void insertDiary(Diary... diaries) {
        new InsertDiaryTask(diaryDao).execute(diaries);
    }

    public void updateDiary(Diary... diaries) {
        new UpdateDiaryTask(diaryDao).execute(diaries);
    }

    public List<Diary> getAllDiary() {
        GetAllDiaryTask task = new GetAllDiaryTask(diaryDao);
        task.execute();
//        return diaryDao.getAllDiaries();
        return null;
    }

    public LiveData<List<Diary>> getAllLiveDiary() {
        return diaryDao.getAllLiveDiary();
    }

    public LiveData<List<DiarySet>> getDiarySet() {
        return diaryDao.getDiarySet();
    }

    public Diary getDiaryById(int id) {
        return diaryDao.getDiaryById(id);
    }

    public List<DiarySet> getDiaryNumByDate() {
        return diaryDao.getDiaryNumByDate();
    }

    public LiveData<List<Diary>> getDiaryByDate(String date) {
        return diaryDao.getDiaryByDate(date);
    }

    public List<Diary> getDiariesByDate(String date) {
        return diaryDao.getDiariesDate(date);
    }

    private static class InsertDiaryTask extends AsyncTask<Diary, Void, Void> {
        private final DiaryDao diaryDao;

        public InsertDiaryTask(DiaryDao diaryDao) {
            this.diaryDao = diaryDao;
        }

        @Override
        protected Void doInBackground(Diary... diaries) {
            this.diaryDao.insertDiary(diaries);
            return null;
        }
    }

    private static class UpdateDiaryTask extends AsyncTask<Diary, Void, Void> {
        private final DiaryDao diaryDao;

        public UpdateDiaryTask(DiaryDao diaryDao) {
            this.diaryDao = diaryDao;
        }

        @Override
        protected Void doInBackground(Diary... diaries) {
            this.diaryDao.UpdateDiary(diaries);
            return null;
        }
    }

    private static class GetAllDiaryTask extends AsyncTask<Void, Void, List<Diary>> {

        private DiaryDao diaryDao;

        public GetAllDiaryTask(DiaryDao diaryDao) {
            this.diaryDao = diaryDao;
        }

        @Override
        protected List<Diary> doInBackground(Void... voids) {
            List<Diary> allDiaries = diaryDao.getAllDiaries();
            Log.d("数据", "doInBackground: 开始加载数据");
            if (allDiaries != null) {
                for (Diary i : allDiaries) {
                    System.out.println(i.toString());
                }
            }
            return allDiaries;
        }
    }

}
