package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes4.dex */
final class zzflx {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f31371a;

    /* renamed from: b, reason: collision with root package name */
    public final long f31372b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f31373c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfly f31374d;

    public zzflx(zzfly zzflyVar, Runnable runnable, long j2) {
        Objects.requireNonNull(zzflyVar);
        this.f31374d = zzflyVar;
        this.f31371a = runnable;
        this.f31372b = j2;
    }
}
