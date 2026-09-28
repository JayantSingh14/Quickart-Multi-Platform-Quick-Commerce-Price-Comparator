package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzct {

    /* renamed from: a, reason: collision with root package name */
    public final int f27082a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27083b;

    /* renamed from: c, reason: collision with root package name */
    public final float f27084c;

    /* renamed from: d, reason: collision with root package name */
    public final float f27085d;

    /* renamed from: e, reason: collision with root package name */
    public final float f27086e;

    /* renamed from: f, reason: collision with root package name */
    public final int f27087f;

    /* renamed from: g, reason: collision with root package name */
    public final int f27088g;

    /* renamed from: h, reason: collision with root package name */
    public final int f27089h;

    /* renamed from: i, reason: collision with root package name */
    public final zzcr f27090i;

    /* renamed from: j, reason: collision with root package name */
    public int f27091j;

    /* renamed from: k, reason: collision with root package name */
    public int f27092k;

    /* renamed from: l, reason: collision with root package name */
    public int f27093l;

    /* renamed from: m, reason: collision with root package name */
    public int f27094m;
    public int n;
    public int o;
    public int p;
    public double q;

    public zzct(int i2, int i3, float f2, float f3, int i4, boolean z) {
        this.f27082a = i2;
        this.f27083b = i3;
        this.f27084c = f2;
        this.f27085d = f3;
        this.f27086e = i2 / i4;
        this.f27087f = i2 / 400;
        int i5 = i2 / 65;
        this.f27088g = i5;
        this.f27089h = i5 + i5;
        this.f27090i = z ? new zzcq(this) : new zzcs(this);
    }

    public final void a(int i2, int i3) {
        zzcr zzcrVar = this.f27090i;
        zzcrVar.r(i3);
        Object objZzr = zzcrVar.zzr();
        Object objZzq = zzcrVar.zzq();
        int i4 = this.f27092k;
        int i5 = this.f27083b;
        System.arraycopy(objZzr, i2 * i5, objZzq, i4 * i5, i3 * i5);
        this.f27092k += i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzct.b():void");
    }
}
