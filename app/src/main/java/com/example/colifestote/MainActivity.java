package com.example.colifestote;


import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.architecture.ui.page.BaseActivity;
import com.example.colifestote.domain.message.DrawerCoordinateManager;
import com.example.colifestote.domain.message.SharedViewModel;
import com.example.colifestote.ui.state.MainActivityViewModel;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.List;


public class MainActivity extends BaseActivity {


    private MainActivityViewModel mState;
    private SharedViewModel mEvent;
    private boolean mIsListened = false;

    @Override
    protected void initViewModel() {
        mState = getActivityScopeViewModel(MainActivityViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, mState)
                .addBindingParam(BR.listener, new ListenerHandler());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO tip：Android 12 部分权限的处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            XXPermissions.with(this)
                    .permission(Permission.READ_PHONE_STATE)
                    .request(new OnPermissionCallback() {
                        @Override
                        public void onGranted(List<String> permissions, boolean all) {
                            init();
                        }

                        @Override
                        public void onDenied(List<String> permissions, boolean never) {
                            finish();
                        }
                    });
        } else {
            init();
    }
    }

    private void init() {
        mEvent.isToCloseActivityIfAllowed().observe(this, aBoolean -> {
            NavController nav = Navigation.findNavController(this, R.id.main_fragment_host);
            if (nav.getCurrentDestination() != null && nav.getCurrentDestination().getId() != R.id.mainFragment) {
                nav.navigateUp();
            } else if (mState.isDrawerOpened.get()) {
                mEvent.requestToOpenOrCloseDrawer(false);
            } else {
                super.onBackPressed();
            }
        });

        mEvent.isToOpenOrCloseDrawer().observe(this, aBoolean -> {
            mState.openDrawer.setValue(aBoolean);
        });

        DrawerCoordinateManager.getInstance().isEnableSwipeDrawer().observe(this, aBoolean -> {
            mState.allowDrawerOpen.setValue(aBoolean);
        });

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!mIsListened) {
            mEvent.requestToAddSlideListener(true);
            mIsListened = true;
        }

    }

    @Override
    public void onBackPressed() {
        mEvent.requestToCloseSlidePanelIfExpanded(true);
    }

    public class ListenerHandler extends DrawerLayout.SimpleDrawerListener {
        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            mState.isDrawerOpened.set(true);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            mState.isDrawerOpened.set(false);
            mState.openDrawer.setValue(false);
        }
    }

}
