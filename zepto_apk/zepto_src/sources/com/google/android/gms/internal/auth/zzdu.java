package com.google.android.gms.internal.auth;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzdu {
    public static int a(byte[] bArr, int i2, zzdt zzdtVar) throws zzfb {
        int iF = f(bArr, i2, zzdtVar);
        int i3 = zzdtVar.f36326a;
        if (i3 < 0) {
            throw zzfb.b();
        }
        if (i3 > bArr.length - iF) {
            throw zzfb.c();
        }
        if (i3 == 0) {
            zzdtVar.f36328c = zzef.f36336b;
            return iF;
        }
        zzdtVar.f36328c = zzef.n(iF, bArr, i3);
        return iF + i3;
    }

    public static int b(byte[] bArr, int i2) {
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public static int c(zzgi zzgiVar, byte[] bArr, int i2, int i3, int i4, zzdt zzdtVar) {
        zzev zzevVarZzd = zzgiVar.zzd();
        int iJ = j(zzevVarZzd, zzgiVar, bArr, i2, i3, i4, zzdtVar);
        zzgiVar.a(zzevVarZzd);
        zzdtVar.f36328c = zzevVarZzd;
        return iJ;
    }

    public static int d(zzgi zzgiVar, int i2, byte[] bArr, int i3, int i4, zzez zzezVar, zzdt zzdtVar) throws zzfb {
        zzev zzevVarZzd = zzgiVar.zzd();
        zzgi zzgiVar2 = zzgiVar;
        byte[] bArr2 = bArr;
        int i5 = i4;
        zzdt zzdtVar2 = zzdtVar;
        int iK = k(zzevVarZzd, zzgiVar2, bArr2, i3, i5, zzdtVar2);
        zzgiVar2.a(zzevVarZzd);
        zzdtVar2.f36328c = zzevVarZzd;
        zzezVar.add(zzevVarZzd);
        while (iK < i5) {
            zzdt zzdtVar3 = zzdtVar2;
            int i6 = i5;
            int iF = f(bArr2, iK, zzdtVar3);
            if (i2 != zzdtVar3.f36326a) {
                break;
            }
            byte[] bArr3 = bArr2;
            zzgi zzgiVar3 = zzgiVar2;
            zzev zzevVarZzd2 = zzgiVar3.zzd();
            iK = k(zzevVarZzd2, zzgiVar3, bArr3, iF, i6, zzdtVar3);
            zzgiVar2 = zzgiVar3;
            bArr2 = bArr3;
            i5 = i6;
            zzdtVar2 = zzdtVar3;
            zzgiVar2.a(zzevVarZzd2);
            zzdtVar2.f36328c = zzevVarZzd2;
            zzezVar.add(zzevVarZzd2);
        }
        return iK;
    }

    public static int e(int i2, byte[] bArr, int i3, int i4, zzha zzhaVar, zzdt zzdtVar) throws zzfb {
        if ((i2 >>> 3) == 0) {
            throw new zzfb("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int i6 = i(bArr, i3, zzdtVar);
            zzhaVar.b(i2, Long.valueOf(zzdtVar.f36327b));
            return i6;
        }
        if (i5 == 1) {
            zzhaVar.b(i2, Long.valueOf(l(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iF = f(bArr, i3, zzdtVar);
            int i7 = zzdtVar.f36326a;
            if (i7 < 0) {
                throw zzfb.b();
            }
            if (i7 > bArr.length - iF) {
                throw zzfb.c();
            }
            if (i7 == 0) {
                zzhaVar.b(i2, zzef.f36336b);
            } else {
                zzhaVar.b(i2, zzef.n(iF, bArr, i7));
            }
            return iF + i7;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new zzfb("Protocol message contained an invalid tag (zero).");
            }
            zzhaVar.b(i2, Integer.valueOf(b(bArr, i3)));
            return i3 + 4;
        }
        int i8 = (i2 & (-8)) | 4;
        zzha zzhaVarA = zzha.a();
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iF2 = f(bArr, i3, zzdtVar);
            i9 = zzdtVar.f36326a;
            if (i9 == i8) {
                i3 = iF2;
                break;
            }
            i3 = e(i9, bArr, iF2, i4, zzhaVarA, zzdtVar);
        }
        if (i3 > i4 || i9 != i8) {
            throw new zzfb("Failed to parse the message.");
        }
        zzhaVar.b(i2, zzhaVarA);
        return i3;
    }

    public static int f(byte[] bArr, int i2, zzdt zzdtVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return g(b2, bArr, i3, zzdtVar);
        }
        zzdtVar.f36326a = b2;
        return i3;
    }

    public static int g(int i2, byte[] bArr, int i3, zzdt zzdtVar) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & WKSRecord.Service.LOCUS_CON;
        if (b2 >= 0) {
            zzdtVar.f36326a = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzdtVar.f36326a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzdtVar.f36326a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzdtVar.f36326a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzdtVar.f36326a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int h(int i2, byte[] bArr, int i3, int i4, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int iF = f(bArr, i3, zzdtVar);
        zzewVar.d(zzdtVar.f36326a);
        while (iF < i4) {
            int iF2 = f(bArr, iF, zzdtVar);
            if (i2 != zzdtVar.f36326a) {
                break;
            }
            iF = f(bArr, iF2, zzdtVar);
            zzewVar.d(zzdtVar.f36326a);
        }
        return iF;
    }

    public static int i(byte[] bArr, int i2, zzdt zzdtVar) {
        long j2 = bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            zzdtVar.f36327b = j2;
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
        zzdtVar.f36327b = j3;
        return i4;
    }

    public static int j(Object obj, zzgi zzgiVar, byte[] bArr, int i2, int i3, int i4, zzdt zzdtVar) {
        int iM = ((zzga) zzgiVar).m(obj, bArr, i2, i3, i4, zzdtVar);
        zzdtVar.f36328c = obj;
        return iM;
    }

    public static int k(Object obj, zzgi zzgiVar, byte[] bArr, int i2, int i3, zzdt zzdtVar) throws zzfb {
        int iG = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iG = g(i4, bArr, iG, zzdtVar);
            i4 = zzdtVar.f36326a;
        }
        int i5 = iG;
        if (i4 < 0 || i4 > i3 - i5) {
            throw zzfb.c();
        }
        int i6 = i5 + i4;
        zzgiVar.d(obj, bArr, i5, i6, zzdtVar);
        zzdtVar.f36328c = obj;
        return i6;
    }

    public static long l(byte[] bArr, int i2) {
        return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }
}
