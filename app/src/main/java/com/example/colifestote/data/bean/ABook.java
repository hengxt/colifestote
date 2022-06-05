package com.example.colifestote.data.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.colifestote.data.config.GsonInstance;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "aBook")
public class ABook {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private Integer id;

    @ColumnInfo(name = "date", typeAffinity = ColumnInfo.TEXT)
    private String date;


    private List<ABookItem> aBookItems;


    @Ignore
    public ABook() {

    }

    @Ignore
    public ABook(String date, List<ABookItem> aBookItems) {
        this.date = date;
        this.aBookItems = aBookItems;
    }

    public ABook(Integer id, String date, List<ABookItem> aBookItems) {
        this.id = id;
        this.date = date;
        this.aBookItems = aBookItems;

    }
    public static class ABookItemConverter {

        @TypeConverter
        public static String converter(List<ABookItem> list) {
            return GsonInstance.getInstance().getGson().toJson(list);
        }

        @TypeConverter
        public static List<ABookItem> revert(String json) {
            Type type = new TypeToken<List<ABookItem>>() {
            }.getType();
            return GsonInstance.getInstance().getGson().fromJson(json, type);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ABookItem> getABookItems() {
        return aBookItems;
    }

    public void setABookItems(List<ABookItem> aBookItems) {
        this.aBookItems = aBookItems;
    }
}
