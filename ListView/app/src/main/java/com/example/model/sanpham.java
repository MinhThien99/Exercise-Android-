package com.example.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class sanpham implements Serializable {

    private  String tensp;
    private String colorsp;

    public sanpham() {
    }

    public sanpham(String tensp, String colorsp) {
        this.tensp = tensp;
        this.colorsp = colorsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getColorsp() {
        return colorsp;
    }

    public void setColorsp(String colorsp) {
        this.colorsp = colorsp;
    }

    @NonNull
    @Override
    public String toString() {
        return this.tensp + "\n" + this.colorsp;
    }
}
