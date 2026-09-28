package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgwt {
    public static void a(long j2, String str) {
        if (j2 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 17);
        sb.append(str);
        sb.append(" (");
        sb.append(j2);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
