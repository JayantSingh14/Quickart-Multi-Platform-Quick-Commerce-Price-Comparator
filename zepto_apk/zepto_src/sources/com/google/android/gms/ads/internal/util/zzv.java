package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.media3.session.e;
import com.bumptech.glide.load.resource.bitmap.a;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcjc;
import com.google.android.gms.internal.ads.zzcjn;
import com.google.android.gms.internal.ads.zzckg;
import com.google.android.gms.internal.ads.zzeif;

@TargetApi(26)
/* loaded from: classes4.dex */
public class zzv extends zzu {
    @Override // com.google.android.gms.ads.internal.util.zzz
    public final zzbfp.zzq a(Context context, TelephonyManager telephonyManager) {
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        return (zzs.d(context, "android.permission.ACCESS_NETWORK_STATE") && telephonyManager.isDataEnabled()) ? zzbfp.zzq.ENUM_TRUE : zzbfp.zzq.ENUM_FALSE;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final void b(Context context) {
        e.C();
        NotificationChannel notificationChannelC = a.c(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y9)).intValue());
        notificationChannelC.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelC);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final boolean c(Context context) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final Intent d(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    @Override // com.google.android.gms.ads.internal.util.zzt
    public final zzcjc i(zzcir zzcirVar, zzbfj zzbfjVar, boolean z, zzeif zzeifVar) {
        return new zzckg((zzcjn) zzcirVar, zzbfjVar, z, zzeifVar);
    }
}
