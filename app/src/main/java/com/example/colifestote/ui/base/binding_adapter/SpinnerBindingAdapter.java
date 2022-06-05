package com.example.colifestote.ui.base.binding_adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.ui.page.adapter.SpinnerDateAdapter;
import com.example.colifestote.ui.state.DiaryViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class SpinnerBindingAdapter {

    @BindingAdapter(value = {"setWeather"}, requireAll = false)
    public static void setWeather(AppCompatSpinner spinner, Diary diary) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diary.setWeather(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @BindingAdapter(value = {"setMood"}, requireAll = false)
    public static void setMood(AppCompatSpinner spinner, Diary diary) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diary.setMood(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @BindingAdapter(value = {"setDate11"}, requireAll = false)
    public static void setDate(AppCompatSpinner spinner, DiaryViewModel vm) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vm.setDate(String.valueOf(i));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @BindingAdapter(value = {"setDate"}, requireAll = false)
    public static void setAdapter(AppCompatSpinner spinner, DiaryViewModel vm) {
        SpinnerDateAdapter dateAdapter = new SpinnerDateAdapter(vm.getContext(), vm.getDateList());
        spinner.setAdapter(dateAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<String> dateList = vm.getDateList();
                vm.setDate(dateList.get(i));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
