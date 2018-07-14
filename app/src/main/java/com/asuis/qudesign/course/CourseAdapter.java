package com.asuis.qudesign.course;

import android.content.Context;
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
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15988440973 on 2018/1/9.
 * desciption:
 */

public class CourseAdapter  extends DelegateAdapter.Adapter<CourseAdapter.ViewHolder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private RecyclerView.LayoutParams layoutParams;
    private List<ClassItem> data;

    public CourseAdapter(Context context, LayoutHelper layoutHelper, RecyclerView.LayoutParams layoutParams) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.layoutParams = layoutParams;
        this.data = data;

        data = new ArrayList<>();
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("一",1));
        this.data.add(new ClassItem("二",1));
        this.data.add(new ClassItem("三",1));
        this.data.add(new ClassItem("四",1));
        this.data.add(new ClassItem("五",1));
        this.data.add(new ClassItem("六",1));
        this.data.add(new ClassItem("七",1));

        this.data.add(new ClassItem("1",1));
        this.data.add(new ClassItem("英语",2));
        this.data.add(new ClassItem("体育",2));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("思想道德与法律",2));
        this.data.add(new ClassItem("android高级应用开发",2));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));

        this.data.add(new ClassItem("2",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));

        this.data.add(new ClassItem("3",1));
        this.data.add(new ClassItem("Java EE程序设计周一第3,4,5节{第1-17周}唐红军6jxB406",3));
        this.data.add(new ClassItem("Html5移动开发" +
                "周二第3,4,5节{第1-17周}" +
                "叶岩明" +
                "6jxD306",3));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("Android高级应用开发\n" +
                "周四第3,4节{第1-17周}\n" +
                "胡昔祥\n" +
                "6jxB309",2));
        this.data.add(new ClassItem("数据结构课程实践\n" +
                "周五第3,4,5节{第1-17周}\n" +
                "任雪萍\n" +
                "6jxB102",3));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));

        this.data.add(new ClassItem("4",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("5",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
        this.data.add(new ClassItem("",1));
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.layoutHelper;
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.course_item,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CourseAdapter.ViewHolder holder, int position) {
        ClassItem classItem = data.get(position);
        String text = classItem.getData();
        if (text.length()>10) {
            text = text.substring(0,10);
        }
        holder.desc.setText(text);
        if (position%2==0){
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,150*classItem.getRow()+5*(classItem.getRow()-1));
            holder.root.setLayoutParams(layoutParams);
//            holder.root.setBackgroundColor(Color.RED);
            int commonShapeSize = context.getResources().getDimensionPixelSize(R.dimen.drawableHelper_common_shape_size);
            int commonShapeRadius = QMUIDisplayHelper.dp2px(context, 3);
            BitmapDrawable img = QMUIDrawableHelper.createDrawableWithSize(context.getResources(), commonShapeSize, commonShapeSize, commonShapeRadius, ContextCompat.getColor(context, R.color.app_color_theme_3));
            holder.root.setBackground(img);
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,150*classItem.getRow()+5*(classItem.getRow()-1));
            holder.root.setLayoutParams(layoutParams);
            int commonShapeSize = context.getResources().getDimensionPixelSize(R.dimen.drawableHelper_common_shape_size);
            int commonShapeRadius = QMUIDisplayHelper.dp2px(context, 10);
            BitmapDrawable img = QMUIDrawableHelper.createDrawableWithSize(context.getResources(), commonShapeSize, commonShapeSize, commonShapeRadius, ContextCompat.getColor(context, R.color.app_color_theme_4));
            holder.root.setBackground(img);
        }
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView desc;

        ViewHolder(View itemView) {
            super(itemView);
            this.root = itemView;
            this.desc = itemView.findViewById(R.id.less_msg);
        }
    }
}
