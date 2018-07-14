package com.asuis.qudesign.schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.asuis.qudesign.R;
import com.asuis.qudesign.db.model.ScheduleItem;

import java.util.List;

/**
 * Created by 15988440973 on 2018/1/12.
 * desciption:
 */

public class ScheAdapter extends DelegateAdapter.Adapter<ScheAdapter.ViewHolder> {

    private LayoutHelper layoutHelper;
    private List<ScheduleItem> data;
    private Context context;
    public ScheAdapter(Context context,LayoutHelper layoutHelper, List<ScheduleItem> data) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.data = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.layoutHelper;
    }

    @Override
    public ScheAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.sche_item,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ScheAdapter.ViewHolder holder, int position) {
        ScheduleItem item = new ScheduleItem();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.sche_time);
            desc = itemView.findViewById(R.id.sche_desc);
        }
    }
}
