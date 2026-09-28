package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ForwardingPlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.legacy.VolumeProviderCompat;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes3.dex */
final class PlayerWrapper extends ForwardingPlayer {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10200b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f10201c;

    /* renamed from: d, reason: collision with root package name */
    public ImmutableList f10202d;

    /* renamed from: e, reason: collision with root package name */
    public SessionCommands f10203e;

    /* renamed from: f, reason: collision with root package name */
    public Player.Commands f10204f;

    /* renamed from: androidx.media3.session.PlayerWrapper$1, reason: invalid class name */
    class AnonymousClass1 extends VolumeProviderCompat {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Handler f10205f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i2, int i3, int i4, String str, Handler handler) {
            super(i2, i3, i4, str);
            this.f10205f = handler;
        }

        @Override // androidx.media3.session.legacy.VolumeProviderCompat
        public final void b(int i2) {
            Util.X(this.f10205f, new g2(i2, 1, this));
        }

        @Override // androidx.media3.session.legacy.VolumeProviderCompat
        public final void c(int i2) {
            Util.X(this.f10205f, new g2(i2, 0, this));
        }
    }

    public static final class CurrentMediaItemOnlyTimeline extends Timeline {

        /* renamed from: j, reason: collision with root package name */
        public static final Object f10207j = new Object();

        /* renamed from: e, reason: collision with root package name */
        public final MediaItem f10208e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f10209f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f10210g;

        /* renamed from: h, reason: collision with root package name */
        public final MediaItem.LiveConfiguration f10211h;

        /* renamed from: i, reason: collision with root package name */
        public final long f10212i;

        public CurrentMediaItemOnlyTimeline(PlayerWrapper playerWrapper) {
            this.f10208e = playerWrapper.B1();
            this.f10209f = playerWrapper.G1();
            this.f10210g = playerWrapper.E1();
            this.f10211h = playerWrapper.H1() ? MediaItem.LiveConfiguration.f5318f : null;
            this.f10212i = Util.T(playerWrapper.S0());
        }

        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            return f10207j.equals(obj) ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            Object obj = f10207j;
            period.getClass();
            period.g(obj, obj, 0, this.f10212i, 0L, AdPlaybackState.f5118g, false);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            return f10207j;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            window.b(f10207j, this.f10208e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f10209f, this.f10210g, this.f10211h, 0L, this.f10212i, 0, 0, 0L);
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 1;
        }
    }

    public static final class LegacyError {
    }

    public PlayerWrapper(ExoPlayer exoPlayer, boolean z, ImmutableList immutableList, SessionCommands sessionCommands, Player.Commands commands, Bundle bundle) {
        super(exoPlayer);
        this.f10200b = z;
        this.f10202d = immutableList;
        this.f10203e = sessionCommands;
        this.f10204f = commands;
        this.f10201c = bundle;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void A0(Player.Listener listener) {
        t();
        super.A0(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long A1() {
        t();
        return super.A1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int B0() {
        t();
        return super.B0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final MediaItem B1() {
        t();
        return super.B1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void C(float f2) {
        t();
        super.C(f2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void C0(boolean z) {
        t();
        super.C0(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void D(PlaybackParameters playbackParameters) {
        t();
        super.D(playbackParameters);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void D0(Player.Listener listener) {
        t();
        super.D0(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean D1(int i2) {
        t();
        return this.f5239a.D1(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void E() {
        t();
        super.E();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int E0() {
        t();
        return super.E0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean E1() {
        t();
        return super.E1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final PlaybackParameters F() {
        t();
        return super.F();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final Timeline F0() {
        t();
        return super.F0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int G() {
        t();
        return super.G();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void G0() {
        t();
        super.G0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean G1() {
        t();
        return super.G1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final TrackSelectionParameters H0() {
        t();
        return super.H0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean H1() {
        t();
        return super.H1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void I0() {
        t();
        super.I0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void J0(TextureView textureView) {
        t();
        super.J0(textureView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int K0() {
        t();
        return this.f5239a.K0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long L0() {
        t();
        return this.f5239a.L0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void M0(int i2, long j2) {
        t();
        super.M0(i2, j2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final Player.Commands N0() {
        t();
        return super.N0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean O0() {
        t();
        return super.O0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void P0(boolean z) {
        t();
        super.P0(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long Q0() {
        t();
        return super.Q0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void R0(int i2, MediaItem mediaItem) {
        t();
        super.R0(i2, mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long S0() {
        t();
        return this.f5239a.S0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int T0() {
        t();
        return super.T0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void U0(TextureView textureView) {
        t();
        super.U0(textureView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final VideoSize V0() {
        t();
        return super.V0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void X(long j2) {
        t();
        super.X(j2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final AudioAttributes X0() {
        t();
        return this.f5239a.X0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final DeviceInfo Y0() {
        t();
        return this.f5239a.Y0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void Z0(int i2, int i3) {
        t();
        super.Z0(i2, i3);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final PlaybackException a() {
        t();
        return super.a();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int a1() {
        t();
        return super.a1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean b() {
        t();
        return this.f5239a.b();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void b1(float f2) {
        t();
        super.b1(f2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void c1(List list, int i2, long j2) {
        t();
        super.c1(list, i2, j2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void d0(int i2) {
        t();
        super.d0(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void d1(int i2) {
        t();
        super.d1(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void e0(Surface surface) {
        t();
        super.e0(surface);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long e1() {
        t();
        return super.e1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean f0() {
        t();
        return super.f0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long f1() {
        t();
        return super.f1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long g0() {
        t();
        return super.g0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void g1(int i2, List list) {
        t();
        super.g1(i2, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long getDuration() {
        t();
        return super.getDuration();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final float getVolume() {
        t();
        return super.getVolume();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void h0() {
        t();
        super.h0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long h1() {
        t();
        return super.h1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int i0() {
        t();
        return super.i0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final MediaMetadata i1() {
        t();
        return this.f5239a.i1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void j0() {
        t();
        super.j0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean j1() {
        t();
        return super.j1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.session.legacy.PlaybackStateCompat k() {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.PlayerWrapper.k():androidx.media3.session.legacy.PlaybackStateCompat");
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void k0() {
        t();
        super.k0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void k1(MediaItem mediaItem, long j2) {
        t();
        super.k1(mediaItem, j2);
    }

    public final PlayerInfo l() {
        return new PlayerInfo(a(), 0, n(), m(), m(), 0, F(), G(), s1(), V0(), q(), 0, D1(18) ? i1() : MediaMetadata.J, D1(22) ? getVolume() : 0.0f, D1(21) ? X0() : AudioAttributes.f5143g, D1(28) ? z0() : CueGroup.f5638c, Y0(), D1(23) ? K0() : 0, s(), O0(), 1, E0(), u(), j1(), b(), r(), A1(), e1(), Q0(), D1(30) ? y0() : Tracks.f5546b, H0());
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void l0(int i2, boolean z) {
        t();
        super.l0(i2, z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int l1() {
        t();
        return super.l1();
    }

    public final Player.PositionInfo m() {
        boolean zD1 = D1(16);
        boolean zD12 = D1(17);
        return new Player.PositionInfo(null, zD12 ? l1() : 0, zD1 ? B1() : null, null, zD12 ? T0() : 0, zD1 ? z1() : 0L, zD1 ? f1() : 0L, zD1 ? B0() : -1, zD1 ? a1() : -1);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void m0() {
        t();
        super.m0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        t();
        super.m1(trackSelectionParameters);
    }

    public final SessionPositionInfo n() {
        boolean zD1 = D1(16);
        return new SessionPositionInfo(m(), zD1 && f0(), SystemClock.elapsedRealtime(), zD1 ? getDuration() : -9223372036854775807L, zD1 ? h1() : 0L, zD1 ? i0() : 0, zD1 ? g0() : 0L, zD1 ? L0() : -9223372036854775807L, zD1 ? S0() : -9223372036854775807L, zD1 ? t1() : 0L);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void n0(int i2) {
        t();
        super.n0(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void n1(SurfaceView surfaceView) {
        t();
        super.n1(surfaceView);
    }

    public final MediaItem o() {
        if (D1(16)) {
            return B1();
        }
        return null;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void o0(SurfaceView surfaceView) {
        t();
        super.o0(surfaceView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void o1(int i2, int i3) {
        t();
        super.o1(i2, i3);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void p() {
        t();
        super.p();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void p0(int i2, int i3, List list) {
        t();
        super.p0(i2, i3, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void p1(int i2, int i3, int i4) {
        t();
        super.p1(i2, i3, i4);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void pause() {
        t();
        super.pause();
    }

    public final Timeline q() {
        return D1(17) ? F0() : D1(16) ? new CurrentMediaItemOnlyTimeline(this) : Timeline.f5466a;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void q0(MediaMetadata mediaMetadata) {
        t();
        super.q0(mediaMetadata);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void q1(List list) {
        t();
        super.q1(list);
    }

    public final MediaMetadata r() {
        return D1(18) ? x1() : MediaMetadata.J;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void r0(int i2) {
        t();
        super.r0(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean r1() {
        t();
        return super.r1();
    }

    public final boolean s() {
        return D1(23) && r1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void s0(int i2, int i3) {
        t();
        super.s0(i2, i3);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final boolean s1() {
        t();
        return super.s1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void stop() {
        t();
        super.stop();
    }

    public final void t() {
        Assertions.g(Looper.myLooper() == this.f5239a.F1());
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void t0() {
        t();
        super.t0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long t1() {
        t();
        return super.t1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final int u() {
        t();
        return super.u();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void u0(boolean z) {
        t();
        super.u0(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void u1(int i2) {
        t();
        super.u1(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void v0(MediaItem mediaItem) {
        t();
        super.v0(mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void v1() {
        t();
        super.v1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void w0() {
        t();
        super.w0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void w1() {
        t();
        super.w1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void x0(int i2) {
        t();
        super.x0(i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final MediaMetadata x1() {
        t();
        return super.x1();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final Tracks y0() {
        t();
        return super.y0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final void y1(List list) {
        t();
        super.y1(list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final CueGroup z0() {
        t();
        return super.z0();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public final long z1() {
        t();
        return super.z1();
    }
}
