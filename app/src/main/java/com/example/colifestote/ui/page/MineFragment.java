package com.example.colifestote.ui.page;

import android.os.Bundle;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.ui.state.MineViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class MineFragment extends BaseFragment {

    private MineViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(MineViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_mine, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public class ClickProxy {
        public void about() {
            nav().navigate(R.id.action_mineFragment_to_aboutFragment);
        }

        public void setting() {
            nav().navigate(R.id.action_mineFragment_to_settingFragment);
        }

        public void statistics() {
            Bundle bundle = new Bundle();
            bundle.putString("statistics", "all");
            nav().navigate(R.id.action_mineFragment_to_statisticsActivity, bundle);
        }

        public void todo() {
            Bundle bundle = new Bundle();
            bundle.putString("statistics", "todo");
            nav().navigate(R.id.action_mineFragment_to_statisticsActivity, bundle);
        }

        public void diary() {
            Bundle bundle = new Bundle();
            bundle.putString("statistics", "diary");
            nav().navigate(R.id.action_mineFragment_to_statisticsActivity, bundle);
        }

        public void aBook() {
            Bundle bundle = new Bundle();
            bundle.putString("statistics", "aBook");
            nav().navigate(R.id.action_mineFragment_to_statisticsActivity, bundle);
        }



    }


}

