package com.mixpanel.android.util;

/* loaded from: classes.dex */
public class Base64Coder {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f46093a = new char[64];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f46094b;

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f46093a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f46093a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f46093a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f46093a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        f46094b = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f46094b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f46094b[f46093a[i4]] = (byte) i4;
        }
    }
}
