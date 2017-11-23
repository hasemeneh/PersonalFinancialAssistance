package com.tugas.rpl.personalfinancialassistance;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreatePINActivity extends AppCompatActivity {
    public static void startThisActivity(Activity parent) {
        Intent intent = new Intent(parent,CreatePINActivity.class);
        parent.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pin);
    }
}
