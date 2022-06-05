package com.example.colifestote.ui.page;

import androidx.fragment.app.Fragment;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.ui.state.SettingViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class SettingFragment extends BaseFragment {


    private SettingViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(SettingViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_setting, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy {
        public void back() {
            nav().navigateUp();
        }
    }

}