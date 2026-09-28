package com.google.common.math;

import android.support.v4.media.b;
import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
final class MathPreconditions {
    public static void a(int i2, int i3, String str, boolean z) {
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(i2);
        sb.append(", ");
        throw new ArithmeticException(b.o(sb, i3, ")"));
    }

    public static void b(long j2, String str) {
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j2 + ") must be >= 0");
    }
}
