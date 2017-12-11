package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class WeeklyDao {
    final int id,value,type,day;
    final String explanatory;


    public WeeklyDao(int id, int value, int type, int day, String explanatory) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.day = day;
        this.explanatory = explanatory;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public int getValue() {
        return value;
    }

    public String getExplanatory() {
        return explanatory;
    }
}
