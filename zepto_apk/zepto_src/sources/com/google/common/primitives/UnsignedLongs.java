package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.math.BigInteger;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class UnsignedLongs {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LexicographicalComparator implements Comparator<long[]> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f43338a = {new LexicographicalComparator("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LexicographicalComparator EF5;

        public static LexicographicalComparator valueOf(String str) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f43338a.clone();
        }

        @Override // java.util.Comparator
        public final int compare(long[] jArr, long[] jArr2) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            int iMin = Math.min(jArr3.length, jArr4.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                long j2 = jArr3[i2];
                long j3 = jArr4[i2];
                if (j2 != j3) {
                    return UnsignedLongs.a(j2, j3);
                }
            }
            return jArr3.length - jArr4.length;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    public static final class ParseOverflowDetection {

        /* renamed from: a, reason: collision with root package name */
        public static final long[] f43339a = new long[37];

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f43340b = new int[37];

        /* renamed from: c, reason: collision with root package name */
        public static final int[] f43341c = new int[37];

        static {
            long j2;
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i2 = 2; i2 <= 36; i2++) {
                long[] jArr = f43339a;
                long j3 = i2;
                long j4 = -1;
                if (j3 < 0) {
                    j2 = UnsignedLongs.a(-1L, j3) < 0 ? 0L : 1L;
                } else {
                    long j5 = (Long.MAX_VALUE / j3) << 1;
                    j2 = j5 + (UnsignedLongs.a((-1) - (j5 * j3), j3) >= 0 ? 1 : 0);
                }
                jArr[i2] = j2;
                int[] iArr = f43340b;
                if (j3 < 0) {
                    if (UnsignedLongs.a(-1L, j3) < 0) {
                    }
                    iArr[i2] = (int) j4;
                    f43341c[i2] = bigInteger.toString(i2).length() - 1;
                } else {
                    j4 = (-1) - (((Long.MAX_VALUE / j3) << 1) * j3);
                    if (UnsignedLongs.a(j4, j3) < 0) {
                        j3 = 0;
                    }
                }
                j4 -= j3;
                iArr[i2] = (int) j4;
                f43341c[i2] = bigInteger.toString(i2).length() - 1;
            }
        }
    }

    public static int a(long j2, long j3) {
        long j4 = j2 ^ Long.MIN_VALUE;
        long j5 = j3 ^ Long.MIN_VALUE;
        if (j4 < j5) {
            return -1;
        }
        return j4 > j5 ? 1 : 0;
    }
}
