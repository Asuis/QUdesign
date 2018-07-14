package com.asuis.qudesign.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.asuis.qudesign.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 15988440973 on 2018/1/11.
 * desciption:
 */

public class NewsAdapter extends DelegateAdapter.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<GankDataResult.ResultsBean> data;
    private LayoutHelper layoutHelper;

    public NewsAdapter(Context context, List<GankDataResult.ResultsBean> data, LayoutHelper layoutHelper) {
        this.context = context;
        this.data = data;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.layoutHelper;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context)
                .inflate(R.layout.news_fragment_item,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, final int position) {
        final GankDataResult.ResultsBean resultsBean = data.get(position);
        Glide.with(context)
                .load(resultsBean.getImages()!=null?resultsBean.getImages().get(0):null)
                .placeholder(R.mipmap.example_image4)
                .error(R.mipmap.example_image0)
                .centerCrop()
                .into(holder.newsIcon);
        holder.newsTitle.setText(resultsBean.getDesc());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewsDetailsActivity.class);
                intent.putExtra("gank_url",resultsBean.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        CardView cardView;
        ImageView newsIcon;
        TextView newsTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            cardView = itemView.findViewById(R.id.news_card);
            newsIcon = itemView.findViewById(R.id.news_img);
            newsTitle = itemView.findViewById(R.id.news_title);
        }
    }
}
