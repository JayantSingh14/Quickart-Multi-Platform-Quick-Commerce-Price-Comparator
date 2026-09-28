package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public class CombinedParallelSampleBandwidthEstimator implements BandwidthEstimator {

    public static class Builder {
        public Builder() {
            new SlidingWeightedAverageBandwidthStatistic();
        }
    }
}
