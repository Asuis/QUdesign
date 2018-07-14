package com.asuis.qudesign.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asuis.qudesign.R
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.Bundler
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.qmuiteam.qmui.widget.QMUITopBar
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment() {

    var topBar: QMUITopBar? = null
    var tabBar: SmartTabLayout? = null
    var viewPager:ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root:View = inflater!!.inflate(R.layout.fragment_news, container, false)
        topBar = root.new_top_bar
        tabBar = root.news_tab
        viewPager = root.news_detail
        initTitleBar()
        initTabBar()
        initNewsDetailFragments()
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }
    private fun initTitleBar() {

        topBar!!.setTitle("News")
    }
    private fun initTabBar () {

    }
    private fun initNewsDetailFragments() {
//        val fragment1:NewsDetailsFragment = NewsDetailsFragment.newInstance("Android")
//        val fragment2:NewsDetailsFragment = NewsDetailsFragment.newInstance("ios")
//        val fragments:List<NewsDetailsFragment> = listOf(fragment1,fragment2)
//        val viewPagerAdapter = ViewPagerAdapter(fragmentManager,fragments)
        val adapter = FragmentPagerItemAdapter(
                fragmentManager, FragmentPagerItems.with(context)
                .add("Android", NewsDetailsFragment::class.java, Bundler().putString("tag","Android").get())
                .add("ios", NewsDetailsFragment::class.java,Bundler().putString("tag","iOS").get())
                .add("前端", NewsDetailsFragment::class.java,Bundler().putString("tag","前端").get())
                .add("App", NewsDetailsFragment::class.java,Bundler().putString("tag","App").get())
                .add("拓展资源",NewsDetailsFragment::class.java,Bundler().putString("tag","拓展资源").get())
                .create())
        viewPager!!.adapter = adapter

        tabBar!!.setViewPager(viewPager)
//        tabBar!!.setupWithViewPager(news_detail,false)
//        tabBar!!.mode = QMUITabSegment.MODE_FIXED
    }
}
