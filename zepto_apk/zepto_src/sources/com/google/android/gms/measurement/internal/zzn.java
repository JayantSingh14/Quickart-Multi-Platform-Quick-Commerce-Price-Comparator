package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39461a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39462b;

    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39461a = zzcuVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39462b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.f39462b;
        zzpo zzpoVar = appMeasurementDynamiteService.f38653a.f39092i;
        zzib.j(zzpoVar);
        zzib zzibVar = appMeasurementDynamiteService.f38653a;
        zzpoVar.R(this.f39461a, zzibVar.y != null && zzibVar.y.booleanValue());
    }
}
