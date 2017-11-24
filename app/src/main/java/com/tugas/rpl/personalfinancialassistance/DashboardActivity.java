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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private PieChart dailyPieChart;
    private PieChart weeklyPieChart;
    private PieChart monthlyPieChart;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        monthlyPieChart = (PieChart) findViewById(R.id.monthlyPieChart);
        weeklyPieChart = (PieChart) findViewById(R.id.weeklyPieChart);
        dailyPieChart = (PieChart) findViewById(R.id.dailyPieChart);
        createDummy();
    }
    private void createDummy(){
        List<PieEntry> listEntryData = new ArrayList<>();
        listEntryData.add(new PieEntry(10000,"Income"));
        listEntryData.add(new PieEntry(20000,"OutCome"));
        listEntryData.add(new PieEntry(30000,"Free-to-Use Money"));
        listEntryData.add(new PieEntry(40000,"Irregularity"));
//        listEntryData.add(new PieEntry(18.5f, "Green"));
//        listEntryData.add(new PieEntry(26.7f, "Yellow"));
//        listEntryData.add(new PieEntry(24.0f, "Red"));
//        listEntryData.add(new PieEntry(30.8f, "Blue"));
        PieDataSet dataSetMonthly = new PieDataSet(listEntryData,"Monthly");
        PieDataSet dataSetWeekly = new PieDataSet(listEntryData,"Weekly");
        PieDataSet dataSetDaily = new PieDataSet(listEntryData,"Daily");
        PieData dataMonthly = new PieData(dataSetMonthly);
        PieData dataWeekly = new PieData(dataSetWeekly);
        PieData dataDaily = new PieData(dataSetDaily);
        dataDaily.setValueTextColor(Color.WHITE);
        dataWeekly.setValueTextColor(Color.WHITE);
        dataMonthly.setValueTextColor(Color.WHITE);
        dataSetDaily.setValueTextColor(Color.WHITE);
        dataSetWeekly.setValueTextColor(Color.WHITE);
        dataSetMonthly.setValueTextColor(Color.WHITE);
        dataSetDaily.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
        dataSetWeekly.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
        dataSetMonthly.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
        monthlyPieChart.setData(dataMonthly);
        dailyPieChart.setData(dataDaily);
        weeklyPieChart.setData(dataWeekly);
        monthlyPieChart.invalidate();
        dailyPieChart.invalidate();
        weeklyPieChart.invalidate();
        monthlyPieChart.notifyDataSetChanged();
        dailyPieChart.notifyDataSetChanged();
        weeklyPieChart.notifyDataSetChanged();
//        monthlyPieChart = (PieChart) findViewById(R.id.monthlyPieChart);
//        weeklyPieChart = (PieChart) findViewById(R.id.weeklyPieChart);
//        dailyPieChart = (PieChart) findViewById(R.id.dailyPieChart);
        //createDummy();
    }
//    private void createDummy(){
//        List<PieEntry> listEntryData = new ArrayList<>();
//        listEntryData.add(new PieEntry(10000,"Income"));
//        listEntryData.add(new PieEntry(20000,"OutCome"));
//        listEntryData.add(new PieEntry(30000,"Free-to-Use Money"));
//        listEntryData.add(new PieEntry(40000,"Irregularity"));
////        listEntryData.add(new PieEntry(18.5f, "Green"));
////        listEntryData.add(new PieEntry(26.7f, "Yellow"));
////        listEntryData.add(new PieEntry(24.0f, "Red"));
////        listEntryData.add(new PieEntry(30.8f, "Blue"));
//        PieDataSet dataSetMonthly = new PieDataSet(listEntryData,"Monthly");
//        PieDataSet dataSetWeekly = new PieDataSet(listEntryData,"Weekly");
//        PieDataSet dataSetDaily = new PieDataSet(listEntryData,"Daily");
//        PieData dataMonthly = new PieData(dataSetMonthly);
//        PieData dataWeekly = new PieData(dataSetWeekly);
//        PieData dataDaily = new PieData(dataSetDaily);
//        dataDaily.setValueTextColor(Color.WHITE);
//        dataWeekly.setValueTextColor(Color.WHITE);
//        dataMonthly.setValueTextColor(Color.WHITE);
//        dataSetDaily.setValueTextColor(Color.WHITE);
//        dataSetWeekly.setValueTextColor(Color.WHITE);
//        dataSetMonthly.setValueTextColor(Color.WHITE);
//        dataSetDaily.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
//        dataSetWeekly.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
//        dataSetMonthly.setColors(new int[]{Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN});
//        monthlyPieChart.setData(dataMonthly);
//        dailyPieChart.setData(dataDaily);
//        weeklyPieChart.setData(dataWeekly);
//        monthlyPieChart.invalidate();
//        dailyPieChart.invalidate();
//        weeklyPieChart.invalidate();
//        monthlyPieChart.notifyDataSetChanged();
//        dailyPieChart.notifyDataSetChanged();
//        weeklyPieChart.notifyDataSetChanged();
//    }

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

        if (id == R.id.nav_monthly) {
        if (id == R.id.nav_history) {
            // Handle the camera action
        } else if (id == R.id.nav_weekly) {

        } else if (id == R.id.nav_daily) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
