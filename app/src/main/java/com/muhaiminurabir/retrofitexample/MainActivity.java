package com.muhaiminurabir.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.muhaiminurabir.retrofitexample.API.ApiClient;
import com.muhaiminurabir.retrofitexample.API.ApiInterface;
import com.muhaiminurabir.retrofitexample.Model.Login;
import com.muhaiminurabir.retrofitexample.Model.Login_body;
import com.muhaiminurabir.retrofitexample.Model.Product_grps;
import com.muhaiminurabir.retrofitexample.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView e;
    TextView e2;
    String token;
    ApiInterface apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(TextView) findViewById(R.id.access_token);
        e2=(TextView) findViewById(R.id.user);
        apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Login_body login_body=new Login_body();
        login_body.setEmail("muhaiminurabir@gmail.com");
        login_body.setPassword("12301019");
        Call<Login> call = apiService.loginuser(login_body);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login>call, Response<Login> response) {
                Log.d("paisi", response.body().getAccessToken());
                e.setText(response.body().getAccessToken());
                token=response.body().getAccessToken();
                e2.setText(response.body().getUser().getName());
                callgrps(token);
            }

            @Override
            public void onFailure(Call<Login>call, Throwable t) {
                // Log error here since request failed
                Log.e("Error", t.toString());
            }
        });

    }
    public  void savetoken(String t){
        token=t;
    }
    public void callgrps(String t){
        Call<Product_grps> call2 = apiService.show_grps("Bearer "+token);
        call2.enqueue(new Callback<Product_grps>() {
            @Override
            public void onResponse(Call<Product_grps>call, Response<Product_grps> response) {
                Log.d("grps", response.body().getAllGroups().get(1).getGroupName()+"");
            }

            @Override
            public void onFailure(Call<Product_grps>call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }
}
