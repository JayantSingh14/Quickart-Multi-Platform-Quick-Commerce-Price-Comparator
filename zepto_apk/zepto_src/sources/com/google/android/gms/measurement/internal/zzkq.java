package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39276a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39277b;

    public zzkq(zzli zzliVar, AtomicReference atomicReference) {
        this.f39276a = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.f39277b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f39276a;
        synchronized (atomicReference) {
            try {
                try {
                    zzib zzibVar = this.f39277b.f39180a;
                    atomicReference.set(Double.valueOf(zzibVar.f39087d.p(zzibVar.q().m(), zzfx.e0)));
                } finally {
                    this.f39276a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
