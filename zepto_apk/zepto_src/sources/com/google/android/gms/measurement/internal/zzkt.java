package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzkt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjk f39282a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f39283b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f39284c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzli f39285d;

    public zzkt(zzli zzliVar, zzjk zzjkVar, long j2, boolean z) {
        this.f39282a = zzjkVar;
        this.f39283b = j2;
        this.f39284c = z;
        Objects.requireNonNull(zzliVar);
        this.f39285d = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjk zzjkVar = this.f39282a;
        zzli zzliVar = this.f39285d;
        zzliVar.k(zzjkVar);
        zzliVar.C(zzjkVar, this.f39283b, this.f39284c);
    }
}
