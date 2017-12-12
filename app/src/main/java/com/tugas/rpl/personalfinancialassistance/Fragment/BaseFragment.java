package com.tugas.rpl.personalfinancialassistance.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tugas.rpl.personalfinancialassistance.R;

/**
 * Created by Undetected on 12/12/2017.
 */

public class BaseFragment extends Fragment {
    final public static String BULANAN = "BULANAN";
    final public static String MINGGUAN = "MINGGUAN";
    public final static String HARIAN = "HARIAN";
    final public static String ARGUMENT_KEY = "ARGUMENT_KEY";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String type = getArguments().getString(ARGUMENT_KEY, "Error");
        View rootView = inflater.inflate(R.layout.fragment_scheduled, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(type);
        if (type.equals(BULANAN)) {

        } else if (type.equals(MINGGUAN)) {

        } else if (type.equals(HARIAN)) {

        }
        return rootView;
    }

    public static BaseFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(ARGUMENT_KEY, type);
        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
