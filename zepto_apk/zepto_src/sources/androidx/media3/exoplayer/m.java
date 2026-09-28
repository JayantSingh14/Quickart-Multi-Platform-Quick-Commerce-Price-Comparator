package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7272a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7273b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7274c;

    public /* synthetic */ m(int i2, Object obj, Object obj2) {
        this.f7272a = i2;
        this.f7273b = obj;
        this.f7274c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = true;
        switch (this.f7272a) {
            case 0:
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.f7273b;
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = (ExoPlayerImplInternal.PlaybackInfoUpdate) this.f7274c;
                int i2 = exoPlayerImpl.H - playbackInfoUpdate.f6241c;
                exoPlayerImpl.H = i2;
                if (playbackInfoUpdate.f6242d) {
                    exoPlayerImpl.I = playbackInfoUpdate.f6243e;
                    exoPlayerImpl.J = true;
                }
                if (i2 == 0) {
                    Timeline timeline = playbackInfoUpdate.f6240b.f6327a;
                    if (!exoPlayerImpl.k0.f6327a.p() && timeline.p()) {
                        exoPlayerImpl.l0 = -1;
                        exoPlayerImpl.m0 = 0L;
                    }
                    if (!timeline.p()) {
                        List listAsList = Arrays.asList(((PlaylistTimeline) timeline).f6353l);
                        Assertions.g(listAsList.size() == exoPlayerImpl.o.size());
                        for (int i3 = 0; i3 < listAsList.size(); i3++) {
                            ((ExoPlayerImpl.MediaSourceHolderSnapshot) exoPlayerImpl.o.get(i3)).f6216c = (Timeline) listAsList.get(i3);
                        }
                    }
                    long j2 = -9223372036854775807L;
                    if (exoPlayerImpl.J) {
                        if (playbackInfoUpdate.f6240b.f6328b.equals(exoPlayerImpl.k0.f6328b) && playbackInfoUpdate.f6240b.f6330d == exoPlayerImpl.k0.s) {
                            z = false;
                        }
                        if (z) {
                            if (timeline.p() || playbackInfoUpdate.f6240b.f6328b.b()) {
                                j2 = playbackInfoUpdate.f6240b.f6330d;
                            } else {
                                PlaybackInfo playbackInfo = playbackInfoUpdate.f6240b;
                                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f6328b;
                                long j3 = playbackInfo.f6330d;
                                Object obj = mediaPeriodId.f7609a;
                                Timeline.Period period = exoPlayerImpl.n;
                                timeline.g(obj, period);
                                j2 = j3 + period.f5479e;
                            }
                        }
                    } else {
                        z = false;
                    }
                    long j4 = j2;
                    exoPlayerImpl.J = false;
                    exoPlayerImpl.T(playbackInfoUpdate.f6240b, 1, z, exoPlayerImpl.I, j4, -1, false);
                    return;
                }
                return;
            default:
                PlayerMessage playerMessage = (PlayerMessage) this.f7274c;
                int i4 = ExoPlayerImplInternal.E0;
                ((ExoPlayerImplInternal) this.f7273b).getClass();
                try {
                    synchronized (playerMessage) {
                    }
                    try {
                        playerMessage.f6340a.o(playerMessage.f6343d, playerMessage.f6344e);
                        return;
                    } finally {
                        playerMessage.b(true);
                    }
                } catch (ExoPlaybackException e2) {
                    Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                    throw new RuntimeException(e2);
                }
        }
    }
}
