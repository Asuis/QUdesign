package com.asuis.qudesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.asuis.qudesign.home.HomeFragment;
import com.asuis.qudesign.news.NewsFragment;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/*使用QMUI、v-layout、gson、butterknife*/
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    QMUITabSegment mTabSegment;
    private HashMap<Pager, Fragment> mPages;
    private FragmentPagerAdapter addView = new FragmentPagerAdapter(getSupportFragmentManager()) {

        private int mChildCount = 0;

        @Override
        public Fragment getItem(int position) {
            Fragment page = mPages.get(Pager.getPagerFromPositon(position));
            return page;
        }

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public int getItemPosition(Object object) {
            if (mChildCount == 0) {
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }
    };
    private PagerAdapter mPagerAdapter = new PagerAdapter() {

        private int mChildCount = 0;

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        /*添加view*/
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            HomeController page = mPages.get(Pager.getPagerFromPositon(position));
//            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            container.addView(page, params);
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            if (mChildCount == 0) {
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }

        @Override
        public void notifyDataSetChanged() {
            mChildCount = getCount();
            super.notifyDataSetChanged();
        }
    };
    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_gray_6);
        int selectColor = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.home),
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.home_selected),
                "首页", false
        );
        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.all),
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.all_selected),
                "新闻", false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.account),
                ContextCompat.getDrawable(getApplicationContext(), R.mipmap.account_selected),
                "我的", false
        );
        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabs();
        mPages = new HashMap<>();
        mPages.put(Pager.COMPONENT, HomeFragment.newInstance());
        mPages.put(Pager.LAB, NewsFragment.newInstance());
        mPages.put(Pager.UTIL, NewsFragment.newInstance());

        mViewPager.setAdapter(addView);
        mTabSegment.setupWithViewPager(mViewPager, false);
    }
    enum Pager{
        COMPONENT, UTIL, LAB;

        public static Pager getPagerFromPositon(int position) {
            switch (position) {
                case 0:
                    return COMPONENT;
                case 1:
                    return UTIL;
                case 2:
                    return LAB;
                default:
                    return COMPONENT;
            }
        }
    }
}
