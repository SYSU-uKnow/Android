package com.xuewen.networkservice;

import android.support.annotation.Nullable;

import com.xuewen.utility.GlobalUtil;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by ym on 16-11-4.
 */

public interface ApiService {
    @GET("api/questions/recommend")
    Call<QRResult> requestQR();

    @GET("api/questions/{question_id}")
    Call<QQidResult> requestQQid(@Path("question_id") int qid);

    @GET("api/users/{user_id}")
    Call<UUidResult> requestUUid(@Path("user_id") int uid);
    @PATCH("api/users/{user_id}")
    @Multipart
    Call<UUidResult> requestUUid(@Path("user_id") int uid,
                                 @Part("username") RequestBody username,
                                 @Part("status") RequestBody status,
                                 @Part("description") RequestBody description,
                                 @Part("school") RequestBody school,
                                 @Part("major") RequestBody major,
                                 @Part("grade") RequestBody grade,
                                 @Nullable @Part MultipartBody.Part file);

    @GET("api/users/{user_id}/introduction")
    Call<UUidIResult> requestUUidI(@Path("user_id") int uid);

    @GET("api/users/{user_id}/follows")
    Call<UUidFResult> requestUUidF(@Path("user_id") int uid);

    @GET("api/users/{user_id}/recommendations")
    Call<UUidRResult> requestUUidR(@Path("user_id") int uid);

//    Call<QRResult> repoContributors(
//            @Path("owner") String owner,
//            @Path("repo") String repo);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GlobalUtil.getInstance().baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}