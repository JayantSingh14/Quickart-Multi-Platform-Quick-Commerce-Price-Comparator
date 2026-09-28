package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbig;
import com.google.android.gms.internal.ads.zzcdr;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzd {
    public static void a(Context context) {
        boolean z;
        Object obj = com.google.android.gms.ads.internal.util.client.zzl.f21429b;
        if (((Boolean) zzbig.f25140a.c()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                    synchronized (com.google.android.gms.ads.internal.util.client.zzl.f21429b) {
                        z = com.google.android.gms.ads.internal.util.client.zzl.f21430c;
                    }
                    if (z) {
                        return;
                    }
                    ListenableFuture listenableFutureB = new zzc(context).b();
                    int i2 = zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.e("Updating ad debug logging enablement.");
                    zzcdr.a(listenableFutureB, "AdDebugLogUpdater.updateEnablement");
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Fail to determine debug setting.", e2);
            }
        }
    }
}
