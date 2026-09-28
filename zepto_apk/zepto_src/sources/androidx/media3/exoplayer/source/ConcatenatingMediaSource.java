package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    public static final MediaItem n;

    /* renamed from: k, reason: collision with root package name */
    public Handler f7535k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7536l;

    /* renamed from: m, reason: collision with root package name */
    public ShuffleOrder f7537m;

    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
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
            throw null;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int r(int i2) {
            return Util.e(null, i2 + 1, false, false);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int s(int i2) {
            return Util.e(null, i2 + 1, false, false);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final Object t(int i2) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int u(int i2) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final int v(int i2) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        public final Timeline x(int i2) {
            throw null;
        }
    }

    public static final class FakeMediaSource extends BaseMediaSource {
        @Override // androidx.media3.exoplayer.source.MediaSource
        public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public final MediaItem D() {
            return ConcatenatingMediaSource.n;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public final void J(MediaPeriod mediaPeriod) {
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public final void V() {
        }

        @Override // androidx.media3.exoplayer.source.BaseMediaSource
        public final void j0(TransferListener transferListener) {
        }

        @Override // androidx.media3.exoplayer.source.BaseMediaSource
        public final void l0() {
        }
    }

    public static final class HandlerAndRunnable {
    }

    public static final class MediaSourceHolder {
    }

    public static final class MessageData<T> {
    }

    static {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5267b = Uri.EMPTY;
        n = builder.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int i2 = AbstractConcatenatedTimeline.f6093g;
        Pair pair = (Pair) mediaPeriodId.f7609a;
        Object obj = pair.first;
        mediaPeriodId.a(pair.second);
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        return n;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized Timeline X() {
        this.f7537m.getLength();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void g0() {
        super.g0();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void h0() {
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final synchronized void j0(TransferListener transferListener) {
        super.j0(transferListener);
        this.f7535k = new Handler(new b(this, 0));
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final synchronized void l0() {
        super.l0();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        ((MediaSourceHolder) obj).getClass();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final int o0(int i2, Object obj) {
        ((MediaSourceHolder) obj).getClass();
        return i2;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        ((MediaSourceHolder) obj).getClass();
        throw null;
    }
}
