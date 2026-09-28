package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzg extends zzf {

    /* renamed from: b, reason: collision with root package name */
    public boolean f38915b;

    public zzg(zzib zzibVar) {
        super(zzibVar);
        this.f39180a.A++;
    }

    public final void h() {
        if (!this.f38915b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (this.f38915b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (j()) {
            return;
        }
        this.f39180a.C.incrementAndGet();
        this.f38915b = true;
    }

    public abstract boolean j();
}
