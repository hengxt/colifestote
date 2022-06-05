package com.example.colifestote.data.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_item")
public class TodoItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tid", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "content", typeAffinity = ColumnInfo.TEXT)
    private String content;

    @ColumnInfo(name = "checked")
    private boolean checked;

    public String getContent() {
        return content;
    }


/*    public TodoItem(int id, String content, boolean checked) {
        this.id = id;
        this.content = content;
        this.checked = checked;
    }

    @Ignore
    public TodoItem(int id) {
        this.id = id;
    }

    @Ignore
    public TodoItem() {
    }*/

    public void setContent(String content) {

        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                '}';
    }
}
