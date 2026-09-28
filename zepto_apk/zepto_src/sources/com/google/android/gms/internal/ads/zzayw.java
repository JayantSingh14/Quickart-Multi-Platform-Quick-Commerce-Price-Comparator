package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* loaded from: classes4.dex */
public final class zzayw {

    /* renamed from: a, reason: collision with root package name */
    public NetworkCapabilities f24519a;

    public static zzayw a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        zzayw zzaywVar = new zzayw();
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(new zzayv(zzaywVar));
                return zzaywVar;
            } catch (RuntimeException unused) {
                synchronized (zzayw.class) {
                    zzaywVar.f24519a = null;
                }
            }
        }
        return zzaywVar;
    }
}
