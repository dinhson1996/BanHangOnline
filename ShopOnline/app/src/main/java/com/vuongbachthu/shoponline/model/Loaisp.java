package com.vuongbachthu.shoponline.model;

/**
 * Created by vuong_000 on 7/10/2017.
 */

public class Loaisp {
    public int IdLoaiSp;
    public String TenLoaiSp;
    public String AnhLoaiSp;

    public Loaisp(int idLoaiSp, String tenLoaiSp, String anhLoaiSp) {
        IdLoaiSp = idLoaiSp;
        TenLoaiSp = tenLoaiSp;
        AnhLoaiSp = anhLoaiSp;
    }

    public int getIdLoaiSp() {
        return IdLoaiSp;
    }

    public void setIdLoaiSp(int idLoaiSp) {
        IdLoaiSp = idLoaiSp;
    }

    public String getTenLoaiSp() {
        return TenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        TenLoaiSp = tenLoaiSp;
    }

    public String getAnhLoaiSp() {
        return AnhLoaiSp;
    }

    public void setAnhLoaiSp(String anhLoaiSp) {
        AnhLoaiSp = anhLoaiSp;
    }
}
