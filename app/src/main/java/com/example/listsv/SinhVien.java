package com.example.listsv;

public class SinhVien {
    public SinhVien(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    private String ten;
    private int tuoi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
