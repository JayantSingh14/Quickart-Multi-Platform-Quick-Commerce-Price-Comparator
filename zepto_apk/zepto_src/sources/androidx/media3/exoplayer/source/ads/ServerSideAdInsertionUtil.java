package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.MediaSource;

@UnstableApi
/* loaded from: classes3.dex */
public final class ServerSideAdInsertionUtil {
    public static int a(AdPlaybackState adPlaybackState, int i2) {
        int i3 = adPlaybackState.a(i2).f5135b;
        if (i3 == -1) {
            return 0;
        }
        return i3;
    }

    public static long b(long j2, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.b() ? c(j2, mediaPeriodId.f7610b, mediaPeriodId.f7611c, adPlaybackState) : d(j2, mediaPeriodId.f7613e, adPlaybackState);
    }

    public static long c(long j2, int i2, int i3, AdPlaybackState adPlaybackState) {
        int i4;
        AdPlaybackState.AdGroup adGroupA = adPlaybackState.a(i2);
        long j3 = j2 - adGroupA.f5134a;
        int i5 = adPlaybackState.f5128e;
        while (true) {
            i4 = 0;
            if (i5 >= i2) {
                break;
            }
            AdPlaybackState.AdGroup adGroupA2 = adPlaybackState.a(i5);
            while (i4 < a(adPlaybackState, i5)) {
                j3 -= adGroupA2.f5140g[i4];
                i4++;
            }
            j3 += adGroupA2.f5141h;
            i5++;
        }
        if (i3 < a(adPlaybackState, i2)) {
            while (i4 < i3) {
                j3 -= adGroupA.f5140g[i4];
                i4++;
            }
        }
        return j3;
    }

    public static long d(long j2, int i2, AdPlaybackState adPlaybackState) {
        if (i2 == -1) {
            i2 = adPlaybackState.f5125b;
        }
        long j3 = 0;
        for (int i3 = adPlaybackState.f5128e; i3 < i2; i3++) {
            AdPlaybackState.AdGroup adGroupA = adPlaybackState.a(i3);
            long j4 = adGroupA.f5134a;
            if (j4 == Long.MIN_VALUE || j4 > j2 - j3) {
                break;
            }
            for (int i4 = 0; i4 < a(adPlaybackState, i3); i4++) {
                j3 += adGroupA.f5140g[i4];
            }
            long j5 = adGroupA.f5141h;
            j3 -= j5;
            long j6 = adGroupA.f5134a;
            long j7 = j2 - j3;
            if (j5 + j6 > j7) {
                return Math.max(j6, j7);
            }
        }
        return j2 - j3;
    }

    public static long e(long j2, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        if (mediaPeriodId.b()) {
            int i2 = mediaPeriodId.f7610b;
            AdPlaybackState.AdGroup adGroupA = adPlaybackState.a(i2);
            long j3 = j2 + adGroupA.f5134a;
            for (int i3 = adPlaybackState.f5128e; i3 < i2; i3++) {
                AdPlaybackState.AdGroup adGroupA2 = adPlaybackState.a(i3);
                for (int i4 = 0; i4 < a(adPlaybackState, i3); i4++) {
                    j3 += adGroupA2.f5140g[i4];
                }
                j3 -= adGroupA2.f5141h;
            }
            int iA = a(adPlaybackState, i2);
            int i5 = mediaPeriodId.f7611c;
            if (i5 < iA) {
                for (int i6 = 0; i6 < i5; i6++) {
                    j3 += adGroupA.f5140g[i6];
                }
            }
            return j3;
        }
        int i7 = mediaPeriodId.f7613e;
        if (i7 == -1) {
            i7 = adPlaybackState.f5125b;
        }
        long j4 = 0;
        for (int i8 = adPlaybackState.f5128e; i8 < i7; i8++) {
            AdPlaybackState.AdGroup adGroupA3 = adPlaybackState.a(i8);
            long j5 = adGroupA3.f5134a;
            if (j5 == Long.MIN_VALUE || j5 > j2) {
                break;
            }
            long j6 = j5 + j4;
            for (int i9 = 0; i9 < a(adPlaybackState, i8); i9++) {
                j4 += adGroupA3.f5140g[i9];
            }
            long j7 = adGroupA3.f5141h;
            j4 -= j7;
            if (adGroupA3.f5134a + j7 > j2) {
                return Math.max(j6, j2 + j4);
            }
        }
        return j2 + j4;
    }
}
