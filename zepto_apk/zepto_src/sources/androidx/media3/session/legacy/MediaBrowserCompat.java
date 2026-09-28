package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaBrowserCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f10433b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public final MediaBrowserImplApi23 f10434a;

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        public static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    public static class CallbackHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f10435a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference f10436b;

        public CallbackHandler(MediaBrowserImplApi21 mediaBrowserImplApi21) {
            this.f10435a = new WeakReference(mediaBrowserImplApi21);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            WeakReference weakReference = this.f10436b;
            if (weakReference == null) {
                return;
            }
            Messenger messenger = (Messenger) weakReference.get();
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) this.f10435a.get();
            if (messenger == null || mediaBrowserServiceCallbackImpl == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            try {
                int i2 = message.what;
                if (i2 == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    mediaBrowserServiceCallbackImpl.c(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) LegacyParcelableUtil.a(data.getParcelable("data_media_session_token"), MediaSessionCompat.Token.CREATOR), bundle);
                    return;
                }
                if (i2 == 2) {
                    mediaBrowserServiceCallbackImpl.a(messenger);
                    return;
                }
                if (i2 != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                    return;
                }
                Bundle bundle2 = data.getBundle("data_options");
                MediaSessionCompat.a(bundle2);
                Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                MediaSessionCompat.a(bundle3);
                mediaBrowserServiceCallbackImpl.b(messenger, data.getString("data_media_item_id"), LegacyParcelableUtil.b(data.getParcelableArrayList("data_media_item_list"), MediaItem.CREATOR), bundle2, bundle3);
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.a(messenger);
                }
            }
        }
    }

    public static class ConnectionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final MediaBrowser.ConnectionCallback f10437a = new ConnectionCallbackApi21();

        /* renamed from: b, reason: collision with root package name */
        public MediaBrowserImplApi21 f10438b;

        @RequiresApi
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnected() {
                ConnectionCallback connectionCallback = ConnectionCallback.this;
                MediaBrowserImplApi21 mediaBrowserImplApi21 = connectionCallback.f10438b;
                if (mediaBrowserImplApi21 != null) {
                    MediaBrowser mediaBrowser = mediaBrowserImplApi21.f10442b;
                    try {
                        Bundle extras = mediaBrowser.getExtras();
                        if (extras != null) {
                            extras.getInt("extra_service_version", 0);
                            IBinder binder = extras.getBinder("extra_messenger");
                            if (binder != null) {
                                ServiceBinderWrapper serviceBinderWrapper = new ServiceBinderWrapper();
                                serviceBinderWrapper.f10457a = new Messenger(binder);
                                serviceBinderWrapper.f10458b = mediaBrowserImplApi21.f10443c;
                                mediaBrowserImplApi21.f10446f = serviceBinderWrapper;
                                CallbackHandler callbackHandler = mediaBrowserImplApi21.f10444d;
                                Messenger messenger = new Messenger(callbackHandler);
                                mediaBrowserImplApi21.f10447g = messenger;
                                callbackHandler.getClass();
                                callbackHandler.f10436b = new WeakReference(messenger);
                                try {
                                    Context context = mediaBrowserImplApi21.f10441a;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data_package_name", context.getPackageName());
                                    bundle.putInt("data_calling_pid", Process.myPid());
                                    bundle.putBundle("data_root_hints", serviceBinderWrapper.f10458b);
                                    serviceBinderWrapper.a(6, bundle, messenger);
                                } catch (RemoteException unused) {
                                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                }
                            }
                            IMediaSession iMediaSessionG = IMediaSession.Stub.g(extras.getBinder("extra_session_binder"));
                            if (iMediaSessionG != null) {
                                MediaSession.Token sessionToken = mediaBrowser.getSessionToken();
                                Assertions.g(sessionToken != null);
                                if (sessionToken == null) {
                                    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
                                }
                                mediaBrowserImplApi21.f10448h = new MediaSessionCompat.Token(sessionToken, iMediaSessionG, null);
                            }
                        }
                    } catch (IllegalStateException e2) {
                        Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e2);
                    }
                }
                connectionCallback.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnectionFailed() {
                ConnectionCallback.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnectionSuspended() {
                ConnectionCallback connectionCallback = ConnectionCallback.this;
                MediaBrowserImplApi21 mediaBrowserImplApi21 = connectionCallback.f10438b;
                if (mediaBrowserImplApi21 != null) {
                    mediaBrowserImplApi21.f10446f = null;
                    mediaBrowserImplApi21.f10447g = null;
                    mediaBrowserImplApi21.f10448h = null;
                    CallbackHandler callbackHandler = mediaBrowserImplApi21.f10444d;
                    callbackHandler.getClass();
                    callbackHandler.f10436b = new WeakReference(null);
                }
                connectionCallback.c();
            }
        }

        public interface ConnectionCallbackInternal {
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public static abstract class CustomActionCallback {
    }

    @SuppressLint({"RestrictedApi"})
    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.t(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                throw null;
            }
            throw null;
        }
    }

    public interface MediaBrowserImpl {
    }

    @RequiresApi
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {

        /* renamed from: a, reason: collision with root package name */
        public final Context f10441a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaBrowser f10442b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f10443c;

        /* renamed from: d, reason: collision with root package name */
        public final CallbackHandler f10444d = new CallbackHandler(this);

        /* renamed from: e, reason: collision with root package name */
        public final ArrayMap f10445e = new ArrayMap();

        /* renamed from: f, reason: collision with root package name */
        public ServiceBinderWrapper f10446f;

        /* renamed from: g, reason: collision with root package name */
        public Messenger f10447g;

        /* renamed from: h, reason: collision with root package name */
        public MediaSessionCompat.Token f10448h;

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$6, reason: invalid class name */
        class AnonymousClass6 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplApi21$7, reason: invalid class name */
        class AnonymousClass7 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback) {
            this.f10441a = context;
            Bundle bundle = new Bundle();
            this.f10443c = bundle;
            bundle.putInt("extra_client_version", 1);
            bundle.putInt("extra_calling_pid", Process.myPid());
            connectionCallback.f10438b = this;
            MediaBrowser.ConnectionCallback connectionCallback2 = connectionCallback.f10437a;
            connectionCallback2.getClass();
            this.f10442b = new MediaBrowser(context, componentName, connectionCallback2, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void a(Messenger messenger) {
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void b(Messenger messenger, String str, ArrayList arrayList, Bundle bundle, Bundle bundle2) {
            SubscriptionCallback subscriptionCallback;
            if (this.f10447g != messenger) {
                return;
            }
            Subscription subscription = str == null ? null : (Subscription) this.f10445e.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.f10433b) {
                    a.t("onLoadChildren for id that isn't subscribed id=", str, "MediaBrowserCompat");
                    return;
                }
                return;
            }
            int i2 = 0;
            while (true) {
                ArrayList arrayList2 = subscription.f10460b;
                if (i2 >= arrayList2.size()) {
                    subscriptionCallback = null;
                    break;
                } else {
                    if (MediaBrowserCompatUtils.a((Bundle) arrayList2.get(i2), bundle)) {
                        subscriptionCallback = (SubscriptionCallback) subscription.f10459a.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            if (subscriptionCallback != null) {
                if (bundle == null) {
                    if (arrayList == null) {
                        subscriptionCallback.c();
                        return;
                    } else {
                        subscriptionCallback.a(str, arrayList);
                        return;
                    }
                }
                if (arrayList == null) {
                    subscriptionCallback.d();
                } else {
                    subscriptionCallback.b(str, arrayList);
                }
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    @RequiresApi
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
    }

    @RequiresApi
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* renamed from: a, reason: collision with root package name */
        public int f10449a;

        /* renamed from: b, reason: collision with root package name */
        public MediaServiceConnection f10450b;

        /* renamed from: c, reason: collision with root package name */
        public ServiceBinderWrapper f10451c;

        /* renamed from: d, reason: collision with root package name */
        public Messenger f10452d;

        /* renamed from: e, reason: collision with root package name */
        public String f10453e;

        /* renamed from: f, reason: collision with root package name */
        public MediaSessionCompat.Token f10454f;

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$6, reason: invalid class name */
        class AnonymousClass6 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        public class MediaServiceConnection implements ServiceConnection {

            /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1, reason: invalid class name */
            class AnonymousClass1 implements Runnable {
                @Override // java.lang.Runnable
                public final void run() {
                    if (!MediaBrowserCompat.f10433b) {
                        throw null;
                    }
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + ((Object) null) + " binder=" + ((Object) null));
                    throw null;
                }
            }

            /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2, reason: invalid class name */
            class AnonymousClass2 implements Runnable {
                @Override // java.lang.Runnable
                public final void run() {
                    if (!MediaBrowserCompat.f10433b) {
                        throw null;
                    }
                    toString();
                    throw null;
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Thread.currentThread();
                throw null;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                Thread.currentThread();
                throw null;
            }
        }

        public static String d(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? b.f(i2, "UNKNOWN/") : "CONNECT_STATE_SUSPENDED" : "CONNECT_STATE_CONNECTED" : "CONNECT_STATE_CONNECTING" : "CONNECT_STATE_DISCONNECTED" : "CONNECT_STATE_DISCONNECTING";
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void a(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for null");
            if (e(messenger, "onConnectFailed")) {
                if (this.f10449a != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + d(this.f10449a) + "... ignoring");
                    return;
                }
                if (this.f10450b != null) {
                    throw null;
                }
                this.f10449a = 1;
                this.f10450b = null;
                this.f10451c = null;
                this.f10452d = null;
                throw null;
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void b(Messenger messenger, String str, ArrayList arrayList, Bundle bundle, Bundle bundle2) {
            if (e(messenger, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.f10433b;
                if (z) {
                    a.t("onLoadChildren for null id=", str, "MediaBrowserCompat");
                }
                if (str != null) {
                    throw null;
                }
                if (z) {
                    a.t("onLoadChildren for id that isn't subscribed id=", str, "MediaBrowserCompat");
                }
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (e(messenger, "onConnect")) {
                if (this.f10449a != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + d(this.f10449a) + "... ignoring");
                    return;
                }
                this.f10453e = str;
                this.f10454f = token;
                this.f10449a = 3;
                if (MediaBrowserCompat.f10433b) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
                    Log.d("MediaBrowserCompat", "  mServiceComponent=null");
                    Log.d("MediaBrowserCompat", "  mCallback=null");
                    Log.d("MediaBrowserCompat", "  mRootHints=null");
                    Log.d("MediaBrowserCompat", "  mState=" + d(this.f10449a));
                    Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f10450b);
                    Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f10451c);
                    Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f10452d);
                    Log.d("MediaBrowserCompat", "  mRootId=" + this.f10453e);
                    Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f10454f);
                }
                throw null;
            }
        }

        public final boolean e(Messenger messenger, String str) {
            int i2;
            if (this.f10452d == messenger && (i2 = this.f10449a) != 0 && i2 != 1) {
                return true;
            }
            int i3 = this.f10449a;
            if (i3 == 0 || i3 == 1) {
                return false;
            }
            StringBuilder sbX = b.x(str, " for null with mCallbacksMessenger=");
            sbX.append(this.f10452d);
            sbX.append(" this=");
            sbX.append(this);
            Log.i("MediaBrowserCompat", sbX.toString());
            return false;
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void a(Messenger messenger);

        void b(Messenger messenger, String str, ArrayList arrayList, Bundle bundle, Bundle bundle2);

        void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    public static abstract class SearchCallback {
    }

    @SuppressLint({"RestrictedApi"})
    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.t(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            parcelableArray.getClass();
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) LegacyParcelableUtil.a(parcelable, MediaItem.CREATOR));
            }
            throw null;
        }
    }

    public static class ServiceBinderWrapper {

        /* renamed from: a, reason: collision with root package name */
        public Messenger f10457a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f10458b;

        public final void a(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = 1;
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            messageObtain.replyTo = messenger;
            this.f10457a.send(messageObtain);
        }
    }

    public static class Subscription {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10459a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f10460b = new ArrayList();
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10434a = new MediaBrowserImplApi26(context, componentName, connectionCallback);
        } else {
            this.f10434a = new MediaBrowserImplApi23(context, componentName, connectionCallback);
        }
    }

    public final void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f10434a.f10442b.connect();
    }

    public final void b() {
        Messenger messenger;
        MediaBrowserImplApi23 mediaBrowserImplApi23 = this.f10434a;
        ServiceBinderWrapper serviceBinderWrapper = mediaBrowserImplApi23.f10446f;
        if (serviceBinderWrapper != null && (messenger = mediaBrowserImplApi23.f10447g) != null) {
            try {
                serviceBinderWrapper.a(7, null, messenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        mediaBrowserImplApi23.f10442b.disconnect();
    }

    public final MediaSessionCompat.Token c() {
        MediaBrowserImplApi23 mediaBrowserImplApi23 = this.f10434a;
        if (mediaBrowserImplApi23.f10448h == null) {
            MediaSession.Token sessionToken = mediaBrowserImplApi23.f10442b.getSessionToken();
            Assertions.g(sessionToken != null);
            if (sessionToken == null) {
                throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
            }
            mediaBrowserImplApi23.f10448h = new MediaSessionCompat.Token(sessionToken, null, null);
        }
        return mediaBrowserImplApi23.f10448h;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final int f10455a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaDescriptionCompat f10456b;

        /* renamed from: androidx.media3.session.legacy.MediaBrowserCompat$MediaItem$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            public final MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.f10587a)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f10455a = i2;
            this.f10456b = mediaDescriptionCompat;
        }

        public static ArrayList a(List list) {
            MediaItem mediaItem;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) obj;
                    mediaItem = new MediaItem(MediaDescriptionCompat.a(Api21Impl.a(mediaItem2)), Api21Impl.b(mediaItem2));
                } else {
                    mediaItem = null;
                }
                if (mediaItem != null) {
                    arrayList.add(mediaItem);
                }
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaItem{mFlags=" + this.f10455a + ", mDescription=" + this.f10456b + '}';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f10455a);
            this.f10456b.writeToParcel(parcel, i2);
        }

        public MediaItem(Parcel parcel) {
            this.f10455a = parcel.readInt();
            this.f10456b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    public static abstract class ItemCallback {

        @RequiresApi
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public final void onError(String str) {
                ItemCallback.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public final void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                MediaItem mediaItem2;
                if (mediaItem != null) {
                    mediaItem2 = new MediaItem(MediaDescriptionCompat.a(Api21Impl.a(mediaItem)), Api21Impl.b(mediaItem));
                } else {
                    mediaItem2 = null;
                }
                ItemCallback.this.b(mediaItem2);
            }
        }

        public ItemCallback() {
            new ItemCallbackApi23();
        }

        public void b(MediaItem mediaItem) {
        }

        public void a() {
        }
    }

    public static abstract class SubscriptionCallback {

        @RequiresApi
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onChildrenLoaded(String str, List list) {
                SubscriptionCallback.this.a(str, MediaItem.a(list));
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onError(String str) {
                SubscriptionCallback.this.c();
            }
        }

        @RequiresApi
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onChildrenLoaded(String str, List list, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                SubscriptionCallback.this.b(str, MediaItem.a(list));
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onError(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                SubscriptionCallback.this.d();
            }
        }

        public SubscriptionCallback() {
            new Binder();
            if (Build.VERSION.SDK_INT >= 26) {
                new SubscriptionCallbackApi26();
            } else {
                new SubscriptionCallbackApi21();
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void a(String str, ArrayList arrayList) {
        }

        public void b(String str, ArrayList arrayList) {
        }
    }
}
