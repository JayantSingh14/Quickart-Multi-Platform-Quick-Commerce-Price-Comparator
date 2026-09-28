package com.facebook.common.webp;

import com.facebook.infer.annotation.Nullsafe;
import java.io.UnsupportedEncodingException;

@Nullsafe
/* loaded from: classes3.dex */
public class WebpSupportStatus {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17149a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f17150b = a("RIFF");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f17151c = a("WEBP");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f17152d = a("VP8 ");

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f17153e = a("VP8L");

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f17154f = a("VP8X");

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(int i2, byte[] bArr, int i3) {
        return i3 >= 20 && c(i2, bArr, f17150b) && c(i2 + 8, bArr, f17151c);
    }

    public static boolean c(int i2, byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3 + i2] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
