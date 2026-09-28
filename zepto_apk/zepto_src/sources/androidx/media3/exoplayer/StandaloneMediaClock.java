package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class StandaloneMediaClock implements MediaClock {

    /* renamed from: a, reason: collision with root package name */
    public final SystemClock f6362a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6363b;

    /* renamed from: c, reason: collision with root package name */
    public long f6364c;

    /* renamed from: d, reason: collision with root package name */
    public long f6365d;

    /* renamed from: e, reason: collision with root package name */
    public PlaybackParameters f6366e = PlaybackParameters.f5424d;

    public StandaloneMediaClock(SystemClock systemClock) {
        this.f6362a = systemClock;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void D(PlaybackParameters playbackParameters) {
        if (this.f6363b) {
            a(w());
        }
        this.f6366e = playbackParameters;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters F() {
        return this.f6366e;
    }

    public final void a(long j2) {
        this.f6364c = j2;
        if (this.f6363b) {
            this.f6362a.getClass();
            this.f6365d = android.os.SystemClock.elapsedRealtime();
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long w() {
        long j2 = this.f6364c;
        if (!this.f6363b) {
            return j2;
        }
        this.f6362a.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.f6365d;
        return this.f6366e.f5427a == 1.0f ? Util.T(jElapsedRealtime) + j2 : (jElapsedRealtime * r4.f5429c) + j2;
    }
}
