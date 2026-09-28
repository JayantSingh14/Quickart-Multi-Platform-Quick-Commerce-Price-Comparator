package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaku {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f23408a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzafv a(zzaep zzaepVar, boolean z, boolean z2) {
        zzafv zzafvVar;
        long j2;
        zzer zzerVar;
        int i2;
        int i3;
        long j3;
        int i4;
        int i5;
        int[] iArr;
        long jZzo = zzaepVar.zzo();
        long j4 = -1;
        long j5 = 4096;
        if (jZzo != -1 && jZzo <= 4096) {
            j5 = jZzo;
        }
        zzer zzerVar2 = new zzer(64);
        int i6 = (int) j5;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            zzerVar2.y(8);
            if (!zzaepVar.t(zzerVar2.f30144a, i7, 8, true)) {
                break;
            }
            long jP = zzerVar2.P();
            int iB = zzerVar2.b();
            if (jP == 1) {
                j2 = j4;
                zzaepVar.s(8, zzerVar2.f30144a, 8);
                i2 = 16;
                zzerVar2.C(16);
                jP = zzerVar2.d();
                zzerVar = zzerVar2;
            } else {
                j2 = j4;
                if (jP == 0) {
                    long jZzo2 = zzaepVar.zzo();
                    if (jZzo2 != j2) {
                        jP = (jZzo2 - zzaepVar.zzm()) + 8;
                    }
                }
                zzerVar = zzerVar2;
                i2 = 8;
            }
            long j6 = jP;
            zzafvVar = null;
            long j7 = i2;
            if (j6 < j7) {
                i3 = 1;
                if (iB == 1718773093) {
                    if (i2 == 8) {
                        j6 = 8;
                        iB = 1718773093;
                    } else {
                        iB = 1718773093;
                    }
                }
                return new zzajo(iB, i2, j6);
            }
            i3 = 1;
            i8 += i2;
            if (iB == 1836019574) {
                i6 += (int) j6;
                if (jZzo != -1 && i6 > jZzo) {
                    i6 = (int) jZzo;
                }
                zzerVar2 = zzerVar;
                j4 = j2;
                i7 = 0;
            } else {
                if (iB == 1953653099 || iB == 1835297121 || iB == 1835626086) {
                    j3 = jZzo;
                    i4 = 0;
                } else {
                    if (iB == 1836019558 || iB == 1836475768) {
                        i7 = i3;
                        break;
                    }
                    i9 |= (iB == 1835295092 ? 0 : i3) ^ 1;
                    if (iB == 1937007212) {
                        if (j6 > 1000000) {
                            i7 = 0;
                            break;
                        }
                        iB = 1937007212;
                    }
                    j3 = jZzo;
                    if ((i8 + j6) - j7 >= i6) {
                        i7 = 0;
                        break;
                    }
                    int i10 = (int) (j6 - j7);
                    i8 += i10;
                    if (iB != 1718909296) {
                        i4 = 0;
                        if (i10 != 0) {
                            zzaepVar.r(i10);
                        }
                    } else {
                        if (i10 < 8) {
                            return new zzajo(1718909296, 8, i10);
                        }
                        zzerVar.y(i10);
                        i4 = 0;
                        zzaepVar.s(0, zzerVar.f30144a, i10);
                        int iB2 = zzerVar.b();
                        int i11 = (b(iB2, z2) ? 1 : 0) | i9;
                        zzerVar.G(4);
                        int iB3 = zzerVar.B() / 4;
                        if (i11 == 0 && iB3 > 0) {
                            iArr = new int[iB3];
                            int i12 = 0;
                            while (true) {
                                if (i12 >= iB3) {
                                    i5 = i11;
                                    break;
                                }
                                int iB4 = zzerVar.b();
                                iArr[i12] = iB4;
                                if (b(iB4, z2)) {
                                    i5 = i3;
                                    break;
                                }
                                i12++;
                            }
                        } else {
                            i5 = i11;
                            iArr = null;
                        }
                        if (i5 == 0) {
                            return new zzakz(iB2, iArr);
                        }
                        i9 = i5;
                    }
                }
                i7 = i4;
                zzerVar2 = zzerVar;
                jZzo = j3;
                j4 = j2;
            }
        }
        zzafvVar = null;
        return i9 == 0 ? zzakq.f23399a : z != i7 ? i7 != 0 ? zzaki.f23372b : zzaki.f23373c : zzafvVar;
    }

    public static boolean b(int i2, boolean z) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (i2 == 1751476579) {
            if (z) {
                return true;
            }
            i2 = 1751476579;
        }
        int[] iArr = f23408a;
        for (int i3 = 0; i3 < 29; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }
}
