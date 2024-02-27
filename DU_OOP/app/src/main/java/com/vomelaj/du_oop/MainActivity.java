package com.vomelaj.du_oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Generator g = new Generator(5,5);
        Log.d("xxx", g.generuj());
        GeneratorHesel gh = new GeneratorHesel(10,3);
        Log.d("xxx", gh.generuj());
        GeneratorKodu gk = new GeneratorKodu(5,10);
        Log.d("xxx", gk.generuj());
    }
}