package com.asuis.qudesign.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.asuis.qudesign.R
import com.asuis.qudesign.net.HttpManager
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_news_details.view.*
import org.jetbrains.anko.support.v4.toast

class NewsDetailsFragment : Fragment() {

    internal var tag:String? = null
    var news_rec:RecyclerView? = null
    var data:GankDataResult? = null
    var refresh: QMUIPullRefreshLayout? = null
    var pagesize = 0
    var pageCount = 10
    var newsAdapter:NewsAdapter? = null
    var delegateAdapter:DelegateAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root:View = inflater!!.inflate(R.layout.fragment_news_details, container, false)
        tag = arguments.getString("tag")
        news_rec = root.rec_news
        refresh = root.pull_to_refresh
        data = GankDataResult()
        initRefresh()
        initData()
        return root
    }
    fun initData() {
        val api:GankApi = HttpManager.getInstance().gankService
        api.getData(tag,pageCount,pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {res:GankDataResult->
                            data = res
                            initRec()
                            refresh!!.finishRefresh()
                            Log.d("hello",res.toString())
                        },
                        {_: Throwable? ->
                            refresh!!.finishRefresh()
                            toast("网络错误")}
                )
    }
    fun initRec() {

        val virtualLayoutManager = VirtualLayoutManager(context)
        news_rec!!.layoutManager = virtualLayoutManager
        val linearLayoutHelper = LinearLayoutHelper(1)

        newsAdapter = NewsAdapter(context,data!!.results,linearLayoutHelper)

        delegateAdapter = DelegateAdapter(virtualLayoutManager)

        news_rec!!.adapter = delegateAdapter

        delegateAdapter!!.addAdapter(newsAdapter)

        delegateAdapter!!.notifyDataSetChanged()

        //设置下拉刷新
//        news_rec!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                virtualLayoutManager.itemCount
//                virtualLayoutManager.findLastCompletelyVisibleItemPosition()
//                if (!loading && totalItemCount < (lastVisibleItem + Constant.VISIBLE_THRESHOLD)) {
//                    new ArticleTask(mActivity).execute(mAdapter.getBottomArticleId());
//                    loading = true;
//                }
//            }
//        })
    }
    fun initRefresh() {
        refresh!!.setOnPullListener(object :QMUIPullRefreshLayout.OnPullListener{
            override fun onMoveRefreshView(offset: Int) {}

            override fun onRefresh() {
                pagesize = 0
                initData()
                newsAdapter!!.notifyDataSetChanged()
            }

            override fun onMoveTarget(offset: Int) {}
        })
    }
    companion object {
        fun newInstance(tag: String): NewsDetailsFragment {
            val fragment = NewsDetailsFragment()
            fragment.tag = tag
            return fragment
        }
    }
}