package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.b;
import android.support.v4.media.session.IMediaSession;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.VolumeProviderCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaSessionCompat {

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$1, reason: invalid class name */
    class AnonymousClass1 extends Callback {
    }

    public static abstract class Callback {

        /* renamed from: a, reason: collision with root package name */
        public final Object f83a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f84b;

        public class CallbackHandler extends Handler {
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    throw null;
                }
            }
        }

        @RequiresApi
        public class MediaSessionCallbackApi21 extends MediaSession.Callback {
            public MediaSessionCallbackApi21() {
            }

            public final void a() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.f83a) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.f84b.get();
                }
                if (mediaSessionImplApi21 != null) {
                    throw null;
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onCustomAction(String str, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onFastForward() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final boolean onMediaButtonEvent(Intent intent) {
                a();
                return false;
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPause() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlay() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromMediaId(String str, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromSearch(String str, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPlayFromUri(Uri uri, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepare() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromMediaId(String str, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromSearch(String str, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onPrepareFromUri(Uri uri, Bundle bundle) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onRewind() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSeekTo(long j2) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSetPlaybackSpeed(float f2) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSetRating(Rating rating) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToNext() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToPrevious() {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onSkipToQueueItem(long j2) {
                a();
            }

            @Override // android.media.session.MediaSession.Callback
            public final void onStop() {
                a();
            }
        }

        public Callback() {
            new MediaSessionCallbackApi21();
            this.f84b = new WeakReference(null);
        }
    }

    public interface MediaSessionImpl {
    }

    @RequiresApi
    public static class MediaSessionImplApi18 extends MediaSessionImplBase {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1, reason: invalid class name */
        class AnonymousClass1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public final void onPlaybackPositionUpdate(long j2) {
                throw null;
            }
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1, reason: invalid class name */
        class AnonymousClass1 implements RemoteControlClient.OnMetadataUpdateListener {
            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public final void onMetadataUpdate(int i2, Object obj) {
                if (i2 == 268435457 && (obj instanceof Rating)) {
                    RatingCompat.a((Rating) obj);
                    throw null;
                }
            }
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi21 implements MediaSessionImpl {

        public static class ExtraSession extends IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public final void B2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void E() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int E0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void E1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final long F() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean F0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int G() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void I0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void I4() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void K8() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void M2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void O5() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void P3() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void Q8() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean T0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void U3() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void U5() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final String V() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final CharSequence V0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void V8() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void W6(IMediaControllerCallback iMediaControllerCallback) {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void a1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void c4() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final PendingIntent k0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void k4() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void k5() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int l0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final List m1() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final ParcelableVolumeInfo o1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void p() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void pause() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final Bundle r0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void r9() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void s1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void s7() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void t1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final PlaybackStateCompat u() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void u3() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void vb() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void w7() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean wa() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void x2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final String z() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void z5() {
                throw new AssertionError();
            }
        }
    }

    @RequiresApi
    public static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
    }

    @RequiresApi
    public static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
    }

    @RequiresApi
    public static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1, reason: invalid class name */
        public class AnonymousClass1 extends VolumeProviderCompat.Callback {
        }

        public static final class Command {
        }

        public static class MediaSessionStub extends IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public final void B2() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void E() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int E0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void E1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final long F() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean F0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int G() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void I0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void I4() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void K8() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void M2() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void O5() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void P3() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void Q8() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean T0() {
                return true;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void U3() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void U5() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final String V() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final CharSequence V0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void V8() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void W6(IMediaControllerCallback iMediaControllerCallback) {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void a1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void c4() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final Bundle getExtras() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final MediaMetadataCompat getMetadata() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final PendingIntent k0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void k4() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void k5() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final int l0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final List m1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void next() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final ParcelableVolumeInfo o1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void p() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void pause() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void previous() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final Bundle r0() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void r9() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void s1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void s7() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void stop() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void t1() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final PlaybackStateCompat u() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void u3() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void vb() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void w7() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean wa() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void x2() {
                throw null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final String z() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void z5() {
                throw null;
            }
        }

        public class MessageHandler extends Handler {
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                throw null;
            }
        }
    }

    public interface OnActiveChangeListener {
    }

    @RestrictTo
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
        public ResultReceiver f88a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                ResultReceiverWrapper resultReceiverWrapper = new ResultReceiverWrapper();
                resultReceiverWrapper.f88a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
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
            this.f88a.writeToParcel(parcel, i2);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new AnonymousClass1();

        /* renamed from: b, reason: collision with root package name */
        public final Parcelable f90b;

        /* renamed from: c, reason: collision with root package name */
        public IMediaSession f91c;

        /* renamed from: a, reason: collision with root package name */
        public final Object f89a = new Object();

        /* renamed from: d, reason: collision with root package name */
        public VersionedParcelable f92d = null;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            public final Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null), null);
            }

            @Override // android.os.Parcelable.Creator
            public final Token[] newArray(int i2) {
                return new Token[i2];
            }
        }

        public Token(Parcelable parcelable, IMediaSession iMediaSession) {
            this.f90b = parcelable;
            this.f91c = iMediaSession;
        }

        public final IMediaSession a() {
            IMediaSession iMediaSession;
            synchronized (this.f89a) {
                iMediaSession = this.f91c;
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
            Parcelable parcelable = this.f90b;
            if (parcelable == null) {
                return token.f90b == null;
            }
            Parcelable parcelable2 = token.f90b;
            if (parcelable2 == null) {
                return false;
            }
            return parcelable.equals(parcelable2);
        }

        public final int hashCode() {
            Parcelable parcelable = this.f90b;
            if (parcelable == null) {
                return 0;
            }
            return parcelable.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f90b, i2);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static Bundle b(Bundle bundle) {
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

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f86a;

        /* renamed from: b, reason: collision with root package name */
        public final long f87b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1, reason: invalid class name */
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

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j2 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f86a = mediaDescriptionCompat;
            this.f87b = j2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
            sb.append(this.f86a);
            sb.append(", Id=");
            return b.p(sb, this.f87b, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            this.f86a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f87b);
        }

        public QueueItem(Parcel parcel) {
            this.f86a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f87b = parcel.readLong();
        }
    }
}
