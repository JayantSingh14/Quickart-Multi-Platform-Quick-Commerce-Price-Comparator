package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
abstract class zzor extends zzok {

    /* renamed from: c, reason: collision with root package name */
    public boolean f39561c;

    public zzor(zzpf zzpfVar) {
        super(zzpfVar);
        this.f39551b.r++;
    }

    public final void h() {
        if (!this.f39561c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (this.f39561c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        j();
        this.f39551b.s++;
        this.f39561c = true;
    }

    public abstract void j();
}
