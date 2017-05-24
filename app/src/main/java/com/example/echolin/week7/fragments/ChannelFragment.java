package com.example.echolin.week7.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.echolin.week7.R;
import com.example.echolin.week7.adapters.ChannelGrideAdapter;
import com.example.echolin.week7.beans.Channel;
import com.example.echolin.week7.beans.Configs;
import com.example.echolin.week7.utils.DownloadUtil;

import java.util.ArrayList;
import java.util.List;


public class ChannelFragment extends Fragment implements DownloadUtil.InfoCallBack<Channel>, AdapterView.OnItemClickListener {

    private List<Channel.ChannelItem> list = new ArrayList<>();
    private GridView channel_gv;
    private ChannelGrideAdapter adapter;
    private String channelURL = Configs.HOST+Configs.MAIN_CHANNEL;

    public ChannelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        channel_gv = (GridView)view.findViewById(R.id.channel_gv);
        adapter = new ChannelGrideAdapter(getContext(),list);
        channel_gv.setAdapter(adapter);
        channel_gv.setOnItemClickListener(this);
        new DownloadUtil<>(this).execute(channelURL);
    }

    @Override
    public void callBack(Channel channel) {
        List<Channel.ChannelItem> data = channel.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
