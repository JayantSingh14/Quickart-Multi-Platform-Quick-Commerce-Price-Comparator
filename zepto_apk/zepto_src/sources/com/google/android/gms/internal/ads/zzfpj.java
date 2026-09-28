package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfpj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f31568a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f31569b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijp f31570c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31571d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f31572e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f31573f;

    public zzfpj(zzclp zzclpVar, zzijf zzijfVar, zzijp zzijpVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f31568a = zzclpVar;
        this.f31569b = zzijfVar;
        this.f31570c = zzijpVar;
        this.f31571d = zzijfVar2;
        this.f31572e = zzijfVar3;
        this.f31573f = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f31568a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzfpi(contextA, zzgywVar, (zzgyx) this.f31569b.zzb(), (com.google.android.gms.ads.internal.util.client.zzu) this.f31570c.zzb(), (zzfpa) this.f31571d.zzb(), (zzfnr) this.f31572e.zzb(), (zzcld) this.f31573f.zzb());
    }
}
