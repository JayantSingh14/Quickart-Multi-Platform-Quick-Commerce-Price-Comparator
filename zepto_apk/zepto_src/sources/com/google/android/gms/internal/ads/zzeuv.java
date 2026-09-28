package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzeuv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfaf f30372a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30373b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30374c;

    public zzeuv(zzfaf zzfafVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30372a = zzfafVar;
        this.f30373b = zzijfVar;
        this.f30374c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f30372a.f30730a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzfad zzfadVar = new zzfad(contextA, zzgywVar);
        Clock clock = (Clock) this.f30373b.zzb();
        zzijo.a(zzgywVar);
        return new zzeul(zzfadVar, TTL.MAX_VALUE, clock, zzgywVar, (zzdxe) this.f30374c.zzb());
    }
}
