package com.example.colifestote.data.beanmodel;

import androidx.databinding.ObservableField;

import com.example.colifestote.data.bean.TodoItem;

public class TodoItemModel {

    private final ObservableField<TodoItem> userObservableField;

    public TodoItemModel() {
        TodoItem item = new TodoItem();
        userObservableField = new ObservableField<>();
        userObservableField.set(item);
    }

    public TodoItem getTodoItem() {
        return userObservableField.get();
    }

    public String getContent() {
        return userObservableField.get().getContent();
    }

    public void setContent(String content) {
        userObservableField.get().setContent(content);
    }



}
