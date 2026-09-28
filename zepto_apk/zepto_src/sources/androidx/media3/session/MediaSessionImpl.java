package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
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
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.VolumeProviderCompat;
import com.brentvatne.exoplayer.VideoPlaybackService;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
class MediaSessionImpl {
    public static final /* synthetic */ int B = 0;
    public final Bundle A;

    /* renamed from: a, reason: collision with root package name */
    public final Object f10091a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Uri f10092b;

    /* renamed from: c, reason: collision with root package name */
    public final PlayerInfoChangedHandler f10093c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaPlayPauseKeyHandler f10094d;

    /* renamed from: e, reason: collision with root package name */
    public final MediaSession.Callback f10095e;

    /* renamed from: f, reason: collision with root package name */
    public final VideoPlaybackService f10096f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaSessionStub f10097g;

    /* renamed from: h, reason: collision with root package name */
    public final MediaSessionLegacyStub f10098h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10099i;

    /* renamed from: j, reason: collision with root package name */
    public final SessionToken f10100j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSession f10101k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f10102l;

    /* renamed from: m, reason: collision with root package name */
    public final CacheBitmapLoader f10103m;
    public final e1 n;
    public final Handler o;
    public final boolean p;
    public final boolean q;
    public PlayerInfo r;
    public PlayerWrapper s;
    public PlayerListener t;
    public MediaSessionService.MediaSessionListener u;
    public MediaSessionServiceLegacyStub v;
    public boolean w;
    public final long x;
    public boolean y;
    public final ImmutableList z;

    @RequiresApi
    public static final class Api21 {
        @DoNotInline
        public static boolean a(Context context) {
            return context.getPackageManager().hasSystemFeature("android.software.leanback");
        }
    }

    public class MediaPlayPauseKeyHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public v0 f10107a;

