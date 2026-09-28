package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzema implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29696a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzemb f29697b;

    public zzema(zzemb zzembVar, zzfhr zzfhrVar) {
        this.f29696a = zzfhrVar;
        Objects.requireNonNull(zzembVar);
        this.f29697b = zzembVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzemb zzembVar = this.f29697b;
        synchronized (zzembVar) {
            try {
                zzemc zzemcVar = zzembVar.f29705h;
                zzfhr zzfhrVar = this.f29696a;
                zzemcVar.c(zzfhrVar);
                zzfhr zzfhrVarA = zzembVar.f29705h.a();
                if (zzfhrVar.v0) {
                    while (zzfhrVarA != null) {
                        zzembVar.a(zzfhrVarA);
                        zzfhrVarA = zzembVar.f29705h.a();
                    }
                } else if (zzfhrVarA != null) {
                    zzembVar.a(zzfhrVarA);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        zzemb zzembVar = this.f29697b;
        zzems zzemsVar = (zzems) obj;
        synchronized (zzembVar) {
            zzembVar.f29705h.b(zzemsVar, this.f29696a);
            zzfhr zzfhrVarA = zzembVar.f29705h.a();
            if (zzfhrVarA != null) {
                zzembVar.a(zzfhrVarA);
            }
        }
    }
}
