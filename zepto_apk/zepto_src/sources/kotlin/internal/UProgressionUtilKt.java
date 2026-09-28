package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

@Metadata
/* loaded from: classes3.dex */
public final class UProgressionUtilKt {
    public static final int a(int i2, int i3, int i4) {
        long j2 = i4 & 4294967295L;
        int i5 = (int) ((i2 & 4294967295L) % j2);
        int i6 = (int) ((i3 & 4294967295L) % j2);
        int iCompare = Integer.compare(i5 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i6);
        int i7 = i5 - i6;
        UInt.Companion companion = UInt.f53556b;
        return iCompare >= 0 ? i7 : i7 + i4;
    }

    public static final long b(long j2, long j3, long j4) {
        if (j4 < 0) {
            if ((j2 ^ Long.MIN_VALUE) >= (j4 ^ Long.MIN_VALUE)) {
                j2 -= j4;
            }
        } else if (j2 >= 0) {
            j2 %= j4;
        } else {
            long j5 = j2 - ((((j2 >>> 1) / j4) << 1) * j4);
            j2 = j5 - ((j5 ^ Long.MIN_VALUE) >= (j4 ^ Long.MIN_VALUE) ? j4 : 0L);
        }
        if (j4 < 0) {
            if ((j3 ^ Long.MIN_VALUE) >= (j4 ^ Long.MIN_VALUE)) {
                j3 -= j4;
            }
        } else if (j3 >= 0) {
            j3 %= j4;
        } else {
            long j6 = j3 - ((((j3 >>> 1) / j4) << 1) * j4);
            j3 = j6 - ((j6 ^ Long.MIN_VALUE) >= (j4 ^ Long.MIN_VALUE) ? j4 : 0L);
        }
        int iCompare = Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        long j7 = j2 - j3;
        ULong.Companion companion = ULong.f53561b;
        return iCompare >= 0 ? j7 : j7 + j4;
    }
}
