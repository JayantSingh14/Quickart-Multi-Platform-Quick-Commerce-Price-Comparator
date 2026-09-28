package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzgna {

    /* renamed from: a, reason: collision with root package name */
    public final zzgcf f32961a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f32962b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public long f32963c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f32964d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f32965e = null;

    /* renamed from: f, reason: collision with root package name */
    public final int f32966f;

    public zzgna(int i2, zzgcf zzgcfVar) {
        this.f32966f = i2;
        this.f32961a = zzgcfVar;
    }

    public final void a() {
        if (this.f32962b.get()) {
            throw new IllegalStateException("Finished trace.");
        }
        this.f32963c = SystemClock.uptimeMillis();
    }

    public final void b(Throwable th) {
        if (this.f32962b.get()) {
            throw new IllegalStateException("Finished trace.");
        }
        this.f32965e = th;
    }

    public final void c() {
        AtomicBoolean atomicBoolean = this.f32962b;
        if (atomicBoolean.getAndSet(true)) {
            throw new IllegalStateException("Finished trace.");
        }
        this.f32964d = SystemClock.uptimeMillis();
        this.f32961a.b(this.f32966f - 1, atomicBoolean.get() ? this.f32964d - this.f32963c : -1L, null, this.f32965e);
    }
}
