package com.vuongbachthu.shoponline.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.activity.ChiTietSanPhamActivity;
import com.vuongbachthu.shoponline.model.SanPham;
import com.vuongbachthu.shoponline.until.CheckConnection;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by vuong_000 on 7/15/2017.
 */

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {

    Context context;
    ArrayList<SanPham> arraySanpham;

    public SanphamAdapter(Context context, ArrayList<SanPham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sanpham_moinhat, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int i) {
        SanPham sanpham = arraySanpham.get(i);
        holder.txt_tensanpham.setText(sanpham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txt_giasanpham.setText("Giá : " + decimalFormat.format(sanpham.getGiaSanPham()) + " Đ");
        Picasso.with(context).load(sanpham.getAnhSanPham())
                .placeholder(R.drawable.ic_noimage)
                .error(R.drawable.ic_error)
                .into(holder.img_anhsanpham);

    }

    @Override
    public int getItemCount() {
        return arraySanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView img_anhsanpham;
        public TextView txt_tensanpham;
        public TextView txt_giasanpham;

        public ItemHolder(View itemView) {
            super(itemView);
            img_anhsanpham = (ImageView) itemView.findViewById(R.id.img_view_tensanpham_moi);
            txt_tensanpham = (TextView) itemView.findViewById(R.id.txt_view_sanpham_moi);
            txt_giasanpham = (TextView) itemView.findViewById(R.id.txt_view_giasanpham_moi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                    intent.putExtra("thongtinsanpham", arraySanpham.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CheckConnection.ShowToast_Short(context, arraySanpham.get(getPosition()).getTenSanPham());
                    context.startActivity(intent);
                }
            });

        }
    }
}
