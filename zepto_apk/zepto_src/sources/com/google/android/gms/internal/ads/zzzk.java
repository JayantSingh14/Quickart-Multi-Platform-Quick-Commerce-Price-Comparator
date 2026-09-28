package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzzk extends zzzm implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public final int f35961e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f35962f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35963g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f35964h;

    /* renamed from: i, reason: collision with root package name */
    public final int f35965i;

    /* renamed from: j, reason: collision with root package name */
    public final int f35966j;

    /* renamed from: k, reason: collision with root package name */
    public final int f35967k;

    /* renamed from: l, reason: collision with root package name */
    public final int f35968l;

    /* renamed from: m, reason: collision with root package name */
    public final int f35969m;
    public final boolean n;

    public zzzk(int i2, zzbg zzbgVar, int i3, zzzf zzzfVar, int i4, String str, String str2) {
        int i5;
        super(i2, zzbgVar, i3);
        int i6 = 0;
        this.f35962f = zzmk.a(i4, false);
        int i7 = this.f35973d.f35683e;
        zzzfVar.getClass();
        this.f35963g = 1 == (i7 & 1);
        this.f35964h = (i7 & 2) != 0;
        zzgtd zzgtdVar = zzzfVar.r;
        zzgtd zzgtdVarN = str2 != null ? zzgtd.n(str2) : zzgtdVar.isEmpty() ? zzgtd.n("") : zzgtdVar;
        int i8 = 0;
        while (true) {
            if (i8 >= ((zzguy) zzgtdVarN).f33234d) {
                i5 = 0;
                i8 = Integer.MAX_VALUE;
                break;
            } else {
                i5 = zzzu.i(this.f35973d, (String) ((zzguy) zzgtdVarN).get(i8), false);
                if (i5 > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.f35965i = i8;
        this.f35966j = i5;
        int i9 = str2 != null ? 1088 : 0;
        int i10 = this.f35973d.f35684f;
        zzgux zzguxVar = zzzu.f35988k;
        int iBitCount = (i10 == 0 || i10 != i9) ? Integer.bitCount(i9 & i10) : Integer.MAX_VALUE;
        this.f35967k = iBitCount;
        zzv zzvVar = this.f35973d;
        this.n = (1088 & zzvVar.f35684f) != 0;
        int iJ = zzzu.j(zzvVar, zzzfVar.s);
        this.f35968l = iJ;
        int i11 = zzzu.i(this.f35973d, str, zzzu.h(str) == null);
        this.f35969m = i11;
        boolean z = i5 > 0 || (zzgtdVar.isEmpty() && iBitCount > 0) || ((zzgtdVar.isEmpty() && iJ != Integer.MAX_VALUE) || this.f35963g || (this.f35964h && i11 > 0));
        if (zzmk.a(i4, zzzfVar.B) && z) {
            i6 = 1;
        }
        this.f35961e = i6;
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final /* bridge */ /* synthetic */ boolean a(zzzm zzzmVar) {
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzzk zzzkVar) {
        zzgsq zzgsqVarD = zzgsq.f33167a.d(this.f35962f, zzzkVar.f35962f);
        Integer numValueOf = Integer.valueOf(this.f35965i);
        Integer numValueOf2 = Integer.valueOf(zzzkVar.f35965i);
        Comparator comparator = zzgvf.f33255a;
        zzgsq zzgsqVarA = zzgsqVarD.a(numValueOf, numValueOf2, comparator);
        int i2 = this.f35966j;
        zzgsq zzgsqVarB = zzgsqVarA.b(i2, zzzkVar.f35966j);
        int i3 = this.f35967k;
        zzgsq zzgsqVarD2 = zzgsqVarB.b(i3, zzzkVar.f35967k).a(Integer.valueOf(this.f35968l), Integer.valueOf(zzzkVar.f35968l), comparator).d(this.f35963g, zzzkVar.f35963g);
        Boolean boolValueOf = Boolean.valueOf(this.f35964h);
        Boolean boolValueOf2 = Boolean.valueOf(zzzkVar.f35964h);
        if (i2 == 0) {
            comparator = zzguv.f33231a;
        }
        zzgsq zzgsqVarB2 = zzgsqVarD2.a(boolValueOf, boolValueOf2, comparator).b(this.f35969m, zzzkVar.f35969m);
        if (i3 == 0) {
            zzgsqVarB2 = zzgsqVarB2.c(this.n, zzzkVar.n);
        }
        return zzgsqVarB2.e();
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final int zza() {
        return this.f35961e;
    }
}
