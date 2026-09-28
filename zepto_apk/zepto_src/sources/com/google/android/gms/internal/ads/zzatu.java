package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class zzatu {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f24364a;

    static {
        int i2 = (((((~349517445) & 1770783991) | 1585637523) + ((349517445 & 828130404) | 441534467)) - 1774508070) ^ (1876855542 % 1069755936);
        int i3 = (((((~396473730) & 280003019) | 1560841089) + ((396473730 & 581959754) | 705178672)) - (-2122415827)) ^ (1447267605 % 1369321801);
        int i4 = (((((~990892921) & 1764437056) | 26530608) + ((990892921 & 2050981056) | 378852004)) - 524777631) ^ (168002245 % 150122846);
        int i5 = (((((~783368690) & 1480833986) | 1027924228) + ((783368690 & 1108040386) | 324812860)) - (-2032723989)) ^ (1189641421 % 1025202362);
        int i6 = (((((~1662981776) & 570576705) | 1321849157) + ((1662981776 & (-264073600)) | (-599138066))) - 1910740440) ^ (882160379 % 11614769);
        int[] iArr = new int[i5];
        iArr[0] = i4;
        iArr[1] = i3;
        iArr[i2] = i6;
        iArr[(((((~12260289) & 18423941) | 1391147552) + ((12260289 & 286296197) | 2093276674)) - (-1077194409)) ^ (1503885238 % 1219407971)] = (((((~1204275569) & 228665354) | 424906800) + ((1204275569 & (-1801127910)) | (-1190276491))) - 1826404452) ^ (2069110699 % 712633417);
        f24364a = iArr;
    }

    public static String a(String str) {
        int i2;
        int i3 = 0;
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[8];
        int i4 = 0;
        while (i4 < bArrDecode.length) {
            int i5 = i4 % 8;
            if (i5 == 0) {
                int i6 = i4 >>> 3;
                int i7 = i3;
                int i8 = i7;
                int i9 = i8;
                int i10 = i9;
                int i11 = i10;
                int i12 = i11;
                int i13 = i12;
                int i14 = i13;
                int i15 = i14;
                int i16 = i15;
                int i17 = i16;
                int i18 = i17;
                int i19 = i18;
                int i20 = i19;
                int i21 = i20;
                int i22 = i21;
                int i23 = i22;
                i2 = i23;
                int i24 = 1821351989;
                while (true) {
                    if (i24 == 91464932) {
                        int i25 = 751433995 + i24;
                        i24 += 1234789214;
                        if (i7 >= i8) {
                            i24 = i25;
                        }
                    } else if (i24 == 1326254146) {
                        int i26 = i10 >>> i12;
                        int[] iArr = f24364a;
                        i9 += ((i10 << i11) ^ (i26 + i10)) ^ (i13 + iArr[i13 & i14]);
                        i13 += i15;
                        i10 += ((i9 << i11) ^ (i26 + i9)) ^ (i13 + iArr[(i13 >> i16) & i14]);
                        i7++;
                        i24 -= 1234789214;
                    } else {
                        if (i24 != 1821351989) {
                            break;
                        }
                        i24 -= 1729887057;
                        i14 = 3;
                        i12 = 5;
                        i17 = 255;
                        i20 = 2;
                        i16 = 11;
                        i15 = 1340169305;
                        i11 = 4;
                        i8 = 64;
                        i9 = -236335227;
                        i21 = 16;
                        i22 = 6;
                        i23 = 7;
                        i19 = 8;
                        i18 = 24;
                        i10 = i6;
                        i7 = i2;
                        i13 = i7;
                    }
                }
                bArr[i2] = (byte) (((i9 & i17) << i18) >> i18);
                bArr[1] = (byte) ((((i9 >> i19) & i17) << i18) >> i18);
                bArr[i20] = (byte) ((((i9 >> i21) & i17) << i18) >> i18);
                bArr[i14] = (byte) (i9 >> i18);
                bArr[i11] = (byte) (((i10 & i17) << i18) >> i18);
                bArr[i12] = (byte) ((((i10 >> i19) & i17) << i18) >> i18);
                bArr[i22] = (byte) ((((i10 >> i21) & i17) << i18) >> i18);
                bArr[i23] = (byte) (i10 >> i18);
                i5 = i2;
            } else {
                i2 = i3;
            }
            bArrDecode[i4] = (byte) (((bArrDecode[i4] ^ bArr[i5]) << 24) >> 24);
            i4++;
            i3 = i2;
        }
        return new String(bArrDecode, Charset.defaultCharset());
    }
}
