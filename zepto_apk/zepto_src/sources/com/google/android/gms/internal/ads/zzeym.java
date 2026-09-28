package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes4.dex */
public final class zzeym implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30588a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30589b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclp f30590c;

    public zzeym(zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30588a = zzijfVar;
        this.f30589b = zzijfVar2;
        this.f30590c = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzeyk zzb() {
        return new zzeyk((ApplicationInfo) this.f30588a.zzb(), (PackageInfo) this.f30589b.zzb(), this.f30590c.a());
    }
}
