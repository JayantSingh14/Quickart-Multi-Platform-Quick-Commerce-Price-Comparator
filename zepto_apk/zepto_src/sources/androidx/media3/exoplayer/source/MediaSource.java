package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;

/* loaded from: classes3.dex */
public interface MediaSource {

    @UnstableApi
    public static final class MediaPeriodId {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7609a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7610b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7611c;

        /* renamed from: d, reason: collision with root package name */
        public final long f7612d;

        /* renamed from: e, reason: collision with root package name */
        public final int f7613e;

        public MediaPeriodId(Object obj) {
            this(-1L, obj);
        }

        public final MediaPeriodId a(Object obj) {
            if (this.f7609a.equals(obj)) {
                return this;
            }
            return new MediaPeriodId(obj, this.f7610b, this.f7611c, this.f7612d, this.f7613e);
        }

        public final boolean b() {
            return this.f7610b != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodId)) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            return this.f7609a.equals(mediaPeriodId.f7609a) && this.f7610b == mediaPeriodId.f7610b && this.f7611c == mediaPeriodId.f7611c && this.f7612d == mediaPeriodId.f7612d && this.f7613e == mediaPeriodId.f7613e;
        }

        public final int hashCode() {
            return ((((((((this.f7609a.hashCode() + 527) * 31) + this.f7610b) * 31) + this.f7611c) * 31) + ((int) this.f7612d)) * 31) + this.f7613e;
        }

        public MediaPeriodId(long j2, Object obj) {
            this(obj, -1, -1, j2, -1);
        }

        public MediaPeriodId(Object obj, int i2, long j2) {
            this(obj, -1, -1, j2, i2);
        }

        public MediaPeriodId(Object obj, int i2, int i3, long j2, int i4) {
            this.f7609a = obj;
            this.f7610b = i2;
            this.f7611c = i3;
            this.f7612d = j2;
            this.f7613e = i4;
        }
    }

    @UnstableApi
    public interface MediaSourceCaller {
        void b(BaseMediaSource baseMediaSource, Timeline timeline);
    }

    MediaPeriod C(MediaPeriodId mediaPeriodId, Allocator allocator, long j2);

    MediaItem D();

    void F(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void I(DrmSessionEventListener drmSessionEventListener);

    void J(MediaPeriod mediaPeriod);

    void L(MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId);

    void N(MediaSourceCaller mediaSourceCaller);

    default void O(MediaItem mediaItem) {
    }

    void T(MediaSourceCaller mediaSourceCaller);

    void U(MediaSourceCaller mediaSourceCaller);

    void V();

    default boolean W() {
        return !(this instanceof ConcatenatingMediaSource);
    }

    default Timeline X() {
        return null;
    }

    default boolean c0(MediaItem mediaItem) {
        return this instanceof ConcatenatingMediaSource2;
    }

    void d(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void z(MediaSourceEventListener mediaSourceEventListener);

    public interface Factory {

        /* renamed from: a, reason: collision with root package name */
        public static final Factory f7608a = MediaSourceFactory.f7619b;

        MediaSource a(MediaItem mediaItem);

        Factory b(DrmSessionManagerProvider drmSessionManagerProvider);

        Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        default void d(boolean z) {
        }

        default Factory e(com.brentvatne.exoplayer.a aVar) {
            return this;
        }

        default void f(DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
        }
    }
}
