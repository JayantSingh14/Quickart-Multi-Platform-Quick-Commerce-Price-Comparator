package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzeuz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzett f30384a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30385b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30386c;

    public zzeuz(zzett zzettVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30384a = zzettVar;
        this.f30385b = zzijfVar;
        this.f30386c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzetr zzetrVarZzb = this.f30384a.zzb();
        Clock clock = (Clock) this.f30385b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeul(zzetrVarZzb, TTL.MAX_VALUE, clock, zzgywVar, (zzdxe) this.f30386c.zzb());
    }
}
