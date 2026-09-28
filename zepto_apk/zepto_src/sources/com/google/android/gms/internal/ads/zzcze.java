package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzcze {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f27458a;

    public zzcze(zzfic zzficVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f27458a = atomicLong;
        atomicLong.set(zzficVar.f31193a.f31185a.u.get());
    }

    public final void a(long j2) {
        this.f27458a.set(j2);
    }
}
