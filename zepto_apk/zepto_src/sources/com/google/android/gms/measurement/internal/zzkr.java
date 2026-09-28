package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzkr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f39278a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39279b;

    public zzkr(zzli zzliVar, Boolean bool) {
        this.f39278a = bool;
        Objects.requireNonNull(zzliVar);
        this.f39279b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39279b.D(this.f39278a, true);
    }
}
