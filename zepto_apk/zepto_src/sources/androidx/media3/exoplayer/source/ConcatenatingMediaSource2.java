package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

@UnstableApi
/* loaded from: classes3.dex */
public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {

    /* renamed from: k, reason: collision with root package name */
    public Handler f7538k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7539l;

    /* renamed from: m, reason: collision with root package name */
    public MediaItem f7540m;

    public static final class Builder {
        public Builder() {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            new ImmutableList.Builder();
        }
    }

    public static final class ConcatenatedTimeline extends Timeline {
        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            if (!(obj instanceof Pair)) {
                return -1;
            }
            Object obj2 = ((Pair) obj).first;
            if (!(obj2 instanceof Integer)) {
                return -1;
            }
            ((Integer) obj2).intValue();
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period g(Object obj, Timeline.Period period) {
            Pair pair = (Pair) obj;
            ((Integer) pair.first).intValue();
            Object obj2 = pair.second;
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            Object obj = Timeline.Window.q;
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 1;
        }
    }

    public static final class MediaSourceHolder {
    }

    public static void s0() {
        new Timeline.Window();
        new Timeline.Period();
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        new ImmutableList.Builder();
        new ImmutableList.Builder();
        new ImmutableList.Builder();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ((Integer) ((Pair) mediaPeriodId.f7609a).first).intValue();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.f7540m;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.f7540m = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final Timeline X() {
        s0();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void h0() {
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        super.j0(transferListener);
        this.f7538k = new Handler(new b(this, 1));
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        super.l0();
        Handler handler = this.f7538k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f7538k = null;
        }
        this.f7539l = false;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        long j2 = mediaPeriodId.f7612d;
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final long n0(Object obj, long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        Integer num = (Integer) obj;
        if (j2 == -9223372036854775807L || mediaPeriodId == null || mediaPeriodId.b()) {
            return j2;
        }
        num.intValue();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final /* bridge */ /* synthetic */ int o0(int i2, Object obj) {
        return 0;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        if (this.f7539l) {
            return;
        }
        Handler handler = this.f7538k;
        handler.getClass();
        handler.obtainMessage(1).sendToTarget();
        this.f7539l = true;
    }
}
