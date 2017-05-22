package com.example.echolin.week7;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.echolin.week7.adapters.GuidePagerAdapter;

public class GuideActivity extends AppCompatActivity {

    private ViewPager guide_vp;
    private RadioGroup page_rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        page_rg = (RadioGroup) findViewById(R.id.page_rg);
        GuidePagerAdapter adapter = new GuidePagerAdapter(this);
        guide_vp.setAdapter(adapter);
        guide_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) page_rg.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
