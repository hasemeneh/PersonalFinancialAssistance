package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 12/12/2017.
 */

public class WeeklyStatisticsDao {
    final String date;
    final long value;
    final int type;

    public WeeklyStatisticsDao(String date, long value, int type) {
        this.date = date;
        this.value = value;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public long getValue() {
        return value;
    }
}
