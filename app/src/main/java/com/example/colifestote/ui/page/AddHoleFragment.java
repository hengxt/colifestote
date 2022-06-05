package com.example.colifestote.ui.page;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.domain.message.SharedViewModel;
import com.example.colifestote.ui.state.AddHoleViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class AddHoleFragment extends BaseFragment {

    private AddHoleViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AddHoleViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_add_hole, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public class ClickProxy {
        public void save() {
            mState.save();
            mEvent.requestDoAddHole(true);
        }

    }

}