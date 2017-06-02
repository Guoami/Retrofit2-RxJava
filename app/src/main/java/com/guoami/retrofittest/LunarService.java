package com.guoami.retrofittest;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by OBR on 2017/5/31.
 */

public interface LunarService {

  //@FormUrlEncoded
  //@POST("json.shtml") Observable<LunarEntity>
  //setData(@Field("year") String year, @Field("month") String month, @Field("day") String day);

  @GET("json.shtml")
  Observable<LunarEntity> getCurrentDay(@Query("date") String date);

  //@GET("json.shtml") Observable<LunarEntity>
  //getLunarData(@Path("date") String date);
}
