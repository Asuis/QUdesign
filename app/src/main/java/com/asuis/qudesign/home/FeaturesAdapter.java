package com.asuis.qudesign.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.asuis.qudesign.R;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;

import java.util.List;

/**
 * Created by 15988440973 on 2018/1/10.
 * desc:
 */

public class FeaturesAdapter extends DelegateAdapter.Adapter<FeaturesAdapter.ViewHolder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private RecyclerView.LayoutParams layoutParams;
    List<FeatureItem> data;

    public FeaturesAdapter(Context context, LayoutHelper layoutHelper, List<FeatureItem> data) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.fragment_home_feature_item,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeatureItem featureItem = data.get(position);
        holder.iconicsImageView.setIcon(new IconicsDrawable(context)
                .icon(featureItem.getIcons())
                .color(Color.WHITE)
                .sizeDp(24));
        int commonShapeSize = context.getResources().getDimensionPixelSize(R.dimen.drawableHelper_common_shape_size);
        int commonShapeRadius = QMUIDisplayHelper.dp2px(context, 5);
        int color;
        switch (position){
            case 0:
                color = R.color.app_color_theme_5;
                break;
            case 1:
                color = R.color.app_color_theme_2;
                break;
            case 2:
                color = R.color.app_color_theme_3;
                break;
            case 3:
                color = R.color.app_color_theme_4;
                break;
            default:
                color = R.color.app_color_theme_6;
        }
        BitmapDrawable img = QMUIDrawableHelper.createDrawableWithSize(context.getResources(), commonShapeSize, commonShapeSize, commonShapeRadius, ContextCompat.getColor(context, color));
        holder.iconicsImageView.setBackground(img);
        holder.desc.setText(featureItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.layoutHelper;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        IconicsImageView iconicsImageView;
        TextView desc;
        public ViewHolder(View itemView) {
            super(itemView);
            this.iconicsImageView = itemView.findViewById(R.id.feature_img);
            this.desc = itemView.findViewById(R.id.feature_desc);
        }
    }
}