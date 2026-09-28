package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.SystemClock;

/* loaded from: classes3.dex */
final class DefaultMediaClock implements MediaClock {

    /* renamed from: a, reason: collision with root package name */
    public final StandaloneMediaClock f6170a;

    /* renamed from: b, reason: collision with root package name */
    public final PlaybackParametersListener f6171b;

    /* renamed from: c, reason: collision with root package name */
    public Renderer f6172c;

    /* renamed from: d, reason: collision with root package name */
    public MediaClock f6173d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6174e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6175f;

    public interface PlaybackParametersListener {
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, SystemClock systemClock) {
        this.f6171b = playbackParametersListener;
        this.f6170a = new StandaloneMediaClock(systemClock);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void D(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f6173d;
        if (mediaClock != null) {
            mediaClock.D(playbackParameters);
            playbackParameters = this.f6173d.F();
        }
        this.f6170a.D(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters F() {
        MediaClock mediaClock = this.f6173d;
        return mediaClock != null ? mediaClock.F() : this.f6170a.f6366e;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final boolean n() {
        if (this.f6174e) {
            this.f6170a.getClass();
            return false;
        }
        MediaClock mediaClock = this.f6173d;
        mediaClock.getClass();
        return mediaClock.n();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long w() {
        if (this.f6174e) {
            return this.f6170a.w();
        }
        MediaClock mediaClock = this.f6173d;
        mediaClock.getClass();
        return mediaClock.w();
    }
}
