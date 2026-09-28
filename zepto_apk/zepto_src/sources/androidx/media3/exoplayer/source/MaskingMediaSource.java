package androidx.media3.exoplayer.source;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

@UnstableApi
/* loaded from: classes3.dex */
public final class MaskingMediaSource extends WrappingMediaSource {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7594l;

    /* renamed from: m, reason: collision with root package name */
    public final Timeline.Window f7595m;
    public final Timeline.Period n;
    public MaskingTimeline o;
    public MaskingMediaPeriod p;
    public boolean q;
    public boolean r;
    public boolean s;

    public static final class MaskingTimeline extends ForwardingTimeline {

        /* renamed from: h, reason: collision with root package name */
        public static final Object f7596h = new Object();

        /* renamed from: f, reason: collision with root package name */
        public final Object f7597f;

        /* renamed from: g, reason: collision with root package name */
        public final Object f7598g;

        public MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.f7597f = obj;
            this.f7598g = obj2;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final int b(Object obj) {
            Object obj2;
            if (f7596h.equals(obj) && (obj2 = this.f7598g) != null) {
                obj = obj2;
            }
            return this.f7572e.b(obj);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            this.f7572e.f(i2, period, z);
            if (Util.a(period.f5476b, this.f7598g) && z) {
                period.f5476b = f7596h;
            }
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Object l(int i2) {
            Object objL = this.f7572e.l(i2);
            return Util.a(objL, this.f7598g) ? f7596h : objL;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            this.f7572e.m(i2, window, j2);
            if (Util.a(window.f5486a, this.f7597f)) {
                window.f5486a = Timeline.Window.q;
            }
            return window;
        }
    }

    @VisibleForTesting
    public static final class PlaceholderTimeline extends Timeline {

        /* renamed from: e, reason: collision with root package name */
        public final MediaItem f7599e;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.f7599e = mediaItem;
        }

        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            return obj == MaskingTimeline.f7596h ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            period.g(z ? 0 : null, z ? MaskingTimeline.f7596h : null, 0, -9223372036854775807L, 0L, AdPlaybackState.f5118g, true);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            return MaskingTimeline.f7596h;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            window.b(Timeline.Window.q, this.f7599e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            window.f5496k = true;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        super(mediaSource);
        this.f7594l = z && mediaSource.W();
        this.f7595m = new Timeline.Window();
        this.n = new Timeline.Period();
        Timeline timelineX = mediaSource.X();
        if (timelineX == null) {
            this.o = new MaskingTimeline(new PlaceholderTimeline(mediaSource.D()), Timeline.Window.q, MaskingTimeline.f7596h);
        } else {
            this.o = new MaskingTimeline(timelineX, null, null);
            this.s = true;
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).n();
        if (mediaPeriod == this.p) {
            this.p = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void O(MediaItem mediaItem) {
        if (this.s) {
            MaskingTimeline maskingTimeline = this.o;
            this.o = new MaskingTimeline(new TimelineWithUpdatedMediaItem(this.o.f7572e, mediaItem), maskingTimeline.f7597f, maskingTimeline.f7598g);
        } else {
            this.o = new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.q, MaskingTimeline.f7596h);
        }
        this.f7774k.O(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void V() {
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        return this.f7774k.c0(mediaItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i0(androidx.media3.common.Timeline r15) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.MaskingMediaSource.i0(androidx.media3.common.Timeline):void");
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        this.r = false;
        this.q = false;
        super.l0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final MediaSource.MediaPeriodId s0(MediaSource.MediaPeriodId mediaPeriodId) {
        Object obj = mediaPeriodId.f7609a;
        Object obj2 = this.o.f7598g;
        if (obj2 != null && obj2.equals(obj)) {
            obj = MaskingTimeline.f7596h;
        }
        return mediaPeriodId.a(obj);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final void u0() {
        if (this.f7594l) {
            return;
        }
        this.q = true;
        t0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final MaskingMediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
        maskingMediaPeriod.t(this.f7774k);
        if (!this.r) {
            this.p = maskingMediaPeriod;
            if (!this.q) {
                this.q = true;
                t0();
            }
            return maskingMediaPeriod;
        }
        Object obj = this.o.f7598g;
        Object obj2 = mediaPeriodId.f7609a;
        if (obj != null && obj2.equals(MaskingTimeline.f7596h)) {
            obj2 = this.o.f7598g;
        }
        maskingMediaPeriod.a(mediaPeriodId.a(obj2));
        return maskingMediaPeriod;
    }

    public final boolean w0(long j2) {
        MaskingMediaPeriod maskingMediaPeriod = this.p;
        int iB = this.o.b(maskingMediaPeriod.f7585a.f7609a);
        if (iB == -1) {
            return false;
        }
        MaskingTimeline maskingTimeline = this.o;
        Timeline.Period period = this.n;
        maskingTimeline.f(iB, period, false);
        long j3 = period.f5478d;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0L, j3 - 1);
        }
        maskingMediaPeriod.f7593i = j2;
        return true;
    }
}
