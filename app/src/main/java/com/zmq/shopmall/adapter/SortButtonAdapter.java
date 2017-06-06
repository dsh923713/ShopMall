package com.zmq.shopmall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.ButtonBean;

import java.util.List;


public class SortButtonAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ButtonBean> data;
    public SortButtonAdapter(Context context, List<ButtonBean> data) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (null == view) {
            view = inflater.inflate(R.layout.gv_item_button, null);
            holder = new ViewHolder();
            holder.icon = (ImageView) view.findViewById(R.id.iv_icon);
            holder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(data.get(position).getName());
        holder.icon.setImageResource(data.get(position).getDrawableIcon());
        return view;
    }
    class ViewHolder {
        ImageView icon;
        TextView name;
    }

}
