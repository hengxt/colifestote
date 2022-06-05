package com.example.colifestote.data.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.colifestote.data.config.GsonInstance;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "date", typeAffinity = ColumnInfo.TEXT)
    private String date;

    @ColumnInfo(name = "time", typeAffinity = ColumnInfo.TEXT)
    private String time;

/*    public Todo(int id, String date, String time, List<TodoItem> todoItems) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.todoItems = todoItems;
    }

    @Ignore
    public Todo(int id) {
        this.id = id;
    }

    @Ignore
    public Todo() {
    }*/

    private List<TodoItem> todoItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public static class TodoItemConverter {

        @TypeConverter
        public static String converter(List<TodoItem> list) {
            return GsonInstance.getInstance().getGson().toJson(list);
        }

        @TypeConverter
        public static List<TodoItem> revert(String json) {
            Type type = new TypeToken<List<TodoItem>>() {
            }.getType();
            return GsonInstance.getInstance().getGson().fromJson(json, type);
        }

    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", todoItems=" + todoItems +
                '}';
    }
}
