package com.example.colifestote.data.bean;

public class DiarySet {

    private String date;

    private Integer count;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DiarySet{" +
                "date='" + date + '\'' +
                ", count=" + count +
                '}';
    }
}
