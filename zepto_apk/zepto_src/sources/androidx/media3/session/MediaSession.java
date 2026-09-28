package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.legacy.MediaSessionManager;
import com.brentvatne.exoplayer.VideoPlaybackCallback;
import com.brentvatne.exoplayer.VideoPlaybackService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@DoNotMock
/* loaded from: classes3.dex */
public class MediaSession {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f10058b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f10059c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionImpl f10060a;

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static boolean a(PendingIntent pendingIntent) {
            return pendingIntent.isActivity();
        }
    }

    public static final class Builder extends BuilderBase<MediaSession, Builder, Callback> {

        /* renamed from: androidx.media3.session.MediaSession$Builder$1, reason: invalid class name */
        class AnonymousClass1 implements Callback {
        }

        public Builder(VideoPlaybackService videoPlaybackService, ExoPlayer exoPlayer) {
            super(videoPlaybackService, exoPlayer, new AnonymousClass1());
        }

        public final MediaSession a() {
            CacheBitmapLoader cacheBitmapLoader = this.f10067g;
            VideoPlaybackService videoPlaybackService = this.f10061a;
            if (cacheBitmapLoader == null) {
                this.f10067g = new CacheBitmapLoader(new DataSourceBitmapLoader(videoPlaybackService));
            }
            String str = this.f10063c;
            ImmutableList immutableList = this.f10069i;
            Callback callback = this.f10064d;
            CacheBitmapLoader cacheBitmapLoader2 = this.f10067g;
            cacheBitmapLoader2.getClass();
            boolean z = this.f10070j;
            return new MediaSession(videoPlaybackService, str, this.f10062b, immutableList, callback, this.f10065e, this.f10066f, cacheBitmapLoader2, this.f10068h, z);
        }

        public final void b(VideoPlaybackCallback videoPlaybackCallback) {
            this.f10064d = videoPlaybackCallback;
        }

        public final void c(List list) {
            this.f10069i = ImmutableList.o(list);
        }

        public final void d(String str) {
            str.getClass();
            this.f10063c = str;
        }
    }

    public static abstract class BuilderBase<SessionT extends MediaSession, BuilderT extends BuilderBase<SessionT, BuilderT, CallbackT>, CallbackT extends Callback> {

        /* renamed from: a, reason: collision with root package name */
        public final VideoPlaybackService f10061a;

        /* renamed from: b, reason: collision with root package name */
        public final ExoPlayer f10062b;

        /* renamed from: c, reason: collision with root package name */
        public String f10063c;

        /* renamed from: d, reason: collision with root package name */
        public Callback f10064d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10065e;

        /* renamed from: f, reason: collision with root package name */
        public final Bundle f10066f;

        /* renamed from: g, reason: collision with root package name */
        public CacheBitmapLoader f10067g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f10068h;

        /* renamed from: i, reason: collision with root package name */
        public ImmutableList f10069i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f10070j;

        public BuilderBase(VideoPlaybackService videoPlaybackService, ExoPlayer exoPlayer, Callback callback) {
            this.f10061a = videoPlaybackService;
            exoPlayer.getClass();
            this.f10062b = exoPlayer;
            Assertions.a(exoPlayer.C1());
            this.f10063c = "";
            this.f10064d = callback;
            Bundle bundle = Bundle.EMPTY;
            this.f10065e = bundle;
            this.f10066f = bundle;
            this.f10069i = ImmutableList.r();
            this.f10068h = true;
            this.f10070j = true;
        }
    }

    public interface Callback {
        /* JADX WARN: Multi-variable type inference failed */
        static ListenableFuture c(List list) {
            UnmodifiableListIterator unmodifiableListIteratorListIterator = ((ImmutableList) list).listIterator(0);
            while (unmodifiableListIteratorListIterator.hasNext()) {
                if (((MediaItem) unmodifiableListIteratorListIterator.next()).f5258b == null) {
                    return Futures.c(new UnsupportedOperationException());
                }
            }
            return Futures.d(list);
        }

        default ListenableFuture a(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
            return Futures.d(new SessionResult(-6));
        }

        default ConnectionResult b(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return new ConnectionResult.AcceptedResultBuilder(mediaSession).a();
        }
    }

    public static final class ConnectionResult {

        /* renamed from: f, reason: collision with root package name */
        public static final SessionCommands f10071f;

        /* renamed from: g, reason: collision with root package name */
        public static final SessionCommands f10072g;

        /* renamed from: h, reason: collision with root package name */
        public static final Player.Commands f10073h;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10074a;

        /* renamed from: b, reason: collision with root package name */
        public final SessionCommands f10075b;

        /* renamed from: c, reason: collision with root package name */
        public final Player.Commands f10076c;

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableList f10077d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10078e;

        @UnstableApi
        public static class AcceptedResultBuilder {

            /* renamed from: a, reason: collision with root package name */
            public SessionCommands f10079a;

            /* renamed from: b, reason: collision with root package name */
            public Player.Commands f10080b = ConnectionResult.f10073h;

            /* renamed from: c, reason: collision with root package name */
            public ImmutableList f10081c;

            public AcceptedResultBuilder(MediaSession mediaSession) {
                this.f10079a = mediaSession instanceof MediaLibraryService.MediaLibrarySession ? ConnectionResult.f10072g : ConnectionResult.f10071f;
            }

            public final ConnectionResult a() {
                return new ConnectionResult(true, this.f10079a, this.f10080b, this.f10081c, null);
            }
        }

        static {
            SessionCommands.Builder builder = new SessionCommands.Builder();
            ImmutableList immutableList = SessionCommand.f10228d;
            builder.a(immutableList);
            f10071f = builder.b();
            SessionCommands.Builder builder2 = new SessionCommands.Builder();
            builder2.a(SessionCommand.f10229e);
            builder2.a(immutableList);
            f10072g = builder2.b();
            Player.Commands.Builder builder3 = new Player.Commands.Builder();
            builder3.f5434a.b(Player.Commands.Builder.f5433b);
            f10073h = builder3.d();
        }

        public ConnectionResult(boolean z, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle) {
            this.f10074a = z;
            this.f10075b = sessionCommands;
            this.f10076c = commands;
            this.f10077d = immutableList;
            this.f10078e = bundle;
        }
    }

    public static final class ControllerInfo {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f10082a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10083b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10084c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10085d;

        /* renamed from: e, reason: collision with root package name */
        public final ControllerCb f10086e;

        /* renamed from: f, reason: collision with root package name */
        public final Bundle f10087f;

        public ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i2, int i3, boolean z, ControllerCb controllerCb, Bundle bundle) {
            this.f10082a = remoteUserInfo;
            this.f10083b = i2;
            this.f10084c = i3;
            this.f10085d = z;
            this.f10086e = controllerCb;
            this.f10087f = bundle;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.f10086e;
            return (controllerCb == null && controllerInfo.f10086e == null) ? this.f10082a.equals(controllerInfo.f10082a) : Util.a(controllerCb, controllerInfo.f10086e);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f10086e, this.f10082a});
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ControllerInfo {pkg=");
            MediaSessionManager.RemoteUserInfo remoteUserInfo = this.f10082a;
            sb.append(remoteUserInfo.a());
            sb.append(", uid=");
            sb.append(remoteUserInfo.c());
            sb.append("}");
            return sb.toString();
        }
    }

    public interface Listener {
    }

    @UnstableApi
    public static final class MediaItemsWithStartPosition {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableList f10088a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10089b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10090c;

        public MediaItemsWithStartPosition(List list, int i2, long j2) {
            this.f10088a = ImmutableList.o(list);
            this.f10089b = i2;
            this.f10090c = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemsWithStartPosition)) {
                return false;
            }
            MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaItemsWithStartPosition) obj;
            if (this.f10088a.equals(mediaItemsWithStartPosition.f10088a)) {
                Integer numValueOf = Integer.valueOf(this.f10089b);
                Integer numValueOf2 = Integer.valueOf(mediaItemsWithStartPosition.f10089b);
                int i2 = Util.f5744a;
                if (numValueOf.equals(numValueOf2) && Long.valueOf(this.f10090c).equals(Long.valueOf(mediaItemsWithStartPosition.f10090c))) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Longs.a(this.f10090c) + (((this.f10088a.hashCode() * 31) + this.f10089b) * 31);
        }
    }

    public MediaSession(VideoPlaybackService videoPlaybackService, String str, ExoPlayer exoPlayer, ImmutableList immutableList, Callback callback, Bundle bundle, Bundle bundle2, CacheBitmapLoader cacheBitmapLoader, boolean z, boolean z2) {
        synchronized (f10058b) {
            HashMap map = f10059c;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.f10060a = new MediaSessionImpl(this, videoPlaybackService, str, exoPlayer, immutableList, callback, bundle, bundle2, cacheBitmapLoader, z, z2);
    }

    public final androidx.media3.common.util.BitmapLoader a() {
        return this.f10060a.f10103m;
    }

    public MediaSessionImpl b() {
        return this.f10060a;
    }

    public final Player c() {
        return this.f10060a.s.f5239a;
    }

    public final void d() {
        try {
            synchronized (f10058b) {
                f10059c.remove(this.f10060a.f10099i);
            }
            this.f10060a.t();
        } catch (Exception unused) {
        }
    }

    public interface ControllerCb {
        default void S0(int i2) {
        }

        default void a(int i2, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i3) {
        }

        default void b(int i2, LibraryResult libraryResult) {
        }

        default void d(int i2, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i3) {
        }

        default void e(int i2, Player.Commands commands) {
        }

        default void f(int i2, SessionResult sessionResult) {
        }

        default void D() {
        }

        default void c(int i2, String str, MediaLibraryService.LibraryParams libraryParams) {
        }
    }
}
