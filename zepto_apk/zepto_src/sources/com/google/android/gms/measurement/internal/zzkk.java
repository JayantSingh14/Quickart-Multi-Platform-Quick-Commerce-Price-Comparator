package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39262a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39263b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39264c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f39265d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzli f39266e;

    public zzkk(zzli zzliVar, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.f39262a = atomicReference;
        this.f39263b = str;
        this.f39264c = str2;
        this.f39265d = z;
        Objects.requireNonNull(zzliVar);
        this.f39266e = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39266e.f39180a.o();
        zznkVarO.g();
        zznkVarO.h();
        zzr zzrVarW = zznkVarO.w(false);
        zznkVarO.u(new zzmw(zznkVarO, this.f39262a, this.f39263b, this.f39264c, zzrVarW, this.f39265d));
    }
}
