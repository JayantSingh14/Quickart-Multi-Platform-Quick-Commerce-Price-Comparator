package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.j;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f5035f = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public MediaBrowserServiceImplApi23 f5036a;

    /* renamed from: b, reason: collision with root package name */
    public final ServiceBinderImpl f5037b = new ServiceBinderImpl();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f5038c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayMap f5039d;

    /* renamed from: e, reason: collision with root package name */
    public final ServiceHandler f5040e;

    public static final class BrowserRoot {
    }

    public class ConnectionRecord implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f5048a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5049b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5050c;

        /* renamed from: d, reason: collision with root package name */
        public final ServiceCallbacksCompat f5051d;

        /* renamed from: e, reason: collision with root package name */
        public final HashMap f5052e = new HashMap();

        public ConnectionRecord(String str, int i2, int i3, ServiceCallbacksCompat serviceCallbacksCompat) {
            this.f5048a = str;
            this.f5049b = i2;
            this.f5050c = i3;
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                j.r(i2, i3, str);
            }
            this.f5051d = serviceCallbacksCompat;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f5040e.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f5039d.remove(connectionRecord.f5051d.f5107a.getBinder());
                }
            });
        }
    }

    public interface MediaBrowserServiceImpl {
        void onCreate();
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f5055a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public MediaBrowserService f5056b;

        /* renamed from: c, reason: collision with root package name */
        public Messenger f5057c;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2, reason: invalid class name */
        class AnonymousClass2 extends Result<List<MediaBrowserCompat.MediaItem>> {
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public final void b() {
                throw null;
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        @RequiresApi
        public class MediaBrowserServiceApi21 extends MediaBrowserService {
            public MediaBrowserServiceApi21(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
                MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                int i3 = -1;
                if (bundle2 != null && bundle2.getInt("extra_client_version", 0) != 0) {
                    bundle2.remove("extra_client_version");
                    mediaBrowserServiceImplApi21.f5057c = new Messenger(mediaBrowserServiceCompat.f5040e);
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("extra_service_version", 2);
                    bundle3.putBinder("extra_messenger", mediaBrowserServiceImplApi21.f5057c.getBinder());
                    mediaBrowserServiceImplApi21.f5055a.add(bundle3);
                    i3 = bundle2.getInt("extra_calling_pid", -1);
                    bundle2.remove("extra_calling_pid");
                }
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i3, i2, null);
                if (mediaBrowserServiceCompat.a() == null) {
                    return null;
                }
                if (mediaBrowserServiceImplApi21.f5057c == null) {
                    throw null;
                }
                mediaBrowserServiceCompat.f5038c.add(connectionRecord);
                throw null;
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21 = MediaBrowserServiceImplApi21.this;
                mediaBrowserServiceImplApi21.getClass();
                MediaBrowserServiceCompat.this.b();
            }
        }

        public MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            MediaBrowserServiceApi21 mediaBrowserServiceApi21 = new MediaBrowserServiceApi21(MediaBrowserServiceCompat.this);
            this.f5056b = mediaBrowserServiceApi21;
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
                MediaBrowserServiceImplApi23.this.getClass();
                Result<MediaBrowserCompat.MediaItem> result2 = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public final void b() {
                        ResultWrapper resultWrapper2 = resultWrapper;
                        resultWrapper2.getClass();
                        resultWrapper2.f5069a.sendResult(null);
                    }
                };
                result2.f5068d = 2;
                result2.c();
            }
        }

        public MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            MediaBrowserServiceApi23 mediaBrowserServiceApi23 = new MediaBrowserServiceApi23(MediaBrowserServiceCompat.this);
            this.f5056b = mediaBrowserServiceApi23;
            mediaBrowserServiceApi23.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1, reason: invalid class name */
        class AnonymousClass1 extends Result<List<MediaBrowserCompat.MediaItem>> {
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public final void b() {
                throw null;
            }
        }

        public class MediaBrowserServiceApi26 extends MediaBrowserServiceImplApi23.MediaBrowserServiceApi23 {
            public MediaBrowserServiceApi26(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                MediaBrowserServiceCompat.this.b();
            }
        }

        public MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final void onCreate() {
            MediaBrowserServiceApi26 mediaBrowserServiceApi26 = new MediaBrowserServiceApi26(MediaBrowserServiceCompat.this);
            this.f5056b = mediaBrowserServiceApi26;
            mediaBrowserServiceApi26.onCreate();
        }
    }

    @RequiresApi
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public final void onCreate() {
            throw null;
        }
    }

    @RequiresApi
    public static class ResultWrapper<T> {

        /* renamed from: a, reason: collision with root package name */
        public final MediaBrowserService.Result f5069a;

        public ResultWrapper(MediaBrowserService.Result result) {
            this.f5069a = result;
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
        public final Messenger f5107a;

        public ServiceCallbacksCompat(Messenger messenger) {
            this.f5107a = messenger;
        }

        public final void a(String str, List list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            bundle2.putBundle("data_notify_children_changed_options", null);
            if (list != null) {
                bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            b(3, bundle2);
        }

        public final void b(int i2, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f5107a.send(messageObtain);
        }
    }

    public static final class ServiceHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public MediaBrowserServiceCompat f5108a;

        public final void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f5108a;
            if (mediaBrowserServiceCompat == null) {
                removeCallbacksAndMessages(null);
                return;
            }
            Bundle data = message.getData();
            int i2 = message.what;
            final ServiceBinderImpl serviceBinderImpl = mediaBrowserServiceCompat.f5037b;
            switch (i2) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    String string = data.getString("data_package_name");
                    int i3 = data.getInt("data_calling_pid");
                    int i4 = data.getInt("data_calling_uid");
                    ServiceCallbacksCompat serviceCallbacksCompat = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat2.getPackageManager().getPackagesForUid(i4);
                        int length = packagesForUid.length;
                        int i5 = 0;
                        while (i5 < length) {
                            if (packagesForUid[i5].equals(string)) {
                                mediaBrowserServiceCompat2.f5040e.a(new Runnable(i3, i4, bundle, serviceBinderImpl, serviceCallbacksCompat, string) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1

                                    /* renamed from: a, reason: collision with root package name */
                                    public final /* synthetic */ ServiceCallbacksCompat f5071a;

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ String f5072b;

                                    /* renamed from: c, reason: collision with root package name */
                                    public final /* synthetic */ int f5073c;

                                    /* renamed from: d, reason: collision with root package name */
                                    public final /* synthetic */ int f5074d;

                                    /* renamed from: e, reason: collision with root package name */
                                    public final /* synthetic */ ServiceBinderImpl f5075e;

                                    {
                                        this.f5075e = serviceBinderImpl;
                                        this.f5071a = serviceCallbacksCompat;
                                        this.f5072b = string;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() throws RemoteException {
                                        ServiceCallbacksCompat serviceCallbacksCompat2 = this.f5071a;
                                        IBinder binder = serviceCallbacksCompat2.f5107a.getBinder();
                                        ServiceBinderImpl serviceBinderImpl2 = this.f5075e;
                                        MediaBrowserServiceCompat.this.f5039d.remove(binder);
                                        MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                                        String str = this.f5072b;
                                        ConnectionRecord connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(str, this.f5073c, this.f5074d, serviceCallbacksCompat2);
                                        if (mediaBrowserServiceCompat3.a() != null) {
                                            try {
                                                mediaBrowserServiceCompat3.f5039d.put(binder, connectionRecord);
                                                binder.linkToDeath(connectionRecord, 0);
                                                return;
                                            } catch (RemoteException unused) {
                                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=".concat(str));
                                                mediaBrowserServiceCompat3.f5039d.remove(binder);
                                                return;
                                            }
                                        }
                                        StringBuilder sbY = b.y("No root for client ", str, " from service ");
                                        sbY.append(getClass().getName());
                                        Log.i("MBServiceCompat", sbY.toString());
                                        try {
                                            serviceCallbacksCompat2.b(2, null);
                                        } catch (RemoteException unused2) {
                                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
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
                    final ServiceCallbacksCompat serviceCallbacksCompat2 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.remove(serviceCallbacksCompat2.f5107a.getBinder());
                            if (connectionRecord != null) {
                                connectionRecord.f5051d.f5107a.getBinder().unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    final Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    final String string2 = data.getString("data_media_item_id");
                    final IBinder binder = data.getBinder("data_callback_token");
                    final ServiceCallbacksCompat serviceCallbacksCompat3 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder2 = serviceCallbacksCompat3.f5107a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = ServiceBinderImpl.this;
                            final ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.get(binder2);
                            final String str = string2;
                            if (connectionRecord == null) {
                                b.A("addSubscription for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            final MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            HashMap map = connectionRecord.f5052e;
                            List arrayList = (List) map.get(str);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Iterator it = arrayList.iterator();
                            while (true) {
                                boolean zHasNext = it.hasNext();
                                IBinder iBinder = binder;
                                final Bundle bundle3 = bundle2;
                                if (!zHasNext) {
                                    arrayList.add(new Pair(iBinder, bundle3));
                                    map.put(str, arrayList);
                                    Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.1
                                        @Override // androidx.media.MediaBrowserServiceCompat.Result
                                        public final void b() {
                                            ArrayMap arrayMap = MediaBrowserServiceCompat.this.f5039d;
                                            ConnectionRecord connectionRecord2 = connectionRecord;
                                            ServiceCallbacksCompat serviceCallbacksCompat4 = connectionRecord2.f5051d;
                                            Object obj = arrayMap.get(serviceCallbacksCompat4.f5107a.getBinder());
                                            String str2 = connectionRecord2.f5048a;
                                            String str3 = str;
                                            if (obj != connectionRecord2) {
                                                if (MediaBrowserServiceCompat.f5035f) {
                                                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + str2 + " id=" + str3);
                                                    return;
                                                }
                                                return;
                                            }
                                            int i6 = this.f5068d & 1;
                                            Bundle bundle4 = bundle3;
                                            if (i6 != 0) {
                                                boolean z = MediaBrowserServiceCompat.f5035f;
                                            }
                                            try {
                                                serviceCallbacksCompat4.a(str3, null, bundle4);
                                            } catch (RemoteException unused) {
                                                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str3 + " package=" + str2);
                                            }
                                        }
                                    };
                                    if (bundle3 == null) {
                                        mediaBrowserServiceCompat3.b();
                                    } else {
                                        result.f5068d = 1;
                                        mediaBrowserServiceCompat3.b();
                                    }
                                    if (!result.a()) {
                                        throw new IllegalStateException(b.s(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), connectionRecord.f5048a, " id=", str));
                                    }
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
                    final ServiceCallbacksCompat serviceCallbacksCompat4 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.get(serviceCallbacksCompat4.f5107a.getBinder());
                            String str = string3;
                            if (connectionRecord == null) {
                                b.A("removeSubscription for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            HashMap map = connectionRecord.f5052e;
                            IBinder iBinder = binder2;
                            boolean z = false;
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
                        }
                    });
                    return;
                case 5:
                    final String string4 = data.getString("data_media_item_id");
                    final ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    final ServiceCallbacksCompat serviceCallbacksCompat5 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string4) || resultReceiver == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.get(serviceCallbacksCompat5.f5107a.getBinder());
                            String str = string4;
                            if (connectionRecord == null) {
                                b.A("getMediaItem for callback that isn't registered id=", str, "MBServiceCompat");
                                return;
                            }
                            final ResultReceiver resultReceiver2 = resultReceiver;
                            Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.2
                                @Override // androidx.media.MediaBrowserServiceCompat.Result
                                public final void b() {
                                    int i6 = this.f5068d & 2;
                                    ResultReceiver resultReceiver3 = resultReceiver2;
                                    if (i6 != 0) {
                                        resultReceiver3.b(-1, null);
                                        return;
                                    }
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putParcelable("media_item", null);
                                    resultReceiver3.b(0, bundle3);
                                }
                            };
                            result.f5068d = 2;
                            result.c();
                            if (!result.a()) {
                                throw new IllegalStateException(b.C("onLoadItem must call detach() or sendResult() before returning for id=", str));
                            }
                        }
                    });
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    ServiceCallbacksCompat serviceCallbacksCompat6 = new ServiceCallbacksCompat(message.replyTo);
                    String string5 = data.getString("data_package_name");
                    int i6 = data.getInt("data_calling_pid");
                    int i7 = data.getInt("data_calling_uid");
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable(i7, i6, bundle3, serviceBinderImpl, serviceCallbacksCompat6, string5) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ ServiceCallbacksCompat f5091a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ int f5092b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ String f5093c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ int f5094d;

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ ServiceBinderImpl f5095e;

                        {
                            this.f5095e = serviceBinderImpl;
                            this.f5091a = serviceCallbacksCompat6;
                            this.f5093c = string5;
                        }

                        @Override // java.lang.Runnable
                        public final void run() throws RemoteException {
                            ConnectionRecord connectionRecord;
                            ServiceCallbacksCompat serviceCallbacksCompat7 = this.f5091a;
                            IBinder binder3 = serviceCallbacksCompat7.f5107a.getBinder();
                            ServiceBinderImpl serviceBinderImpl2 = this.f5095e;
                            MediaBrowserServiceCompat.this.f5039d.remove(binder3);
                            MediaBrowserServiceCompat mediaBrowserServiceCompat3 = MediaBrowserServiceCompat.this;
                            Iterator it = mediaBrowserServiceCompat3.f5038c.iterator();
                            while (true) {
                                connectionRecord = null;
                                if (!it.hasNext()) {
                                    break;
                                }
                                ConnectionRecord connectionRecord2 = (ConnectionRecord) it.next();
                                if (connectionRecord2.f5050c == this.f5092b) {
                                    if (TextUtils.isEmpty(this.f5093c) || this.f5094d <= 0) {
                                        connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(connectionRecord2.f5048a, connectionRecord2.f5049b, connectionRecord2.f5050c, serviceCallbacksCompat7);
                                    }
                                    it.remove();
                                }
                            }
                            if (connectionRecord == null) {
                                connectionRecord = mediaBrowserServiceCompat3.new ConnectionRecord(this.f5093c, this.f5094d, this.f5092b, serviceCallbacksCompat7);
                            }
                            mediaBrowserServiceCompat3.f5039d.put(binder3, connectionRecord);
                            try {
                                binder3.linkToDeath(connectionRecord, 0);
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "IBinder is already dead.");
                            }
                        }
                    });
                    return;
                case 7:
                    final ServiceCallbacksCompat serviceCallbacksCompat7 = new ServiceCallbacksCompat(message.replyTo);
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            IBinder binder3 = serviceCallbacksCompat7.f5107a.getBinder();
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.remove(binder3);
                            if (connectionRecord != null) {
                                binder3.unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    String string6 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat serviceCallbacksCompat8 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string6) || resultReceiver2 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable(serviceCallbacksCompat8, string6, bundle4, resultReceiver2) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ ServiceCallbacksCompat f5098a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ String f5099b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ ResultReceiver f5100c;

                        {
                            this.f5100c = resultReceiver2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.get(this.f5098a.f5107a.getBinder());
                            String str = this.f5099b;
                            if (connectionRecord == null) {
                                b.A("search for callback that isn't registered query=", str, "MBServiceCompat");
                                return;
                            }
                            final ResultReceiver resultReceiver3 = this.f5100c;
                            Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.3
                                @Override // androidx.media.MediaBrowserServiceCompat.Result
                                public final void b() {
                                    resultReceiver3.b(-1, null);
                                }
                            };
                            result.f5068d = 4;
                            result.c();
                            if (!result.a()) {
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
                    final ServiceCallbacksCompat serviceCallbacksCompat9 = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.getClass();
                    if (TextUtils.isEmpty(string7) || resultReceiver3 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f5040e.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f5039d.get(serviceCallbacksCompat9.f5107a.getBinder());
                            Bundle bundle6 = bundle5;
                            String str = string7;
                            if (connectionRecord == null) {
                                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle6);
                                return;
                            }
                            final ResultReceiver resultReceiver4 = resultReceiver3;
                            Result<Bundle> result = new Result<Bundle>(str) { // from class: androidx.media.MediaBrowserServiceCompat.4
                                @Override // androidx.media.MediaBrowserServiceCompat.Result
                                public final void b() {
                                    resultReceiver4.b(0, null);
                                }
                            };
                            if (result.f5066b || result.f5067c) {
                                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + ((Object) str));
                            }
                            result.f5067c = true;
                            resultReceiver4.b(-1, null);
                            if (result.a()) {
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
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
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
        new ConnectionRecord("android.media.session.MediaController", -1, -1, null);
        this.f5038c = new ArrayList();
        this.f5039d = new ArrayMap();
        ServiceHandler serviceHandler = new ServiceHandler();
        serviceHandler.f5108a = this;
        this.f5040e = serviceHandler;
    }

    public abstract BrowserRoot a();

    public abstract void b();

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f5036a.f5056b.onBind(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f5036a = new MediaBrowserServiceImplApi28();
        } else if (i2 >= 26) {
            this.f5036a = new MediaBrowserServiceImplApi26();
        } else {
            this.f5036a = new MediaBrowserServiceImplApi23();
        }
        this.f5036a.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f5040e.f5108a = null;
    }

    public static class Result<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f5065a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5066b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5067c;

        /* renamed from: d, reason: collision with root package name */
        public int f5068d;

        public Result(Object obj) {
            this.f5065a = obj;
        }

        public final boolean a() {
            return this.f5066b || this.f5067c;
        }

        public final void c() {
            if (this.f5066b || this.f5067c) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f5065a);
            }
            this.f5066b = true;
            b();
        }

        public void b() {
        }
    }
}
