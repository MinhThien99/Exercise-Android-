package model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class sinhvien implements Serializable {

    private  int msv;
    private String tên;
    private String sdt;

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public String getTên() {
        return tên;
    }

    public void setTên(String tên) {
        this.tên = tên;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public sinhvien() {
    }

    public sinhvien(int msv, String tên, String sdt) {
        this.msv = msv;
        this.tên = tên;
        this.sdt = sdt;
    }

    @NonNull
    @Override
    public String toString() {
        return this.msv + " - " + this.tên + " - " + this.sdt;
    }
}
