package com.example.colifestote.ui.page;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import com.example.architecture.ui.page.BaseActivity;
import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.MainActivity;
import com.example.colifestote.R;
import com.example.colifestote.domain.message.SharedViewModel;
import com.example.colifestote.ui.state.AddViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.Objects;

public class AddFragment extends BaseFragment {

    private MyTouchTop myTouchTop;
    private AddViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AddViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {


        return new DataBindingConfig(R.layout.fragment_add, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myTouchTop = new MyTouchTop(mState);
        ((MainActivity) requireActivity()).registerMyTouchListener(myTouchTop);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mState.getAnimal().observe(getViewLifecycleOwner(), aBoolean -> {
//        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity) requireActivity()).unRegisterMyTouchListener(myTouchTop);
    }


    private static class MyTouchTop implements BaseActivity.MyTouchListener {
        private final AddViewModel mState;
        private float startX = 0.0f;
        private float startY = 0.0f;
        private int firstDownTag = 0;

        public MyTouchTop(AddViewModel mState) {
            this.mState = mState;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
//            Log.d("高度高度", "onTouchEvent: " + event.getY());
            final float x = event.getX();
            final float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = x;
                    startY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (isTop()) {
                        if (firstDownTag == 0) {
                            firstDownTag++;
                        } else {
                            final float dy = y - startY;
                            if (dy > 50)
                            mState.setAnimal(true);
                        }
                    }
                    if (isBottom()) {
                        if (firstDownTag == 0) {
                            firstDownTag++;
                        } else {
                            final float dy = y - startY;
                            if (dy < -50)
                            mState.setAnimal(false);
                        }
                    }
                    startX = x;
                    startY = y;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        }

        private boolean isTop() {
            if (startY < 500) {
                return true;
            }
            return false;
        }

        private boolean isBottom() {
            if (startY > 1600) {
                return true;
            }
            return false;
        }

    }

    @SuppressLint("NonConstantResourceId")
    public class ClickProxy {
        public void back() {
            nav().navigateUp();
        }

        public void addTodo() {
            Integer currentAddFragment = mEvent.getCurrentAddFragment();
            if (currentAddFragment == R.id.addTodoFragment) {
                mState.setAnimal(true);
                mState.setAnimal(false);
                return;
            }
            mEvent.requestCurrentAddFragment(R.id.addTodoFragment);
            mEvent.requestToAddFragment(R.id.action_addBaseFragment_to_addTodoFragment);
            mState.setAnimal(true);
            mState.setAnimal(false);
        }

        public void addABook(){
            Integer currentAddFragment = mEvent.getCurrentAddFragment();
            if (currentAddFragment == R.id.addAbookFragment) {
                mState.setAnimal(true);
                mState.setAnimal(false);
                return;
            }
            mEvent.requestCurrentAddFragment(R.id.addAbookFragment);
            mEvent.requestToAddFragment(R.id.action_addBaseFragment_to_addAbookFragment);
            mState.setAnimal(true);
            mState.setAnimal(false);
        }

        public void addHole() {
            Integer currentAddFragment = mEvent.getCurrentAddFragment();
            if (currentAddFragment == R.id.addHoleFragment) {
                mState.setAnimal(true);
                mState.setAnimal(false);
                return;
            }
            mEvent.requestCurrentAddFragment(R.id.addHoleFragment);
            mEvent.requestToAddFragment(R.id.action_addBaseFragment_to_addHoleFragment);
            mState.setAnimal(true);
            mState.setAnimal(false);
        }

        public void addDiary() {
            Integer currentAddFragment = mEvent.getCurrentAddFragment();
            if (currentAddFragment == R.id.addDiaryFragment) {
                mState.setAnimal(true);
                mState.setAnimal(false);
                return;
            }
            mEvent.requestCurrentAddFragment(R.id.addDiaryFragment);
            mEvent.requestToAddFragment(R.id.action_addBaseFragment_to_addDiaryFragment);
            mState.setAnimal(true);
            mState.setAnimal(false);
        }

    }

}