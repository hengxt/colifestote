package com.example.colifestote.ui.state;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.architecture.utils.ToastUtils;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.bean.TodoItem;
import com.example.colifestote.data.beanmodel.TodoItemModel;
import com.example.colifestote.data.repository.TodoRepository;
import com.example.colifestote.ui.page.adapter.AddTodoAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DateUtil;

public class AddTodoViewModel extends AndroidViewModel {

    private final TodoRepository todoRepository;
    private final MutableLiveData<List<TodoItemModel>> items = new MutableLiveData<>();
    public MutableLiveData<Todo> todoMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isNotify = new MutableLiveData<>(false);

    {
        Todo todo = new Todo();
        Date date = DateUtil.date();
        todo.setDate(DateUtil.format(date, "MM月dd日"));
        todo.setTime(DateUtil.format(date, "hh:mm"));
        todoMutableLiveData.setValue(todo);
    }

    public AddTodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
    }

    public LiveData<List<TodoItemModel>> getItems() {
        return items;
    }

    public void setItems(List<TodoItemModel> myItems) {
        this.items.setValue(myItems);
    }

    public Todo getTodo() {
        return todoMutableLiveData.getValue();
    }


    public void insertNewOne() {
        List<TodoItemModel> itemsTmp = items.getValue();
        TodoItemModel itemModel = new TodoItemModel();
        itemsTmp.add(itemModel);
        setItems(itemsTmp);
    }

    public void save() {
        List<TodoItem> tmp = new ArrayList<>();
        Log.d("数据", "save: ======================================");
        List<TodoItemModel> itemsTmp = items.getValue();
        for (TodoItemModel itemModel : itemsTmp) {
            tmp.add(itemModel.getTodoItem());
            Log.d("数据", "save: " + itemModel.getContent());
        }
        Log.d("数据", "save: ======================================");
        Todo value = todoMutableLiveData.getValue();
        assert value != null;
        value.setTodoItems(tmp);
        todoRepository.insertTodo(value);
        ToastUtils.showLongToast(getApplication(), "提交成功");
    }


}
