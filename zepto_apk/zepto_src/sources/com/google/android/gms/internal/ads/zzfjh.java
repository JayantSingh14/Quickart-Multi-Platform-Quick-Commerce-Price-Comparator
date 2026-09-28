package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfjh {
    public static void a(int i2, String str, Throwable th) {
        String strR = androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 20), i2, "Ad failed to load : ");
        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e(strR);
        com.google.android.gms.ads.internal.util.zze.l(str, th);
        if (i2 == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.C.f21684h.e(str, th);
    }

    public static void b(Context context, boolean z) {
        if (z) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        String strC = com.google.android.gms.ads.internal.util.client.zzf.c(context);
        String strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(strC).length() + 102), "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"", strC, "\")) to get test ads on this device.");
        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e(strS);
    }
}
