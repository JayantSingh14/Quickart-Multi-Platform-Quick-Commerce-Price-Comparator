package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzkc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39244a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39245b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f39246c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f39247d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzli f39248e;

    public zzkc(zzli zzliVar, String str, String str2, Object obj, long j2) {
        this.f39244a = str;
        this.f39245b = str2;
        this.f39246c = obj;
        this.f39247d = j2;
        Objects.requireNonNull(zzliVar);
        this.f39248e = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f39246c;
        this.f39248e.s(this.f39247d, obj, this.f39244a, this.f39245b);
    }
}
