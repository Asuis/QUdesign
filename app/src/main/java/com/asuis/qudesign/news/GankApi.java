package com.asuis.qudesign.news;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 15988440973 on 2018/1/9.
 * desciption:
 */

public interface GankApi {
    @GET("data/{category}/{pageSize}/{page}")
    Observable<GankDataResult> getData(@Path("category") String type, @Path("pageSize") int pageSize, @Path("page") int page);
    @GET("search/query/{searchkey}/category/all/count/10/page/{page}")
    Observable<GankDataResult> getSearchData(@Path("searchkey") String searchkey,
                                             @Path("page") int page);
}
