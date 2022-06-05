package com.example.colifestote.ui.state;


import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    public final ObservableBoolean isDrawerOpened = new ObservableBoolean();

    public final MutableLiveData<Boolean> openDrawer = new MutableLiveData<>(false);

    public final MutableLiveData<Boolean> allowDrawerOpen = new MutableLiveData<>(true);


}
