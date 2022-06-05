package com.example.colifestote;

import com.example.architecture.BaseApplication;
import com.example.architecture.utils.Utils;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }

}