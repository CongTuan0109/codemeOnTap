package com.example.listsv;

import java.util.ArrayList;

public class ArraylistSV {
    ArrayList<SinhVien> dssv=new ArrayList<>();
    public ArraylistSV() {

    }
    public void addSinhVien(SinhVien sv)
    {
        dssv.add(sv);
    }

    public ArrayList<SinhVien> LayDSSV(){

        for(int i=0;i<10;i++){
            dssv.add(new SinhVien("tuan",i));
        }
        return dssv;
    }
}
