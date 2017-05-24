package com.example.echolin.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.echolin.week7.R;
import com.example.echolin.week7.beans.Newest;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by echolin on 2017/5/23.
 */

public class NewestListAdapter extends BaseAdapter{

    private List<Newest.MovieData> list;
    private LayoutInflater inflater;
    private Context context;

    public NewestListAdapter(Context context,List<Newest.MovieData> list) {
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
            convertView = inflater.inflate(R.layout.frag_newest_list,parent,false);
            holder.info_tv = (TextView) convertView.findViewById(R.id.info_tv);
            holder.title_tv = (TextView) convertView.findViewById(R.id.title_tv);
            holder.pic_iv = (ImageView) convertView.findViewById(R.id.pic_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Newest.MovieData movieData = list.get(position);
        String title = movieData.getTitle();
        String catename = movieData.getCates().get(0).getCatename();
        String duration = movieData.getDuration();
        String image = movieData.getImage();
        int time = Integer.parseInt(duration);
        String minute = String.valueOf(time/60);
        int sec = time%60;
        String second;
        if (sec == 0){
            second = "00";
        }else{
            second = String.valueOf(sec);
        }
//        SimpleDateFormat format = new SimpleDateFormat("mm′ss″");
//        Date date = new Date(time*1000);
//        String s = format.format(date);
        holder.title_tv.setText(title);
        holder.info_tv.setText(catename+" / "+minute+"′"+second+"″");
        Picasso.with(context).load(image).into(holder.pic_iv);
        return convertView;
    }
    class ViewHolder{
        TextView info_tv,title_tv;
        ImageView pic_iv;
    }
}
