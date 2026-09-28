package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39230a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39231b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39232c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f39233d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39234e;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z) {
        this.f39230a = zzcuVar;
        this.f39231b = str;
        this.f39232c = str2;
        this.f39233d = z;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39234e = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39234e.f38653a.o();
        zznkVarO.g();
        zznkVarO.h();
        zznkVarO.u(new zzmb(zznkVarO, this.f39231b, this.f39232c, zznkVarO.w(false), this.f39233d, this.f39230a));
    }
}
