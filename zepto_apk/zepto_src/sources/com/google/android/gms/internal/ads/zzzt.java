package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzzt extends zzzm {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f35979e;

    /* renamed from: f, reason: collision with root package name */
    public final zzzf f35980f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35981g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f35982h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f35983i;

    /* renamed from: j, reason: collision with root package name */
    public final int f35984j;

    /* renamed from: k, reason: collision with root package name */
    public final int f35985k;

    /* renamed from: l, reason: collision with root package name */
    public final int f35986l;

    /* renamed from: m, reason: collision with root package name */
    public final int f35987m;
    public final int n;
    public final int o;
    public final int p;
    public final boolean q;
    public final int r;
    public final int s;
    public final boolean t;
    public final boolean u;
    public final int v;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzzt(int r7, com.google.android.gms.internal.ads.zzbg r8, int r9, com.google.android.gms.internal.ads.zzzf r10, int r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzt.<init>(int, com.google.android.gms.internal.ads.zzbg, int, com.google.android.gms.internal.ads.zzzf, int, java.lang.String, boolean):void");
    }

    public static int b(zzzt zzztVar, zzzt zzztVar2) {
        zzgsq zzgsqVarD = zzgsq.f33167a.d(zzztVar.f35982h, zzztVar2.f35982h);
        Integer numValueOf = Integer.valueOf(zzztVar.f35987m);
        Integer numValueOf2 = Integer.valueOf(zzztVar2.f35987m);
        zzgvf zzgvfVar = zzgvf.f33255a;
        zzgsq zzgsqVarA = zzgsqVarD.a(numValueOf, numValueOf2, zzgvfVar).b(zzztVar.n, zzztVar2.n).b(zzztVar.o, zzztVar2.o).a(Integer.valueOf(zzztVar.p), Integer.valueOf(zzztVar2.p), zzgvfVar).d(zzztVar.q, zzztVar2.q).b(zzztVar.r, zzztVar2.r).d(zzztVar.f35983i, zzztVar2.f35983i).d(zzztVar.f35979e, zzztVar2.f35979e).d(zzztVar.f35981g, zzztVar2.f35981g).a(Integer.valueOf(zzztVar.f35986l), Integer.valueOf(zzztVar2.f35986l), zzgvfVar);
        boolean z = zzztVar.t;
        zzgsq zzgsqVarD2 = zzgsqVarA.d(z, zzztVar2.t);
        boolean z2 = zzztVar.u;
        zzgsq zzgsqVarD3 = zzgsqVarD2.d(z2, zzztVar2.u);
        if (z && z2) {
            zzgsqVarD3 = zzgsqVarD3.b(zzztVar.v, zzztVar2.v);
        }
        return zzgsqVarD3.e();
    }

    public static int c(zzzt zzztVar, zzzt zzztVar2) {
        Comparator zzgvgVar;
        if (zzztVar.f35979e && zzztVar.f35982h) {
            zzgvgVar = zzzu.f35988k;
        } else {
            zzgux zzguxVar = zzzu.f35988k;
            zzgvgVar = new zzgvg();
        }
        zzztVar.f35980f.getClass();
        return zzgso.f(zzgvgVar.compare(Integer.valueOf(zzztVar.f35985k), Integer.valueOf(zzztVar2.f35985k))).a(Integer.valueOf(zzztVar.f35984j), Integer.valueOf(zzztVar2.f35984j), zzgvgVar).e();
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final /* bridge */ /* synthetic */ boolean a(zzzm zzzmVar) {
        zzzt zzztVar = (zzzt) zzzmVar;
        if (!Objects.equals(this.f35973d.f35691m, zzztVar.f35973d.f35691m)) {
            return false;
        }
        this.f35980f.getClass();
        return this.t == zzztVar.t && this.u == zzztVar.u;
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final int zza() {
        return this.s;
    }
}
