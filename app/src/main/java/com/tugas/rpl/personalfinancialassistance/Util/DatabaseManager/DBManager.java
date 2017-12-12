package com.tugas.rpl.personalfinancialassistance.Util.DatabaseManager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.tugas.rpl.personalfinancialassistance.Model.WeeklyStatisticsDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Retrieving on 5/24/2016.
 */
public class DBManager {
    private static SQLiteDatabase dataBasex;
    private static SQLiteDatabase dataBase;

    public static void initDB(final Context context) {
        if (dataBasex == null || dataBase == null) {
            final DBHelper DBhelper = new DBHelper(context);
            dataBasex = DBhelper.getReadableDatabase();
            dataBase = DBhelper.getWritableDatabase();
        }
    }


    //    public static boolean insertNews(Context context, List<BeritaDao> datas,int page) {
//        try {
//            DBManager.initDB(context);
//        } catch (Exception e) {
//            Log.d("errorSQLManager", e.getMessage());
//        }
//        final Gson gson = new Gson();
//
//        try {
//            if(page<2){
//                String sql = "TRUNCATE `berita`;";
//                dataBase.execSQL(sql);
//            }
//            for (BeritaDao dao : datas) {
//                String sql = "REPLACE INTO `berita` (`id_newsdive`,`id_provinsi`,`kategori`, `json`,`modified_date`) " +
//                        "VALUES ('" + dao.getId_newsdive() + "'," + dao.getId_provinsi() + ",'" + dao.getKategori() + "', '" + gson.toJson(dao) + "','"+dao.getModified_date()+"');";
//                dataBase.execSQL(sql);
//            }
//            return true;
//        } catch (SQLException ex) {
//            Log.d("errorSQLManager", ex.getMessage());
//            return false;
//        }
//
//    }
    public static final int PEMASUKKAN = 1;
    public static final int PENGELUARAN = -1;

    public static List<WeeklyStatisticsDao> getWeeklyStatistics(Context context) {
        final ArrayList<WeeklyStatisticsDao> item = new ArrayList();
        try {
            DBManager.initDB(context);
        } catch (Exception e) {
            Log.d("errorSQLManager", e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        Date endDate = Calendar.getInstance().getTime();
        calendar.setTime(endDate);
        calendar.add(Calendar.DAY_OF_YEAR,-7);
        Date startDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "SELECT SUM(`value`) as 'besaran', `date`,`type` FROM `ledger` WHERE date BETWEEN '"+formatter.format(startDate)+"' AND '"+formatter.format(endDate)+"'  GROUP BY `date`,`type` ORDER BY `date`,`type` DESC";
        final Gson gson = new Gson();
        try {
            final Cursor cursor = dataBasex.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                item.add(new WeeklyStatisticsDao(cursor.getString(1), cursor.getLong(0), cursor.getInt(2)));
//                Toast.makeText(context, ""+cursor.getString(3), Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            return item;
        } catch (SQLException ex) {
            Log.d("errorSQLManager", ex.getMessage());
        }
        return item;
    }
    public static long getFreeToUseMoney(Context context) {
        try {
            DBManager.initDB(context);
        } catch (Exception e) {
            Log.d("errorSQLManager", e.getMessage());
        }
        String sql = "SELECT SUM(`value`*`type`) as 'besaran' FROM `ledger`";
        final Gson gson = new Gson();
        try {
            final Cursor cursor = dataBasex.rawQuery(sql, null);
            long jumlah = 0 ;
            cursor.moveToFirst();
            jumlah = cursor.getLong(0);
            cursor.close();
            return jumlah;
        } catch (SQLException ex) {
            Log.d("errorSQLManager", ex.getMessage());
        }
        return 0;
    }
}
