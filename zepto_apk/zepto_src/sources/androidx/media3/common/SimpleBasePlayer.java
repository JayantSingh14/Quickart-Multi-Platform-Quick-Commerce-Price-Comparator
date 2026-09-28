package androidx.media3.common;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SimpleBasePlayer extends BasePlayer {

    public static final class MediaItemData {

        public static final class Builder {
        }

        public static Object a(MediaItemData mediaItemData, int i2) {
            mediaItemData.getClass();
            throw null;
        }

        public static void b(MediaItemData mediaItemData, int i2, int i3, Timeline.Period period) {
            mediaItemData.getClass();
            throw null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemData)) {
                return false;
            }
            ((MediaItemData) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    public static final class PeriodData {

        public static final class Builder {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeriodData)) {
                return false;
            }
            ((PeriodData) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    public static final class PlaceholderUid {
    }

    public static final class PlaylistTimeline extends Timeline {
        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period g(Object obj, Timeline.Period period) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            throw null;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            throw null;
        }
    }

    public interface PositionSupplier {
        public static final b c0 = new b(0L);
    }

    public static final class State {

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final PositionSupplier f5451a;

            public Builder() {
                Player.Commands commands = Player.Commands.f5430b;
                PlaybackParameters playbackParameters = PlaybackParameters.f5424d;
                TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.C;
                AudioAttributes audioAttributes = AudioAttributes.f5143g;
                VideoSize videoSize = VideoSize.f5559e;
                CueGroup cueGroup = CueGroup.f5638c;
                DeviceInfo deviceInfo = DeviceInfo.f5188e;
                Size size = Size.f5730c;
                new Metadata(-9223372036854775807L, new Metadata.Entry[0]);
                ImmutableList.r();
                Timeline timeline = Timeline.f5466a;
                MediaMetadata mediaMetadata = MediaMetadata.J;
                this.f5451a = new b(-9223372036854775807L);
                new b(-9223372036854775807L);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            ((State) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    @Override // androidx.media3.common.Player
    public final void A0(Player.Listener listener) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long A1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int B0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void C0(boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void D(PlaybackParameters playbackParameters) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void D0(Player.Listener listener) {
        listener.getClass();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int E0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters F() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Timeline F0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Looper F1() {
        return null;
    }

    @Override // androidx.media3.common.Player
    public final int G() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void G0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters H0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void J0(TextureView textureView) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int K0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands N0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean O0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void P0(boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long Q0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int T0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void U0(TextureView textureView) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final VideoSize V0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes X0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo Y0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void Z0(int i2, int i3) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException a() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int a1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean b() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void b1(float f2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void c1(List list, int i2, long j2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void d0(int i2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void e0(Surface surface) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long e1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean f0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long f1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long g0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void g1(int i2, List list) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long h1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata i1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void l0(int i2, boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int l1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void m0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.BasePlayer
    public final void n(int i2, long j2, boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void n0(int i2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void n1(SurfaceView surfaceView) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void o0(SurfaceView surfaceView) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p0(int i2, int i3, List list) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p1(int i2, int i3, int i4) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void q0(MediaMetadata mediaMetadata) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean r1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void s0(int i2, int i3) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean s1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long t1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int u() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void u0(boolean z) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void u1(int i2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void x0(int i2) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata x1() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Tracks y0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void y1(List list) {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup z0() {
        Thread.currentThread();
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long z1() {
        Thread.currentThread();
        throw null;
    }
}
