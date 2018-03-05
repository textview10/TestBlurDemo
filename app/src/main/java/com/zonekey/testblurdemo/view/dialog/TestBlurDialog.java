package com.zonekey.testblurdemo.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.zonekey.testblurdemo.R;

import jp.wasabeef.blurry.Blurry;

/**
 * Created by xu.wang
 * Date on  2018/3/5 10:00:21.
 *
 * @Desc
 */

public class TestBlurDialog extends Dialog {

    private ImageView iv_testblur;

    public TestBlurDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_testblur);
        initialView();
    }

    private void initialView() {
        iv_testblur = findViewById(R.id.iv_dialog_testblur);
        iv_testblur.setPadding(0, getStatusHeight(getContext()), 0, 0);
    }

    public void setBitmap(Bitmap bitmap) {
        Blurry.with(getContext()).async().radius(5).sampling(2).from(bitmap).into(iv_testblur);
    }

    public static int getStatusHeight(Context context) {
        int height = 0;
        int resourcID = context
                .getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        if (resourcID > 0) {
            height = context
                    .getResources()
                    .getDimensionPixelOffset(resourcID);
        }
        return height;
    }
}
