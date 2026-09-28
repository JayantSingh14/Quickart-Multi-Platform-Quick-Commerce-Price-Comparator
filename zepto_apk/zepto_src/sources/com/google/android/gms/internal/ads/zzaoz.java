package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaoz implements zzapv {

    /* renamed from: a, reason: collision with root package name */
    public final zzaog f24021a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeq f24022b = new zzeq(new byte[10], 10);

    /* renamed from: c, reason: collision with root package name */
    public int f24023c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f24024d;

    /* renamed from: e, reason: collision with root package name */
    public zzfg f24025e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f24026f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24027g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f24028h;

    /* renamed from: i, reason: collision with root package name */
    public int f24029i;

    /* renamed from: j, reason: collision with root package name */
    public int f24030j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f24031k;

    public zzaoz(zzaog zzaogVar) {
        this.f24021a = zzaogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapv
    public final void a(zzfg zzfgVar, zzaer zzaerVar, zzapu zzapuVar) {
        this.f24025e = zzfgVar;
        this.f24021a.e(zzaerVar, zzapuVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.internal.ads.zzeq] */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r5v26 */
    @Override // com.google.android.gms.internal.ads.zzapv
    public final void b(int i2, zzer zzerVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        long jC;
        long j2;
        this.f24025e.getClass();
        int i7 = i2 & 1;
        zzaog zzaogVar = this.f24021a;
        int i8 = 1;
        boolean z = false;
        int i9 = -1;
        int i10 = 2;
        if (i7 != 0) {
            int i11 = this.f24023c;
            if (i11 != 0 && i11 != 1) {
                if (i11 != 2) {
                    int i12 = this.f24030j;
                    if (i12 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i12);
                        sb.append(" more bytes");
                        zzee.c("PesReader", sb.toString());
                    }
                    zzaogVar.c(zzerVar.f30146c == 0);
                } else {
                    zzee.c("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            this.f24023c = 1;
            this.f24024d = 0;
        }
        int i13 = i2;
        while (zzerVar.B() > 0) {
            int i14 = this.f24023c;
            if (i14 != 0) {
                ?? r10 = this.f24022b;
                if (i14 != i8) {
                    if (i14 != i10) {
                        int iB = zzerVar.B();
                        int i15 = this.f24030j;
                        int i16 = i15 == i9 ? z ? 1 : 0 : iB - i15;
                        if (i16 > 0) {
                            iB -= i16;
                            zzerVar.C(zzerVar.f30145b + iB);
                        }
                        zzaogVar.d(zzerVar);
                        int i17 = this.f24030j;
                        if (i17 != i9) {
                            int i18 = i17 - iB;
                            this.f24030j = i18;
                            if (i18 == 0) {
                                zzaogVar.c(z);
                                this.f24023c = i8;
                                this.f24024d = z ? 1 : 0;
                            }
                        }
                    } else {
                        if (c(zzerVar, r10.f30084a, Math.min(10, this.f24029i)) && c(zzerVar, null, this.f24029i)) {
                            r10.d(z ? 1 : 0);
                            if (this.f24026f) {
                                r10.f(4);
                                long jH = r10.h(3);
                                r10.f(i8);
                                int iH = r10.h(15) << 15;
                                r10.f(i8);
                                long jH2 = r10.h(15);
                                r10.f(i8);
                                if (this.f24028h || !this.f24027g) {
                                    j2 = jH;
                                } else {
                                    r10.f(4);
                                    j2 = jH;
                                    r10.f(i8);
                                    int iH2 = r10.h(15) << 15;
                                    r10.f(i8);
                                    long jH3 = r10.h(15);
                                    r10.f(i8);
                                    this.f24025e.c((r10.h(3) << 30) | iH2 | jH3);
                                    this.f24028h = true;
                                }
                                jC = this.f24025e.c((j2 << 30) | iH | jH2);
                            } else {
                                jC = -9223372036854775807L;
                            }
                            i13 |= true != this.f24031k ? 0 : 4;
                            zzaogVar.b(i13, jC);
                            this.f24023c = 3;
                            this.f24024d = 0;
                            z = false;
                            i8 = 1;
                            i9 = -1;
                            i10 = 2;
                        }
                    }
                    i3 = i8;
                    i4 = i9;
                    i5 = i10;
                } else {
                    ?? r4 = z ? 1 : 0;
                    if (c(zzerVar, r10.f30084a, 9)) {
                        r10.d(r4);
                        int iH3 = r10.h(24);
                        i3 = 1;
                        if (iH3 != 1) {
                            b.d(new StringBuilder(String.valueOf(iH3).length() + 30), "Unexpected start code prefix: ", iH3, "PesReader");
                            i4 = -1;
                            this.f24030j = -1;
                            i6 = 0;
                            i5 = 2;
                        } else {
                            r10.f(8);
                            int iH4 = r10.h(16);
                            r10.f(5);
                            this.f24031k = r10.g();
                            i5 = 2;
                            r10.f(2);
                            this.f24026f = r10.g();
                            this.f24027g = r10.g();
                            r10.f(6);
                            int iH5 = r10.h(8);
                            this.f24029i = iH5;
                            if (iH4 == 0) {
                                this.f24030j = -1;
                                i6 = 2;
                                i4 = -1;
                            } else {
                                int i19 = (iH4 - 3) - iH5;
                                this.f24030j = i19;
                                if (i19 < 0) {
                                    b.d(new StringBuilder(String.valueOf(i19).length() + 36), "Found negative packet payload size: ", i19, "PesReader");
                                    i4 = -1;
                                    this.f24030j = -1;
                                } else {
                                    i4 = -1;
                                }
                                i6 = 2;
                            }
                        }
                        this.f24023c = i6;
                        z = false;
                        this.f24024d = 0;
                    } else {
                        z = r4;
                        i4 = -1;
                        i5 = 2;
                        i3 = 1;
                    }
                }
            } else {
                i3 = i8;
                i4 = i9;
                i5 = i10;
                zzerVar.G(zzerVar.B());
            }
            i10 = i5;
            i9 = i4;
            i8 = i3;
        }
    }

    public final boolean c(zzer zzerVar, byte[] bArr, int i2) {
        int iMin = Math.min(zzerVar.B(), i2 - this.f24024d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzerVar.G(iMin);
        } else {
            zzerVar.H(this.f24024d, bArr, iMin);
        }
        int i3 = this.f24024d + iMin;
        this.f24024d = i3;
        return i3 == i2;
    }

    @Override // com.google.android.gms.internal.ads.zzapv
    public final void zzb() {
        this.f24023c = 0;
        this.f24024d = 0;
        this.f24028h = false;
        this.f24021a.zza();
    }
}
