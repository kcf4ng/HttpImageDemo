package com.example.httpimagedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    private void ConnectInternet() {
        try {

            //對目標的ＵＲＬ轉址
            URL url = new URL("https://i.imgur.com/MBsW93Z.jpg");

            //針對拿到的ＵＲＬ連線
            URLConnection conn = url.openConnection();

            //取得串流
            InputStream streamIn = conn.getInputStream();

            //在C#以及JAVA之中圖片叫做Bitmap, 所以製造一個 Bitmap，並且呼叫BitmapFactory來給圖片解碼
            Bitmap pic = BitmapFactory.decodeStream(streamIn);

            imgHttp.setImageBitmap(pic);
            //抓影音檔案、ＭＰ３都是一樣的流程模式。


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
        StrictMode.ThreadPolicy l_policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(l_policy);
        ConnectInternet();
    }



    private void InitialComponent() {
    imgHttp = findViewById(R.id.imgHttp);

    }


    ImageView imgHttp;
}
