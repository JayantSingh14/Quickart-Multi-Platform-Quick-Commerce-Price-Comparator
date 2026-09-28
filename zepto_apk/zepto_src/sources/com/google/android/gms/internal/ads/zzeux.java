package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzeux implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzerp f30378a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30379b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30380c;

    public zzeux(zzerp zzerpVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30378a = zzerpVar;
        this.f30379b = zzijfVar;
        this.f30380c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzern zzernVar = new zzern(this.f30378a.f30174a.a());
        Clock clock = (Clock) this.f30379b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzernVar, TTL.MAX_VALUE, clock, zzgywVar, (zzdxe) this.f30380c.zzb());
    }
}
