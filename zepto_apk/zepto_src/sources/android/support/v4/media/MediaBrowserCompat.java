package android.support.v4.media;

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
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserCompatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class MediaBrowserCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f21b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public final MediaBrowserImplApi23 f22a;

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
        public final WeakReference f23a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference f24b;

        public CallbackHandler(MediaBrowserImplApi21 mediaBrowserImplApi21) {
            this.f23a = new WeakReference(mediaBrowserImplApi21);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            WeakReference weakReference = this.f24b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            WeakReference weakReference2 = this.f23a;
            if (weakReference2.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) weakReference2.get();
            Messenger messenger = (Messenger) this.f24b.get();
            try {
                int i2 = message.what;
                if (i2 == 1) {
                    MediaSessionCompat.a(data.getBundle("data_root_hints"));
                    mediaBrowserServiceCallbackImpl.c(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"));
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
                Bundle bundle = data.getBundle("data_options");
                MediaSessionCompat.a(bundle);
                MediaSessionCompat.a(data.getBundle("data_notify_children_changed_options"));
                String string = data.getString("data_media_item_id");
                data.getParcelableArrayList("data_media_item_list");
                mediaBrowserServiceCallbackImpl.b(messenger, string, bundle);
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
        public final MediaBrowser.ConnectionCallback f25a = new ConnectionCallbackApi21();

        /* renamed from: b, reason: collision with root package name */
        public MediaBrowserImplApi21 f26b;

        @RequiresApi
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnected() {
                ConnectionCallback connectionCallback = ConnectionCallback.this;
                MediaBrowserImplApi21 mediaBrowserImplApi21 = connectionCallback.f26b;
                if (mediaBrowserImplApi21 != null) {
                    MediaBrowser mediaBrowser = mediaBrowserImplApi21.f30b;
                    try {
                        Bundle extras = mediaBrowser.getExtras();
                        if (extras != null) {
                            extras.getInt("extra_service_version", 0);
                            IBinder binder = extras.getBinder("extra_messenger");
                            if (binder != null) {
                                ServiceBinderWrapper serviceBinderWrapper = new ServiceBinderWrapper();
                                serviceBinderWrapper.f45a = new Messenger(binder);
                                serviceBinderWrapper.f46b = mediaBrowserImplApi21.f31c;
                                mediaBrowserImplApi21.f34f = serviceBinderWrapper;
                                CallbackHandler callbackHandler = mediaBrowserImplApi21.f32d;
                                Messenger messenger = new Messenger(callbackHandler);
                                mediaBrowserImplApi21.f35g = messenger;
                                callbackHandler.getClass();
                                callbackHandler.f24b = new WeakReference(messenger);
                                try {
                                    ServiceBinderWrapper serviceBinderWrapper2 = mediaBrowserImplApi21.f34f;
                                    Context context = mediaBrowserImplApi21.f29a;
                                    Messenger messenger2 = mediaBrowserImplApi21.f35g;
                                    serviceBinderWrapper2.getClass();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data_package_name", context.getPackageName());
                                    bundle.putInt("data_calling_pid", Process.myPid());
                                    bundle.putBundle("data_root_hints", serviceBinderWrapper2.f46b);
                                    serviceBinderWrapper2.a(6, bundle, messenger2);
                                } catch (RemoteException unused) {
                                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                }
                            }
                            IMediaSession iMediaSessionG = IMediaSession.Stub.g(extras.getBinder("extra_session_binder"));
                            if (iMediaSessionG != null) {
                                MediaSession.Token sessionToken = mediaBrowser.getSessionToken();
                                mediaBrowserImplApi21.f36h = sessionToken != null ? new MediaSessionCompat.Token(sessionToken, iMediaSessionG) : null;
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
                MediaBrowserImplApi21 mediaBrowserImplApi21 = connectionCallback.f26b;
                if (mediaBrowserImplApi21 != null) {
                    mediaBrowserImplApi21.f34f = null;
                    mediaBrowserImplApi21.f35g = null;
                    mediaBrowserImplApi21.f36h = null;
                    CallbackHandler callbackHandler = mediaBrowserImplApi21.f32d;
                    callbackHandler.getClass();
                    callbackHandler.f24b = new WeakReference(null);
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

    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
        }
    }

    public static abstract class ItemCallback {

        @RequiresApi
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public final void onError(String str) {
                ItemCallback.this.getClass();
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public final void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                if (mediaItem != null) {
                    new MediaItem(MediaDescriptionCompat.a(Api21Impl.a(mediaItem)), Api21Impl.b(mediaItem));
                }
            }
        }

        public ItemCallback() {
            new ItemCallbackApi23();
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            throw null;
        }
    }

    public interface MediaBrowserImpl {
    }

    @RequiresApi
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
    }

    @RequiresApi
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* renamed from: a, reason: collision with root package name */
        public int f37a;

        /* renamed from: b, reason: collision with root package name */
        public MediaServiceConnection f38b;

        /* renamed from: c, reason: collision with root package name */
        public ServiceBinderWrapper f39c;

        /* renamed from: d, reason: collision with root package name */
        public Messenger f40d;

        /* renamed from: e, reason: collision with root package name */
        public String f41e;

        /* renamed from: f, reason: collision with root package name */
        public MediaSessionCompat.Token f42f;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6, reason: invalid class name */
        class AnonymousClass6 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        public class MediaServiceConnection implements ServiceConnection {

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1, reason: invalid class name */
            class AnonymousClass1 implements Runnable {
                @Override // java.lang.Runnable
                public final void run() {
                    if (!MediaBrowserCompat.f21b) {
                        throw null;
                    }
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + ((Object) null) + " binder=" + ((Object) null));
                    throw null;
                }
            }

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2, reason: invalid class name */
            class AnonymousClass2 implements Runnable {
                @Override // java.lang.Runnable
                public final void run() {
                    if (!MediaBrowserCompat.f21b) {
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

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void a(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for null");
            if (e(messenger, "onConnectFailed")) {
                if (this.f37a != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + d(this.f37a) + "... ignoring");
                    return;
                }
                if (this.f38b != null) {
                    throw null;
                }
                this.f37a = 1;
                this.f38b = null;
                this.f39c = null;
                this.f40d = null;
                throw null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void b(Messenger messenger, String str, Bundle bundle) {
            if (e(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f21b) {
                    a.t("onLoadChildren for null id=", str, "MediaBrowserCompat");
                }
                throw null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void c(Messenger messenger, String str, MediaSessionCompat.Token token) {
            if (e(messenger, "onConnect")) {
                if (this.f37a != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + d(this.f37a) + "... ignoring");
                    return;
                }
                this.f41e = str;
                this.f42f = token;
                this.f37a = 3;
                if (MediaBrowserCompat.f21b) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
                    Log.d("MediaBrowserCompat", "  mServiceComponent=null");
                    Log.d("MediaBrowserCompat", "  mCallback=null");
                    Log.d("MediaBrowserCompat", "  mRootHints=null");
                    Log.d("MediaBrowserCompat", "  mState=" + d(this.f37a));
                    Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f38b);
                    Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f39c);
                    Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f40d);
                    Log.d("MediaBrowserCompat", "  mRootId=" + this.f41e);
                    Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f42f);
                }
                throw null;
            }
        }

        public final boolean e(Messenger messenger, String str) {
            int i2;
            if (this.f40d == messenger && (i2 = this.f37a) != 0 && i2 != 1) {
                return true;
            }
            int i3 = this.f37a;
            if (i3 == 0 || i3 == 1) {
                return false;
            }
            StringBuilder sbX = b.x(str, " for null with mCallbacksMessenger=");
            sbX.append(this.f40d);
            sbX.append(" this=");
            sbX.append(this);
            Log.i("MediaBrowserCompat", sbX.toString());
            return false;
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void a(Messenger messenger);

        void b(Messenger messenger, String str, Bundle bundle);

        void c(Messenger messenger, String str, MediaSessionCompat.Token token);
    }

    public static abstract class SearchCallback {
    }

    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            parcelableArray.getClass();
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            throw null;
        }
    }

    public static class ServiceBinderWrapper {

        /* renamed from: a, reason: collision with root package name */
        public Messenger f45a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f46b;

        public final void a(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f45a.send(messageObtain);
        }
    }

    public static class Subscription {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f47a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f48b = new ArrayList();
    }

    public static abstract class SubscriptionCallback {

        @RequiresApi
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onChildrenLoaded(String str, List list) {
                MediaItem.a(list);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onError(String str) {
                SubscriptionCallback.this.getClass();
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
                MediaItem.a(list);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public final void onError(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                SubscriptionCallback.this.getClass();
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
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f22a = new MediaBrowserImplApi26(context, componentName, connectionCallback);
        } else {
            this.f22a = new MediaBrowserImplApi23(context, componentName, connectionCallback);
        }
    }

    public final void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f22a.f30b.connect();
    }

    public final void b() {
        Messenger messenger;
        MediaBrowserImplApi23 mediaBrowserImplApi23 = this.f22a;
        ServiceBinderWrapper serviceBinderWrapper = mediaBrowserImplApi23.f34f;
        if (serviceBinderWrapper != null && (messenger = mediaBrowserImplApi23.f35g) != null) {
            try {
                serviceBinderWrapper.a(7, null, messenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        mediaBrowserImplApi23.f30b.disconnect();
    }

    public final MediaSessionCompat.Token c() {
        MediaBrowserImplApi23 mediaBrowserImplApi23 = this.f22a;
        if (mediaBrowserImplApi23.f36h == null) {
            MediaSession.Token sessionToken = mediaBrowserImplApi23.f30b.getSessionToken();
            mediaBrowserImplApi23.f36h = sessionToken != null ? new MediaSessionCompat.Token(sessionToken, null) : null;
        }
        return mediaBrowserImplApi23.f36h;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final int f43a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaDescriptionCompat f44b;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1, reason: invalid class name */
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
            if (TextUtils.isEmpty(mediaDescriptionCompat.f51a)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f43a = i2;
            this.f44b = mediaDescriptionCompat;
        }

        public static void a(List list) {
            MediaItem mediaItem;
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj != null) {
                        MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) obj;
                        mediaItem = new MediaItem(MediaDescriptionCompat.a(Api21Impl.a(mediaItem2)), Api21Impl.b(mediaItem2));
                    } else {
                        mediaItem = null;
                    }
                    arrayList.add(mediaItem);
                }
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaItem{mFlags=" + this.f43a + ", mDescription=" + this.f44b + '}';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f43a);
            this.f44b.writeToParcel(parcel, i2);
        }

        public MediaItem(Parcel parcel) {
            this.f43a = parcel.readInt();
            this.f44b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    @RequiresApi
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {

        /* renamed from: a, reason: collision with root package name */
        public final Context f29a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaBrowser f30b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f31c;

        /* renamed from: d, reason: collision with root package name */
        public final CallbackHandler f32d = new CallbackHandler(this);

        /* renamed from: e, reason: collision with root package name */
        public final ArrayMap f33e = new ArrayMap();

        /* renamed from: f, reason: collision with root package name */
        public ServiceBinderWrapper f34f;

        /* renamed from: g, reason: collision with root package name */
        public Messenger f35g;

        /* renamed from: h, reason: collision with root package name */
        public MediaSessionCompat.Token f36h;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6, reason: invalid class name */
        class AnonymousClass6 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7, reason: invalid class name */
        class AnonymousClass7 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback) {
            this.f29a = context;
            Bundle bundle = new Bundle();
            this.f31c = bundle;
            bundle.putInt("extra_client_version", 1);
            bundle.putInt("extra_calling_pid", Process.myPid());
            connectionCallback.f26b = this;
            this.f30b = new MediaBrowser(context, componentName, connectionCallback.f25a, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void a(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void b(Messenger messenger, String str, Bundle bundle) {
            if (this.f35g != messenger) {
                return;
            }
            Subscription subscription = (Subscription) this.f33e.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.f21b) {
                    a.t("onLoadChildren for id that isn't subscribed id=", str, "MediaBrowserCompat");
                    return;
                }
                return;
            }
            int i2 = 0;
            while (true) {
                ArrayList arrayList = subscription.f48b;
                if (i2 >= arrayList.size()) {
                    return;
                }
                if (MediaBrowserCompatUtils.a((Bundle) arrayList.get(i2), bundle)) {
                    return;
                }
                i2++;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public final void c(Messenger messenger, String str, MediaSessionCompat.Token token) {
        }
    }
}
