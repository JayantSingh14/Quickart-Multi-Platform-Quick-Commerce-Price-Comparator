package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgwo {
    public static long a(double d2) {
        zzgqa.b("not a normal value", b(d2));
        int exponent = Math.getExponent(d2);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean b(double d2) {
        return Math.getExponent(d2) <= 1023;
    }
}
