package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class DailyDao {
    final int id,value,type;
    final String explanatory;

    public DailyDao(int id, int value, int type, String explanatory) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.explanatory = explanatory;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;

    }

    public int getValue() {
        return value;
    }

    public String getExplanatory() {
        return explanatory;
    }

}
