package com.vuongbachthu.shoponline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.adapter.LoaispAdapter;
import com.vuongbachthu.shoponline.adapter.SanphamAdapter;
import com.vuongbachthu.shoponline.model.Loaisp;
import com.vuongbachthu.shoponline.model.SanPham;
import com.vuongbachthu.shoponline.until.CheckConnection;
import com.vuongbachthu.shoponline.until.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    DrawerLayout drawerLayout;

    // Loai San Pham
    ArrayList<Loaisp> mangLoaisp;
    LoaispAdapter loaispAdapter;
    int id_loaisp = 0;
    String ten_loaisp = "";
    String anh_loaisp = "";

    // San Pham
    ArrayList<SanPham> mangSanPham;
    SanphamAdapter sanphamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
            GetDuLieuSanPhamMoiNhat();
            CatchOnItemlistView();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Lỗi kết nối Internet");
            finish();
        }


    }

    private void CatchOnItemlistView() {
        listViewManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, DienThoaiActivity.class);
                            intent.putExtra("id_loaisp", mangLoaisp.get(position).getIdLoaiSp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, DienThoaiActivity.class);
                            intent.putExtra("id_loaisp", mangLoaisp.get(position).getIdLoaiSp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, LienHeActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
            }
        });
    }

    private void GetDuLieuSanPhamMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.url_sanphammoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int IdSanpham = 0;
                    String TenSanpham = "";
                    Integer GiaSanpham = 0;
                    String AnhSanpham = "";
                    String MotaSanpham = "";
                    int IdLoaiSanpham = 0;

                    for (int i = 0; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            IdSanpham = jsonObject.getInt("id_sanpham");
                            TenSanpham = jsonObject.getString("ten_sanpham");
                            GiaSanpham = jsonObject.getInt("gia_sanpham");
                            AnhSanpham = jsonObject.getString("anh_sanpham");
                            MotaSanpham = jsonObject.getString("mota_sanpham");
                            IdLoaiSanpham = jsonObject.getInt("id_loaisp");

                            mangSanPham.add(new SanPham(IdSanpham, TenSanpham, GiaSanpham, Server.url_img + AnhSanpham, MotaSanpham, IdLoaiSanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuLoaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.urlLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for (int i = 0; i <response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id_loaisp = jsonObject.getInt("id_loaisp");
                            ten_loaisp = jsonObject.getString("ten_loaisp");
                            anh_loaisp = jsonObject.getString("anh_loaisp");

                            mangLoaisp.add(new Loaisp(id_loaisp, ten_loaisp, Server.url_img + anh_loaisp));
                            loaispAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                mangLoaisp.add(3, new Loaisp(0, "Liên hệ", Server.url_img + "/server/image/menu/ic_contact.png"));
                mangLoaisp.add(4, new Loaisp(0, "Thông tin", Server.url_img + "/server/image/menu/ic_info.png"));
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VolleyError: ", error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_sort_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88909_f5f490678df3ae60c2d2375dc0b9d711.jpg");
        mangquangcao.add("https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88904_998b546e6bdc8daebf2422409344ade1.jpg");
        mangquangcao.add("https://tinhte.cdnforo.com/store/2016/09/xengallery_photos_l_71081_c0c4a90e35a857e0f5f2ab6cc3d01882.jpg");
        mangquangcao.add("https://tinhte.cdnforo.com/store/2016/09/xengallery_photos_l_71045_524479327cce608427992e100e8968a9.jpg");
        for (int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);

        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_manhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        recyclerViewManHinhChinh = (RecyclerView) findViewById(R.id.recycler_view);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        listViewManHinhChinh = (ListView) findViewById(R.id.listview_manhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Loai SP
        mangLoaisp = new ArrayList<>();
        mangLoaisp.add(0, new Loaisp(0, "Trang chủ", Server.url_img + "/server/image/menu/ic_home.png"));
        loaispAdapter = new LoaispAdapter(mangLoaisp, getApplicationContext());
        listViewManHinhChinh.setAdapter(loaispAdapter);

        // San pham
        mangSanPham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(), mangSanPham);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        recyclerViewManHinhChinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerViewManHinhChinh.setAdapter(sanphamAdapter);


    }
}
