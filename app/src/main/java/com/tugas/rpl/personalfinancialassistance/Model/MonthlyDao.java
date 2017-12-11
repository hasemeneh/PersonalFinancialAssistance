package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class MonthlyDao {
    final int id,value,type,date;
    final String explanatory;

    public MonthlyDao(int id, int value, int type, int date, String explanatory) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.date = date;
        this.explanatory = explanatory;
    }

    public String getExplanatory() {
        return explanatory;
    }

    public int getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }
}
