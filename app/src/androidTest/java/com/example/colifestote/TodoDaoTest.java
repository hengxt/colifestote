package com.example.colifestote;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.bean.TodoItem;
import com.example.colifestote.data.repository.TodoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TodoDaoTest {

    private Context appContext;
    private TodoRepository repository;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        repository = new TodoRepository(appContext);
        Log.d("包名字", "useAppContext: " + appContext.getPackageName());
        Log.d("初始化完成", "useAppContext: ");
    }

    @Test
    public void insert(){

        Todo todo = new Todo();
        todo.setDate("5月12日");
        todo.setTime("12:24");
        List<TodoItem> todoItems = new ArrayList<>();
        TodoItem item = new TodoItem();
        item.setContent("测试测试测试");
        item.setChecked(false);
        todoItems.add(item);
        todoItems.add(item);
        todoItems.add(item);
        todo.setTodoItems(todoItems);


        repository.insertTodo(todo);
    }

    @Test
    public void QueryAll() {

        Log.d("获取数据", "useAppContext: ");
        LiveData<List<Todo>> todoLive = repository.getTodoLive();
        for (Todo todo: todoLive.getValue()) {
            System.out.println(todo.toString());
        }
    }

}
