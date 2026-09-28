package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzcuz implements zzdby, zzbck, zzdfm {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhr f27198a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdbc f27199b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdch f27200c;

    /* renamed from: f, reason: collision with root package name */
    public final zzddd f27203f;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f27201d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f27202e = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f27204g = new AtomicBoolean();

    public zzcuz(zzfhr zzfhrVar, zzdbc zzdbcVar, zzdch zzdchVar, zzddd zzdddVar) {
        this.f27198a = zzfhrVar;
        this.f27199b = zzdbcVar;
        this.f27200c = zzdchVar;
        this.f27203f = zzdddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void a() {
        if (this.f27198a.f31153e == 4 && this.f27201d.compareAndSet(false, true)) {
            this.f27199b.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void m() {
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        int i2 = this.f27198a.f31153e;
        if (i2 == 1) {
            if (zzbcjVar.f24707j && this.f27201d.compareAndSet(false, true)) {
                this.f27199b.g();
            }
        } else if (i2 == 4 && zzbcjVar.f24707j && this.f27204g.compareAndSet(false, true)) {
            this.f27203f.g();
        }
        if (zzbcjVar.f24707j && this.f27202e.compareAndSet(false, true)) {
            zzdch zzdchVar = this.f27200c;
            synchronized (zzdchVar) {
                zzdchVar.v0(zzdcg.f27606a);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final synchronized void zzg() {
        int i2 = this.f27198a.f31153e;
        if (i2 == 1 || i2 == 4) {
            return;
        }
        if (this.f27201d.compareAndSet(false, true)) {
            this.f27199b.g();
        }
    }
}
