package com.asuis.qudesign.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.asuis.qudesign.R;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIFloatLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * 主页 先是横向的rec，然后使用vlayout 网格布局 添加单栏布局 添加按钮 然后是当前日程
 * 按钮编辑页 选中的按钮加入数据库
 * 新闻页 使用viewpager的配合gankApi使用
 * 会话页 目前显示官方推送
 * 课程表页 右上角 点击进入绑定页面
 * 使用viewpager分页显示日程表
 * 支持添加、修改日程 远程同步 添加系统推送
 * 任务卡片
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.reCarouse)
    RecyclerView recyclerView;
    @BindView(R.id.features)
    QMUIFloatLayout floatLayout;
    @BindView(R.id.banner)
    Banner banner;

    List<FeatureItem> featureItems;

    RecyclerView mRecyclerView;
    LinearLayoutManager mPagerLayoutManager;
    QDRecyclerViewAdapter mRecyclerViewAdapter;
    SnapHelper mSnapHelper;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
//        QMUIStatusBarHelper.translucent(getActivity());
        initBanner();
        initFeatures();

//        floatLayout.setGravity(Gravity.CENTER_HORIZONTAL);
//        for (int i=0;i<8;i++) {
//            initMainFeatures();
//        }
        return view;
    }
    public void initTopBar(){
//        topBar.setTitle("hello");
//        topBar.addLeftBackImageButton();
    }
    public void initBanner(){
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.banner_1);
        images.add(R.drawable.banner_2);
        banner.setImages(images);

        //banner设置方法全部调用完毕时最后调用

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        banner.start();
    }
    public void initFeatures() {

        featureItems = new ArrayList<>();
        FeatureItem featureItem1 = new FeatureItem();
        featureItem1.setIcons("gmd-ac-unit");
        featureItem1.setDesc("hello");

        FeatureItem featureItem2 = new FeatureItem();
        featureItem2.setIcons("gmd-adb");
        featureItem2.setDesc("adb");

        FeatureItem featureItem3 = new FeatureItem();
        featureItem3.setIcons("gmd-assignment");
        featureItem3.setDesc("hello");

        FeatureItem featureItem4 = new FeatureItem();
        featureItem4.setIcons("gmd-dvr");
        featureItem4.setDesc("faw_th");

        featureItems.add(featureItem1);
        featureItems.add(featureItem2);
        featureItems.add(featureItem3);
        featureItems.add(featureItem4);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        recyclerView.setLayoutManager(virtualLayoutManager);
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setAutoExpand(false);
        FeaturesAdapter featuresAdapter = new FeaturesAdapter(getContext(),gridLayoutHelper,featureItems);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);

        recyclerView.setAdapter(delegateAdapter);

        delegateAdapter.addAdapter(featuresAdapter);

        delegateAdapter.notifyDataSetChanged();
    }
    public void initMainFeatures () {

        View root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_feature_item,null);
        IconicsImageView imageView = root.findViewById(R.id.feature_img);
        TextView desc = root.findViewById(R.id.feature_desc);
        imageView.setIcon(new IconicsDrawable(getContext()));
        desc.setText("hello");
        int currentChildCount = floatLayout.getChildCount();

        floatLayout.addView(root);
    }
    private void addFloatLayout(){
        int currentChildCount = floatLayout.getChildCount();

        TextView textView = new TextView(getActivity());
        int textViewPadding = QMUIDisplayHelper.dp2px(getContext(), 4);
        textView.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.qmui_config_color_white));
        textView.setText(String.valueOf(currentChildCount));
        textView.setBackgroundResource(currentChildCount % 2 == 0 ? R.color.app_color_theme_3 : R.color.app_color_theme_6);

        int textViewSize = QMUIDisplayHelper.dpToPx(60);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(textViewSize, textViewSize);
        floatLayout.addView(textView, lp);
    }
}