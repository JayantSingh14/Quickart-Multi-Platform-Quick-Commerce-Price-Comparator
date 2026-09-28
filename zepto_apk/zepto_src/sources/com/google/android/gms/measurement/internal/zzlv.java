package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzlv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzlt f39363a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzlt f39364b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f39365c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f39366d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzma f39367e;

    public zzlv(zzma zzmaVar, zzlt zzltVar, zzlt zzltVar2, long j2, boolean z) {
        this.f39363a = zzltVar;
        this.f39364b = zzltVar2;
        this.f39365c = j2;
        this.f39366d = z;
        Objects.requireNonNull(zzmaVar);
        this.f39367e = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39367e.q(this.f39363a, this.f39364b, this.f39365c, this.f39366d, null);
    }
}
