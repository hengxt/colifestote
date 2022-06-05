package com.example.colifestote.ui.page;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.helper.widget.Carousel;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.domain.message.SharedViewModel;
import com.example.colifestote.ui.page.adapter.ABookAdapter;
import com.example.colifestote.ui.page.adapter.DiaryAdapter;
import com.example.colifestote.ui.page.adapter.HoleAdapter;
import com.example.colifestote.ui.page.adapter.TodoAdapter;
import com.example.colifestote.ui.state.MainViewModel;
import com.example.colifestote.util.BannerUtil;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainFragment extends BaseFragment {

    private MainViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(MainViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected DataBindingConfig getDataBindingConfig() {
        TodoAdapter todoAdapter = new TodoAdapter(getContext(), new TodoAdapter.MyClickListener() {
            @Override
            public void onClick(Todo item) {
                mState.updateTodo(item);
            }
        });
        ABookAdapter aBookAdapter = new ABookAdapter(getContext());
        HoleAdapter holeAdapter = new HoleAdapter(getContext());
        DiaryAdapter diaryAdapter = new DiaryAdapter(getContext());

        diaryAdapter.setOnItemClickListener((viewId, item, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("date", item.getDate());
            // 下面是获取整理的日记日期
            ArrayList<String> arrayList = new ArrayList<>();
            Objects.requireNonNull(mState.diarySetList.getValue()).forEach(i -> {
                String date = i.getDate();
                arrayList.add(date.substring(0, date.lastIndexOf('/')));
            });
            bundle.putStringArrayList("dateList", arrayList);
            nav().navigate(R.id.action_mainFragment_to_diaryFragment, bundle);
        });

        return new DataBindingConfig(R.layout.fragment_main, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter1, todoAdapter)
                .addBindingParam(BR.adapter2, aBookAdapter)
                .addBindingParam(BR.adapter3, holeAdapter)
                .addBindingParam(BR.adapter4, diaryAdapter)
                .addBindingParam(BR.carouselAdapter, new CarouselAdapter());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 待办数据
        mState.getAllTodo().observe(getViewLifecycleOwner(), todos -> {
            mState.todoList.setValue(todos);
            for (Todo todo : todos) {
                Log.d("主页数据", "onViewCreated: " + todo.getTodoItems());
            }
        });
        // 账本数据
        mState.getAllABook().observe(getViewLifecycleOwner(), aBooks -> {
            mState.aBookList.setValue(aBooks);
            for (ABook aBook : aBooks) {
//                Log.d("主页数据", "onViewCreated: " + aBook.getABookItems());
            }
        });

        // 树洞数据
        mState.holeRequest.requestAllHoles();
        mState.holeRequest.getAllHoleLiveData().observe(getViewLifecycleOwner(), listDataResult -> {
            if (!listDataResult.getResponseStatus().isSuccess()) return;
            List<Hole> holes = listDataResult.getResult();
            if (holes != null) {
                mState.holeList.setValue(holes);
            }
        });
        mEvent.isDoAddHole().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                mState.holeRequest.requestAllHoles();
                mEvent.requestDoAddHole(false);
            }
        });

        // 日记数据
        mState.getDiarySet().observe(getViewLifecycleOwner(), diarySets -> {
            if (diarySets != null) {
                for (DiarySet diarySet : diarySets) {
                    Log.d("日记数据", "onViewCreated: " + diarySet.toString());
                }
            }
            mState.diarySetList.setValue(diarySets);
        });


    }

    public class ClickProxy {

        public void openMenu() {
            mEvent.requestToOpenOrCloseDrawer(true);
        }

        public void add() {
            nav().navigate(R.id.action_mainFragment_to_addFragment);
        }


    }

    public static class CarouselAdapter implements Carousel.Adapter {

        @Override
        public int count() {
            return BannerUtil.size();
        }

        @Override
        public void populate(View view, int index) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(BannerUtil.getBanner(index));
            }
        }

        @Override
        public void onNewItem(int index) {

        }
    }

}
