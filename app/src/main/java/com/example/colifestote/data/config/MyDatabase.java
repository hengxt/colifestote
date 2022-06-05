package com.example.colifestote.data.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.bean.TodoItem;
import com.example.colifestote.data.dao.ABookDao;
import com.example.colifestote.data.dao.DiaryDao;
import com.example.colifestote.data.dao.TodoDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Database(entities = {TodoItem.class, Todo.class, Diary.class, ABook.class, ABookItem.class},
        version = 1,
        exportSchema = false)
@TypeConverters({Todo.TodoItemConverter.class, ABook.ABookItemConverter.class})
public abstract class MyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase mInstance;

    //private MyDatabase(){}

    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return mInstance;
    }

    public abstract TodoDao getTodoDao();

    public abstract DiaryDao getDiaryDao();

    public abstract ABookDao getABookDao();

    public static class BaseDataCovert<T> {
        @TypeConverter
        public  T revert(String jsonString) {
            try {

                Type type = new TypeToken<T>() {
                }.getType();
                T data = new Gson().fromJson(jsonString, type);
                return data;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @TypeConverter
        public String converter(T data) {
            return new Gson().toJson(data);
        }
    }

    public static class TodoListCovert extends BaseDataCovert<List<TodoItem>> {
    }

    public static class ABookListCovert extends BaseDataCovert<List<ABookItem>> {
    }

}
