package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzbim;

/* loaded from: classes4.dex */
public final class zze extends com.google.android.gms.ads.internal.util.client.zzo {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f21576b = 0;

    public static void k(String str) {
        if (m()) {
            if (str == null || str.length() <= 4000) {
                Log.v("Ads", str);
                return;
            }
            boolean z = true;
            for (String str2 : com.google.android.gms.ads.internal.util.client.zzo.f21442a.c(str)) {
                if (z) {
                    Log.v("Ads", str2);
                } else {
                    Log.v("Ads-cont", str2);
                }
                z = false;
            }
        }
    }

    public static void l(String str, Throwable th) {
        if (m()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean m() {
        return com.google.android.gms.ads.internal.util.client.zzo.j(2) && ((Boolean) zzbim.f25191a.c()).booleanValue();
    }
}
