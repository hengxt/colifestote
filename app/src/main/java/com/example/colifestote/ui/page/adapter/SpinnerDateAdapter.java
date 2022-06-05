package com.example.colifestote.ui.page.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.colifestote.R;

import java.util.List;

public class SpinnerDateAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context context;
    private final List<String> list;

    public SpinnerDateAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View inflate = LayoutInflater.from(context).inflate(R.layout.spinner_date, null);
        TextView tvDate = inflate.findViewById(R.id.tv_date);
        tvDate.setText(getItem(i).toString());
        return inflate;
    }



}
