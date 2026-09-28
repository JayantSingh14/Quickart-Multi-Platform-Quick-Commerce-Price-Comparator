package androidx.media3.exoplayer.source;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.android.gms.common.api.Api;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public final class LoopingMediaSource extends WrappingMediaSource {

    public static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final int e(int i2, int i3, boolean z) {
            Timeline timeline = this.f7572e;
            int iE = timeline.e(i2, i3, z);
            return iE == -1 ? timeline.a(z) : iE;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final int k(int i2, int i3, boolean z) {
            Timeline timeline = this.f7572e;
            int iK = timeline.k(i2, i3, z);
            return iK == -1 ? timeline.c(z) : iK;
        }
    }

    public static final class LoopingTimeline extends AbstractConcatenatedTimeline {

        /* renamed from: h, reason: collision with root package name */
        public final Timeline f7582h;

        /* renamed from: i, reason: collision with root package name */
        public final int f7583i;

        /* renamed from: j, reason: collision with root package name */
        public final int f7584j;

        public LoopingTimeline(Timeline timeline) {
            super(new ShuffleOrder.UnshuffledShuffleOrder(0));
            this.f7582h = timeline;
            int iH = timeline.h();
            this.f7583i = iH;
            this.f7584j = timeline.o();
            if (iH > 0) {
                Assertions.f("LoopingMediaSource contains too many periods", Api.BaseClientBuilder.API_PRIORITY_OTHER / iH >= 0);
            }
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 0;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int q(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int r(int i2) {
            return i2 / this.f7583i;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int s(int i2) {
            return i2 / this.f7584j;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final Object t(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int u(int i2) {
            return i2 * this.f7583i;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int v(int i2) {
            return i2 * this.f7584j;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final Timeline x(int i2) {
            return this.f7582h;
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int i2 = AbstractConcatenatedTimeline.f6093g;
        mediaPeriodId.a(((Pair) mediaPeriodId.f7609a).second);
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        this.f7774k.J(mediaPeriod);
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final boolean W() {
        return false;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final Timeline X() {
        return new LoopingTimeline(((MaskingMediaSource) this.f7774k).o);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void i0(Timeline timeline) {
        k0(new LoopingTimeline(timeline));
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final MediaSource.MediaPeriodId s0(MediaSource.MediaPeriodId mediaPeriodId) {
        throw null;
    }
}
