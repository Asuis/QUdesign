package com.asuis.qudesign.news

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.asuis.qudesign.R
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        initWebView()
    }
    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView() {
        QMUIStatusBarHelper.translucent(this)
        topbar.addLeftBackImageButton().setOnClickListener {
            finish()
        }
        val setting =  url_web.settings
        setting.javaScriptEnabled = true
        url_web.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pb_progress.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                pb_progress.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        url_web.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                pb_progress.setProgress(newProgress)
            }

            override fun onReceivedTitle(view: WebView, title: String) {
                collapsing_topbar_layout.title = title
                super.onReceivedTitle(view, title)
            }
        }
        url_web.loadUrl(intent.getStringExtra("gank_url") as String)
    }
}
