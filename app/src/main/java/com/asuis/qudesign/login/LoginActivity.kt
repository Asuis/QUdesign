package com.asuis.qudesign.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asuis.qudesign.MainActivity
import com.asuis.qudesign.R
import com.asuis.qudesign.base.Result
import com.asuis.qudesign.net.HttpManager
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        btn_login.setOnClickListener {
            _ -> login(input_user.text.toString(),input_pass.text.toString());
        }
    }
    private fun initView () {
        QMUIStatusBarHelper.translucent(this)
    }
    private fun login(username:String, pwd:String) {
        val api: UserApi = HttpManager.getInstance().userApiService
        val dialog = indeterminateProgressDialog("登陆中...")
        dialog.show()
        api.login(username,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {t: Result<LoginUserResult> ->
                        dialog.cancel()
                        loginHelp(t)
                    },
                    {t: Throwable? -> toast(t.toString()) }
                )
    }
    private fun loginHelp(res:Result<LoginUserResult>) {
        when {
            res.code.equals("200") -> {
                saveUserResult(res.data)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            res.code.equals("404") -> toast("用户名或密码错误")
            else -> toast("未知的错误")
        }
    }
    fun saveUserResult(user:LoginUserResult) {
        val shared: SharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = shared.edit()
        editor.putString("username",user.username)
        editor.putString("avatar",user.avatar)
        editor.putString("token",user.token)
        editor.putString("refreshToken",user.refreshToken)
        editor.commit()
    }
}
