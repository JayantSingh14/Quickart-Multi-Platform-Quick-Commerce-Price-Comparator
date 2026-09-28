package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39274a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39275b;

    public zzkp(zzli zzliVar, AtomicReference atomicReference) {
        this.f39274a = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.f39275b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f39274a;
        synchronized (atomicReference) {
            try {
                try {
                    zzib zzibVar = this.f39275b.f39180a;
                    atomicReference.set(Integer.valueOf(zzibVar.f39087d.o(zzibVar.q().m(), zzfx.d0)));
                } finally {
                    this.f39274a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
