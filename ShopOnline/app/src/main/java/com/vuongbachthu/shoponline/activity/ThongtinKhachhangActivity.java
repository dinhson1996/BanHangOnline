package com.vuongbachthu.shoponline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.until.CheckConnection;
import com.vuongbachthu.shoponline.until.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThongtinKhachhangActivity extends AppCompatActivity {

    EditText edt_tenkhachhang, edt_emailkhachhang, edt_sodienthoaikhachhang;
    Button btn_xacnhan, btn_trove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_khachhang);

        Anhxa();
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
        }
    }

    private void EventButton() {
        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = edt_tenkhachhang.getText().toString().trim();
                final String sdt = edt_sodienthoaikhachhang.getText().toString().trim();
                final String email = edt_emailkhachhang.getText().toString().trim();
                if (ten.length() > 0 && sdt.length() > 0 && email.length() >0){
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.url_donhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String madonhang_res) {
                            Log.d("madonhang ", madonhang_res);
                            if (Integer.parseInt(madonhang_res) > 0){
                                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                                StringRequest request = new StringRequest(Request.Method.POST, Server.url_chitietdonhang, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response.equals("1")){
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn đã thêm dữ liệu giỏ hàng thành công");
                                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Mời bạn tiếp tục mua hàng");
                                        }else {
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Dữ liệu giỏ hàng của bạn đã bị lỗi");
                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }){
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        JSONArray jsonArray = new JSONArray();
                                        for (int i = 0; i < MainActivity.mangGiohang.size(); i++){
                                            JSONObject jsonObject = new JSONObject();
                                            try {
                                                jsonObject.put("id_donhang", madonhang_res);
                                                jsonObject.put("id_sanpham", MainActivity.mangGiohang.get(i).getId_sanpham());
                                                jsonObject.put("ten_sanpham", MainActivity.mangGiohang.get(i).getTen_sanpham());
                                                jsonObject.put("gia_sanpham", MainActivity.mangGiohang.get(i).getGia_sanpham());
                                                jsonObject.put("soluong_sanpham", MainActivity.mangGiohang.get(i).getSoluong_sanpham());

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            jsonArray.put(jsonObject);
                                        }
                                        HashMap<String, String> hashMap = new HashMap<String, String>();
                                        hashMap.put("json", jsonArray.toString());

                                        return hashMap;
                                    }
                                };
                                queue.add(request);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("ten_khachhang", ten);
                            hashMap.put("sodienthoai_khachhang", sdt);
                            hashMap.put("email_khachhang", email);

                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(), "Hãy kiểm tra lại dữ liệu");
                }

            }
        });
    }

    private void Anhxa() {
        edt_tenkhachhang = (EditText) findViewById(R.id.edt_khachhang_ten);
        edt_sodienthoaikhachhang = (EditText) findViewById(R.id.edt_khachhang_sodienthoai);
        edt_emailkhachhang = (EditText) findViewById(R.id.edt_khachhang_email);
        btn_xacnhan = (Button) findViewById(R.id.btn_khachhang_xacnhan);
        btn_trove = (Button) findViewById(R.id.btn_khachhang_trove);
    }
}
