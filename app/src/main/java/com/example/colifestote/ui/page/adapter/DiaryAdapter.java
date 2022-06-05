package com.example.colifestote.ui.page.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.databinding.AdapterDiaryBinding;
import com.example.colifestote.util.DiaryImgUtil;
import com.example.colifestote.util.IconUtil;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class DiaryAdapter extends SimpleDataBindingAdapter<DiarySet, AdapterDiaryBinding> {
    public DiaryAdapter(Context context) {
        super(context, R.layout.adapter_diary, DiffUtils.getInstance().getDiarySetCallback());
        setOnItemClickListener(new OnItemClickListener<DiarySet>() {
            @Override
            public void onItemClick(int viewId, DiarySet item, int position) {


            }
        });
    }

    @Override
    protected void onBindItem(AdapterDiaryBinding binding, DiarySet item, RecyclerView.ViewHolder holder) {
        Date parse = DateUtil.parse(item.getDate());
        binding.setDate(DateUtil.format(parse, "yyyy.MM.dd"));
        binding.setNum("共有"+ item.getCount() + "篇日记");
        binding.imageDiary.setImageResource(DiaryImgUtil.getImage(DateUtil.month(parse)));
    }
}
