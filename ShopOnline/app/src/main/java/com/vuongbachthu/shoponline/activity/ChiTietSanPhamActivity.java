package com.vuongbachthu.shoponline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.model.Giohang;
import com.vuongbachthu.shoponline.model.SanPham;

import java.text.DecimalFormat;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    Toolbar toolbar_ChitietSanpham;
    ImageView img_ChitietSanpham;
    TextView txt_TenSanpham, txt_GiaSanpham, txt_MotaSanpham;
    Spinner spinner_SoluongMua;
    Button btn_ThemGioHang;

    // San pham
    int id_sanpham_ct = 0;
    String ten_sanpham_ct = "";
    int gia_sanpham_ct = 0;
    String anh_sanpham_ct = "";
    String mota_sanpham_ct = "";
    int id_loaisp_ct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);

        Anhxa();
        ActionToolbar();
        GetInformation();
        CatchEventSpinner();
        EventButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_giohang:
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void EventButton() {
        btn_ThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGiohang.size() > 0){
                    int sl = Integer.parseInt(spinner_SoluongMua.getSelectedItem().toString());
                    boolean exists = false;
                    for (int i = 0; i < MainActivity.mangGiohang.size(); i++){
                        if (MainActivity.mangGiohang.get(i).getId_sanpham() == id_sanpham_ct){
                            MainActivity.mangGiohang.get(i).setSoluong_sanpham(MainActivity.mangGiohang.get(i).getSoluong_sanpham() + sl);
                            if (MainActivity.mangGiohang.get(i).getSoluong_sanpham() >= 9){
                                MainActivity.mangGiohang.get(i).setSoluong_sanpham(10);
                            }else if (MainActivity.mangGiohang.get(i).getSoluong_sanpham() <=0){
                                MainActivity.mangGiohang.get(i).setSoluong_sanpham(1);
                            }
                            MainActivity.mangGiohang.get(i).setGia_sanpham(gia_sanpham_ct * MainActivity.mangGiohang.get(i).getSoluong_sanpham());
                            exists = true;
                        }
                    }
                    if (exists == false){
                        int soluong = Integer.parseInt(spinner_SoluongMua.getSelectedItem().toString());
                        long giamoi = soluong * gia_sanpham_ct;
                        MainActivity.mangGiohang.add(new Giohang(id_sanpham_ct, ten_sanpham_ct, giamoi, anh_sanpham_ct, soluong));
                    }

                }else {
                    int soluong = Integer.parseInt(spinner_SoluongMua.getSelectedItem().toString());
                    long giamoi = soluong * gia_sanpham_ct;
                    MainActivity.mangGiohang.add(new Giohang(id_sanpham_ct, ten_sanpham_ct, giamoi, anh_sanpham_ct, soluong));
                }
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapterSpinner = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner_SoluongMua.setAdapter(arrayAdapterSpinner);
    }

    private void GetInformation() {

        SanPham sanpham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
        id_sanpham_ct = sanpham.getIdSanPham();
        ten_sanpham_ct = sanpham.getTenSanPham();
        gia_sanpham_ct = sanpham.getGiaSanPham();
        anh_sanpham_ct = sanpham.getAnhSanPham();
        mota_sanpham_ct = sanpham.getMoTaSanPham();
        id_loaisp_ct = sanpham.getIdLoaiSanPham();

        txt_TenSanpham.setText(ten_sanpham_ct);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txt_GiaSanpham.setText("Giá: " + decimalFormat.format(gia_sanpham_ct) + " đ");
        txt_MotaSanpham.setText(mota_sanpham_ct);
        Picasso.with(getApplicationContext()).load(anh_sanpham_ct)
                .placeholder(R.drawable.ic_noimage)
                .error(R.drawable.ic_error)
                .into(img_ChitietSanpham);


    }

    private void ActionToolbar() {
        setSupportActionBar(toolbar_ChitietSanpham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_ChitietSanpham.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void Anhxa() {
        toolbar_ChitietSanpham = (Toolbar) findViewById(R.id.toolbar_chitiet_sanpham);
        img_ChitietSanpham = (ImageView) findViewById(R.id.img_chitiet_sanpham);
        txt_TenSanpham = (TextView) findViewById(R.id.txt_ten_chitiet_sanpham);
        txt_GiaSanpham = (TextView) findViewById(R.id.txt_gia_chitiet_sanpham);
        txt_MotaSanpham = (TextView) findViewById(R.id.txt_mota_chitiet_sanpham);
        spinner_SoluongMua = (Spinner) findViewById(R.id.spinner_soluong_chitiet_sanpham);
        btn_ThemGioHang = (Button) findViewById(R.id.btn_themgiohang_chitiet_sanpham);
    }
}
