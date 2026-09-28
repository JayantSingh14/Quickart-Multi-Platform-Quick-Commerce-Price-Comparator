package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzenb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzena f29849a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29850b;

    /* renamed from: c, reason: collision with root package name */
    public final zzemu f29851c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29852d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29853e;

    public zzenb(zzena zzenaVar, zzijf zzijfVar, zzemu zzemuVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f29849a = zzenaVar;
        this.f29850b = zzijfVar;
        this.f29851c = zzemuVar;
        this.f29852d = zzijfVar2;
        this.f29853e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Clock clock = (Clock) this.f29850b.zzb();
        zzemu zzemuVar = this.f29851c;
        zzemt zzemtVar = new zzemt((zzfjd) zzemuVar.f29813a.zzb(), (zzdur) zzemuVar.f29814b.zzb(), (zzdxe) zzemuVar.f29815c.zzb());
        zzejl zzejlVar = (zzejl) this.f29852d.zzb();
        zzfpi zzfpiVar = (zzfpi) this.f29853e.zzb();
        zzemr zzemrVar = this.f29849a.f29848a;
        return zzemrVar != null ? zzemrVar : new zzemr(clock, zzemtVar, zzejlVar, zzfpiVar);
    }
}
