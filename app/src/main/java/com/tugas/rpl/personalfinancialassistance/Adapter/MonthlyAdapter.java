package com.tugas.rpl.personalfinancialassistance.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tugas.rpl.personalfinancialassistance.Model.MonthlyDao;
import com.tugas.rpl.personalfinancialassistance.R;

import java.util.List;

/**
 * Created by Undetected on 12/12/2017.
 */

public class MonthlyAdapter extends BaseAdapter {
    final Activity activity;
    final List<MonthlyDao> data;

    public MonthlyAdapter(Activity activity, List<MonthlyDao> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        if (v == null) {
            final LayoutInflater inflater = activity.getLayoutInflater();
            v = inflater.inflate(R.layout.layout_item_bulanan, null);
        }
        return v;
    }
}
