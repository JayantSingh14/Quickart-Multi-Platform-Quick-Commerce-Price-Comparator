package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39375a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39376b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39377c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39378d;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2) {
        this.f39375a = zzcuVar;
        this.f39376b = str;
        this.f39377c = str2;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39378d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39378d.f38653a.o();
        zznkVarO.g();
        zznkVarO.h();
        zzr zzrVarW = zznkVarO.w(false);
        zznkVarO.u(new zzmv(zznkVarO, this.f39376b, this.f39377c, zzrVarW, this.f39375a));
    }
}
