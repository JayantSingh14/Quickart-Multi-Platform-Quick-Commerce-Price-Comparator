package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzab;
import com.google.android.gms.cloudmessaging.zzv;
import com.google.android.gms.cloudmessaging.zzy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Store;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: m, reason: collision with root package name */
    public static Store f44699m;
    public static ScheduledThreadPoolExecutor o;

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseApp f44700a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseInstanceIdInternal f44701b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f44702c;

    /* renamed from: d, reason: collision with root package name */
    public final GmsRpc f44703d;

    /* renamed from: e, reason: collision with root package name */
    public final RequestDeduplicator f44704e;

    /* renamed from: f, reason: collision with root package name */
    public final AutoInit f44705f;

    /* renamed from: g, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f44706g;

    /* renamed from: h, reason: collision with root package name */
    public final ThreadPoolExecutor f44707h;

    /* renamed from: i, reason: collision with root package name */
    public final Task f44708i;

    /* renamed from: j, reason: collision with root package name */
    public final Metadata f44709j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f44710k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f44698l = TimeUnit.HOURS.toSeconds(8);
    public static Provider n = new g();

    public class AutoInit {

        /* renamed from: a, reason: collision with root package name */
        public final Subscriber f44711a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f44712b;

        /* renamed from: c, reason: collision with root package name */
        public n f44713c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f44714d;

        public AutoInit(Subscriber subscriber) {
            this.f44711a = subscriber;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.google.firebase.messaging.n] */
        public final synchronized void a() {
            try {
                if (this.f44712b) {
                    return;
                }
                Boolean boolC = c();
                this.f44714d = boolC;
                if (boolC == null) {
                    ?? r0 = new EventHandler() { // from class: com.google.firebase.messaging.n
                        @Override // com.google.firebase.events.EventHandler
                        public final void a(Event event) {
                            FirebaseMessaging.AutoInit autoInit = this.f44840a;
                            if (autoInit.b()) {
                                Store store = FirebaseMessaging.f44699m;
                                FirebaseMessaging.this.m();
                            }
                        }
                    };
                    this.f44713c = r0;
                    this.f44711a.b(r0);
                }
                this.f44712b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized boolean b() {
            Boolean bool;
            try {
                a();
                bool = this.f44714d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f44700a.j();
        }

        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            FirebaseApp firebaseApp = FirebaseMessaging.this.f44700a;
            firebaseApp.a();
            Context context = firebaseApp.f43489a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider3, Subscriber subscriber) {
        final int i2 = 0;
        final int i3 = 1;
        firebaseApp.a();
        Context context = firebaseApp.f43489a;
        final Metadata metadata = new Metadata(context);
        final GmsRpc gmsRpc = new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-File-Io"));
        this.f44710k = false;
        n = provider3;
        this.f44700a = firebaseApp;
        this.f44701b = firebaseInstanceIdInternal;
        this.f44705f = new AutoInit(subscriber);
        firebaseApp.a();
        final Context context2 = firebaseApp.f43489a;
        this.f44702c = context2;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.f44709j = metadata;
        this.f44703d = gmsRpc;
        this.f44704e = new RequestDeduplicator(executorServiceNewSingleThreadExecutor);
        this.f44706g = scheduledThreadPoolExecutor;
        this.f44707h = threadPoolExecutor;
        firebaseApp.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.c();
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.l

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f44838b;

            {
                this.f44838b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f44838b;
                        if (firebaseMessaging.f44705f.b()) {
                            firebaseMessaging.m();
                            break;
                        }
                        break;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f44838b;
                        Context context3 = firebaseMessaging2.f44702c;
                        ProxyNotificationInitializer.a(context3);
                        ProxyNotificationPreferences.b(context3, firebaseMessaging2.f44703d, firebaseMessaging2.l());
                        if (firebaseMessaging2.l()) {
                            firebaseMessaging2.g();
                            break;
                        }
                        break;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
        int i4 = TopicsSubscriber.f44781j;
        Task taskC = Tasks.c(new Callable() { // from class: com.google.firebase.messaging.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsStore topicsStore;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                Metadata metadata2 = metadata;
                GmsRpc gmsRpc2 = gmsRpc;
                int i5 = TopicsSubscriber.f44781j;
                synchronized (TopicsStore.class) {
                    try {
                        WeakReference weakReference = TopicsStore.f44777c;
                        topicsStore = weakReference != null ? (TopicsStore) weakReference.get() : null;
                        if (topicsStore == null) {
                            SharedPreferences sharedPreferences = context3.getSharedPreferences("com.google.android.gms.appid", 0);
                            TopicsStore topicsStore2 = new TopicsStore(sharedPreferences, scheduledThreadPoolExecutor3);
                            synchronized (topicsStore2) {
                                topicsStore2.f44778a = SharedPreferencesQueue.a(sharedPreferences, scheduledThreadPoolExecutor3);
                            }
                            TopicsStore.f44777c = new WeakReference(topicsStore2);
                            topicsStore = topicsStore2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new TopicsSubscriber(firebaseMessaging, metadata2, topicsStore, gmsRpc2, context3, scheduledThreadPoolExecutor3);
            }
        }, scheduledThreadPoolExecutor2);
        this.f44708i = taskC;
        taskC.f(scheduledThreadPoolExecutor, new m(this));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.l

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f44838b;

            {
                this.f44838b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f44838b;
                        if (firebaseMessaging.f44705f.b()) {
                            firebaseMessaging.m();
                            break;
                        }
                        break;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f44838b;
                        Context context3 = firebaseMessaging2.f44702c;
                        ProxyNotificationInitializer.a(context3);
                        ProxyNotificationPreferences.b(context3, firebaseMessaging2.f44703d, firebaseMessaging2.l());
                        if (firebaseMessaging2.l()) {
                            firebaseMessaging2.g();
                            break;
                        }
                        break;
                }
            }
        });
    }

    public static void b(long j2, Runnable runnable) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (o == null) {
                    o = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                o.schedule(runnable, j2, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized FirebaseMessaging c() {
        return getInstance(FirebaseApp.d());
    }

    public static synchronized Store d(Context context) {
        try {
            if (f44699m == null) {
                f44699m = new Store(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f44699m;
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) firebaseApp.b(FirebaseMessaging.class);
        Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public final String a() throws IOException {
        Task taskJ;
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f44701b;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.a(firebaseInstanceIdInternal.d());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        }
        final Store.Token tokenF = f();
        if (!o(tokenF)) {
            return tokenF.f44764a;
        }
        final String strB = Metadata.b(this.f44700a);
        final RequestDeduplicator requestDeduplicator = this.f44704e;
        synchronized (requestDeduplicator) {
            taskJ = (Task) requestDeduplicator.f44751b.get(strB);
            if (taskJ == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + strB);
                }
                GmsRpc gmsRpc = this.f44703d;
                taskJ = gmsRpc.a(gmsRpc.c(Metadata.b(gmsRpc.f44716a), "*", new Bundle())).r(this.f44707h, new SuccessContinuation() { // from class: com.google.firebase.messaging.i
                    @Override // com.google.android.gms.tasks.SuccessContinuation
                    public final Task then(Object obj) {
                        FirebaseMessaging firebaseMessaging = this.f44829a;
                        String str = strB;
                        Store.Token token = tokenF;
                        String str2 = (String) obj;
                        Store storeD = FirebaseMessaging.d(firebaseMessaging.f44702c);
                        String strE = firebaseMessaging.e();
                        String strA = firebaseMessaging.f44709j.a();
                        synchronized (storeD) {
                            String strA2 = Store.Token.a(System.currentTimeMillis(), str2, strA);
                            if (strA2 != null) {
                                SharedPreferences.Editor editorEdit = storeD.f44762a.edit();
                                editorEdit.putString(Store.a(strE, str), strA2);
                                editorEdit.commit();
                            }
                        }
                        if (token == null || !str2.equals(token.f44764a)) {
                            FirebaseApp firebaseApp = firebaseMessaging.f44700a;
                            firebaseApp.a();
                            if ("[DEFAULT]".equals(firebaseApp.f43490b)) {
                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                                    firebaseApp.a();
                                    sb.append(firebaseApp.f43490b);
                                    Log.d("FirebaseMessaging", sb.toString());
                                }
                                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                                intent.putExtra(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, str2);
                                new FcmBroadcastProcessor(firebaseMessaging.f44702c).b(intent);
                            }
                        }
                        return Tasks.e(str2);
                    }
                }).j(requestDeduplicator.f44750a, new Continuation() { // from class: com.google.firebase.messaging.q
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        RequestDeduplicator requestDeduplicator2 = requestDeduplicator;
                        String str = strB;
                        synchronized (requestDeduplicator2) {
                            requestDeduplicator2.f44751b.remove(str);
                        }
                        return task;
                    }
                });
                requestDeduplicator.f44751b.put(strB, taskJ);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + strB);
            }
        }
        try {
            return (String) Tasks.a(taskJ);
        } catch (InterruptedException | ExecutionException e3) {
            throw new IOException(e3);
        }
    }

    public final String e() {
        FirebaseApp firebaseApp = this.f44700a;
        firebaseApp.a();
        return "[DEFAULT]".equals(firebaseApp.f43490b) ? "" : firebaseApp.f();
    }

    public final Store.Token f() {
        Store.Token tokenB;
        Store storeD = d(this.f44702c);
        String strE = e();
        String strB = Metadata.b(this.f44700a);
        synchronized (storeD) {
            tokenB = Store.Token.b(storeD.f44762a.getString(Store.a(strE, strB), null));
        }
        return tokenB;
    }

    public final void g() {
        Rpc rpc = this.f44703d.f44718c;
        (rpc.f22240c.a() >= 241100000 ? zzv.a(rpc.f22239b).c(5, Bundle.EMPTY).h(zzy.f22292a, zzab.f22246a) : Tasks.d(new IOException("SERVICE_NOT_AVAILABLE"))).f(this.f44706g, new j(this, 1));
    }

    public final boolean h() {
        return this.f44705f.b();
    }

    public final boolean i() {
        return ProxyNotificationInitializer.b(this.f44702c);
    }

    public final void j(boolean z) {
        AutoInit autoInit = this.f44705f;
        synchronized (autoInit) {
            try {
                autoInit.a();
                n nVar = autoInit.f44713c;
                if (nVar != null) {
                    autoInit.f44711a.a(nVar);
                    autoInit.f44713c = null;
                }
                FirebaseApp firebaseApp = FirebaseMessaging.this.f44700a;
                firebaseApp.a();
                SharedPreferences.Editor editorEdit = firebaseApp.f43489a.getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z);
                editorEdit.apply();
                if (z) {
                    FirebaseMessaging.this.m();
                }
                autoInit.f44714d = Boolean.valueOf(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(boolean z) {
        FirebaseApp firebaseAppD = FirebaseApp.d();
        firebaseAppD.a();
        firebaseAppD.f43489a.getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", z).apply();
        ProxyNotificationPreferences.b(this.f44702c, this.f44703d, l());
    }

    public final boolean l() {
        Context context = this.f44702c;
        ProxyNotificationInitializer.a(context);
        if (!ProxyNotificationInitializer.b(context)) {
            return false;
        }
        if (this.f44700a.b(AnalyticsConnector.class) != null) {
            return true;
        }
        return MessagingAnalytics.a() && n != null;
    }

    public final void m() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f44701b;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.a();
        } else if (o(f())) {
            synchronized (this) {
                if (!this.f44710k) {
                    n(0L);
                }
            }
        }
    }

    public final synchronized void n(long j2) {
        b(j2, new SyncTask(this, Math.min(Math.max(30L, 2 * j2), f44698l)));
        this.f44710k = true;
    }

    public final boolean o(Store.Token token) {
        if (token != null) {
            return System.currentTimeMillis() > token.f44766c + Store.Token.f44763d || !this.f44709j.a().equals(token.f44765b);
        }
        return true;
    }
}
