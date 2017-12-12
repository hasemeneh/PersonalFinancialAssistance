package com.tugas.rpl.personalfinancialassistance.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Undetected on 12/12/2017.
 */

public class ScheduledPagerAdapter extends FragmentPagerAdapter{
    final FragmentManager fragmentManager;
    final List<Fragment> data ;

    public ScheduledPagerAdapter(FragmentManager fragmentManager, List<Fragment> data) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
