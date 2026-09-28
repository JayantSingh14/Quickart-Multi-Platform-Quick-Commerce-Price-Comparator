package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zznd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f39466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzne f39467b;

    public zznd(zzne zzneVar, ConnectionResult connectionResult) {
        this.f39466a = connectionResult;
        this.f39467b = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39467b.f39470c;
        zznkVar.f39485d = null;
        if (this.f39466a.getErrorCode() != 7777) {
            zznkVar.v();
            return;
        }
        if (zznkVar.f39488g == null) {
            zznkVar.f39488g = Executors.newScheduledThreadPool(1);
        }
        zznkVar.f39488g.schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznb
            @Override // java.lang.Runnable
            public final void run() {
                final zznk zznkVar2 = this.f39464a.f39467b.f39470c;
                zzhy zzhyVar = zznkVar2.f39180a.f39090g;
                zzib.l(zzhyVar);
                zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznc
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zznkVar2.m();
                    }
                });
            }
        }, ((Long) zzfx.Z.a(null)).longValue(), TimeUnit.MILLISECONDS);
    }
}
