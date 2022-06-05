package com.example.colifestote.ui.page.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.beanmodel.TodoItemModel;
import com.example.colifestote.databinding.AdapterAddTodoItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class AddTodoAdapter extends SimpleDataBindingAdapter<TodoItemModel, AdapterAddTodoItemBinding> {


    public AddTodoAdapter(Context context) {
        super(context, R.layout.adapter_add_todo_item, DiffUtils.getInstance().getAddTodoCallBack());
    }

    @Override
    protected void onBindItem(AdapterAddTodoItemBinding binding, TodoItemModel item, RecyclerView.ViewHolder holder) {
        int i = holder.getPosition();
        binding.setVm(item);
        binding.setPos(String.valueOf(i + 1));
    }



}

