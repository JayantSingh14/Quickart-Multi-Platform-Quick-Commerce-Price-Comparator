package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
public final class zzefx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f29250a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmd f29251b;

    /* renamed from: c, reason: collision with root package name */
    public final zzegf f29252c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29253d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29254e;

    public zzefx(zzclp zzclpVar, zzcmd zzcmdVar, zzegf zzegfVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f29250a = zzclpVar;
        this.f29251b = zzcmdVar;
        this.f29252c = zzegfVar;
        this.f29253d = zzijfVar;
        this.f29254e = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f29250a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzbzi zzbziVar = new zzbzi();
        zzclg zzclgVar = (zzclg) this.f29251b.f26535a.f34899a;
        zzijo.a(zzclgVar);
        zzege zzegeVar = new zzege(this.f29252c.f29279a.zzb());
        ArrayDeque arrayDeque = (ArrayDeque) this.f29253d.zzb();
        new zzegb();
        return new zzefw(contextA, zzgywVar, zzbziVar, zzclgVar, zzegeVar, arrayDeque, (zzfnr) this.f29254e.zzb());
    }
}
