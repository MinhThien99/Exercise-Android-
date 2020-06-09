package com.example.model;

public class SanPham {
    public SanPham(int hinh, String tenSP, long gia) {
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public SanPham(int beer333) {
    }

    public int getHinh() {
        return hinh;
    }


    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    private  int hinh;
    private  String tenSP;
    private  long gia;

}
