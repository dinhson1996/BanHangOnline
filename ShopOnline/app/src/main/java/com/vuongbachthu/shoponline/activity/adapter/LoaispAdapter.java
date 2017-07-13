package com.vuongbachthu.shoponline.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.activity.model.LoaiSP;

import java.util.ArrayList;

/**
 * Created by Administrator on 12/07/2017.
 */

public class LoaispAdapter extends BaseAdapter {
    ArrayList<LoaiSP> arrayListloaisp;
    Context context;

    public LoaispAdapter(ArrayList<LoaiSP> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHoder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHoder viewHoder = null;
        if(view == null){
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lisview_loaisp,null);
            viewHoder.txttenloaisp = (TextView)view.findViewById(R.id.txtloaisp);
            viewHoder.imgloaisp = (ImageView)view.findViewById(R.id.imgviewloaisp);
            view.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder)view.getTag();
        }
        LoaiSP loaisp = (LoaiSP) getItem(i);
        viewHoder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.noimages)
                .error(R.drawable.error)
                .into(viewHoder.imgloaisp);
        return view;
    }
}
