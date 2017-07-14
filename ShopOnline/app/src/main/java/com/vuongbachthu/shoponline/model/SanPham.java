package com.vuongbachthu.shoponline.model;

/**
 * Created by vuong_000 on 7/15/2017.
 */

public class SanPham {
    public int IdSanPham;
    public String TenSanPham;
    public Integer GiaSanPham;
    public String AnhSanPham;
    public String MoTaSanPham;
    public int IdLoaiSanPham;

    public SanPham(int idSanPham, String tenSanPham, Integer giaSanPham, String anhSanPham, String moTaSanPham, int idLoaiSanPham) {
        IdSanPham = idSanPham;
        TenSanPham = tenSanPham;
        GiaSanPham = giaSanPham;
        AnhSanPham = anhSanPham;
        MoTaSanPham = moTaSanPham;
        IdLoaiSanPham = idLoaiSanPham;
    }

    public int getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        IdSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public Integer getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(Integer giaSanPham) {
        GiaSanPham = giaSanPham;
    }

    public String getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        AnhSanPham = anhSanPham;
    }

    public String getMoTaSanPham() {
        return MoTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        MoTaSanPham = moTaSanPham;
    }

    public int getIdLoaiSanPham() {
        return IdLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        IdLoaiSanPham = idLoaiSanPham;
    }
}
