package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
final class zzaqb implements zzaqa {

    /* renamed from: a, reason: collision with root package name */
    public final zzaer f24130a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga f24131b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaqe f24132c;

    /* renamed from: d, reason: collision with root package name */
    public final zzv f24133d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24134e;

    /* renamed from: f, reason: collision with root package name */
    public long f24135f;

    /* renamed from: g, reason: collision with root package name */
    public int f24136g;

    /* renamed from: h, reason: collision with root package name */
    public long f24137h;

    public zzaqb(zzaer zzaerVar, zzaga zzagaVar, zzaqe zzaqeVar, String str, int i2) throws zzat {
        this.f24130a = zzaerVar;
        this.f24131b = zzagaVar;
        this.f24132c = zzaqeVar;
        int i3 = zzaqeVar.f24149d;
        int i4 = zzaqeVar.f24146a;
        int i5 = (i3 * i4) / 8;
        int i6 = zzaqeVar.f24148c;
        if (i6 != i5) {
            throw zzat.a(null, androidx.fragment.app.e.n(i5, i6, "Expected block size: ", "; got: ", new StringBuilder(String.valueOf(i5).length() + 28 + String.valueOf(i6).length())));
        }
        int i7 = zzaqeVar.f24147b;
        int i8 = i7 * i5;
        int i9 = i8 * 8;
        int iMax = Math.max(i5, i8 / 10);
        this.f24134e = iMax;
        zzt zztVar = new zzt();
        zztVar.d("audio/wav");
        zztVar.e(str);
        zztVar.f35570g = i9;
        zztVar.f35571h = i9;
        zztVar.f35576m = iMax;
        zztVar.D = i4;
        zztVar.E = i7;
        zztVar.F = i2;
        this.f24133d = new zzv(zztVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void a(long j2) {
        this.f24135f = j2;
        this.f24136g = 0;
        this.f24137h = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void b(int i2, long j2) {
        this.f24130a.d(new zzaqh(this.f24132c, 1, i2, j2));
        this.f24131b.c(this.f24133d);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final boolean c(zzaef zzaefVar, long j2) {
        int i2;
        int i3;
        long j3 = j2;
        while (j3 > 0 && (i2 = this.f24136g) < (i3 = this.f24134e)) {
            int iF = this.f24131b.f(zzaefVar, (int) Math.min(i3 - i2, j3), true);
            if (iF == -1) {
                j3 = 0;
            } else {
                this.f24136g += iF;
                j3 -= iF;
            }
        }
        int i4 = this.f24136g;
        int i5 = this.f24132c.f24148c;
        int i6 = i4 / i5;
        if (i6 > 0) {
            long jU = this.f24135f + zzfj.u(this.f24137h, 1000000L, r2.f24147b, RoundingMode.DOWN);
            int i7 = i6 * i5;
            int i8 = this.f24136g - i7;
            this.f24131b.e(jU, 1, i7, i8, null);
            this.f24137h += i6;
            this.f24136g = i8;
        }
        return j3 <= 0;
    }
}
