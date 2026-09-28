package com.google.android.gms.internal.pal;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzabm {
    public static int a(byte[] bArr, int i2, zzabl zzablVar) throws zzadi {
        int iH = h(bArr, i2, zzablVar);
        int i3 = zzablVar.f37352a;
        if (i3 < 0) {
            throw zzadi.c();
        }
        if (i3 > bArr.length - iH) {
            throw zzadi.e();
        }
        if (i3 == 0) {
            zzablVar.f37354c = zzaby.f37363b;
            return iH;
        }
        zzablVar.f37354c = zzaby.q(iH, bArr, i3);
        return iH + i3;
    }

    public static int b(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static int c(zzaer zzaerVar, byte[] bArr, int i2, int i3, int i4, zzabl zzablVar) {
        zzaei zzaeiVar = (zzaei) zzaerVar;
        Object objZze = zzaeiVar.zze();
        int iZ = zzaeiVar.z(objZze, bArr, i2, i3, i4, zzablVar);
        zzaeiVar.zzf(objZze);
        zzablVar.f37354c = objZze;
        return iZ;
    }

    public static int d(zzaer zzaerVar, byte[] bArr, int i2, int i3, zzabl zzablVar) throws zzadi {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = i(i5, bArr, i4, zzablVar);
            i5 = zzablVar.f37352a;
        }
        int i6 = i4;
        if (i5 < 0 || i5 > i3 - i6) {
            throw zzadi.e();
        }
        Object objZze = zzaerVar.zze();
        int i7 = i6 + i5;
        zzaerVar.a(objZze, bArr, i6, i7, zzablVar);
        zzaerVar.zzf(objZze);
        zzablVar.f37354c = objZze;
        return i7;
    }

    public static int e(zzaer zzaerVar, int i2, byte[] bArr, int i3, int i4, zzadf zzadfVar, zzabl zzablVar) throws zzadi {
        int iD = d(zzaerVar, bArr, i3, i4, zzablVar);
        zzadfVar.add(zzablVar.f37354c);
        while (iD < i4) {
            int iH = h(bArr, iD, zzablVar);
            if (i2 != zzablVar.f37352a) {
                break;
            }
            iD = d(zzaerVar, bArr, iH, i4, zzablVar);
            zzadfVar.add(zzablVar.f37354c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i2, zzabl zzablVar) throws zzadi {
        int iH = h(bArr, i2, zzablVar);
        int i3 = zzablVar.f37352a;
        if (i3 < 0) {
            throw zzadi.c();
        }
        if (i3 == 0) {
            zzablVar.f37354c = "";
            return iH;
        }
        zzablVar.f37354c = new String(bArr, iH, i3, zzadg.f37410a);
        return iH + i3;
    }

    public static int g(int i2, byte[] bArr, int i3, int i4, zzafj zzafjVar, zzabl zzablVar) throws zzadi {
        if ((i2 >>> 3) == 0) {
            throw new zzadi("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iK = k(bArr, i3, zzablVar);
            zzafjVar.c(i2, Long.valueOf(zzablVar.f37353b));
            return iK;
        }
        if (i5 == 1) {
            zzafjVar.c(i2, Long.valueOf(l(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iH = h(bArr, i3, zzablVar);
            int i6 = zzablVar.f37352a;
            if (i6 < 0) {
                throw zzadi.c();
            }
            if (i6 > bArr.length - iH) {
                throw zzadi.e();
            }
            if (i6 == 0) {
                zzafjVar.c(i2, zzaby.f37363b);
            } else {
                zzafjVar.c(i2, zzaby.q(iH, bArr, i6));
            }
            return iH + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new zzadi("Protocol message contained an invalid tag (zero).");
            }
            zzafjVar.c(i2, Integer.valueOf(b(bArr, i3)));
            return i3 + 4;
        }
        int i7 = (i2 & (-8)) | 4;
        zzafj zzafjVarB = zzafj.b();
        int i8 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iH2 = h(bArr, i3, zzablVar);
            i8 = zzablVar.f37352a;
            if (i8 == i7) {
                i3 = iH2;
                break;
            }
            i3 = g(i8, bArr, iH2, i4, zzafjVarB, zzablVar);
        }
        if (i3 > i4 || i8 != i7) {
            throw zzadi.d();
        }
        zzafjVar.c(i2, zzafjVarB);
        return i3;
    }

    public static int h(byte[] bArr, int i2, zzabl zzablVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return i(b2, bArr, i3, zzablVar);
        }
        zzablVar.f37352a = b2;
        return i3;
    }

    public static int i(int i2, byte[] bArr, int i3, zzabl zzablVar) {
        int i4 = i2 & WKSRecord.Service.LOCUS_CON;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzablVar.f37352a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            zzablVar.f37352a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzablVar.f37352a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzablVar.f37352a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzablVar.f37352a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int j(int i2, byte[] bArr, int i3, int i4, zzadf zzadfVar, zzabl zzablVar) {
        zzada zzadaVar = (zzada) zzadfVar;
        int iH = h(bArr, i3, zzablVar);
        zzadaVar.d(zzablVar.f37352a);
        while (iH < i4) {
            int iH2 = h(bArr, iH, zzablVar);
            if (i2 != zzablVar.f37352a) {
                break;
            }
            iH = h(bArr, iH2, zzablVar);
            zzadaVar.d(zzablVar.f37352a);
        }
        return iH;
    }

    public static int k(byte[] bArr, int i2, zzabl zzablVar) {
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            zzablVar.f37353b = j2;
            return i3;
        }
        int i4 = i2 + 2;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | ((b2 & 127) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & 127) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        zzablVar.f37353b = j3;
        return i4;
    }

    public static long l(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }
}
