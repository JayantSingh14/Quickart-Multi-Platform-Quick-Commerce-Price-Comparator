package com.google.android.gms.measurement.internal;

import android.os.Looper;

/* loaded from: classes.dex */
public final class zzob extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.zzcn f39532c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39533d;

    /* renamed from: e, reason: collision with root package name */
    public final zzoa f39534e;

    /* renamed from: f, reason: collision with root package name */
    public final zznz f39535f;

    /* renamed from: g, reason: collision with root package name */
    public final zznx f39536g;

    public zzob(zzib zzibVar) {
        super(zzibVar);
        this.f39533d = true;
        this.f39534e = new zzoa(this);
        this.f39535f = new zznz(this);
        this.f39536g = new zznx(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return false;
    }

    public final void k() {
        g();
        if (this.f39532c == null) {
            this.f39532c = new com.google.android.gms.internal.measurement.zzcn(Looper.getMainLooper());
        }
    }
}
