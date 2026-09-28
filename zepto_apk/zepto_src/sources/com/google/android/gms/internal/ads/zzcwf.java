package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzcwf implements com.google.android.gms.ads.internal.overlay.zzr {

    /* renamed from: a, reason: collision with root package name */
    public final zzdbr f27276a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f27277b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f27278c = new AtomicBoolean(false);

    public zzcwf(zzdbr zzdbrVar) {
        this.f27276a = zzdbrVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
        AtomicBoolean atomicBoolean = this.f27278c;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        this.f27276a.v0(zzdbq.f27593a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
        this.f27277b.set(true);
        AtomicBoolean atomicBoolean = this.f27278c;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        this.f27276a.v0(zzdbq.f27593a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        this.f27276a.v0(zzdbm.f27587a);
    }
}
