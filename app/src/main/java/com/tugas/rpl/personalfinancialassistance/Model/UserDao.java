package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class UserDao {
    final String nama,secQuestion,secAnswer,PIN;

    public UserDao(String nama, String secQuestion, String secAnswer, String pin) {
        this.nama = nama;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
        PIN = pin;
    }

    public String getNama() {
        return nama;
    }

    public String getPIN() {
        return PIN;
    }

    public String getSecAnswer() {
        return secAnswer;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

}
