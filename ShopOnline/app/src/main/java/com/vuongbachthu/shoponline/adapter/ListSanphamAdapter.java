package com.vuongbachthu.shoponline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vuongbachthu.shoponline.R;
import com.vuongbachthu.shoponline.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by vuong_000 on 7/21/2017.
 */

public class ListSanphamAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayDienThoai;

    public ListSanphamAdapter(Context context, ArrayList<SanPham> arrayDienThoai) {
        this.context = context;
        this.arrayDienThoai = arrayDienThoai;
    }

    @Override
    public int getCount() {
        return arrayDienThoai.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayDienThoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        public TextView txt_TenDienthoai, txt_GiaDienthoai, txt_MotaDienthoai;
        public ImageView img_AnhDienthoai;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_list_sanpham, null);

            viewHolder.txt_TenDienthoai = (TextView) convertView.findViewById(R.id.txt_ten_dienthoai);
            viewHolder.txt_GiaDienthoai = (TextView) convertView.findViewById(R.id.txt_gia_dienthoai);
            viewHolder.txt_MotaDienthoai = (TextView) convertView.findViewById(R.id.txt_mota_dienthoai);
            viewHolder.img_AnhDienthoai = (ImageView) convertView.findViewById(R.id.img_dienthoai);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SanPham sanpham = (SanPham) getItem(position);
        viewHolder.txt_TenDienthoai.setText(sanpham.getTenSanPham());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txt_GiaDienthoai.setText("Giá : " + decimalFormat.format(sanpham.getGiaSanPham()) + " đ");

        viewHolder.txt_MotaDienthoai.setMaxLines(2);
        viewHolder.txt_MotaDienthoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txt_MotaDienthoai.setText(sanpham.getMoTaSanPham());

        Picasso.with(context).load(sanpham.getAnhSanPham())
                .placeholder(R.drawable.ic_noimage)
                .error(R.drawable.ic_error)
                .into(viewHolder.img_AnhDienthoai);
        return convertView;
    }
}
