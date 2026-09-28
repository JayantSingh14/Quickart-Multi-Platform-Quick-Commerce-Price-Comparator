package com.google.android.gms.internal.measurement;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
final class zzkw {
    public static int a(byte[] bArr, int i2, zzkv zzkvVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return b(b2, bArr, i3, zzkvVar);
        }
        zzkvVar.f37059a = b2;
        return i3;
    }

    public static int b(int i2, byte[] bArr, int i3, zzkv zzkvVar) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & WKSRecord.Service.LOCUS_CON;
        if (b2 >= 0) {
            zzkvVar.f37059a = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzkvVar.f37059a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzkvVar.f37059a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzkvVar.f37059a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzkvVar.f37059a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int c(byte[] bArr, int i2, zzkv zzkvVar) {
        long j2 = bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            zzkvVar.f37060b = j2;
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
        zzkvVar.f37060b = j3;
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

    public static int f(byte[] bArr, int i2, zzkv zzkvVar) {
        int i3;
        int iA = a(bArr, i2, zzkvVar);
        int i4 = zzkvVar.f37059a;
        if (i4 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            zzkvVar.f37061c = "";
            return iA;
        }
        int i5 = zzor.f37201a;
        int length = bArr.length;
        if ((((length - iA) - i4) | iA | i4) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iA), Integer.valueOf(i4)));
        }
        int i6 = iA + i4;
        char[] cArr = new char[i4];
        int i7 = 0;
        while (iA < i6) {
            byte b2 = bArr[iA];
            if (!zzop.a(b2)) {
                break;
            }
            iA++;
            cArr[i7] = (char) b2;
            i7++;
        }
        int i8 = i7;
        while (iA < i6) {
            int i9 = iA + 1;
            byte b3 = bArr[iA];
            if (zzop.a(b3)) {
                cArr[i8] = (char) b3;
                i8++;
                iA = i9;
                while (iA < i6) {
                    byte b4 = bArr[iA];
                    if (zzop.a(b4)) {
                        iA++;
                        cArr[i8] = (char) b4;
                        i8++;
                    }
                }
            } else {
                if (b3 < -32) {
                    if (i9 >= i6) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    i3 = i8 + 1;
                    iA += 2;
                    zzop.b(b3, bArr[i9], cArr, i8);
                } else if (b3 < -16) {
                    if (i9 >= i6 - 1) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    i3 = i8 + 1;
                    int i10 = iA + 2;
                    iA += 3;
                    zzop.c(b3, bArr[i9], bArr[i10], cArr, i8);
                } else {
                    if (i9 >= i6 - 2) {
                        throw new zzmq("Protocol message had invalid UTF-8.");
                    }
                    byte b5 = bArr[i9];
                    int i11 = iA + 3;
                    byte b6 = bArr[iA + 2];
                    iA += 4;
                    zzop.d(b3, b5, b6, bArr[i11], cArr, i8);
                    i8 += 2;
                }
                i8 = i3;
            }
        }
        zzkvVar.f37061c = new String(cArr, 0, i8);
        return i6;
    }

    public static int g(byte[] bArr, int i2, zzkv zzkvVar) {
        int iA = a(bArr, i2, zzkvVar);
        int i3 = zzkvVar.f37059a;
        if (i3 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 > bArr.length - iA) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i3 == 0) {
            zzkvVar.f37061c = zzlg.f37073b;
            return iA;
        }
        zzkvVar.f37061c = zzlg.k(iA, bArr, i3);
        return iA + i3;
    }

    public static int h(Object obj, zznw zznwVar, byte[] bArr, int i2, int i3, zzkv zzkvVar) {
        int iB = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iB = b(i4, bArr, iB, zzkvVar);
            i4 = zzkvVar.f37059a;
        }
        int i5 = iB;
        if (i4 < 0 || i4 > i3 - i5) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzkvVar.f37063e + 1;
        zzkvVar.f37063e = i6;
        if (i6 >= 100) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i7 = i5 + i4;
        zznwVar.g(obj, bArr, i5, i7, zzkvVar);
        zzkvVar.f37063e--;
        zzkvVar.f37061c = obj;
        return i7;
    }

    public static int i(Object obj, zznw zznwVar, byte[] bArr, int i2, int i3, int i4, zzkv zzkvVar) {
        zzno zznoVar = (zzno) zznwVar;
        int i5 = zzkvVar.f37063e + 1;
        zzkvVar.f37063e = i5;
        if (i5 >= 100) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iT = zznoVar.t(obj, bArr, i2, i3, i4, zzkvVar);
        zzkvVar.f37063e--;
        zzkvVar.f37061c = obj;
        return iT;
    }

    public static int j(int i2, byte[] bArr, int i3, int i4, zzmn zzmnVar, zzkv zzkvVar) {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int iA = a(bArr, i3, zzkvVar);
        zzmfVar.zzh(zzkvVar.f37059a);
        while (iA < i4) {
            int iA2 = a(bArr, iA, zzkvVar);
            if (i2 != zzkvVar.f37059a) {
                break;
            }
            iA = a(bArr, iA2, zzkvVar);
            zzmfVar.zzh(zzkvVar.f37059a);
        }
        return iA;
    }

    public static int k(byte[] bArr, int i2, zzmn zzmnVar, zzkv zzkvVar) {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int iA = a(bArr, i2, zzkvVar);
        int i3 = zzkvVar.f37059a + iA;
        while (iA < i3) {
            iA = a(bArr, iA, zzkvVar);
            zzmfVar.zzh(zzkvVar.f37059a);
        }
        if (iA == i3) {
            return iA;
        }
        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int l(zznw zznwVar, int i2, byte[] bArr, int i3, int i4, zzmn zzmnVar, zzkv zzkvVar) {
        Object objZza = zznwVar.zza();
        zznw zznwVar2 = zznwVar;
        byte[] bArr2 = bArr;
        int i5 = i4;
        zzkv zzkvVar2 = zzkvVar;
        int iH = h(objZza, zznwVar2, bArr2, i3, i5, zzkvVar2);
        zznwVar2.d(objZza);
        zzkvVar2.f37061c = objZza;
        zzmnVar.add(objZza);
        while (iH < i5) {
            zzkv zzkvVar3 = zzkvVar2;
            int i6 = i5;
            int iA = a(bArr2, iH, zzkvVar3);
            if (i2 != zzkvVar3.f37059a) {
                break;
            }
            byte[] bArr3 = bArr2;
            zznw zznwVar3 = zznwVar2;
            Object objZza2 = zznwVar3.zza();
            iH = h(objZza2, zznwVar3, bArr3, iA, i6, zzkvVar3);
            zznwVar2 = zznwVar3;
            bArr2 = bArr3;
            i5 = i6;
            zzkvVar2 = zzkvVar3;
            zznwVar2.d(objZza2);
            zzkvVar2.f37061c = objZza2;
            zzmnVar.add(objZza2);
        }
        return iH;
    }

    public static int m(int i2, byte[] bArr, int i3, int i4, zzoi zzoiVar, zzkv zzkvVar) {
        if ((i2 >>> 3) == 0) {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iC = c(bArr, i3, zzkvVar);
            zzoiVar.d(i2, Long.valueOf(zzkvVar.f37060b));
            return iC;
        }
        if (i5 == 1) {
            zzoiVar.d(i2, Long.valueOf(e(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iA = a(bArr, i3, zzkvVar);
            int i6 = zzkvVar.f37059a;
            if (i6 < 0) {
                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 > bArr.length - iA) {
                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i6 == 0) {
                zzoiVar.d(i2, zzlg.f37073b);
            } else {
                zzoiVar.d(i2, zzlg.k(iA, bArr, i6));
            }
            return iA + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new zzmq("Protocol message contained an invalid tag (zero).");
            }
            zzoiVar.d(i2, Integer.valueOf(d(i3, bArr)));
            return i3 + 4;
        }
        int i7 = (i2 & (-8)) | 4;
        zzoi zzoiVarA = zzoi.a();
        int i8 = zzkvVar.f37063e + 1;
        zzkvVar.f37063e = i8;
        if (i8 >= 100) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iA2 = a(bArr, i3, zzkvVar);
            int i10 = zzkvVar.f37059a;
            if (i10 == i7) {
                i9 = i10;
                i3 = iA2;
                break;
            }
            i3 = m(i10, bArr, iA2, i4, zzoiVarA, zzkvVar);
            i9 = i10;
        }
        zzkvVar.f37063e--;
        if (i3 > i4 || i9 != i7) {
            throw new zzmq("Failed to parse the message.");
        }
        zzoiVar.d(i2, zzoiVarA);
        return i3;
    }

    public static int n(int i2, byte[] bArr, int i3, int i4, zzkv zzkvVar) {
        if ((i2 >>> 3) == 0) {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return c(bArr, i3, zzkvVar);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return a(bArr, i3, zzkvVar) + zzkvVar.f37059a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = a(bArr, i3, zzkvVar);
            i7 = zzkvVar.f37059a;
            if (i7 == i6) {
                break;
            }
            i3 = n(i7, bArr, i3, i4, zzkvVar);
        }
        if (i3 > i4 || i7 != i6) {
            throw new zzmq("Failed to parse the message.");
        }
        return i3;
    }
}
