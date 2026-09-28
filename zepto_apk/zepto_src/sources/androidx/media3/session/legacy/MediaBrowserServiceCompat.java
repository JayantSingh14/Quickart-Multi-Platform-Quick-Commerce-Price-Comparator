package androidx.media3.session.legacy;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.android.gms.common.api.Api;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f10463i = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public MediaBrowserServiceImplApi23 f10464a;

    /* renamed from: b, reason: collision with root package name */
    public final ServiceBinderImpl f10465b = new ServiceBinderImpl();

    /* renamed from: c, reason: collision with root package name */
    public final ConnectionRecord f10466c = new ConnectionRecord("android.media.session.MediaController", -1, -1, null);

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f10467d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f10468e = new ArrayMap();

    /* renamed from: f, reason: collision with root package name */
    public ConnectionRecord f10469f;

    /* renamed from: g, reason: collision with root package name */
    public final ServiceHandler f10470g;

    /* renamed from: h, reason: collision with root package name */
    public MediaSessionCompat.Token f10471h;

    public static final class BrowserRoot {

        /* renamed from: a, reason: collision with root package name */
        public final String f10480a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f10481b;

        public BrowserRoot(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.f10480a = str;
            this.f10481b = bundle;
        }
    }

    public class ConnectionRecord implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f10482a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10483b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10484c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f10485d;

        /* renamed from: e, reason: collision with root package name */
        public final ServiceCallbacksCompat f10486e;

        /* renamed from: f, reason: collision with root package name */
        public final HashMap f10487f = new HashMap();

        public ConnectionRecord(String str, int i2, int i3, ServiceCallbacksCompat serviceCallbacksCompat) {
            this.f10482a = str;
            this.f10483b = i2;
            this.f10484c = i3;
            this.f10485d = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.f10486e = serviceCallbacksCompat;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f10470g.post(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    ArrayMap arrayMap = MediaBrowserServiceCompat.this.f10468e;
                    ServiceCallbacksCompat serviceCallbacksCompat = connectionRecord.f10486e;
                    serviceCallbacksCompat.getClass();
                    arrayMap.remove(serviceCallbacksCompat.f10559a.getBinder());
                }
            });
        }
    }

    public interface MediaBrowserServiceImpl {
        MediaSessionManager.RemoteUserInfo a();

        void onCreate();
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10490a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public MediaBrowserService f10491b;

        /* renamed from: c, reason: collision with root package name */
        public Messenger f10492c;

        /* renamed from: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f10497a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f10498b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MediaBrowserServiceImplApi23 f10499c;

            public AnonymousClass3(MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23, String str, Bundle bundle) {
                this.f10499c = mediaBrowserServiceImplApi23;
                this.f10497a = str;
                this.f10498b = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10499c;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                Iterator it = mediaBrowserServiceCompat.f10468e.keySet().iterator();
                while (it.hasNext()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) mediaBrowserServiceCompat.f10468e.get((IBinder) it.next());
                    connectionRecord.getClass();
                    mediaBrowserServiceImplApi23.b(connectionRecord, this.f10497a, this.f10498b);
                }
            }
        }

        @RequiresApi
        public class MediaBrowserServiceApi21 extends MediaBrowserService {
            public MediaBrowserServiceApi21(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
                Bundle bundle2;
                BrowserRoot browserRoot;
                MediaSessionCompat.a(bundle);
                Bundle bundle3 = bundle == null ? null : new Bundle(bundle);
                MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                int i3 = -1;
                if (bundle3 == null || bundle3.getInt("extra_client_version", 0) == 0) {
                    bundle2 = null;
                } else {
                    bundle3.remove("extra_client_version");
                    mediaBrowserServiceImplApi21.f10492c = new Messenger(mediaBrowserServiceCompat.f10470g);
                    bundle2 = new Bundle();
                    bundle2.putInt("extra_service_version", 2);
                    bundle2.putBinder("extra_messenger", mediaBrowserServiceImplApi21.f10492c.getBinder());
                    MediaSessionCompat.Token token = mediaBrowserServiceCompat.f10471h;
                    if (token != null) {
                        IMediaSession iMediaSessionA = token.a();
                        bundle2.putBinder("extra_session_binder", iMediaSessionA == null ? null : iMediaSessionA.asBinder());
                    } else {
                        mediaBrowserServiceImplApi21.f10490a.add(bundle2);
                    }
                    i3 = bundle3.getInt("extra_calling_pid", -1);
                    bundle3.remove("extra_calling_pid");
                }
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i3, i2, null);
                mediaBrowserServiceCompat.f10469f = connectionRecord;
                BrowserRoot browserRootG = mediaBrowserServiceCompat.g(str, i2, bundle3);
                mediaBrowserServiceCompat.f10469f = null;
                if (browserRootG == null) {
                    browserRoot = null;
                } else {
                    if (mediaBrowserServiceImplApi21.f10492c != null) {
                        mediaBrowserServiceCompat.f10467d.add(connectionRecord);
                    }
                    Bundle bundle4 = browserRootG.f10481b;
                    if (bundle2 == null) {
                        bundle2 = bundle4;
                    } else if (bundle4 != null) {
                        bundle2.putAll(bundle4);
                    }
                    browserRoot = new BrowserRoot(browserRootG.f10480a, bundle2);
                }
                if (browserRoot == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(browserRoot.f10480a, browserRoot.f10481b);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result) {
                final ResultWrapper resultWrapper = new ResultWrapper(result);
                MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                mediaBrowserServiceImplApi21.getClass();
                Result<List<MediaBrowserCompat.MediaItem>> result2 = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void a() {
                        resultWrapper.f10519a.detach();
                    }

                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void d(Object obj) {
                        ArrayList arrayList;
                        List<MediaBrowserCompat.MediaItem> list = (List) obj;
                        if (list == null) {
                            arrayList = null;
                        } else {
                            ArrayList arrayList2 = new ArrayList(list.size());
                            for (MediaBrowserCompat.MediaItem mediaItem : list) {
                                Parcel parcelObtain = Parcel.obtain();
                                mediaItem.writeToParcel(parcelObtain, 0);
                                arrayList2.add(parcelObtain);
                            }
                            arrayList = arrayList2;
                        }
                        resultWrapper.a(arrayList);
                    }
                };
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f10469f = mediaBrowserServiceCompat.f10466c;
                mediaBrowserServiceCompat.i(str, result2);
                mediaBrowserServiceCompat.f10469f = null;
            }
        }

        public MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo a() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f10469f;
            if (connectionRecord != null) {
                return connectionRecord.f10485d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            int i2;
            int i3;
            List<Pair> list = (List) connectionRecord.f10487f.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    Bundle bundle2 = (Bundle) pair.f2990b;
                    int i4 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE", -1);
                    int i5 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE", -1);
                    int i6 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                    int i7 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                    int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    int i9 = 0;
                    if (i4 == -1 || i6 == -1) {
                        i2 = Integer.MAX_VALUE;
                        i3 = 0;
                    } else {
                        i3 = i4 * i6;
                        i2 = (i6 + i3) - 1;
                    }
                    if (i5 != -1 && i7 != -1) {
                        i9 = i7 * i5;
                        i8 = (i7 + i9) - 1;
                    }
                    if (i2 >= i9 && i8 >= i3) {
                        MediaBrowserServiceCompat.this.n(str, connectionRecord, (Bundle) pair.f2990b, bundle);
                    }
                }
            }
        }

        public void c(Bundle bundle, String str) {
            MediaBrowserService mediaBrowserService = this.f10491b;
            mediaBrowserService.getClass();
            mediaBrowserService.notifyChildrenChanged(str);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            MediaBrowserServiceApi21 mediaBrowserServiceApi21 = new MediaBrowserServiceApi21(MediaBrowserServiceCompat.this);
            this.f10491b = mediaBrowserServiceApi21;
            mediaBrowserServiceApi21.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 {

        public class MediaBrowserServiceApi23 extends MediaBrowserServiceImplApi21.MediaBrowserServiceApi21 {
            public MediaBrowserServiceApi23(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadItem(String str, MediaBrowserService.Result result) {
                final ResultWrapper resultWrapper = new ResultWrapper(result);
                MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = MediaBrowserServiceImplApi23.this;
                mediaBrowserServiceImplApi23.getClass();
                Result<MediaBrowserCompat.MediaItem> result2 = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void a() {
                        resultWrapper.f10519a.detach();
                    }

                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void d(Object obj) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) obj;
                        ResultWrapper resultWrapper2 = resultWrapper;
                        if (mediaItem == null) {
                            resultWrapper2.a(null);
                            return;
                        }
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        resultWrapper2.a(parcelObtain);
                    }
                };
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f10469f = mediaBrowserServiceCompat.f10466c;
                mediaBrowserServiceCompat.j(str, result2);
                mediaBrowserServiceCompat.f10469f = null;
            }
        }

        public MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            MediaBrowserServiceApi23 mediaBrowserServiceApi23 = new MediaBrowserServiceApi23(MediaBrowserServiceCompat.this);
            this.f10491b = mediaBrowserServiceApi23;
            mediaBrowserServiceApi23.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 {

        public class MediaBrowserServiceApi26 extends MediaBrowserServiceImplApi23.MediaBrowserServiceApi23 {
            public MediaBrowserServiceApi26(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result, final Bundle bundle) {
                MediaSessionCompat.a(bundle);
                final MediaBrowserServiceImplApi26 mediaBrowserServiceImplApi26 = MediaBrowserServiceImplApi26.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                final ResultWrapper resultWrapper = new ResultWrapper(result);
                Result<List<MediaBrowserCompat.MediaItem>> result2 = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1
                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void a() {
                        resultWrapper.f10519a.detach();
                    }

                    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                    public final void d(Object obj) {
                        List<MediaBrowserCompat.MediaItem> listA = (List) obj;
                        ResultWrapper resultWrapper2 = resultWrapper;
                        if (listA == null) {
                            resultWrapper2.a(null);
                            return;
                        }
                        if ((this.f10518e & 1) != 0) {
                            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                            listA = MediaBrowserServiceCompat.a(listA, bundle);
                        }
                        ArrayList arrayList = new ArrayList(listA == null ? 0 : listA.size());
                        if (listA != null) {
                            for (MediaBrowserCompat.MediaItem mediaItem : listA) {
                                Parcel parcelObtain = Parcel.obtain();
                                mediaItem.writeToParcel(parcelObtain, 0);
                                arrayList.add(parcelObtain);
                            }
                        }
                        resultWrapper2.a(arrayList);
                    }
                };
                mediaBrowserServiceCompat.f10469f = mediaBrowserServiceCompat.f10466c;
                mediaBrowserServiceCompat.h(bundle, result2, str);
                mediaBrowserServiceCompat.f10469f = null;
                MediaBrowserServiceCompat.this.f10469f = null;
            }
        }

        public MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        public final void c(Bundle bundle, String str) {
            if (bundle == null) {
                super.c(bundle, str);
                return;
            }
            MediaBrowserService mediaBrowserService = this.f10491b;
            mediaBrowserService.getClass();
            mediaBrowserService.notifyChildrenChanged(str, bundle);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final void onCreate() {
            MediaBrowserServiceApi26 mediaBrowserServiceApi26 = new MediaBrowserServiceApi26(MediaBrowserServiceCompat.this);
            this.f10491b = mediaBrowserServiceApi26;
            mediaBrowserServiceApi26.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        public MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final MediaSessionManager.RemoteUserInfo a() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            ConnectionRecord connectionRecord = mediaBrowserServiceCompat.f10469f;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (connectionRecord != mediaBrowserServiceCompat.f10466c) {
                return connectionRecord.f10485d;
            }
            MediaBrowserService mediaBrowserService = this.f10491b;
            mediaBrowserService.getClass();
            return new MediaSessionManager.RemoteUserInfo(mediaBrowserService.getCurrentBrowserInfo());
        }
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final MediaSessionManager.RemoteUserInfo a() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final void onCreate() {
            throw null;
        }
    }

    public static class Result<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f10514a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10515b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10516c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10517d;

        /* renamed from: e, reason: collision with root package name */
        public int f10518e;

        public Result(Object obj) {
            this.f10514a = obj;
        }

        public void a() {
            boolean z = this.f10515b;
            Object obj = this.f10514a;
            if (z) {
                throw new IllegalStateException(b.j(obj, "detach() called when detach() had already been called for: "));
            }
            if (this.f10516c) {
                throw new IllegalStateException(b.j(obj, "detach() called when sendResult() had already been called for: "));
            }
            if (this.f10517d) {
                throw new IllegalStateException(b.j(obj, "detach() called when sendError() had already been called for: "));
            }
            this.f10515b = true;
        }

        public final boolean b() {
            return this.f10515b || this.f10516c || this.f10517d;
        }

        public void c() {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f10514a);
        }

        public void d(Object obj) {
        }

        public final void e() {
            if (this.f10516c || this.f10517d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f10514a);
            }
            this.f10517d = true;
            c();
        }

        public final void f(Object obj) {
            if (this.f10516c || this.f10517d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f10514a);
            }
            this.f10516c = true;
            d(obj);
        }
    }

    @RequiresApi
    public static class ResultWrapper<T> {

        /* renamed from: a, reason: collision with root package name */
        public final MediaBrowserService.Result f10519a;

        public ResultWrapper(MediaBrowserService.Result result) {
            this.f10519a = result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Object obj) {
            boolean z = obj instanceof List;
            ArrayList arrayList = null;
            MediaBrowserService.Result result = this.f10519a;
            if (!z) {
                if (!(obj instanceof Parcel)) {
                    result.sendResult(null);
                    return;
                }
                Parcel parcel = (Parcel) obj;
                parcel.setDataPosition(0);
                result.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
                return;
            }
            List<Parcel> list = (List) obj;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (Parcel parcel2 : list) {
                    parcel2.setDataPosition(0);
                    arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel2));
                    parcel2.recycle();
                }
            }
            result.sendResult(arrayList);
        }
    }

    public class ServiceBinderImpl {
        public ServiceBinderImpl() {
        }
    }

    public interface ServiceCallbacks {
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final Messenger f10559a;

        public ServiceCallbacksCompat(Messenger messenger) {
            this.f10559a = messenger;
        }

        public final void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", LegacyParcelableUtil.a(token, MediaSessionCompat.Token.CREATOR));
            bundle2.putBundle("data_root_hints", bundle);
            b(1, bundle2);
        }

        public final void b(int i2, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = 2;
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            this.f10559a.send(messageObtain);
        }
    }

    public static final class ServiceHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public MediaBrowserServiceCompat f10560a;

        public final void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String[] packagesForUid;
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f10560a;
            if (mediaBrowserServiceCompat == null) {
                removeCallbacksAndMessages(null);
                return;
            }
            Bundle data = message.getData();
            int i2 = message.what;
            final ServiceBinderImpl serviceBinderImpl = mediaBrowserServiceCompat.f10465b;
            switch (i2) {
                case 1:
                    final Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    final String string = data.getString("data_package_name");
                    final int i3 = data.getInt("data_calling_pid");
                    final int i4 = data.getInt("data_calling_uid");
                    ServiceCallbacksCompat serviceCallbacksCompat = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                    if (string != null && (packagesForUid = mediaBrowserServiceCompat2.getPackageManager().getPackagesForUid(i4)) != null) {
                        int length = packagesForUid.length;
                        int i5 = 0;
                        while (i5 < length) {
                            if (packagesForUid[i5].equals(string)) {
                                final ServiceCallbacksCompat serviceCallbacksCompat2 = serviceCallbacksCompat;
                                mediaBrowserServiceCompat2.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.1
                                    @Override // java.lang.Runnable
                                    public final void run() throws RemoteException {
                                        ServiceCallbacksCompat serviceCallbacksCompat3 = serviceCallbacksCompat2;
                                        IBinder binder = serviceCallbacksCompat3.f10559a.getBinder();
                                        ServiceBinderImpl serviceBinderImpl2 = serviceBinderImpl;
                                        MediaBrowserServiceCompat.this.f10468e.remove(binder);
                                        MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                                        String str = string;
                                        ConnectionRecord connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(str, i3, i4, serviceCallbacksCompat3);
                                        mediaBrowserServiceCompat3.f10469f = connectionRecord;
                                        BrowserRoot browserRootG = mediaBrowserServiceCompat3.g(str, i4, bundle);
                                        mediaBrowserServiceCompat3.f10469f = null;
                                        if (browserRootG == null) {
                                            StringBuilder sbY = b.y("No root for client ", str, " from service ");
                                            sbY.append(getClass().getName());
                                            Log.i("MBServiceCompat", sbY.toString());
                                            try {
                                                serviceCallbacksCompat3.b(2, null);
                                                return;
                                            } catch (RemoteException unused) {
                                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
                                                return;
                                            }
                                        }
                                        try {
                                            mediaBrowserServiceCompat3.f10468e.put(binder, connectionRecord);
                                            binder.linkToDeath(connectionRecord, 0);
                                            MediaSessionCompat.Token token = mediaBrowserServiceCompat3.f10471h;
                                            if (token != null) {
                                                serviceCallbacksCompat3.a(browserRootG.f10480a, token, browserRootG.f10481b);
                                            }
                                        } catch (RemoteException unused2) {
                                            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=".concat(str));
                                            mediaBrowserServiceCompat3.f10468e.remove(binder);
                                        }
                                    }
                                });
                                return;
                            } else {
                                i5++;
                                serviceCallbacksCompat = serviceCallbacksCompat;
                            }
                        }
                    }
                    throw new IllegalArgumentException(b.h(i4, "Package/uid mismatch: uid=", " package=", string));
                case 2:
                    final ServiceCallbacksCompat serviceCallbacksCompat3 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.remove(serviceCallbacksCompat3.f10559a.getBinder());
                            if (connectionRecord != null) {
                                ServiceCallbacksCompat serviceCallbacksCompat4 = connectionRecord.f10486e;
                                serviceCallbacksCompat4.getClass();
                                serviceCallbacksCompat4.f10559a.getBinder().unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    final Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    final String string2 = data.getString("data_media_item_id");
                    final IBinder binder = data.getBinder("data_callback_token");
                    final ServiceCallbacksCompat serviceCallbacksCompat4 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder2 = serviceCallbacksCompat4.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.get(binder2);
                            String str = string2;
                            if (connectionRecord == null) {
                                b.A("addSubscription for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            HashMap map = connectionRecord.f10487f;
                            List arrayList = (List) map.get(str);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Iterator it = arrayList.iterator();
                            while (true) {
                                boolean zHasNext = it.hasNext();
                                IBinder iBinder = binder;
                                Bundle bundle3 = bundle2;
                                if (!zHasNext) {
                                    arrayList.add(new Pair(iBinder, bundle3));
                                    map.put(str, arrayList);
                                    mediaBrowserServiceCompat3.n(str, connectionRecord, bundle3, null);
                                    mediaBrowserServiceCompat3.f10469f = connectionRecord;
                                    mediaBrowserServiceCompat3.l(bundle3, str);
                                    mediaBrowserServiceCompat3.f10469f = null;
                                    return;
                                }
                                Pair pair = (Pair) it.next();
                                if (iBinder == pair.f2989a && MediaBrowserCompatUtils.a(bundle3, (Bundle) pair.f2990b)) {
                                    return;
                                }
                            }
                        }
                    });
                    return;
                case 4:
                    final String string3 = data.getString("data_media_item_id");
                    final IBinder binder2 = data.getBinder("data_callback_token");
                    final ServiceCallbacksCompat serviceCallbacksCompat5 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat5.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.get(binder3);
                            String str = string3;
                            if (connectionRecord == null) {
                                b.A("removeSubscription for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            HashMap map = connectionRecord.f10487f;
                            IBinder iBinder = binder2;
                            boolean z = false;
                            try {
                                if (iBinder != null) {
                                    List list = (List) map.get(str);
                                    if (list != null) {
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            if (iBinder == ((Pair) it.next()).f2989a) {
                                                it.remove();
                                                z = true;
                                            }
                                        }
                                        if (list.size() == 0) {
                                            map.remove(str);
                                        }
                                    }
                                } else if (map.remove(str) != null) {
                                    z = true;
                                }
                                if (z) {
                                    return;
                                }
                                Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                            } finally {
                                mediaBrowserServiceCompat3.f10469f = connectionRecord;
                                mediaBrowserServiceCompat3.m(str);
                                mediaBrowserServiceCompat3.f10469f = null;
                            }
                        }
                    });
                    return;
                case 5:
                    final String string4 = data.getString("data_media_item_id");
                    final ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    final ServiceCallbacksCompat serviceCallbacksCompat6 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string4) || resultReceiver == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat6.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.get(binder3);
                            String str = string4;
                            if (connectionRecord == null) {
                                b.A("getMediaItem for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            final ResultReceiver resultReceiver2 = resultReceiver;
                            Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.2
                                @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                                public final void d(Object obj) {
                                    MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) obj;
                                    int i6 = this.f10518e & 2;
                                    ResultReceiver resultReceiver3 = resultReceiver2;
                                    if (i6 != 0) {
                                        resultReceiver3.b(-1, null);
                                        return;
                                    }
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putParcelable("media_item", LegacyParcelableUtil.a(mediaItem, MediaBrowserCompat.MediaItem.CREATOR));
                                    resultReceiver3.b(0, bundle3);
                                }
                            };
                            mediaBrowserServiceCompat3.f10469f = connectionRecord;
                            mediaBrowserServiceCompat3.j(str, result);
                            mediaBrowserServiceCompat3.f10469f = null;
                            if (!result.b()) {
                                throw new IllegalStateException(b.C("onLoadItem must call detach() or sendResult() before returning for id=", str));
                            }
                        }
                    });
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    ServiceCallbacksCompat serviceCallbacksCompat7 = new ServiceCallbacksCompat(message.replyTo);
                    String string5 = data.getString("data_package_name");
                    int i6 = data.getInt("data_calling_pid");
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable(data.getInt("data_calling_uid"), i6, bundle3, serviceBinderImpl, serviceCallbacksCompat7, string5) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.6

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ ServiceCallbacksCompat f10542a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ int f10543b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ String f10544c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ int f10545d;

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ ServiceBinderImpl f10546e;

                        {
                            this.f10546e = serviceBinderImpl;
                            this.f10542a = serviceCallbacksCompat7;
                            this.f10544c = string5;
                        }

                        @Override // java.lang.Runnable
                        public final void run() throws RemoteException {
                            ConnectionRecord connectionRecord;
                            ServiceCallbacksCompat serviceCallbacksCompat8 = this.f10542a;
                            IBinder binder3 = serviceCallbacksCompat8.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = this.f10546e;
                            MediaBrowserServiceCompat.this.f10468e.remove(binder3);
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            Iterator it = mediaBrowserServiceCompat3.f10467d.iterator();
                            while (true) {
                                connectionRecord = null;
                                if (!it.hasNext()) {
                                    break;
                                }
                                ConnectionRecord connectionRecord2 = (ConnectionRecord) it.next();
                                if (connectionRecord2.f10484c == this.f10543b) {
                                    if (TextUtils.isEmpty(this.f10544c) || this.f10545d <= 0) {
                                        connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(connectionRecord2.f10482a, connectionRecord2.f10483b, connectionRecord2.f10484c, serviceCallbacksCompat8);
                                    }
                                    it.remove();
                                }
                            }
                            if (connectionRecord == null) {
                                connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(this.f10544c, this.f10545d, this.f10543b, serviceCallbacksCompat8);
                            }
                            mediaBrowserServiceCompat3.f10468e.put(binder3, connectionRecord);
                            try {
                                binder3.linkToDeath(connectionRecord, 0);
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "IBinder is already dead.");
                            }
                        }
                    });
                    return;
                case 7:
                    final ServiceCallbacksCompat serviceCallbacksCompat8 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat8.f10559a.getBinder();
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.remove(binder3);
                            if (connectionRecord != null) {
                                binder3.unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 8:
                    final Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    final String string6 = data.getString("data_search_query");
                    final ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    final ServiceCallbacksCompat serviceCallbacksCompat9 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string6) || resultReceiver2 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat9.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.get(binder3);
                            String str = string6;
                            if (connectionRecord == null) {
                                b.A("search for callback that isn't registered query=", str, "MBServiceCompat");
                                return;
                            }
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            final ResultReceiver resultReceiver3 = resultReceiver2;
                            Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.3
                                @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                                public final void d(Object obj) {
                                    List list = (List) obj;
                                    int i7 = this.f10518e & 4;
                                    ResultReceiver resultReceiver4 = resultReceiver3;
                                    if (i7 != 0 || list == null) {
                                        resultReceiver4.b(-1, null);
                                        return;
                                    }
                                    Bundle bundle5 = new Bundle();
                                    bundle5.putParcelableArray("search_results", (Parcelable[]) LegacyParcelableUtil.b(list, MediaBrowserCompat.MediaItem.CREATOR).toArray(new MediaBrowserCompat.MediaItem[0]));
                                    resultReceiver4.b(0, bundle5);
                                }
                            };
                            mediaBrowserServiceCompat3.f10469f = connectionRecord;
                            mediaBrowserServiceCompat3.k(bundle4, result, str);
                            mediaBrowserServiceCompat3.f10469f = null;
                            if (!result.b()) {
                                throw new IllegalStateException(b.C("onSearch must call detach() or sendResult() before returning for query=", str));
                            }
                        }
                    });
                    return;
                case 9:
                    final Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    final String string7 = data.getString("data_custom_action");
                    final ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    final ServiceCallbacksCompat serviceCallbacksCompat10 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string7) || resultReceiver3 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.ServiceBinderImpl.9
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat10.f10559a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f10468e.get(binder3);
                            Bundle bundle6 = bundle5;
                            String str = string7;
                            if (connectionRecord == null) {
                                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle6);
                                return;
                            }
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            final ResultReceiver resultReceiver4 = resultReceiver3;
                            Result<Bundle> result = new Result<Bundle>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.4
                                @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                                public final void c() {
                                    resultReceiver4.b(-1, null);
                                }

                                @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
                                public final void d(Object obj) {
                                    resultReceiver4.b(0, (Bundle) obj);
                                }
                            };
                            mediaBrowserServiceCompat3.f10469f = connectionRecord;
                            mediaBrowserServiceCompat3.f(bundle6 == null ? Bundle.EMPTY : bundle6, result, str);
                            mediaBrowserServiceCompat3.f10469f = null;
                            if (result.b()) {
                                return;
                            }
                            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle6);
                        }
                    });
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            ClassLoader classLoader = MediaBrowserCompat.class.getClassLoader();
            classLoader.getClass();
            data.setClassLoader(classLoader);
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j2);
        }
    }

    public MediaBrowserServiceCompat() {
        ServiceHandler serviceHandler = new ServiceHandler();
        serviceHandler.f10560a = this;
        this.f10470g = serviceHandler;
    }

    public static List a(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        if (bundle != null) {
            int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
            int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
            if (i2 != -1 || i3 != -1) {
                int i4 = i3 * i2;
                int size = i4 + i3;
                if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
                    return Collections.EMPTY_LIST;
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i4, size);
            }
        }
        return list;
    }

    public final MediaSessionManager.RemoteUserInfo b() {
        MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        return mediaBrowserServiceImplApi23.a();
    }

    public final void c(Bundle bundle, String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        mediaBrowserServiceImplApi23.c(bundle, str);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.f10470g.post(new MediaBrowserServiceImplApi21.AnonymousClass3(mediaBrowserServiceImplApi23, str, bundle));
    }

    public final void d(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        final MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.f10470g.post(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.4
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = 0;
                while (true) {
                    MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                    ArrayMap arrayMap = MediaBrowserServiceCompat.this.f10468e;
                    if (i2 >= arrayMap.f1605c) {
                        return;
                    }
                    ConnectionRecord connectionRecord = (ConnectionRecord) arrayMap.j(i2);
                    if (connectionRecord.f10485d.equals(remoteUserInfo)) {
                        mediaBrowserServiceImplApi21.b(connectionRecord, str, bundle);
                    }
                    i2++;
                }
            }
        });
    }

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final void e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        mediaBrowserServiceImplApi23.c(null, str);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.f10470g.post(new MediaBrowserServiceImplApi21.AnonymousClass3(mediaBrowserServiceImplApi23, str, null));
    }

    public void f(Bundle bundle, Result result, String str) {
        result.e();
    }

    public abstract BrowserRoot g(String str, int i2, Bundle bundle);

    public void h(Bundle bundle, Result result, String str) {
        result.f10518e = 1;
        i(str, result);
    }

    public abstract void i(String str, Result result);

    public void j(String str, Result result) {
        result.f10518e = 2;
        result.f(null);
    }

    public void k(Bundle bundle, Result result, String str) {
        result.f10518e = 4;
        result.f(null);
    }

    public void m(String str) {
    }

    public final void n(final String str, final ConnectionRecord connectionRecord, final Bundle bundle, final Bundle bundle2) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.1
            @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat.Result
            public final void d(Object obj) {
                List listA = (List) obj;
                ArrayMap arrayMap = MediaBrowserServiceCompat.this.f10468e;
                ConnectionRecord connectionRecord2 = connectionRecord;
                ServiceCallbacksCompat serviceCallbacksCompat = connectionRecord2.f10486e;
                serviceCallbacksCompat.getClass();
                Object obj2 = arrayMap.get(serviceCallbacksCompat.f10559a.getBinder());
                String str2 = connectionRecord2.f10482a;
                String str3 = str;
                if (obj2 != connectionRecord2) {
                    if (MediaBrowserServiceCompat.f10463i) {
                        Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + str2 + " id=" + str3);
                        return;
                    }
                    return;
                }
                int i2 = this.f10518e & 1;
                Bundle bundle3 = bundle;
                if (i2 != 0) {
                    listA = MediaBrowserServiceCompat.a(listA, bundle3);
                }
                try {
                    Bundle bundle4 = bundle2;
                    serviceCallbacksCompat.getClass();
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("data_media_item_id", str3);
                    bundle5.putBundle("data_options", bundle3);
                    bundle5.putBundle("data_notify_children_changed_options", bundle4);
                    if (listA != null) {
                        bundle5.putParcelableArrayList("data_media_item_list", LegacyParcelableUtil.b(listA, MediaBrowserCompat.MediaItem.CREATOR));
                    }
                    serviceCallbacksCompat.b(3, bundle5);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str3 + " package=" + str2);
                }
            }
        };
        this.f10469f = connectionRecord;
        if (bundle == null) {
            i(str, result);
        } else {
            h(bundle, result, str);
        }
        this.f10469f = null;
        if (!result.b()) {
            throw new IllegalStateException(b.s(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), connectionRecord.f10482a, " id=", str));
        }
    }

    public final void o(final MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.f10471h != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.f10471h = token;
        final MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.f10470g.a(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
            @Override // java.lang.Runnable
            public final void run() {
                MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                ArrayList arrayList = mediaBrowserServiceImplApi21.f10490a;
                boolean zIsEmpty = arrayList.isEmpty();
                MediaSessionCompat.Token token2 = token;
                if (!zIsEmpty) {
                    IMediaSession iMediaSessionA = token2.a();
                    if (iMediaSessionA != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((Bundle) it.next()).putBinder("extra_session_binder", iMediaSessionA.asBinder());
                        }
                    }
                    arrayList.clear();
                }
                MediaBrowserService mediaBrowserService = mediaBrowserServiceImplApi21.f10491b;
                mediaBrowserService.getClass();
                MediaSession.Token token3 = (MediaSession.Token) token2.f10639b;
                token3.getClass();
                mediaBrowserService.setSessionToken(token3);
            }
        });
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23 = this.f10464a;
        mediaBrowserServiceImplApi23.getClass();
        MediaBrowserService mediaBrowserService = mediaBrowserServiceImplApi23.f10491b;
        mediaBrowserService.getClass();
        return mediaBrowserService.onBind(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f10464a = new MediaBrowserServiceImplApi28();
        } else if (i2 >= 26) {
            this.f10464a = new MediaBrowserServiceImplApi26();
        } else {
            this.f10464a = new MediaBrowserServiceImplApi23();
        }
        this.f10464a.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f10470g.f10560a = null;
    }

    public void l(Bundle bundle, String str) {
    }
}
