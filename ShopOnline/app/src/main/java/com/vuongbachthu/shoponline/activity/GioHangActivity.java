package com.vuongbachthu.shoponline.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.adapter.GiohangAdapter;
import com.vuongbachthu.shoponline.until.CheckConnection;

import java.text.DecimalFormat;

public class GioHangActivity extends AppCompatActivity {

    ListView lvGiohang;
    TextView txtThongbao;
    static TextView txtTongTien;
    Button btnThanhToan, btnTiepTucMuaHang;
    Toolbar toolbarGionHang;
    GiohangAdapter giohangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        Anhxa();
        ActionToolbar();
        CheckData();
        EvenUltil();
        CatchOnItemListView();
        EventButton();
    }

    private void EventButton() {
        btnTiepTucMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGiohang.size() > 0){
                    Intent intent = new Intent(getApplicationContext(), ThongtinKhachhangActivity.class);
                    startActivity(intent);
                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(), "Giỏ hàng của bạn chưa có sản phẩm đẻ thanh toán");
                }
            }
        });
    }

    private void CatchOnItemListView() {
        lvGiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (MainActivity.mangGiohang.size() <= 0){
                            txtThongbao.setVisibility(View.VISIBLE);
                        }else {
                            MainActivity.mangGiohang.remove(position);
                            giohangAdapter.notifyDataSetChanged();
                            EvenUltil();
                            if (MainActivity.mangGiohang.size() <= 0){
                                txtThongbao.setVisibility(View.VISIBLE);
                            }else {
                                txtThongbao.setVisibility(View.INVISIBLE);
                                giohangAdapter.notifyDataSetChanged();
                                EvenUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        giohangAdapter.notifyDataSetChanged();
                        EvenUltil();
                    }
                });
                builder.show();

                return true;
            }
        });
    }

    public static void EvenUltil() {
        long tongtien = 0;
        for (int i = 0; i < MainActivity.mangGiohang.size(); i++){
            tongtien += MainActivity.mangGiohang.get(i).getGia_sanpham();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongTien.setText(decimalFormat.format(tongtien) + " đ");

    }

    private void CheckData() {
        if (MainActivity.mangGiohang.size() <= 0){
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.VISIBLE);
            lvGiohang.setVisibility(View.INVISIBLE);
        }else {
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.INVISIBLE);
            lvGiohang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarGionHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarGionHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        lvGiohang = (ListView) findViewById(R.id.listview_giohang);
        txtThongbao = (TextView) findViewById(R.id.txt_thongbao_giohang);
        txtTongTien = (TextView) findViewById(R.id.txt_giohang_tongtien);
        btnThanhToan = (Button) findViewById(R.id.btn_thanhtoan_giohang);
        btnTiepTucMuaHang = (Button) findViewById(R.id.btn_tieptuc_muahang_giohang);
        toolbarGionHang = (Toolbar) findViewById(R.id.toolbar_giohang);
        giohangAdapter = new GiohangAdapter(GioHangActivity.this, MainActivity.mangGiohang);
        lvGiohang.setAdapter(giohangAdapter);

    }
}
