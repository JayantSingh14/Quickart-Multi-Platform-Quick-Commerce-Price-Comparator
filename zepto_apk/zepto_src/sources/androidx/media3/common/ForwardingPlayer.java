package androidx.media3.common;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.Player;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class ForwardingPlayer implements Player {

    /* renamed from: a, reason: collision with root package name */
    public final ExoPlayer f5239a;

    public static final class ForwardingListener implements Player.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final ForwardingPlayer f5240a;

        /* renamed from: b, reason: collision with root package name */
        public final Player.Listener f5241b;

        public ForwardingListener(ForwardingPlayer forwardingPlayer, Player.Listener listener) {
            this.f5240a = forwardingPlayer;
            this.f5241b = listener;
        }

        @Override // androidx.media3.common.Player.Listener
        public final void A1(AudioAttributes audioAttributes) {
            this.f5241b.A1(audioAttributes);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void B1(Timeline timeline, int i2) {
            this.f5241b.B1(timeline, i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void C1(MediaMetadata mediaMetadata) {
            this.f5241b.C1(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void D1(long j2) {
            this.f5241b.D1(j2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void E1(Tracks tracks) {
            this.f5241b.E1(tracks);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void F1(DeviceInfo deviceInfo) {
            this.f5241b.F1(deviceInfo);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void G1(int i2, boolean z) {
            this.f5241b.G1(i2, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void H1(PlaybackException playbackException) {
            this.f5241b.H1(playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void I1(long j2) {
            this.f5241b.I1(j2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void J1(boolean z) {
            this.f5241b.J1(z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void b(VideoSize videoSize) {
            this.f5241b.b(videoSize);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void d(boolean z) {
            this.f5241b.d(z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void d1(int i2) {
            this.f5241b.d1(i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void e1(CueGroup cueGroup) {
            this.f5241b.e1(cueGroup);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (this.f5240a.equals(forwardingListener.f5240a)) {
                return this.f5241b.equals(forwardingListener.f5241b);
            }
            return false;
        }

        @Override // androidx.media3.common.Player.Listener
        public final void f1(Metadata metadata) {
            this.f5241b.f1(metadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void g1(int i2) {
            this.f5241b.g1(i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void h1(boolean z) {
            this.f5241b.w1(z);
        }

        public final int hashCode() {
            return this.f5241b.hashCode() + (this.f5240a.hashCode() * 31);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void i1(int i2) {
            this.f5241b.i1(i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void j1(int i2, MediaItem mediaItem) {
            this.f5241b.j1(i2, mediaItem);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void k(List list) {
            this.f5241b.k(list);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void k1(boolean z) {
            this.f5241b.k1(z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void l1(PlaybackParameters playbackParameters) {
            this.f5241b.l1(playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void m1(int i2, boolean z) {
            this.f5241b.m1(i2, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void n1(long j2) {
            this.f5241b.n1(j2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void o1(MediaMetadata mediaMetadata) {
            this.f5241b.o1(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void p1(TrackSelectionParameters trackSelectionParameters) {
            this.f5241b.p1(trackSelectionParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void q1() {
            this.f5241b.q1();
        }

        @Override // androidx.media3.common.Player.Listener
        public final void r1(PlaybackException playbackException) {
            this.f5241b.r1(playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void s1(int i2, int i3) {
            this.f5241b.s1(i2, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void t1(Player.Commands commands) {
            this.f5241b.t1(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void u1(int i2) {
            this.f5241b.u1(i2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
            this.f5241b.v1(i2, positionInfo, positionInfo2);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void w1(boolean z) {
            this.f5241b.w1(z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void x1(Player player, Player.Events events) {
            this.f5241b.x1(this.f5240a, events);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void y1(int i2, boolean z) {
            this.f5241b.y1(i2, z);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void z1(float f2) {
            this.f5241b.z1(f2);
        }
    }

    public ForwardingPlayer(ExoPlayer exoPlayer) {
        this.f5239a = exoPlayer;
    }

    @Override // androidx.media3.common.Player
    public void A0(Player.Listener listener) {
        this.f5239a.A0(new ForwardingListener(this, listener));
    }

    @Override // androidx.media3.common.Player
    public long A1() {
        return this.f5239a.A1();
    }

    @Override // androidx.media3.common.Player
    public int B0() {
        return this.f5239a.B0();
    }

    @Override // androidx.media3.common.Player
    public MediaItem B1() {
        return this.f5239a.B1();
    }

    @Override // androidx.media3.common.Player
    public void C(float f2) {
        this.f5239a.C(f2);
    }

    @Override // androidx.media3.common.Player
    public void C0(boolean z) {
        this.f5239a.C0(z);
    }

    @Override // androidx.media3.common.Player
    public final boolean C1() {
        return this.f5239a.C1();
    }

    @Override // androidx.media3.common.Player
    public void D(PlaybackParameters playbackParameters) {
        this.f5239a.D(playbackParameters);
    }

    @Override // androidx.media3.common.Player
    public void D0(Player.Listener listener) {
        this.f5239a.D0(new ForwardingListener(this, listener));
    }

    @Override // androidx.media3.common.Player
    public boolean D1(int i2) {
        return this.f5239a.D1(i2);
    }

    @Override // androidx.media3.common.Player
    public void E() {
        this.f5239a.E();
    }

    @Override // androidx.media3.common.Player
    public int E0() {
        return this.f5239a.E0();
    }

    @Override // androidx.media3.common.Player
    public boolean E1() {
        return this.f5239a.E1();
    }

    @Override // androidx.media3.common.Player
    public PlaybackParameters F() {
        return this.f5239a.F();
    }

    @Override // androidx.media3.common.Player
    public Timeline F0() {
        return this.f5239a.F0();
    }

    @Override // androidx.media3.common.Player
    public final Looper F1() {
        return this.f5239a.F1();
    }

    @Override // androidx.media3.common.Player
    public int G() {
        return this.f5239a.G();
    }

    @Override // androidx.media3.common.Player
    public void G0() {
        this.f5239a.G0();
    }

    @Override // androidx.media3.common.Player
    public boolean G1() {
        return this.f5239a.G1();
    }

    @Override // androidx.media3.common.Player
    public TrackSelectionParameters H0() {
        return this.f5239a.H0();
    }

    @Override // androidx.media3.common.Player
    public boolean H1() {
        return this.f5239a.H1();
    }

    @Override // androidx.media3.common.Player
    public void I0() {
        this.f5239a.I0();
    }

    @Override // androidx.media3.common.Player
    public void J0(TextureView textureView) {
        this.f5239a.J0(textureView);
    }

    @Override // androidx.media3.common.Player
    public int K0() {
        return this.f5239a.K0();
    }

    @Override // androidx.media3.common.Player
    public long L0() {
        return this.f5239a.L0();
    }

    @Override // androidx.media3.common.Player
    public void M0(int i2, long j2) {
        this.f5239a.M0(i2, j2);
    }

    @Override // androidx.media3.common.Player
    public Player.Commands N0() {
        return this.f5239a.N0();
    }

    @Override // androidx.media3.common.Player
    public boolean O0() {
        return this.f5239a.O0();
    }

    @Override // androidx.media3.common.Player
    public void P0(boolean z) {
        this.f5239a.P0(z);
    }

    @Override // androidx.media3.common.Player
    public long Q0() {
        return this.f5239a.Q0();
    }

    @Override // androidx.media3.common.Player
    public void R0(int i2, MediaItem mediaItem) {
        this.f5239a.R0(i2, mediaItem);
    }

    @Override // androidx.media3.common.Player
    public long S0() {
        return this.f5239a.S0();
    }

    @Override // androidx.media3.common.Player
    public int T0() {
        return this.f5239a.T0();
    }

    @Override // androidx.media3.common.Player
    public void U0(TextureView textureView) {
        this.f5239a.U0(textureView);
    }

    @Override // androidx.media3.common.Player
    public VideoSize V0() {
        return this.f5239a.V0();
    }

    @Override // androidx.media3.common.Player
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        this.f5239a.W0(audioAttributes, z);
    }

    @Override // androidx.media3.common.Player
    public void X(long j2) {
        this.f5239a.X(j2);
    }

    @Override // androidx.media3.common.Player
    public AudioAttributes X0() {
        return this.f5239a.X0();
    }

    @Override // androidx.media3.common.Player
    public DeviceInfo Y0() {
        return this.f5239a.Y0();
    }

    @Override // androidx.media3.common.Player
    public void Z0(int i2, int i3) {
        this.f5239a.Z0(i2, i3);
    }

    @Override // androidx.media3.common.Player
    public PlaybackException a() {
        return this.f5239a.a();
    }

    @Override // androidx.media3.common.Player
    public int a1() {
        return this.f5239a.a1();
    }

    @Override // androidx.media3.common.Player
    public boolean b() {
        return this.f5239a.b();
    }

    @Override // androidx.media3.common.Player
    public void b1(float f2) {
        this.f5239a.b1(f2);
    }

    @Override // androidx.media3.common.Player
    public void c1(List list, int i2, long j2) {
        this.f5239a.c1(list, i2, j2);
    }

    @Override // androidx.media3.common.Player
    public void d0(int i2) {
        this.f5239a.d0(i2);
    }

    @Override // androidx.media3.common.Player
    public void d1(int i2) {
        this.f5239a.d1(i2);
    }

    @Override // androidx.media3.common.Player
    public void e0(Surface surface) {
        this.f5239a.e0(surface);
    }

    @Override // androidx.media3.common.Player
    public long e1() {
        return this.f5239a.e1();
    }

    @Override // androidx.media3.common.Player
    public boolean f0() {
        return this.f5239a.f0();
    }

    @Override // androidx.media3.common.Player
    public long f1() {
        return this.f5239a.f1();
    }

    @Override // androidx.media3.common.Player
    public long g0() {
        return this.f5239a.g0();
    }

    @Override // androidx.media3.common.Player
    public void g1(int i2, List list) {
        this.f5239a.g1(i2, list);
    }

    @Override // androidx.media3.common.Player
    public long getDuration() {
        return this.f5239a.getDuration();
    }

    @Override // androidx.media3.common.Player
    public float getVolume() {
        return this.f5239a.getVolume();
    }

    @Override // androidx.media3.common.Player
    public void h0() {
        this.f5239a.h0();
    }

    @Override // androidx.media3.common.Player
    public long h1() {
        return this.f5239a.h1();
    }

    @Override // androidx.media3.common.Player
    public int i0() {
        return this.f5239a.i0();
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata i1() {
        return this.f5239a.i1();
    }

    @Override // androidx.media3.common.Player
    public void j0() {
        this.f5239a.j0();
    }

    @Override // androidx.media3.common.Player
    public boolean j1() {
        return this.f5239a.j1();
    }

    @Override // androidx.media3.common.Player
    public void k0() {
        this.f5239a.k0();
    }

    @Override // androidx.media3.common.Player
    public void k1(MediaItem mediaItem, long j2) {
        this.f5239a.k1(mediaItem, j2);
    }

    @Override // androidx.media3.common.Player
    public void l0(int i2, boolean z) {
        this.f5239a.l0(i2, z);
    }

    @Override // androidx.media3.common.Player
    public int l1() {
        return this.f5239a.l1();
    }

    @Override // androidx.media3.common.Player
    public void m0() {
        this.f5239a.m0();
    }

    @Override // androidx.media3.common.Player
    public void m1(TrackSelectionParameters trackSelectionParameters) {
        this.f5239a.m1(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public void n0(int i2) {
        this.f5239a.n0(i2);
    }

    @Override // androidx.media3.common.Player
    public void n1(SurfaceView surfaceView) {
        this.f5239a.n1(surfaceView);
    }

    @Override // androidx.media3.common.Player
    public void o0(SurfaceView surfaceView) {
        this.f5239a.o0(surfaceView);
    }

    @Override // androidx.media3.common.Player
    public void o1(int i2, int i3) {
        this.f5239a.o1(i2, i3);
    }

    @Override // androidx.media3.common.Player
    public void p() {
        this.f5239a.p();
    }

    @Override // androidx.media3.common.Player
    public void p0(int i2, int i3, List list) {
        this.f5239a.p0(i2, i3, list);
    }

    @Override // androidx.media3.common.Player
    public void p1(int i2, int i3, int i4) {
        this.f5239a.p1(i2, i3, i4);
    }

    @Override // androidx.media3.common.Player
    public void pause() {
        this.f5239a.pause();
    }

    @Override // androidx.media3.common.Player
    public void q0(MediaMetadata mediaMetadata) {
        this.f5239a.q0(mediaMetadata);
    }

    @Override // androidx.media3.common.Player
    public void q1(List list) {
        this.f5239a.q1(list);
    }

    @Override // androidx.media3.common.Player
    public void r0(int i2) {
        this.f5239a.r0(i2);
    }

    @Override // androidx.media3.common.Player
    public boolean r1() {
        return this.f5239a.r1();
    }

    @Override // androidx.media3.common.Player
    public void s0(int i2, int i3) {
        this.f5239a.s0(i2, i3);
    }

    @Override // androidx.media3.common.Player
    public boolean s1() {
        return this.f5239a.s1();
    }

    @Override // androidx.media3.common.Player
    public void stop() {
        this.f5239a.stop();
    }

    @Override // androidx.media3.common.Player
    public void t0() {
        this.f5239a.t0();
    }

    @Override // androidx.media3.common.Player
    public long t1() {
        return this.f5239a.t1();
    }

    @Override // androidx.media3.common.Player
    public int u() {
        return this.f5239a.u();
    }

    @Override // androidx.media3.common.Player
    public void u0(boolean z) {
        this.f5239a.u0(z);
    }

    @Override // androidx.media3.common.Player
    public void u1(int i2) {
        this.f5239a.u1(i2);
    }

    @Override // androidx.media3.common.Player
    public void v0(MediaItem mediaItem) {
        this.f5239a.v0(mediaItem);
    }

    @Override // androidx.media3.common.Player
    public void v1() {
        this.f5239a.v1();
    }

    @Override // androidx.media3.common.Player
    public void w0() {
        this.f5239a.w0();
    }

    @Override // androidx.media3.common.Player
    public void w1() {
        this.f5239a.w1();
    }

    @Override // androidx.media3.common.Player
    public void x0(int i2) {
        this.f5239a.x0(i2);
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata x1() {
        return this.f5239a.x1();
    }

    @Override // androidx.media3.common.Player
    public Tracks y0() {
        return this.f5239a.y0();
    }

    @Override // androidx.media3.common.Player
    public void y1(List list) {
        this.f5239a.y1(list);
    }

    @Override // androidx.media3.common.Player
    public CueGroup z0() {
        return this.f5239a.z0();
    }

    @Override // androidx.media3.common.Player
    public long z1() {
        return this.f5239a.z1();
    }
}
