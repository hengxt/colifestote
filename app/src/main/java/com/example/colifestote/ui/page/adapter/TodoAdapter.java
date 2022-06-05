package com.example.colifestote.ui.page.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.bean.TodoItem;
import com.example.colifestote.databinding.AdapterTodoBinding;
import com.example.colifestote.databinding.AdapterTodoItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.List;

public class TodoAdapter extends SimpleDataBindingAdapter<Todo, AdapterTodoBinding> {

    private final MyClickListener myClickListener;

    public TodoAdapter(Context context, MyClickListener onClickListener) {
        super(context, R.layout.adapter_todo, DiffUtils.getInstance().getTodoCallback());
        this.myClickListener = onClickListener;
    }

    @Override
    protected void onBindItem(AdapterTodoBinding binding, Todo item, RecyclerView.ViewHolder holder) {
        binding.setTodo(item);
        TodoItemAdapter itemAdapter = new TodoItemAdapter(mContext);

        setOnItemClickListener(new OnItemClickListener<Todo>() {
            @Override
            public void onItemClick(int viewId, Todo item, int position) {
                System.out.println("=======获取好巧好巧好巧");
                myClickListener.onClick(item);
            }
        });
        binding.recyclerView.setAdapter(itemAdapter);


    }

    public interface MyClickListener{
        void onClick(Todo item);

    }


    private static class TodoItemAdapter extends SimpleDataBindingAdapter<TodoItem, AdapterTodoItemBinding> {

        public TodoItemAdapter(Context context) {
            super(context, R.layout.adapter_todo_item, DiffUtils.getInstance().getTodoItemCallback());
        }

        @Override
        protected void onBindItem(AdapterTodoItemBinding binding, TodoItem item, RecyclerView.ViewHolder holder) {
            binding.setTodoItem(item);
            binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    item.setChecked(b);
                }
            });

        }
    }
}
