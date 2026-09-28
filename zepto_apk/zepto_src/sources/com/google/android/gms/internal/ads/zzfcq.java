package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfcq implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzfcq f30856a = new zzfcq();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap map = new HashMap();
        zzbgb zzbgbVar = zzbgk.i0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        String str = (String) zzbdVar.f21153c.a(zzbgbVar);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzbdVar.f21153c.a(zzbgk.j0)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    map.put(str2, com.google.android.gms.ads.internal.util.zzch.a(str2));
                }
            }
        }
        return new zzfcs(map);
    }
}
