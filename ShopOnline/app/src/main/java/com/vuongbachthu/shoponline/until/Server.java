package com.vuongbachthu.shoponline.until;

/**
 * Created by vuong_000 on 7/11/2017.
 */

public class Server {
    public static String localhost = "192.168.1.86:8080";
    public static String urlLoaisp = "http://" + localhost + "/server/main/getloaisp.php";
    public static String url_img = "http://" + localhost;
    public static String url_sanphammoinhat = "http://" + localhost + "/server/main/getsanphammoinhat.php";

    // List Dien Thoai
    public static String url_sanpham_dienthoai = "http://" + localhost + "/server/main/getsanpham.php?page=";
    public static String url_donhang = "http://" + localhost + "/server/main/thongtinkhachhang.php";
    public static String url_chitietdonhang = "http://" + localhost + "/server/main/chitietdonhang.php";


}
