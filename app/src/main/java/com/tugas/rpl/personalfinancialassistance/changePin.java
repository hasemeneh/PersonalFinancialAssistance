package com.tugas.rpl.personalfinancialassistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class changePin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);
        getSupportActionBar().setTitle("Change Pin");
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
