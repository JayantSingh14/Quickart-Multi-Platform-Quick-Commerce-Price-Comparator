package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes3.dex */
final class PlaybackInfo {
    public static final MediaSource.MediaPeriodId u = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final Timeline f6327a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f6328b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6329c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6330d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6331e;

    /* renamed from: f, reason: collision with root package name */
    public final ExoPlaybackException f6332f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6333g;

    /* renamed from: h, reason: collision with root package name */
    public final TrackGroupArray f6334h;

    /* renamed from: i, reason: collision with root package name */
    public final TrackSelectorResult f6335i;

    /* renamed from: j, reason: collision with root package name */
    public final List f6336j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f6337k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6338l;

    /* renamed from: m, reason: collision with root package name */
    public final int f6339m;
    public final int n;
    public final PlaybackParameters o;
    public final boolean p;
    public volatile long q;
    public volatile long r;
    public volatile long s;
    public volatile long t;

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, int i2, ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i3, int i4, PlaybackParameters playbackParameters, long j4, long j5, long j6, long j7, boolean z3) {
        this.f6327a = timeline;
        this.f6328b = mediaPeriodId;
        this.f6329c = j2;
        this.f6330d = j3;
        this.f6331e = i2;
        this.f6332f = exoPlaybackException;
        this.f6333g = z;
        this.f6334h = trackGroupArray;
        this.f6335i = trackSelectorResult;
        this.f6336j = list;
        this.f6337k = mediaPeriodId2;
        this.f6338l = z2;
        this.f6339m = i3;
        this.n = i4;
        this.o = playbackParameters;
        this.q = j4;
        this.r = j5;
        this.s = j6;
        this.t = j7;
        this.p = z3;
    }

    public static PlaybackInfo i(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f5466a;
        MediaSource.MediaPeriodId mediaPeriodId = u;
        return new PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.f7769d, trackSelectorResult, ImmutableList.r(), mediaPeriodId, false, 1, 0, PlaybackParameters.f5424d, 0L, 0L, 0L, 0L, false);
    }

    public final PlaybackInfo a() {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, this.f6331e, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, this.f6338l, this.f6339m, this.n, this.o, this.q, this.r, j(), SystemClock.elapsedRealtime(), this.p);
    }

    public final PlaybackInfo b(MediaSource.MediaPeriodId mediaPeriodId) {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, this.f6331e, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, mediaPeriodId, this.f6338l, this.f6339m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final PlaybackInfo c(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list) {
        return new PlaybackInfo(this.f6327a, mediaPeriodId, j3, j4, this.f6331e, this.f6332f, this.f6333g, trackGroupArray, trackSelectorResult, list, this.f6337k, this.f6338l, this.f6339m, this.n, this.o, this.q, j5, j2, SystemClock.elapsedRealtime(), this.p);
    }

    public final PlaybackInfo d(int i2, int i3, boolean z) {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, this.f6331e, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, z, i2, i3, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final PlaybackInfo e(ExoPlaybackException exoPlaybackException) {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, this.f6331e, exoPlaybackException, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, this.f6338l, this.f6339m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final PlaybackInfo f(PlaybackParameters playbackParameters) {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, this.f6331e, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, this.f6338l, this.f6339m, this.n, playbackParameters, this.q, this.r, this.s, this.t, this.p);
    }

    public final PlaybackInfo g(int i2) {
        return new PlaybackInfo(this.f6327a, this.f6328b, this.f6329c, this.f6330d, i2, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, this.f6338l, this.f6339m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final PlaybackInfo h(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f6328b, this.f6329c, this.f6330d, this.f6331e, this.f6332f, this.f6333g, this.f6334h, this.f6335i, this.f6336j, this.f6337k, this.f6338l, this.f6339m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final long j() {
        long j2;
        long j3;
        if (!k()) {
            return this.s;
        }
        do {
            j2 = this.t;
            j3 = this.s;
        } while (j2 != this.t);
        return Util.T(Util.j0(j3) + ((long) ((SystemClock.elapsedRealtime() - j2) * this.o.f5427a)));
    }

    public final boolean k() {
        return this.f6331e == 3 && this.f6338l && this.n == 0;
    }
}
