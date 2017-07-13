package com.vuongbachthu.shoponline.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.activity.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 12/07/2017.
 */

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemmHoder> {
    Context context;
    ArrayList<SanPham> arrayListsanpham;

    public SanPhamAdapter(Context context, ArrayList<SanPham> arrayListsanpham) {
        this.context = context;
        this.arrayListsanpham = arrayListsanpham;
    }

    @Override
    public ItemmHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanphammoinhat,null);
        ItemmHoder itemmHoder = new ItemmHoder(v);
        return null;
    }

    @Override
    public void onBindViewHolder(ItemmHoder holder, int position) {
    SanPham sanPham = arrayListsanpham.get(position);
        holder.txttensanpham.setText(sanPham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Gia : " + decimalFormat.format(sanPham.getGiasanpham())+ "VND");
        Picasso.with(context).load(sanPham.getHinhanhsanpham())
                .placeholder(R.drawable.noimages)
                .error(R.drawable.error)
                .into(holder.imageViewhinsanpham);
    }

    @Override
    public int getItemCount() {
        return arrayListsanpham.size();
    }

    public class  ItemmHoder extends RecyclerView.ViewHolder{
        public ImageView imageViewhinsanpham;
        public TextView txttensanpham, txtgiasanpham;

        public ItemmHoder(View itemview){
            super(itemview);
            imageViewhinsanpham = (ImageView) itemview.findViewById(R.id.imgsanpham);
            txtgiasanpham = (TextView)itemview.findViewById(R.id.txtgiasp);
            txttensanpham = (TextView)itemview.findViewById(R.id.txttensanpham);
        }
    }

}
