package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzgzk extends zzgyt {

    /* renamed from: c, reason: collision with root package name */
    public final Callable f33401c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgzl f33402d;

    public zzgzk(zzgzl zzgzlVar, Callable callable) {
        Objects.requireNonNull(zzgzlVar);
        this.f33402d = zzgzlVar;
        callable.getClass();
        this.f33401c = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final Object a() {
        return this.f33401c.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String c() {
        return this.f33401c.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean d() {
        return this.f33402d.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void e(Object obj) {
        this.f33402d.c(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void f(Throwable th) {
        this.f33402d.d(th);
    }
}
