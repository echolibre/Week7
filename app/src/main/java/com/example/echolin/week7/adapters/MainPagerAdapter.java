package com.example.echolin.week7.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.echolin.week7.fragments.ChannelFragment;
import com.example.echolin.week7.fragments.NewestFragment;

import java.util.ArrayList;

/**
 * Created by echolin on 2017/5/22.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        list.add(new NewestFragment());
        list.add(new ChannelFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
