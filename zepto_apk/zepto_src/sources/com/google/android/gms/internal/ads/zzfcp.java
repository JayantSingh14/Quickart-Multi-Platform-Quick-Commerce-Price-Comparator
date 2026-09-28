package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfcp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30850a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfcg f30851b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfcd f30852c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f30853d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfci f30854e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfcj f30855f;

    public zzfcp(zzijf zzijfVar, zzfcg zzfcgVar, zzfcd zzfcdVar, zzijf zzijfVar2, zzfci zzfciVar, zzfcj zzfcjVar) {
        this.f30850a = zzijfVar;
        this.f30851b = zzfcgVar;
        this.f30852c = zzfcdVar;
        this.f30853d = zzijfVar2;
        this.f30854e = zzfciVar;
        this.f30855f = zzfcjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzcda zzcdaVar = (zzcda) this.f30850a.zzb();
        boolean z = this.f30851b.f30837a.f30832a.f25730k;
        new zzccq();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzijo.a(this.f30852c.f30834a.f30832a.f25723d);
        return new zzfcn(zzcdaVar, z, zzgywVar, (ScheduledExecutorService) this.f30853d.zzb(), this.f30854e.f30839a.a(), this.f30855f.f30840a.f30832a.o);
    }
}
