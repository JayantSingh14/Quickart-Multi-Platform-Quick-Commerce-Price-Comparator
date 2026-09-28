package androidx.media3.exoplayer.source;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class ClippingMediaSource extends WrappingMediaSource {

    /* renamed from: l, reason: collision with root package name */
    public final long f7515l;

    /* renamed from: m, reason: collision with root package name */
    public final long f7516m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final ArrayList q;
    public final Timeline.Window r;
    public ClippingTimeline s;
    public IllegalClippingException t;
    public long u;
    public long v;

    public static final class ClippingTimeline extends ForwardingTimeline {

        /* renamed from: f, reason: collision with root package name */
        public final long f7517f;

        /* renamed from: g, reason: collision with root package name */
        public final long f7518g;

        /* renamed from: h, reason: collision with root package name */
        public final long f7519h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f7520i;

        public ClippingTimeline(Timeline timeline, long j2, long j3) throws IllegalClippingException {
            super(timeline);
            boolean z = false;
            if (timeline.h() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window windowM = timeline.m(0, new Timeline.Window(), 0L);
            long jMax = Math.max(0L, j2);
            if (!windowM.f5496k && jMax != 0 && !windowM.f5493h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j3 == Long.MIN_VALUE ? windowM.f5498m : Math.max(0L, j3);
            long j4 = windowM.f5498m;
            if (j4 != -9223372036854775807L) {
                jMax2 = jMax2 > j4 ? j4 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f7517f = jMax;
            this.f7518g = jMax2;
            this.f7519h = jMax2 != -9223372036854775807L ? jMax2 - jMax : -9223372036854775807L;
            if (windowM.f5494i && (jMax2 == -9223372036854775807L || (j4 != -9223372036854775807L && jMax2 == j4))) {
                z = true;
            }
            this.f7520i = z;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            this.f7572e.f(0, period, z);
            long j2 = period.f5479e - this.f7517f;
            long j3 = this.f7519h;
            period.g(period.f5475a, period.f5476b, 0, j3 != -9223372036854775807L ? j3 - j2 : -9223372036854775807L, j2, AdPlaybackState.f5118g, false);
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            this.f7572e.m(0, window, 0L);
            long j3 = window.p;
            long j4 = this.f7517f;
            window.p = j3 + j4;
            window.f5498m = this.f7519h;
            window.f5494i = this.f7520i;
            long j5 = window.f5497l;
            if (j5 != -9223372036854775807L) {
                long jMax = Math.max(j5, j4);
                window.f5497l = jMax;
                long j6 = this.f7518g;
                if (j6 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j6);
                }
                window.f5497l = jMax - j4;
            }
            long jJ0 = Util.j0(j4);
            long j7 = window.f5490e;
            if (j7 != -9223372036854775807L) {
                window.f5490e = j7 + jJ0;
            }
            long j8 = window.f5491f;
            if (j8 != -9223372036854775807L) {
                window.f5491f = j8 + jJ0;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i2) {
            super("Illegal clipping: ".concat(i2 != 0 ? i2 != 1 ? i2 != 2 ? zzck.UNKNOWN_CONTENT_TYPE : "start exceeds end" : "not seekable to start" : "invalid period count"));
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3) {
        this(mediaSource, j2, j3, true, false, false);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.f7774k.C(mediaPeriodId, allocator, j2), this.n, this.u, this.v);
        this.q.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.q;
        Assertions.g(arrayList.remove(mediaPeriod));
        this.f7774k.J(((ClippingMediaPeriod) mediaPeriod).f7505a);
        if (!arrayList.isEmpty() || this.o) {
            return;
        }
        ClippingTimeline clippingTimeline = this.s;
        clippingTimeline.getClass();
        v0(clippingTimeline.f7572e);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void V() throws IllegalClippingException {
        IllegalClippingException illegalClippingException = this.t;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.V();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaSource mediaSource = this.f7774k;
        return mediaSource.D().f5261e.equals(mediaItem.f5261e) && mediaSource.c0(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void i0(Timeline timeline) {
        if (this.t != null) {
            return;
        }
        v0(timeline);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        super.l0();
        this.t = null;
        this.s = null;
    }

    public final void v0(Timeline timeline) {
        long j2;
        long j3;
        long j4;
        Timeline.Window window = this.r;
        timeline.n(0, window);
        long j5 = window.p;
        ClippingTimeline clippingTimeline = this.s;
        ArrayList arrayList = this.q;
        long j6 = this.f7516m;
        if (clippingTimeline == null || arrayList.isEmpty() || this.o) {
            boolean z = this.p;
            j2 = this.f7515l;
            if (z) {
                long j7 = window.f5497l;
                j2 += j7;
                j3 = j7 + j6;
            } else {
                j3 = j6;
            }
            this.u = j5 + j2;
            this.v = j6 != Long.MIN_VALUE ? j5 + j3 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) arrayList.get(i2);
                long j8 = this.u;
                long j9 = this.v;
                clippingMediaPeriod.f7509e = j8;
                clippingMediaPeriod.f7510f = j9;
            }
            j4 = j3;
        } else {
            j2 = this.u - j5;
            j4 = j6 != Long.MIN_VALUE ? this.v - j5 : Long.MIN_VALUE;
        }
        try {
            ClippingTimeline clippingTimeline2 = new ClippingTimeline(timeline, j2, j4);
            this.s = clippingTimeline2;
            k0(clippingTimeline2);
        } catch (IllegalClippingException e2) {
            this.t = e2;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((ClippingMediaPeriod) arrayList.get(i3)).f7511g = this.t;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClippingMediaSource(MediaSource mediaSource, long j2, long j3, boolean z, boolean z2, boolean z3) {
        super(mediaSource);
        mediaSource.getClass();
        Assertions.a(j2 >= 0);
        this.f7515l = j2;
        this.f7516m = j3;
        this.n = z;
        this.o = z2;
        this.p = z3;
        this.q = new ArrayList();
        this.r = new Timeline.Window();
    }
}
