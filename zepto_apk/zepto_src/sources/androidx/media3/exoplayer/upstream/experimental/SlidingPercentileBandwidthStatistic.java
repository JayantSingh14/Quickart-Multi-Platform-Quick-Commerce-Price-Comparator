package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.TreeSet;

@UnstableApi
/* loaded from: classes3.dex */
public class SlidingPercentileBandwidthStatistic implements BandwidthStatistic {

    public static class Sample implements Comparable<Sample> {
        @Override // java.lang.Comparable
        public final int compareTo(Sample sample) {
            sample.getClass();
            return Util.i(0L, 0L);
        }
    }

    public SlidingPercentileBandwidthStatistic() {
        new ArrayDeque();
        new TreeSet();
    }
}
