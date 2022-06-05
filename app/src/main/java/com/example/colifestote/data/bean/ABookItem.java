package com.example.colifestote.data.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "aBook_item")
public class ABookItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "type", typeAffinity = ColumnInfo.INTEGER)
    private int type;

    @ColumnInfo(name = "mark", typeAffinity = ColumnInfo.TEXT)
    private String mark;

    @ColumnInfo(name = "money")
    private float money;

    @ColumnInfo(name = "date", typeAffinity = ColumnInfo.TEXT)
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ABookItem{" +
                "id=" + id +
                ", type=" + type +
                ", mark='" + mark + '\'' +
                ", money=" + money +
                ", date='" + date + '\'' +
                '}';
    }
}
