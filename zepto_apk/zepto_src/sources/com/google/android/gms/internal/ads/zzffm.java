package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzffm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f31016a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f31017b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f31018c;

    public zzffm(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f31016a = zzijhVar;
        this.f31017b = zzijfVar;
        this.f31018c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzffj zzb() {
        zzccv zzccvVarI;
        Context context = (Context) this.f31016a.f34899a;
        zzfjv zzfjvVar = (zzfjv) this.f31017b.zzb();
        zzfkn zzfknVar = (zzfkn) this.f31018c.zzb();
        zzbgb zzbgbVar = zzbgk.W6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzccvVarI = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i();
        } else {
            com.google.android.gms.ads.internal.util.zzj zzjVarG = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
            synchronized (zzjVarG.f21580a) {
                zzccvVarI = zzjVarG.n;
            }
        }
        boolean z = false;
        if (zzccvVarI != null && zzccvVarI.f25916j) {
            z = true;
        }
        if (((Integer) zzbdVar.f21153c.a(zzbgk.Y6)).intValue() > 0) {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.V6)).booleanValue() || z) {
                zzfkm zzfkmVarA = zzfknVar.a(zzfkd.f31303a, context, zzfjvVar, new zzfem(new zzfel()));
                zzffa zzffaVar = new zzffa(new zzfez());
                zzgyw zzgywVar = zzcdo.f25982a;
                zzfjz zzfjzVar = zzfkmVarA.f31323a;
                return new zzfeq(zzffaVar, new zzfew(zzfjzVar, zzgywVar), zzfkmVarA.f31324b, ((zzfka) zzfjzVar).f31293b.f31313g, zzgywVar);
            }
        }
        return new zzfez();
    }
}
