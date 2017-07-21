package com.vuongbachthu.shoponline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.model.Loaisp;

import java.util.ArrayList;

/**
 * Created by vuong_000 on 7/10/2017.
 */

public class LoaispAdapter extends BaseAdapter {

    ArrayList<Loaisp> arrayListloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListloaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txt_TenLoaisp;
        ImageView img_AnhLoaisp;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_listview_loaisp, null);

            viewHolder.txt_TenLoaisp = (TextView) convertView.findViewById(R.id.txt_tenloaisp);
            viewHolder.img_AnhLoaisp = (ImageView) convertView.findViewById(R.id.img_anhloaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(position);
        viewHolder.txt_TenLoaisp.setText(loaisp.getTenLoaiSp());
        Picasso.with(context).load(loaisp.getAnhLoaiSp())
                .placeholder(R.drawable.ic_noimage)
                .error(R.drawable.ic_error)
                .into(viewHolder.img_AnhLoaisp);

        return convertView;
    }
}
