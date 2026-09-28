package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzp implements zzjo {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzda f39580a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39581b;

    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39581b = appMeasurementDynamiteService;
        this.f39580a = zzdaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjo
    public final void a(long j2, Bundle bundle, String str, String str2) {
        try {
            this.f39580a.L7(j2, bundle, str, str2);
        } catch (RemoteException e2) {
            zzib zzibVar = this.f39581b.f38653a;
            if (zzibVar != null) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(e2, "Event interceptor threw exception");
            }
        }
    }
}
