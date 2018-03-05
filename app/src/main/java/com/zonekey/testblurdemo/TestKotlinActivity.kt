package com.zonekey.testblurdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_kotlin.*;

class TestKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kotlin)
        initialView()
    }

    private fun initialView() {
        btn_one.text = "悬浮在上方测试"
        btn_two.text = "弹出窗测试"
        btn__three.text = "三"
        btn_four.text = "四"
        btn_one.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
        btn_two.setOnClickListener{
            var intent = Intent(this,SecondActivity::class.java);
            startActivity(intent)
        }
    }
}
