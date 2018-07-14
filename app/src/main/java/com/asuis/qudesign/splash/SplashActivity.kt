package com.asuis.qudesign.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.asuis.qudesign.MainActivity
import com.asuis.qudesign.R
import com.asuis.qudesign.login.LoginActivity
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.util.QMUIDrawableHelper
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    private var max = 2;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
        tokenLogin()
    }
    private fun initView() {
        val commonShapeSize = resources.getDimensionPixelSize(R.dimen.drawableHelper_common_shape_size)
        val commonShapeRadius = QMUIDisplayHelper.dp2px(this, 0)
        val img = QMUIDrawableHelper.createDrawableWithSize(resources, commonShapeSize, commonShapeSize, commonShapeRadius, ContextCompat.getColor(this, R.color.app_color_theme_4))
        splash.background = img
        QMUIStatusBarHelper.translucent(this)
    }
    //判断是否登录使用token登录
    private fun tokenLogin() {
        //获取shared preferences
        val shared:SharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
        if (shared.contains("token")) {
            // todo 若存在判断是否登录过期 这里先这样
            val intent = Intent(this,MainActivity::class.java)
            startClock(intent)
        } else {
            val intent = Intent(this,LoginActivity::class.java)
            startClock(intent)
        }
    }
    private fun startClock(intent: Intent) {
        Observable.timer(1,TimeUnit.SECONDS)
                .repeat()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Consumer<Long>{
                    override fun accept(t: Long?) {
                        max--
                        if (max == 0) {
                            startActivity(intent)
                            finish()
                        }
                    }
                })
    }
}
