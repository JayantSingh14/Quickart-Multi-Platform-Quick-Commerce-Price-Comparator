package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RandomKt {
    public static final String a(Number from, Number until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(a(0, Integer.valueOf(i2)).toString());
        }
    }

    public static final void c(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException(a(0L, Long.valueOf(j2)).toString());
        }
    }

    public static final int d(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int e(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
