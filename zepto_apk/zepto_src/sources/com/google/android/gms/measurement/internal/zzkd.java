package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39249a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39250b;

    public zzkd(zzli zzliVar, AtomicReference atomicReference) {
        this.f39249a = atomicReference;
        Objects.requireNonNull(zzliVar);
        this.f39250b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f39249a;
        synchronized (atomicReference) {
            try {
                try {
                    zzib zzibVar = this.f39250b.f39180a;
                    atomicReference.set(Boolean.valueOf(zzibVar.f39087d.q(zzibVar.q().m(), zzfx.a0)));
                } finally {
                    this.f39249a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
