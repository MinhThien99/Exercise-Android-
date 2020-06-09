package example.model;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.AppComponentFactory;

public class sanpham extends AppCompatActivity {
    private String tenSp;
    private Integer giaSp;
    private Integer hinh;

    public sanpham(String tenSp, Integer giaSp, Integer hinh) {
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.hinh = hinh;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaSp(Integer giaSp) {
        this.giaSp = giaSp;
    }

    public void setHinh(Integer hinh) {
        this.hinh = hinh;
    }

    public String getTenSp() {
        return tenSp;
    }

    public Integer getGiaSp() {
        return giaSp;
    }

    public Integer getHinh() {
        return hinh;
    }
}
