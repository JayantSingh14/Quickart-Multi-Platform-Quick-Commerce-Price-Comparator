package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzevi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeym f30408a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30409b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30410c;

    public zzevi(zzeym zzeymVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30408a = zzeymVar;
        this.f30409b = zzijfVar;
        this.f30410c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzeyk zzeykVarZzb = this.f30408a.zzb();
        Clock clock = (Clock) this.f30409b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzeykVarZzb, TTL.MAX_VALUE, clock, zzgywVar, (zzdxe) this.f30410c.zzb());
    }
}
