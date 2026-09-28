package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
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
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.DoNotMock;
import java.util.HashSet;
import java.util.List;

@DoNotMock
/* loaded from: classes3.dex */
public class MediaController implements Player {

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.Window f9954a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9955b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaControllerImpl f9956c;

    /* renamed from: d, reason: collision with root package name */
    public final Listener f9957d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f9958e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9959f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9960g;

    /* renamed from: h, reason: collision with root package name */
    public final MediaControllerHolder f9961h;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f9962a;

        /* renamed from: b, reason: collision with root package name */
        public Listener f9963b;

        /* renamed from: c, reason: collision with root package name */
        public Looper f9964c;

        /* renamed from: d, reason: collision with root package name */
        public CacheBitmapLoader f9965d;

        /* renamed from: androidx.media3.session.MediaController$Builder$1, reason: invalid class name */
        class AnonymousClass1 implements Listener {
        }
    }

    public interface ConnectionCallback {
    }

    public interface MediaControllerImpl {
        void A0(Player.Listener listener);

        long A1();

        int B0();

        void C(float f2);

        void C0(boolean z);

        void D(PlaybackParameters playbackParameters);

        void D0(Player.Listener listener);

        void E();

        int E0();

        PlaybackParameters F();

        Timeline F0();

        int G();

        void G0();

        TrackSelectionParameters H0();

        void I0();

        void J0(TextureView textureView);

        int K0();

        long L0();

        void M0(int i2, long j2);

        Player.Commands N0();

        boolean O0();

        void P0(boolean z);

        long Q0();

        void R0(int i2, MediaItem mediaItem);

        long S0();

        int T0();

        void U0(TextureView textureView);

        VideoSize V0();

        void W0(AudioAttributes audioAttributes, boolean z);

        void X(long j2);

        AudioAttributes X0();

        DeviceInfo Y0();

        void Z0(int i2, int i3);

        PlaybackException a();

        int a1();

        boolean b();

        void b1(float f2);

        SessionCommands c();

        void c1(List list, int i2, long j2);

        void connect();

        ListenableFuture d(SessionCommand sessionCommand);

        void d0(int i2);

        void d1(int i2);

        ImmutableList e();

        void e0(Surface surface);

        long e1();

        boolean f0();

        long f1();

        long g0();

        void g1(int i2, List list);

        long getDuration();

        float getVolume();

        void h0();

        long h1();

        int i0();

        MediaMetadata i1();

        boolean isConnected();

        void j0();

        boolean j1();

        void k0();

        void k1(MediaItem mediaItem, long j2);

        void l0(int i2, boolean z);

        int l1();

        void m0();

        void m1(TrackSelectionParameters trackSelectionParameters);

        void n0(int i2);

        void n1(SurfaceView surfaceView);

        void o0(SurfaceView surfaceView);

        void o1(int i2, int i3);

        void p();

        void p0(int i2, int i3, List list);

        void p1(int i2, int i3, int i4);

        void pause();

        void q0(MediaMetadata mediaMetadata);

        void q1(List list);

        void r0(int i2);

        boolean r1();

        void release();

        void s0(int i2, int i3);

        boolean s1();

        void stop();

        void t0();

        long t1();

        int u();

        void u0(boolean z);

        void u1(int i2);

        void v0(MediaItem mediaItem);

        void v1();

        void w0();

        void w1();

        void x0(int i2);

        MediaMetadata x1();

        Tracks y0();

        void y1(List list);

        CueGroup z0();

        long z1();
    }

    public MediaController(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, MediaControllerHolder mediaControllerHolder, CacheBitmapLoader cacheBitmapLoader) {
        MediaController mediaController;
        MediaControllerImpl mediaControllerImplBase;
        Assertions.e(context, "context must not be null");
        Assertions.e(sessionToken, "token must not be null");
        Log.g("MediaController", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.1] [" + Util.f5748e + "]");
        this.f9954a = new Timeline.Window();
        this.f9959f = -9223372036854775807L;
        this.f9957d = listener;
        this.f9958e = new Handler(looper);
        this.f9961h = mediaControllerHolder;
        if (sessionToken.f10269a.g()) {
            cacheBitmapLoader.getClass();
            mediaControllerImplBase = new MediaControllerImplLegacy(context, this, sessionToken, looper, cacheBitmapLoader);
            mediaController = this;
        } else {
            mediaController = this;
            mediaControllerImplBase = new MediaControllerImplBase(context, mediaController, sessionToken, bundle, looper);
        }
        mediaController.f9956c = mediaControllerImplBase;
        mediaControllerImplBase.connect();
    }

    @Override // androidx.media3.common.Player
    public final void A0(Player.Listener listener) {
        m();
        Assertions.e(listener, "listener must not be null");
        this.f9956c.A0(listener);
    }

    @Override // androidx.media3.common.Player
    public final long A1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.A1();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final int B0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.B0();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem B1() {
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            return null;
        }
        return timelineF0.m(l1(), this.f9954a, 0L).f5488c;
    }

    @Override // androidx.media3.common.Player
    public final void C(float f2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.C(f2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void C0(boolean z) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.C0(z);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean C1() {
        return false;
    }

    @Override // androidx.media3.common.Player
    public final void D(PlaybackParameters playbackParameters) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.D(playbackParameters);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void D0(Player.Listener listener) {
        Assertions.e(listener, "listener must not be null");
        this.f9956c.D0(listener);
    }

    @Override // androidx.media3.common.Player
    public final boolean D1(int i2) {
        return N0().a(i2);
    }

    @Override // androidx.media3.common.Player
    public final void E() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.E();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring play().");
        }
    }

    @Override // androidx.media3.common.Player
    public final int E0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.E0();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final boolean E1() {
        m();
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f9954a, 0L).f5494i;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters F() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.F() : PlaybackParameters.f5424d;
    }

    @Override // androidx.media3.common.Player
    public final Timeline F0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.F0() : Timeline.f5466a;
    }

    @Override // androidx.media3.common.Player
    public final Looper F1() {
        return this.f9958e.getLooper();
    }

    @Override // androidx.media3.common.Player
    public final int G() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.G();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final void G0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.G0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean G1() {
        m();
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f9954a, 0L).f5493h;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters H0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return !mediaControllerImpl.isConnected() ? TrackSelectionParameters.C : mediaControllerImpl.H0();
    }

    @Override // androidx.media3.common.Player
    public final boolean H1() {
        m();
        Timeline timelineF0 = F0();
        return !timelineF0.p() && timelineF0.m(l1(), this.f9954a, 0L).a();
    }

    @Override // androidx.media3.common.Player
    public final void I0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.I0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekToNext().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void J0(TextureView textureView) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.J0(textureView);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setVideoTextureView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final int K0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.K0();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long L0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.L0();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final void M0(int i2, long j2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.M0(i2, j2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands N0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return !mediaControllerImpl.isConnected() ? Player.Commands.f5430b : mediaControllerImpl.N0();
    }

    @Override // androidx.media3.common.Player
    public final boolean O0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.O0();
    }

    @Override // androidx.media3.common.Player
    public final void P0(boolean z) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.P0(z);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long Q0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.Q0();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final void R0(int i2, MediaItem mediaItem) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.R0(i2, mediaItem);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring replaceMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long S0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.S0();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final int T0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.T0();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final void U0(TextureView textureView) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.U0(textureView);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring clearVideoTextureView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final VideoSize V0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.V0() : VideoSize.f5559e;
    }

    @Override // androidx.media3.common.Player
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.W0(audioAttributes, z);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setAudioAttributes().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void X(long j2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.X(j2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes X0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return !mediaControllerImpl.isConnected() ? AudioAttributes.f5143g : mediaControllerImpl.X0();
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo Y0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return !mediaControllerImpl.isConnected() ? DeviceInfo.f5188e : mediaControllerImpl.Y0();
    }

    @Override // androidx.media3.common.Player
    public final void Z0(int i2, int i3) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.Z0(i2, i3);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException a() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.a();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final int a1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.a1();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final boolean b() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.b();
    }

    @Override // androidx.media3.common.Player
    public final void b1(float f2) {
        m();
        Assertions.b(f2 >= 0.0f && f2 <= 1.0f, "volume must be between 0 and 1");
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.b1(f2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void c1(List list, int i2, long j2) {
        m();
        Assertions.e(list, "mediaItems must not be null");
        for (int i3 = 0; i3 < list.size(); i3++) {
            Assertions.b(list.get(i3) != null, "items must not contain null, index=" + i3);
        }
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.c1(list, i2, j2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void d0(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.d0(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void d1(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.d1(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void e0(Surface surface) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.e0(surface);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setVideoSurface().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long e1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.e1();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final boolean f0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.f0();
    }

    @Override // androidx.media3.common.Player
    public final long f1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.f1();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long g0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.g0();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final void g1(int i2, List list) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.g1(i2, list);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getDuration();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getVolume();
        }
        return 1.0f;
    }

    @Override // androidx.media3.common.Player
    public final void h0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.h0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long h1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.h1();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final int i0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.i0();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata i1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.i1() : MediaMetadata.J;
    }

    @Override // androidx.media3.common.Player
    public final void j0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.j0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean j1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.j1();
    }

    public final void k() {
        Assertions.g(Looper.myLooper() == this.f9958e.getLooper());
        Assertions.g(!this.f9960g);
        this.f9960g = true;
        MediaControllerHolder mediaControllerHolder = this.f9961h;
        mediaControllerHolder.f9969j = true;
        MediaController mediaController = mediaControllerHolder.f9968i;
        if (mediaController != null) {
            mediaControllerHolder.n(mediaController);
        }
    }

    @Override // androidx.media3.common.Player
    public final void k0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.k0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void k1(MediaItem mediaItem, long j2) {
        m();
        Assertions.e(mediaItem, "mediaItems must not be null");
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.k1(mediaItem, j2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        }
    }

    public final void l(Runnable runnable) {
        Util.X(this.f9958e, runnable);
    }

    @Override // androidx.media3.common.Player
    public final void l0(int i2, boolean z) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.l0(i2, z);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        }
    }

    @Override // androidx.media3.common.Player
    public final int l1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.l1();
        }
        return -1;
    }

    public final void m() {
        Assertions.f("MediaController method is called from a wrong thread. See javadoc of MediaController for details.", Looper.myLooper() == this.f9958e.getLooper());
    }

    @Override // androidx.media3.common.Player
    public final void m0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.m0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (!mediaControllerImpl.isConnected()) {
            Log.h("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        mediaControllerImpl.m1(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public final void n0(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.n0(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void n1(SurfaceView surfaceView) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.n1(surfaceView);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void o0(SurfaceView surfaceView) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.o0(surfaceView);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setVideoSurfaceView().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void o1(int i2, int i3) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.o1(i2, i3);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void p() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.p();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring prepare().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void p0(int i2, int i3, List list) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.p0(i2, i3, list);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring replaceMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void p1(int i2, int i3, int i4) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.p1(i2, i3, i4);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.pause();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring pause().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void q0(MediaMetadata mediaMetadata) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.q0(mediaMetadata);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void q1(List list) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.q1(list);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void r0(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.r0(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean r1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.r1();
        }
        return false;
    }

    public final void release() {
        String str;
        m();
        if (this.f9955b) {
            return;
        }
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [AndroidXMedia3/1.4.1] [");
        sb.append(Util.f5748e);
        sb.append("] [");
        HashSet hashSet = MediaLibraryInfo.f5377a;
        synchronized (MediaLibraryInfo.class) {
            str = MediaLibraryInfo.f5378b;
        }
        sb.append(str);
        sb.append("]");
        Log.g("MediaController", sb.toString());
        this.f9955b = true;
        Handler handler = this.f9958e;
        handler.removeCallbacksAndMessages(null);
        try {
            this.f9956c.release();
        } catch (Exception e2) {
            Log.c("MediaController", "Exception while releasing impl", e2);
        }
        if (this.f9960g) {
            Assertions.g(Looper.myLooper() == handler.getLooper());
            this.f9957d.D();
        } else {
            this.f9960g = true;
            MediaControllerHolder mediaControllerHolder = this.f9961h;
            mediaControllerHolder.getClass();
            mediaControllerHolder.o(new SecurityException("Session rejected the connection request."));
        }
    }

    @Override // androidx.media3.common.Player
    public final void s0(int i2, int i3) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.s0(i2, i3);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean s1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.s1();
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.stop();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring stop().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void t0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.t0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
        }
    }

    @Override // androidx.media3.common.Player
    public final long t1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.t1();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final int u() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.u();
        }
        return 1;
    }

    @Override // androidx.media3.common.Player
    public final void u0(boolean z) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.u0(z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void u1(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.u1(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void v0(MediaItem mediaItem) {
        m();
        Assertions.e(mediaItem, "mediaItems must not be null");
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.v0(mediaItem);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void v1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.v1();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekForward().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void w0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.w0();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void w1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.w1();
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring seekBack().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void x0(int i2) {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.x0(i2);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata x1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.x1() : MediaMetadata.J;
    }

    @Override // androidx.media3.common.Player
    public final Tracks y0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.y0() : Tracks.f5546b;
    }

    @Override // androidx.media3.common.Player
    public final void y1(List list) {
        m();
        Assertions.e(list, "mediaItems must not be null");
        for (int i2 = 0; i2 < list.size(); i2++) {
            Assertions.b(list.get(i2) != null, "items must not contain null, index=" + i2);
        }
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.y1(list);
        } else {
            Log.h("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final CueGroup z0() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.z0() : CueGroup.f5638c;
    }

    @Override // androidx.media3.common.Player
    public final long z1() {
        m();
        MediaControllerImpl mediaControllerImpl = this.f9956c;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.z1();
        }
        return 0L;
    }

    public interface Listener {
        static ListenableFuture B() {
            return Futures.d(new SessionResult(-6));
        }

        static ListenableFuture z() {
            return Futures.d(new SessionResult(-6));
        }

        default void C() {
        }

        default void D() {
        }

        default void h() {
        }
    }
}
