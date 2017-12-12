package com.tugas.rpl.personalfinancialassistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tugas.rpl.personalfinancialassistance.Util.DatabaseManager.DBManager;

public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBManager.initDB(this);
        setContentView(R.layout.activity_authentication);
        findViewById(R.id.enterButton).setOnClickListener(this);
        findViewById(R.id.createNewPassword).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.enterButton){
            DashboardActivity.startThisActivity(this);
            finish();
        }else if (view.getId() == R.id.createNewPassword){
            CreatePINActivity.startThisActivity(this);
            finish();
        }
    }
}
