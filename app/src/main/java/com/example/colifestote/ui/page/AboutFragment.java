package com.example.colifestote.ui.page;

import com.example.architecture.ui.page.BaseFragment;
import com.example.colifestote.BR;
import com.example.colifestote.R;
import com.example.colifestote.ui.state.AboutViewModel;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class AboutFragment extends BaseFragment {


    private AboutViewModel mState;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(AboutViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {

        return new DataBindingConfig(R.layout.fragment_about, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());

    }

    public class ClickProxy {
        public void back() {
            nav().navigateUp();
        }
    }



}