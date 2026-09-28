package com.google.android.gms.internal.ads;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzhza {
    public static int a(byte[] bArr, int i2, zzhyz zzhyzVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return b(b2, bArr, i3, zzhyzVar);
        }
        zzhyzVar.f34537a = b2;
        return i3;
    }

    public static int b(int i2, byte[] bArr, int i3, zzhyz zzhyzVar) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & WKSRecord.Service.LOCUS_CON;
        if (b2 >= 0) {
            zzhyzVar.f34537a = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzhyzVar.f34537a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzhyzVar.f34537a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzhyzVar.f34537a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzhyzVar.f34537a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int c(byte[] bArr, int i2, zzhyz zzhyzVar) {
        long j2 = bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            zzhyzVar.f34538b = j2;
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
        zzhyzVar.f34538b = j3;
        return i4;
    }

    public static int d(int i2, byte[] bArr) {
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public static long e(int i2, byte[] bArr) {
        return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public static int f(byte[] bArr, int i2, zzhyz zzhyzVar) throws zzibg {
        int iA = a(bArr, i2, zzhyzVar);
        int i3 = zzhyzVar.f34537a;
        if (i3 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 == 0) {
            zzhyzVar.f34539c = "";
            return iA;
        }
        zzhyzVar.f34539c = zzidr.f34775a.b(iA, bArr, i3);
        return iA + i3;
    }

    public static int g(byte[] bArr, int i2, zzhyz zzhyzVar) throws zzibg {
        int iA = a(bArr, i2, zzhyzVar);
        int i3 = zzhyzVar.f34537a;
        if (i3 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 > bArr.length - iA) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i3 == 0) {
            zzhyzVar.f34539c = zzhzl.f34557b;
            return iA;
        }
        zzhyzVar.f34539c = zzhzl.v(iA, bArr, i3);
        return iA + i3;
    }

    public static int h(Object obj, zzicu zzicuVar, byte[] bArr, int i2, int i3, zzhyz zzhyzVar) throws zzibg {
        int iB = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iB = b(i4, bArr, iB, zzhyzVar);
            i4 = zzhyzVar.f34537a;
        }
        int i5 = iB;
        if (i4 < 0 || i4 > i3 - i5) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzhyzVar.f34541e + 1;
        zzhyzVar.f34541e = i6;
        if (i6 >= 100) {
            throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i7 = i5 + i4;
        zzicuVar.c(obj, bArr, i5, i7, zzhyzVar);
        zzhyzVar.f34541e--;
        zzhyzVar.f34539c = obj;
        return i7;
    }

    public static int i(Object obj, zzicu zzicuVar, byte[] bArr, int i2, int i3, int i4, zzhyz zzhyzVar) throws zzibg {
        zzicf zzicfVar = (zzicf) zzicuVar;
        int i5 = zzhyzVar.f34541e + 1;
        zzhyzVar.f34541e = i5;
        if (i5 >= 100) {
            throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iX = zzicfVar.x(obj, bArr, i2, i3, i4, zzhyzVar);
        zzhyzVar.f34541e--;
        zzhyzVar.f34539c = obj;
        return iX;
    }

    public static int j(int i2, byte[] bArr, int i3, int i4, zzibd zzibdVar, zzhyz zzhyzVar) {
        zzias zziasVar = (zzias) zzibdVar;
        int iA = a(bArr, i3, zzhyzVar);
        zziasVar.zzi(zzhyzVar.f34537a);
        while (iA < i4) {
            int iA2 = a(bArr, iA, zzhyzVar);
            if (i2 != zzhyzVar.f34537a) {
                break;
            }
            iA = a(bArr, iA2, zzhyzVar);
            zziasVar.zzi(zzhyzVar.f34537a);
        }
        return iA;
    }

    public static int k(byte[] bArr, int i2, zzibd zzibdVar, zzhyz zzhyzVar) throws zzibg {
        zzias zziasVar = (zzias) zzibdVar;
        int iA = a(bArr, i2, zzhyzVar);
        int i3 = zzhyzVar.f34537a + iA;
        while (iA < i3) {
            iA = a(bArr, iA, zzhyzVar);
            zziasVar.zzi(zzhyzVar.f34537a);
        }
        if (iA == i3) {
            return iA;
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int l(zzicu zzicuVar, int i2, byte[] bArr, int i3, int i4, zzibd zzibdVar, zzhyz zzhyzVar) throws zzibg {
        Object objZza = zzicuVar.zza();
        zzicu zzicuVar2 = zzicuVar;
        byte[] bArr2 = bArr;
        int i5 = i4;
        zzhyz zzhyzVar2 = zzhyzVar;
        int iH = h(objZza, zzicuVar2, bArr2, i3, i5, zzhyzVar2);
        zzicuVar2.b(objZza);
        zzhyzVar2.f34539c = objZza;
        zzibdVar.add(objZza);
        while (iH < i5) {
            zzhyz zzhyzVar3 = zzhyzVar2;
            int i6 = i5;
            int iA = a(bArr2, iH, zzhyzVar3);
            if (i2 != zzhyzVar3.f34537a) {
                break;
            }
            byte[] bArr3 = bArr2;
            zzicu zzicuVar3 = zzicuVar2;
            Object objZza2 = zzicuVar3.zza();
            iH = h(objZza2, zzicuVar3, bArr3, iA, i6, zzhyzVar3);
            zzicuVar2 = zzicuVar3;
            bArr2 = bArr3;
            i5 = i6;
            zzhyzVar2 = zzhyzVar3;
            zzicuVar2.b(objZza2);
            zzhyzVar2.f34539c = objZza2;
            zzibdVar.add(objZza2);
        }
        return iH;
    }

    public static int m(int i2, byte[] bArr, int i3, int i4, zzidg zzidgVar, zzhyz zzhyzVar) throws zzibg {
        if ((i2 >>> 3) == 0) {
            throw new zzibg("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iC = c(bArr, i3, zzhyzVar);
            zzidgVar.d(i2, Long.valueOf(zzhyzVar.f34538b));
            return iC;
        }
        if (i5 == 1) {
            zzidgVar.d(i2, Long.valueOf(e(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iA = a(bArr, i3, zzhyzVar);
            int i6 = zzhyzVar.f34537a;
            if (i6 < 0) {
                throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 > bArr.length - iA) {
                throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i6 == 0) {
                zzidgVar.d(i2, zzhzl.f34557b);
            } else {
                zzidgVar.d(i2, zzhzl.v(iA, bArr, i6));
            }
            return iA + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new zzibg("Protocol message contained an invalid tag (zero).");
            }
            zzidgVar.d(i2, Integer.valueOf(d(i3, bArr)));
            return i3 + 4;
        }
        int i7 = (i2 & (-8)) | 4;
        zzidg zzidgVarA = zzidg.a();
        int i8 = zzhyzVar.f34541e + 1;
        zzhyzVar.f34541e = i8;
        if (i8 >= 100) {
            throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iA2 = a(bArr, i3, zzhyzVar);
            int i10 = zzhyzVar.f34537a;
            if (i10 == i7) {
                i9 = i10;
                i3 = iA2;
                break;
            }
            i3 = m(i10, bArr, iA2, i4, zzidgVarA, zzhyzVar);
            i9 = i10;
        }
        zzhyzVar.f34541e--;
        if (i3 > i4 || i9 != i7) {
            throw new zzibg("Failed to parse the message.");
        }
        zzidgVar.d(i2, zzidgVarA);
        return i3;
    }

    public static int n(int i2, byte[] bArr, int i3, int i4, zzhyz zzhyzVar) throws zzibg {
        if ((i2 >>> 3) == 0) {
            throw new zzibg("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return c(bArr, i3, zzhyzVar);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return a(bArr, i3, zzhyzVar) + zzhyzVar.f34537a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw new zzibg("Protocol message contained an invalid tag (zero).");
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = a(bArr, i3, zzhyzVar);
            i7 = zzhyzVar.f34537a;
            if (i7 == i6) {
                break;
            }
            i3 = n(i7, bArr, i3, i4, zzhyzVar);
        }
        if (i3 > i4 || i7 != i6) {
            throw new zzibg("Failed to parse the message.");
        }
        return i3;
    }
}
