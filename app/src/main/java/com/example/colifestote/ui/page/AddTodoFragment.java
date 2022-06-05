package com.example.colifestote.ui.page;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.data.beanmodel.TodoItemModel;
import com.example.colifestote.ui.page.adapter.AddTodoAdapter;
import com.example.colifestote.ui.state.AddTodoViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.ArrayList;
import java.util.List;

public class AddTodoFragment extends BaseFragment {


    private AddTodoViewModel mState;
    private AddTodoAdapter todoAdapter;


    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AddTodoViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        todoAdapter = new AddTodoAdapter(getContext());
        return new DataBindingConfig(R.layout.fragment_add_todo, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, todoAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TodoItemModel myItem1 = new TodoItemModel();
        List<TodoItemModel> myItems = new ArrayList<>();
        myItems.add(myItem1);
        mState.setItems(myItems);

    }

    public class ClickProxy {
        public void save() {
            mState.save();
        }

        public void insertNewOne() {
            mState.insertNewOne();
        }

    }

}
