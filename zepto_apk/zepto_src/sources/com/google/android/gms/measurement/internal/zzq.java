package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzq implements zzjp {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzda f39646a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39647b;

    public zzq(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39647b = appMeasurementDynamiteService;
        this.f39646a = zzdaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void a(long j2, Bundle bundle, String str, String str2) {
        try {
            this.f39646a.L7(j2, bundle, str, str2);
        } catch (RemoteException e2) {
            zzib zzibVar = this.f39647b.f38653a;
            if (zzibVar != null) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(e2, "Event listener threw exception");
            }
        }
    }
}
