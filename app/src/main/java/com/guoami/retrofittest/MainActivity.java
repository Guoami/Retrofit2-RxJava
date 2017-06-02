package com.guoami.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.button1) Button clickMe;
  @Bind(R.id.result) TextView result;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.button1)
  public void onClick() {
    getLunarDay();
  }

  private void getLunarDay() {
    String baseUrl = "http://www.sojson.com/open/api/lunar/";
    String date = "2017-4-20";

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    LunarService lunarService = retrofit.create(LunarService.class);
    //TODO 先不传参数，使用默认值
    lunarService.getCurrentDay(date)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<LunarEntity>() {
          @Override public void onCompleted() {
            Toast.makeText(MainActivity.this, "Get LunarDay", Toast.LENGTH_SHORT).show();
          }

          @Override public void onError(Throwable e) {
            result.setText(e.getMessage());
          }

          @Override public void onNext(LunarEntity lunarEntity) {
            //result.setText(lunarEntity.getData().getLunarYear());
            result.setText(lunarEntity.getData().getLunarMonth());
            //result.setText(lunarEntity.getData().getLunarDay());
            //result.setText(lunarEntity.getData().getCyclicalYear());
            //result.setText(lunarEntity.getData().getCyclicalMonth());
            //result.setText(lunarEntity.getData().getCyclicalDay());
          }
        });
  }
}
