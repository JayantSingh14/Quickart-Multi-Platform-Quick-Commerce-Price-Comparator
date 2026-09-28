package androidx.media3.session;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
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
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaController;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaControllerCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9990a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaController f9991b;

    /* renamed from: c, reason: collision with root package name */
    public final SessionToken f9992c;

    /* renamed from: d, reason: collision with root package name */
    public final ListenerSet f9993d;

    /* renamed from: e, reason: collision with root package name */
    public final ControllerCompatCallback f9994e;

    /* renamed from: f, reason: collision with root package name */
    public final CacheBitmapLoader f9995f;

    /* renamed from: g, reason: collision with root package name */
    public MediaControllerCompat f9996g;

    /* renamed from: h, reason: collision with root package name */
    public MediaBrowserCompat f9997h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9998i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9999j;

    /* renamed from: k, reason: collision with root package name */
    public LegacyPlayerInfo f10000k = new LegacyPlayerInfo();

    /* renamed from: l, reason: collision with root package name */
    public LegacyPlayerInfo f10001l = new LegacyPlayerInfo();

    /* renamed from: m, reason: collision with root package name */
    public ControllerInfo f10002m = new ControllerInfo();
    public long n = -9223372036854775807L;
    public long o = -9223372036854775807L;

    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public ConnectionCallback() {
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void a() {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            MediaBrowserCompat mediaBrowserCompat = mediaControllerImplLegacy.f9997h;
            if (mediaBrowserCompat != null) {
                mediaControllerImplLegacy.j().l(new l0(0, mediaControllerImplLegacy, mediaBrowserCompat.c()));
                mediaControllerImplLegacy.j().f9958e.post(new m0(mediaControllerImplLegacy, 1));
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void b() {
            MediaControllerImplLegacy.this.j().release();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void c() {
            MediaControllerImplLegacy.this.j().release();
        }
    }

    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {

        /* renamed from: d, reason: collision with root package name */
        public final Handler f10005d;

        public ControllerCompatCallback(Looper looper) {
            this.f10005d = new Handler(looper, new f0(this, 1));
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void a(MediaControllerCompat.PlaybackInfo playbackInfo) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            int i2 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(playbackInfo, legacyPlayerInfo.f10014b, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, legacyPlayerInfo.f10017e, legacyPlayerInfo.f10018f, i2, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void b(boolean z) {
            MediaController mediaControllerJ = MediaControllerImplLegacy.this.j();
            mediaControllerJ.getClass();
            Assertions.g(Looper.myLooper() == mediaControllerJ.f9958e.getLooper());
            new Bundle().putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z);
            new SessionCommand("androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED", Bundle.EMPTY);
            mediaControllerJ.f9957d.getClass();
            MediaController.Listener.B();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void c(Bundle bundle) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            ControllerInfo controllerInfo = mediaControllerImplLegacy.f10002m;
            mediaControllerImplLegacy.f10002m = new ControllerInfo(controllerInfo.f10007a, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, bundle, null);
            MediaController mediaControllerJ = mediaControllerImplLegacy.j();
            mediaControllerJ.getClass();
            Assertions.g(Looper.myLooper() == mediaControllerJ.f9958e.getLooper());
            mediaControllerJ.f9957d.getClass();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void d(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            int i2 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, legacyPlayerInfo.f10014b, mediaMetadataCompat, legacyPlayerInfo.f10016d, legacyPlayerInfo.f10017e, legacyPlayerInfo.f10018f, i2, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void e(PlaybackStateCompat playbackStateCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            PlaybackStateCompat playbackStateCompatH = MediaControllerImplLegacy.h(playbackStateCompat);
            int i2 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, playbackStateCompatH, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, legacyPlayerInfo.f10017e, legacyPlayerInfo.f10018f, i2, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void f(List list) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            List listG = MediaControllerImplLegacy.g(list);
            int i2 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, legacyPlayerInfo.f10014b, legacyPlayerInfo.f10015c, listG, legacyPlayerInfo.f10017e, legacyPlayerInfo.f10018f, i2, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void g(CharSequence charSequence) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            int i2 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, legacyPlayerInfo.f10014b, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, charSequence, legacyPlayerInfo.f10018f, i2, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void h(int i2) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            int i3 = legacyPlayerInfo.f10019g;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, legacyPlayerInfo.f10014b, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, legacyPlayerInfo.f10017e, i2, i3, legacyPlayerInfo.f10020h);
            o();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void i() {
            MediaControllerImplLegacy.this.j().release();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void j(String str, Bundle bundle) {
            if (str == null) {
                return;
            }
            MediaController mediaControllerJ = MediaControllerImplLegacy.this.j();
            mediaControllerJ.getClass();
            Assertions.g(Looper.myLooper() == mediaControllerJ.f9958e.getLooper());
            new SessionCommand(str, Bundle.EMPTY);
            mediaControllerJ.f9957d.getClass();
            MediaController.Listener.B();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void k() throws LegacyConversions.ConversionException {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            if (!mediaControllerImplLegacy.f9999j) {
                mediaControllerImplLegacy.n();
                return;
            }
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            PlaybackStateCompat playbackStateCompatH = MediaControllerImplLegacy.h(mediaControllerImplLegacy.f9996g.j());
            int iN = mediaControllerImplLegacy.f9996g.n();
            int iO = mediaControllerImplLegacy.f9996g.o();
            CharSequence charSequence = legacyPlayerInfo.f10017e;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, playbackStateCompatH, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, charSequence, iN, iO, legacyPlayerInfo.f10020h);
            b(mediaControllerImplLegacy.f9996g.q());
            this.f10005d.removeMessages(1);
            mediaControllerImplLegacy.k(false, mediaControllerImplLegacy.f10001l);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public final void l(int i2) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.f10001l;
            int i3 = legacyPlayerInfo.f10018f;
            mediaControllerImplLegacy.f10001l = new LegacyPlayerInfo(legacyPlayerInfo.f10013a, legacyPlayerInfo.f10014b, legacyPlayerInfo.f10015c, legacyPlayerInfo.f10016d, legacyPlayerInfo.f10017e, i3, i2, legacyPlayerInfo.f10020h);
            o();
        }

        public final void o() {
            Handler handler = this.f10005d;
            if (handler.hasMessages(1)) {
                return;
            }
            handler.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public MediaControllerImplLegacy(Context context, MediaController mediaController, SessionToken sessionToken, Looper looper, CacheBitmapLoader cacheBitmapLoader) {
        this.f9993d = new ListenerSet(looper, Clock.f5662a, new k0(this));
        this.f9990a = context;
        this.f9991b = mediaController;
        this.f9994e = new ControllerCompatCallback(looper);
        this.f9992c = sessionToken;
        this.f9995f = cacheBitmapLoader;
    }

    public static List g(List list) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        MediaBrowserServiceCompat.BrowserRoot browserRoot = MediaUtils.f10167a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static PlaybackStateCompat h(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return null;
        }
        if (playbackStateCompat.f10661d > 0.0f) {
            return playbackStateCompat;
        }
        Log.h("MCImplLegacy", "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder(playbackStateCompat);
        builder.f10671b = playbackStateCompat.f10658a;
        builder.f10672c = playbackStateCompat.f10659b;
        builder.f10678i = playbackStateCompat.f10665h;
        builder.f10674e = 1.0f;
        return builder.a();
    }

    public static Player.PositionInfo i(int i2, MediaItem mediaItem, long j2, boolean z) {
        return new Player.PositionInfo(null, i2, mediaItem, null, i2, j2, j2, z ? 0 : -1, z ? 0 : -1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void A0(Player.Listener listener) {
        this.f9993d.e(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long A1() {
        return this.f10002m.f10007a.A;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int B0() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void C(float f2) {
        if (f2 != F().f5427a) {
            PlayerInfo playerInfoC = this.f10002m.f10007a.c(new PlaybackParameters(f2));
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoC, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.p().n(f2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void C0(boolean z) {
        l0(1, z);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void D(PlaybackParameters playbackParameters) {
        if (!playbackParameters.equals(F())) {
            PlayerInfo playerInfoC = this.f10002m.f10007a.c(playbackParameters);
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoC, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.p().n(playbackParameters.f5427a);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void D0(Player.Listener listener) {
        this.f9993d.a(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void E() {
        u0(true);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int E0() {
        return 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackParameters F() {
        return this.f10002m.f10007a.f10174g;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Timeline F0() {
        return this.f10002m.f10007a.f10177j;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int G() {
        return this.f10002m.f10007a.f10175h;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void G0() {
        n0(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final TrackSelectionParameters H0() {
        return TrackSelectionParameters.C;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void I0() {
        this.f9996g.p().q();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void J0(TextureView textureView) {
        Log.h("MCImplLegacy", "Session doesn't support setting TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int K0() {
        PlayerInfo playerInfo = this.f10002m.f10007a;
        if (playerInfo.q.f5193a == 1) {
            return playerInfo.r;
        }
        MediaControllerCompat mediaControllerCompat = this.f9996g;
        if (mediaControllerCompat == null) {
            return 0;
        }
        MediaControllerCompat.PlaybackInfo playbackInfoI = mediaControllerCompat.i();
        ImmutableSet immutableSet = LegacyConversions.f9940a;
        if (playbackInfoI == null) {
            return 0;
        }
        return playbackInfoI.f10585e;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long L0() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void M0(int i2, long j2) {
        o(i2, j2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Player.Commands N0() {
        return this.f10002m.f10009c;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean O0() {
        return this.f10002m.f10007a.t;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void P0(boolean z) {
        if (z != s1()) {
            PlayerInfo playerInfo = this.f10002m.f10007a;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10189i = z;
            PlayerInfo playerInfoA = builderE.a();
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        MediaControllerCompat.TransportControls transportControlsP = this.f9996g.p();
        ImmutableSet immutableSet = LegacyConversions.f9940a;
        transportControlsP.p(z ? 1 : 0);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long Q0() {
        return this.f10002m.f10007a.C;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void R0(int i2, MediaItem mediaItem) {
        p0(i2, i2 + 1, ImmutableList.t(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long S0() {
        return getDuration();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int T0() {
        return l1();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void U0(TextureView textureView) {
        Log.h("MCImplLegacy", "Session doesn't support clearing TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final VideoSize V0() {
        Log.h("MCImplLegacy", "Session doesn't support getting VideoSize");
        return VideoSize.f5559e;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        Log.h("MCImplLegacy", "Legacy session doesn't support setting audio attributes remotely");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void X(long j2) {
        o(l1(), j2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final AudioAttributes X0() {
        return this.f10002m.f10007a.o;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final DeviceInfo Y0() {
        return this.f10002m.f10007a.q;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void Z0(int i2, int i3) {
        int i4;
        DeviceInfo deviceInfoY0 = Y0();
        if (deviceInfoY0.f5194b <= i2 && ((i4 = deviceInfoY0.f5195c) == 0 || i2 <= i4)) {
            PlayerInfo playerInfoA = this.f10002m.f10007a.a(i2, r1());
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.v(i2, i3);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackException a() {
        return this.f10002m.f10007a.f10168a;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int a1() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean b() {
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void b1(float f2) {
        Log.h("MCImplLegacy", "Session doesn't support setting player volume");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands c() {
        return this.f10002m.f10008b;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void c1(List list, int i2, long j2) {
        if (list.isEmpty()) {
            h0();
            return;
        }
        QueueTimeline queueTimelineQ = QueueTimeline.f10213g.q(0, list);
        long j3 = j2 == -9223372036854775807L ? 0L : j2;
        PlayerInfo playerInfo = this.f10002m.f10007a;
        SessionPositionInfo sessionPositionInfo = new SessionPositionInfo(i(i2, (MediaItem) list.get(i2), j3, false), false, SystemClock.elapsedRealtime(), -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
        builderE.f10190j = queueTimelineQ;
        builderE.f10183c = sessionPositionInfo;
        builderE.f10191k = 0;
        PlayerInfo playerInfoA = builderE.a();
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (m()) {
            l();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void connect() {
        SessionToken sessionToken = this.f9992c;
        if (sessionToken.f10269a.getType() != 0) {
            j().l(new m0(this, 0));
            return;
        }
        Object objB = sessionToken.f10269a.b();
        Assertions.h(objB);
        j().l(new l0(0, this, (MediaSessionCompat.Token) objB));
        j().f9958e.post(new m0(this, 1));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ListenableFuture d(SessionCommand sessionCommand) {
        Bundle bundle = Bundle.EMPTY;
        SessionCommands sessionCommands = this.f10002m.f10008b;
        sessionCommands.getClass();
        boolean zContains = sessionCommands.f10238a.contains(sessionCommand);
        String str = sessionCommand.f10234b;
        if (zContains) {
            this.f9996g.p().m(bundle, str);
            return Futures.d(new SessionResult(0));
        }
        final SettableFuture settableFuture = new SettableFuture();
        this.f9996g.u(str, new ResultReceiver(j().f9958e) { // from class: androidx.media3.session.MediaControllerImplLegacy.1
            @Override // android.os.ResultReceiver
            public final void onReceiveResult(int i2, Bundle bundle2) {
                if (bundle2 == null) {
                    bundle2 = Bundle.EMPTY;
                }
                settableFuture.n(new SessionResult(i2, bundle2));
            }
        });
        return settableFuture;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void d0(int i2) {
        if (i2 != G()) {
            PlayerInfo playerInfo = this.f10002m.f10007a;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10188h = i2;
            PlayerInfo playerInfoA = builderE.a();
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.p().o(LegacyConversions.p(i2));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void d1(int i2) {
        o(i2, 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ImmutableList e() {
        return this.f10002m.f10010d;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void e0(Surface surface) {
        Log.h("MCImplLegacy", "Session doesn't support setting Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long e1() {
        return this.f10002m.f10007a.B;
    }

    public final void f(int i2, List list) {
        ArrayList arrayList = new ArrayList();
        n0 n0Var = new n0(this, new AtomicInteger(0), list, arrayList, i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            byte[] bArr = ((MediaItem) list.get(i3)).f5260d.f5389k;
            if (bArr == null) {
                arrayList.add(null);
                n0Var.run();
            } else {
                ListenableFuture listenableFutureC = this.f9995f.c(bArr);
                arrayList.add(listenableFutureC);
                Handler handler = j().f9958e;
                Objects.requireNonNull(handler);
                listenableFutureC.q(n0Var, new androidx.media3.exoplayer.audio.m(handler));
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean f0() {
        return this.f10002m.f10007a.f10170c.f10250b;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long f1() {
        return z1();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long g0() {
        return this.f10002m.f10007a.f10170c.f10255g;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void g1(int i2, List list) {
        Assertions.a(i2 >= 0);
        if (list.isEmpty()) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) this.f10002m.f10007a.f10177j;
        if (queueTimeline.p()) {
            c1(list, 0, -9223372036854775807L);
            return;
        }
        int iMin = Math.min(i2, F0().o());
        QueueTimeline queueTimelineQ = queueTimeline.q(iMin, list);
        int iL1 = l1();
        int size = list.size();
        if (iL1 >= iMin) {
            iL1 += size;
        }
        PlayerInfo playerInfoF = this.f10002m.f10007a.f(queueTimelineQ, iL1);
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoF, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (m()) {
            f(iMin, list);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getDuration() {
        return this.f10002m.f10007a.f10170c.f10252d;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final float getVolume() {
        return 1.0f;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void h0() {
        s0(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long h1() {
        return this.f10002m.f10007a.f10170c.f10253e;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int i0() {
        return this.f10002m.f10007a.f10170c.f10254f;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata i1() {
        return this.f10002m.f10007a.f10180m;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isConnected() {
        return this.f9999j;
    }

    public MediaController j() {
        return this.f9991b;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void j0() {
        this.f9996g.p().r();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean j1() {
        return this.f10002m.f10007a.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0376 A[PHI: r27
      0x0376: PHI (r27v10 long) = (r27v6 long), (r27v11 long) binds: [B:178:0x0380, B:173:0x0373] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x05ba A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x073c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x05f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0788 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a7 A[PHI: r4
      0x01a7: PHI (r4v6 androidx.media3.session.QueueTimeline) = (r4v1 androidx.media3.session.QueueTimeline), (r4v9 androidx.media3.session.QueueTimeline) binds: [B:91:0x01af, B:88:0x01a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b1  */
    /* JADX WARN: Type inference failed for: r10v39, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v135, types: [java.util.AbstractCollection, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(boolean r77, androidx.media3.session.MediaControllerImplLegacy.LegacyPlayerInfo r78) throws androidx.media3.session.LegacyConversions.ConversionException {
        /*
            Method dump skipped, instructions count: 2132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplLegacy.k(boolean, androidx.media3.session.MediaControllerImplLegacy$LegacyPlayerInfo):void");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void k0() {
        o(l1(), 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void k1(MediaItem mediaItem, long j2) {
        c1(ImmutableList.t(mediaItem), 0, j2);
    }

    public final void l() {
        Timeline.Window window = new Timeline.Window();
        Assertions.g(m() && !this.f10002m.f10007a.f10177j.p());
        PlayerInfo playerInfo = this.f10002m.f10007a;
        QueueTimeline queueTimeline = (QueueTimeline) playerInfo.f10177j;
        int i2 = playerInfo.f10170c.f10249a.f5441b;
        queueTimeline.m(i2, window, 0L);
        MediaItem mediaItem = window.f5488c;
        if (queueTimeline.r(i2) == -1) {
            MediaItem.RequestMetadata requestMetadata = mediaItem.f5262f;
            if (requestMetadata.f5351a != null) {
                if (this.f10002m.f10007a.t) {
                    MediaControllerCompat.TransportControls transportControlsP = this.f9996g.p();
                    Uri uri = requestMetadata.f5351a;
                    Bundle bundle = requestMetadata.f5353c;
                    if (bundle == null) {
                        bundle = Bundle.EMPTY;
                    }
                    transportControlsP.f(uri, bundle);
                } else {
                    MediaControllerCompat.TransportControls transportControlsP2 = this.f9996g.p();
                    Uri uri2 = requestMetadata.f5351a;
                    Bundle bundle2 = requestMetadata.f5353c;
                    if (bundle2 == null) {
                        bundle2 = Bundle.EMPTY;
                    }
                    transportControlsP2.j(uri2, bundle2);
                }
            } else if (requestMetadata.f5352b == null) {
                boolean z = this.f10002m.f10007a.t;
                String str = mediaItem.f5257a;
                if (z) {
                    MediaControllerCompat.TransportControls transportControlsP3 = this.f9996g.p();
                    Bundle bundle3 = requestMetadata.f5353c;
                    if (bundle3 == null) {
                        bundle3 = Bundle.EMPTY;
                    }
                    transportControlsP3.d(bundle3, str);
                } else {
                    MediaControllerCompat.TransportControls transportControlsP4 = this.f9996g.p();
                    Bundle bundle4 = requestMetadata.f5353c;
                    if (bundle4 == null) {
                        bundle4 = Bundle.EMPTY;
                    }
                    transportControlsP4.h(bundle4, str);
                }
            } else if (this.f10002m.f10007a.t) {
                MediaControllerCompat.TransportControls transportControlsP5 = this.f9996g.p();
                String str2 = requestMetadata.f5352b;
                Bundle bundle5 = requestMetadata.f5353c;
                if (bundle5 == null) {
                    bundle5 = Bundle.EMPTY;
                }
                transportControlsP5.e(bundle5, str2);
            } else {
                MediaControllerCompat.TransportControls transportControlsP6 = this.f9996g.p();
                String str3 = requestMetadata.f5352b;
                Bundle bundle6 = requestMetadata.f5353c;
                if (bundle6 == null) {
                    bundle6 = Bundle.EMPTY;
                }
                transportControlsP6.i(bundle6, str3);
            }
        } else if (this.f10002m.f10007a.t) {
            this.f9996g.p().c();
        } else {
            this.f9996g.p().g();
        }
        if (this.f10002m.f10007a.f10170c.f10249a.f5445f != 0) {
            this.f9996g.p().l(this.f10002m.f10007a.f10170c.f10249a.f5445f);
        }
        if (this.f10002m.f10009c.a(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < queueTimeline.o(); i3++) {
                if (i3 != i2 && queueTimeline.r(i3) == -1) {
                    queueTimeline.m(i3, window, 0L);
                    arrayList.add(window.f5488c);
                }
            }
            f(0, arrayList);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void l0(int i2, boolean z) {
        if (Util.f5744a < 23) {
            Log.h("MCImplLegacy", "Session doesn't support setting mute state at API level less than 23");
            return;
        }
        if (z != r1()) {
            PlayerInfo playerInfoA = this.f10002m.f10007a.a(K0(), z);
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.b(z ? -100 : 100, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int l1() {
        return this.f10002m.f10007a.f10170c.f10249a.f5441b;
    }

    public final boolean m() {
        return this.f10002m.f10007a.y != 1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void m0() {
        x0(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
    }

    public final void n() throws LegacyConversions.ConversionException {
        if (this.f9998i || this.f9999j) {
            return;
        }
        this.f9999j = true;
        k(true, new LegacyPlayerInfo(this.f9996g.i(), h(this.f9996g.j()), this.f9996g.g(), g(this.f9996g.k()), this.f9996g.l(), this.f9996g.n(), this.f9996g.o(), this.f9996g.d()));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void n0(int i2) {
        int iK0 = K0();
        int i3 = Y0().f5195c;
        if (i3 == 0 || iK0 + 1 <= i3) {
            PlayerInfo playerInfoA = this.f10002m.f10007a.a(iK0 + 1, r1());
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.b(1, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void n1(SurfaceView surfaceView) {
        Log.h("MCImplLegacy", "Session doesn't support clearing SurfaceView");
    }

    public final void o(int i2, long j2) {
        Integer num;
        Integer num2;
        int i3;
        long j3;
        long j4;
        long j5;
        int i4 = i2;
        long j6 = j2;
        Assertions.a(i4 >= 0);
        int iL1 = l1();
        Timeline timeline = this.f10002m.f10007a.f10177j;
        if ((timeline.p() || i4 < timeline.o()) && !f0()) {
            if (i4 != iL1) {
                long jR = ((QueueTimeline) this.f10002m.f10007a.f10177j).r(i4);
                if (jR != -1) {
                    this.f9996g.p().s(jR);
                    num = 2;
                } else {
                    android.support.v4.media.a.r(i4, "Cannot seek to new media item due to the missing queue Id at media item, mediaItemIndex=", "MCImplLegacy");
                    i4 = iL1;
                    num = null;
                }
            } else {
                i4 = iL1;
                num = null;
            }
            long jZ1 = z1();
            if (j6 == -9223372036854775807L) {
                j6 = jZ1;
                num2 = null;
            } else {
                this.f9996g.p().l(j6);
                num2 = 1;
            }
            if (num == null) {
                long jH1 = h1();
                long duration = getDuration();
                long jMax = j6 < jZ1 ? j6 : Math.max(j6, jH1);
                j3 = jMax;
                i3 = duration == -9223372036854775807L ? 0 : (int) ((100 * jMax) / duration);
                j4 = jMax - j6;
                j5 = duration;
            } else {
                i3 = 0;
                j3 = 0;
                j4 = 0;
                j5 = -9223372036854775807L;
            }
            PlayerInfo playerInfoE = this.f10002m.f10007a.e(new SessionPositionInfo(i(i4, !timeline.p() ? timeline.m(i4, new Timeline.Window(), 0L).f5488c : null, j6, false), false, SystemClock.elapsedRealtime(), j5, j3, i3, j4, -9223372036854775807L, j5, j3));
            if (playerInfoE.y != 1) {
                playerInfoE = playerInfoE.d(2, null);
            }
            PlayerInfo playerInfo = playerInfoE;
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfo, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), num2, num);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void o0(SurfaceView surfaceView) {
        Log.h("MCImplLegacy", "Session doesn't support setting SurfaceView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void o1(int i2, int i3) {
        p1(i2, i2 + 1, i3);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p() {
        PlayerInfo playerInfo = this.f10002m.f10007a;
        if (playerInfo.y != 1) {
            return;
        }
        PlayerInfo playerInfoD = playerInfo.d(playerInfo.f10177j.p() ? 4 : 2, null);
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoD, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (this.f10002m.f10007a.f10177j.p()) {
            return;
        }
        l();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p0(int i2, int i3, List list) {
        Assertions.a(i2 >= 0 && i2 <= i3);
        int iO = ((QueueTimeline) this.f10002m.f10007a.f10177j).o();
        if (i2 > iO) {
            return;
        }
        int iMin = Math.min(i3, iO);
        g1(iMin, list);
        s0(i2, iMin);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p1(int i2, int i3, int i4) {
        Assertions.a(i2 >= 0 && i2 <= i3 && i4 >= 0);
        QueueTimeline queueTimeline = (QueueTimeline) this.f10002m.f10007a.f10177j;
        int iO = queueTimeline.o();
        int iMin = Math.min(i3, iO);
        int i5 = iMin - i2;
        int i6 = iO - i5;
        int i7 = i6 - 1;
        int iMin2 = Math.min(i4, i6);
        if (i2 >= iO || i2 == iMin || i2 == iMin2) {
            return;
        }
        int iL1 = l1();
        if (iL1 >= i2) {
            iL1 = iL1 < iMin ? -1 : iL1 - i5;
        }
        if (iL1 == -1) {
            iL1 = Util.k(i2, 0, i7);
            Log.h("MCImplLegacy", "Currently playing item will be removed and added back to mimic move. Assumes item at " + iL1 + " would be the new current item");
        }
        if (iL1 >= iMin2) {
            iL1 += i5;
        }
        ArrayList arrayList = new ArrayList(queueTimeline.f10215e);
        Util.S(arrayList, i2, iMin, iMin2);
        PlayerInfo playerInfoF = this.f10002m.f10007a.f(new QueueTimeline(ImmutableList.o(arrayList), queueTimeline.f10216f), iL1);
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoF, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (m()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i8 = 0; i8 < i5; i8++) {
                arrayList2.add((MediaSessionCompat.QueueItem) this.f10000k.f10016d.get(i2));
                this.f9996g.t(((MediaSessionCompat.QueueItem) this.f10000k.f10016d.get(i2)).f10634a);
            }
            for (int i9 = 0; i9 < arrayList2.size(); i9++) {
                this.f9996g.a(((MediaSessionCompat.QueueItem) arrayList2.get(i9)).f10634a, i9 + iMin2);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void pause() {
        u0(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(boolean r17, androidx.media3.session.MediaControllerImplLegacy.LegacyPlayerInfo r18, final androidx.media3.session.MediaControllerImplLegacy.ControllerInfo r19, java.lang.Integer r20, java.lang.Integer r21) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplLegacy.q(boolean, androidx.media3.session.MediaControllerImplLegacy$LegacyPlayerInfo, androidx.media3.session.MediaControllerImplLegacy$ControllerInfo, java.lang.Integer, java.lang.Integer):void");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void q0(MediaMetadata mediaMetadata) {
        Log.h("MCImplLegacy", "Session doesn't support setting playlist metadata");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void q1(List list) {
        g1(Api.BaseClientBuilder.API_PRIORITY_OTHER, list);
    }

    public final void r(ControllerInfo controllerInfo, Integer num, Integer num2) {
        q(false, this.f10000k, controllerInfo, num, num2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void r0(int i2) {
        s0(i2, i2 + 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean r1() {
        PlayerInfo playerInfo = this.f10002m.f10007a;
        if (playerInfo.q.f5193a == 1) {
            return playerInfo.s;
        }
        MediaControllerCompat mediaControllerCompat = this.f9996g;
        if (mediaControllerCompat == null) {
            return false;
        }
        MediaControllerCompat.PlaybackInfo playbackInfoI = mediaControllerCompat.i();
        ImmutableSet immutableSet = LegacyConversions.f9940a;
        return playbackInfoI != null && playbackInfoI.f10585e == 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        if (this.f9998i) {
            return;
        }
        this.f9998i = true;
        MediaBrowserCompat mediaBrowserCompat = this.f9997h;
        if (mediaBrowserCompat != null) {
            mediaBrowserCompat.b();
            this.f9997h = null;
        }
        MediaControllerCompat mediaControllerCompat = this.f9996g;
        if (mediaControllerCompat != null) {
            ControllerCompatCallback controllerCompatCallback = this.f9994e;
            mediaControllerCompat.w(controllerCompatCallback);
            controllerCompatCallback.f10005d.removeCallbacksAndMessages(null);
            this.f9996g = null;
        }
        this.f9999j = false;
        this.f9993d.d();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void s0(int i2, int i3) {
        Assertions.a(i2 >= 0 && i3 >= i2);
        int iO = F0().o();
        int iMin = Math.min(i3, iO);
        if (i2 >= iO || i2 == iMin) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) this.f10002m.f10007a.f10177j;
        queueTimeline.getClass();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = queueTimeline.f10215e;
        builder.f(immutableList.subList(0, i2));
        builder.f(immutableList.subList(iMin, immutableList.size()));
        QueueTimeline queueTimeline2 = new QueueTimeline(builder.j(), queueTimeline.f10216f);
        int iL1 = l1();
        int i4 = iMin - i2;
        if (iL1 >= i2) {
            iL1 = iL1 < iMin ? -1 : iL1 - i4;
        }
        if (iL1 == -1) {
            iL1 = Util.k(i2, 0, queueTimeline2.o() - 1);
            Log.h("MCImplLegacy", "Currently playing item is removed. Assumes item at " + iL1 + " is the new current item");
        }
        PlayerInfo playerInfoF = this.f10002m.f10007a.f(queueTimeline2, iL1);
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoF, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (m()) {
            while (i2 < iMin && i2 < this.f10000k.f10016d.size()) {
                this.f9996g.t(((MediaSessionCompat.QueueItem) this.f10000k.f10016d.get(i2)).f10634a);
                i2++;
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean s1() {
        return this.f10002m.f10007a.f10176i;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void stop() {
        PlayerInfo playerInfo = this.f10002m.f10007a;
        if (playerInfo.y == 1) {
            return;
        }
        SessionPositionInfo sessionPositionInfo = playerInfo.f10170c;
        Player.PositionInfo positionInfo = sessionPositionInfo.f10249a;
        long j2 = positionInfo.f5445f;
        long j3 = sessionPositionInfo.f10252d;
        PlayerInfo playerInfoE = playerInfo.e(new SessionPositionInfo(positionInfo, false, SystemClock.elapsedRealtime(), j3, j2, MediaUtils.b(j2, j3), 0L, -9223372036854775807L, j3, j2));
        PlayerInfo playerInfo2 = this.f10002m.f10007a;
        if (playerInfo2.y != 1) {
            playerInfoE = playerInfoE.d(1, playerInfo2.f10168a);
        }
        PlayerInfo playerInfo3 = playerInfoE;
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfo3, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        this.f9996g.p().t();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void t0() {
        this.f9996g.p().r();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long t1() {
        return h1();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int u() {
        return this.f10002m.f10007a.y;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void u0(boolean z) {
        PlayerInfo playerInfo = this.f10002m.f10007a;
        if (playerInfo.t == z) {
            return;
        }
        this.n = MediaUtils.c(playerInfo, this.n, this.o, j().f9959f);
        this.o = SystemClock.elapsedRealtime();
        PlayerInfo playerInfoB = this.f10002m.f10007a.b(1, 0, z);
        ControllerInfo controllerInfo = this.f10002m;
        r(new ControllerInfo(playerInfoB, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        if (!m() || this.f10002m.f10007a.f10177j.p()) {
            return;
        }
        if (z) {
            this.f9996g.p().c();
        } else {
            this.f9996g.p().b();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void u1(int i2) {
        Z0(i2, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void v0(MediaItem mediaItem) {
        k1(mediaItem, -9223372036854775807L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void v1() {
        this.f9996g.p().a();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void w0() {
        this.f9996g.p().q();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void w1() {
        this.f9996g.p().k();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void x0(int i2) {
        int iK0 = K0() - 1;
        if (iK0 >= Y0().f5194b) {
            PlayerInfo playerInfoA = this.f10002m.f10007a.a(iK0, r1());
            ControllerInfo controllerInfo = this.f10002m;
            r(new ControllerInfo(playerInfoA, controllerInfo.f10008b, controllerInfo.f10009c, controllerInfo.f10010d, controllerInfo.f10011e, null), null, null);
        }
        this.f9996g.b(-1, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata x1() {
        MediaItem mediaItemI = this.f10002m.f10007a.i();
        return mediaItemI == null ? MediaMetadata.J : mediaItemI.f5260d;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Tracks y0() {
        return Tracks.f5546b;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void y1(List list) {
        c1(list, 0, -9223372036854775807L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final CueGroup z0() {
        Log.h("MCImplLegacy", "Session doesn't support getting Cue");
        return CueGroup.f5638c;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long z1() {
        long jC = MediaUtils.c(this.f10002m.f10007a, this.n, this.o, j().f9959f);
        this.n = jC;
        return jC;
    }

    public static final class LegacyPlayerInfo {

        /* renamed from: a, reason: collision with root package name */
        public final MediaControllerCompat.PlaybackInfo f10013a;

        /* renamed from: b, reason: collision with root package name */
        public final PlaybackStateCompat f10014b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaMetadataCompat f10015c;

        /* renamed from: d, reason: collision with root package name */
        public final List f10016d;

        /* renamed from: e, reason: collision with root package name */
        public final CharSequence f10017e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10018f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10019g;

        /* renamed from: h, reason: collision with root package name */
        public final Bundle f10020h;

        public LegacyPlayerInfo() {
            this.f10013a = null;
            this.f10014b = null;
            this.f10015c = null;
            this.f10016d = Collections.EMPTY_LIST;
            this.f10017e = null;
            this.f10018f = 0;
            this.f10019g = 0;
            this.f10020h = Bundle.EMPTY;
        }

        public LegacyPlayerInfo(MediaControllerCompat.PlaybackInfo playbackInfo, PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, List list, CharSequence charSequence, int i2, int i3, Bundle bundle) {
            this.f10013a = playbackInfo;
            this.f10014b = playbackStateCompat;
            this.f10015c = mediaMetadataCompat;
            list.getClass();
            this.f10016d = list;
            this.f10017e = charSequence;
            this.f10018f = i2;
            this.f10019g = i3;
            this.f10020h = bundle == null ? Bundle.EMPTY : bundle;
        }

        public LegacyPlayerInfo(LegacyPlayerInfo legacyPlayerInfo) {
            this.f10013a = legacyPlayerInfo.f10013a;
            this.f10014b = legacyPlayerInfo.f10014b;
            this.f10015c = legacyPlayerInfo.f10015c;
            this.f10016d = legacyPlayerInfo.f10016d;
            this.f10017e = legacyPlayerInfo.f10017e;
            this.f10018f = legacyPlayerInfo.f10018f;
            this.f10019g = legacyPlayerInfo.f10019g;
            this.f10020h = legacyPlayerInfo.f10020h;
        }
    }

    public static class ControllerInfo {

        /* renamed from: a, reason: collision with root package name */
        public final PlayerInfo f10007a;

        /* renamed from: b, reason: collision with root package name */
        public final SessionCommands f10008b;

        /* renamed from: c, reason: collision with root package name */
        public final Player.Commands f10009c;

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableList f10010d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10011e;

        /* renamed from: f, reason: collision with root package name */
        public final SessionError f10012f;

        public ControllerInfo() {
            PlayerInfo playerInfo = PlayerInfo.F;
            QueueTimeline queueTimeline = QueueTimeline.f10213g;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10190j = queueTimeline;
            this.f10007a = builderE.a();
            this.f10008b = SessionCommands.f10236b;
            this.f10009c = Player.Commands.f5430b;
            this.f10010d = ImmutableList.r();
            this.f10011e = Bundle.EMPTY;
            this.f10012f = null;
        }

        public ControllerInfo(PlayerInfo playerInfo, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle, SessionError sessionError) {
            this.f10007a = playerInfo;
            this.f10008b = sessionCommands;
            this.f10009c = commands;
            this.f10010d = immutableList;
            this.f10011e = bundle == null ? Bundle.EMPTY : bundle;
            this.f10012f = sessionError;
        }
    }
}
