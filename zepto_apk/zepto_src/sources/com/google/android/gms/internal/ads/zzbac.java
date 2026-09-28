package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzbac {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f24621e = {"android:establish_vpn_service", "android:establish_vpn_manager"};

    /* renamed from: a, reason: collision with root package name */
    public long f24622a;

    /* renamed from: b, reason: collision with root package name */
    public long f24623b;

    /* renamed from: c, reason: collision with root package name */
    public long f24624c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f24625d;

    public static zzbac a(Context context, Executor executor) {
        String[] strArr = f24621e;
        zzbac zzbacVar = new zzbac();
        zzbacVar.f24622a = 0L;
        zzbacVar.f24623b = 0L;
        zzbacVar.f24624c = -1L;
        zzbacVar.f24625d = false;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).startWatchingActive(strArr, executor, new zzbab(zzbacVar));
            } catch (IllegalArgumentException | NoSuchMethodError unused) {
            }
        }
        return zzbacVar;
    }
}
