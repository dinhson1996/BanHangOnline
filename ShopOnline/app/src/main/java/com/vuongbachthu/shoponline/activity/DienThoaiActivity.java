package com.vuongbachthu.shoponline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.adapter.DienthoaiAdapter;
import com.vuongbachthu.shoponline.model.SanPham;
import com.vuongbachthu.shoponline.until.CheckConnection;
import com.vuongbachthu.shoponline.until.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DienThoaiActivity extends AppCompatActivity {

    Toolbar toolbar_dienthoai;
    ListView lv_dienthoai;
    DienthoaiAdapter dienthoaiAdapter;
    ArrayList<SanPham> mang_dienthoai;
    int idLoaisp = 0;
    int page = 1;

    // Load more
    View footerview;
    boolean isLoading = false;
    boolean limitData = false;
    mHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thoai);

        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            GetIdLoaiSp();
            ActionToolbar();
            GetData(page);
            LoadMoreData();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Ban hay kiem tra lai Internet");
            finish();
        }


    }

    private void LoadMoreData() {
        lv_dienthoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mang_dienthoai.get(position));
                startActivity(intent);
            }
        });
        lv_dienthoai.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false && limitData == false){
                    isLoading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();

                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = Server.url_sanpham_dienthoai + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id_sanpham_dt = 0;
                String ten_sanpham_dt = "";
                int gia_sanpham_dt = 0;
                String anh_sanpham_dt = "";
                String mota_sanpham_dt = "";
                int id_loaisp_dt = 0;
                if (response != null && response.length() !=2){
                    lv_dienthoai.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i <jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id_sanpham_dt = jsonObject.getInt("id_sanpham");
                            ten_sanpham_dt = jsonObject.getString("ten_sanpham");
                            gia_sanpham_dt = jsonObject.getInt("gia_sanpham");
                            anh_sanpham_dt = jsonObject.getString("anh_sanpham");
                            mota_sanpham_dt = jsonObject.getString("mota_sanpham");
                            id_loaisp_dt = jsonObject.getInt("id_loaisp");

                            mang_dienthoai.add(new SanPham(
                                    id_sanpham_dt,
                                    ten_sanpham_dt,
                                    gia_sanpham_dt,
                                    Server.url_img + anh_sanpham_dt,
                                    mota_sanpham_dt,
                                    id_loaisp_dt)
                            );
                            dienthoaiAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitData = true;
                    lv_dienthoai.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(), "Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR Voley Request: ", error + "");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("id_loaisp", String.valueOf(idLoaisp));

                Log.d("Param Value: ", param + "");
                return param;
            }

        };
        requestQueue.add(stringRequest);

        Log.d("ID Page: ", Page +"");
    }


    private void ActionToolbar() {
        setSupportActionBar(toolbar_dienthoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (idLoaisp == 1){
            toolbar_dienthoai.setTitle("Laptop");
        }else if (idLoaisp == 2){
            toolbar_dienthoai.setTitle("Điện thoại");
        }

        toolbar_dienthoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIdLoaiSp() {
        idLoaisp = getIntent().getIntExtra("id_loaisp", -1);
        Log.d("ID Loai SP ", idLoaisp + "");
    }

    private void AnhXa() {
        toolbar_dienthoai = (Toolbar) findViewById(R.id.toolbar_dienthoai);
        lv_dienthoai = (ListView) findViewById(R.id.listview_dienthoai);
        mang_dienthoai = new ArrayList<>();
        dienthoaiAdapter = new DienthoaiAdapter(getApplicationContext(), mang_dienthoai);
        lv_dienthoai.setAdapter(dienthoaiAdapter);

        // Loadmore
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.footer_view, null);
        mHandler = new mHandler();

    }

    public class mHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lv_dienthoai.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading =false;
                    break;
            }
            super.handleMessage(msg);
        }


    }

    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }


}
