package com.example.colifestote.ui.state;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddViewModel extends ViewModel {

    private final MutableLiveData<Boolean> animal = new MutableLiveData<>(false);

    public LiveData<Boolean> getAnimal() {
        return animal;
    }

    public void setAnimal(boolean b) {
        this.animal.setValue(b);
    }


}
