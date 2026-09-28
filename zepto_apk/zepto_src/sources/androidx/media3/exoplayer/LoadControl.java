package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.DefaultAllocator;

@UnstableApi
/* loaded from: classes3.dex */
public interface LoadControl {

    public static final class Parameters {

        /* renamed from: a, reason: collision with root package name */
        public final PlayerId f6255a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6256b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6257c;

        /* renamed from: d, reason: collision with root package name */
        public final float f6258d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f6259e;

        /* renamed from: f, reason: collision with root package name */
        public final long f6260f;

        public Parameters(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, float f2, boolean z, long j4) {
            this.f6255a = playerId;
            this.f6256b = j2;
            this.f6257c = j3;
            this.f6258d = f2;
            this.f6259e = z;
            this.f6260f = j4;
        }
    }

    default boolean a(Parameters parameters) {
        throw new IllegalStateException("shouldStartPlayback not implemented");
    }

    default boolean b() {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    default long c() {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    default void d(PlayerId playerId) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    DefaultAllocator e();

    default void f(PlayerId playerId) {
        throw new IllegalStateException("onReleased not implemented");
    }

    default boolean g(Parameters parameters) {
        return j(parameters.f6256b, parameters.f6257c, parameters.f6258d);
    }

    default void h(PlayerId playerId) {
        throw new IllegalStateException("onStopped not implemented");
    }

    default void i(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    default boolean j(long j2, long j3, float f2) {
        throw new IllegalStateException("shouldContinueLoading not implemented");
    }
}
