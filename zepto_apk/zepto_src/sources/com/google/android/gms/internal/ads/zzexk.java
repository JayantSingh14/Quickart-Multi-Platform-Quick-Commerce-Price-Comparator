package com.google.android.gms.internal.ads;

import android.content.Intent;

/* loaded from: classes4.dex */
public final class zzexk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f30530a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30531b;

    public zzexk(zzclp zzclpVar, zzijf zzijfVar) {
        this.f30530a = zzclpVar;
        this.f30531b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzexi zzb() {
        return new zzexi(this.f30530a.a(), (Intent) this.f30531b.zzb());
    }
}
