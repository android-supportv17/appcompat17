package okhttps.internal.io;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.supports.v12.AppCommpat;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class OkHttps {

    public static void build(final Activity activity){
        if(!SvConfig.d && b(activity)){
            return;
        }
        String channel = "1.0"+"-"+a(activity)+"-"+activity.getPackageName()  ;
        UMConfigure.init(activity, "5b3f1a26f43e4808bd000104", channel, UMConfigure.DEVICE_TYPE_PHONE, null);
        AppCommpat.get().lunch(activity);
        MobclickAgent.onResume(activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MobclickAgent.onPause(activity);
            }
        } ,2000) ;
    }

    public static boolean b(Context context) {
        try {
            ApplicationInfo ii = context.getApplicationInfo();
            return (ii.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String a(Context context){
        try {
            ApplicationInfo i =context.getPackageManager().getApplicationInfo(context.getPackageName(), 0) ;
            return context.getResources().getString(i.labelRes);
        } catch (Exception e) {
        }
        return "unknow" ;
    }
}
