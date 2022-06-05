package com.example.colifestote.ui.state;

import android.app.Application;
import android.text.format.Time;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecture.utils.ToastUtils;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.domain.request.HoleRequest;
import com.example.colifestote.util.WeekUtil;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class AddHoleViewModel extends AndroidViewModel {

    private final MutableLiveData<Hole> holeLiveData = new MutableLiveData<>();
    private final String chineseWeekName;
    private final HoleRequest holeRequest = new HoleRequest();
    private final Application application;

    {
        Hole hole = new Hole();
        Date date = DateUtil.date();
        hole.setDate(DateUtil.format(date, "yyyy/MM/dd"));
        holeLiveData.setValue(hole);
        int i = DateUtil.dayOfWeek(date);
        Log.d("====星期====", "instance initializer: " );
        chineseWeekName = WeekUtil.getChineseWeekName(i);
    }

    public AddHoleViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public Hole getHoleLiveData() {
        return holeLiveData.getValue();
    }

    public void setHoleLiveData(Hole hole) {
        holeLiveData.setValue(hole);
    }

    public String getChineseWeekName() {
        return chineseWeekName;
    }


    public void save() {
        try {
            Hole data = getHoleLiveData();
            holeRequest.requestInsertHole(data);
            Thread.sleep(500);
            ToastUtils.showLongToast(application, "请求成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
