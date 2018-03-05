package com.zonekey.testblurdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;

import com.zonekey.testblurdemo.view.dialog.TestBlurDialog;

/**
 * Created by xu.wang
 * Date on  2018/3/5 09:53:40.
 *
 * @Desc
 */

public class SecondActivity extends AppCompatActivity {

    private ImageView imageView;
    private AppCompatButton btn_blur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialView();
    }

    private void initialView() {
        imageView = findViewById(R.id.iv_second);
        btn_blur = findViewById(R.id.btn_second_blur);
        btn_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testClick();
            }
        });
    }

    private void testClick() {
        TestBlurDialog testBlurDialog = new TestBlurDialog(this);
        testBlurDialog.show();
        Bitmap bitmap = takeScreenShot(this);
        testBlurDialog.setBitmap(bitmap);

    }

    public Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // 去掉标题栏
        // Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }
}
