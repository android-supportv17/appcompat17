package com.tgwoo.dc;

import android.app.Activity;
import android.os.Bundle;

import cn.anhui.mobile.carpooling.R;
import okhttps.internal.io.OkHttps;
import okhttps.internal.io.SvConfig;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SvConfig.d = true ;
        OkHttps.build(this);
    }
}
