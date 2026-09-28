package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzko implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39272a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39273b;

    public zzko(zzli zzliVar, AtomicReference atomicReference) {
        this.f39272a = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.f39273b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f39272a;
        synchronized (atomicReference) {
            try {
                try {
                    zzib zzibVar = this.f39273b.f39180a;
                    atomicReference.set(Long.valueOf(zzibVar.f39087d.n(zzibVar.q().m(), zzfx.c0)));
                } finally {
                    this.f39272a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
