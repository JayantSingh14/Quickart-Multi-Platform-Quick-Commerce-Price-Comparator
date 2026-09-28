package androidx.media3.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.collection.ArraySet;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
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
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaController;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SequencedFutureManager;
import androidx.media3.session.SessionToken;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    public long A;
    public long B;
    public PlayerInfo C;
    public PlayerInfo.BundlingExclusions D;

    /* renamed from: a, reason: collision with root package name */
    public final MediaController f9970a;

    /* renamed from: b, reason: collision with root package name */
    public final SequencedFutureManager f9971b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaControllerStub f9972c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f9973d;

    /* renamed from: e, reason: collision with root package name */
    public final SessionToken f9974e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f9975f;

    /* renamed from: g, reason: collision with root package name */
    public final j f9976g;

    /* renamed from: h, reason: collision with root package name */
    public final SurfaceCallback f9977h;

    /* renamed from: i, reason: collision with root package name */
    public final ListenerSet f9978i;

    /* renamed from: j, reason: collision with root package name */
    public final FlushCommandQueueHandler f9979j;

    /* renamed from: k, reason: collision with root package name */
    public final ArraySet f9980k;

    /* renamed from: l, reason: collision with root package name */
    public SessionToken f9981l;

    /* renamed from: m, reason: collision with root package name */
    public SessionServiceConnection f9982m;
    public boolean n;
    public Player.Commands s;
    public Player.Commands t;
    public Player.Commands u;
    public Surface v;
    public SurfaceHolder w;
    public TextureView x;
    public IMediaSession z;
    public PlayerInfo o = PlayerInfo.F;
    public Size y = Size.f5730c;
    public SessionCommands r = SessionCommands.f10236b;
    public ImmutableList p = ImmutableList.r();
    public ImmutableList q = ImmutableList.r();

    public class FlushCommandQueueHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f9983a;

        public FlushCommandQueueHandler(Looper looper) {
            this.f9983a = new Handler(looper, new f0(this, 0));
        }
    }

    public static final class PeriodInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f9985a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9986b;

        public PeriodInfo(int i2, long j2) {
            this.f9985a = i2;
            this.f9986b = j2;
        }
    }

    public interface RemoteSessionTask {
        void d(IMediaSession iMediaSession, int i2);
    }

    public class SessionServiceConnection implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f9987a;

        public SessionServiceConnection(Bundle bundle) {
            this.f9987a = bundle;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName componentName) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            MediaController mediaControllerO = mediaControllerImplBase.o();
            MediaController mediaControllerO2 = mediaControllerImplBase.o();
            Objects.requireNonNull(mediaControllerO2);
            mediaControllerO.l(new a0(mediaControllerO2, 2));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaController mediaControllerO;
            a0 a0Var;
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            try {
                try {
                    if (mediaControllerImplBase.f9974e.f10269a.V().equals(componentName.getPackageName())) {
                        IMediaSessionService iMediaSessionServiceG = IMediaSessionService.Stub.g(iBinder);
                        if (iMediaSessionServiceG != null) {
                            iMediaSessionServiceG.G7(mediaControllerImplBase.f9972c, new ConnectionRequest(mediaControllerImplBase.f9973d.getPackageName(), Process.myPid(), this.f9987a).b());
                            return;
                        } else {
                            Log.d("MCImplBase", "Service interface is missing.");
                            mediaControllerO = mediaControllerImplBase.o();
                            MediaController mediaControllerO2 = mediaControllerImplBase.o();
                            Objects.requireNonNull(mediaControllerO2);
                            a0Var = new a0(mediaControllerO2, 2);
                        }
                    } else {
                        Log.d("MCImplBase", "Expected connection to " + mediaControllerImplBase.f9974e.f10269a.V() + " but is connected to " + componentName);
                        mediaControllerO = mediaControllerImplBase.o();
                        MediaController mediaControllerO3 = mediaControllerImplBase.o();
                        Objects.requireNonNull(mediaControllerO3);
                        a0Var = new a0(mediaControllerO3, 2);
                    }
                    mediaControllerO.l(a0Var);
                } catch (RemoteException unused) {
                    Log.h("MCImplBase", "Service " + componentName + " has died prematurely");
                    MediaController mediaControllerO4 = mediaControllerImplBase.o();
                    MediaController mediaControllerO5 = mediaControllerImplBase.o();
                    Objects.requireNonNull(mediaControllerO5);
                    mediaControllerO4.l(new a0(mediaControllerO5, 2));
                }
            } catch (Throwable th) {
                MediaController mediaControllerO6 = mediaControllerImplBase.o();
                MediaController mediaControllerO7 = mediaControllerImplBase.o();
                Objects.requireNonNull(mediaControllerO7);
                mediaControllerO6.l(new a0(mediaControllerO7, 2));
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            MediaController mediaControllerO = mediaControllerImplBase.o();
            MediaController mediaControllerO2 = mediaControllerImplBase.o();
            Objects.requireNonNull(mediaControllerO2);
            mediaControllerO.l(new a0(mediaControllerO2, 2));
        }
    }

    public class SurfaceCallback implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public SurfaceCallback() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            TextureView textureView = mediaControllerImplBase.x;
            if (textureView == null || textureView.getSurfaceTexture() != surfaceTexture) {
                return;
            }
            mediaControllerImplBase.v = new Surface(surfaceTexture);
            mediaControllerImplBase.m(new g0(this, 2));
            mediaControllerImplBase.z(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            TextureView textureView = mediaControllerImplBase.x;
            if (textureView != null && textureView.getSurfaceTexture() == surfaceTexture) {
                mediaControllerImplBase.v = null;
                mediaControllerImplBase.m(new g0(this, 3));
                mediaControllerImplBase.z(0, 0);
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            TextureView textureView = mediaControllerImplBase.x;
            if (textureView == null || textureView.getSurfaceTexture() != surfaceTexture) {
                return;
            }
            mediaControllerImplBase.z(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.w != surfaceHolder) {
                return;
            }
            mediaControllerImplBase.z(i3, i4);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.w != surfaceHolder) {
                return;
            }
            mediaControllerImplBase.v = surfaceHolder.getSurface();
            mediaControllerImplBase.m(new g0(this, 0));
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            mediaControllerImplBase.z(surfaceFrame.width(), surfaceFrame.height());
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.w != surfaceHolder) {
                return;
            }
            mediaControllerImplBase.v = null;
            mediaControllerImplBase.m(new g0(this, 1));
            mediaControllerImplBase.z(0, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.media3.session.j] */
    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, Bundle bundle, Looper looper) {
        Player.Commands commands = Player.Commands.f5430b;
        this.s = commands;
        this.t = commands;
        this.u = i(commands, commands);
        this.f9978i = new ListenerSet(looper, Clock.f5662a, new i(this, 0));
        this.f9970a = mediaController;
        Assertions.e(context, "context must not be null");
        Assertions.e(sessionToken, "token must not be null");
        this.f9973d = context;
        this.f9971b = new SequencedFutureManager();
        this.f9972c = new MediaControllerStub(this);
        this.f9980k = new ArraySet();
        this.f9974e = sessionToken;
        this.f9975f = bundle;
        this.f9976g = new IBinder.DeathRecipient() { // from class: androidx.media3.session.j
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                MediaControllerImplBase mediaControllerImplBase = this.f10392a;
                MediaController mediaControllerO = mediaControllerImplBase.o();
                MediaController mediaControllerO2 = mediaControllerImplBase.o();
                Objects.requireNonNull(mediaControllerO2);
                mediaControllerO.l(new a0(mediaControllerO2, 2));
            }
        };
        this.f9977h = new SurfaceCallback();
        Bundle bundle2 = Bundle.EMPTY;
        this.f9982m = sessionToken.f10269a.getType() == 0 ? null : new SessionServiceConnection(bundle);
        this.f9979j = new FlushCommandQueueHandler(looper);
        this.A = -9223372036854775807L;
        this.B = -9223372036854775807L;
    }

    public static void H(Timeline timeline, ArrayList arrayList, ArrayList arrayList2) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Timeline.Window window = (Timeline.Window) arrayList.get(i2);
            int i3 = window.n;
            int i4 = window.o;
            if (i3 == -1 || i4 == -1) {
                window.n = arrayList2.size();
                window.o = arrayList2.size();
                Timeline.Period period = new Timeline.Period();
                period.g(null, null, i2, -9223372036854775807L, 0L, AdPlaybackState.f5118g, true);
                arrayList2.add(period);
            } else {
                window.n = arrayList2.size();
                window.o = (i4 - i3) + arrayList2.size();
                while (i3 <= i4) {
                    Timeline.Period period2 = new Timeline.Period();
                    timeline.f(i3, period2, false);
                    period2.f5477c = i2;
                    arrayList2.add(period2);
                    i3++;
                }
            }
        }
    }

    public static Player.Commands i(Player.Commands commands, Player.Commands commands2) {
        Player.Commands commandsD = MediaUtils.d(commands, commands2);
        if (commandsD.a(32)) {
            return commandsD;
        }
        Player.Commands.Builder builder = new Player.Commands.Builder(commandsD);
        builder.f5434a.a(32);
        return builder.d();
    }

    public static Timeline.RemotableTimeline j(ArrayList arrayList, ArrayList arrayList2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.f(arrayList);
        ImmutableList immutableListJ = builder.j();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        builder2.f(arrayList2);
        ImmutableList immutableListJ2 = builder2.j();
        int size = arrayList.size();
        MediaBrowserServiceCompat.BrowserRoot browserRoot = MediaUtils.f10167a;
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = i2;
        }
        return new Timeline.RemotableTimeline(immutableListJ, immutableListJ2, iArr);
    }

    public static int n(PlayerInfo playerInfo) {
        int i2 = playerInfo.f10170c.f10249a.f5441b;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public static PlayerInfo v(PlayerInfo playerInfo, int i2, List list, long j2, long j3) {
        int size;
        Timeline timeline = playerInfo.f10177j;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size2 = 0;
        for (int i3 = 0; i3 < timeline.o(); i3++) {
            arrayList.add(timeline.m(i3, new Timeline.Window(), 0L));
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            MediaItem mediaItem = (MediaItem) list.get(i4);
            Timeline.Window window = new Timeline.Window();
            window.b(0, mediaItem, null, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, -1, -1, 0L);
            arrayList.add(i4 + i2, window);
        }
        H(timeline, arrayList, arrayList2);
        Timeline.RemotableTimeline remotableTimelineJ = j(arrayList, arrayList2);
        if (playerInfo.f10177j.p()) {
            size = 0;
        } else {
            SessionPositionInfo sessionPositionInfo = playerInfo.f10170c;
            int i5 = sessionPositionInfo.f10249a.f5441b;
            size2 = i5 >= i2 ? list.size() + i5 : i5;
            int i6 = sessionPositionInfo.f10249a.f5444e;
            size = i6 >= i2 ? list.size() + i6 : i6;
        }
        return x(playerInfo, remotableTimelineJ, size2, size, j2, j3, 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
    
        r8 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.PlayerInfo w(androidx.media3.session.PlayerInfo r35, int r36, int r37, boolean r38, long r39, long r41) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplBase.w(androidx.media3.session.PlayerInfo, int, int, boolean, long, long):androidx.media3.session.PlayerInfo");
    }

    public static PlayerInfo x(PlayerInfo playerInfo, Timeline.RemotableTimeline remotableTimeline, int i2, int i3, long j2, long j3, int i4) {
        Timeline.Window window = new Timeline.Window();
        remotableTimeline.m(i2, window, 0L);
        MediaItem mediaItem = window.f5488c;
        Player.PositionInfo positionInfo = playerInfo.f10170c.f10249a;
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(null, i2, mediaItem, null, i3, j2, j3, positionInfo.f5447h, positionInfo.f5448i);
        SessionPositionInfo sessionPositionInfo = playerInfo.f10170c;
        return y(playerInfo, remotableTimeline, positionInfo2, new SessionPositionInfo(positionInfo2, sessionPositionInfo.f10250b, SystemClock.elapsedRealtime(), sessionPositionInfo.f10252d, sessionPositionInfo.f10253e, sessionPositionInfo.f10254f, sessionPositionInfo.f10255g, sessionPositionInfo.f10256h, sessionPositionInfo.f10257i, sessionPositionInfo.f10258j), i4);
    }

    public static PlayerInfo y(PlayerInfo playerInfo, Timeline timeline, Player.PositionInfo positionInfo, SessionPositionInfo sessionPositionInfo, int i2) {
        PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfo);
        builder.f10190j = timeline;
        builder.f10184d = playerInfo.f10170c.f10249a;
        builder.f10185e = positionInfo;
        builder.f10183c = sessionPositionInfo;
        builder.f10186f = i2;
        return builder.a();
    }

    public final void A(int i2, int i3, int i4) {
        int i5;
        int i6;
        Timeline timeline = this.o.f10177j;
        int iO = timeline.o();
        int iMin = Math.min(i3, iO);
        int i7 = iMin - i2;
        int iMin2 = Math.min(i4, iO - i7);
        if (i2 >= iO || i2 == iMin || i2 == iMin2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i8 = 0; i8 < iO; i8++) {
            arrayList.add(timeline.m(i8, new Timeline.Window(), 0L));
        }
        Util.S(arrayList, i2, iMin, iMin2);
        H(timeline, arrayList, arrayList2);
        Timeline.RemotableTimeline remotableTimelineJ = j(arrayList, arrayList2);
        if (remotableTimelineJ.p()) {
            return;
        }
        int iN = n(this.o);
        if (iN >= i2 && iN < iMin) {
            i6 = (iN - i2) + iMin2;
        } else if (iMin <= iN && iMin2 > iN) {
            i6 = iN - i7;
        } else {
            if (iMin <= iN || iMin2 > iN) {
                i5 = iN;
                Timeline.Window window = new Timeline.Window();
                int i9 = this.o.f10170c.f10249a.f5444e - timeline.m(iN, window, 0L).n;
                remotableTimelineJ.m(i5, window, 0L);
                O(x(this.o, remotableTimelineJ, i5, window.n + i9, z1(), f1(), 5), 0, null, null, null);
            }
            i6 = iN + i7;
        }
        i5 = i6;
        Timeline.Window window2 = new Timeline.Window();
        int i92 = this.o.f10170c.f10249a.f5444e - timeline.m(iN, window2, 0L).n;
        remotableTimelineJ.m(i5, window2, 0L);
        O(x(this.o, remotableTimelineJ, i5, window2.n + i92, z1(), f1(), 5), 0, null, null, null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void A0(Player.Listener listener) {
        this.f9978i.e(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long A1() {
        return this.o.A;
    }

    public final void B(PlayerInfo playerInfo, final PlayerInfo playerInfo2, final Integer num, final Integer num2, final Integer num3, Integer num4) {
        ListenerSet listenerSet = this.f9978i;
        if (num != null) {
            final int i2 = 0;
            listenerSet.c(0, new ListenerSet.Event() { // from class: androidx.media3.session.u
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i2) {
                        case 0:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.B1(playerInfo3.f10177j, num.intValue());
                            break;
                        case 1:
                            PlayerInfo playerInfo4 = playerInfo2;
                            listener.v1(num.intValue(), playerInfo4.f10171d, playerInfo4.f10172e);
                            break;
                        default:
                            listener.y1(num.intValue(), playerInfo2.t);
                            break;
                    }
                }
            });
        }
        if (num3 != null) {
            final int i3 = 1;
            listenerSet.c(11, new ListenerSet.Event() { // from class: androidx.media3.session.u
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i3) {
                        case 0:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.B1(playerInfo3.f10177j, num3.intValue());
                            break;
                        case 1:
                            PlayerInfo playerInfo4 = playerInfo2;
                            listener.v1(num3.intValue(), playerInfo4.f10171d, playerInfo4.f10172e);
                            break;
                        default:
                            listener.y1(num3.intValue(), playerInfo2.t);
                            break;
                    }
                }
            });
        }
        MediaItem mediaItemI = playerInfo2.i();
        if (num4 != null) {
            listenerSet.c(1, new s(15, mediaItemI, num4));
        }
        PlaybackException playbackException = playerInfo.f10168a;
        PlaybackException playbackException2 = playerInfo2.f10168a;
        if (playbackException != playbackException2 && (playbackException == null || !playbackException.a(playbackException2))) {
            listenerSet.c(10, new x(0, playbackException2));
            if (playbackException2 != null) {
                listenerSet.c(10, new x(1, playbackException2));
            }
        }
        if (!playerInfo.D.equals(playerInfo2.D)) {
            final int i4 = 17;
            listenerSet.c(2, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i4) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.z.equals(playerInfo2.z)) {
            final int i5 = 18;
            listenerSet.c(14, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i5) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.w != playerInfo2.w) {
            final int i6 = 19;
            listenerSet.c(3, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i6) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.y != playerInfo2.y) {
            final int i7 = 20;
            listenerSet.c(4, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i7) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (num2 != null) {
            final int i8 = 2;
            listenerSet.c(5, new ListenerSet.Event() { // from class: androidx.media3.session.u
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i8) {
                        case 0:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.B1(playerInfo3.f10177j, num2.intValue());
                            break;
                        case 1:
                            PlayerInfo playerInfo4 = playerInfo2;
                            listener.v1(num2.intValue(), playerInfo4.f10171d, playerInfo4.f10172e);
                            break;
                        default:
                            listener.y1(num2.intValue(), playerInfo2.t);
                            break;
                    }
                }
            });
        }
        if (playerInfo.x != playerInfo2.x) {
            final int i9 = 0;
            listenerSet.c(6, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i9) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.v != playerInfo2.v) {
            final int i10 = 1;
            listenerSet.c(7, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i10) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.f10174g.equals(playerInfo2.f10174g)) {
            final int i11 = 2;
            listenerSet.c(12, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i11) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.f10175h != playerInfo2.f10175h) {
            final int i12 = 3;
            listenerSet.c(8, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i12) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.f10176i != playerInfo2.f10176i) {
            final int i13 = 4;
            listenerSet.c(9, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i13) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.f10180m.equals(playerInfo2.f10180m)) {
            final int i14 = 5;
            listenerSet.c(15, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i14) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.n != playerInfo2.n) {
            final int i15 = 6;
            listenerSet.c(22, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i15) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.o.equals(playerInfo2.o)) {
            final int i16 = 7;
            listenerSet.c(20, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i16) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.p.f5641a.equals(playerInfo2.p.f5641a)) {
            final int i17 = 8;
            listenerSet.c(27, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i17) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
            final int i18 = 9;
            listenerSet.c(27, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i18) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.q.equals(playerInfo2.q)) {
            final int i19 = 10;
            listenerSet.c(29, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i19) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.r != playerInfo2.r || playerInfo.s != playerInfo2.s) {
            final int i20 = 11;
            listenerSet.c(30, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i20) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.f10179l.equals(playerInfo2.f10179l)) {
            final int i21 = 12;
            listenerSet.c(25, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i21) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.A != playerInfo2.A) {
            final int i22 = 13;
            listenerSet.c(16, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i22) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.B != playerInfo2.B) {
            final int i23 = 14;
            listenerSet.c(17, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i23) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (playerInfo.C != playerInfo2.C) {
            final int i24 = 15;
            listenerSet.c(18, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i24) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.E.equals(playerInfo2.E)) {
            final int i25 = 16;
            listenerSet.c(19, new ListenerSet.Event() { // from class: androidx.media3.session.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    switch (i25) {
                        case 0:
                            listener.g1(playerInfo2.x);
                            break;
                        case 1:
                            listener.J1(playerInfo2.v);
                            break;
                        case 2:
                            listener.l1(playerInfo2.f10174g);
                            break;
                        case 3:
                            listener.d1(playerInfo2.f10175h);
                            break;
                        case 4:
                            listener.k1(playerInfo2.f10176i);
                            break;
                        case 5:
                            listener.C1(playerInfo2.f10180m);
                            break;
                        case 6:
                            listener.z1(playerInfo2.n);
                            break;
                        case 7:
                            listener.A1(playerInfo2.o);
                            break;
                        case 8:
                            listener.k(playerInfo2.p.f5641a);
                            break;
                        case 9:
                            listener.e1(playerInfo2.p);
                            break;
                        case 10:
                            listener.F1(playerInfo2.q);
                            break;
                        case 11:
                            PlayerInfo playerInfo3 = playerInfo2;
                            listener.m1(playerInfo3.r, playerInfo3.s);
                            break;
                        case 12:
                            listener.b(playerInfo2.f10179l);
                            break;
                        case 13:
                            listener.n1(playerInfo2.A);
                            break;
                        case 14:
                            listener.D1(playerInfo2.B);
                            break;
                        case 15:
                            listener.I1(playerInfo2.C);
                            break;
                        case 16:
                            listener.p1(playerInfo2.E);
                            break;
                        case 17:
                            listener.E1(playerInfo2.D);
                            break;
                        case 18:
                            listener.o1(playerInfo2.z);
                            break;
                        case 19:
                            listener.w1(playerInfo2.w);
                            break;
                        default:
                            listener.i1(playerInfo2.y);
                            break;
                    }
                }
            });
        }
        listenerSet.b();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int B0() {
        return this.o.f10170c.f10249a.f5447h;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void C(float f2) {
        if (t(13)) {
            l(new z(this, f2, 0));
            PlaybackParameters playbackParameters = this.o.f10174g;
            if (playbackParameters.f5427a != f2) {
                PlaybackParameters playbackParameters2 = new PlaybackParameters(f2, playbackParameters.f5428b);
                this.o = this.o.c(playbackParameters2);
                r1 r1Var = new r1(playbackParameters2, 2);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(12, r1Var);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void C0(boolean z) {
        if (t(26)) {
            l(new m(this, z, 2));
            PlayerInfo playerInfo = this.o;
            if (playerInfo.s != z) {
                this.o = playerInfo.a(playerInfo.r, z);
                m mVar = new m(this, z, 3);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, mVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void D(PlaybackParameters playbackParameters) {
        if (t(13)) {
            l(new s(0, this, playbackParameters));
            if (this.o.f10174g.equals(playbackParameters)) {
                return;
            }
            this.o = this.o.c(playbackParameters);
            r1 r1Var = new r1(playbackParameters, 1);
            ListenerSet listenerSet = this.f9978i;
            listenerSet.c(12, r1Var);
            listenerSet.b();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void D0(Player.Listener listener) {
        this.f9978i.a(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void E() {
        if (!t(1)) {
            Log.h("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        } else {
            l(new i(this, 5));
            N(true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int E0() {
        return this.o.x;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackParameters F() {
        return this.o.f10174g;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Timeline F0() {
        return this.o.f10177j;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int G() {
        return this.o.f10175h;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void G0() {
        if (t(26)) {
            l(new i(this, 14));
            PlayerInfo playerInfo = this.o;
            int i2 = playerInfo.r + 1;
            int i3 = playerInfo.q.f5195c;
            if (i3 == 0 || i2 <= i3) {
                this.o = playerInfo.a(i2, playerInfo.s);
                o oVar = new o(this, i2, 4);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final TrackSelectionParameters H0() {
        return this.o.E;
    }

    public final void I(int i2, int i3) {
        int iO = this.o.f10177j.o();
        int iMin = Math.min(i3, iO);
        if (i2 >= iO || i2 == iMin || iO == 0) {
            return;
        }
        boolean z = n(this.o) >= i2 && n(this.o) < iMin;
        PlayerInfo playerInfoW = w(this.o, i2, iMin, false, z1(), f1());
        int i4 = this.o.f10170c.f10249a.f5441b;
        O(playerInfoW, 0, null, z ? 4 : null, i4 >= i2 && i4 < iMin ? 3 : null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void I0() {
        if (t(9)) {
            l(new i(this, 7));
            Timeline timeline = this.o.f10177j;
            if (timeline.p() || f0()) {
                return;
            }
            if (q() != -1) {
                K(q(), -9223372036854775807L);
                return;
            }
            Timeline.Window windowM = timeline.m(n(this.o), new Timeline.Window(), 0L);
            if (windowM.f5494i && windowM.a()) {
                K(n(this.o), -9223372036854775807L);
            }
        }
    }

    public final void J(int i2, int i3, List list) {
        int iO = this.o.f10177j.o();
        if (i2 > iO) {
            return;
        }
        if (this.o.f10177j.p()) {
            M(list, -1, -9223372036854775807L, false);
            return;
        }
        int iMin = Math.min(i3, iO);
        PlayerInfo playerInfoW = w(v(this.o, iMin, list, z1(), f1()), i2, iMin, true, z1(), f1());
        int i4 = this.o.f10170c.f10249a.f5441b;
        boolean z = i4 >= i2 && i4 < iMin;
        O(playerInfoW, 0, null, z ? 4 : null, z ? 3 : null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void J0(TextureView textureView) {
        if (t(27)) {
            if (textureView == null) {
                h();
                return;
            }
            if (this.x == textureView) {
                return;
            }
            g();
            this.x = textureView;
            textureView.setSurfaceTextureListener(this.f9977h);
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            if (surfaceTexture == null) {
                m(new i(this, 9));
                z(0, 0);
            } else {
                this.v = new Surface(surfaceTexture);
                m(new i(this, 10));
                z(textureView.getWidth(), textureView.getHeight());
            }
        }
    }

    public final void K(int i2, long j2) {
        int i3;
        int i4;
        PlayerInfo playerInfoY;
        Timeline timeline = this.o.f10177j;
        if ((timeline.p() || i2 < timeline.o()) && !f0()) {
            PlayerInfo playerInfo = this.o;
            PlayerInfo playerInfoD = playerInfo.d(playerInfo.y == 1 ? 1 : 2, playerInfo.f10168a);
            PeriodInfo periodInfoR = r(timeline, i2, j2);
            if (periodInfoR == null) {
                long j3 = 0;
                long j4 = j2 != -9223372036854775807L ? j2 : 0L;
                if (j2 != -9223372036854775807L) {
                    j3 = j2;
                }
                i3 = 1;
                i4 = 2;
                Player.PositionInfo positionInfo = new Player.PositionInfo(null, i2, null, null, i2, j4, j3, -1, -1);
                PlayerInfo playerInfo2 = this.o;
                Timeline timeline2 = playerInfo2.f10177j;
                boolean z = this.o.f10170c.f10250b;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                SessionPositionInfo sessionPositionInfo = this.o.f10170c;
                playerInfoY = y(playerInfo2, timeline2, positionInfo, new SessionPositionInfo(positionInfo, z, jElapsedRealtime, sessionPositionInfo.f10252d, j2 == -9223372036854775807L ? 0L : j2, 0, 0L, sessionPositionInfo.f10256h, sessionPositionInfo.f10257i, j2 == -9223372036854775807L ? 0L : j2), 1);
            } else {
                i3 = 1;
                i4 = 2;
                SessionPositionInfo sessionPositionInfo2 = playerInfoD.f10170c;
                int i5 = sessionPositionInfo2.f10249a.f5444e;
                Timeline.Period period = new Timeline.Period();
                timeline.f(i5, period, false);
                Timeline.Period period2 = new Timeline.Period();
                int i6 = periodInfoR.f9985a;
                timeline.f(i6, period2, false);
                boolean z2 = i5 != i6;
                long jT = Util.T(z1()) - period.f5479e;
                long j5 = periodInfoR.f9986b;
                if (z2 || j5 != jT) {
                    Player.PositionInfo positionInfo2 = sessionPositionInfo2.f10249a;
                    Assertions.g(positionInfo2.f5447h == -1);
                    Player.PositionInfo positionInfo3 = new Player.PositionInfo(null, period.f5477c, positionInfo2.f5442c, null, i5, Util.j0(period.f5479e + jT), Util.j0(period.f5479e + jT), -1, -1);
                    timeline.f(i6, period2, false);
                    Timeline.Window window = new Timeline.Window();
                    timeline.n(period2.f5477c, window);
                    Player.PositionInfo positionInfo4 = new Player.PositionInfo(null, period2.f5477c, window.f5488c, null, i6, Util.j0(period2.f5479e + j5), Util.j0(period2.f5479e + j5), -1, -1);
                    PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfoD);
                    builder.f10184d = positionInfo3;
                    builder.f10185e = positionInfo4;
                    builder.f10186f = 1;
                    PlayerInfo playerInfoA = builder.a();
                    if (z2 || j5 < jT) {
                        playerInfoD = playerInfoA.e(new SessionPositionInfo(positionInfo4, false, SystemClock.elapsedRealtime(), Util.j0(window.f5498m), Util.j0(period2.f5479e + j5), MediaUtils.b(Util.j0(period2.f5479e + j5), Util.j0(window.f5498m)), 0L, -9223372036854775807L, -9223372036854775807L, Util.j0(period2.f5479e + j5)));
                    } else {
                        long jMax = Math.max(0L, Util.T(playerInfoA.f10170c.f10255g) - (j5 - jT));
                        long j6 = j5 + jMax;
                        playerInfoD = playerInfoA.e(new SessionPositionInfo(positionInfo4, false, SystemClock.elapsedRealtime(), Util.j0(window.f5498m), Util.j0(j6), MediaUtils.b(Util.j0(j6), Util.j0(window.f5498m)), Util.j0(jMax), -9223372036854775807L, -9223372036854775807L, Util.j0(j6)));
                    }
                }
                playerInfoY = playerInfoD;
            }
            boolean zP = this.o.f10177j.p();
            SessionPositionInfo sessionPositionInfo3 = playerInfoY.f10170c;
            int i7 = (zP || sessionPositionInfo3.f10249a.f5441b == this.o.f10170c.f10249a.f5441b) ? 0 : i3;
            if (i7 == 0 && sessionPositionInfo3.f10249a.f5445f == this.o.f10170c.f10249a.f5445f) {
                return;
            }
            O(playerInfoY, null, null, Integer.valueOf(i3), i7 != 0 ? Integer.valueOf(i4) : null);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int K0() {
        return this.o.r;
    }

    public final void L(long j2) {
        long jZ1 = z1() + j2;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            jZ1 = Math.min(jZ1, duration);
        }
        K(n(this.o), Math.max(jZ1, 0L));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long L0() {
        return this.o.f10170c.f10256h;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(java.util.List r35, int r36, long r37, boolean r39) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplBase.M(java.util.List, int, long, boolean):void");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void M0(int i2, long j2) {
        if (t(10)) {
            Assertions.a(i2 >= 0);
            l(new n(this, i2, j2));
            K(i2, j2);
        }
    }

    public final void N(boolean z) {
        PlayerInfo playerInfo = this.o;
        int i2 = playerInfo.x;
        int i3 = i2 == 1 ? 0 : i2;
        if (playerInfo.t == z && i2 == i3) {
            return;
        }
        this.A = MediaUtils.c(playerInfo, this.A, this.B, o().f9959f);
        this.B = SystemClock.elapsedRealtime();
        O(this.o.b(1, i3, z), null, 1, null, null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Player.Commands N0() {
        return this.u;
    }

    public final void O(PlayerInfo playerInfo, Integer num, Integer num2, Integer num3, Integer num4) {
        PlayerInfo playerInfo2 = this.o;
        this.o = playerInfo;
        B(playerInfo2, playerInfo, num, num2, num3, num4);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean O0() {
        return this.o.t;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void P0(boolean z) {
        if (t(14)) {
            l(new m(this, z, 0));
            PlayerInfo playerInfo = this.o;
            if (playerInfo.f10176i != z) {
                PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfo);
                builder.f10189i = z;
                this.o = builder.a();
                o1 o1Var = new o1(z, 3);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(9, o1Var);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long Q0() {
        return this.o.C;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void R0(int i2, MediaItem mediaItem) {
        if (t(20)) {
            Assertions.a(i2 >= 0);
            l(new l(this, i2, mediaItem, 0));
            J(i2, i2 + 1, ImmutableList.t(mediaItem));
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long S0() {
        return this.o.f10170c.f10257i;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int T0() {
        return this.o.f10170c.f10249a.f5444e;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void U0(TextureView textureView) {
        if (t(27) && textureView != null && this.x == textureView) {
            h();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final VideoSize V0() {
        return this.o.f10179l;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        if (t(35)) {
            l(new e0(this, audioAttributes, z));
            if (this.o.o.equals(audioAttributes)) {
                return;
            }
            PlayerInfo playerInfo = this.o;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.o = audioAttributes;
            this.o = builderE.a();
            s0 s0Var = new s0(audioAttributes, 9);
            ListenerSet listenerSet = this.f9978i;
            listenerSet.c(20, s0Var);
            listenerSet.b();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void X(long j2) {
        if (t(5)) {
            l(new w(j2, this));
            K(n(this.o), j2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final AudioAttributes X0() {
        return this.o.o;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final DeviceInfo Y0() {
        return this.o.q;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void Z0(int i2, int i3) {
        if (t(33)) {
            l(new y(this, i2, i3, 0));
            PlayerInfo playerInfo = this.o;
            DeviceInfo deviceInfo = playerInfo.q;
            if (playerInfo.r == i2 || deviceInfo.f5194b > i2) {
                return;
            }
            int i4 = deviceInfo.f5195c;
            if (i4 == 0 || i2 <= i4) {
                this.o = playerInfo.a(i2, playerInfo.s);
                o oVar = new o(this, i2, 3);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackException a() {
        return this.o.f10168a;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int a1() {
        return this.o.f10170c.f10249a.f5448i;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean b() {
        return this.o.w;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void b1(float f2) {
        if (t(24)) {
            l(new z(this, f2, 1));
            PlayerInfo playerInfo = this.o;
            if (playerInfo.n != f2) {
                PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfo);
                builder.n = f2;
                this.o = builder.a();
                p1 p1Var = new p1(f2, 2);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(22, p1Var);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final SessionCommands c() {
        return this.r;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void c1(final List list, final int i2, final long j2) {
        if (t(20)) {
            l(new RemoteSessionTask() { // from class: androidx.media3.session.q
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void d(IMediaSession iMediaSession, int i3) {
                    MediaControllerImplBase mediaControllerImplBase = this.f10734a;
                    mediaControllerImplBase.getClass();
                    UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                    ImmutableList.Builder builder = new ImmutableList.Builder();
                    int i4 = 0;
                    while (true) {
                        List list2 = list;
                        if (i4 >= list2.size()) {
                            iMediaSession.Kb(mediaControllerImplBase.f9972c, i3, new BundleListRetriever(builder.j()), i2, j2);
                            return;
                        }
                        builder.h(((MediaItem) list2.get(i4)).c(true));
                        i4++;
                    }
                }
            });
            M(list, i2, j2, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.media3.session.IMediaSession] */
    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void connect() {
        IMediaSession.Stub.Proxy proxy;
        SessionToken sessionToken = this.f9974e;
        int type = sessionToken.f10269a.getType();
        SessionToken.SessionTokenImpl sessionTokenImpl = sessionToken.f10269a;
        Context context = this.f9973d;
        Bundle bundle = this.f9975f;
        if (type == 0) {
            this.f9982m = null;
            Object objB = sessionTokenImpl.b();
            Assertions.h(objB);
            IBinder iBinder = (IBinder) objB;
            int i2 = IMediaSession.Stub.f9937a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSession");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                IMediaSession.Stub.Proxy proxy2 = new IMediaSession.Stub.Proxy();
                proxy2.f9938a = iBinder;
                proxy = proxy2;
            } else {
                proxy = (IMediaSession) iInterfaceQueryLocalInterface;
            }
            try {
                proxy.f5(this.f9972c, this.f9971b.a(), new ConnectionRequest(context.getPackageName(), Process.myPid(), bundle).b());
                return;
            } catch (RemoteException e2) {
                Log.i("MCImplBase", "Failed to call connection request.", e2);
            }
        } else {
            this.f9982m = new SessionServiceConnection(bundle);
            int i3 = Util.f5744a >= 29 ? 4097 : 1;
            Intent intent = new Intent("androidx.media3.session.MediaSessionService");
            intent.setClassName(sessionTokenImpl.V(), sessionTokenImpl.c());
            if (context.bindService(intent, this.f9982m, i3)) {
                return;
            }
            Log.h("MCImplBase", "bind to " + sessionToken + " failed");
        }
        MediaController mediaControllerO = o();
        MediaController mediaControllerO2 = o();
        Objects.requireNonNull(mediaControllerO2);
        mediaControllerO.l(new a0(mediaControllerO2, 2));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ListenableFuture d(SessionCommand sessionCommand) {
        IMediaSession iMediaSession;
        Bundle bundle = Bundle.EMPTY;
        s sVar = new s(this, sessionCommand);
        Assertions.a(sessionCommand.f10233a == 0);
        SessionCommands sessionCommands = this.r;
        sessionCommands.getClass();
        if (sessionCommands.f10238a.contains(sessionCommand)) {
            iMediaSession = this.z;
        } else {
            Log.h("MCImplBase", "Controller isn't allowed to call custom session command:" + sessionCommand.f10234b);
            iMediaSession = null;
        }
        return k(iMediaSession, sVar, false);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void d0(int i2) {
        if (t(15)) {
            l(new o(this, i2, 0));
            PlayerInfo playerInfo = this.o;
            if (playerInfo.f10175h != i2) {
                PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfo);
                builder.f10188h = i2;
                this.o = builder.a();
                r0 r0Var = new r0(i2, 6);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(8, r0Var);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void d1(int i2) {
        if (t(10)) {
            Assertions.a(i2 >= 0);
            l(new o(this, i2, 10));
            K(i2, -9223372036854775807L);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ImmutableList e() {
        return this.q;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void e0(Surface surface) {
        if (t(27)) {
            g();
            this.v = surface;
            m(new t(this, surface, 0));
            int i2 = surface == null ? 0 : -1;
            z(i2, i2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long e1() {
        return this.o.B;
    }

    public final void f(int i2, List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.o.f10177j.p()) {
            M(list, -1, -9223372036854775807L, false);
        } else {
            O(v(this.o, Math.min(i2, this.o.f10177j.o()), list, z1(), f1()), 0, null, null, this.o.f10177j.p() ? 3 : null);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean f0() {
        return this.o.f10170c.f10250b;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long f1() {
        SessionPositionInfo sessionPositionInfo = this.o.f10170c;
        return !sessionPositionInfo.f10250b ? z1() : sessionPositionInfo.f10249a.f5446g;
    }

    public final void g() {
        TextureView textureView = this.x;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.x = null;
        }
        SurfaceHolder surfaceHolder = this.w;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f9977h);
            this.w = null;
        }
        if (this.v != null) {
            this.v = null;
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long g0() {
        return this.o.f10170c.f10255g;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void g1(int i2, List list) {
        if (t(20)) {
            Assertions.a(i2 >= 0);
            l(new l(this, i2, list, 1));
            f(i2, list);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getDuration() {
        return this.o.f10170c.f10252d;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final float getVolume() {
        return this.o.n;
    }

    public final void h() {
        if (t(27)) {
            g();
            m(new i(this, 12));
            z(0, 0);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void h0() {
        if (t(20)) {
            l(new i(this, 2));
            I(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long h1() {
        return this.o.f10170c.f10253e;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int i0() {
        return this.o.f10170c.f10254f;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata i1() {
        return this.o.f10180m;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isConnected() {
        return this.z != null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void j0() {
        if (t(6)) {
            l(new i(this, 11));
            if (s() != -1) {
                K(s(), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean j1() {
        return this.o.v;
    }

    public final ListenableFuture k(IMediaSession iMediaSession, RemoteSessionTask remoteSessionTask, boolean z) {
        int iA;
        SequencedFutureManager.SequencedFuture sequencedFuture;
        if (iMediaSession == null) {
            return Futures.d(new SessionResult(-4));
        }
        SequencedFutureManager sequencedFutureManager = this.f9971b;
        SessionResult sessionResult = new SessionResult(1);
        synchronized (sequencedFutureManager.f10220a) {
            try {
                iA = sequencedFutureManager.a();
                sequencedFuture = new SequencedFutureManager.SequencedFuture(iA, sessionResult);
                if (sequencedFutureManager.f10225f) {
                    sequencedFuture.r();
                } else {
                    sequencedFutureManager.f10222c.put(Integer.valueOf(iA), sequencedFuture);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.f9980k.add(Integer.valueOf(iA));
        }
        try {
            remoteSessionTask.d(iMediaSession, iA);
            return sequencedFuture;
        } catch (RemoteException e2) {
            Log.i("MCImplBase", "Cannot connect to the service or the session is gone", e2);
            this.f9980k.remove(Integer.valueOf(iA));
            this.f9971b.c(iA, new SessionResult(-100));
            return sequencedFuture;
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void k0() {
        if (t(4)) {
            l(new i(this, 20));
            K(n(this.o), -9223372036854775807L);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void k1(final MediaItem mediaItem, final long j2) {
        if (t(31)) {
            l(new RemoteSessionTask() { // from class: androidx.media3.session.p
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void d(IMediaSession iMediaSession, int i2) {
                    MediaControllerImplBase mediaControllerImplBase = this.f10725a;
                    mediaControllerImplBase.getClass();
                    iMediaSession.b6(mediaControllerImplBase.f9972c, i2, mediaItem.c(true), j2);
                }
            });
            M(Collections.singletonList(mediaItem), -1, j2, false);
        }
    }

    public final void l(RemoteSessionTask remoteSessionTask) {
        FlushCommandQueueHandler flushCommandQueueHandler = this.f9979j;
        if (MediaControllerImplBase.this.z != null) {
            Handler handler = flushCommandQueueHandler.f9983a;
            if (!handler.hasMessages(1)) {
                handler.sendEmptyMessage(1);
            }
        }
        k(this.z, remoteSessionTask, true);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void l0(final int i2, final boolean z) {
        if (t(34)) {
            l(new RemoteSessionTask() { // from class: androidx.media3.session.b0
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void d(IMediaSession iMediaSession, int i3) {
                    iMediaSession.Cb(this.f10310a.f9972c, i3, z, i2);
                }
            });
            PlayerInfo playerInfo = this.o;
            if (playerInfo.s != z) {
                this.o = playerInfo.a(playerInfo.r, z);
                m mVar = new m(this, z, 1);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, mVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int l1() {
        return n(this.o);
    }

    public final void m(RemoteSessionTask remoteSessionTask) {
        FlushCommandQueueHandler flushCommandQueueHandler = this.f9979j;
        if (MediaControllerImplBase.this.z != null) {
            Handler handler = flushCommandQueueHandler.f9983a;
            if (!handler.hasMessages(1)) {
                handler.sendEmptyMessage(1);
            }
        }
        ListenableFuture listenableFutureK = k(this.z, remoteSessionTask, true);
        try {
            LegacyConversions.v(listenableFutureK);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2);
        } catch (TimeoutException e3) {
            if (listenableFutureK instanceof SequencedFutureManager.SequencedFuture) {
                int i2 = ((SequencedFutureManager.SequencedFuture) listenableFutureK).f10226h;
                this.f9980k.remove(Integer.valueOf(i2));
                this.f9971b.c(i2, new SessionResult(-1));
            }
            Log.i("MCImplBase", "Synchronous command takes too long on the session side.", e3);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void m0() {
        if (t(26)) {
            l(new i(this, 16));
            PlayerInfo playerInfo = this.o;
            int i2 = playerInfo.r - 1;
            if (i2 >= playerInfo.q.f5194b) {
                this.o = playerInfo.a(i2, playerInfo.s);
                o oVar = new o(this, i2, 9);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        if (t(29)) {
            l(new s(3, this, trackSelectionParameters));
            PlayerInfo playerInfo = this.o;
            if (trackSelectionParameters != playerInfo.E) {
                PlayerInfo.Builder builder = new PlayerInfo.Builder(playerInfo);
                builder.E = trackSelectionParameters;
                this.o = builder.a();
                s0 s0Var = new s0(trackSelectionParameters, 8);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(19, s0Var);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void n0(int i2) {
        if (t(34)) {
            l(new o(this, i2, 5));
            PlayerInfo playerInfo = this.o;
            int i3 = playerInfo.r + 1;
            int i4 = playerInfo.q.f5195c;
            if (i4 == 0 || i3 <= i4) {
                this.o = playerInfo.a(i3, playerInfo.s);
                o oVar = new o(this, i3, 6);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void n1(SurfaceView surfaceView) {
        if (t(27)) {
            SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
            if (t(27) && holder != null && this.w == holder) {
                h();
            }
        }
    }

    public MediaController o() {
        return this.f9970a;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void o0(SurfaceView surfaceView) {
        if (t(27)) {
            SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
            if (t(27)) {
                if (holder == null) {
                    h();
                    return;
                }
                if (this.w == holder) {
                    return;
                }
                g();
                this.w = holder;
                holder.addCallback(this.f9977h);
                Surface surface = holder.getSurface();
                if (surface == null || !surface.isValid()) {
                    this.v = null;
                    m(new i(this, 17));
                    z(0, 0);
                } else {
                    this.v = surface;
                    m(new t(this, surface, 1));
                    Rect surfaceFrame = holder.getSurfaceFrame();
                    z(surfaceFrame.width(), surfaceFrame.height());
                }
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void o1(int i2, int i3) {
        if (t(20)) {
            Assertions.a(i2 >= 0 && i3 >= 0);
            l(new y(this, i2, i3, 1));
            A(i2, i2 + 1, i3);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p() {
        if (t(2)) {
            l(new i(this, 8));
            PlayerInfo playerInfo = this.o;
            if (playerInfo.y == 1) {
                O(playerInfo.d(playerInfo.f10177j.p() ? 4 : 2, null), null, null, null, null);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p0(final int i2, final int i3, final List list) {
        if (t(20)) {
            Assertions.a(i2 >= 0 && i2 <= i3);
            l(new RemoteSessionTask() { // from class: androidx.media3.session.k
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void d(IMediaSession iMediaSession, int i4) {
                    MediaControllerImplBase mediaControllerImplBase = this.f10400a;
                    mediaControllerImplBase.getClass();
                    UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                    ImmutableList.Builder builder = new ImmutableList.Builder();
                    int i5 = 0;
                    while (true) {
                        List list2 = list;
                        if (i5 >= list2.size()) {
                            break;
                        }
                        builder.h(((MediaItem) list2.get(i5)).c(true));
                        i5++;
                    }
                    BundleListRetriever bundleListRetriever = new BundleListRetriever(builder.j());
                    SessionToken sessionToken = mediaControllerImplBase.f9981l;
                    sessionToken.getClass();
                    int iD = sessionToken.f10269a.d();
                    int i6 = i2;
                    int i7 = i3;
                    if (iD >= 2) {
                        iMediaSession.Da(mediaControllerImplBase.f9972c, i4, i6, i7, bundleListRetriever);
                        return;
                    }
                    MediaControllerStub mediaControllerStub = mediaControllerImplBase.f9972c;
                    iMediaSession.q8(mediaControllerStub, i4, i7, bundleListRetriever);
                    iMediaSession.u9(mediaControllerStub, i4, i6, i7);
                }
            });
            J(i2, i3, list);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void p1(final int i2, final int i3, final int i4) {
        if (t(20)) {
            Assertions.a(i2 >= 0 && i2 <= i3 && i4 >= 0);
            l(new RemoteSessionTask() { // from class: androidx.media3.session.c0
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void d(IMediaSession iMediaSession, int i5) {
                    iMediaSession.c8(this.f10326a.f9972c, i5, i2, i3, i4);
                }
            });
            A(i2, i3, i4);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void pause() {
        if (t(1)) {
            l(new i(this, 4));
            N(false);
        }
    }

    public final int q() {
        if (this.o.f10177j.p()) {
            return -1;
        }
        PlayerInfo playerInfo = this.o;
        Timeline timeline = playerInfo.f10177j;
        int iN = n(playerInfo);
        PlayerInfo playerInfo2 = this.o;
        int i2 = playerInfo2.f10175h;
        if (i2 == 1) {
            i2 = 0;
        }
        return timeline.e(iN, i2, playerInfo2.f10176i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void q0(MediaMetadata mediaMetadata) {
        if (t(19)) {
            l(new s(1, this, mediaMetadata));
            if (this.o.f10180m.equals(mediaMetadata)) {
                return;
            }
            PlayerInfo playerInfo = this.o;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo, playerInfo);
            builderE.f10193m = mediaMetadata;
            this.o = builderE.a();
            x1 x1Var = new x1(mediaMetadata);
            ListenerSet listenerSet = this.f9978i;
            listenerSet.c(15, x1Var);
            listenerSet.b();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void q1(List list) {
        if (t(20)) {
            l(new d0(this, list, 1));
            f(this.o.f10177j.o(), list);
        }
    }

    public final PeriodInfo r(Timeline timeline, int i2, long j2) {
        if (timeline.p()) {
            return null;
        }
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        if (i2 == -1 || i2 >= timeline.o()) {
            i2 = timeline.a(this.o.f10176i);
            j2 = Util.j0(timeline.m(i2, window, 0L).f5497l);
        }
        long jT = Util.T(j2);
        Assertions.c(i2, timeline.o());
        timeline.n(i2, window);
        if (jT == -9223372036854775807L) {
            jT = window.f5497l;
            if (jT == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = window.n;
        timeline.f(i3, period, false);
        while (i3 < window.o && period.f5479e != jT) {
            int i4 = i3 + 1;
            if (timeline.f(i4, period, false).f5479e > jT) {
                break;
            }
            i3 = i4;
        }
        timeline.f(i3, period, false);
        return new PeriodInfo(i3, jT - period.f5479e);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void r0(int i2) {
        if (t(20)) {
            Assertions.a(i2 >= 0);
            l(new o(this, i2, 11));
            I(i2, i2 + 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean r1() {
        return this.o.s;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void release() {
        IMediaSession iMediaSession = this.z;
        if (this.n) {
            return;
        }
        this.n = true;
        this.f9981l = null;
        FlushCommandQueueHandler flushCommandQueueHandler = this.f9979j;
        Handler handler = flushCommandQueueHandler.f9983a;
        if (handler.hasMessages(1)) {
            try {
                MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
                mediaControllerImplBase.z.s9(mediaControllerImplBase.f9972c);
            } catch (RemoteException unused) {
                Log.h("MCImplBase", "Error in sending flushCommandQueue");
            }
        }
        handler.removeCallbacksAndMessages(null);
        this.z = null;
        if (iMediaSession != null) {
            int iA = this.f9971b.a();
            try {
                iMediaSession.asBinder().unlinkToDeath(this.f9976g, 0);
                iMediaSession.o3(this.f9972c, iA);
            } catch (RemoteException unused2) {
            }
        }
        this.f9978i.d();
        SequencedFutureManager sequencedFutureManager = this.f9971b;
        a0 a0Var = new a0(this, 0);
        synchronized (sequencedFutureManager.f10220a) {
            try {
                Handler handlerO = Util.o(null);
                sequencedFutureManager.f10224e = handlerO;
                sequencedFutureManager.f10223d = a0Var;
                if (sequencedFutureManager.f10222c.isEmpty()) {
                    sequencedFutureManager.b();
                } else {
                    handlerO.postDelayed(new a0(sequencedFutureManager, 1), 30000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int s() {
        if (this.o.f10177j.p()) {
            return -1;
        }
        PlayerInfo playerInfo = this.o;
        Timeline timeline = playerInfo.f10177j;
        int iN = n(playerInfo);
        PlayerInfo playerInfo2 = this.o;
        int i2 = playerInfo2.f10175h;
        if (i2 == 1) {
            i2 = 0;
        }
        return timeline.k(iN, i2, playerInfo2.f10176i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void s0(int i2, int i3) {
        if (t(20)) {
            Assertions.a(i2 >= 0 && i3 >= i2);
            l(new y(this, i2, i3, 2));
            I(i2, i3);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean s1() {
        return this.o.f10176i;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void stop() {
        if (t(3)) {
            l(new i(this, 6));
            PlayerInfo playerInfo = this.o;
            SessionPositionInfo sessionPositionInfo = this.o.f10170c;
            Player.PositionInfo positionInfo = sessionPositionInfo.f10249a;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SessionPositionInfo sessionPositionInfo2 = this.o.f10170c;
            long j2 = sessionPositionInfo2.f10252d;
            long j3 = sessionPositionInfo2.f10249a.f5445f;
            int iB = MediaUtils.b(j3, j2);
            SessionPositionInfo sessionPositionInfo3 = this.o.f10170c;
            PlayerInfo playerInfoE = playerInfo.e(new SessionPositionInfo(positionInfo, sessionPositionInfo.f10250b, jElapsedRealtime, j2, j3, iB, 0L, sessionPositionInfo3.f10256h, sessionPositionInfo3.f10257i, sessionPositionInfo3.f10249a.f5445f));
            this.o = playerInfoE;
            if (playerInfoE.y != 1) {
                this.o = playerInfoE.d(1, playerInfoE.f10168a);
                f fVar = new f();
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(4, fVar);
                listenerSet.b();
            }
        }
    }

    public final boolean t(int i2) {
        if (this.u.a(i2)) {
            return true;
        }
        android.support.v4.media.a.r(i2, "Controller isn't allowed to call command= ", "MCImplBase");
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void t0() {
        if (t(7)) {
            l(new i(this, 1));
            Timeline timeline = this.o.f10177j;
            if (timeline.p() || f0()) {
                return;
            }
            boolean z = s() != -1;
            Timeline.Window windowM = timeline.m(n(this.o), new Timeline.Window(), 0L);
            if (windowM.f5494i && windowM.a()) {
                if (z) {
                    K(s(), -9223372036854775807L);
                }
            } else if (!z || z1() > this.o.C) {
                K(n(this.o), 0L);
            } else {
                K(s(), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long t1() {
        return this.o.f10170c.f10258j;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int u() {
        return this.o.y;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void u0(boolean z) {
        if (t(1)) {
            l(new m(this, z, 4));
            N(z);
        } else if (z) {
            Log.h("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void u1(int i2) {
        if (t(25)) {
            l(new o(this, i2, 7));
            PlayerInfo playerInfo = this.o;
            DeviceInfo deviceInfo = playerInfo.q;
            if (playerInfo.r == i2 || deviceInfo.f5194b > i2) {
                return;
            }
            int i3 = deviceInfo.f5195c;
            if (i3 == 0 || i2 <= i3) {
                this.o = playerInfo.a(i2, playerInfo.s);
                o oVar = new o(this, i2, 8);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void v0(MediaItem mediaItem) {
        if (t(31)) {
            l(new s(2, this, mediaItem));
            M(Collections.singletonList(mediaItem), -1, -9223372036854775807L, true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void v1() {
        if (t(12)) {
            l(new i(this, 13));
            L(this.o.B);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void w0() {
        if (t(8)) {
            l(new i(this, 15));
            if (q() != -1) {
                K(q(), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void w1() {
        if (t(11)) {
            l(new i(this, 3));
            L(-this.o.A);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void x0(int i2) {
        if (t(34)) {
            l(new o(this, i2, 1));
            PlayerInfo playerInfo = this.o;
            int i3 = playerInfo.r - 1;
            if (i3 >= playerInfo.q.f5194b) {
                this.o = playerInfo.a(i3, playerInfo.s);
                o oVar = new o(this, i3, 2);
                ListenerSet listenerSet = this.f9978i;
                listenerSet.c(30, oVar);
                listenerSet.b();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata x1() {
        return this.o.z;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Tracks y0() {
        return this.o.D;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void y1(List list) {
        if (t(20)) {
            l(new d0(this, list, 0));
            M(list, -1, -9223372036854775807L, true);
        }
    }

    public final void z(int i2, int i3) {
        Size size = this.y;
        if (size.f5731a == i2 && size.f5732b == i3) {
            return;
        }
        this.y = new Size(i2, i3);
        this.f9978i.f(24, new v1(i2, i3, 2));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final CueGroup z0() {
        return this.o.p;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long z1() {
        long jC = MediaUtils.c(this.o, this.A, this.B, o().f9959f);
        this.A = jC;
        return jC;
    }
}
