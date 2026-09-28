package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzaoe implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23852a;

    /* renamed from: c, reason: collision with root package name */
    public final String f23854c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23855d;

    /* renamed from: f, reason: collision with root package name */
    public String f23857f;

    /* renamed from: g, reason: collision with root package name */
    public zzaga f23858g;

    /* renamed from: i, reason: collision with root package name */
    public int f23860i;

    /* renamed from: j, reason: collision with root package name */
    public int f23861j;

    /* renamed from: k, reason: collision with root package name */
    public long f23862k;

    /* renamed from: l, reason: collision with root package name */
    public zzv f23863l;

    /* renamed from: m, reason: collision with root package name */
    public int f23864m;
    public int n;

    /* renamed from: h, reason: collision with root package name */
    public int f23859h = 0;
    public long q = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f23853b = new AtomicInteger();
    public int o = -1;
    public int p = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String f23856e = "video/mp2t";

    public zzaoe(String str, int i2, int i3) {
        this.f23852a = new zzer(new byte[i3]);
        this.f23854c = str;
        this.f23855d = i2;
    }

    public final boolean a(zzer zzerVar, byte[] bArr, int i2) {
        int iMin = Math.min(zzerVar.B(), i2 - this.f23860i);
        zzerVar.H(this.f23860i, bArr, iMin);
        int i3 = this.f23860i + iMin;
        this.f23860i = i3;
        return i3 == i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.q = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) throws zzat {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        long jU;
        int i5;
        int i6;
        int i7;
        int iH;
        int i8;
        int iH2;
        long jU2;
        int i9;
        int i10 = 4;
        this.f23858g.getClass();
        while (zzerVar.B() > 0) {
            int i11 = this.f23859h;
            zzer zzerVar2 = this.f23852a;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        int iH3 = -2147483647;
                        if (i11 != 3) {
                            if (i11 == i10) {
                                i4 = i10;
                                if (a(zzerVar, zzerVar2.f30144a, 6)) {
                                    zzeq zzeqVarD = zzaen.d(zzerVar2.f30144a);
                                    zzeqVarD.f(32);
                                    int iC = zzaen.c(zzeqVarD, zzaen.f22897i) + 1;
                                    this.p = iC;
                                    int i12 = this.f23860i;
                                    if (i12 > iC) {
                                        int i13 = i12 - iC;
                                        this.f23860i = i12 - i13;
                                        zzerVar.E(zzerVar.f30145b - i13);
                                    }
                                    this.f23859h = 5;
                                }
                            } else if (i11 != 5) {
                                int iMin = Math.min(zzerVar.B(), this.f23864m - this.f23860i);
                                this.f23858g.b(iMin, zzerVar);
                                int i14 = this.f23860i + iMin;
                                this.f23860i = i14;
                                if (i14 == this.f23864m) {
                                    zzgqa.f(this.q != -9223372036854775807L);
                                    this.f23858g.e(this.q, this.n == i10 ? 0 : 1, this.f23864m, 0, null);
                                    this.q += this.f23862k;
                                    this.f23859h = 0;
                                }
                            } else if (a(zzerVar, zzerVar2.f30144a, this.p)) {
                                AtomicInteger atomicInteger = this.f23853b;
                                byte[] bArr = zzerVar2.f30144a;
                                i4 = i10;
                                zzeq zzeqVarD2 = zzaen.d(bArr);
                                int iH4 = zzeqVarD2.h(32);
                                int iC2 = zzaen.c(zzeqVarD2, zzaen.f22893e);
                                int i15 = iC2 + 1;
                                char c2 = iH4 == 1078008818 ? (char) 1 : (char) 0;
                                if (c2 == 0) {
                                    jU = -9223372036854775807L;
                                } else {
                                    if (!zzeqVarD2.g()) {
                                        throw zzat.b("Only supports full channel mask-based audio presentation");
                                    }
                                    int i16 = iC2 - 1;
                                    int i17 = bArr[i16] << 8;
                                    int i18 = bArr[iC2] & 255;
                                    String str = zzfj.f31254a;
                                    char c3 = 65535;
                                    for (int i19 = 0; i19 < i16; i19++) {
                                        byte b4 = bArr[i19];
                                        int[] iArr = zzfj.f31261h;
                                        char c4 = (char) (((char) (c3 << 4)) ^ iArr[((c3 >> '\f') ^ ((b4 & 255) >> 4)) & 255]);
                                        c3 = (char) (iArr[((b4 & 15) ^ (c4 >> '\f')) & 255] ^ ((char) (c4 << 4)));
                                    }
                                    if ((((char) i17) | i18) != c3) {
                                        throw zzat.a(null, "CRC check failed");
                                    }
                                    int iH5 = zzeqVarD2.h(2);
                                    if (iH5 != 0) {
                                        if (iH5 == 1) {
                                            i6 = 480;
                                        } else {
                                            if (iH5 != 2) {
                                                StringBuilder sb = new StringBuilder(String.valueOf(iH5).length() + 51);
                                                sb.append("Unsupported base duration index in DTS UHD header: ");
                                                sb.append(iH5);
                                                throw zzat.a(null, sb.toString());
                                            }
                                            i6 = 384;
                                        }
                                        i5 = 3;
                                    } else {
                                        i5 = 3;
                                        i6 = 512;
                                    }
                                    int iH6 = zzeqVarD2.h(i5) + 1;
                                    int iH7 = zzeqVarD2.h(2);
                                    if (iH7 == 0) {
                                        i7 = 32000;
                                    } else if (iH7 == 1) {
                                        i7 = 44100;
                                    } else {
                                        if (iH7 != 2) {
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(iH7).length() + 48);
                                            sb2.append("Unsupported clock rate index in DTS UHD header: ");
                                            sb2.append(iH7);
                                            throw zzat.a(null, sb2.toString());
                                        }
                                        i7 = 48000;
                                    }
                                    if (zzeqVarD2.g()) {
                                        zzeqVarD2.f(36);
                                    }
                                    iH3 = i7 * (1 << zzeqVarD2.h(2));
                                    jU = zzfj.u(i6 * iH6, 1000000L, i7, RoundingMode.DOWN);
                                }
                                int i20 = iH3;
                                int iC3 = 0;
                                for (char c5 = 0; c5 < c2; c5 = 1) {
                                    iC3 += zzaen.c(zzeqVarD2, zzaen.f22894f);
                                }
                                for (int i21 = 0; i21 <= 0; i21++) {
                                    if (c2 != 0) {
                                        atomicInteger.set(zzaen.c(zzeqVarD2, zzaen.f22895g));
                                    }
                                    iC3 += atomicInteger.get() != 0 ? zzaen.c(zzeqVarD2, zzaen.f22896h) : 0;
                                }
                                int i22 = i15 + iC3;
                                zzaem zzaemVar = new zzaem(jU, 2, "audio/vnd.dts.uhd;profile=p2", i20, i22);
                                if (this.n == 3) {
                                    f(zzaemVar);
                                }
                                this.f23864m = i22;
                                this.f23862k = jU == -9223372036854775807L ? 0L : jU;
                                zzerVar2.E(0);
                                this.f23858g.b(this.p, zzerVar2);
                                this.f23859h = 6;
                            } else {
                                continue;
                            }
                            i10 = i4;
                        } else {
                            int i23 = i10;
                            int i24 = 8;
                            if (a(zzerVar, zzerVar2.f30144a, this.o)) {
                                zzeq zzeqVarD3 = zzaen.d(zzerVar2.f30144a);
                                zzeqVarD3.f(40);
                                int iH8 = zzeqVarD3.h(2);
                                boolean zG = zzeqVarD3.g();
                                int i25 = true != zG ? 16 : 20;
                                zzeqVarD3.f(true != zG ? 8 : 12);
                                int iH9 = zzeqVarD3.h(i25) + 1;
                                boolean zG2 = zzeqVarD3.g();
                                if (zG2) {
                                    iH = zzeqVarD3.h(2);
                                    int iH10 = zzeqVarD3.h(3) + 1;
                                    if (zzeqVarD3.g()) {
                                        zzeqVarD3.f(36);
                                    }
                                    int iH11 = zzeqVarD3.h(3) + 1;
                                    int iH12 = zzeqVarD3.h(3) + 1;
                                    if (iH11 != 1 || iH12 != 1) {
                                        throw zzat.b("Multiple audio presentations or assets not supported");
                                    }
                                    int i26 = iH8 + 1;
                                    int iH13 = zzeqVarD3.h(i26);
                                    int i27 = 0;
                                    while (i27 < i26) {
                                        if (((iH13 >> i27) & 1) == 1) {
                                            zzeqVarD3.f(i24);
                                        }
                                        i27++;
                                        i24 = 8;
                                    }
                                    i8 = iH10 * 512;
                                    if (zzeqVarD3.g()) {
                                        zzeqVarD3.f(2);
                                        int iH14 = (zzeqVarD3.h(2) + 1) << 2;
                                        int iH15 = zzeqVarD3.h(2) + 1;
                                        for (int i28 = 0; i28 < iH15; i28++) {
                                            zzeqVarD3.f(iH14);
                                        }
                                    }
                                } else {
                                    iH = -1;
                                    i8 = 0;
                                }
                                zzeqVarD3.f(i25);
                                zzeqVarD3.f(12);
                                if (zG2) {
                                    if (zzeqVarD3.g()) {
                                        zzeqVarD3.f(i23);
                                    }
                                    if (zzeqVarD3.g()) {
                                        zzeqVarD3.f(24);
                                    }
                                    if (zzeqVarD3.g()) {
                                        zzeqVarD3.l(zzeqVarD3.h(10) + 1);
                                    }
                                    zzeqVarD3.f(5);
                                    iH3 = zzaen.f22892d[zzeqVarD3.h(4)];
                                    iH2 = zzeqVarD3.h(8) + 1;
                                } else {
                                    iH2 = -1;
                                }
                                int i29 = iH3;
                                if (zG2) {
                                    if (iH == 0) {
                                        i9 = 32000;
                                    } else if (iH == 1) {
                                        i9 = 44100;
                                    } else {
                                        if (iH != 2) {
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(iH).length() + 51);
                                            sb3.append("Unsupported reference clock code in DTS HD header: ");
                                            sb3.append(iH);
                                            throw zzat.a(null, sb3.toString());
                                        }
                                        i9 = 48000;
                                    }
                                    jU2 = zzfj.u(i8, 1000000L, i9, RoundingMode.DOWN);
                                } else {
                                    jU2 = -9223372036854775807L;
                                }
                                f(new zzaem(jU2, iH2, "audio/vnd.dts.hd;profile=lbr", i29, iH9));
                                this.f23864m = iH9;
                                this.f23862k = jU2 == -9223372036854775807L ? 0L : jU2;
                                zzerVar2.E(0);
                                this.f23858g.b(this.o, zzerVar2);
                                this.f23859h = 6;
                            }
                        }
                    } else if (a(zzerVar, zzerVar2.f30144a, 7)) {
                        zzeq zzeqVarD4 = zzaen.d(zzerVar2.f30144a);
                        zzeqVarD4.f(42);
                        this.o = zzeqVarD4.h(true != zzeqVarD4.g() ? 8 : 12) + 1;
                        this.f23859h = 3;
                    }
                } else if (a(zzerVar, zzerVar2.f30144a, 18)) {
                    byte[] bArr2 = zzerVar2.f30144a;
                    if (this.f23863l == null) {
                        String str2 = this.f23857f;
                        zzeq zzeqVarD5 = zzaen.d(bArr2);
                        zzeqVarD5.f(60);
                        int i30 = zzaen.f22889a[zzeqVarD5.h(6)];
                        int i31 = zzaen.f22890b[zzeqVarD5.h(4)];
                        int iH16 = zzeqVarD5.h(5);
                        int i32 = iH16 >= 29 ? -1 : (zzaen.f22891c[iH16] * 1000) / 2;
                        zzeqVarD5.f(10);
                        int i33 = i30 + (zzeqVarD5.h(2) > 0 ? 1 : 0);
                        zzt zztVar = new zzt();
                        zztVar.f35564a = str2;
                        zztVar.d("video/mp2t");
                        zztVar.e("audio/vnd.dts");
                        zztVar.f35570g = i32;
                        zztVar.D = i33;
                        zztVar.E = i31;
                        zztVar.p = null;
                        zztVar.f35567d = this.f23854c;
                        zztVar.f35569f = this.f23855d;
                        zzv zzvVar = new zzv(zztVar);
                        this.f23863l = zzvVar;
                        this.f23858g.c(zzvVar);
                    }
                    this.f23864m = zzaen.b(bArr2);
                    byte b5 = bArr2[0];
                    if (b5 != -2) {
                        if (b5 == -1) {
                            i2 = (bArr2[4] & 7) << 4;
                            b3 = bArr2[7];
                        } else if (b5 != 31) {
                            i2 = (bArr2[4] & 1) << 6;
                            b2 = bArr2[5];
                        } else {
                            i2 = (bArr2[5] & 7) << 4;
                            b3 = bArr2[6];
                        }
                        i3 = b3 & 60;
                        this.f23862k = zzgwx.a(zzfj.t(this.f23863l.F, (((i3 >> 2) | i2) + 1) * 32));
                        zzerVar2.E(0);
                        this.f23858g.b(18, zzerVar2);
                        this.f23859h = 6;
                    } else {
                        i2 = (bArr2[5] & 1) << 6;
                        b2 = bArr2[4];
                    }
                    i3 = b2 & 252;
                    this.f23862k = zzgwx.a(zzfj.t(this.f23863l.F, (((i3 >> 2) | i2) + 1) * 32));
                    zzerVar2.E(0);
                    this.f23858g.b(18, zzerVar2);
                    this.f23859h = 6;
                }
                i10 = 4;
            } else {
                while (zzerVar.B() > 0) {
                    int i34 = this.f23861j << 8;
                    this.f23861j = i34;
                    int iK = i34 | zzerVar.K();
                    this.f23861j = iK;
                    int iA = zzaen.a(iK);
                    this.n = iA;
                    if (iA != 0) {
                        byte[] bArr3 = zzerVar2.f30144a;
                        int i35 = this.f23861j;
                        bArr3[0] = (byte) ((i35 >> 24) & 255);
                        bArr3[1] = (byte) ((i35 >> 16) & 255);
                        bArr3[2] = (byte) ((i35 >> 8) & 255);
                        bArr3[3] = (byte) (i35 & 255);
                        this.f23860i = 4;
                        this.f23861j = 0;
                        if (iA == 3 || iA == 4) {
                            this.f23859h = 4;
                        } else if (iA == 1) {
                            this.f23859h = 1;
                        } else {
                            this.f23859h = 2;
                        }
                        i10 = 4;
                    }
                }
                i10 = 4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23857f = zzapuVar.f24112e;
        zzapuVar.b();
        this.f23858g = zzaerVar.e(zzapuVar.f24111d, 1);
    }

    public final void f(zzaem zzaemVar) {
        int i2;
        int i3 = zzaemVar.f22887b;
        if (i3 == -2147483647 || (i2 = zzaemVar.f22888c) == -1) {
            return;
        }
        zzv zzvVar = this.f23863l;
        String str = zzaemVar.f22886a;
        if (zzvVar != null && i2 == zzvVar.E && i3 == zzvVar.F && str.equals(zzvVar.f35691m)) {
            return;
        }
        zzv zzvVar2 = this.f23863l;
        zzt zztVar = zzvVar2 == null ? new zzt() : new zzt(zzvVar2);
        zztVar.f35564a = this.f23857f;
        zztVar.d(this.f23856e);
        zztVar.e(str);
        zztVar.D = i2;
        zztVar.E = i3;
        zztVar.f35567d = this.f23854c;
        zztVar.f35569f = this.f23855d;
        zzv zzvVar3 = new zzv(zztVar);
        this.f23863l = zzvVar3;
        this.f23858g.c(zzvVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23859h = 0;
        this.f23860i = 0;
        this.f23861j = 0;
        this.q = -9223372036854775807L;
        this.f23853b.set(0);
    }
}
