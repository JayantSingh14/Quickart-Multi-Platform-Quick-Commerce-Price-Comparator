package android.support.v4.media.session;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final MediaControllerImplApi21 f73a;

    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public IMediaControllerCallback f74a;

        @RequiresApi
        public static class MediaControllerCallbackApi21 extends MediaController.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f75a;

            public MediaControllerCallbackApi21(Callback callback) {
                this.f75a = new WeakReference(callback);
            }

            @Override // android.media.session.MediaController.Callback
            public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                if (((Callback) this.f75a.get()) != null) {
                    playbackInfo.getPlaybackType();
                    playbackInfo.getAudioAttributes();
                    if (Build.VERSION.SDK_INT >= 26) {
                    }
                    playbackInfo.getVolumeControl();
                    playbackInfo.getMaxVolume();
                    playbackInfo.getCurrentVolume();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.a(bundle);
            }

            @Override // android.media.session.MediaController.Callback
            public final void onMetadataChanged(MediaMetadata mediaMetadata) {
                if (((Callback) this.f75a.get()) != null) {
                    Parcelable.Creator<MediaMetadataCompat> creator = MediaMetadataCompat.CREATOR;
                    if (mediaMetadata != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaMetadata.writeToParcel(parcelObtain, 0);
                        parcelObtain.setDataPosition(0);
                        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        mediaMetadataCompatCreateFromParcel.getClass();
                    }
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onPlaybackStateChanged(PlaybackState playbackState) {
                ArrayList arrayList;
                PlaybackStateCompat.CustomAction customAction;
                Callback callback = (Callback) this.f75a.get();
                if (callback == null || callback.f74a != null || playbackState == null) {
                    return;
                }
                List<PlaybackState.CustomAction> listJ = PlaybackStateCompat.Api21Impl.j(playbackState);
                if (listJ != null) {
                    ArrayList arrayList2 = new ArrayList(listJ.size());
                    for (PlaybackState.CustomAction customAction2 : listJ) {
                        if (customAction2 != null) {
                            PlaybackState.CustomAction customAction3 = customAction2;
                            Bundle bundleL = PlaybackStateCompat.Api21Impl.l(customAction3);
                            MediaSessionCompat.a(bundleL);
                            customAction = new PlaybackStateCompat.CustomAction(PlaybackStateCompat.Api21Impl.f(customAction3), PlaybackStateCompat.Api21Impl.o(customAction3), PlaybackStateCompat.Api21Impl.m(customAction3), bundleL);
                        } else {
                            customAction = null;
                        }
                        arrayList2.add(customAction);
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                Bundle bundleA = PlaybackStateCompat.Api22Impl.a(playbackState);
                MediaSessionCompat.a(bundleA);
                new PlaybackStateCompat(PlaybackStateCompat.Api21Impl.r(playbackState), PlaybackStateCompat.Api21Impl.q(playbackState), PlaybackStateCompat.Api21Impl.i(playbackState), PlaybackStateCompat.Api21Impl.p(playbackState), PlaybackStateCompat.Api21Impl.g(playbackState), 0, PlaybackStateCompat.Api21Impl.k(playbackState), PlaybackStateCompat.Api21Impl.n(playbackState), arrayList, PlaybackStateCompat.Api21Impl.h(playbackState), bundleA);
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueChanged(List list) {
                MediaSessionCompat.QueueItem queueItem;
                if (((Callback) this.f75a.get()) == null || list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj != null) {
                        MediaSession.QueueItem queueItem2 = (MediaSession.QueueItem) obj;
                        queueItem = new MediaSessionCompat.QueueItem(MediaDescriptionCompat.a(MediaSessionCompat.QueueItem.Api21Impl.b(queueItem2)), MediaSessionCompat.QueueItem.Api21Impl.c(queueItem2));
                    } else {
                        queueItem = null;
                    }
                    arrayList.add(queueItem);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueTitleChanged(CharSequence charSequence) {
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionDestroyed() {
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
            }
        }

        public class MessageHandler extends Handler {
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
            }
        }

        public static class StubCompat extends IMediaControllerCallback.Stub {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f76a;

            public StubCompat(Callback callback) {
                this.f76a = new WeakReference(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void A0() {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void C3() {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void Ja() {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void M6(ParcelableVolumeInfo parcelableVolumeInfo) {
                if (((Callback) this.f76a.get()) == null || parcelableVolumeInfo == null) {
                    return;
                }
                AudioAttributesCompat.Builder builder = new AudioAttributesCompat.Builder();
                builder.a(parcelableVolumeInfo.f94b);
                builder.f5027a.build();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void k2() {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void kb() {
            }
        }

        public Callback() {
            new MediaControllerCallbackApi21(this);
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
        }
    }

    public interface MediaControllerImpl {
    }

    @RequiresApi
    public static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController f77a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f78b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f79c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f80d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public final MediaSessionCompat.Token f81e;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public WeakReference f82a;

            @Override // android.os.ResultReceiver
            public final void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f82a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f78b) {
                    MediaSessionCompat.Token token = mediaControllerImplApi21.f81e;
                    IMediaSession iMediaSessionG = IMediaSession.Stub.g(bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER"));
                    synchronized (token.f89a) {
                        token.f91c = iMediaSessionG;
                    }
                    MediaSessionCompat.Token token2 = mediaControllerImplApi21.f81e;
                    VersionedParcelable versionedParcelableA = ParcelUtils.a(bundle);
                    synchronized (token2.f89a) {
                        token2.f92d = versionedParcelableA;
                    }
                    mediaControllerImplApi21.a();
                }
            }
        }

        public static class ExtraCallback extends Callback.StubCompat {
            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void A0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void C3() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void Ja() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void M6(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void k2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public final void kb() {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f81e = token;
            MediaController mediaController = new MediaController(context, (MediaSession.Token) token.f90b);
            this.f77a = mediaController;
            if (token.a() == null) {
                ExtraBinderRequestResultReceiver extraBinderRequestResultReceiver = new ExtraBinderRequestResultReceiver(null);
                extraBinderRequestResultReceiver.f82a = new WeakReference(this);
                mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, extraBinderRequestResultReceiver);
            }
        }

        public final void a() {
            MediaSessionCompat.Token token = this.f81e;
            if (token.a() == null) {
                return;
            }
            ArrayList arrayList = this.f79c;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Callback callback = (Callback) it.next();
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.f80d.put(callback, extraCallback);
                callback.f74a = extraCallback;
                try {
                    token.a().W6(extraCallback);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            arrayList.clear();
        }
    }

    @RequiresApi
    public static class MediaControllerImplApi29 extends MediaControllerImplApi21 {
    }

    public static class MediaControllerImplBase implements MediaControllerImpl {
    }

    public static final class PlaybackInfo {
    }

    public static abstract class TransportControls {
    }

    @RequiresApi
    public static class TransportControlsApi21 extends TransportControls {
    }

    @RequiresApi
    public static class TransportControlsApi23 extends TransportControlsApi21 {
    }

    @RequiresApi
    public static class TransportControlsApi24 extends TransportControlsApi23 {
    }

    @RequiresApi
    public static class TransportControlsApi29 extends TransportControlsApi24 {
    }

    public static class TransportControlsBase extends TransportControls {
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.f73a = new MediaControllerImplApi29(context, token);
        } else {
            this.f73a = new MediaControllerImplApi21(context, token);
        }
    }

    public final void a(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        this.f73a.f77a.dispatchMediaButtonEvent(keyEvent);
    }
}
