package com.vuongbachthu.shoponline.model;

/**
 * Created by vuong_000 on 7/23/2017.
 */

public class Giohang {
    public int id_sanpham;
    public String ten_sanpham;
    public long gia_sanpham;
    public String anh_sanpham;
    public int soluong_sanpham;

    public Giohang(int id_sanpham, String ten_sanpham, long gia_sanpham, String anh_sanpham, int soluong_sanpham) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.gia_sanpham = gia_sanpham;
        this.anh_sanpham = anh_sanpham;
        this.soluong_sanpham = soluong_sanpham;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public void setTen_sanpham(String ten_sanpham) {
        this.ten_sanpham = ten_sanpham;
    }

    public long getGia_sanpham() {
        return gia_sanpham;
    }

    public void setGia_sanpham(long gia_sanpham) {
        this.gia_sanpham = gia_sanpham;
    }

    public String getAnh_sanpham() {
        return anh_sanpham;
    }

    public void setAnh_sanpham(String anh_sanpham) {
        this.anh_sanpham = anh_sanpham;
    }

    public int getSoluong_sanpham() {
        return soluong_sanpham;
    }

    public void setSoluong_sanpham(int soluong_sanpham) {
        this.soluong_sanpham = soluong_sanpham;
    }
}
