package com.example.colifestote.ui.page.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colifestote.R;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.databinding.AdapterDiaryMonthBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class DiaryMonthAdapter extends SimpleDataBindingAdapter<Diary, AdapterDiaryMonthBinding> {

    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;


    public DiaryMonthAdapter(Context context) {
        super(context, R.layout.adapter_diary_month, DiffUtils.getInstance().getDiaryCallback());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE1;
        } else if (position % 2 == 1) {
            return TYPE2;
        } else {
            return TYPE3;
        }
    }

    @Override
    protected void onBindItem(AdapterDiaryMonthBinding binding, Diary item, RecyclerView.ViewHolder holder) {
        binding.setDiary(item);
        int type = getItemViewType(holder.getPosition());
        switch (type) {
            case TYPE1:
                binding.cardView1.setVisibility(View.VISIBLE);
                binding.imageView1.setImageURL("https://www.dmoe.cc/random.php");
                binding.callMeasure.setOnClickListener(null);
                break;
            case TYPE2:
                binding.cardView2.setVisibility(View.VISIBLE);
                binding.imageView2.setImageURL("https://www.dmoe.cc/random.php");
                break;
            case TYPE3:
                binding.cardView3.setVisibility(View.VISIBLE);
                binding.imageView3.setImageURL("https://www.dmoe.cc/random.php");
                break;
        }
    }

}
