package com.example.colifestote.ui.state;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecture.utils.ToastUtils;
import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.beanmodel.ABookViewModel;
import com.example.colifestote.data.beanmodel.TodoItemModel;
import com.example.colifestote.data.repository.ABookRepository;
import com.example.colifestote.util.WeekUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DateUtil;

public class AddAbookViewModel extends AndroidViewModel {

    private final ABookRepository aBookRepository;
    private final MutableLiveData<ABook> abookLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ABookViewModel>> items = new MutableLiveData<>();
    private final String chineseWeekName;


    {
        ABook aBook = new ABook();
        Date date = DateUtil.date();
        aBook.setDate(DateUtil.format(date, "yyyy/MM/dd"));
        abookLiveData.setValue(aBook);
        int i = DateUtil.dayOfWeek(date);
        chineseWeekName = WeekUtil.getChineseWeekName(i);
    }

    public AddAbookViewModel(@NonNull Application application) {
        super(application);
        aBookRepository = new ABookRepository(application);
    }

    public String getChineseWeekName() {
        return chineseWeekName;
    }

    public LiveData<List<ABookViewModel>> getItems() {
        return items;
    }

    public void setItems(List<ABookViewModel> aBookViewModelList) {
        this.items.setValue(aBookViewModelList);
    }

    public ABook getABook() {
        return abookLiveData.getValue();
    }

    public void insertNewOne() {
        List<ABookViewModel> itemsTmp = items.getValue();
        ABookViewModel itemModel = new ABookViewModel();
        itemsTmp.add(itemModel);
        setItems(itemsTmp);
    }

    public void save() {
        List<ABookItem> tmp = new ArrayList<>();
        Log.d("数据", "save: ======================================");
        List<ABookViewModel> itemsTmp = items.getValue();
        if (items != null) {
            for (ABookViewModel item : itemsTmp) {
                tmp.add(item.getABookItem());
                Log.d("ABOOK数据", "save: " + item.getABookItem().toString());
            }
        }
        Log.d("数据", "save: ======================================");
        ABook value = abookLiveData.getValue();
        assert value != null;
        value.setABookItems(tmp);
        aBookRepository.insertAbook(value);
        ToastUtils.showLongToast(getApplication(), "提交成功");
    }


}
