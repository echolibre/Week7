package com.example.echolin.week7.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.echolin.week7.R;
import com.example.echolin.week7.adapters.HeadViewPagerAdapter;
import com.example.echolin.week7.adapters.NewestListAdapter;
import com.example.echolin.week7.beans.Configs;
import com.example.echolin.week7.beans.HeadView;
import com.example.echolin.week7.beans.Newest;
import com.example.echolin.week7.utils.DownloadUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewestFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NewestFragment extends Fragment implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener {

    private OnFragmentInteractionListener mListener;
    private ListView list_lv;
    private List<Newest.MovieData> list = new ArrayList<>();
    private List<View> pagerList = new ArrayList<>();
    private int page = 1;
    private String newestURL = Configs.HOST+Configs.MAIN_MOVIE+"?p=";
    private String pagerURL = Configs.HOST+Configs.MAIN_PAGER;
    private NewestListAdapter adapter;
    private DownloadUtil.InfoCallBack<Newest> infoCallBack;
    private ViewPager pager_vp;
    private int index;
    private RadioGroup slid_rg;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            index++;
            pager_vp.setCurrentItem(index);
            sendEmptyMessageDelayed(0,5000);
        }
    };

    public NewestFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newest, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_lv = (ListView) view.findViewById(R.id.newList_lv);
        adapter = new NewestListAdapter(getContext(),list);
        list_lv.setAdapter(adapter);
        infoCallBack = new DownloadUtil.InfoCallBack<Newest>() {
            @Override
            public void callBack(Newest newest) {
                List<Newest.MovieData> data = newest.getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }
        };
        new DownloadUtil<>(infoCallBack).execute(newestURL+page);
        list_lv.setOnScrollListener(this);
        list_lv.setOnItemClickListener(this);
        final View headView = LayoutInflater.from(getContext()).inflate(R.layout.newest_list_head, null);
        pager_vp = (ViewPager)headView.findViewById(R.id.pager_vp);
        slid_rg = (RadioGroup) headView.findViewById(R.id.slid_rg);
        pager_vp.addOnPageChangeListener(this);
        new DownloadUtil<>(new DownloadUtil.InfoCallBack<HeadView>() {

            @Override
            public void callBack(HeadView view) {
                List<HeadView.DataBean> data = view.getData();

                RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT);
                params.leftMargin = 8;
                params.rightMargin = 8;
                for (int i = 0; i < data.size(); i++) {
                    ImageView iv = new ImageView(getContext());
                    iv.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getContext()).load(data.get(i).getImage()).into(iv);
                    pagerList.add(iv);
                    RadioButton rb = new RadioButton(getContext());
                    rb.setButtonDrawable(R.drawable.newest_head_selector);
                    rb.setLayoutParams(params);
                    slid_rg.addView(rb);
                }
                HeadViewPagerAdapter adapter = new HeadViewPagerAdapter(pagerList);
                pager_vp.setAdapter(adapter);
                index = Integer.MAX_VALUE/2-((Integer.MAX_VALUE/2)%pagerList.size());
                pager_vp.setCurrentItem(index);
                slid_rg.check(slid_rg.getChildAt(index%pagerList.size()).getId());
                list_lv.addHeaderView(headView);
                handler.sendEmptyMessageDelayed(0,5000);
            }
        }).execute(pagerURL);
    }


    /**ListView滑动监听
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    /**ListView滑动监听
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount){
//            list_lv.addView();
            page++;
            new DownloadUtil<>(infoCallBack).execute(newestURL+page);
        }
    }

    /**ListView点击监听
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**ViewPager滑动监听
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**ViewPager滑动监听
     */
    @Override
    public void onPageSelected(int position) {
        index = position;
        slid_rg.check(slid_rg.getChildAt(index%pagerList.size()).getId());
    }

    /**ViewPager滑动监听
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String date,boolean isUp);
    }
}
