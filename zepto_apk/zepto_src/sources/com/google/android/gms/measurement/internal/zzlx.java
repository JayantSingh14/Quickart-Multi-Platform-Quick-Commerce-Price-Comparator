package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzlx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f39369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzma f39370b;

    public zzlx(zzma zzmaVar, long j2) {
        this.f39369a = j2;
        Objects.requireNonNull(zzmaVar);
        this.f39370b = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.f39370b;
        zzd zzdVar = zzmaVar.f39180a.n;
        zzib.i(zzdVar);
        zzdVar.j(this.f39369a);
        zzmaVar.f39381e = null;
    }
}
