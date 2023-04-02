package com.example.practica2;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar pbar;
    Handler handler = new Handler();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbar = findViewById(R.id.progressBar2);
        progressMethod();
    }

    public void progressMethod(){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<=100){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pbar.setProgress(i);
                        }
                    });
                    i++;
                    try {
                        Thread.sleep(100);
                    }catch (Exception ex){

                    }
                    if(i==100){
                        //Toast.makeText(MainActivity.this, "Se lleno", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        hilo.start();
    }
}