package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzly implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzlt f39371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f39372b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzma f39373c;

    public zzly(zzma zzmaVar, zzlt zzltVar, long j2) {
        this.f39371a = zzltVar;
        this.f39372b = j2;
        Objects.requireNonNull(zzmaVar);
        this.f39373c = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlt zzltVar = this.f39371a;
        long j2 = this.f39372b;
        zzma zzmaVar = this.f39373c;
        zzmaVar.k(zzltVar, false, j2);
        zzmaVar.f39381e = null;
        zznk zznkVarO = zzmaVar.f39180a.o();
        zznkVarO.g();
        zznkVarO.h();
        zznkVarO.u(new zzmm(zznkVarO, null));
    }
}
