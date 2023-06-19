package com.example.demau2;

import androidx.annotation.NonNull;

public class SinhVien {
    private int id;
    private String ten;
    private String yob;
    private String que;
    private String namhoc;

    public SinhVien(int id, String ten, String yob, String que, String namhoc) {
        this.id = id;
        this.ten = ten;
        this.yob = yob;
        this.que = que;
        this.namhoc = namhoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: "+id + "\nTen: " + ten + "\nNam sinh: " + yob + "\nQue: "+que
                +"\nNamhoc: "+namhoc;
    }
}
