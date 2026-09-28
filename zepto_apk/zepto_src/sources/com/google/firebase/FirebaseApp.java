package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class FirebaseApp {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f43487k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayMap f43488l = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f43489a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43490b;

    /* renamed from: c, reason: collision with root package name */
    public final FirebaseOptions f43491c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentRuntime f43492d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f43493e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f43494f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f43495g;

    /* renamed from: h, reason: collision with root package name */
    public final Provider f43496h;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f43497i;

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f43498j;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public static final AtomicReference f43499a = new AtomicReference();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public final void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.f43487k) {
                try {
                    Iterator it = new ArrayList(FirebaseApp.f43488l.values()).iterator();
                    while (it.hasNext()) {
                        FirebaseApp firebaseApp = (FirebaseApp) it.next();
                        if (firebaseApp.f43493e.get()) {
                            firebaseApp.k(z);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @TargetApi(24)
    /* loaded from: classes4.dex */
    public static class UserUnlockReceiver extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicReference f43500b = new AtomicReference();

        /* renamed from: a, reason: collision with root package name */
        public final Context f43501a;

        public UserUnlockReceiver(Context context) {
            this.f43501a = context;
        }

        public static void a(Context context) {
            AtomicReference atomicReference = f43500b;
            if (atomicReference.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                while (!atomicReference.compareAndSet(null, userUnlockReceiver)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f43487k) {
                try {
                    Iterator it = FirebaseApp.f43488l.values().iterator();
                    while (it.hasNext()) {
                        ((FirebaseApp) it.next()).g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f43501a.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    public FirebaseApp(final Context context, FirebaseOptions firebaseOptions, String str) throws PackageManager.NameNotFoundException {
        ?? arrayList;
        final int i2 = 1;
        final int i3 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f43493e = atomicBoolean;
        this.f43494f = new AtomicBoolean();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f43497i = copyOnWriteArrayList;
        this.f43498j = new CopyOnWriteArrayList();
        this.f43489a = (Context) Preconditions.checkNotNull(context);
        this.f43490b = Preconditions.checkNotEmpty(str);
        this.f43491c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        StartupTime startupTime = FirebaseInitProvider.f44909a;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ComponentDiscovery componentDiscoveryA = ComponentDiscovery.a(context);
        ArrayList arrayList2 = new ArrayList();
        Context context2 = componentDiscoveryA.f43570a;
        Bundle bundle = null;
        try {
            PackageManager packageManager = context2.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context2, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        for (final String str3 : arrayList) {
            arrayList2.add(new Provider() { // from class: com.google.firebase.components.a
                @Override // com.google.firebase.inject.Provider
                public final Object get() throws ClassNotFoundException {
                    switch (i3) {
                        case 0:
                            String str4 = (String) str3;
                            try {
                                Class<?> cls = Class.forName(str4);
                                if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                                    return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                                }
                                throw new InvalidRegistrarException("Class " + str4 + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                            } catch (ClassNotFoundException unused2) {
                                Log.w("ComponentDiscovery", "Class " + str4 + " is not an found.");
                                return null;
                            } catch (IllegalAccessException e2) {
                                throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e2);
                            } catch (InstantiationException e3) {
                                throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e3);
                            } catch (NoSuchMethodException e4) {
                                throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e4);
                            } catch (InvocationTargetException e5) {
                                throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e5);
                            }
                        default:
                            return (ComponentRegistrar) str3;
                    }
                }
            });
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        UiExecutor uiExecutor = UiExecutor.f43653a;
        ComponentRuntime.Builder builder = new ComponentRuntime.Builder();
        ArrayList arrayList3 = builder.f43580b;
        arrayList3.addAll(arrayList2);
        final FirebaseCommonRegistrar firebaseCommonRegistrar = new FirebaseCommonRegistrar();
        arrayList3.add(new Provider() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() throws ClassNotFoundException {
                switch (i2) {
                    case 0:
                        String str4 = (String) firebaseCommonRegistrar;
                        try {
                            Class<?> cls = Class.forName(str4);
                            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                            }
                            throw new InvalidRegistrarException("Class " + str4 + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                        } catch (ClassNotFoundException unused2) {
                            Log.w("ComponentDiscovery", "Class " + str4 + " is not an found.");
                            return null;
                        } catch (IllegalAccessException e2) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e2);
                        } catch (InstantiationException e3) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e3);
                        } catch (NoSuchMethodException e4) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e4);
                        } catch (InvocationTargetException e5) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e5);
                        }
                    default:
                        return (ComponentRegistrar) firebaseCommonRegistrar;
                }
            }
        });
        final ExecutorsRegistrar executorsRegistrar = new ExecutorsRegistrar();
        arrayList3.add(new Provider() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() throws ClassNotFoundException {
                switch (i2) {
                    case 0:
                        String str4 = (String) executorsRegistrar;
                        try {
                            Class<?> cls = Class.forName(str4);
                            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                            }
                            throw new InvalidRegistrarException("Class " + str4 + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                        } catch (ClassNotFoundException unused2) {
                            Log.w("ComponentDiscovery", "Class " + str4 + " is not an found.");
                            return null;
                        } catch (IllegalAccessException e2) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e2);
                        } catch (InstantiationException e3) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.D("Could not instantiate ", str4, CLConstants.DOT_SALT_DELIMETER), e3);
                        } catch (NoSuchMethodException e4) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e4);
                        } catch (InvocationTargetException e5) {
                            throw new InvalidRegistrarException(android.support.v4.media.b.C("Could not instantiate ", str4), e5);
                        }
                    default:
                        return (ComponentRegistrar) executorsRegistrar;
                }
            }
        });
        Component componentC = Component.c(context, Context.class, new Class[0]);
        ArrayList arrayList4 = builder.f43581c;
        arrayList4.add(componentC);
        arrayList4.add(Component.c(this, FirebaseApp.class, new Class[0]));
        arrayList4.add(Component.c(firebaseOptions, FirebaseOptions.class, new Class[0]));
        builder.f43582d = new ComponentMonitor();
        if (UserManagerCompat.a(context) && FirebaseInitProvider.f44910b.get()) {
            arrayList4.add(Component.c(startupTime, StartupTime.class, new Class[0]));
        }
        ComponentRuntime componentRuntime = new ComponentRuntime(builder.f43579a, arrayList3, arrayList4, builder.f43582d);
        this.f43492d = componentRuntime;
        Trace.endSection();
        this.f43495g = new Lazy(new Provider() { // from class: com.google.firebase.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                Object obj = FirebaseApp.f43487k;
                FirebaseApp firebaseApp = this.f43524a;
                return new DataCollectionConfigStorage(context, firebaseApp.f(), (Publisher) firebaseApp.f43492d.a(Publisher.class));
            }
        });
        this.f43496h = componentRuntime.g(DefaultHeartBeatController.class);
        BackgroundStateChangeListener backgroundStateChangeListener = new BackgroundStateChangeListener() { // from class: com.google.firebase.b
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void onBackgroundStateChanged(boolean z) {
                FirebaseApp firebaseApp = this.f43555a;
                if (!z) {
                    ((DefaultHeartBeatController) firebaseApp.f43496h.get()).c();
                } else {
                    Object obj = FirebaseApp.f43487k;
                    firebaseApp.getClass();
                }
            }
        };
        a();
        if (atomicBoolean.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        copyOnWriteArrayList.add(backgroundStateChangeListener);
        Trace.endSection();
    }

    public static ArrayList c() {
        ArrayList arrayList = new ArrayList();
        synchronized (f43487k) {
            try {
                for (FirebaseApp firebaseApp : f43488l.values()) {
                    firebaseApp.a();
                    arrayList.add(firebaseApp.f43490b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static FirebaseApp d() {
        FirebaseApp firebaseApp;
        synchronized (f43487k) {
            try {
                firebaseApp = (FirebaseApp) f43488l.get("[DEFAULT]");
                if (firebaseApp == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((DefaultHeartBeatController) firebaseApp.f43496h.get()).c();
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp e(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f43487k) {
            try {
                firebaseApp = (FirebaseApp) f43488l.get(str.trim());
                if (firebaseApp == null) {
                    ArrayList arrayListC = c();
                    if (arrayListC.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", arrayListC);
                    }
                    throw new IllegalStateException("FirebaseApp with name " + str + " doesn't exist. " + str2);
                }
                ((DefaultHeartBeatController) firebaseApp.f43496h.get()).c();
            } finally {
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp h(Context context) {
        synchronized (f43487k) {
            try {
                if (f43488l.containsKey("[DEFAULT]")) {
                    return d();
                }
                FirebaseOptions firebaseOptionsA = FirebaseOptions.a(context);
                if (firebaseOptionsA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return i(context, firebaseOptionsA, "[DEFAULT]");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static FirebaseApp i(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        AtomicReference atomicReference = GlobalBackgroundStateListener.f43499a;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = GlobalBackgroundStateListener.f43499a;
            if (atomicReference2.get() == null) {
                GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                while (true) {
                    if (atomicReference2.compareAndSet(null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        String strTrim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f43487k) {
            ArrayMap arrayMap = f43488l;
            Preconditions.checkState(!arrayMap.containsKey(strTrim), "FirebaseApp name " + strTrim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, firebaseOptions, strTrim);
            arrayMap.put(strTrim, firebaseApp);
        }
        firebaseApp.g();
        return firebaseApp;
    }

    public final void a() {
        Preconditions.checkState(!this.f43494f.get(), "FirebaseApp was deleted");
    }

    public final Object b(Class cls) {
        a();
        return this.f43492d.a(cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        FirebaseApp firebaseApp = (FirebaseApp) obj;
        firebaseApp.a();
        return this.f43490b.equals(firebaseApp.f43490b);
    }

    public final String f() {
        StringBuilder sb = new StringBuilder();
        a();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.f43490b.getBytes(Charset.defaultCharset())));
        sb.append("+");
        a();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.f43491c.f43507b.getBytes(Charset.defaultCharset())));
        return sb.toString();
    }

    public final void g() {
        HashMap map;
        if (!UserManagerCompat.a(this.f43489a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f43490b);
            Log.i("FirebaseApp", sb.toString());
            UserUnlockReceiver.a(this.f43489a);
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f43490b);
        Log.i("FirebaseApp", sb2.toString());
        ComponentRuntime componentRuntime = this.f43492d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f43490b);
        AtomicReference atomicReference = componentRuntime.f43577f;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference.compareAndSet(null, boolValueOf)) {
                synchronized (componentRuntime) {
                    map = new HashMap(componentRuntime.f43572a);
                }
                componentRuntime.j(map, zEquals);
                break;
            } else if (atomicReference.get() != null) {
                break;
            }
        }
        ((DefaultHeartBeatController) this.f43496h.get()).c();
    }

    public final int hashCode() {
        return this.f43490b.hashCode();
    }

    public final boolean j() {
        boolean z;
        a();
        DataCollectionConfigStorage dataCollectionConfigStorage = (DataCollectionConfigStorage) this.f43495g.get();
        synchronized (dataCollectionConfigStorage) {
            z = dataCollectionConfigStorage.f44659d;
        }
        return z;
    }

    public final void k(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f43497i.iterator();
        while (it.hasNext()) {
            ((BackgroundStateChangeListener) it.next()).onBackgroundStateChanged(z);
        }
    }

    public final void l(Boolean bool) {
        a();
        DataCollectionConfigStorage dataCollectionConfigStorage = (DataCollectionConfigStorage) this.f43495g.get();
        synchronized (dataCollectionConfigStorage) {
            try {
                if (bool == null) {
                    dataCollectionConfigStorage.f44657b.edit().remove("firebase_data_collection_default_enabled").apply();
                    dataCollectionConfigStorage.b(dataCollectionConfigStorage.a());
                } else {
                    boolean zEquals = Boolean.TRUE.equals(bool);
                    dataCollectionConfigStorage.f44657b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
                    dataCollectionConfigStorage.b(zEquals);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(CLConstants.FIELD_PAY_INFO_NAME, this.f43490b).add("options", this.f43491c).toString();
    }
}
