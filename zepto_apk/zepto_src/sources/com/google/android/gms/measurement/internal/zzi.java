package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39082b;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39081a = zzcuVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39082b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39082b.f38653a.o();
        zznkVarO.g();
        zznkVarO.h();
        zznkVarO.u(new zzmi(zznkVarO, zznkVarO.w(false), this.f39081a));
    }
}
