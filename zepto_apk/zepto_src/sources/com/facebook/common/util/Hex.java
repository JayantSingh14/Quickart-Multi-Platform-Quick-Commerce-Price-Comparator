package com.facebook.common.util;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class Hex {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f17139a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f17140b = new char[256];

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f17141c = new char[256];

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f17142d;

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr = f17140b;
            char[] cArr2 = f17139a;
            cArr[i2] = cArr2[(i2 >> 4) & 15];
            f17141c[i2] = cArr2[i2 & 15];
        }
        f17142d = new byte[103];
        for (int i3 = 0; i3 <= 70; i3++) {
            f17142d[i3] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            f17142d[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = f17142d;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }
}
