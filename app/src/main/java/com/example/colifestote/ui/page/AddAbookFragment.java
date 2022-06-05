package com.example.colifestote.ui.page;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.data.beanmodel.ABookViewModel;
import com.example.colifestote.ui.page.adapter.AddABookAdapter;
import com.example.colifestote.ui.state.AddAbookViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.ArrayList;
import java.util.List;

public class AddAbookFragment extends BaseFragment {

    private AddAbookViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AddAbookViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        AddABookAdapter aBookAdapter = new AddABookAdapter(getContext(), getFragmentManager());

        return new DataBindingConfig(R.layout.fragment_add_abook, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, aBookAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ABookViewModel aBookViewModel1 = new ABookViewModel();
        aBookViewModel1.setMark("今天又干了啥！");
        aBookViewModel1.setMoney("3.5");
        List<ABookViewModel> aBookViewModelList = new ArrayList<>();
        aBookViewModelList.add(aBookViewModel1);
        mState.setItems(aBookViewModelList);
    }


    public class ClickProxy {
        public void save() {
            mState.save();
        }

        public void insertNewOne(){
            mState.insertNewOne();
        }

    }

}