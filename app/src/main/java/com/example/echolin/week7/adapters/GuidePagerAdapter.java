package com.example.echolin.week7.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.echolin.week7.MainActivity;
import com.example.echolin.week7.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by echolin on 2017/5/22.
 */

public class GuidePagerAdapter extends PagerAdapter {

    private List<View> list = new ArrayList<>();

    public GuidePagerAdapter(final Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        list.add(inflater.inflate(R.layout.guide_page1,null));
        list.add(inflater.inflate(R.layout.guide_page2,null));
        View page3 = inflater.inflate(R.layout.guide_page3, null);
        ImageView next_bt = (ImageView) page3.findViewById(R.id.next_bt);
        next_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        });
        list.add(page3);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
