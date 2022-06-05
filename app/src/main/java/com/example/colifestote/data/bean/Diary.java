package com.example.colifestote.data.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "diary")
public class Diary {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "date", typeAffinity = ColumnInfo.TEXT)
    public String date;

    @ColumnInfo(name = "content", typeAffinity = ColumnInfo.TEXT)
    public String content;

    @ColumnInfo(name = "theme", typeAffinity = ColumnInfo.TEXT)
    public String theme;

    @ColumnInfo(name = "weather", typeAffinity = ColumnInfo.INTEGER)
    public int weather;

    @ColumnInfo(name = "mood", typeAffinity = ColumnInfo.INTEGER)
    public int mood;

    public Diary(int id, String date, String content, String theme, int weather, int mood) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.theme = theme;
        this.weather = weather;
        this.mood = mood;
    }

    @Ignore
    public Diary() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", theme='" + theme + '\'' +
                ", weather=" + weather +
                ", mood=" + mood +
                '}';
    }
}
