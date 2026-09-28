package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public interface MediaSourceFactory extends MediaSource.Factory {

    /* renamed from: b, reason: collision with root package name */
    public static final MediaSourceFactory f7619b = new AnonymousClass1();

    /* renamed from: androidx.media3.exoplayer.source.MediaSourceFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements MediaSourceFactory {
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
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
}
