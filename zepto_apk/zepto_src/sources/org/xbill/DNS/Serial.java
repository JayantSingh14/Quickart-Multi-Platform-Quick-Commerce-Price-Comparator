package org.xbill.DNS;

/* loaded from: classes5.dex */
public final class Serial {
    private static final String ERROR_MESSAGE_SUFFIX = " out of range";
    private static final long MAX32 = 4294967295L;

    private Serial() {
    }

    public static int compare(long j2, long j3) {
        if (j2 < 0 || j2 > MAX32) {
            throw new IllegalArgumentException(j2 + ERROR_MESSAGE_SUFFIX);
        }
        if (j3 < 0 || j3 > MAX32) {
            throw new IllegalArgumentException(j3 + ERROR_MESSAGE_SUFFIX);
        }
        long j4 = j2 - j3;
        if (j4 >= MAX32) {
            j4 -= 4294967296L;
        }
        return (int) j4;
    }

    public static long increment(long j2) {
        if (j2 >= 0 && j2 <= MAX32) {
            if (j2 == MAX32) {
                return 1L;
            }
            return j2 + 1;
        }
        throw new IllegalArgumentException(j2 + ERROR_MESSAGE_SUFFIX);
    }
}
