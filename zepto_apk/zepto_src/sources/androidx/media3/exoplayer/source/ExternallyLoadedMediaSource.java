package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public final class ExternallyLoadedMediaSource extends BaseMediaSource {

    /* renamed from: h, reason: collision with root package name */
    public MediaItem f7568h;

    public static final class Factory implements MediaSource.Factory {
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaItem mediaItemD = D();
        mediaItemD.f5258b.getClass();
        MediaItem.LocalConfiguration localConfiguration = mediaItemD.f5258b;
        Assertions.e(localConfiguration.f5340b, "Externally loaded mediaItems require a MIME type.");
        return new ExternallyLoadedMediaPeriod(localConfiguration.f5339a, localConfiguration.f5340b);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.f7568h;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ((ExternallyLoadedMediaPeriod) mediaPeriod).getClass();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.f7568h = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        MediaItem.LocalConfiguration localConfiguration2 = D().f5258b;
        localConfiguration2.getClass();
        if (localConfiguration == null || !localConfiguration.f5339a.equals(localConfiguration2.f5339a) || !Objects.equals(localConfiguration.f5340b, localConfiguration2.f5340b)) {
            return false;
        }
        long j2 = localConfiguration.f5346h;
        return j2 == -9223372036854775807L || Util.T(j2) == 0;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        k0(new SinglePeriodTimeline(0L, true, false, D()));
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
    }
}
