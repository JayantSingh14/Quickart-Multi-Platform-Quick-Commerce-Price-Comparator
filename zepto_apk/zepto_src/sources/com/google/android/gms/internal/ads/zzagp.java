package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
final class zzagp {

    /* renamed from: a, reason: collision with root package name */
    public final zzago f23040a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga f23041b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23042c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23043d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23044e;

    /* renamed from: f, reason: collision with root package name */
    public int f23045f;

    /* renamed from: g, reason: collision with root package name */
    public int f23046g;

    /* renamed from: h, reason: collision with root package name */
    public int f23047h;

    /* renamed from: i, reason: collision with root package name */
    public int f23048i;

    /* renamed from: j, reason: collision with root package name */
    public int f23049j;

    /* renamed from: k, reason: collision with root package name */
    public int f23050k;

    /* renamed from: l, reason: collision with root package name */
    public long f23051l;

    /* renamed from: m, reason: collision with root package name */
    public long[] f23052m;
    public int[] n;

    public zzagp(int i2, zzago zzagoVar, zzaga zzagaVar) {
        this.f23040a = zzagoVar;
        int iA = zzagoVar.a();
        boolean z = true;
        if (iA != 1) {
            if (iA == 2) {
                iA = 2;
            } else {
                z = false;
            }
        }
        zzgqa.a(z);
        int i3 = ((i2 / 10) + 48) | (((i2 % 10) + 48) << 8);
        this.f23042c = (iA == 2 ? 1667497984 : 1651965952) | i3;
        long j2 = zzagoVar.f23036c;
        RoundingMode roundingMode = RoundingMode.DOWN;
        int i4 = zzagoVar.f23037d;
        this.f23044e = zzfj.u(i4, zzagoVar.f23035b * 1000000, j2, roundingMode);
        this.f23041b = zzagaVar;
        this.f23043d = iA == 2 ? 1650720768 | i3 : -1;
        this.f23051l = -1L;
        this.f23052m = new long[512];
        this.n = new int[512];
        this.f23045f = i4;
    }

    public final zzafp a(long j2) {
        if (this.f23050k == 0) {
            zzafs zzafsVar = new zzafs(0L, this.f23051l);
            return new zzafp(zzafsVar, zzafsVar);
        }
        int i2 = (int) (j2 / ((this.f23044e * 1) / this.f23045f));
        int iP = zzfj.p(this.n, i2, true, true);
        if (this.n[iP] == i2) {
            zzafs zzafsVarB = b(iP);
            return new zzafp(zzafsVarB, zzafsVarB);
        }
        zzafs zzafsVarB2 = b(iP);
        int i3 = iP + 1;
        return i3 < this.f23052m.length ? new zzafp(zzafsVarB2, b(i3)) : new zzafp(zzafsVarB2, zzafsVarB2);
    }

    public final zzafs b(int i2) {
        return new zzafs(((this.f23044e * 1) / this.f23045f) * this.n[i2], this.f23052m[i2]);
    }
}
