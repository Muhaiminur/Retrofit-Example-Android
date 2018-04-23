package com.muhaiminurabir.retrofitexample.API;

import com.muhaiminurabir.retrofitexample.Model.Login;
import com.muhaiminurabir.retrofitexample.Model.Login_body;
import com.muhaiminurabir.retrofitexample.Model.Product_grps;
import com.muhaiminurabir.retrofitexample.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("/api/login")
    Call<Login> loginuser(@Body Login_body login_body);

    @POST("/api/product_groups")
    Call<Product_grps> show_grps(@Header("Authorization") String token);
}
