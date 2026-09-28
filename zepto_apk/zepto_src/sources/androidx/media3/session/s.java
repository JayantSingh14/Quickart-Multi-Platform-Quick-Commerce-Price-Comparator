package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class s implements MediaControllerImplBase.RemoteSessionTask, ListenerSet.Event, MediaControllerStub.ControllerTask, MediaSessionLegacyStub.SessionTask, Consumer, MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10747c;

    public /* synthetic */ s(int i2, Object obj, Object obj2) {
        this.f10745a = i2;
        this.f10746b = obj;
        this.f10747c = obj2;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        PlayerInfo.BundlingExclusions bundlingExclusions;
        boolean z;
        boolean z2;
        Object obj = this.f10746b;
        Object obj2 = this.f10747c;
        switch (this.f10745a) {
            case 6:
                int i2 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected()) {
                    PlayerInfo playerInfo = mediaControllerImplBase.C;
                    PlayerInfo.BundlingExclusions bundlingExclusions2 = (PlayerInfo.BundlingExclusions) obj2;
                    PlayerInfo playerInfo2 = (PlayerInfo) obj;
                    if (playerInfo != null && (bundlingExclusions = mediaControllerImplBase.D) != null) {
                        Pair pairE = MediaUtils.e(playerInfo, bundlingExclusions, playerInfo2, bundlingExclusions2, mediaControllerImplBase.u);
                        PlayerInfo playerInfo3 = (PlayerInfo) pairE.first;
                        bundlingExclusions2 = (PlayerInfo.BundlingExclusions) pairE.second;
                        playerInfo2 = playerInfo3;
                    }
                    mediaControllerImplBase.C = null;
                    mediaControllerImplBase.D = null;
                    if (!mediaControllerImplBase.f9980k.isEmpty()) {
                        mediaControllerImplBase.C = playerInfo2;
                        mediaControllerImplBase.D = bundlingExclusions2;
                        break;
                    } else {
                        PlayerInfo playerInfo4 = mediaControllerImplBase.o;
                        PlayerInfo playerInfo5 = (PlayerInfo) MediaUtils.e(playerInfo4, PlayerInfo.BundlingExclusions.f10194c, playerInfo2, bundlingExclusions2, mediaControllerImplBase.u).first;
                        mediaControllerImplBase.o = playerInfo5;
                        Integer numValueOf = (playerInfo4.f10171d.equals(playerInfo2.f10171d) && playerInfo4.f10172e.equals(playerInfo2.f10172e)) ? null : Integer.valueOf(playerInfo5.f10173f);
                        Integer numValueOf2 = !Util.a(playerInfo4.i(), playerInfo5.i()) ? Integer.valueOf(playerInfo5.f10169b) : null;
                        Integer numValueOf3 = !playerInfo4.f10177j.equals(playerInfo5.f10177j) ? Integer.valueOf(playerInfo5.f10178k) : null;
                        int i3 = playerInfo4.u;
                        int i4 = playerInfo5.u;
                        mediaControllerImplBase.B(playerInfo4, playerInfo5, numValueOf3, (i3 == i4 && playerInfo4.t == playerInfo5.t) ? null : Integer.valueOf(i4), numValueOf, numValueOf2);
                        break;
                    }
                }
                break;
            default:
                int i5 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected()) {
                    Player.Commands commands = (Player.Commands) obj2;
                    boolean zA = Util.a(mediaControllerImplBase.s, commands);
                    SessionCommands sessionCommands = (SessionCommands) obj;
                    boolean zA2 = Util.a(mediaControllerImplBase.r, sessionCommands);
                    if (!zA || !zA2) {
                        mediaControllerImplBase.r = sessionCommands;
                        if (zA) {
                            z = false;
                        } else {
                            mediaControllerImplBase.s = commands;
                            Player.Commands commands2 = mediaControllerImplBase.u;
                            Player.Commands commandsI = MediaControllerImplBase.i(commands, mediaControllerImplBase.t);
                            mediaControllerImplBase.u = commandsI;
                            z = !commandsI.equals(commands2);
                        }
                        if (!zA2 || z) {
                            ImmutableList immutableList = mediaControllerImplBase.q;
                            ImmutableList immutableListA = CommandButton.a(mediaControllerImplBase.p, sessionCommands, mediaControllerImplBase.u);
                            mediaControllerImplBase.q = immutableListA;
                            z2 = !immutableListA.equals(immutableList);
                        } else {
                            z2 = false;
                        }
                        if (z) {
                            mediaControllerImplBase.f9978i.f(13, new i(mediaControllerImplBase, 18));
                        }
                        if (!zA2) {
                            MediaController mediaControllerO = mediaControllerImplBase.o();
                            mediaControllerO.getClass();
                            Assertions.g(Looper.myLooper() == mediaControllerO.f9958e.getLooper());
                            mediaControllerO.f9957d.C();
                        }
                        if (z2) {
                            MediaController mediaControllerO2 = mediaControllerImplBase.o();
                            mediaControllerO2.getClass();
                            Assertions.g(Looper.myLooper() == mediaControllerO2.f9958e.getLooper());
                            mediaControllerO2.f9957d.h();
                            break;
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        Object obj2 = this.f10747c;
        Object obj3 = this.f10746b;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10745a) {
            case 9:
                int i2 = MediaSessionStub.f10157h;
                MediaSessionStub mediaSessionStub = (MediaSessionStub) obj3;
                mediaSessionStub.getClass();
                TrackSelectionParameters trackSelectionParametersB = (TrackSelectionParameters) obj2;
                ImmutableMap immutableMap = trackSelectionParametersB.A;
                if (!immutableMap.isEmpty()) {
                    TrackSelectionParameters.Builder builderC = trackSelectionParametersB.a().c();
                    UnmodifiableIterator it = immutableMap.values().iterator();
                    while (it.hasNext()) {
                        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) it.next();
                        TrackGroup trackGroup = (TrackGroup) mediaSessionStub.f10162f.o().get(trackSelectionOverride.f5508a.f5502b);
                        if (trackGroup == null || trackSelectionOverride.f5508a.f5501a != trackGroup.f5501a) {
                            builderC.a(trackSelectionOverride);
                        } else {
                            builderC.a(new TrackSelectionOverride(trackGroup, trackSelectionOverride.f5509b));
                        }
                    }
                    trackSelectionParametersB = builderC.b();
                }
                playerWrapper.m1(trackSelectionParametersB);
                break;
            default:
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) ((MediaSessionStub) obj3).f10158b.get();
                if (mediaSessionImpl != null && !mediaSessionImpl.j()) {
                    mediaSessionImpl.g((MediaSession.ControllerInfo) obj2, false);
                    break;
                }
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionLegacyStub.r;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f10746b;
        mediaSessionLegacyStub.getClass();
        String str = ((MediaDescriptionCompat) this.f10747c).f10587a;
        if (TextUtils.isEmpty(str)) {
            Log.h("MediaSessionLegacyStub", "onRemoveQueueItem(): Media ID shouldn't be null");
            return;
        }
        PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
        if (!playerWrapper.D1(17)) {
            Log.h("MediaSessionLegacyStub", "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
            return;
        }
        Timeline timelineF0 = playerWrapper.F0();
        Timeline.Window window = new Timeline.Window();
        for (int i3 = 0; i3 < timelineF0.o(); i3++) {
            if (TextUtils.equals(timelineF0.m(i3, window, 0L).f5488c.f5257a, str)) {
                playerWrapper.r0(i3);
                return;
            }
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(final MediaSessionImpl mediaSessionImpl, final MediaSession.ControllerInfo controllerInfo, int i2) {
        Object obj = this.f10747c;
        Object obj2 = this.f10746b;
        switch (this.f10745a) {
            case 10:
                int i3 = MediaSessionStub.f10157h;
                return mediaSessionImpl.n(controllerInfo, (SessionCommand) obj2, (Bundle) obj);
            case 11:
            default:
                int i4 = MediaSessionStub.f10157h;
                if (mediaSessionImpl.j()) {
                    return Futures.d(new SessionResult(-100));
                }
                ListenableFuture listenableFuture = (ListenableFuture) ((MediaSessionStub.SessionTask) obj2).c(mediaSessionImpl, controllerInfo, i2);
                final MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask = (MediaSessionStub.MediaItemPlayerTask) obj;
                final int i5 = 1;
                return Util.i0(listenableFuture, new AsyncFunction() { // from class: androidx.media3.session.d2
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final ListenableFuture apply(Object obj3) {
                        Object obj4 = mediaItemPlayerTask;
                        switch (i5) {
                            case 0:
                                int i6 = MediaSessionStub.f10157h;
                                MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
                                Handler handler = mediaSessionImpl2.f10102l;
                                l0 l0Var = new l0(mediaSessionImpl2, controllerInfo, new v0(mediaSessionImpl2, (MediaSessionStub.MediaItemsWithStartPositionPlayerTask) obj4, (MediaSession.MediaItemsWithStartPosition) obj3, 8));
                                SessionResult sessionResult = new SessionResult(0);
                                int i7 = Util.f5744a;
                                SettableFuture settableFutureR = SettableFuture.r();
                                Util.X(handler, new androidx.media3.common.util.e(settableFutureR, l0Var, sessionResult));
                                return settableFutureR;
                            default:
                                List list = (List) obj3;
                                int i8 = MediaSessionStub.f10157h;
                                MediaSessionImpl mediaSessionImpl3 = mediaSessionImpl;
                                Handler handler2 = mediaSessionImpl3.f10102l;
                                MediaSession.ControllerInfo controllerInfo2 = controllerInfo;
                                l0 l0Var2 = new l0(mediaSessionImpl3, controllerInfo2, new d(mediaSessionImpl3, (MediaSessionStub.MediaItemPlayerTask) obj4, controllerInfo2, list, 9));
                                SessionResult sessionResult2 = new SessionResult(0);
                                int i9 = Util.f5744a;
                                SettableFuture settableFutureR2 = SettableFuture.r();
                                Util.X(handler2, new androidx.media3.common.util.e(settableFutureR2, l0Var2, sessionResult2));
                                return settableFutureR2;
                        }
                    }
                });
            case 12:
                int i6 = MediaSessionStub.f10157h;
                return ((MediaLibrarySessionImpl) mediaSessionImpl).A(controllerInfo, (String) obj2, (MediaLibraryService.LibraryParams) obj);
            case 13:
                int i7 = MediaSessionStub.f10157h;
                if (mediaSessionImpl.j()) {
                    return Futures.d(new SessionResult(-100));
                }
                ListenableFuture listenableFuture2 = (ListenableFuture) ((MediaSessionStub.SessionTask) obj2).c(mediaSessionImpl, controllerInfo, i2);
                final MediaSessionStub.MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask = (MediaSessionStub.MediaItemsWithStartPositionPlayerTask) obj;
                final int i8 = 0;
                return Util.i0(listenableFuture2, new AsyncFunction() { // from class: androidx.media3.session.d2
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final ListenableFuture apply(Object obj3) {
                        Object obj4 = mediaItemsWithStartPositionPlayerTask;
                        switch (i8) {
                            case 0:
                                int i62 = MediaSessionStub.f10157h;
                                MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
                                Handler handler = mediaSessionImpl2.f10102l;
                                l0 l0Var = new l0(mediaSessionImpl2, controllerInfo, new v0(mediaSessionImpl2, (MediaSessionStub.MediaItemsWithStartPositionPlayerTask) obj4, (MediaSession.MediaItemsWithStartPosition) obj3, 8));
                                SessionResult sessionResult = new SessionResult(0);
                                int i72 = Util.f5744a;
                                SettableFuture settableFutureR = SettableFuture.r();
                                Util.X(handler, new androidx.media3.common.util.e(settableFutureR, l0Var, sessionResult));
                                return settableFutureR;
                            default:
                                List list = (List) obj3;
                                int i82 = MediaSessionStub.f10157h;
                                MediaSessionImpl mediaSessionImpl3 = mediaSessionImpl;
                                Handler handler2 = mediaSessionImpl3.f10102l;
                                MediaSession.ControllerInfo controllerInfo2 = controllerInfo;
                                l0 l0Var2 = new l0(mediaSessionImpl3, controllerInfo2, new d(mediaSessionImpl3, (MediaSessionStub.MediaItemPlayerTask) obj4, controllerInfo2, list, 9));
                                SessionResult sessionResult2 = new SessionResult(0);
                                int i9 = Util.f5744a;
                                SettableFuture settableFutureR2 = SettableFuture.r();
                                Util.X(handler2, new androidx.media3.common.util.e(settableFutureR2, l0Var2, sessionResult2));
                                return settableFutureR2;
                        }
                    }
                });
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10745a) {
            case 0:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10746b;
                mediaControllerImplBase.getClass();
                PlaybackParameters playbackParameters = (PlaybackParameters) this.f10747c;
                Bundle bundle = new Bundle();
                bundle.putFloat(PlaybackParameters.f5425e, playbackParameters.f5427a);
                bundle.putFloat(PlaybackParameters.f5426f, playbackParameters.f5428b);
                iMediaSession.W7(mediaControllerImplBase.f9972c, i2, bundle);
                break;
            case 1:
                MediaControllerImplBase mediaControllerImplBase2 = (MediaControllerImplBase) this.f10746b;
                mediaControllerImplBase2.getClass();
                iMediaSession.t8(mediaControllerImplBase2.f9972c, i2, ((MediaMetadata) this.f10747c).c());
                break;
            case 2:
                MediaControllerImplBase mediaControllerImplBase3 = (MediaControllerImplBase) this.f10746b;
                mediaControllerImplBase3.getClass();
                iMediaSession.ea(mediaControllerImplBase3.f9972c, i2, ((MediaItem) this.f10747c).c(true), true);
                break;
            case 3:
                iMediaSession.Sb(((MediaControllerImplBase) this.f10746b).f9972c, i2, ((TrackSelectionParameters) this.f10747c).c());
                break;
            default:
                MediaControllerImplBase mediaControllerImplBase4 = (MediaControllerImplBase) this.f10746b;
                mediaControllerImplBase4.getClass();
                iMediaSession.Hb(mediaControllerImplBase4.f9972c, i2, ((SessionCommand) this.f10747c).b(), Bundle.EMPTY);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10745a) {
            case 5:
                listener.j1(((Integer) this.f10747c).intValue(), ((MediaControllerImplLegacy.ControllerInfo) this.f10746b).f10007a.i());
                break;
            default:
                listener.j1(((Integer) this.f10747c).intValue(), (MediaItem) this.f10746b);
                break;
        }
    }

    public /* synthetic */ s(MediaControllerImplBase mediaControllerImplBase, SessionCommand sessionCommand) {
        this.f10745a = 4;
        Bundle bundle = Bundle.EMPTY;
        this.f10746b = mediaControllerImplBase;
        this.f10747c = sessionCommand;
    }
}
