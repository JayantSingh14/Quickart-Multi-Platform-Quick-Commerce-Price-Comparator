package androidx.media3.exoplayer.source.ads;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ForwardingTimeline;

@VisibleForTesting
@UnstableApi
/* loaded from: classes3.dex */
public final class SinglePeriodAdTimeline extends ForwardingTimeline {

    /* renamed from: f, reason: collision with root package name */
    public final AdPlaybackState f7814f;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        Assertions.g(timeline.h() == 1);
        Assertions.g(timeline.o() == 1);
        this.f7814f = adPlaybackState;
    }

    @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
    public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
        this.f7572e.f(i2, period, z);
        long j2 = period.f5478d;
        if (j2 == -9223372036854775807L) {
            j2 = this.f7814f.f5127d;
        }
        period.g(period.f5475a, period.f5476b, period.f5477c, j2, period.f5479e, this.f7814f, period.f5480f);
        return period;
    }
}
