package com.vuongbachthu.shoponline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.activity.GioHangActivity;
import com.vuongbachthu.shoponline.activity.MainActivity;
import com.vuongbachthu.shoponline.model.Giohang;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by vuong_000 on 7/23/2017.
 */

public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> arrayGiohang;

    public GiohangAdapter(Context context, ArrayList<Giohang> arrayGiohang) {
        this.context = context;
        this.arrayGiohang = arrayGiohang;
    }

    @Override
    public int getCount() {
        return arrayGiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayGiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        public TextView txt_tensanpham_giohang, txt_giasanpham_giohang;
        public ImageView img_anhsanpham_giohang;
        public Button btn_minus_giohang, btn_plus_giohang, btn_values_giohang;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_list_giohang, null);
            viewHolder.txt_tensanpham_giohang = (TextView) convertView.findViewById(R.id.txt_giohang_row_tensanpham);
            viewHolder.txt_giasanpham_giohang = (TextView) convertView.findViewById(R.id.txt_giohang_row_giasanpham);
            viewHolder.img_anhsanpham_giohang = (ImageView) convertView.findViewById(R.id.img_giohang_row_anhsanpham);
            viewHolder.btn_minus_giohang = (Button) convertView.findViewById(R.id.btn_giohang_row_minus);
            viewHolder.btn_plus_giohang = (Button) convertView.findViewById(R.id.btn_giohang_row_plus);
            viewHolder.btn_values_giohang = (Button) convertView.findViewById(R.id.btn_giohang_row_values);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Giohang giohang = (Giohang) getItem(position);
        viewHolder.txt_tensanpham_giohang.setText(giohang.getTen_sanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txt_giasanpham_giohang.setText(decimalFormat.format(giohang.getGia_sanpham()) + " đ");
        Picasso.with(context).load(giohang.getAnh_sanpham())
                .placeholder(R.drawable.ic_noimage)
                .error(R.drawable.ic_error)
                .into(viewHolder.img_anhsanpham_giohang);
        viewHolder.btn_values_giohang.setText(giohang.getSoluong_sanpham() + "");

        int sl = Integer.parseInt(viewHolder.btn_values_giohang.getText().toString());
        if (sl >= 10) {
            viewHolder.btn_plus_giohang.setVisibility(View.INVISIBLE);
            viewHolder.btn_minus_giohang.setVisibility(View.VISIBLE);
        }else if (sl <= 1){
            viewHolder.btn_minus_giohang.setVisibility(View.INVISIBLE);
        }else if (sl >= 1){
            viewHolder.btn_plus_giohang.setVisibility(View.VISIBLE);
            viewHolder.btn_minus_giohang.setVisibility(View.VISIBLE);
        }

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.btn_plus_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(finalViewHolder.btn_values_giohang.getText().toString()) + 1;
                if (slMoiNhat >= 10){
                    slMoiNhat = 10;
                }
                int slHienTai = MainActivity.mangGiohang.get(position).getSoluong_sanpham();
                long giaHienTai = MainActivity.mangGiohang.get(position).getGia_sanpham();
                MainActivity.mangGiohang.get(position).setSoluong_sanpham(slMoiNhat);
                long giaMoiNhat = (giaHienTai * slMoiNhat)/slHienTai;
                MainActivity.mangGiohang.get(position).setGia_sanpham(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txt_giasanpham_giohang.setText(decimalFormat.format(giaMoiNhat) + " đ");
                GioHangActivity.EvenUltil();
                if (slMoiNhat > 9){
                    finalViewHolder.btn_plus_giohang.setVisibility(View.INVISIBLE);
                    finalViewHolder.btn_minus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_values_giohang.setText(String.valueOf(slMoiNhat));
                } else {
                    finalViewHolder.btn_plus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_minus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_values_giohang.setText(String.valueOf(slMoiNhat));
                }
            }
        });
        viewHolder.btn_minus_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(finalViewHolder.btn_values_giohang.getText().toString()) - 1;
                if (slMoiNhat <= 1){
                    slMoiNhat = 1;
                }
                int slHienTai = MainActivity.mangGiohang.get(position).getSoluong_sanpham();
                long giaHienTai = MainActivity.mangGiohang.get(position).getGia_sanpham();
                MainActivity.mangGiohang.get(position).setSoluong_sanpham(slMoiNhat);
                long giaMoiNhat = (giaHienTai * slMoiNhat)/slHienTai;
                MainActivity.mangGiohang.get(position).setGia_sanpham(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txt_giasanpham_giohang.setText(decimalFormat.format(giaMoiNhat) + " đ");
                GioHangActivity.EvenUltil();
                if (slMoiNhat < 2){
                    finalViewHolder.btn_plus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_minus_giohang.setVisibility(View.INVISIBLE);
                    finalViewHolder.btn_values_giohang.setText(String.valueOf(slMoiNhat));
                } else {
                    finalViewHolder.btn_plus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_minus_giohang.setVisibility(View.VISIBLE);
                    finalViewHolder.btn_values_giohang.setText(String.valueOf(slMoiNhat));
                }
            }
        });


        return convertView;
    }
}
