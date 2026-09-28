package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayDeque;

@UnstableApi
/* loaded from: classes3.dex */
public class SlidingWeightedAverageBandwidthStatistic implements BandwidthStatistic {

    public static class Sample {
    }

    public interface SampleEvictionFunction {
    }

    public SlidingWeightedAverageBandwidthStatistic() {
        new ArrayDeque();
    }
}
