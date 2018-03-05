package com.zonekey.testblurdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wonderkiln.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity {

    private BlurLayout blurLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
    }

    private void initialView() {
        blurLayout = findViewById(R.id.blur_layout_test);

    }
}
