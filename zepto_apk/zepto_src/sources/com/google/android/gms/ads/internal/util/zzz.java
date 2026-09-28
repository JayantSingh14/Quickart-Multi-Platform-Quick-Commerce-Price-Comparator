package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzbfp;

/* loaded from: classes4.dex */
public class zzz {
    public zzbfp.zzq a(Context context, TelephonyManager telephonyManager) {
        return zzbfp.zzq.ENUM_UNKNOWN;
    }

    public boolean c(Context context) {
        return false;
    }

    public Intent d(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public void e(Activity activity) {
    }

    public int f(AudioManager audioManager) {
        return 0;
    }

    public int g(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    public void b(Context context) {
    }
}
