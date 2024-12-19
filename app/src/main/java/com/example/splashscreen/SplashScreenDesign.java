package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kotlin.jvm.Throws;

public class SplashScreenDesign extends AppCompatActivity {

    TextView pbCount;
    ProgressBar pb;
    Handler handler=new Handler();
    int prog=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        pbCount=findViewById(R.id.lbl1);
        pb=findViewById(R.id.progressBar);

        Intent a=new Intent(SplashScreenDesign.this,MainActivity.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(prog<100)
                {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            prog++;
                            pb.setProgress(prog);
                            pbCount.setText(prog+"/100");
                            if(prog==100)
                            {
                                startActivity(a);
                                finish();
                            }
                        }
                    });
                    try{
                        Thread.sleep(30);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}