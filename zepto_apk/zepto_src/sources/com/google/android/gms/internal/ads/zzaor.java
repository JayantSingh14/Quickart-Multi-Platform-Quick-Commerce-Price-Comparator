package com.google.android.gms.internal.ads;

import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzaor implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final String f23971a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23972b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23973c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeq f23974d;

    /* renamed from: e, reason: collision with root package name */
    public zzaga f23975e;

    /* renamed from: f, reason: collision with root package name */
    public String f23976f;

    /* renamed from: g, reason: collision with root package name */
    public zzv f23977g;

    /* renamed from: h, reason: collision with root package name */
    public int f23978h;

    /* renamed from: i, reason: collision with root package name */
    public int f23979i;

    /* renamed from: j, reason: collision with root package name */
    public int f23980j;

    /* renamed from: k, reason: collision with root package name */
    public int f23981k;

    /* renamed from: l, reason: collision with root package name */
    public long f23982l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23983m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public int u;
    public String v;

    public zzaor(String str, int i2) {
        this.f23971a = str;
        this.f23972b = i2;
        zzer zzerVar = new zzer(1024);
        this.f23973c = zzerVar;
        byte[] bArr = zzerVar.f30144a;
        this.f23974d = new zzeq(bArr, bArr.length);
        this.f23982l = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f23982l = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) throws zzat {
        int iH;
        int i2;
        int iH2;
        boolean zG;
        int i3;
        this.f23975e.getClass();
        while (zzerVar.B() > 0) {
            int i4 = this.f23978h;
            if (i4 != 0) {
                if (i4 != 1) {
                    zzeq zzeqVar = this.f23974d;
                    zzer zzerVar2 = this.f23973c;
                    if (i4 != 2) {
                        int iMin = Math.min(zzerVar.B(), this.f23980j - this.f23979i);
                        zzerVar.H(this.f23979i, zzeqVar.f30084a, iMin);
                        int i5 = this.f23979i + iMin;
                        this.f23979i = i5;
                        if (i5 == this.f23980j) {
                            zzeqVar.d(0);
                            if (zzeqVar.g()) {
                                if (this.f23983m) {
                                }
                                this.f23978h = 0;
                            } else {
                                this.f23983m = true;
                                int iH3 = zzeqVar.h(1);
                                if (iH3 == 1) {
                                    iH2 = zzeqVar.h(1);
                                    i2 = 1;
                                } else {
                                    i2 = iH3;
                                    iH2 = 0;
                                }
                                this.n = iH2;
                                if (iH2 != 0) {
                                    throw zzat.a(null, null);
                                }
                                if (i2 == 1) {
                                    zzeqVar.h((zzeqVar.h(2) + 1) * 8);
                                    i2 = 1;
                                }
                                if (!zzeqVar.g()) {
                                    throw zzat.a(null, null);
                                }
                                this.o = zzeqVar.h(6);
                                int iH4 = zzeqVar.h(4);
                                int iH5 = zzeqVar.h(3);
                                if (iH4 != 0 || iH5 != 0) {
                                    throw zzat.a(null, null);
                                }
                                if (i2 == 0) {
                                    int i6 = (zzeqVar.f30085b * 8) + zzeqVar.f30086c;
                                    int iB = zzeqVar.b();
                                    zzadm zzadmVarA = zzadn.a(zzeqVar, true);
                                    this.v = zzadmVarA.f22802c;
                                    this.s = zzadmVarA.f22800a;
                                    this.u = zzadmVarA.f22801b;
                                    int iB2 = iB - zzeqVar.b();
                                    zzeqVar.d(i6);
                                    byte[] bArr = new byte[(iB2 + 7) / 8];
                                    zzeqVar.j(iB2, bArr);
                                    zzt zztVar = new zzt();
                                    zztVar.f35564a = this.f23976f;
                                    zztVar.d("video/mp2t");
                                    zztVar.e("audio/mp4a-latm");
                                    zztVar.f35572i = this.v;
                                    zztVar.D = this.u;
                                    zztVar.E = this.s;
                                    zztVar.o = Collections.singletonList(bArr);
                                    zztVar.f35567d = this.f23971a;
                                    zztVar.f35569f = this.f23972b;
                                    zzv zzvVar = new zzv(zztVar);
                                    if (!zzvVar.equals(this.f23977g)) {
                                        this.f23977g = zzvVar;
                                        this.t = 1024000000 / zzvVar.F;
                                        this.f23975e.c(zzvVar);
                                    }
                                } else {
                                    int iB3 = zzeqVar.b();
                                    zzadm zzadmVarA2 = zzadn.a(zzeqVar, true);
                                    this.v = zzadmVarA2.f22802c;
                                    this.s = zzadmVarA2.f22800a;
                                    this.u = zzadmVarA2.f22801b;
                                    zzeqVar.f(zzeqVar.h((zzeqVar.h(2) + 1) * 8) - (iB3 - zzeqVar.b()));
                                }
                                int iH6 = zzeqVar.h(3);
                                this.p = iH6;
                                if (iH6 == 0) {
                                    zzeqVar.f(8);
                                } else if (iH6 == 1) {
                                    zzeqVar.f(9);
                                } else if (iH6 == 3 || iH6 == 4 || iH6 == 5) {
                                    zzeqVar.f(6);
                                } else {
                                    if (iH6 != 6 && iH6 != 7) {
                                        throw new IllegalStateException();
                                    }
                                    zzeqVar.f(1);
                                }
                                boolean zG2 = zzeqVar.g();
                                this.q = zG2;
                                this.r = 0L;
                                if (zG2) {
                                    if (i2 != 1) {
                                        do {
                                            zG = zzeqVar.g();
                                            this.r = (this.r << 8) + zzeqVar.h(8);
                                        } while (zG);
                                    } else {
                                        this.r = zzeqVar.h((zzeqVar.h(2) + 1) * 8);
                                    }
                                }
                                if (zzeqVar.g()) {
                                    zzeqVar.f(8);
                                }
                            }
                            if (this.n != 0) {
                                throw zzat.a(null, null);
                            }
                            if (this.o != 0) {
                                throw zzat.a(null, null);
                            }
                            if (this.p != 0) {
                                throw zzat.a(null, null);
                            }
                            int i7 = 0;
                            do {
                                iH = zzeqVar.h(8);
                                i7 += iH;
                            } while (iH == 255);
                            int i8 = (zzeqVar.f30085b * 8) + zzeqVar.f30086c;
                            if ((i8 & 7) == 0) {
                                zzerVar2.E(i8 >> 3);
                            } else {
                                zzeqVar.j(i7 * 8, zzerVar2.f30144a);
                                zzerVar2.E(0);
                            }
                            this.f23975e.b(i7, zzerVar2);
                            zzgqa.f(this.f23982l != -9223372036854775807L);
                            this.f23975e.e(this.f23982l, 1, i7, 0, null);
                            this.f23982l += this.t;
                            if (this.q) {
                                zzeqVar.f((int) this.r);
                            }
                            this.f23978h = 0;
                        } else {
                            continue;
                        }
                    } else {
                        int iK = ((this.f23981k & (-225)) << 8) | zzerVar.K();
                        this.f23980j = iK;
                        if (iK > zzerVar2.f30144a.length) {
                            zzerVar2.y(iK);
                            byte[] bArr2 = zzerVar2.f30144a;
                            int length = bArr2.length;
                            zzeqVar.f30084a = bArr2;
                            i3 = 0;
                            zzeqVar.f30085b = 0;
                            zzeqVar.f30086c = 0;
                            zzeqVar.f30087d = length;
                        } else {
                            i3 = 0;
                        }
                        this.f23979i = i3;
                        this.f23978h = 3;
                    }
                } else {
                    int iK2 = zzerVar.K();
                    if ((iK2 & 224) == 224) {
                        this.f23981k = iK2;
                        this.f23978h = 2;
                    } else if (iK2 != 86) {
                        this.f23978h = 0;
                    }
                }
            } else if (zzerVar.K() == 86) {
                this.f23978h = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23975e = zzaerVar.e(zzapuVar.f24111d, 1);
        zzapuVar.b();
        this.f23976f = zzapuVar.f24112e;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23978h = 0;
        this.f23982l = -9223372036854775807L;
        this.f23983m = false;
    }
}
