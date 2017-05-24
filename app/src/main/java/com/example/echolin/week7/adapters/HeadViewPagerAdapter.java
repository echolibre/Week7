package com.example.echolin.week7.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by echolin on 2017/5/23.
 */

public class HeadViewPagerAdapter extends PagerAdapter {


    private List<View> list ;

    public HeadViewPagerAdapter(List<View> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position%list.size()));
        return list.get(position%list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%list.size()));
    }
}
