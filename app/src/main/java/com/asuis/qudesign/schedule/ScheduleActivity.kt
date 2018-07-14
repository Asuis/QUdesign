package com.asuis.qudesign.schedule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.asuis.qudesign.R
import com.asuis.qudesign.db.model.ScheduleItem
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity() {
    private var data:List<ScheduleItem>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        initTopBar()
        initData()

    }
    fun initData() {
        data = listOf(ScheduleItem("12:00","dfjkdf"),ScheduleItem("11:00","dfjkdf"))
    }
    fun initTopBar() {
        scheTopBar.addLeftBackImageButton()
                .setOnClickListener { finish() }
        scheTopBar.setTitle("日程表")
        scheTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_about_button)
                .setOnClickListener { showSimpleBottomSheetList() }
    }
    fun initRec(){
        val vm:VirtualLayoutManager = VirtualLayoutManager(this)
        rec_sche.layoutManager = vm

        val delegateAdapter:DelegateAdapter = DelegateAdapter(vm)
        rec_sche.adapter = delegateAdapter

        val lh:LinearLayoutHelper = LinearLayoutHelper();

        val scheAdapter:ScheAdapter = ScheAdapter(this,lh,data)

        delegateAdapter.addAdapter(scheAdapter)
        delegateAdapter.notifyDataSetChanged()
    }
    private fun showSimpleBottomSheetList() {
        QMUIBottomSheet.BottomListSheetBuilder(this)
                .addItem("添加日程")
                .setOnSheetItemClickListener { dialog, itemView, position, tag ->
                    dialog.dismiss()
                    Toast.makeText(this, "Item " + (position + 1), Toast.LENGTH_SHORT).show()
                }
                .build()
                .show()
    }
}
