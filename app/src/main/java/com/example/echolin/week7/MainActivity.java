package com.example.echolin.week7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echolin.week7.adapters.MainPagerAdapter;
import com.example.echolin.week7.fragments.NewestFragment;

public class MainActivity extends AppCompatActivity implements NewestFragment.OnFragmentInteractionListener,ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    private long lastClick;
    private ViewPager mainpager_vp;
    private RadioGroup choice_rg;
    private ImageView user_iv,search_iv,underline_iv;
    private RadioButton newest_rb,channel_rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        choice_rg.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams params = underline_iv.getLayoutParams();
                params.width = newest_rb.getWidth();
                underline_iv.setLayoutParams(params);
            }
        });
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        mainpager_vp.setAdapter(adapter);
    }

    /**
     * 设置监听
     */
    private void initListener() {
        choice_rg.setOnCheckedChangeListener(this);
        user_iv.setOnClickListener(this);
        search_iv.setOnClickListener(this);
        mainpager_vp.addOnPageChangeListener(this);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mainpager_vp = (ViewPager) findViewById(R.id.mainpager_vp);
        choice_rg = (RadioGroup) findViewById(R.id.choice_rg);
        user_iv = (ImageView) findViewById(R.id.user_iv);
        search_iv = (ImageView) findViewById(R.id.search_iv);
        underline_iv = (ImageView) findViewById(R.id.underline_iv);
        newest_rb = (RadioButton) findViewById(R.id.newest_rb);
        channel_rb = (RadioButton) findViewById(R.id.channel_rb);
    }


    /**按两次退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (System.currentTimeMillis() - lastClick >2000){
                Toast.makeText(this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
                lastClick = System.currentTimeMillis();
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**NewestFragment 的回调接口，实现newest_rb中改变text的动画
     * @param date  text要变为的字符串
     * @param isUp  text改变动画的方式
     */
    @Override
    public void onFragmentInteraction(String date, boolean isUp) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator first;
        ObjectAnimator second;
        ObjectAnimator third;
        int distance = newest_rb.getHeight()+30;
        if (isUp){
            first = ObjectAnimator.ofFloat(newest_rb, "translationY", 0, -distance);
            second = ObjectAnimator.ofObject(newest_rb, Property.of(TextView.class, CharSequence.class, "text"), new TypeEvaluator<CharSequence>() {
                @Override
                public CharSequence evaluate(float fraction, CharSequence startValue, CharSequence endValue) {
                    return fraction == 1 ? endValue : startValue;
                }
            }, newest_rb.getText(), date).setDuration(0);
            third = ObjectAnimator.ofFloat(newest_rb,"translationY", distance,0);
        }else{
            first = ObjectAnimator.ofFloat(newest_rb, "translationY", 0, distance);
            second = ObjectAnimator.ofObject(newest_rb, Property.of(TextView.class, CharSequence.class, "text"), new TypeEvaluator<CharSequence>() {
                @Override
                public CharSequence evaluate(float fraction, CharSequence startValue, CharSequence endValue) {
                    return fraction == 1 ? endValue : startValue;
                }
            }, newest_rb.getText(), date).setDuration(0);
            third = ObjectAnimator.ofFloat(newest_rb,"translationY",-distance,0);

        }
        set.playSequentially(first,second,third);
        set.start();
    }

    /**viewpager滑动监听
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ViewCompat.setTranslationX(underline_iv,newest_rb.getWidth()*(position+positionOffset));
    }

    /**viewpager滑动监听
     */
    @Override
    public void onPageSelected(int position) {
        choice_rg.check(choice_rg.getChildAt(position).getId());
    }

    /**viewpager滑动监听
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**RadioGroup选择监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.newest_rb:
                mainpager_vp.setCurrentItem(0);
                break;
            case R.id.channel_rb:
                mainpager_vp.setCurrentItem(1);
                break;
        }
    }

    /**点击监听
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_iv:

                break;
            case R.id.search_iv:

                break;
        }
    }
}
