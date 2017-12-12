package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class LedgerDao {
    final int id,value,type;
    final String explanatory,date;

    public LedgerDao(int id, int value, int type, String explanatory, String date) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.explanatory = explanatory;
        this.date = date;
    }

    public String getExplanatory() {
        return explanatory;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
