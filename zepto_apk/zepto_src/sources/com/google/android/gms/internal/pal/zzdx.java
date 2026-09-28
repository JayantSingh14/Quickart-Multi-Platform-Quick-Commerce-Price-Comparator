package com.google.android.gms.internal.pal;

import android.util.Base64;
import android.util.DisplayMetrics;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class zzdx {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f37659a = "0123456789abcdef".toCharArray();

    public static long a(double d2, DisplayMetrics displayMetrics) {
        return Math.round(d2 / displayMetrics.density);
    }

    public static String b(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID uuidFromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
        byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }

    public static byte[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("String must be of even-length");
        }
        byte[] bArr = new byte[length / 2];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        return bArr;
    }
}
