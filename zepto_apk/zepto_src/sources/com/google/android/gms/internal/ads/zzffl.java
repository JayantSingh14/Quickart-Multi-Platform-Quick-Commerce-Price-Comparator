package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzffl implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f31013a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f31014b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f31015c;

    public zzffl(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f31013a = zzijhVar;
        this.f31014b = zzijfVar;
        this.f31015c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzffj zzb() {
        zzccv zzccvVarI;
        Context context = (Context) this.f31013a.f34899a;
        zzfjv zzfjvVar = (zzfjv) this.f31014b.zzb();
        zzfkn zzfknVar = (zzfkn) this.f31015c.zzb();
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
        if (((Integer) zzbdVar.f21153c.a(zzbgk.m7)).intValue() > 0) {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.V6)).booleanValue() || z) {
                zzfkm zzfkmVarA = zzfknVar.a(zzfkd.f31305c, context, zzfjvVar, new zzfem(new zzfel()));
                zzffa zzffaVar = new zzffa(new zzfez());
                zzgyw zzgywVar = zzcdo.f25982a;
                zzfjz zzfjzVar = zzfkmVarA.f31323a;
                return new zzfeq(zzffaVar, new zzfew(zzfjzVar, zzgywVar), zzfkmVarA.f31324b, ((zzfka) zzfjzVar).f31293b.f31313g, zzgywVar);
            }
        }
        return new zzfez();
    }
}
