package androidx.media3.exoplayer.source.preload;

import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.WrappingMediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.brentvatne.exoplayer.a;

@UnstableApi
/* loaded from: classes3.dex */
public final class PreloadMediaSource extends WrappingMediaSource {

    /* renamed from: l, reason: collision with root package name */
    public boolean f7946l;

    /* renamed from: m, reason: collision with root package name */
    public Timeline f7947m;
    public Pair n;
    public Pair o;
    public boolean p;

    public static final class Factory implements MediaSource.Factory {
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory e(a aVar) {
            throw null;
        }
    }

    public static class MediaPeriodKey {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f7948a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f7949b;

        public MediaPeriodKey(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            this.f7948a = mediaPeriodId;
            this.f7949b = Long.valueOf(j2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodKey)) {
                return false;
            }
            MediaPeriodKey mediaPeriodKey = (MediaPeriodKey) obj;
            return PreloadMediaSource.w0(this.f7948a, mediaPeriodKey.f7948a) && this.f7949b.equals(mediaPeriodKey.f7949b);
        }

        public final int hashCode() {
            MediaSource.MediaPeriodId mediaPeriodId = this.f7948a;
            return this.f7949b.intValue() + ((((((((mediaPeriodId.f7609a.hashCode() + 527) * 31) + mediaPeriodId.f7610b) * 31) + mediaPeriodId.f7611c) * 31) + mediaPeriodId.f7613e) * 31);
        }
    }

    public interface PreloadControl {
    }

    public class PreloadMediaPeriodCallback implements MediaPeriod.Callback {
        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public final void j(MediaPeriod mediaPeriod) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public final void k(SequenceableLoader sequenceableLoader) {
            throw null;
        }
    }

    public static boolean w0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.f7609a.equals(mediaPeriodId2.f7609a) && mediaPeriodId.f7610b == mediaPeriodId2.f7610b && mediaPeriodId.f7611c == mediaPeriodId2.f7611c && mediaPeriodId.f7613e == mediaPeriodId2.f7613e;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaPeriodKey mediaPeriodKey = new MediaPeriodKey(mediaPeriodId, j2);
        Pair pair = this.n;
        if (pair != null && mediaPeriodKey.equals(pair.second)) {
            Pair pair2 = this.n;
            pair2.getClass();
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) pair2.first;
            if (!v0()) {
                return preloadMediaPeriod;
            }
            this.n = null;
            this.o = new Pair(preloadMediaPeriod, mediaPeriodId);
            return preloadMediaPeriod;
        }
        Pair pair3 = this.n;
        MediaSource mediaSource = this.f7774k;
        if (pair3 != null) {
            mediaSource.J(((PreloadMediaPeriod) pair3.first).f7940a);
            this.n = null;
        }
        PreloadMediaPeriod preloadMediaPeriod2 = new PreloadMediaPeriod(mediaSource.C(mediaPeriodId, allocator, j2));
        if (!v0()) {
            this.n = new Pair(preloadMediaPeriod2, mediaPeriodKey);
        }
        return preloadMediaPeriod2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(androidx.media3.exoplayer.source.MediaPeriod r3) {
        /*
            r2 = this;
            androidx.media3.exoplayer.source.preload.PreloadMediaPeriod r3 = (androidx.media3.exoplayer.source.preload.PreloadMediaPeriod) r3
            android.util.Pair r0 = r2.n
            r1 = 0
            if (r0 == 0) goto L11
            r0.getClass()
            java.lang.Object r0 = r0.first
            if (r3 != r0) goto L11
            r2.n = r1
            goto L1e
        L11:
            android.util.Pair r0 = r2.o
            if (r0 == 0) goto L1e
            r0.getClass()
            java.lang.Object r0 = r0.first
            if (r3 != r0) goto L1e
            r2.o = r1
        L1e:
            androidx.media3.exoplayer.source.MediaSource r0 = r2.f7774k
            androidx.media3.exoplayer.source.MediaPeriod r3 = r3.f7940a
            r0.J(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.preload.PreloadMediaSource.J(androidx.media3.exoplayer.source.MediaPeriod):void");
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void i0(Timeline timeline) {
        this.f7947m = timeline;
        k0(timeline);
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        if (v0()) {
            return;
        }
        this.p = false;
        this.f7947m = null;
        this.f7946l = false;
        super.l0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final MediaSource.MediaPeriodId s0(MediaSource.MediaPeriodId mediaPeriodId) {
        Pair pair = this.o;
        if (pair == null) {
            return mediaPeriodId;
        }
        pair.getClass();
        if (!w0(mediaPeriodId, (MediaSource.MediaPeriodId) pair.second)) {
            return mediaPeriodId;
        }
        Pair pair2 = this.o;
        pair2.getClass();
        return (MediaSource.MediaPeriodId) pair2.second;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final void u0() {
        if (v0() && !this.p) {
            throw null;
        }
        Timeline timeline = this.f7947m;
        if (timeline != null) {
            i0(timeline);
            throw null;
        }
        if (this.f7946l) {
            return;
        }
        this.f7946l = true;
        t0();
    }

    public final boolean v0() {
        return !this.f7495a.isEmpty();
    }
}
