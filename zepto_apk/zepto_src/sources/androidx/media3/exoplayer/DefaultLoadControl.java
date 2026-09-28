package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.util.HashMap;
import java.util.Iterator;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultLoadControl implements LoadControl {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultAllocator f6158a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6159b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6160c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6161d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6162e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6163f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6164g;

    /* renamed from: h, reason: collision with root package name */
    public final long f6165h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f6166i;

    /* renamed from: j, reason: collision with root package name */
    public long f6167j;

    public static final class Builder {
    }

    public static class PlayerLoadingState {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6168a;

        /* renamed from: b, reason: collision with root package name */
        public int f6169b;
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(), 50000, 50000, 2500, 5000, false, 0);
    }

    public static void k(int i2, int i3, String str, String str2) {
        Assertions.b(i2 >= i3, str + " cannot be less than " + str2);
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final boolean a(LoadControl.Parameters parameters) {
        long jD = Util.D(parameters.f6257c, parameters.f6258d);
        long jMin = parameters.f6259e ? this.f6162e : this.f6161d;
        long j2 = parameters.f6260f;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        if (jMin <= 0 || jD >= jMin) {
            return true;
        }
        return !this.f6164g && this.f6158a.f() >= l();
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final boolean b() {
        return false;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final long c() {
        return this.f6165h;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final void d(PlayerId playerId) {
        long id = Thread.currentThread().getId();
        long j2 = this.f6167j;
        Assertions.f("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j2 == -1 || j2 == id);
        this.f6167j = id;
        HashMap map = this.f6166i;
        if (!map.containsKey(playerId)) {
            map.put(playerId, new PlayerLoadingState());
        }
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) map.get(playerId);
        playerLoadingState.getClass();
        int i2 = this.f6163f;
        if (i2 == -1) {
            i2 = 13107200;
        }
        playerLoadingState.f6169b = i2;
        playerLoadingState.f6168a = false;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final DefaultAllocator e() {
        return this.f6158a;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final void f(PlayerId playerId) {
        HashMap map = this.f6166i;
        if (map.remove(playerId) != null) {
            m();
        }
        if (map.isEmpty()) {
            this.f6167j = -1L;
        }
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final boolean g(LoadControl.Parameters parameters) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) this.f6166i.get(parameters.f6255a);
        playerLoadingState.getClass();
        boolean z = true;
        boolean z2 = this.f6158a.f() >= l();
        float f2 = parameters.f6258d;
        long j2 = this.f6160c;
        long jMin = this.f6159b;
        if (f2 > 1.0f) {
            jMin = Math.min(Util.z(jMin, f2), j2);
        }
        long jMax = Math.max(jMin, 500000L);
        long j3 = parameters.f6257c;
        if (j3 < jMax) {
            if (!this.f6164g && z2) {
                z = false;
            }
            playerLoadingState.f6168a = z;
            if (!z && j3 < 500000) {
                Log.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= j2 || z2) {
            playerLoadingState.f6168a = false;
        }
        return playerLoadingState.f6168a;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public final void h(PlayerId playerId) {
        if (this.f6166i.remove(playerId) != null) {
            m();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.media3.exoplayer.LoadControl
    public final void i(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) this.f6166i.get(playerId);
        playerLoadingState.getClass();
        int iMax = this.f6163f;
        if (iMax == -1) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = 13107200;
                if (i2 < rendererArr.length) {
                    if (exoTrackSelectionArr[i2] != null) {
                        switch (rendererArr[i2].g()) {
                            case CompanionAdSlot.FLUID_SIZE /* -2 */:
                                i4 = 0;
                                i3 += i4;
                                break;
                            case -1:
                            default:
                                throw new IllegalArgumentException();
                            case 0:
                                i4 = 144310272;
                                i3 += i4;
                                break;
                            case 1:
                                i3 += i4;
                                break;
                            case 2:
                                i4 = 131072000;
                                i3 += i4;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i4 = 131072;
                                i3 += i4;
                                break;
                        }
                    }
                    i2++;
                } else {
                    iMax = Math.max(13107200, i3);
                }
            }
        }
        playerLoadingState.f6169b = iMax;
        m();
    }

    public final int l() {
        Iterator it = this.f6166i.values().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((PlayerLoadingState) it.next()).f6169b;
        }
        return i2;
    }

    public final void m() {
        if (!this.f6166i.isEmpty()) {
            this.f6158a.g(l());
            return;
        }
        DefaultAllocator defaultAllocator = this.f6158a;
        synchronized (defaultAllocator) {
            if (defaultAllocator.f8130a) {
                defaultAllocator.g(0);
            }
        }
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, boolean z, int i6) {
        k(i4, 0, "bufferForPlaybackMs", "0");
        k(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        k(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i3, i2, "maxBufferMs", "minBufferMs");
        k(i6, 0, "backBufferDurationMs", "0");
        this.f6158a = defaultAllocator;
        this.f6159b = Util.T(i2);
        this.f6160c = Util.T(i3);
        this.f6161d = Util.T(i4);
        this.f6162e = Util.T(i5);
        this.f6163f = -1;
        this.f6164g = z;
        this.f6165h = Util.T(i6);
        this.f6166i = new HashMap();
        this.f6167j = -1L;
    }
}
