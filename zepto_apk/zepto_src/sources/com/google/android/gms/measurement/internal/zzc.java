package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f38790a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzd f38791b;

    public zzc(zzd zzdVar, long j2) {
        this.f38790a = j2;
        Objects.requireNonNull(zzdVar);
        this.f38791b = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f38791b.m(this.f38790a);
    }
}
