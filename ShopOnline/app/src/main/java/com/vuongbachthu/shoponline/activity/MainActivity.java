package com.vuongbachthu.shoponline.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.support.v7.widget.GridLayoutManager;
=======
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
<<<<<<< HEAD
import com.vuongbachthu.shoponline.activity.adapter.LoaispAdapter;
import com.vuongbachthu.shoponline.activity.adapter.SanPhamAdapter;
import com.vuongbachthu.shoponline.activity.model.LoaiSP;
import com.vuongbachthu.shoponline.activity.model.SanPham;
import com.vuongbachthu.shoponline.activity.ultil.CheckCollection;
import com.vuongbachthu.shoponline.activity.ultil.Server;
=======
import com.vuongbachthu.shoponline.adapter.LoaispAdapter;
import com.vuongbachthu.shoponline.model.Loaisp;
import com.vuongbachthu.shoponline.until.CheckConnection;
import com.vuongbachthu.shoponline.until.Server;
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001

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
    ArrayList<LoaiSP> mangloaisp;
    LoaispAdapter loaispAdapter;
    int id =0;
    String tenloaisp = "";
    String hinhanhloaisp = "";
    ArrayList<SanPham> mangsp;
    SanPhamAdapter sanPhamAdapter;

    ArrayList<Loaisp> arrayLoaisp;
    LoaispAdapter loaispAdapter;
    int id_loaisp = 0;
    String ten_loaisp = "";
    String anh_loaisp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        Anhxa();
      if(CheckCollection.haveNetWorkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaiSp();
            GetDuLieuSpMoiNhat();
        }else{
            CheckCollection.ShowToast_Short(getApplicationContext(),"bạn hãy kiểm tra lại kết nối");
            finish();
        }

    }

    private void GetDuLieuSpMoiNhat() {
    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansanphammoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if(response != null){
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for (int i = 0 ; i<response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("tensp");
                            Giasanpham = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motasp");
                            IDsanpham = jsonObject.getInt("idsanpham");

                            mangsp.add(new SanPham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham));
                            sanPhamAdapter.notifyDataSetChanged();

=======
        Initially();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            //ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Ban hay kiem tra lai ket noi");
            finish();
        }
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

                            arrayLoaisp.add(new Loaisp(id_loaisp, ten_loaisp, anh_loaisp));
                            loaispAdapter.notifyDataSetChanged();

>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
<<<<<<< HEAD
                }

=======
                    arrayLoaisp.add(3, new Loaisp(0, "Lien he", "https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88909_f5f490678df3ae60c2d2375dc0b9d711.jpg"));
                    arrayLoaisp.add(4, new Loaisp(0, "Thong tin", "https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88909_f5f490678df3ae60c2d2375dc0b9d711.jpg"));
                }
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
<<<<<<< HEAD

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void GetDuLieuLoaiSp() {
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArray = new JsonArrayRequest(Server.DuongdanLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            if(response != null){
                for(int i= 0; i<response.length();i++){
                    try {
                        JSONObject jsonobject = response.getJSONObject(i);
                        id = jsonobject.getInt("id");
                        tenloaisp=jsonobject.getString("tenloaisp");
                        hinhanhloaisp = jsonobject.getString("hinhanhloaisp");
                        mangloaisp.add(new LoaiSP(id,tenloaisp,hinhanhloaisp));
                        loaispAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mangloaisp.add(3, new LoaiSP(0,"Liên Hệ","http://findicons.com/files/icons/1580/devine_icons_part_2/128/home.png"));
                mangloaisp.add(4, new LoaiSP(0,"Thông Tin","http://findicons.com/files/icons/1580/devine_icons_part_2/128/home.png"));
            }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckCollection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        request.add(jsonArray);
=======
                CheckConnection.ShowToast_Short(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88909_f5f490678df3ae60c2d2375dc0b9d711.jpg");
        mangquangcao.add("https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88904_998b546e6bdc8daebf2422409344ade1.jpg");
        mangquangcao.add("https:/k/tinhte.cdnforo.com/store/2016/09/xengallery_photos_l_71081_c0c4a90e35a857e0f5f2ab6cc3d01882.jpg");
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

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Initially() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_manhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        recyclerViewManHinhChinh = (RecyclerView) findViewById(R.id.recycler_view);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        listViewManHinhChinh = (ListView) findViewById(R.id.listview_manhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
<<<<<<< HEAD
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0,new LoaiSP(0,"Trang Chủ","http://findicons.com/files/icons/1580/devine_icons_part_2/128/home.png"));
        loaispAdapter= new LoaispAdapter(mangloaisp,getApplicationContext());
        listViewManHinhChinh.setAdapter(loaispAdapter);
        mangsp =  new ArrayList<>();

        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),mangsp);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        recyclerViewManHinhChinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewManHinhChinh.setAdapter(sanPhamAdapter);
=======
        arrayLoaisp = new ArrayList<>();
        arrayLoaisp.add(0, new Loaisp(0, "Trang chu", "https://tinhte.cdnforo.com/store/2017/04/xengallery_photos_l_88909_f5f490678df3ae60c2d2375dc0b9d711.jpg"));

        loaispAdapter = new LoaispAdapter(arrayLoaisp, getApplicationContext());
        listViewManHinhChinh.setAdapter(loaispAdapter);
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001

    }
}
