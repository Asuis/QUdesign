package com.asuis.qudesign.login;

import com.asuis.qudesign.base.Result;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 15988440973 on 2018/1/9.
 * desciption:
 */

public interface UserApi {
    @FormUrlEncoded
    @POST("user/login")
    Observable<Result<LoginUserResult>> login(@Field("username") String username, @Field("pwd") String pwd);
}
