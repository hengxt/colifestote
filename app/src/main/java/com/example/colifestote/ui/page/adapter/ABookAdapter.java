package com.example.colifestote.ui.page.adapter;

import android.content.Context;
import android.graphics.Color;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.databinding.AdapterAbookBinding;
import com.example.colifestote.databinding.AdapterAbookItemBinding;
import com.example.colifestote.util.IconUtil;
import com.example.colifestote.util.WeekUtil;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class ABookAdapter extends SimpleDataBindingAdapter<ABook, AdapterAbookBinding> {
    public ABookAdapter(Context context) {
        super(context, R.layout.adapter_abook, DiffUtils.getInstance().getABookCallback());
    }

    @Override
    protected void onBindItem(AdapterAbookBinding binding, ABook item, RecyclerView.ViewHolder holder) {
        Date parse = DateUtil.parse(item.getDate());
        int i = DateUtil.dayOfWeek(parse);
        binding.setABook(item);
        binding.setDate(DateUtil.format(parse, "MM月dd日"));
        binding.setWeek(WeekUtil.getChineseWeekName(i));
        binding.recyclerView.setAdapter(new ABookItemAdapter(mContext));
    }

    private static class ABookItemAdapter extends SimpleDataBindingAdapter<ABookItem, AdapterAbookItemBinding> {
        public ABookItemAdapter(Context context) {
            super(context, R.layout.adapter_abook_item, DiffUtils.getInstance().getABookItemCallback());
        }

        @Override
        protected void onBindItem(AdapterAbookItemBinding binding, ABookItem item, RecyclerView.ViewHolder holder) {
            int icon = IconUtil.getIcon(item.getType());
            if (item.getMoney() < 0) {
                binding.tvMoney.setTextColor(Color.parseColor("#FF03DAC5"));
            } else {
                binding.tvMoney.setTextColor(Color.parseColor("#D81B60"));
            }
            binding.setABookItem(item);
            binding.imageType.setBackgroundResource(icon);
        }
    }


}
