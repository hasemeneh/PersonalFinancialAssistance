package com.tugas.rpl.personalfinancialassistance.Model;

/**
 * Created by Undetected on 11/24/2017.
 */

public class UserDao {
    String nama,secQuestion,secAnswer,PIN;

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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }
}
