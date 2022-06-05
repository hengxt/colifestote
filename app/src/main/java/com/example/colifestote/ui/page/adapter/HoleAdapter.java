package com.example.colifestote.ui.page.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.databinding.AdapterHoleBinding;
import com.example.colifestote.util.WeekUtil;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class HoleAdapter extends SimpleDataBindingAdapter<Hole, AdapterHoleBinding> {

    public HoleAdapter(Context context) {
        super(context, R.layout.adapter_hole, DiffUtils.getInstance().getHoleCallback());
    }

    @Override
    protected void onBindItem(AdapterHoleBinding binding, Hole item, RecyclerView.ViewHolder holder) {
        Date parse = DateUtil.parse(item.getDate());
        int i = DateUtil.dayOfWeek(parse);
        binding.setHole(item);
        binding.setDate(DateUtil.format(parse, "MM月dd日"));
        binding.setTime(WeekUtil.getChineseWeekName(i));
    }



}
