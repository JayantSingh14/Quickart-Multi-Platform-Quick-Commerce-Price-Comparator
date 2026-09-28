package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzagg {
    public static long a(int i2, long j2) {
        long j3 = i2;
        long j4 = j2 * j3;
        if (j4 / j3 == j2) {
            return j4;
        }
        StringBuilder sb = new StringBuilder(67);
        sb.append("Multiplication overflows a long: ");
        sb.append(j2);
        sb.append(" * ");
        sb.append(i2);
        throw new ArithmeticException(sb.toString());
    }
}
