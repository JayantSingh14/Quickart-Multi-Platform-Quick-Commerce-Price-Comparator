package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzp f39301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39302b;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar) {
        this.f39301a = zzpVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39302b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.f39302b.f38653a.f39096m;
        zzib.k(zzliVar);
        zzp zzpVar = this.f39301a;
        zzliVar.g();
        zzliVar.h();
        zzjo zzjoVar = zzliVar.f39316d;
        if (zzpVar != zzjoVar) {
            Preconditions.checkState(zzjoVar == null, "EventInterceptor already set.");
        }
        zzliVar.f39316d = zzpVar;
    }
}
