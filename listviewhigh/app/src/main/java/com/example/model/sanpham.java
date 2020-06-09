package com.example.model;

import java.io.Serializable;

public class sanpham implements Serializable {
    private int imageid;
    private  String ten;
    private double gia;

    public sanpham() {

    }

    public sanpham(int imageid, String ten, double gia) {
        this.imageid = imageid;
        this.ten = ten;
        this.gia = gia;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
