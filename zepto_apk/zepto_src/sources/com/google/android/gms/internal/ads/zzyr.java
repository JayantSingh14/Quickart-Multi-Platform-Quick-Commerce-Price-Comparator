package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzyr extends zzzm implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public final int f35918e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f35919f;

    /* renamed from: g, reason: collision with root package name */
    public final String f35920g;

    /* renamed from: h, reason: collision with root package name */
    public final zzzf f35921h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f35922i;

    /* renamed from: j, reason: collision with root package name */
    public final int f35923j;

    /* renamed from: k, reason: collision with root package name */
    public final int f35924k;

    /* renamed from: l, reason: collision with root package name */
    public final int f35925l;

    /* renamed from: m, reason: collision with root package name */
    public final int f35926m;
    public final boolean n;
    public final int o;
    public final int p;
    public final boolean q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final boolean x;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzyr(int r9, com.google.android.gms.internal.ads.zzbg r10, int r11, com.google.android.gms.internal.ads.zzzf r12, int r13, boolean r14, com.google.android.gms.internal.ads.zzgqb r15) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyr.<init>(int, com.google.android.gms.internal.ads.zzbg, int, com.google.android.gms.internal.ads.zzzf, int, boolean, com.google.android.gms.internal.ads.zzgqb):void");
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final /* bridge */ /* synthetic */ boolean a(zzzm zzzmVar) {
        String str;
        int i2;
        zzyr zzyrVar = (zzyr) zzzmVar;
        this.f35921h.getClass();
        zzv zzvVar = this.f35973d;
        int i3 = zzvVar.E;
        if (i3 == -1) {
            return false;
        }
        zzv zzvVar2 = zzyrVar.f35973d;
        return i3 == zzvVar2.E && (str = zzvVar.f35691m) != null && TextUtils.equals(str, zzvVar2.f35691m) && (i2 = zzvVar.F) != -1 && i2 == zzvVar2.F && this.v == zzyrVar.v && this.w == zzyrVar.w;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyr zzyrVar) {
        Comparator zzgvgVar;
        boolean z = this.f35922i;
        boolean z2 = this.f35919f;
        if (z2 && z) {
            zzgvgVar = zzzu.f35988k;
        } else {
            zzgux zzguxVar = zzzu.f35988k;
            zzgvgVar = new zzgvg();
        }
        zzgsq zzgsqVarD = zzgsq.f33167a.d(z, zzyrVar.f35922i);
        Integer numValueOf = Integer.valueOf(this.f35924k);
        Integer numValueOf2 = Integer.valueOf(zzyrVar.f35924k);
        zzgvf zzgvfVar = zzgvf.f33255a;
        zzgsq zzgsqVarA = zzgsqVarD.a(numValueOf, numValueOf2, zzgvfVar).b(this.f35923j, zzyrVar.f35923j).b(this.f35925l, zzyrVar.f35925l).a(Integer.valueOf(this.f35926m), Integer.valueOf(zzyrVar.f35926m), zzgvfVar).d(this.q, zzyrVar.q).d(this.n, zzyrVar.n).a(Integer.valueOf(this.o), Integer.valueOf(zzyrVar.o), zzgvfVar).b(this.p, zzyrVar.p).d(z2, zzyrVar.f35919f).a(Integer.valueOf(this.u), Integer.valueOf(zzyrVar.u), zzgvfVar);
        this.f35921h.getClass();
        zzgsq zzgsqVarA2 = zzgsqVarA.d(this.v, zzyrVar.v).d(this.w, zzyrVar.w).d(this.x, zzyrVar.x).a(Integer.valueOf(this.r), Integer.valueOf(zzyrVar.r), zzgvgVar).a(Integer.valueOf(this.s), Integer.valueOf(zzyrVar.s), zzgvgVar);
        if (Objects.equals(this.f35920g, zzyrVar.f35920g)) {
            zzgsqVarA2 = zzgsqVarA2.a(Integer.valueOf(this.t), Integer.valueOf(zzyrVar.t), zzgvgVar);
        }
        return zzgsqVarA2.e();
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final int zza() {
        return this.f35918e;
    }
}
