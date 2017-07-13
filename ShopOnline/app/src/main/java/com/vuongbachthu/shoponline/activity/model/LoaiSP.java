package com.vuongbachthu.shoponline.activity.model;

/**
 * Created by Administrator on 12/07/2017.
 */

public class LoaiSP {
    public int id;
    public String tenloaisp;
    public String hinhanhloaisp;

    public LoaiSP(int id, String tenloaisp, String hinhanhloaisp) {
        this.id = id;
        this.tenloaisp = tenloaisp;
        this.hinhanhloaisp = hinhanhloaisp;
    }

    public int getId() {
        return id;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public String getHinhanhloaisp() {
        return hinhanhloaisp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        this.hinhanhloaisp = hinhanhloaisp;
    }
}
