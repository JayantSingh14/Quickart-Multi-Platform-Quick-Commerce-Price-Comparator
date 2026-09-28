package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class PercentileTimeToFirstByteEstimator implements TimeToFirstByteEstimator {

    public static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f8208a = 10;

        @Override // java.util.LinkedHashMap
        public final boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.f8208a;
        }
    }

    public PercentileTimeToFirstByteEstimator() {
        new FixedSizeLinkedHashMap();
        new SlidingPercentile(10);
    }
}
