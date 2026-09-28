package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39270a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39271b;

    public zzkn(zzli zzliVar, AtomicReference atomicReference) {
        this.f39270a = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.f39271b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f39270a;
        synchronized (atomicReference) {
            try {
                try {
                    zzib zzibVar = this.f39271b.f39180a;
                    atomicReference.set(zzibVar.f39087d.m(zzibVar.q().m(), zzfx.b0));
                } finally {
                    this.f39270a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
