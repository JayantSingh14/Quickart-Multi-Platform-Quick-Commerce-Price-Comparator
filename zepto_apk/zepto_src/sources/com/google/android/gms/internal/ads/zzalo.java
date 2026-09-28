package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzalo extends zzalm {
    public zzaln n;
    public int o;
    public boolean p;
    public zzagf q;
    public zzagd r;

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final long b(zzer zzerVar) {
        byte b2 = zzerVar.f30144a[0];
        if ((b2 & 1) == 1) {
            return -1L;
        }
        zzaln zzalnVar = this.n;
        zzalnVar.getClass();
        boolean z = zzalnVar.f23504d[(b2 >> 1) & (255 >>> (8 - zzalnVar.f23505e))].f22993a;
        zzagf zzagfVar = zzalnVar.f23501a;
        int i2 = !z ? zzagfVar.f22998e : zzagfVar.f22999f;
        int i3 = this.p ? (this.o + i2) / 4 : 0;
        byte[] bArr = zzerVar.f30144a;
        int length = bArr.length;
        int i4 = zzerVar.f30146c;
        if (length < i4 + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i4 + 4);
            zzerVar.z(bArrCopyOf.length, bArrCopyOf);
        } else {
            zzerVar.C(i4 + 4);
        }
        long j2 = i3;
        byte[] bArr2 = zzerVar.f30144a;
        int i5 = zzerVar.f30146c;
        bArr2[i5 - 4] = (byte) (j2 & 255);
        bArr2[i5 - 3] = (byte) ((j2 >>> 8) & 255);
        bArr2[i5 - 2] = (byte) ((j2 >>> 16) & 255);
        bArr2[i5 - 1] = (byte) ((j2 >>> 24) & 255);
        this.p = true;
        this.o = i2;
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final boolean c(zzer zzerVar, long j2, zzalk zzalkVar) throws zzat {
        zzaln zzalnVar;
        zzagf zzagfVar;
        int i2;
        int i3;
        zzagf zzagfVar2;
        long jFloor;
        if (this.n != null) {
            zzalkVar.f23486a.getClass();
            return false;
        }
        zzagf zzagfVar3 = this.q;
        int i4 = 1;
        int i5 = 4;
        if (zzagfVar3 == null) {
            zzagg.d(1, zzerVar, false);
            zzerVar.i();
            int iK = zzerVar.K();
            int i6 = zzerVar.i();
            int iC = zzerVar.c();
            int i7 = iC <= 0 ? -1 : iC;
            int iC2 = zzerVar.c();
            int i8 = iC2 <= 0 ? -1 : iC2;
            zzerVar.c();
            int iK2 = zzerVar.K();
            int iPow = (int) Math.pow(2.0d, iK2 & 15);
            int iPow2 = (int) Math.pow(2.0d, (iK2 & 240) >> 4);
            zzerVar.K();
            this.q = new zzagf(Arrays.copyOf(zzerVar.f30144a, zzerVar.f30146c), iK, i6, i7, i8, iPow, iPow2);
        } else {
            zzagd zzagdVar = this.r;
            if (zzagdVar == null) {
                this.r = zzagg.b(zzerVar, true, true);
            } else {
                int i9 = zzerVar.f30146c;
                byte[] bArr = new byte[i9];
                System.arraycopy(zzerVar.f30144a, 0, bArr, 0, i9);
                int i10 = 5;
                zzagg.d(5, zzerVar, false);
                int iK3 = zzerVar.K() + 1;
                zzagc zzagcVar = new zzagc(zzerVar.f30144a);
                int i11 = 8;
                zzagcVar.c(zzerVar.f30145b * 8);
                int i12 = 0;
                while (true) {
                    int i13 = 2;
                    int i14 = 16;
                    if (i12 < iK3) {
                        int i15 = i11;
                        if (zzagcVar.b(24) != 5653314) {
                            int i16 = (zzagcVar.f22990c * 8) + zzagcVar.f22991d;
                            StringBuilder sb = new StringBuilder(String.valueOf(i16).length() + 55);
                            sb.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb.append(i16);
                            throw zzat.a(null, sb.toString());
                        }
                        int iB = zzagcVar.b(16);
                        int iB2 = zzagcVar.b(24);
                        if (zzagcVar.a()) {
                            zzagcVar.c(5);
                            for (int iB3 = 0; iB3 < iB2; iB3 += zzagcVar.b(zzagg.a(iB2 - iB3))) {
                            }
                        } else {
                            boolean zA = zzagcVar.a();
                            for (int i17 = 0; i17 < iB2; i17++) {
                                if (!zA) {
                                    zzagcVar.c(5);
                                } else if (zzagcVar.a()) {
                                    zzagcVar.c(5);
                                }
                            }
                        }
                        int iB4 = zzagcVar.b(i5);
                        if (iB4 > 2) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(iB4).length() + 42);
                            sb2.append("lookup type greater than 2 not decodable: ");
                            sb2.append(iB4);
                            throw zzat.a(null, sb2.toString());
                        }
                        if (iB4 != 1) {
                            if (iB4 != 2) {
                                zzagfVar2 = zzagfVar3;
                            }
                            i12++;
                            i11 = i15;
                            zzagfVar3 = zzagfVar2;
                            i5 = 4;
                        } else {
                            i13 = iB4;
                        }
                        zzagcVar.c(32);
                        zzagcVar.c(32);
                        int iB5 = zzagcVar.b(i5) + 1;
                        zzagcVar.c(1);
                        if (i13 != 1) {
                            zzagfVar2 = zzagfVar3;
                            jFloor = iB * iB2;
                        } else if (iB != 0) {
                            zzagfVar2 = zzagfVar3;
                            jFloor = (long) Math.floor(Math.pow(iB2, 1.0d / iB));
                        } else {
                            zzagfVar2 = zzagfVar3;
                            jFloor = 0;
                        }
                        zzagcVar.c((int) (jFloor * iB5));
                        i12++;
                        i11 = i15;
                        zzagfVar3 = zzagfVar2;
                        i5 = 4;
                    } else {
                        zzagf zzagfVar4 = zzagfVar3;
                        int i18 = i11;
                        int i19 = 6;
                        int iB6 = zzagcVar.b(6) + 1;
                        for (int i20 = 0; i20 < iB6; i20++) {
                            if (zzagcVar.b(16) != 0) {
                                throw zzat.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int iB7 = zzagcVar.b(6) + 1;
                        int i21 = 0;
                        while (true) {
                            int i22 = 3;
                            if (i21 < iB7) {
                                int iB8 = zzagcVar.b(i14);
                                if (iB8 == 0) {
                                    int i23 = i18;
                                    i2 = i4;
                                    zzagcVar.c(i23);
                                    zzagcVar.c(16);
                                    zzagcVar.c(16);
                                    zzagcVar.c(6);
                                    zzagcVar.c(i23);
                                    int iB9 = zzagcVar.b(4) + 1;
                                    int i24 = 0;
                                    while (i24 < iB9) {
                                        zzagcVar.c(i23);
                                        i24++;
                                        i23 = 8;
                                    }
                                } else {
                                    if (iB8 != i4) {
                                        StringBuilder sb3 = new StringBuilder(androidx.fragment.app.e.a(iB8, 41));
                                        sb3.append("floor type greater than 1 not decodable: ");
                                        sb3.append(iB8);
                                        throw zzat.a(null, sb3.toString());
                                    }
                                    int iB10 = zzagcVar.b(i10);
                                    int[] iArr = new int[iB10];
                                    i2 = i4;
                                    int i25 = -1;
                                    for (int i26 = 0; i26 < iB10; i26++) {
                                        int iB11 = zzagcVar.b(4);
                                        iArr[i26] = iB11;
                                        if (iB11 > i25) {
                                            i25 = iB11;
                                        }
                                    }
                                    int i27 = i25 + 1;
                                    int[] iArr2 = new int[i27];
                                    int i28 = 0;
                                    while (i28 < i27) {
                                        iArr2[i28] = zzagcVar.b(i22) + 1;
                                        int iB12 = zzagcVar.b(i13);
                                        if (iB12 > 0) {
                                            i3 = i18;
                                            zzagcVar.c(i3);
                                        } else {
                                            i3 = i18;
                                        }
                                        int i29 = 0;
                                        while (i29 < (i2 << iB12)) {
                                            zzagcVar.c(i3);
                                            i29++;
                                            i3 = 8;
                                        }
                                        i28++;
                                        i18 = 8;
                                        i13 = 2;
                                        i22 = 3;
                                    }
                                    zzagcVar.c(i13);
                                    int iB13 = zzagcVar.b(4);
                                    int i30 = 0;
                                    int i31 = 0;
                                    for (int i32 = 0; i32 < iB10; i32++) {
                                        i30 += iArr2[iArr[i32]];
                                        while (i31 < i30) {
                                            zzagcVar.c(iB13);
                                            i31++;
                                        }
                                    }
                                }
                                i21++;
                                i4 = i2;
                                i18 = 8;
                                i19 = 6;
                                i13 = 2;
                                i14 = 16;
                                i10 = 5;
                            } else {
                                int i33 = i4;
                                int iB14 = zzagcVar.b(i19) + 1;
                                int i34 = 0;
                                while (i34 < iB14) {
                                    if (zzagcVar.b(16) > 2) {
                                        throw zzat.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    zzagcVar.c(24);
                                    zzagcVar.c(24);
                                    zzagcVar.c(24);
                                    int iB15 = zzagcVar.b(i19) + 1;
                                    int i35 = 8;
                                    zzagcVar.c(8);
                                    int[] iArr3 = new int[iB15];
                                    for (int i36 = 0; i36 < iB15; i36++) {
                                        iArr3[i36] = ((zzagcVar.a() ? zzagcVar.b(5) : 0) * 8) + zzagcVar.b(3);
                                    }
                                    int i37 = 0;
                                    while (i37 < iB15) {
                                        int i38 = 0;
                                        while (i38 < i35) {
                                            if ((iArr3[i37] & (i33 << i38)) != 0) {
                                                zzagcVar.c(i35);
                                            }
                                            i38++;
                                            i35 = 8;
                                        }
                                        i37++;
                                        i35 = 8;
                                    }
                                    i34++;
                                    i19 = 6;
                                }
                                int iB16 = zzagcVar.b(i19) + 1;
                                int i39 = 0;
                                while (i39 < iB16) {
                                    int iB17 = zzagcVar.b(16);
                                    if (iB17 != 0) {
                                        StringBuilder sb4 = new StringBuilder(androidx.fragment.app.e.a(iB17, 41));
                                        sb4.append("mapping type other than 0 not supported: ");
                                        sb4.append(iB17);
                                        zzee.e("VorbisUtil", sb4.toString());
                                        zzagfVar = zzagfVar4;
                                    } else {
                                        int iB18 = zzagcVar.a() ? zzagcVar.b(4) + 1 : i33;
                                        boolean zA2 = zzagcVar.a();
                                        zzagfVar = zzagfVar4;
                                        int i40 = zzagfVar.f22994a;
                                        if (zA2) {
                                            int iB19 = zzagcVar.b(8) + 1;
                                            for (int i41 = 0; i41 < iB19; i41++) {
                                                int i42 = i40 - 1;
                                                zzagcVar.c(zzagg.a(i42));
                                                zzagcVar.c(zzagg.a(i42));
                                            }
                                        }
                                        if (zzagcVar.b(2) != 0) {
                                            throw zzat.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (iB18 > i33) {
                                            for (int i43 = 0; i43 < i40; i43++) {
                                                zzagcVar.c(4);
                                            }
                                        }
                                        for (int i44 = 0; i44 < iB18; i44++) {
                                            zzagcVar.c(8);
                                            zzagcVar.c(8);
                                            zzagcVar.c(8);
                                        }
                                    }
                                    i39++;
                                    zzagfVar4 = zzagfVar;
                                    i33 = 1;
                                }
                                zzagf zzagfVar5 = zzagfVar4;
                                int iB20 = zzagcVar.b(6);
                                int i45 = iB20 + 1;
                                zzage[] zzageVarArr = new zzage[i45];
                                for (int i46 = 0; i46 < i45; i46++) {
                                    boolean zA3 = zzagcVar.a();
                                    zzagcVar.b(16);
                                    zzagcVar.b(16);
                                    zzagcVar.b(8);
                                    zzageVarArr[i46] = new zzage(zA3);
                                }
                                if (!zzagcVar.a()) {
                                    throw zzat.a(null, "framing bit after modes not set as expected");
                                }
                                zzalnVar = new zzaln(zzagfVar5, zzagdVar, bArr, zzageVarArr, zzagg.a(iB20));
                            }
                        }
                    }
                }
            }
        }
        zzalnVar = null;
        this.n = zzalnVar;
        if (zzalnVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzagf zzagfVar6 = zzalnVar.f23501a;
        arrayList.add(zzagfVar6.f23000g);
        arrayList.add(zzalnVar.f23503c);
        zzap zzapVarC = zzagg.c(zzgtd.s(zzalnVar.f23502b.f22992a));
        zzt zztVar = new zzt();
        zztVar.d("audio/ogg");
        zztVar.e("audio/vorbis");
        zztVar.f35570g = zzagfVar6.f22997d;
        zztVar.f35571h = zzagfVar6.f22996c;
        zztVar.D = zzagfVar6.f22994a;
        zztVar.E = zzagfVar6.f22995b;
        zztVar.o = arrayList;
        zztVar.f35573j = zzapVarC;
        zzalkVar.f23486a = new zzv(zztVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void d(long j2) {
        this.f23494g = j2;
        this.p = j2 != 0;
        zzagf zzagfVar = this.q;
        this.o = zzagfVar != null ? zzagfVar.f22998e : 0;
    }
}
