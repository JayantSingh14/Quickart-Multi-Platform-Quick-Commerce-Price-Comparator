package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.PlayerInfo.InProcessBinder;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
final class MediaSessionStub extends IMediaSession.Stub {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f10157h = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f10158b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaSessionManager f10159c;

    /* renamed from: d, reason: collision with root package name */
    public final ConnectedControllersManager f10160d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f10161e = Collections.synchronizedSet(new HashSet());

    /* renamed from: f, reason: collision with root package name */
    public ImmutableBiMap f10162f = ImmutableBiMap.p();

    /* renamed from: g, reason: collision with root package name */
    public int f10163g;

    public static final class Controller2Cb implements MediaSession.ControllerCb {

        /* renamed from: a, reason: collision with root package name */
        public final IMediaController f10164a;

        public Controller2Cb(IMediaController iMediaController) {
            this.f10164a = iMediaController;
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void D() {
            this.f10164a.D();
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void S0(int i2) {
            this.f10164a.S0(i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void a(int i2, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i3) {
            this.f10164a.T8(i2, sessionPositionInfo.a(z, z2).c(i3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            if (r3 != 4) goto L25;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.session.MediaSession.ControllerCb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(int r9, androidx.media3.session.LibraryResult r10) {
            /*
                r8 = this;
                r0 = 1
                android.os.Bundle r1 = new android.os.Bundle
                r1.<init>()
                java.lang.String r2 = androidx.media3.session.LibraryResult.f9941g
                int r3 = r10.f9947a
                r1.putInt(r2, r3)
                java.lang.String r2 = androidx.media3.session.LibraryResult.f9942h
                long r3 = r10.f9948b
                r1.putLong(r2, r3)
                androidx.media3.session.MediaLibraryService$LibraryParams r2 = r10.f9951e
                if (r2 == 0) goto L21
                android.os.Bundle r2 = r2.b()
                java.lang.String r3 = androidx.media3.session.LibraryResult.f9943i
                r1.putBundle(r3, r2)
            L21:
                androidx.media3.session.SessionError r2 = r10.f9952f
                if (r2 == 0) goto L2e
                android.os.Bundle r2 = r2.b()
                java.lang.String r3 = androidx.media3.session.LibraryResult.f9946l
                r1.putBundle(r3, r2)
            L2e:
                java.lang.String r2 = androidx.media3.session.LibraryResult.f9945k
                int r3 = r10.f9950d
                r1.putInt(r2, r3)
                java.lang.Object r10 = r10.f9949c
                if (r10 != 0) goto L3a
                goto L7e
            L3a:
                if (r3 == r0) goto L84
                java.lang.String r2 = androidx.media3.session.LibraryResult.f9944j
                r4 = 2
                r5 = 0
                if (r3 == r4) goto L75
                r4 = 3
                if (r3 == r4) goto L49
                r10 = 4
                if (r3 == r10) goto L84
                goto L7e
            L49:
                androidx.media3.common.BundleListRetriever r3 = new androidx.media3.common.BundleListRetriever
                com.google.common.collect.ImmutableList r10 = (com.google.common.collect.ImmutableList) r10
                com.google.common.collect.UnmodifiableListIterator r4 = com.google.common.collect.ImmutableList.f42665b
                com.google.common.collect.ImmutableList$Builder r4 = new com.google.common.collect.ImmutableList$Builder
                r4.<init>()
                r6 = r5
            L55:
                int r7 = r10.size()
                if (r6 >= r7) goto L6a
                java.lang.Object r7 = r10.get(r6)
                androidx.media3.common.MediaItem r7 = (androidx.media3.common.MediaItem) r7
                android.os.Bundle r7 = r7.c(r5)
                r4.h(r7)
                int r6 = r6 + r0
                goto L55
            L6a:
                com.google.common.collect.ImmutableList r10 = r4.j()
                r3.<init>(r10)
                r1.putBinder(r2, r3)
                goto L7e
            L75:
                androidx.media3.common.MediaItem r10 = (androidx.media3.common.MediaItem) r10
                android.os.Bundle r10 = r10.c(r5)
                r1.putBundle(r2, r10)
            L7e:
                androidx.media3.session.IMediaController r10 = r8.f10164a
                r10.y4(r9, r1)
                return
            L84:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionStub.Controller2Cb.b(int, androidx.media3.session.LibraryResult):void");
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void c(int i2, String str, MediaLibraryService.LibraryParams libraryParams) {
            this.f10164a.Ab(i2, str, Api.BaseClientBuilder.API_PRIORITY_OTHER, libraryParams == null ? null : libraryParams.b());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void d(int i2, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i3) {
            Bundle bundleJ;
            Assertions.g(i3 != 0);
            boolean z3 = z || !commands.a(17);
            boolean z4 = z2 || !commands.a(30);
            IMediaController iMediaController = this.f10164a;
            if (i3 < 2) {
                iMediaController.ub(i2, playerInfo.g(commands, z, true).j(i3), z3);
                return;
            }
            PlayerInfo playerInfoG = playerInfo.g(commands, z, z2);
            if (iMediaController instanceof MediaControllerStub) {
                bundleJ = new Bundle();
                bundleJ.putBinder(PlayerInfo.l0, playerInfoG.new InProcessBinder());
            } else {
                bundleJ = playerInfoG.j(i3);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(PlayerInfo.BundlingExclusions.f10195d, z3);
            bundle.putBoolean(PlayerInfo.BundlingExclusions.f10196e, z4);
            iMediaController.j9(i2, bundleJ, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void e(int i2, Player.Commands commands) {
            this.f10164a.N8(i2, commands.c());
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Controller2Cb.class) {
                return false;
            }
            return Util.a(this.f10164a.asBinder(), ((Controller2Cb) obj).f10164a.asBinder());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void f(int i2, SessionResult sessionResult) {
            this.f10164a.I6(i2, sessionResult.b());
        }

        public final int hashCode() {
            return Objects.hash(this.f10164a.asBinder());
        }
    }

    public interface ControllerPlayerTask {
        void b(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo);
    }

    public interface MediaItemPlayerTask {
        void e(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list);
    }

    public interface MediaItemsWithStartPositionPlayerTask {
        void b(PlayerWrapper playerWrapper, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition);
    }

    public interface SessionTask<T, K extends MediaSessionImpl> {
        Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2);
    }

    public MediaSessionStub(MediaSessionImpl mediaSessionImpl) {
        this.f10158b = new WeakReference(mediaSessionImpl);
        this.f10159c = MediaSessionManager.a(mediaSessionImpl.f10096f);
        this.f10160d = new ConnectedControllersManager(mediaSessionImpl);
    }

    public static void A4(MediaSession.ControllerInfo controllerInfo, int i2, SessionResult sessionResult) {
        try {
            MediaSession.ControllerCb controllerCb = controllerInfo.f10086e;
            Assertions.h(controllerCb);
            controllerCb.f(i2, sessionResult);
        } catch (RemoteException e2) {
            Log.i("MediaSessionStub", "Failed to send result to controller " + controllerInfo, e2);
        }
    }

    public static s0 i5(Consumer consumer) {
        return new s0(new s0(consumer, 7), 6);
    }

    public static ListenableFuture w1(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2, SessionTask sessionTask, Consumer consumer) {
        if (mediaSessionImpl.j()) {
            return Futures.e();
        }
        ListenableFuture listenableFuture = (ListenableFuture) sessionTask.c(mediaSessionImpl, controllerInfo, i2);
        SettableFuture settableFuture = new SettableFuture();
        listenableFuture.q(new d(mediaSessionImpl, settableFuture, consumer, listenableFuture, 8), MoreExecutors.a());
        return settableFuture;
    }

    @Override // androidx.media3.session.IMediaSession
    public final void A6(IMediaController iMediaController, int i2, Bundle bundle) {
        ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord;
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            SessionResult sessionResultA = SessionResult.a(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                ConnectedControllersManager connectedControllersManager = this.f10160d;
                IBinder iBinderAsBinder = iMediaController.asBinder();
                synchronized (connectedControllersManager.f9885a) {
                    try {
                        MediaSession.ControllerInfo controllerInfoG = connectedControllersManager.g(iBinderAsBinder);
                        connectedControllerRecord = controllerInfoG != null ? (ConnectedControllersManager.ConnectedControllerRecord) connectedControllersManager.f9887c.get(controllerInfoG) : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                SequencedFutureManager sequencedFutureManager = connectedControllerRecord != null ? connectedControllerRecord.f9890b : null;
                if (sequencedFutureManager == null) {
                    return;
                }
                sequencedFutureManager.c(i2, sessionResultA);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void B6(IMediaController iMediaController, int i2, int i3, int i4) {
        if (iMediaController == null || i3 < 0 || i4 < 0) {
            return;
        }
        y3(iMediaController, i2, 20, i5(new v1(i3, i4, 1)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Cb(IMediaController iMediaController, int i2, final boolean z, final int i3) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 34, i5(new Consumer() { // from class: androidx.media3.session.w1
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                int i4 = MediaSessionStub.f10157h;
                ((PlayerWrapper) obj).l0(i3, z);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.IMediaSession
    public final void Da(IMediaController iMediaController, int i2, int i3, int i4, IBinder iBinder) {
        int i5 = 1;
        if (iMediaController == null || iBinder == null || i3 < 0 || i4 < i3) {
            return;
        }
        try {
            ImmutableList immutableListA = BundleListRetriever.a(iBinder);
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i6 = 0; i6 < immutableListA.size(); i6++) {
                Bundle bundle = (Bundle) immutableListA.get(i6);
                bundle.getClass();
                builder.h(MediaItem.b(bundle));
            }
            y3(iMediaController, i2, 20, new b2(new s(14, new s0(builder.j(), 3), new m1(this, i3, i4)), i5));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void E6(IMediaController iMediaController, int i2, float f2) {
        if (iMediaController == null || f2 <= 0.0f) {
            return;
        }
        y3(iMediaController, i2, 13, i5(new p1(f2, 0)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void F1(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 26, i5(new o0(10)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void F6(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
        if (iMediaController == null || bundle == null || i3 < 0) {
            return;
        }
        try {
            y3(iMediaController, i2, 20, new b2(new s(14, new q1(1, MediaItem.b(bundle)), new n1(this, i3, 2)), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Hb(IMediaController iMediaController, int i2, Bundle bundle, Bundle bundle2) {
        if (iMediaController == null || bundle == null || bundle2 == null) {
            return;
        }
        try {
            SessionCommand sessionCommandA = SessionCommand.a(bundle);
            z0(iMediaController, i2, sessionCommandA, 0, new b2(new s(10, sessionCommandA, bundle2), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for SessionCommand", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Ia(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 1, i5(new s(11, this, controllerInfoG)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void K1(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 1, i5(new o0(8)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.IMediaSession
    public final void Kb(IMediaController iMediaController, int i2, IBinder iBinder, int i3, long j2) {
        int i4 = 1;
        if (iMediaController == null || iBinder == null) {
            return;
        }
        if (i3 == -1 || i3 >= 0) {
            try {
                ImmutableList immutableListA = BundleListRetriever.a(iBinder);
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (int i5 = 0; i5 < immutableListA.size(); i5++) {
                    Bundle bundle = (Bundle) immutableListA.get(i5);
                    bundle.getClass();
                    builder.h(MediaItem.b(bundle));
                }
                y3(iMediaController, i2, 20, new b2(new s(13, new n(builder.j(), i3, j2), new o0(26)), i4));
            } catch (RuntimeException e2) {
                Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
            }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void La(IMediaController iMediaController, int i2, boolean z) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 1, i5(new o1(z, 0)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void M5(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 4, i5(new o0(23)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.IMediaSession
    public final void N6(IMediaController iMediaController, int i2, IBinder iBinder) {
        int i3 = 1;
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            ImmutableList immutableListA = BundleListRetriever.a(iBinder);
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i4 = 0; i4 < immutableListA.size(); i4++) {
                Bundle bundle = (Bundle) immutableListA.get(i4);
                bundle.getClass();
                builder.h(MediaItem.b(bundle));
            }
            y3(iMediaController, i2, 20, new b2(new s(14, new t1(builder.j(), i3), new o0(18)), i3));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void O8(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 2, i5(new o0(22)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Q3(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 35, i5(new s1(AudioAttributes.a(bundle), z, 1)));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for AudioAttributes", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Qa(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 34, i5(new r0(i3, 2)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Sb(IMediaController iMediaController, int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 29, i5(new s(9, this, TrackSelectionParameters.b(bundle))));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for TrackSelectionParameters", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void T5(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 34, i5(new r0(i3, 1)));
    }

    public final int V2(MediaSession.ControllerInfo controllerInfo, PlayerWrapper playerWrapper, int i2) {
        if (!playerWrapper.D1(17)) {
            return i2;
        }
        ConnectedControllersManager connectedControllersManager = this.f10160d;
        return (connectedControllersManager.j(controllerInfo, 17) || !connectedControllersManager.j(controllerInfo, 16)) ? i2 : i2 + playerWrapper.l1();
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Va(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 11, i5(new o0(11)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void W7(IMediaController iMediaController, int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 13, i5(new r1(new PlaybackParameters(bundle.getFloat(PlaybackParameters.f5425e, 1.0f), bundle.getFloat(PlaybackParameters.f5426f, 1.0f)), 0)));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for PlaybackParameters", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void Z3(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null || i3 < 0) {
            return;
        }
        y3(iMediaController, i2, 25, i5(new r0(i3, 5)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void a7(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
        if (iMediaController == null || bundle == null || i3 < 0) {
            return;
        }
        try {
            y3(iMediaController, i2, 20, new b2(new s(14, new q1(0, MediaItem.b(bundle)), new n1(this, i3, 1)), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void b6(IMediaController iMediaController, int i2, Bundle bundle, long j2) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 31, new b2(new s(13, new w(j2, MediaItem.b(bundle)), new o0(26)), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void b7(IMediaController iMediaController, int i2, int i3, int i4) {
        if (iMediaController == null || i3 < 0) {
            return;
        }
        y3(iMediaController, i2, 33, i5(new v1(i3, i4, 0)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void c8(IMediaController iMediaController, int i2, final int i3, final int i4, final int i5) {
        if (iMediaController == null || i3 < 0 || i4 < i3 || i5 < 0) {
            return;
        }
        y3(iMediaController, i2, 20, i5(new Consumer() { // from class: androidx.media3.session.u1
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                int i6 = MediaSessionStub.f10157h;
                ((PlayerWrapper) obj).p1(i3, i4, i5);
            }
        }));
    }

    public final void d4(final MediaSession.ControllerInfo controllerInfo, final int i2, final int i3, final SessionTask sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10158b.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.j()) {
                Util.X(mediaSessionImpl.f10102l, new Runnable() { // from class: androidx.media3.session.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectedControllersManager connectedControllersManager = this.f10302a.f10160d;
                        final MediaSession.ControllerInfo controllerInfo2 = controllerInfo;
                        int i4 = i3;
                        boolean zJ = connectedControllersManager.j(controllerInfo2, i4);
                        final int i5 = i2;
                        if (!zJ) {
                            MediaSessionStub.A4(controllerInfo2, i5, new SessionResult(-4));
                            return;
                        }
                        final MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
                        mediaSessionImpl2.u(controllerInfo2);
                        mediaSessionImpl2.f10095e.getClass();
                        final MediaSessionStub.SessionTask sessionTask2 = sessionTask;
                        if (i4 != 27) {
                            connectedControllersManager.b(controllerInfo2, i4, new ConnectedControllersManager.AsyncCommand() { // from class: androidx.media3.session.f2
                                @Override // androidx.media3.session.ConnectedControllersManager.AsyncCommand
                                public final ListenableFuture run() {
                                    int i6 = MediaSessionStub.f10157h;
                                    return (ListenableFuture) sessionTask2.c(mediaSessionImpl2, controllerInfo2, i5);
                                }
                            });
                            return;
                        }
                        int i6 = MediaSessionImpl.B;
                        int i7 = MediaSessionStub.f10157h;
                        sessionTask2.c(mediaSessionImpl2, controllerInfo2, i5);
                        connectedControllersManager.b(controllerInfo2, i4, new e2());
                    }
                });
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void d7(IMediaController iMediaController, int i2, boolean z) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 26, i5(new o1(z, 1)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void ea(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 31, new b2(new s(13, new s1(MediaItem.b(bundle), z, 0), new o0(26)), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void f5(IMediaController iMediaController, int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            ConnectionRequest connectionRequestA = ConnectionRequest.a(bundle);
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            if (callingPid == 0) {
                callingPid = connectionRequestA.f9904d;
            }
            try {
                MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequestA.f9903c, callingPid, callingUid);
                g(iMediaController, new MediaSession.ControllerInfo(remoteUserInfo, connectionRequestA.f9901a, connectionRequestA.f9902b, this.f10159c.b(remoteUserInfo), new Controller2Cb(iMediaController), connectionRequestA.f9905e));
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for ConnectionRequest", e2);
        }
    }

    public final void g(IMediaController iMediaController, MediaSession.ControllerInfo controllerInfo) {
        if (iMediaController != null) {
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10158b.get();
            if (mediaSessionImpl == null || mediaSessionImpl.j()) {
                try {
                    iMediaController.D();
                } catch (RemoteException unused) {
                }
            } else {
                this.f10161e.add(controllerInfo);
                Util.X(mediaSessionImpl.f10102l, new d(this, controllerInfo, mediaSessionImpl, iMediaController, 7));
            }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void g6(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null || i3 < 0) {
            return;
        }
        y3(iMediaController, i2, 20, new s0(new n1(this, i3, 4), 6));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void ga(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 3, i5(new o0(21)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void h6(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 8, i5(new o0(9)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void h7(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null || i3 < 0) {
            return;
        }
        y3(iMediaController, i2, 10, new s0(new n1(this, i3, 0), 6));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void i6(IMediaController iMediaController, int i2, final long j2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 5, i5(new Consumer() { // from class: androidx.media3.session.y1
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                int i3 = MediaSessionStub.f10157h;
                ((PlayerWrapper) obj).X(j2);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PlayerInfo j1(PlayerInfo playerInfo) {
        ImmutableList immutableList = playerInfo.D.f5548a;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableBiMap.Builder builder2 = new ImmutableBiMap.Builder();
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Tracks.Group group = (Tracks.Group) immutableList.get(i2);
            TrackGroup trackGroup = group.f5554b;
            String string = (String) this.f10162f.get(trackGroup);
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                int i3 = this.f10163g;
                this.f10163g = i3 + 1;
                int i4 = Util.f5744a;
                sb.append(Integer.toString(i3, 36));
                sb.append("-");
                sb.append(trackGroup.f5502b);
                string = sb.toString();
            }
            builder2.g(trackGroup, string);
            builder.h(new Tracks.Group(new TrackGroup(string, group.f5554b.f5504d), group.f5555c, group.f5556d, group.f5557e));
        }
        this.f10162f = builder2.b();
        Tracks tracks = new Tracks(builder.j());
        PlayerInfo.Builder builder3 = new PlayerInfo.Builder(playerInfo);
        builder3.D = tracks;
        PlayerInfo playerInfoA = builder3.a();
        TrackSelectionParameters trackSelectionParameters = playerInfoA.E;
        if (trackSelectionParameters.A.isEmpty()) {
            return playerInfoA;
        }
        TrackSelectionParameters.Builder builderC = trackSelectionParameters.a().c();
        UnmodifiableIterator it = trackSelectionParameters.A.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) it.next();
            TrackGroup trackGroup2 = trackSelectionOverride.f5508a;
            String str = (String) this.f10162f.get(trackGroup2);
            if (str != null) {
                builderC.a(new TrackSelectionOverride(new TrackGroup(str, trackGroup2.f5504d), trackSelectionOverride.f5509b));
            } else {
                builderC.a(trackSelectionOverride);
            }
        }
        TrackSelectionParameters trackSelectionParametersB = builderC.b();
        PlayerInfo.Builder builder4 = new PlayerInfo.Builder(playerInfoA);
        builder4.E = trackSelectionParametersB;
        return builder4.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.IMediaSession
    public final void j4(IMediaController iMediaController, int i2, IBinder iBinder, boolean z) {
        int i3 = 1;
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            ImmutableList immutableListA = BundleListRetriever.a(iBinder);
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i4 = 0; i4 < immutableListA.size(); i4++) {
                Bundle bundle = (Bundle) immutableListA.get(i4);
                bundle.getClass();
                builder.h(MediaItem.b(bundle));
            }
            y3(iMediaController, i2, 20, new b2(new s(13, new s1(builder.j(), z, 2), new o0(26)), i3));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void j8(IMediaController iMediaController, int i2, Surface surface) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 27, i5(new s0(surface, 4)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void l4(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 6, i5(new o0(13)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void o3(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10158b.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.j()) {
                Util.X(mediaSessionImpl.f10102l, new l0(11, this, iMediaController));
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void q3(IMediaController iMediaController, int i2, boolean z) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 14, i5(new o1(z, 2)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void q7(IMediaController iMediaController, int i2, int i3, long j2) {
        if (iMediaController == null || i3 < 0) {
            return;
        }
        y3(iMediaController, i2, 10, new s0(new n(this, i3, j2), 6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.IMediaSession
    public final void q8(IMediaController iMediaController, int i2, int i3, IBinder iBinder) {
        int i4 = 1;
        int i5 = 0;
        if (iMediaController == null || iBinder == null || i3 < 0) {
            return;
        }
        try {
            ImmutableList immutableListA = BundleListRetriever.a(iBinder);
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i6 = 0; i6 < immutableListA.size(); i6++) {
                Bundle bundle = (Bundle) immutableListA.get(i6);
                bundle.getClass();
                builder.h(MediaItem.b(bundle));
            }
            y3(iMediaController, i2, 20, new b2(new s(14, new t1(builder.j(), i5), new n1(this, i3, 3)), i4));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void qb(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 26, i5(new o0(19)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void s4(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 9, i5(new o0(16)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void s9(IMediaController iMediaController) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10158b.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.j()) {
                MediaSession.ControllerInfo controllerInfoG = this.f10160d.g(iMediaController.asBinder());
                if (controllerInfoG != null) {
                    Util.X(mediaSessionImpl.f10102l, new l0(12, this, controllerInfoG));
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void t7(IMediaController iMediaController, int i2, int i3) {
        if (iMediaController == null) {
            return;
        }
        if (i3 == 2 || i3 == 0 || i3 == 1) {
            y3(iMediaController, i2, 15, i5(new r0(i3, 3)));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void t8(IMediaController iMediaController, int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            y3(iMediaController, i2, 19, i5(new x1(MediaMetadata.b(bundle))));
        } catch (RuntimeException e2) {
            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaMetadata", e2);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void u2(IMediaController iMediaController, int i2) {
        if (iMediaController == null) {
            return;
        }
        y3(iMediaController, i2, 20, i5(new o0(24)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void u9(IMediaController iMediaController, int i2, int i3, int i4) {
        if (iMediaController == null || i3 < 0 || i4 < i3) {
            return;
        }
        y3(iMediaController, i2, 20, new s0(new m1(this, i3, i4), 6));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void v5(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 7, i5(new o0(12)));
    }

    public final void y3(IMediaController iMediaController, int i2, int i3, SessionTask sessionTask) {
        MediaSession.ControllerInfo controllerInfoG = this.f10160d.g(iMediaController.asBinder());
        if (controllerInfoG != null) {
            d4(controllerInfoG, i2, i3, sessionTask);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void y6(IMediaController iMediaController, int i2, float f2) {
        if (iMediaController == null || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        y3(iMediaController, i2, 24, i5(new p1(f2, 1)));
    }

    public final void z0(IMediaController iMediaController, final int i2, final SessionCommand sessionCommand, final int i3, final SessionTask sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10158b.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.j()) {
                final MediaSession.ControllerInfo controllerInfoG = this.f10160d.g(iMediaController.asBinder());
                if (controllerInfoG == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    Util.X(mediaSessionImpl.f10102l, new Runnable() { // from class: androidx.media3.session.z1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectedControllersManager connectedControllersManager = this.f10810a.f10160d;
                            MediaSession.ControllerInfo controllerInfo = controllerInfoG;
                            if (connectedControllersManager.i(controllerInfo)) {
                                SessionCommand sessionCommand2 = sessionCommand;
                                int i4 = i2;
                                if (sessionCommand2 != null) {
                                    if (!connectedControllersManager.l(controllerInfo, sessionCommand2)) {
                                        MediaSessionStub.A4(controllerInfo, i4, new SessionResult(-4));
                                        return;
                                    }
                                } else if (!connectedControllersManager.k(controllerInfo, i3)) {
                                    MediaSessionStub.A4(controllerInfo, i4, new SessionResult(-4));
                                    return;
                                }
                                sessionTask.c(mediaSessionImpl, controllerInfo, i4);
                            }
                        }
                    });
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void za(IMediaController iMediaController, int i2) {
        MediaSession.ControllerInfo controllerInfoG;
        if (iMediaController == null || (controllerInfoG = this.f10160d.g(iMediaController.asBinder())) == null) {
            return;
        }
        d4(controllerInfoG, i2, 12, i5(new o0(15)));
    }
}
