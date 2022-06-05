package com.example.colifestote.ui.base.binding_adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.ui.state.AddTodoViewModel;
import com.example.colifestote.ui.state.DiaryViewModel;
import com.example.colifestote.ui.state.MainViewModel;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class RecycleViewBindingAdapter {


    @BindingAdapter(value = {"notifyInsert"}, requireAll = false)
    public static void notifyInsert(RecyclerView recyclerView, boolean b) {
        if (b) {
            recyclerView.getAdapter().notifyAll();
        }
    }

    @BindingAdapter(value = {"setLoadingListener"}, requireAll = false)
    public static void setLoadingListener(XRecyclerView recyclerView, MainViewModel vm) {
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                vm.holeRequest.requestAllHoles();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyclerView.loadMoreComplete();
            }
        });
    }


}
