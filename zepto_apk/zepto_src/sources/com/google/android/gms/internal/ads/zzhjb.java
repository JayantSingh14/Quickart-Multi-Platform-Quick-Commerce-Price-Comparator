package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzhjb {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhjb f33880b = new zzhjb();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f33881a = new AtomicReference(new zzhjw(new zzhjt()));

    public final synchronized void a(zzhjs zzhjsVar) {
        AtomicReference atomicReference = this.f33881a;
        zzhjt zzhjtVar = new zzhjt((zzhjw) atomicReference.get());
        zzhjtVar.a(zzhjsVar);
        atomicReference.set(new zzhjw(zzhjtVar));
    }

    public final synchronized void b(zzhjy zzhjyVar) {
        AtomicReference atomicReference = this.f33881a;
        zzhjt zzhjtVar = new zzhjt((zzhjw) atomicReference.get());
        zzhjtVar.b(zzhjyVar);
        atomicReference.set(new zzhjw(zzhjtVar));
    }
}
