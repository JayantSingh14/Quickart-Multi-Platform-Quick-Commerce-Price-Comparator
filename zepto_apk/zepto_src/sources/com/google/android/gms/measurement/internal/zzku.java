package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzku implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjk f39286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f39287b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f39288c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzli f39289d;

    public zzku(zzli zzliVar, zzjk zzjkVar, long j2, boolean z) {
        this.f39286a = zzjkVar;
        this.f39287b = j2;
        this.f39288c = z;
        Objects.requireNonNull(zzliVar);
        this.f39289d = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjk zzjkVar = this.f39286a;
        zzli zzliVar = this.f39289d;
        zzliVar.k(zzjkVar);
        zzliVar.C(zzjkVar, this.f39287b, this.f39288c);
    }
}
