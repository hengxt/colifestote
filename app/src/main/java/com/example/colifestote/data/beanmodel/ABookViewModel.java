package com.example.colifestote.data.beanmodel;

import androidx.databinding.ObservableField;

import com.example.colifestote.data.bean.ABookItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABookViewModel {

    private final ObservableField<ABookItem> aBookItemObservableField;

    public ABookViewModel() {
        ABookItem item = new ABookItem();
        aBookItemObservableField = new ObservableField<>();
        aBookItemObservableField.set(item);
    }

    public ABookItem getABookItem() {
        return aBookItemObservableField.get();
    }

    public String getDate() {
        return aBookItemObservableField.get().getDate();
    }

    public void setDate(String date) {
        aBookItemObservableField.get().setDate(date);
    }

    public String getMark() {
        return aBookItemObservableField.get().getMark();
    }

    public void setMark(String mark) {
        aBookItemObservableField.get().setMark(mark);
    }

    public String getMoney() {
        return String.valueOf(aBookItemObservableField.get().getMoney());
    }

    public void setMoney(String money) {
        if ("".equals(money) || money == null){
            money = "0.0";
        } else if (!isNumericzidai(money)){
            money = "0.0";
        }
        aBookItemObservableField.get().setMoney(Float.valueOf(money));
    }

    public String getType() {
        return String.valueOf(aBookItemObservableField.get().getType());
    }

    public void setType(String type) {
        if ("".equals(type) || type == null) {
            type = "0";
        }
        aBookItemObservableField.get().setType(Integer.valueOf(type));
    }

    public static boolean isNumericzidai(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
