package com.example.colifestote.ui.page.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.beanmodel.ABookViewModel;
import com.example.colifestote.databinding.AdapterAddAbookItemBinding;
import com.example.colifestote.ui.view.CustomDatePickerDialogFragment;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.Calendar;
import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class AddABookAdapter extends SimpleDataBindingAdapter<ABookViewModel, AdapterAddAbookItemBinding> {

    private final FragmentManager fragmentManager;

    public AddABookAdapter(Context context, FragmentManager fragmentManager) {
        super(context, R.layout.adapter_add_abook_item, DiffUtils.getInstance().getAddABookCallBack());
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected void onBindItem(AdapterAddAbookItemBinding binding, ABookViewModel item, RecyclerView.ViewHolder holder) {
//        Date date = DateUtil.date();
//        item.setDate((DateUtil.format(date, "yyyy/MM/dd")));
        binding.tvNum.setText(String.valueOf(holder.getPosition() + 1));
        binding.setVm(item);
        binding.setClick(new ClickProxy(binding));
        AppCompatSpinner spinner = binding.appCompatSpinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item.setType("" + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public class ClickProxy {
        long day = 24 * 60 * 60 * 1000;

        private final AdapterAddAbookItemBinding binding;

        public ClickProxy(AdapterAddAbookItemBinding binding) {
            this.binding = binding;
        }

        public void openDatePicker() {
            Log.d("点击日期选择器", "openDatePicker: ");
            CustomDatePickerDialogFragment fragment = new CustomDatePickerDialogFragment();
            // 处理放回结果
            fragment.setOnSelectedDateListener((year, monthOfYear, dayOfMonth) -> {
                String s = year + "/" + monthOfYear + "/" + dayOfMonth;
                binding.editTextDate.setText(s);
            });
            Bundle bundle = new Bundle();
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTimeInMillis(System.currentTimeMillis());
            currentDate.set(Calendar.HOUR_OF_DAY, 0);
            currentDate.set(Calendar.MINUTE, 0);
            currentDate.set(Calendar.SECOND, 0);
            currentDate.set(Calendar.MILLISECOND, 0);
            bundle.putSerializable(CustomDatePickerDialogFragment.CURRENT_DATE, currentDate);


            long start = currentDate.getTimeInMillis() - day * 7;
            long end = currentDate.getTimeInMillis() - day;
            Calendar startDate = Calendar.getInstance();
            startDate.setTimeInMillis(start);
            Calendar endDate = Calendar.getInstance();
            endDate.setTimeInMillis(end);
            bundle.putSerializable(CustomDatePickerDialogFragment.START_DATE, startDate);
            bundle.putSerializable(CustomDatePickerDialogFragment.END_DATE, currentDate);

            fragment.setArguments(bundle);
            fragment.show(fragmentManager, CustomDatePickerDialogFragment.class.getSimpleName());
        }


    }

}
