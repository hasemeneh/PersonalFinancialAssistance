package com.tugas.rpl.personalfinancialassistance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.tugas.rpl.personalfinancialassistance.Adapter.ScheduledPagerAdapter;
import com.tugas.rpl.personalfinancialassistance.Model.WeeklyStatisticsDao;
import com.tugas.rpl.personalfinancialassistance.Util.DatabaseManager.DBManager;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView txtIsiTips;
    private LineChart lineChartPengeluaran;
    private TextView txtFreeToUseMoney;

//    private PieChart dailyPieChart;
//    private PieChart weeklyPieChart;
//    private PieChart monthlyPieChart;

    public static void startThisActivity(Activity parent) {
        Intent intent = new Intent(parent,DashboardActivity.class);
        parent.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutActivity.startThisActivity(DashboardActivity.this);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        txtFreeToUseMoney = (TextView) findViewById(R.id.textViewFreeToUseMoney);
        txtIsiTips = (TextView) findViewById(R.id.txtIsiTips);
        txtIsiTips.setSelected(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        lineChartPengeluaran= (LineChart) findViewById(R.id.linechartPengeluaran);
        createDummy();
    }
    private void createDummy(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("in_ID"));
        txtFreeToUseMoney.setText(numberFormat.format(DBManager.getFreeToUseMoney(this)));
        final List<Entry> entries = new ArrayList<Entry>();
        final List<Entry> entries2 = new ArrayList<Entry>();
        final List<WeeklyStatisticsDao> temp1 = new ArrayList<>();
        temp1.addAll(DBManager.getWeeklyStatistics(this));
//        Calendar calendar = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR,1);
//        Date endDate = calendar2.getTime();
//        calendar.setTime(endDate);
//        calendar.add(Calendar.DAY_OF_YEAR,-8);
//        Date startDate = calendar.getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd");
//        Date iterator = (Date) startDate.clone();
//        while(!iterator.equals(endDate)){
//
//
//        }
        int size = temp1.size();
        for (int i =0;i<size;i++){
            //if((i+1))
        }

//        entries.add(new Entry(1.1f,1.2f));
//        entries.add(new Entry(2f,3f));
//        entries.add(new Entry(3f,1.2f));
//        entries.add(new Entry(4f,5f));
//        entries.add(new Entry(5f,2f));
//        entries.add(new Entry(6f,9f));
//        entries.add(new Entry(7f,3f));
//        entries2.add(new Entry(1.1f,4f));
//        entries2.add(new Entry(2f,2f));
//        entries2.add(new Entry(3f,3f));
//        entries2.add(new Entry(4f,6f));
//        entries2.add(new Entry(5f,8f));
//        entries2.add(new Entry(6f,9f));
//        entries2.add(new Entry(7f,9f));

        LineDataSet dataSet1 = new LineDataSet(entries,"Pengeluaran");
        dataSet1.setColor(Color.rgb(245,179,23));
        LineDataSet dataSet2 = new LineDataSet(entries2,"Pemasukkan");
        dataSet2.setColor(Color.rgb(128,211,77));
        LineData data2 = new LineData(dataSet1,dataSet2);
        lineChartPengeluaran.setData(data2);
        lineChartPengeluaran.invalidate();
        lineChartPengeluaran.animateXY(2000,2000);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_history) {
            // Handle the camera action
            ScheduledActivity.startThisActivity(this);
        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