        public MediaPlayPauseKeyHandler(Looper looper) {
            super(looper);
        }
    }

    public class PlayerInfoChangedHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10109a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10110b;

        public PlayerInfoChangedHandler(Looper looper) {
            super(looper);
            this.f10109a = true;
            this.f10110b = true;
        }

        public final void a(boolean z, boolean z2) {
            boolean z3 = false;
            this.f10109a = this.f10109a && z;
            if (this.f10110b && z2) {
                z3 = true;
            }
            this.f10110b = z3;
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo;
            int iA;
            if (message.what != 1) {
                throw new IllegalStateException("Invalid message what=" + message.what);
            }
            MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
            PlayerInfo playerInfo = mediaSessionImpl.r;
            Timeline timelineQ = mediaSessionImpl.s.q();
            SessionPositionInfo sessionPositionInfoN = mediaSessionImpl.s.n();
            int i2 = mediaSessionImpl.r.f10178k;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10190j = timelineQ;
            builderE.f10183c = sessionPositionInfoN;
            builderE.f10191k = i2;
            PlayerInfo playerInfoA = builderE.a();
            mediaSessionImpl.r = playerInfoA;
            boolean z = this.f10109a;
            boolean z2 = this.f10110b;
            MediaSessionStub mediaSessionStub = mediaSessionImpl.f10097g;
            PlayerInfo playerInfoJ1 = mediaSessionStub.j1(playerInfoA);
            ConnectedControllersManager connectedControllersManager = mediaSessionStub.f10160d;
            ImmutableList immutableListF = connectedControllersManager.f();
            for (int i3 = 0; i3 < immutableListF.size(); i3++) {
                MediaSession.ControllerInfo controllerInfo2 = (MediaSession.ControllerInfo) immutableListF.get(i3);
                try {
                    SequencedFutureManager sequencedFutureManagerH = connectedControllersManager.h(controllerInfo2);
                    if (sequencedFutureManagerH != null) {
                        iA = sequencedFutureManagerH.a();
                    } else if (!mediaSessionImpl.h(controllerInfo2)) {
                        break;
                    } else {
                        iA = 0;
                    }
                    Player.Commands commandsD = MediaUtils.d(connectedControllersManager.e(controllerInfo2), mediaSessionImpl.s.N0());
                    MediaSession.ControllerCb controllerCb = controllerInfo2.f10086e;
                    Assertions.h(controllerCb);
                    controllerInfo = controllerInfo2;
                    try {
                        controllerCb.d(iA, playerInfoJ1, commandsD, z, z2, controllerInfo2.f10084c);
                    } catch (DeadObjectException unused) {
                        mediaSessionStub.f10160d.m(controllerInfo);
                    } catch (RemoteException e2) {
                        e = e2;
                        Log.i("MediaSessionImpl", "Exception in " + controllerInfo.toString(), e);
                    }
                } catch (DeadObjectException unused2) {
                    controllerInfo = controllerInfo2;
                } catch (RemoteException e3) {
                    e = e3;
                    controllerInfo = controllerInfo2;
                }
            }
            this.f10109a = true;
            this.f10110b = true;
        }
    }

    public static class PlayerListener implements Player.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f10112a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f10113b;

        public PlayerListener(MediaSessionImpl mediaSessionImpl, PlayerWrapper playerWrapper) {
            this.f10112a = new WeakReference(mediaSessionImpl);
            this.f10113b = new WeakReference(playerWrapper);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void A1(AudioAttributes audioAttributes) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.o = audioAttributes;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                if (mediaSessionLegacyStub.f10115g.s.Y0().f5193a == 0) {
                    mediaSessionLegacyStub.f10119k.m(LegacyConversions.w(audioAttributes));
                }
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void B1(Timeline timeline, int i2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            PlayerWrapper playerWrapper = (PlayerWrapper) this.f10113b.get();
            if (playerWrapper == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            SessionPositionInfo sessionPositionInfoN = playerWrapper.n();
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10190j = timeline;
            builderE.f10183c = sessionPositionInfoN;
            builderE.f10191k = i2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(false, true);
            try {
                mediaSessionImplH.f10098h.f10117i.m(timeline);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void C1(MediaMetadata mediaMetadata) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10193m = mediaMetadata;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.j(mediaMetadata);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void D1(long j2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.B = j2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.getClass();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void E1(Tracks tracks) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.D = tracks;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, false);
            mediaSessionImplH.d(new o0(tracks, 6));
        }

        @Override // androidx.media3.common.Player.Listener
        public final void F1(DeviceInfo deviceInfo) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.q = deviceInfo;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.g();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void I1(long j2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.C = j2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void J1(boolean z) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.v = z;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
            mediaSessionImplH.v();
        }

        @Override // androidx.media3.common.Player.Listener
        public final void b(VideoSize videoSize) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10192l = videoSize;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.getClass();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void d1(int i2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10188h = i2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.k(i2);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void e1(CueGroup cueGroup) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo.Builder builder = new PlayerInfo.Builder(mediaSessionImplH.r);
            builder.p = cueGroup;
            mediaSessionImplH.r = builder.a();
            mediaSessionImplH.f10093c.a(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void g1(int i2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            mediaSessionImplH.r = playerInfo.b(playerInfo.u, i2, playerInfo.t);
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        public final MediaSessionImpl h() {
            return (MediaSessionImpl) this.f10112a.get();
        }

        @Override // androidx.media3.common.Player.Listener
        public final void i1(int i2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            PlayerWrapper playerWrapper = (PlayerWrapper) this.f10113b.get();
            if (playerWrapper == null) {
                return;
            }
            mediaSessionImplH.r = mediaSessionImplH.r.d(i2, playerWrapper.a());
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub.ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast = mediaSessionImplH.f10098h.f10117i;
                playerWrapper.a();
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void j1(int i2, MediaItem mediaItem) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10182b = i2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.h(mediaItem);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void k1(boolean z) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10189i = z;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.l(z);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void l1(PlaybackParameters playbackParameters) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            mediaSessionImplH.r = mediaSessionImplH.r.c(playbackParameters);
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void m1(int i2, boolean z) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            mediaSessionImplH.r = mediaSessionImplH.r.a(i2, z);
            mediaSessionImplH.f10093c.a(true, true);
            try {
                VolumeProviderCompat volumeProviderCompat = MediaSessionLegacyStub.this.n;
                if (volumeProviderCompat != null) {
                    if (z) {
                        i2 = 0;
                    }
                    volumeProviderCompat.d(i2);
                }
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void n1(long j2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.A = j2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.getClass();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void o1(MediaMetadata mediaMetadata) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.z = mediaMetadata;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.n();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void p1(TrackSelectionParameters trackSelectionParameters) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.E = trackSelectionParameters;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            mediaSessionImplH.d(new o0(trackSelectionParameters, 5));
        }

        @Override // androidx.media3.common.Player.Listener
        public final void q1() {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            mediaSessionImplH.d(new o0(7));
        }

        @Override // androidx.media3.common.Player.Listener
        public final void r1(PlaybackException playbackException) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10181a = playbackException;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void t1(Player.Commands commands) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            mediaSessionImplH.f(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10184d = positionInfo;
            builderE.f10185e = positionInfo2;
            builderE.f10186f = i2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void w1(boolean z) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.w = z;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.getClass();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
            mediaSessionImplH.v();
        }

        @Override // androidx.media3.common.Player.Listener
        public final void y1(int i2, boolean z) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i3 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            if (((PlayerWrapper) this.f10113b.get()) == null) {
                return;
            }
            PlayerInfo playerInfo = mediaSessionImplH.r;
            mediaSessionImplH.r = playerInfo.b(i2, playerInfo.x, z);
            mediaSessionImplH.f10093c.a(true, true);
            try {
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public final void z1(float f2) {
            MediaSessionImpl mediaSessionImplH = h();
            if (mediaSessionImplH == null) {
                return;
            }
            int i2 = MediaSessionImpl.B;
            mediaSessionImplH.w();
            PlayerInfo playerInfo = mediaSessionImplH.r;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.n = f2;
            mediaSessionImplH.r = builderE.a();
            mediaSessionImplH.f10093c.a(true, true);
            try {
                mediaSessionImplH.f10098h.f10117i.getClass();
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }
    }

    public interface RemoteControllerTask {
        void d(MediaSession.ControllerCb controllerCb, int i2);
    }

    static {
        new SessionResult(1);
    }

    public MediaSessionImpl(MediaSession mediaSession, VideoPlaybackService videoPlaybackService, String str, ExoPlayer exoPlayer, ImmutableList immutableList, MediaSession.Callback callback, Bundle bundle, Bundle bundle2, CacheBitmapLoader cacheBitmapLoader, boolean z, boolean z2) {
        Log.g("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.1] [" + Util.f5748e + "]");
        this.f10101k = mediaSession;
        this.f10096f = videoPlaybackService;
        this.f10099i = str;
        this.z = immutableList;
        this.f10095e = callback;
        this.A = bundle2;
        this.f10103m = cacheBitmapLoader;
        this.p = z;
        this.q = z2;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.f10097g = mediaSessionStub;
        this.o = new Handler(Looper.getMainLooper());
        Looper looperF1 = exoPlayer.F1();
        Handler handler = new Handler(looperF1);
        this.f10102l = handler;
        this.r = PlayerInfo.F;
        this.f10093c = new PlayerInfoChangedHandler(looperF1);
        this.f10094d = new MediaPlayPauseKeyHandler(looperF1);
        Uri uriBuild = new Uri.Builder().scheme(MediaSessionImpl.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.f10092b = uriBuild;
        this.f10100j = new SessionToken(Process.myUid(), 1004001300, 4, videoPlaybackService.getPackageName(), mediaSessionStub, bundle);
        this.f10098h = new MediaSessionLegacyStub(this, uriBuild, handler);
        MediaSession.ConnectionResult connectionResultA = new MediaSession.ConnectionResult.AcceptedResultBuilder(mediaSession).a();
        PlayerWrapper playerWrapper = new PlayerWrapper(exoPlayer, z, immutableList, connectionResultA.f10075b, connectionResultA.f10076c, bundle2);
        this.s = playerWrapper;
        Util.X(handler, new l0(7, this, playerWrapper));
        this.x = 3000L;
        this.n = new e1(this, 2);
        Util.X(handler, new e1(this, 3));
    }

    public static boolean k(MediaSession.ControllerInfo controllerInfo) {
        return controllerInfo != null && controllerInfo.f10083b == 0 && Objects.equals(controllerInfo.f10082a.a(), "com.android.systemui");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.view.KeyEvent r4, boolean r5) {
        /*
            r3 = this;
            androidx.media3.session.MediaSession r0 = r3.f10101k
            androidx.media3.session.MediaSessionImpl r0 = r0.f10060a
            androidx.media3.session.MediaSession$ControllerInfo r0 = r0.e()
            r0.getClass()
            int r4 = r4.getKeyCode()
            r1 = 85
            if (r4 == r1) goto L17
            r1 = 79
            if (r4 != r1) goto L1b
        L17:
            if (r5 == 0) goto L1b
            r4 = 87
        L1b:
            r5 = 126(0x7e, float:1.77E-43)
            if (r4 == r5) goto L72
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 == r5) goto L6b
            r5 = 272(0x110, float:3.81E-43)
            if (r4 == r5) goto L64
            r5 = 273(0x111, float:3.83E-43)
            if (r4 == r5) goto L5d
            switch(r4) {
                case 85: goto L47;
                case 86: goto L3f;
                case 87: goto L64;
                case 88: goto L5d;
                case 89: goto L37;
                case 90: goto L30;
                default: goto L2e;
            }
        L2e:
            r4 = 0
            return r4
        L30:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 7
            r4.<init>(r3, r0, r5)
            goto L78
        L37:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 8
            r4.<init>(r3, r0, r5)
            goto L78
        L3f:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 9
            r4.<init>(r3, r0, r5)
            goto L78
        L47:
            androidx.media3.session.PlayerWrapper r4 = r3.s
            boolean r4 = r4.O0()
            if (r4 == 0) goto L56
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 1
            r4.<init>(r3, r0, r5)
            goto L78
        L56:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 2
            r4.<init>(r3, r0, r5)
            goto L78
        L5d:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 6
            r4.<init>(r3, r0, r5)
            goto L78
        L64:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 5
            r4.<init>(r3, r0, r5)
            goto L78
        L6b:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 4
            r4.<init>(r3, r0, r5)
            goto L78
        L72:
            androidx.media3.session.a r4 = new androidx.media3.session.a
            r5 = 3
            r4.<init>(r3, r0, r5)
        L78:
            android.os.Handler r5 = r3.f10102l
            androidx.media3.session.v0 r1 = new androidx.media3.session.v0
            r2 = 5
            r1.<init>(r3, r4, r0, r2)
            androidx.media3.common.util.Util.X(r5, r1)
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionImpl.a(android.view.KeyEvent, boolean):boolean");
    }

    public MediaSessionServiceLegacyStub b(MediaSessionCompat.Token token) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub = new MediaSessionServiceLegacyStub(this);
        mediaSessionServiceLegacyStub.q(token);
        return mediaSessionServiceLegacyStub;
    }

    public final void c(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int iA;
        MediaSessionStub mediaSessionStub = this.f10097g;
        try {
            SequencedFutureManager sequencedFutureManagerH = mediaSessionStub.f10160d.h(controllerInfo);
            if (sequencedFutureManagerH != null) {
                iA = sequencedFutureManagerH.a();
            } else if (!h(controllerInfo)) {
                return;
            } else {
                iA = 0;
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.f10086e;
            if (controllerCb != null) {
                remoteControllerTask.d(controllerCb, iA);
            }
        } catch (DeadObjectException unused) {
            mediaSessionStub.f10160d.m(controllerInfo);
        } catch (RemoteException e2) {
            Log.i("MediaSessionImpl", "Exception in " + controllerInfo.toString(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(RemoteControllerTask remoteControllerTask) {
        ImmutableList immutableListF = this.f10097g.f10160d.f();
        for (int i2 = 0; i2 < immutableListF.size(); i2++) {
            c((MediaSession.ControllerInfo) immutableListF.get(i2), remoteControllerTask);
        }
        try {
            remoteControllerTask.d(this.f10098h.f10117i, 0);
        } catch (RemoteException e2) {
            Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MediaSession.ControllerInfo e() {
        ImmutableList immutableListF = this.f10097g.f10160d.f();
        for (int i2 = 0; i2 < immutableListF.size(); i2++) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) immutableListF.get(i2);
            if (i(controllerInfo)) {
                return controllerInfo;
            }
        }
        return null;
    }

    public final void f(Player.Commands commands) {
        this.f10093c.a(false, false);
        d(new q0(commands));
        try {
            MediaSessionLegacyStub.ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast = this.f10098h.f10117i;
            DeviceInfo deviceInfo = this.r.q;
            controllerLegacyCbForBroadcast.g();
        } catch (RemoteException e2) {
            Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
        }
    }

    public final void g(MediaSession.ControllerInfo controllerInfo, boolean z) {
        if (q()) {
            boolean z2 = this.s.D1(16) && this.s.B1() != null;
            boolean z3 = this.s.D1(31) || this.s.D1(20);
            MediaSession.ControllerInfo controllerInfoU = u(controllerInfo);
            Player.Commands.Builder builder = new Player.Commands.Builder();
            builder.f5434a.a(1);
            Player.Commands commandsD = builder.d();
            if (!z2 && z3) {
                this.f10095e.getClass();
                Futures.a(Futures.c(new UnsupportedOperationException()), new FutureCallback<MediaSession.MediaItemsWithStartPosition>(controllerInfoU, z, commandsD) { // from class: androidx.media3.session.MediaSessionImpl.1

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ MediaSession.ControllerInfo f10104a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ boolean f10105b;

                    @Override // com.google.common.util.concurrent.FutureCallback
                    public final void onFailure(Throwable th) {
                        if (th instanceof UnsupportedOperationException) {
                            Log.i("MediaSessionImpl", "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
                        } else {
                            Log.e("MediaSessionImpl", "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
                        }
                        MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
                        Util.J(mediaSessionImpl.s);
                        if (this.f10105b) {
                            mediaSessionImpl.r(this.f10104a);
                        }
                    }

                    @Override // com.google.common.util.concurrent.FutureCallback
                    public final void onSuccess(Object obj) {
                        MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
                        mediaSessionImpl.getClass();
                        int i2 = MediaSessionImpl.B;
                        MediaUtils.f(mediaSessionImpl.s, (MediaSession.MediaItemsWithStartPosition) obj);
                        Util.J(mediaSessionImpl.s);
                        if (this.f10105b) {
                            mediaSessionImpl.r(this.f10104a);
                        }
                    }
                }, new h(this, 2));
                return;
            }
            if (!z2) {
                Log.h("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
            }
            Util.J(this.s);
            if (z) {
                r(controllerInfoU);
            }
        }
    }

    public boolean h(MediaSession.ControllerInfo controllerInfo) {
        return this.f10097g.f10160d.i(controllerInfo) || this.f10098h.f10114f.i(controllerInfo);
    }

    public final boolean i(MediaSession.ControllerInfo controllerInfo) {
        return Objects.equals(controllerInfo.f10082a.a(), this.f10096f.getPackageName()) && controllerInfo.f10083b != 0 && new Bundle(controllerInfo.f10087f).getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public final boolean j() {
        boolean z;
        synchronized (this.f10091a) {
            z = this.w;
        }
        return z;
    }

    public final ListenableFuture l(MediaSession.ControllerInfo controllerInfo, List list) {
        u(controllerInfo);
        this.f10095e.getClass();
        return MediaSession.Callback.c(list);
    }

    public final MediaSession.ConnectionResult m(MediaSession.ControllerInfo controllerInfo) {
        boolean z = this.y;
        MediaSession mediaSession = this.f10101k;
        if (z && k(controllerInfo)) {
            MediaSession.ConnectionResult.AcceptedResultBuilder acceptedResultBuilder = new MediaSession.ConnectionResult.AcceptedResultBuilder(mediaSession);
            SessionCommands sessionCommands = this.s.f10203e;
            sessionCommands.getClass();
            acceptedResultBuilder.f10079a = sessionCommands;
            Player.Commands commands = this.s.f10204f;
            commands.getClass();
            acceptedResultBuilder.f10080b = commands;
            ImmutableList immutableList = this.s.f10202d;
            acceptedResultBuilder.f10081c = immutableList == null ? null : ImmutableList.o(immutableList);
            return acceptedResultBuilder.a();
        }
        MediaSession.ConnectionResult connectionResultB = this.f10095e.b(mediaSession, controllerInfo);
        if (i(controllerInfo) && connectionResultB.f10074a) {
            this.y = true;
            PlayerWrapper playerWrapper = this.s;
            ImmutableList immutableList2 = connectionResultB.f10077d;
            if (immutableList2 == null) {
                immutableList2 = mediaSession.f10060a.z;
            }
            playerWrapper.f10202d = immutableList2;
            boolean zA = playerWrapper.f10204f.a(17);
            Player.Commands commands2 = connectionResultB.f10076c;
            boolean z2 = zA != commands2.a(17);
            PlayerWrapper playerWrapper2 = this.s;
            playerWrapper2.f10203e = connectionResultB.f10075b;
            playerWrapper2.f10204f = commands2;
            MediaSessionLegacyStub mediaSessionLegacyStub = this.f10098h;
            if (z2) {
                Util.X(mediaSessionLegacyStub.f10115g.f10102l, new k1(mediaSessionLegacyStub, playerWrapper2, 1));
                return connectionResultB;
            }
            mediaSessionLegacyStub.I(playerWrapper2);
        }
        return connectionResultB;
    }

    public final ListenableFuture n(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return this.f10095e.a(this.f10101k, u(controllerInfo), sessionCommand, bundle);
    }

    public void o(MediaSession.ControllerInfo controllerInfo) {
        if (this.y) {
            if (k(controllerInfo)) {
                return;
            }
            if (i(controllerInfo)) {
                this.y = false;
            }
        }
        this.f10095e.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(androidx.media3.session.MediaSession.ControllerInfo r10, android.content.Intent r11) {
        /*
            r9 = this;
            android.os.Bundle r0 = r11.getExtras()
            r1 = 0
            if (r0 == 0) goto L16
            java.lang.String r2 = "android.intent.extra.KEY_EVENT"
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L16
            android.os.Parcelable r0 = r0.getParcelable(r2)
            android.view.KeyEvent r0 = (android.view.KeyEvent) r0
            goto L17
        L16:
            r0 = r1
        L17:
            android.content.ComponentName r2 = r11.getComponent()
            java.lang.String r11 = r11.getAction()
            java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
            boolean r11 = java.util.Objects.equals(r11, r3)
            r3 = 0
            if (r11 == 0) goto Ld8
            com.brentvatne.exoplayer.VideoPlaybackService r11 = r9.f10096f
            if (r2 == 0) goto L3a
            java.lang.String r2 = r2.getPackageName()
            java.lang.String r4 = r11.getPackageName()
            boolean r2 = java.util.Objects.equals(r2, r4)
            if (r2 == 0) goto Ld8
        L3a:
            if (r0 == 0) goto Ld8
            int r2 = r0.getAction()
            if (r2 == 0) goto L44
            goto Ld8
        L44:
            r9.w()
            androidx.media3.session.MediaSession$Callback r2 = r9.f10095e
            r2.getClass()
            int r2 = r0.getKeyCode()
            int r4 = androidx.media3.common.util.Util.f5744a
            r5 = 21
            r6 = 1
            if (r4 < r5) goto L5f
            boolean r11 = androidx.media3.session.MediaSessionImpl.Api21.a(r11)
            if (r11 == 0) goto L5f
            r11 = r6
            goto L60
        L5f:
            r11 = r3
        L60:
            int r4 = r10.f10083b
            r5 = 85
            r7 = 79
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r8 = r9.f10094d
            if (r2 == r7) goto L7e
            if (r2 == r5) goto L7e
            androidx.media3.session.v0 r10 = r8.f10107a
            if (r10 == 0) goto L78
            r8.removeCallbacks(r10)
            androidx.media3.session.v0 r10 = r8.f10107a
            r8.f10107a = r1
            r1 = r10
        L78:
            if (r1 == 0) goto Lb8
            androidx.media3.common.util.Util.X(r8, r1)
            goto Lb8
        L7e:
            if (r11 != 0) goto La7
            if (r4 != 0) goto La7
            int r11 = r0.getRepeatCount()
            if (r11 == 0) goto L89
            goto La7
        L89:
            androidx.media3.session.v0 r11 = r8.f10107a
            if (r11 == 0) goto L96
            if (r11 == 0) goto L94
            r8.removeCallbacks(r11)
            r8.f10107a = r1
        L94:
            r10 = r6
            goto Lb9
        L96:
            androidx.media3.session.v0 r11 = new androidx.media3.session.v0
            r1 = 6
            r11.<init>(r8, r10, r0, r1)
            r8.f10107a = r11
            int r10 = android.view.ViewConfiguration.getDoubleTapTimeout()
            long r0 = (long) r10
            r8.postDelayed(r11, r0)
            return r6
        La7:
            androidx.media3.session.v0 r10 = r8.f10107a
            if (r10 == 0) goto Lb3
            r8.removeCallbacks(r10)
            androidx.media3.session.v0 r10 = r8.f10107a
            r8.f10107a = r1
            r1 = r10
        Lb3:
            if (r1 == 0) goto Lb8
            androidx.media3.common.util.Util.X(r8, r1)
        Lb8:
            r10 = r3
        Lb9:
            boolean r11 = r9.y
            if (r11 != 0) goto Ld3
            androidx.media3.session.MediaSessionLegacyStub r11 = r9.f10098h
            if (r2 == r5) goto Lc3
            if (r2 != r7) goto Lc9
        Lc3:
            if (r10 == 0) goto Lc9
            r11.y()
            return r6
        Lc9:
            if (r4 == 0) goto Ld8
            androidx.media3.session.legacy.MediaSessionCompat r10 = r11.f10119k
            androidx.media3.session.legacy.MediaControllerCompat r10 = r10.f10611b
            r10.c(r0)
            return r6
        Ld3:
            boolean r10 = r9.a(r0, r10)
            return r10
        Ld8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionImpl.p(androidx.media3.session.MediaSession$ControllerInfo, android.content.Intent):boolean");
    }

    public final boolean q() {
        int i2;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            SettableFuture settableFuture = new SettableFuture();
            this.o.post(new l0(6, this, settableFuture));
            try {
                return ((Boolean) settableFuture.get()).booleanValue();
            } catch (InterruptedException | ExecutionException e2) {
                throw new IllegalStateException(e2);
            }
        }
        MediaSessionService.MediaSessionListener mediaSessionListener = this.u;
        if (mediaSessionListener != null && (i2 = Util.f5744a) >= 31 && i2 < 33) {
            int i3 = MediaSessionService.f10141h;
            MediaSessionService mediaSessionService = MediaSessionService.this;
            if (!mediaSessionService.c().f10054j) {
                return mediaSessionService.g(this.f10101k, true);
            }
        }
        return true;
    }

    public final void r(MediaSession.ControllerInfo controllerInfo) {
        u(controllerInfo);
        this.f10095e.getClass();
    }

    public final ListenableFuture s(MediaSession.ControllerInfo controllerInfo, List list, final int i2, final long j2) {
        u(controllerInfo);
        this.f10095e.getClass();
        return Util.i0(MediaSession.Callback.c(list), new AsyncFunction() { // from class: androidx.media3.session.d1
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return Futures.d(new MediaSession.MediaItemsWithStartPosition((List) obj, i2, j2));
            }
        });
    }

    public final void t() throws NoSuchFieldException, SecurityException {
        String str;
        int i2 = 0;
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
        Log.g("MediaSessionImpl", sb.toString());
        synchronized (this.f10091a) {
            try {
                if (this.w) {
                    return;
                }
                this.w = true;
                MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler = this.f10094d;
                v0 v0Var = mediaPlayPauseKeyHandler.f10107a;
                if (v0Var != null) {
                    mediaPlayPauseKeyHandler.removeCallbacks(v0Var);
                    mediaPlayPauseKeyHandler.f10107a = null;
                }
                this.f10102l.removeCallbacksAndMessages(null);
                try {
                    Util.X(this.f10102l, new e1(this, i2));
                } catch (Exception e2) {
                    Log.i("MediaSessionImpl", "Exception thrown while closing", e2);
                }
                MediaSessionLegacyStub mediaSessionLegacyStub = this.f10098h;
                mediaSessionLegacyStub.getClass();
                int i3 = Util.f5744a;
                MediaSessionImpl mediaSessionImpl = mediaSessionLegacyStub.f10115g;
                MediaSessionCompat mediaSessionCompat = mediaSessionLegacyStub.f10119k;
                if (i3 < 31) {
                    ComponentName componentName = mediaSessionLegacyStub.f10121m;
                    if (componentName == null) {
                        mediaSessionCompat.j(null);
                    } else {
                        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", mediaSessionImpl.f10092b);
                        intent.setComponent(componentName);
                        mediaSessionCompat.j(PendingIntent.getBroadcast(mediaSessionImpl.f10096f, 0, intent, MediaSessionLegacyStub.r));
                    }
                }
                MediaSessionLegacyStub.MediaButtonReceiver mediaButtonReceiver = mediaSessionLegacyStub.f10120l;
                if (mediaButtonReceiver != null) {
                    mediaSessionImpl.f10096f.unregisterReceiver(mediaButtonReceiver);
                }
                mediaSessionCompat.f();
                MediaSessionStub mediaSessionStub = this.f10097g;
                Iterator<E> it = mediaSessionStub.f10160d.f().iterator();
                while (it.hasNext()) {
                    MediaSession.ControllerCb controllerCb = ((MediaSession.ControllerInfo) it.next()).f10086e;
                    if (controllerCb != null) {
                        try {
                            controllerCb.D();
                        } catch (RemoteException unused) {
                        }
                    }
                }
                Iterator it2 = mediaSessionStub.f10161e.iterator();
                while (it2.hasNext()) {
                    MediaSession.ControllerCb controllerCb2 = ((MediaSession.ControllerInfo) it2.next()).f10086e;
                    if (controllerCb2 != null) {
                        try {
                            controllerCb2.D();
                        } catch (RemoteException unused2) {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final MediaSession.ControllerInfo u(MediaSession.ControllerInfo controllerInfo) {
        if (!this.y || !k(controllerInfo)) {
            return controllerInfo;
        }
        MediaSession.ControllerInfo controllerInfoE = e();
        controllerInfoE.getClass();
        return controllerInfoE;
    }

    public final void v() {
        Handler handler = this.f10102l;
        e1 e1Var = this.n;
        handler.removeCallbacks(e1Var);
        if (this.q) {
            long j2 = this.x;
            if (j2 > 0) {
                if (this.s.j1() || this.s.b()) {
                    handler.postDelayed(e1Var, j2);
                }
            }
        }
    }

    public final void w() {
        if (Looper.myLooper() != this.f10102l.getLooper()) {
            throw new IllegalStateException("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
        }
    }
}
