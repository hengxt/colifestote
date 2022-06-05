package com.example.colifestote.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.config.MyDatabase;
import com.example.colifestote.data.dao.ABookDao;

import java.util.List;

public class ABookRepository {

    private final ABookDao aBookDao;

    public ABookRepository(Context context) {
        aBookDao = MyDatabase.getInstance(context).getABookDao();
    }

    public void insertAbook(ABook... aBooks) {
        new InsertAbookTask(aBookDao).execute(aBooks);
    }

    public void insertItem(ABookItem... aBookItems) {
        new InsertAbookItemTask(aBookDao).execute(aBookItems);
    }

    public List<DiarySet> getABookNumByDate() {
        return aBookDao.getAbookNumByDate();
    }

    public LiveData<List<ABook>> getAllABook() {
        return aBookDao.getAllABook();
    }

    public LiveData<List<ABookItem>> getAllItems() {
        return aBookDao.getAllItem();
    }

    private static class InsertAbookTask extends AsyncTask<ABook, Void, Void> {

        private ABookDao aBookDao;

        public InsertAbookTask(ABookDao aBookDao) {
            this.aBookDao = aBookDao;
        }

        @Override
        protected Void doInBackground(ABook... aBooks) {
            aBookDao.insertABook(aBooks);
            return null;
        }
    }

    private class InsertAbookItemTask extends AsyncTask<ABookItem, Void, Void>{
        private final ABookDao aBookdao;

        public InsertAbookItemTask(ABookDao aBookDao) {
            this.aBookdao = aBookDao;
        }

        @Override
        protected Void doInBackground(ABookItem... aBookItems) {
            aBookdao.insertItem(aBookItems);
            return null;
        }
    }
}
