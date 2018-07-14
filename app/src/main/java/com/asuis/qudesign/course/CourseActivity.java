package com.asuis.qudesign.course;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.asuis.qudesign.R;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseActivity extends AppCompatActivity {

    @BindView(R.id.coutseTopBar)
    QMUITopBar topBar;

    @BindView(R.id.rec_course)
    RecyclerView recyclerView;

    private List<ClassItem> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ButterKnife.bind(this);
        initTopBar();
        initData();
        initCourse();
    }
    public void initData() {
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
    public void initTopBar() {
        topBar.addLeftBackImageButton()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        topBar.setTitle("课程表");
        topBar.addRightImageButton(R.mipmap.icon_topbar_overflow,R.id.topbar_right_about_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showSimpleBottomSheetList();
                    }
                });
    }
    public void initCourse() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(8);

        staggeredGridLayoutHelper.setHGap(2);
        staggeredGridLayoutHelper.setVGap(2);
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        recyclerView.setAdapter(delegateAdapter);
        CourseAdapter courseAdapter = new CourseAdapter(this,staggeredGridLayoutHelper,null);
        delegateAdapter.addAdapter(courseAdapter);
        delegateAdapter.notifyDataSetChanged();
    }
    private void showSimpleBottomSheetList() {
        new QMUIBottomSheet.BottomListSheetBuilder(this)
                .addItem("绑定教务系统")
                .addItem("添加课程")
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        dialog.dismiss();
                        Toast.makeText(CourseActivity.this, "Item " + (position + 1), Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }

}