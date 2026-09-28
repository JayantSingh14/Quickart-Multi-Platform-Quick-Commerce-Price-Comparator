package androidx.media3.session.legacy;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.AudioAttributesCompat;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final MediaControllerImplApi21 f10566a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f10567b;

    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController.Callback f10568a = new MediaControllerCallbackApi21(this);

        /* renamed from: b, reason: collision with root package name */
        public MessageHandler f10569b;

        /* renamed from: c, reason: collision with root package name */
        public IMediaControllerCallback f10570c;

        @RequiresApi
        public static class MediaControllerCallbackApi21 extends MediaController.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f10571a;

            public MediaControllerCallbackApi21(Callback callback) {
                this.f10571a = new WeakReference(callback);
            }

            @Override // android.media.session.MediaController.Callback
            public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                Callback callback = (Callback) this.f10571a.get();
                if (callback == null || playbackInfo == null) {
                    return;
                }
                callback.a(new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.b(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
            }

            @Override // android.media.session.MediaController.Callback
            public final void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.a(bundle);
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    callback.c(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onMetadataChanged(MediaMetadata mediaMetadata) {
                MediaMetadataCompat mediaMetadataCompatCreateFromParcel;
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    ArrayMap arrayMap = MediaMetadataCompat.f10604c;
                    if (mediaMetadata != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaMetadata.writeToParcel(parcelObtain, 0);
                        parcelObtain.setDataPosition(0);
                        mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        mediaMetadataCompatCreateFromParcel.f10607b = mediaMetadata;
                    } else {
                        mediaMetadataCompatCreateFromParcel = null;
                    }
                    callback.d(mediaMetadataCompatCreateFromParcel);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onPlaybackStateChanged(PlaybackState playbackState) {
                Callback callback = (Callback) this.f10571a.get();
                if (callback == null || callback.f10570c != null) {
                    return;
                }
                callback.e(PlaybackStateCompat.a(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueChanged(List list) {
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    callback.f(MediaSessionCompat.QueueItem.a(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    callback.g(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionDestroyed() {
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    callback.i();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                Callback callback = (Callback) this.f10571a.get();
                if (callback != null) {
                    callback.j(str, bundle);
                }
            }
        }

        public class MessageHandler extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public boolean f10572a;

            public MessageHandler(Looper looper) {
                super(looper);
                this.f10572a = false;
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (this.f10572a) {
                    int i2 = message.what;
                    Callback callback = Callback.this;
                    switch (i2) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            callback.j((String) message.obj, data);
                            break;
                        case 2:
                            callback.e((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            callback.d((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            callback.a((PlaybackInfo) message.obj);
                            break;
                        case 5:
                            callback.f((List) message.obj);
                            break;
                        case 6:
                            callback.g((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            callback.c(bundle);
                            break;
                        case 8:
                            callback.i();
                            break;
                        case 9:
                            callback.h(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            callback.b(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            callback.l(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            callback.k();
                            break;
                    }
                }
            }
        }

        public static class StubCompat extends IMediaControllerCallback.Stub {

            /* renamed from: b, reason: collision with root package name */
            public final WeakReference f10574b;

            public StubCompat(Callback callback) {
                this.f10574b = new WeakReference(callback);
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void A0() {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(8, null, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void G4(MediaMetadataCompat mediaMetadataCompat) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(3, mediaMetadataCompat, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void O7(Bundle bundle) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(7, bundle, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void T2(List list) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(5, list, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void d1(int i2) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(9, Integer.valueOf(i2), null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void d6(ParcelableVolumeInfo parcelableVolumeInfo) {
                PlaybackInfo playbackInfo;
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    if (parcelableVolumeInfo != null) {
                        int i2 = parcelableVolumeInfo.f10656d;
                        int i3 = parcelableVolumeInfo.f10657e;
                        int i4 = parcelableVolumeInfo.f10653a;
                        int i5 = parcelableVolumeInfo.f10654b;
                        int i6 = parcelableVolumeInfo.f10655c;
                        AudioAttributesCompat.AudioAttributesImpl.Builder builder = new AudioAttributesCompat.Builder().f10428a;
                        ((AudioAttributesCompat.AudioAttributesImplApi21.Builder) builder).f10424a.setLegacyStreamType(i5);
                        playbackInfo = new PlaybackInfo(i4, new AudioAttributesCompat(builder.build()), i6, i2, i3);
                    } else {
                        playbackInfo = null;
                    }
                    callback.m(4, playbackInfo, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void g5(PlaybackStateCompat playbackStateCompat) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(2, playbackStateCompat, null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void m5(int i2) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(12, Integer.valueOf(i2), null);
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void z9(CharSequence charSequence) {
                Callback callback = (Callback) this.f10574b.get();
                if (callback != null) {
                    callback.m(6, charSequence, null);
                }
            }
        }

        public void a(PlaybackInfo playbackInfo) {
        }

        public void b(boolean z) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            m(8, null, null);
        }

        public void c(Bundle bundle) {
        }

        public void d(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void e(PlaybackStateCompat playbackStateCompat) {
        }

        public void f(List list) {
        }

        public void g(CharSequence charSequence) {
        }

        public void h(int i2) {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k() {
        }

        public void l(int i2) {
        }

        public final void m(int i2, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.f10569b;
            if (messageHandler != null) {
                Message messageObtainMessage = messageHandler.obtainMessage(i2, obj);
                if (bundle != null) {
                    messageObtainMessage.setData(bundle);
                }
                messageObtainMessage.sendToTarget();
            }
        }

        public final void n(Handler handler) {
            if (handler != null) {
                MessageHandler messageHandler = new MessageHandler(handler.getLooper());
                this.f10569b = messageHandler;
                messageHandler.f10572a = true;
            } else {
                MessageHandler messageHandler2 = this.f10569b;
                if (messageHandler2 != null) {
                    messageHandler2.f10572a = false;
                    messageHandler2.removeCallbacksAndMessages(null);
                    this.f10569b = null;
                }
            }
        }
    }

    public interface MediaControllerImpl {
    }

    @RequiresApi
    public static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController f10575a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f10576b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f10577c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f10578d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public final MediaSessionCompat.Token f10579e;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public WeakReference f10580a;

            @Override // android.os.ResultReceiver
            public final void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f10580a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f10576b) {
                    MediaSessionCompat.Token token = mediaControllerImplApi21.f10579e;
                    IMediaSession iMediaSessionG = IMediaSession.Stub.g(bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER"));
                    synchronized (token.f10638a) {
                        token.f10640c = iMediaSessionG;
                    }
                    MediaSessionCompat.Token token2 = mediaControllerImplApi21.f10579e;
                    VersionedParcelable versionedParcelableA = ParcelUtils.a(bundle);
                    synchronized (token2.f10638a) {
                        token2.f10641d = versionedParcelableA;
                    }
                    mediaControllerImplApi21.a();
                }
            }
        }

        public static class ExtraCallback extends Callback.StubCompat {
            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void A0() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void G4(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void O7(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void T2(List list) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void d6(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback.StubCompat, androidx.media3.session.legacy.IMediaControllerCallback
            public final void z9(CharSequence charSequence) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f10579e = token;
            Object obj = token.f10639b;
            obj.getClass();
            MediaController mediaController = new MediaController(context, (MediaSession.Token) obj);
            this.f10575a = mediaController;
            if (token.a() == null) {
                ExtraBinderRequestResultReceiver extraBinderRequestResultReceiver = new ExtraBinderRequestResultReceiver(null);
                extraBinderRequestResultReceiver.f10580a = new WeakReference(this);
                mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, extraBinderRequestResultReceiver);
            }
        }

        public final void a() {
            IMediaSession iMediaSessionA = this.f10579e.a();
            if (iMediaSessionA == null) {
                return;
            }
            ArrayList arrayList = this.f10577c;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Callback callback = (Callback) it.next();
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.f10578d.put(callback, extraCallback);
                callback.f10570c = extraCallback;
                try {
                    iMediaSessionA.Rb(extraCallback);
                    callback.m(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            arrayList.clear();
        }

        public final void b(Callback callback) {
            MediaController mediaController = this.f10575a;
            MediaController.Callback callback2 = callback.f10568a;
            callback2.getClass();
            mediaController.unregisterCallback(callback2);
            synchronized (this.f10576b) {
                IMediaSession iMediaSessionA = this.f10579e.a();
                if (iMediaSessionA != null) {
                    try {
                        ExtraCallback extraCallback = (ExtraCallback) this.f10578d.remove(callback);
                        if (extraCallback != null) {
                            callback.f10570c = null;
                            iMediaSessionA.D9(extraCallback);
                        }
                    } catch (RemoteException e2) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e2);
                    }
                }
                this.f10577c.remove(callback);
            }
        }
    }

    @RequiresApi
    public static class MediaControllerImplApi29 extends MediaControllerImplApi21 {
    }

    public static class MediaControllerImplBase implements MediaControllerImpl {
    }

    public static final class PlaybackInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f10581a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioAttributesCompat f10582b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10583c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10584d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10585e;

        public PlaybackInfo(int i2, AudioAttributesCompat audioAttributesCompat, int i3, int i4, int i5) {
            this.f10581a = i2;
            this.f10582b = audioAttributesCompat;
            this.f10583c = i3;
            this.f10584d = i4;
            this.f10585e = i5;
        }
    }

    public static abstract class TransportControls {
        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(Bundle bundle, String str);

        public abstract void e(Bundle bundle, String str);

        public abstract void f(Uri uri, Bundle bundle);

        public abstract void g();

        public abstract void h(Bundle bundle, String str);

        public abstract void i(Bundle bundle, String str);

        public abstract void j(Uri uri, Bundle bundle);

        public abstract void k();

        public abstract void l(long j2);

        public abstract void m(Bundle bundle, String str);

        public abstract void n(float f2);

        public abstract void o(int i2);

        public abstract void p(int i2);

        public abstract void q();

        public abstract void r();

        public abstract void s(long j2);

        public abstract void t();
    }

    @RequiresApi
    public static class TransportControlsApi21 extends TransportControls {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController.TransportControls f10586a;

        public TransportControlsApi21(MediaController.TransportControls transportControls) {
            this.f10586a = transportControls;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void a() {
            this.f10586a.fastForward();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void b() {
            this.f10586a.pause();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void c() {
            this.f10586a.play();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void d(Bundle bundle, String str) {
            this.f10586a.playFromMediaId(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void e(Bundle bundle, String str) {
            this.f10586a.playFromSearch(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void f(Uri uri, Bundle bundle) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void g() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void h(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void i(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void j(Uri uri, Bundle bundle) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void k() {
            this.f10586a.rewind();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void l(long j2) {
            this.f10586a.seekTo(j2);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void m(Bundle bundle, String str) {
            if (str != null && ((str.equals("android.support.v4.media.session.action.FOLLOW") || str.equals("android.support.v4.media.session.action.UNFOLLOW")) && (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")))) {
                throw new IllegalArgumentException(b.D("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", str, CLConstants.DOT_SALT_DELIMETER));
            }
            this.f10586a.sendCustomAction(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public void n(float f2) {
            if (f2 == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f2);
            m(bundle, "android.support.v4.media.session.action.SET_PLAYBACK_SPEED");
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void o(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i2);
            m(bundle, "android.support.v4.media.session.action.SET_REPEAT_MODE");
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void p(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i2);
            m(bundle, "android.support.v4.media.session.action.SET_SHUFFLE_MODE");
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void q() {
            this.f10586a.skipToNext();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void r() {
            this.f10586a.skipToPrevious();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void s(long j2) {
            this.f10586a.skipToQueueItem(j2);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void t() {
            this.f10586a.stop();
        }
    }

    @RequiresApi
    public static class TransportControlsApi23 extends TransportControlsApi21 {
        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void f(Uri uri, Bundle bundle) {
            this.f10586a.playFromUri(uri, bundle);
        }
    }

    @RequiresApi
    public static class TransportControlsApi24 extends TransportControlsApi23 {
        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void g() {
            this.f10586a.prepare();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void h(Bundle bundle, String str) {
            this.f10586a.prepareFromMediaId(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void i(Bundle bundle, String str) {
            this.f10586a.prepareFromSearch(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void j(Uri uri, Bundle bundle) {
            this.f10586a.prepareFromUri(uri, bundle);
        }
    }

    @RequiresApi
    public static class TransportControlsApi29 extends TransportControlsApi24 {
        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControlsApi21, androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void n(float f2) {
            if (f2 == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            this.f10586a.setPlaybackSpeed(f2);
        }
    }

    public static class TransportControlsBase extends TransportControls {
        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void a() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void b() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void c() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void d(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void e(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void f(Uri uri, Bundle bundle) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void g() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void h(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void i(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void j(Uri uri, Bundle bundle) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void k() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void l(long j2) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void m(Bundle bundle, String str) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void n(float f2) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void o(int i2) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void p(int i2) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void q() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void r() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void s(long j2) {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.TransportControls
        public final void t() {
            throw null;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f10567b = Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.f10566a = new MediaControllerImplApi29(context, token);
        } else {
            this.f10566a = new MediaControllerImplApi21(context, token);
        }
    }

    public final void a(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        MediaControllerImplApi21 mediaControllerImplApi21 = this.f10566a;
        if ((mediaControllerImplApi21.f10575a.getFlags() & 4) == 0) {
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", LegacyParcelableUtil.a(mediaDescriptionCompat, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i2);
        mediaControllerImplApi21.f10575a.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
    }

    public final void b(int i2, int i3) {
        this.f10566a.f10575a.adjustVolume(i2, i3);
    }

    public final void c(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        this.f10566a.f10575a.dispatchMediaButtonEvent(keyEvent);
    }

    public final Bundle d() {
        return this.f10566a.f10575a.getExtras();
    }

    public final long e() {
        return this.f10566a.f10575a.getFlags();
    }

    public final MediaController f() {
        return this.f10566a.f10575a;
    }

    public final MediaMetadataCompat g() {
        MediaMetadata metadata = this.f10566a.f10575a.getMetadata();
        if (metadata == null) {
            return null;
        }
        ArrayMap arrayMap = MediaMetadataCompat.f10604c;
        Parcel parcelObtain = Parcel.obtain();
        metadata.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.f10607b = metadata;
        return mediaMetadataCompatCreateFromParcel;
    }

    public final String h() {
        return this.f10566a.f10575a.getPackageName();
    }

    public final PlaybackInfo i() {
        MediaController.PlaybackInfo playbackInfo = this.f10566a.f10575a.getPlaybackInfo();
        if (playbackInfo != null) {
            return new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.b(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
        return null;
    }

    public final PlaybackStateCompat j() {
        MediaControllerImplApi21 mediaControllerImplApi21 = this.f10566a;
        IMediaSession iMediaSessionA = mediaControllerImplApi21.f10579e.a();
        if (iMediaSessionA != null) {
            try {
                return iMediaSessionA.u();
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e2);
            }
        }
        PlaybackState playbackState = mediaControllerImplApi21.f10575a.getPlaybackState();
        if (playbackState != null) {
            return PlaybackStateCompat.a(playbackState);
        }
        return null;
    }

    public final ArrayList k() {
        List<MediaSession.QueueItem> queue = this.f10566a.f10575a.getQueue();
        if (queue != null) {
            return MediaSessionCompat.QueueItem.a(queue);
        }
        return null;
    }

    public final CharSequence l() {
        return this.f10566a.f10575a.getQueueTitle();
    }

    public final int m() {
        return this.f10566a.f10575a.getRatingType();
    }

    public final int n() {
        IMediaSession iMediaSessionA = this.f10566a.f10579e.a();
        if (iMediaSessionA == null) {
            return -1;
        }
        try {
            return iMediaSessionA.G();
        } catch (RemoteException e2) {
            Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e2);
            return -1;
        }
    }

    public final int o() {
        IMediaSession iMediaSessionA = this.f10566a.f10579e.a();
        if (iMediaSessionA == null) {
            return -1;
        }
        try {
            return iMediaSessionA.E0();
        } catch (RemoteException e2) {
            Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e2);
            return -1;
        }
    }

    public final TransportControls p() {
        MediaController.TransportControls transportControls = this.f10566a.f10575a.getTransportControls();
        return Build.VERSION.SDK_INT >= 29 ? new TransportControlsApi29(transportControls) : new TransportControlsApi24(transportControls);
    }

    public final boolean q() {
        IMediaSession iMediaSessionA = this.f10566a.f10579e.a();
        if (iMediaSessionA == null) {
            return false;
        }
        try {
            return iMediaSessionA.F0();
        } catch (RemoteException e2) {
            Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e2);
            return false;
        }
    }

    public final boolean r() {
        return this.f10566a.f10579e.a() != null;
    }

    public final void s(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (!this.f10567b.add(callback)) {
            Log.w("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        callback.n(handler);
        MediaControllerImplApi21 mediaControllerImplApi21 = this.f10566a;
        MediaController mediaController = mediaControllerImplApi21.f10575a;
        MediaController.Callback callback2 = callback.f10568a;
        callback2.getClass();
        mediaController.registerCallback(callback2, handler);
        synchronized (mediaControllerImplApi21.f10576b) {
            IMediaSession iMediaSessionA = mediaControllerImplApi21.f10579e.a();
            if (iMediaSessionA != null) {
                MediaControllerImplApi21.ExtraCallback extraCallback = new MediaControllerImplApi21.ExtraCallback(callback);
                mediaControllerImplApi21.f10578d.put(callback, extraCallback);
                callback.f10570c = extraCallback;
                try {
                    iMediaSessionA.Rb(extraCallback);
                    callback.m(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            } else {
                callback.f10570c = null;
                mediaControllerImplApi21.f10577c.add(callback);
            }
        }
    }

    public final void t(MediaDescriptionCompat mediaDescriptionCompat) {
        MediaControllerImplApi21 mediaControllerImplApi21 = this.f10566a;
        if ((mediaControllerImplApi21.f10575a.getFlags() & 4) == 0) {
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", LegacyParcelableUtil.a(mediaDescriptionCompat, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        mediaControllerImplApi21.f10575a.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
    }

    public final void u(String str, ResultReceiver resultReceiver) {
        Bundle bundle = Bundle.EMPTY;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.f10566a.f10575a.sendCommand(str, bundle, resultReceiver);
    }

    public final void v(int i2, int i3) {
        this.f10566a.f10575a.setVolumeTo(i2, i3);
    }

    public final void w(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (!this.f10567b.remove(callback)) {
            Log.w("MediaControllerCompat", "the callback has never been registered");
            return;
        }
        try {
            this.f10566a.b(callback);
        } finally {
            callback.n(null);
        }
    }
}
