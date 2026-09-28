package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzje extends zzjd {

    /* renamed from: b, reason: collision with root package name */
    public boolean f39181b;

    public zzje(zzib zzibVar) {
        super(zzibVar);
        this.f39180a.A++;
    }

    public abstract boolean h();

    public final void i() {
        if (!this.f39181b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f39181b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (h()) {
            return;
        }
        this.f39180a.C.incrementAndGet();
        this.f39181b = true;
    }
}
