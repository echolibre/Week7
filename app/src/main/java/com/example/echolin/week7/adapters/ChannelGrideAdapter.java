package com.example.echolin.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.echolin.week7.R;
import com.example.echolin.week7.beans.Channel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by echolin on 2017/5/23.
 */

public class ChannelGrideAdapter extends BaseAdapter{

    private Context context;
    private List<Channel.ChannelItem> list;
    private LayoutInflater inflater;

    public ChannelGrideAdapter(Context context, List<Channel.ChannelItem> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.frag_channel_gride,parent,false);
            holder.name_tv = (TextView) convertView.findViewById(R.id.name_tv);
            holder.pic_iv = (ImageView) convertView.findViewById(R.id.pic_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Channel.ChannelItem item = list.get(position);
        String catename = item.getCatename();
        String icon = item.getIcon();
        holder.name_tv.setText("#"+catename+"#");
        Picasso.with(context).load(icon).into(holder.pic_iv);
        return convertView;
    }

    class ViewHolder{
        TextView name_tv;
        ImageView pic_iv;
    }
}
