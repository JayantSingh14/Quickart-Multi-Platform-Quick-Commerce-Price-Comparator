package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.mediaparser.a;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaSessionManager;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.VolumeProviderCompat;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.VersionedParcelable;
import com.brentvatne.exoplayer.VideoPlaybackService;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public class MediaSessionCompat {

    /* renamed from: d, reason: collision with root package name */
    public static int f10609d;

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionImplApi22 f10610a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaControllerCompat f10611b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f10612c = new ArrayList();

    /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$1, reason: invalid class name */
    class AnonymousClass1 extends Callback {
    }

    public interface MediaSessionImpl {
        void a(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        Callback b();

        MediaSessionManager.RemoteUserInfo c();

        PlaybackStateCompat u();
    }

    public static class MediaSessionImplApi18 extends MediaSessionImplBase {

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi18$1, reason: invalid class name */
        class AnonymousClass1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public final void onPlaybackPositionUpdate(long j2) {
                throw null;
            }
        }
    }

    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi19$1, reason: invalid class name */
        class AnonymousClass1 implements RemoteControlClient.OnMetadataUpdateListener {
            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public final void onMetadataUpdate(int i2, Object obj) {
                if (i2 == 268435457 && (obj instanceof Rating)) {
                    RatingCompat.a((Parcelable) obj);
                    throw null;
                }
            }
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi21 implements MediaSessionImpl {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSession f10620a;

        /* renamed from: b, reason: collision with root package name */
        public final ExtraSession f10621b;

        /* renamed from: c, reason: collision with root package name */
        public final Token f10622c;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10624e;

        /* renamed from: g, reason: collision with root package name */
        public PlaybackStateCompat f10626g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList f10627h;

        /* renamed from: i, reason: collision with root package name */
        public MediaMetadataCompat f10628i;

        /* renamed from: j, reason: collision with root package name */
        public int f10629j;

        /* renamed from: k, reason: collision with root package name */
        public int f10630k;

        /* renamed from: l, reason: collision with root package name */
        public Callback f10631l;

        /* renamed from: m, reason: collision with root package name */
        public MediaSessionManager.RemoteUserInfo f10632m;

        /* renamed from: d, reason: collision with root package name */
        public final Object f10623d = new Object();

        /* renamed from: f, reason: collision with root package name */
        public final RemoteCallbackList f10625f = new RemoteCallbackList();

        public static class ExtraSession extends IMediaSession.Stub {

            /* renamed from: b, reason: collision with root package name */
            public final AtomicReference f10633b;

            public ExtraSession(MediaSessionImplApi22 mediaSessionImplApi22) {
                this.f10633b = new AtomicReference(mediaSessionImplApi22);
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void C(float f2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void D9(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 == null || iMediaControllerCallback == null) {
                    return;
                }
                mediaSessionImplApi21.f10625f.unregister(iMediaControllerCallback);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (mediaSessionImplApi21.f10623d) {
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void E() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int E0() {
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.f10630k;
                }
                return -1;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final long F() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean F0() {
                return false;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int G() {
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.f10629j;
                }
                return -1;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void G8(int i2, int i3) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void I0() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Mb(Bundle bundle, String str) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void N1(Bundle bundle, String str) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void N9(boolean z) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void P1(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Rb(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 == null || iMediaControllerCallback == null) {
                    return;
                }
                mediaSessionImplApi21.f10625f.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (mediaSessionImplApi21.f10623d) {
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean T0() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void T6(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final String V() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final CharSequence V0() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void V4(int i2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void X(long j2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Xa(Bundle bundle, String str) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Y5(long j2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a1() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a2(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a8(int i2, int i3) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void ca(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d0(int i2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d3(Bundle bundle, String str) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void e9(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void i7(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final PendingIntent k0() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int l0() {
                return 0;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final List m1() {
                return null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void next() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final ParcelableVolumeInfo o1() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void o6(int i2) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void p() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean p4(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void pause() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void previous() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final Bundle r0() {
                Bundle bundle;
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 == null || (bundle = mediaSessionImplApi21.f10624e) == null) {
                    return null;
                }
                return new Bundle(bundle);
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void s5(Bundle bundle, String str) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void stop() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final PlaybackStateCompat u() {
                MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f10633b.get();
                if (mediaSessionImplApi21 == null) {
                    return null;
                }
                PlaybackStateCompat playbackStateCompat = mediaSessionImplApi21.f10626g;
                MediaMetadataCompat mediaMetadataCompat = mediaSessionImplApi21.f10628i;
                if (playbackStateCompat == null) {
                    return playbackStateCompat;
                }
                long j2 = playbackStateCompat.f10659b;
                if (j2 == -1) {
                    return playbackStateCompat;
                }
                int i2 = playbackStateCompat.f10658a;
                if (i2 != 3 && i2 != 4 && i2 != 5) {
                    return playbackStateCompat;
                }
                long j3 = playbackStateCompat.f10665h;
                long j4 = 0;
                if (j3 <= 0) {
                    return playbackStateCompat;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                float f2 = jElapsedRealtime - j3;
                float f3 = playbackStateCompat.f10661d;
                long j5 = ((long) (f2 * f3)) + j2;
                long jA = (mediaMetadataCompat == null || !mediaMetadataCompat.f10606a.containsKey("android.media.metadata.DURATION")) ? -1L : mediaMetadataCompat.a("android.media.metadata.DURATION");
                if (jA >= 0 && j5 > jA) {
                    j4 = jA;
                } else if (j5 >= 0) {
                    j4 = j5;
                }
                PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder(playbackStateCompat);
                builder.f10671b = i2;
                builder.f10672c = j4;
                builder.f10678i = jElapsedRealtime;
                builder.f10674e = f3;
                return builder.a();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void w3(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void x7(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final String z() {
                throw new AssertionError();
            }
        }

        public MediaSessionImplApi21(VideoPlaybackService videoPlaybackService, String str, Bundle bundle) {
            MediaSession mediaSessionD = d(videoPlaybackService, str, bundle);
            this.f10620a = mediaSessionD;
            ExtraSession extraSession = new ExtraSession((MediaSessionImplApi22) this);
            this.f10621b = extraSession;
            this.f10622c = new Token(mediaSessionD.getSessionToken(), extraSession, null);
            this.f10624e = bundle;
            mediaSessionD.setFlags(3);
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f10623d) {
                this.f10632m = remoteUserInfo;
            }
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final Callback b() {
            Callback callback;
            synchronized (this.f10623d) {
                callback = this.f10631l;
            }
            return callback;
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo c() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.f10623d) {
                remoteUserInfo = this.f10632m;
            }
            return remoteUserInfo;
        }

        public MediaSession d(VideoPlaybackService videoPlaybackService, String str, Bundle bundle) {
            return new MediaSession(videoPlaybackService, str);
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final PlaybackStateCompat u() {
            return this.f10626g;
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
    }

    @RequiresApi
    public static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImplApi21, androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImplApi21, androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo c() {
            return new MediaSessionManager.RemoteUserInfo(this.f10620a.getCurrentControllerInfo());
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImplApi21
        public final MediaSession d(VideoPlaybackService videoPlaybackService, String str, Bundle bundle) {
            return a.j(videoPlaybackService, str, bundle);
        }
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplBase$1, reason: invalid class name */
        public class AnonymousClass1 extends VolumeProviderCompat.Callback {
        }

        public static final class Command {
        }

        public static class MediaSessionStub extends IMediaSession.Stub {
            @Override // androidx.media3.session.legacy.IMediaSession
            public final void C(float f2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void D9(IMediaControllerCallback iMediaControllerCallback) {
                if (iMediaControllerCallback != null) {
                    throw null;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void E() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int E0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final long F() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean F0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int G() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void G8(int i2, int i3) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void I0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Mb(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void N1(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void N9(boolean z) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void P1(Uri uri, Bundle bundle) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Rb(IMediaControllerCallback iMediaControllerCallback) {
                if (iMediaControllerCallback != null) {
                    throw null;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean T0() {
                return true;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void T6(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                if (str != null) {
                    throw null;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final String V() {
                return null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final CharSequence V0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void V4(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void X(long j2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Xa(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Y5(long j2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a1() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a2(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a8(int i2, int i3) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void ca(MediaDescriptionCompat mediaDescriptionCompat) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d0(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d3(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void e9(MediaDescriptionCompat mediaDescriptionCompat) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final Bundle getExtras() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final MediaMetadataCompat getMetadata() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void i7(RatingCompat ratingCompat) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final PendingIntent k0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int l0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final List m1() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void next() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final ParcelableVolumeInfo o1() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void o6(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void p() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean p4(KeyEvent keyEvent) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void pause() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void previous() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final Bundle r0() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void s5(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void stop() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final PlaybackStateCompat u() {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void w3(Uri uri, Bundle bundle) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void x7(RatingCompat ratingCompat, Bundle bundle) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final String z() {
                return null;
            }
        }

        public class MessageHandler extends Handler {
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                throw null;
            }
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final Callback b() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo c() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaSessionCompat.MediaSessionImpl
        public final PlaybackStateCompat u() {
            throw null;
        }
    }

    public interface OnActiveChangeListener {
        void a();
    }

    public interface RegistrationCallback {
    }

    public static final class RegistrationCallbackHandler extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1001 || i2 == 1002) {
                throw null;
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public ResultReceiver f10637a;

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$ResultReceiverWrapper$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                ResultReceiverWrapper resultReceiverWrapper = new ResultReceiverWrapper();
                resultReceiverWrapper.f10637a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return resultReceiverWrapper;
            }

            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            this.f10637a.writeToParcel(parcel, i2);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final Object f10638a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final Object f10639b;

        /* renamed from: c, reason: collision with root package name */
        public IMediaSession f10640c;

        /* renamed from: d, reason: collision with root package name */
        public VersionedParcelable f10641d;

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$Token$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            public final Token createFromParcel(Parcel parcel) {
                Parcelable parcelable = parcel.readParcelable(null);
                parcelable.getClass();
                return new Token(parcelable, null, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Token[] newArray(int i2) {
                return new Token[i2];
            }
        }

        public Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.f10639b = obj;
            this.f10640c = iMediaSession;
            this.f10641d = versionedParcelable;
        }

        public final IMediaSession a() {
            IMediaSession iMediaSession;
            synchronized (this.f10638a) {
                iMediaSession = this.f10640c;
            }
            return iMediaSession;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f10639b;
            if (obj2 == null) {
                return token.f10639b == null;
            }
            Object obj3 = token.f10639b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public final int hashCode() {
            Object obj = this.f10639b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable((Parcelable) this.f10639b, i2);
        }
    }

    public MediaSessionCompat(VideoPlaybackService videoPlaybackService, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        if (videoPlaybackService == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (componentName == null) {
            int i2 = MediaButtonReceiver.f10561a;
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setPackage(videoPlaybackService.getPackageName());
            List<ResolveInfo> listQueryBroadcastReceivers = videoPlaybackService.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers.size() == 1) {
                ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
                componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            } else {
                if (listQueryBroadcastReceivers.size() > 1) {
                    Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                }
                componentName = null;
            }
            if (componentName == null) {
                Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
            }
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent2.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(videoPlaybackService, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            this.f10610a = new MediaSessionImplApi29(videoPlaybackService, str, bundle);
        } else if (i3 >= 28) {
            this.f10610a = new MediaSessionImplApi28(videoPlaybackService, str, bundle);
        } else {
            this.f10610a = new MediaSessionImplApi22(videoPlaybackService, str, bundle);
        }
        Looper looperMyLooper = Looper.myLooper();
        h(new AnonymousClass1(), new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper));
        this.f10610a.f10620a.setMediaButtonReceiver(pendingIntent);
        this.f10611b = new MediaControllerCompat(videoPlaybackService, this.f10610a.f10622c);
        if (f10609d == 0) {
            f10609d = (int) (TypedValue.applyDimension(1, 320.0f, videoPlaybackService.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            ClassLoader classLoader = MediaSessionCompat.class.getClassLoader();
            classLoader.getClass();
            bundle.setClassLoader(classLoader);
        }
    }

    public static Bundle t(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public final MediaSessionManager.RemoteUserInfo b() {
        return this.f10610a.c();
    }

    public final MediaSession c() {
        return this.f10610a.f10620a;
    }

    public final Token d() {
        return this.f10610a.f10622c;
    }

    public final boolean e() {
        return this.f10610a.f10620a.isActive();
    }

    public final void f() throws NoSuchFieldException, SecurityException {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.f10625f.kill();
        int i2 = Build.VERSION.SDK_INT;
        MediaSession mediaSession = mediaSessionImplApi22.f10620a;
        if (i2 == 27) {
            try {
                Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                declaredField.setAccessible(true);
                Handler handler = (Handler) declaredField.get(mediaSession);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e2);
            }
        }
        mediaSession.setCallback(null);
        mediaSessionImplApi22.f10621b.f10633b.set(null);
        mediaSession.release();
    }

    public final void g() {
        this.f10610a.f10620a.setActive(true);
        Iterator it = this.f10612c.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).a();
        }
    }

    public final void h(Callback callback, Handler handler) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        synchronized (mediaSessionImplApi22.f10623d) {
            mediaSessionImplApi22.f10631l = callback;
            mediaSessionImplApi22.f10620a.setCallback(callback == null ? null : callback.f10614b, handler);
            if (callback != null) {
                synchronized (callback.f10613a) {
                    try {
                        callback.f10616d = new WeakReference(mediaSessionImplApi22);
                        Callback.CallbackHandler callbackHandler = callback.f10617e;
                        Callback.CallbackHandler callbackHandler2 = null;
                        if (callbackHandler != null) {
                            callbackHandler.removeCallbacksAndMessages(null);
                        }
                        if (mediaSessionImplApi22 != null && handler != null) {
                            callbackHandler2 = callback.new CallbackHandler(handler.getLooper());
                        }
                        callback.f10617e = callbackHandler2;
                    } finally {
                    }
                }
            }
        }
    }

    public final void i(int i2) {
        this.f10610a.f10620a.setFlags(i2 | 3);
    }

    public final void j(PendingIntent pendingIntent) {
        this.f10610a.f10620a.setMediaButtonReceiver(pendingIntent);
    }

    public final void k(MediaMetadataCompat mediaMetadataCompat) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.f10628i = mediaMetadataCompat;
        MediaMetadata mediaMetadata = mediaMetadataCompat.f10607b;
        if (mediaMetadata == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                mediaMetadataCompat.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                MediaMetadata mediaMetadata2 = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(parcelObtain);
                mediaMetadataCompat.f10607b = mediaMetadata2;
                parcelObtain.recycle();
                mediaMetadata = mediaMetadata2;
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        mediaSessionImplApi22.f10620a.setMetadata(mediaMetadata);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.AbstractCollection, java.util.List] */
    public final void l(PlaybackStateCompat playbackStateCompat) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.f10626g = playbackStateCompat;
        synchronized (mediaSessionImplApi22.f10623d) {
            for (int iBeginBroadcast = mediaSessionImplApi22.f10625f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((IMediaControllerCallback) mediaSessionImplApi22.f10625f.getBroadcastItem(iBeginBroadcast)).g5(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            mediaSessionImplApi22.f10625f.finishBroadcast();
        }
        MediaSession mediaSession = mediaSessionImplApi22.f10620a;
        if (playbackStateCompat.f10669l == null) {
            PlaybackState.Builder builderD = PlaybackStateCompat.Api21Impl.d();
            PlaybackStateCompat.Api21Impl.x(builderD, playbackStateCompat.f10658a, playbackStateCompat.f10659b, playbackStateCompat.f10661d, playbackStateCompat.f10665h);
            PlaybackStateCompat.Api21Impl.u(builderD, playbackStateCompat.f10660c);
            PlaybackStateCompat.Api21Impl.s(builderD, playbackStateCompat.f10662e);
            PlaybackStateCompat.Api21Impl.v(builderD, playbackStateCompat.f10664g);
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.f10666i) {
                PlaybackState.CustomAction customActionB = customAction.f10685e;
                if (customActionB == null) {
                    PlaybackState.CustomAction.Builder builderE = PlaybackStateCompat.Api21Impl.e(customAction.f10681a, customAction.f10682b, customAction.f10683c);
                    PlaybackStateCompat.Api21Impl.w(builderE, customAction.f10684d);
                    customActionB = PlaybackStateCompat.Api21Impl.b(builderE);
                }
                if (customActionB != null) {
                    PlaybackStateCompat.Api21Impl.a(builderD, customActionB);
                }
            }
            PlaybackStateCompat.Api21Impl.t(builderD, playbackStateCompat.f10667j);
            PlaybackStateCompat.Api22Impl.b(builderD, playbackStateCompat.f10668k);
            playbackStateCompat.f10669l = PlaybackStateCompat.Api21Impl.c(builderD);
        }
        mediaSession.setPlaybackState(playbackStateCompat.f10669l);
    }

    public final void m(int i2) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i2);
        mediaSessionImplApi22.f10620a.setPlaybackToLocal(builder.build());
    }

    public final void n(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.getClass();
        mediaSessionImplApi22.f10620a.setPlaybackToRemote(volumeProviderCompat.a());
    }

    public final void o(ArrayList arrayList) {
        if (arrayList != null) {
            HashSet hashSet = new HashSet();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                QueueItem queueItem = (QueueItem) it.next();
                if (queueItem == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                long j2 = queueItem.f10635b;
                if (hashSet.contains(Long.valueOf(j2))) {
                    Log.e("MediaSessionCompat", b.i(j2, "Found duplicate queue id: "), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(j2));
            }
        }
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        mediaSessionImplApi22.f10627h = arrayList;
        MediaSession mediaSession = mediaSessionImplApi22.f10620a;
        if (arrayList == null) {
            mediaSession.setQueue(null);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            QueueItem queueItem2 = (QueueItem) it2.next();
            MediaSession.QueueItem queueItemA = queueItem2.f10636c;
            if (queueItemA == null) {
                queueItemA = QueueItem.Api21Impl.a(queueItem2.f10634a.b(), queueItem2.f10635b);
                queueItem2.f10636c = queueItemA;
            }
            queueItemA.getClass();
            arrayList2.add(queueItemA);
        }
        mediaSession.setQueue(arrayList2);
    }

    public final void p(CharSequence charSequence) {
        this.f10610a.f10620a.setQueueTitle(charSequence);
    }

    public final void q(int i2) {
        this.f10610a.f10620a.setRatingType(i2);
    }

    public final void r(int i2) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        if (mediaSessionImplApi22.f10629j != i2) {
            mediaSessionImplApi22.f10629j = i2;
            synchronized (mediaSessionImplApi22.f10623d) {
                for (int iBeginBroadcast = mediaSessionImplApi22.f10625f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) mediaSessionImplApi22.f10625f.getBroadcastItem(iBeginBroadcast)).d1(i2);
                    } catch (RemoteException unused) {
                    }
                }
                mediaSessionImplApi22.f10625f.finishBroadcast();
            }
        }
    }

    public final void s(int i2) {
        MediaSessionImplApi22 mediaSessionImplApi22 = this.f10610a;
        if (mediaSessionImplApi22.f10630k != i2) {
            mediaSessionImplApi22.f10630k = i2;
            synchronized (mediaSessionImplApi22.f10623d) {
                for (int iBeginBroadcast = mediaSessionImplApi22.f10625f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) mediaSessionImplApi22.f10625f.getBroadcastItem(iBeginBroadcast)).m5(i2);
                    } catch (RemoteException unused) {
                    }
                }
                mediaSessionImplApi22.f10625f.finishBroadcast();
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f10634a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10635b;

        /* renamed from: c, reason: collision with root package name */
        public MediaSession.QueueItem f10636c;

        /* renamed from: androidx.media3.session.legacy.MediaSessionCompat$QueueItem$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            public final QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        }

        @RequiresApi
        public static class Api21Impl {
            @DoNotInline
            public static MediaSession.QueueItem a(MediaDescription mediaDescription, long j2) {
                return new MediaSession.QueueItem(mediaDescription, j2);
            }

            @DoNotInline
            public static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            @DoNotInline
            public static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j2 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f10634a = mediaDescriptionCompat;
            this.f10635b = j2;
            this.f10636c = queueItem;
        }

        public static ArrayList a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MediaSession.QueueItem queueItem = (MediaSession.QueueItem) it.next();
                arrayList.add(new QueueItem(queueItem, MediaDescriptionCompat.a(Api21Impl.b(queueItem)), Api21Impl.c(queueItem)));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
            sb.append(this.f10634a);
            sb.append(", Id=");
            return b.p(sb, this.f10635b, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            this.f10634a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f10635b);
        }

        public QueueItem(Parcel parcel) {
            this.f10634a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f10635b = parcel.readLong();
        }
    }

    public static abstract class Callback {

        /* renamed from: c, reason: collision with root package name */
        public boolean f10615c;

        /* renamed from: e, reason: collision with root package name */
        public CallbackHandler f10617e;

        /* renamed from: a, reason: collision with root package name */
        public final Object f10613a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final MediaSession.Callback f10614b = new MediaSessionCallbackApi21();

        /* renamed from: d, reason: collision with root package name */
        public WeakReference f10616d = new WeakReference(null);

        public class CallbackHandler extends Handler {
            public CallbackHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                Callback callback;
                CallbackHandler callbackHandler;
                if (message.what == 1) {
                    synchronized (Callback.this.f10613a) {
                        mediaSessionImpl = (MediaSessionImpl) Callback.this.f10616d.get();
                        callback = Callback.this;
                        callbackHandler = callback.f10617e;
                    }
                    if (mediaSessionImpl == null || callback != mediaSessionImpl.b() || callbackHandler == null) {
                        return;
                    }
                    mediaSessionImpl.a((MediaSessionManager.RemoteUserInfo) message.obj);
                    Callback.this.a(mediaSessionImpl, callbackHandler);
                    mediaSessionImpl.a(null);
                }
            }
        }

        @RequiresApi
        public class MediaSessionCallbackApi21 extends MediaSession.Callback {
            public MediaSessionCallbackApi21() {
            }

            public static void b(MediaSessionImplApi21 mediaSessionImplApi21) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                MediaSession mediaSession = mediaSessionImplApi21.f10620a;
                String str = null;
                try {
                    str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
                } catch (Exception e2) {
                    Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e2);
                }
                if (TextUtils.isEmpty(str)) {
                    str = "android.media.session.MediaController";
                }
                mediaSessionImplApi21.a(new MediaSessionManager.RemoteUserInfo(str, -1, -1));
            }

            public final MediaSessionImplApi21 a() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.f10613a) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.f10616d.get();
                }
                if (mediaSessionImplApi21 == null || Callback.this != mediaSessionImplApi21.b()) {
                    return null;
                }
                return mediaSessionImplApi21;
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                VersionedParcelable versionedParcelable;
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                try {
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        if (resultReceiver != null) {
                            Bundle bundle2 = new Bundle();
                            Token token = mediaSessionImplApi21A.f10622c;
                            IMediaSession iMediaSessionA = token.a();
                            bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", iMediaSessionA == null ? null : iMediaSessionA.asBinder());
                            synchronized (token.f10638a) {
                                versionedParcelable = token.f10641d;
                            }
                            if (versionedParcelable != null) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putParcelable("a", new ParcelImpl(versionedParcelable));
                                bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                            }
                            resultReceiver.send(0, bundle2);
                        }
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        if (bundle != null) {
                            Callback.this.b((MediaDescriptionCompat) LegacyParcelableUtil.a(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        if (bundle != null) {
                            Callback.this.c((MediaDescriptionCompat) LegacyParcelableUtil.a(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        if (bundle != null) {
                            Callback.this.q((MediaDescriptionCompat) LegacyParcelableUtil.a(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        ArrayList arrayList = mediaSessionImplApi21A.f10627h;
                        if (arrayList != null && bundle != null) {
                            int i2 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            QueueItem queueItem = (i2 < 0 || i2 >= arrayList.size()) ? null : (QueueItem) arrayList.get(i2);
                            if (queueItem != null) {
                                Callback.this.q(queueItem.f10634a);
                            }
                        }
                    } else {
                        Callback.this.d(str, bundle, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                try {
                    boolean zEquals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
                    Callback callback = Callback.this;
                    if (zEquals) {
                        if (bundle != null) {
                            Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                            Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.a(bundle2);
                            callback.l(uri, bundle2);
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        callback.m();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        if (bundle != null) {
                            String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                            Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.a(bundle3);
                            callback.n(string, bundle3);
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        if (bundle != null) {
                            String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                            Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.a(bundle4);
                            callback.o(string2, bundle4);
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        if (bundle != null) {
                            Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                            Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.a(bundle5);
                            callback.p(uri2, bundle5);
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        if (bundle != null) {
                            bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        if (bundle != null) {
                            callback.w(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        if (bundle != null) {
                            callback.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        if (bundle != null) {
                            RatingCompat ratingCompat = (RatingCompat) LegacyParcelableUtil.a(bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), RatingCompat.CREATOR);
                            MediaSessionCompat.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                            callback.v(ratingCompat);
                        }
                    } else if (!str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        callback.e(str, bundle);
                    } else if (bundle != null) {
                        callback.t(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onFastForward() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.f();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final boolean onMediaButtonEvent(Intent intent) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return false;
                }
                b(mediaSessionImplApi21A);
                boolean zG = Callback.this.g(intent);
                mediaSessionImplApi21A.a(null);
                return zG || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPause() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.h();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlay() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.i();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.j(str, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.k(str, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.l(uri, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepare() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.m();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.n(str, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.o(str, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                b(mediaSessionImplApi21A);
                Callback.this.p(uri, bundle);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onRewind() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.r();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSeekTo(long j2) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.s(j2);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSetPlaybackSpeed(float f2) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.t(f2);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSetRating(Rating rating) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.u(RatingCompat.a(rating));
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToNext() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.y();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToPrevious() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.z();
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToQueueItem(long j2) {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.A(j2);
                mediaSessionImplApi21A.a(null);
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onStop() {
                MediaSessionImplApi21 mediaSessionImplApi21A = a();
                if (mediaSessionImplApi21A == null) {
                    return;
                }
                b(mediaSessionImplApi21A);
                Callback.this.B();
                mediaSessionImplApi21A.a(null);
            }
        }

        public void A(long j2) {
        }

        public void B() {
        }

        public final void a(MediaSessionImpl mediaSessionImpl, Handler handler) {
            if (this.f10615c) {
                this.f10615c = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackStateCompatU = mediaSessionImpl.u();
                long j2 = playbackStateCompatU == null ? 0L : playbackStateCompatU.f10662e;
                boolean z = playbackStateCompatU != null && playbackStateCompatU.f10658a == 3;
                boolean z2 = (516 & j2) != 0;
                boolean z3 = (j2 & 514) != 0;
                if (z && z3) {
                    h();
                } else {
                    if (z || !z2) {
                        return;
                    }
                    i();
                }
            }
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT < 27) {
                synchronized (this.f10613a) {
                    mediaSessionImpl = (MediaSessionImpl) this.f10616d.get();
                    callbackHandler = this.f10617e;
                }
                if (mediaSessionImpl != null && callbackHandler != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                    MediaSessionManager.RemoteUserInfo remoteUserInfoC = mediaSessionImpl.c();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79 && keyCode != 85) {
                        a(mediaSessionImpl, callbackHandler);
                        return false;
                    }
                    if (keyEvent.getRepeatCount() != 0) {
                        a(mediaSessionImpl, callbackHandler);
                        return true;
                    }
                    if (!this.f10615c) {
                        this.f10615c = true;
                        callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, remoteUserInfoC), ViewConfiguration.getDoubleTapTimeout());
                        return true;
                    }
                    callbackHandler.removeMessages(1);
                    this.f10615c = false;
                    PlaybackStateCompat playbackStateCompatU = mediaSessionImpl.u();
                    if (((playbackStateCompatU == null ? 0L : playbackStateCompatU.f10662e) & 32) != 0) {
                        y();
                    }
                    return true;
                }
            }
            return false;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void r() {
        }

        public void s(long j2) {
        }

        public void t(float f2) {
        }

        public void u(RatingCompat ratingCompat) {
        }

        public void w(int i2) {
        }

        public void x(int i2) {
        }

        public void y() {
        }

        public void z() {
        }

        public void v(RatingCompat ratingCompat) {
        }
    }
}
