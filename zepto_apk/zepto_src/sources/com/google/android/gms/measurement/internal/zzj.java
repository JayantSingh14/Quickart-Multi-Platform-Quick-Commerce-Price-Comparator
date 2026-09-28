package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39167a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbg f39168b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39169c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f39170d;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, zzbg zzbgVar, String str) {
        this.f39167a = zzcuVar;
        this.f39168b = zzbgVar;
        this.f39169c = str;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f39170d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39170d.f38653a.o();
        zznkVarO.g();
        zznkVarO.h();
        zzib zzibVar = zznkVarO.f39180a;
        zzpo zzpoVar = zzibVar.f39092i;
        zzib.j(zzpoVar);
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzpoVar.f39180a.f39084a, 12451000);
        com.google.android.gms.internal.measurement.zzcu zzcuVar = this.f39167a;
        if (iIsGooglePlayServicesAvailable == 0) {
            zznkVarO.u(new zzmo(zznkVarO, this.f39168b, this.f39169c, zzcuVar));
            return;
        }
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.a("Not bundling data. Service unavailable or out of date");
        zzpo zzpoVar2 = zzibVar.f39092i;
        zzib.j(zzpoVar2);
        zzpoVar2.Q(zzcuVar, new byte[0]);
    }
}
