package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzdwm;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21827a;

    /* renamed from: b, reason: collision with root package name */
    public final zzd f21828b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21829c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f21830d;

    /* renamed from: e, reason: collision with root package name */
    public final PackageInfo f21831e;

    public zzb(Context context, long j2, PackageInfo packageInfo, zzd zzdVar, ScheduledExecutorService scheduledExecutorService) {
        this.f21827a = context;
        this.f21829c = j2;
        this.f21831e = packageInfo;
        this.f21828b = zzdVar;
        this.f21830d = scheduledExecutorService;
    }

    public static final void b(Bundle bundle, zzdwm zzdwmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q8)).booleanValue()) {
            bundle.putLong(zzdwmVar.f28699a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
    }

    public static final void c(int i2, Bundle bundle) {
        bundle.putBoolean("sod_h", false);
        bundle.putInt("cmr", i2 - 1);
    }

    public final boolean a() {
        return this.f21828b.d().size() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.p8)).intValue();
    }
}
