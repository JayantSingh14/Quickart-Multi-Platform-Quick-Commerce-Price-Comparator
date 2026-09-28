package com.google.firebase.installations;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.time.SystemClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f44568m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseApp f44569a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseInstallationServiceClient f44570b;

    /* renamed from: c, reason: collision with root package name */
    public final PersistedInstallation f44571c;

    /* renamed from: d, reason: collision with root package name */
    public final Utils f44572d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f44573e;

    /* renamed from: f, reason: collision with root package name */
    public final RandomFidGenerator f44574f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f44575g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f44576h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f44577i;

    /* renamed from: j, reason: collision with root package name */
    public String f44578j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f44579k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f44580l;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements FidListenerHandle {
    }

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44582a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f44583b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f44583b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44583b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44583b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f44582a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44582a[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        new ThreadFactory() { // from class: com.google.firebase.installations.FirebaseInstallations.1

            /* renamed from: a, reason: collision with root package name */
            public final AtomicInteger f44581a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f44581a.getAndIncrement())));
            }
        };
    }

    public FirebaseInstallations(final FirebaseApp firebaseApp, Provider provider, ExecutorService executorService, Executor executor) {
        firebaseApp.a();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.f43489a, provider);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        if (SystemClock.f44655a == null) {
            SystemClock.f44655a = new SystemClock();
        }
        SystemClock systemClock = SystemClock.f44655a;
        if (Utils.f44592d == null) {
            Utils.f44592d = new Utils(systemClock);
        }
        Utils utils = Utils.f44592d;
        Lazy lazy = new Lazy(new Provider() { // from class: com.google.firebase.installations.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                Object obj = FirebaseInstallations.f44568m;
                return new IidStore(firebaseApp);
            }
        });
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.f44575g = new Object();
        this.f44579k = new HashSet();
        this.f44580l = new ArrayList();
        this.f44569a = firebaseApp;
        this.f44570b = firebaseInstallationServiceClient;
        this.f44571c = persistedInstallation;
        this.f44572d = utils;
        this.f44573e = lazy;
        this.f44574f = randomFidGenerator;
        this.f44576h = executorService;
        this.f44577i = executor;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public final Task a() {
        d();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.f44572d, taskCompletionSource);
        synchronized (this.f44575g) {
            this.f44580l.add(getAuthTokenListener);
        }
        this.f44576h.execute(new b(this, 2));
        return taskCompletionSource.f39750a;
    }

    /* JADX WARN: Finally extract failed */
    public final void b() {
        PersistedInstallationEntry persistedInstallationEntryC;
        synchronized (f44568m) {
            try {
                FirebaseApp firebaseApp = this.f44569a;
                firebaseApp.a();
                CrossProcessLock crossProcessLockA = CrossProcessLock.a(firebaseApp.f43489a);
                try {
                    persistedInstallationEntryC = this.f44571c.c();
                    if (persistedInstallationEntryC.f() == PersistedInstallation.RegistrationStatus.f44617b || persistedInstallationEntryC.f() == PersistedInstallation.RegistrationStatus.f44616a) {
                        String strE = e(persistedInstallationEntryC);
                        PersistedInstallation persistedInstallation = this.f44571c;
                        PersistedInstallationEntry.Builder builderH = persistedInstallationEntryC.h();
                        builderH.d(strE);
                        builderH.f(PersistedInstallation.RegistrationStatus.f44618c);
                        persistedInstallationEntryC = builderH.a();
                        persistedInstallation.b(persistedInstallationEntryC);
                    }
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                } catch (Throwable th) {
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        h(persistedInstallationEntryC);
        this.f44577i.execute(new b(this, 0));
    }

    public final PersistedInstallationEntry c(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        FirebaseApp firebaseApp = this.f44569a;
        firebaseApp.a();
        String str = firebaseApp.f43491c.f43506a;
        String strC = persistedInstallationEntry.c();
        FirebaseApp firebaseApp2 = this.f44569a;
        firebaseApp2.a();
        TokenResult tokenResultB = this.f44570b.b(str, strC, firebaseApp2.f43491c.f43512g, persistedInstallationEntry.e());
        int iOrdinal = tokenResultB.b().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return persistedInstallationEntry.i();
            }
            if (iOrdinal != 2) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
            }
            synchronized (this) {
                this.f44578j = null;
            }
            PersistedInstallationEntry.Builder builderH = persistedInstallationEntry.h();
            builderH.f(PersistedInstallation.RegistrationStatus.f44617b);
            return builderH.a();
        }
        String strC2 = tokenResultB.c();
        long jD = tokenResultB.d();
        Utils utils = this.f44572d;
        utils.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        utils.f44593a.getClass();
        long seconds = timeUnit.toSeconds(System.currentTimeMillis());
        PersistedInstallationEntry.Builder builderH2 = persistedInstallationEntry.h();
        builderH2.b(strC2);
        builderH2.c(jD);
        builderH2.g(seconds);
        return builderH2.a();
    }

    public final void d() {
        FirebaseApp firebaseApp = this.f44569a;
        firebaseApp.a();
        Preconditions.checkNotEmpty(firebaseApp.f43491c.f43507b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp.a();
        Preconditions.checkNotEmpty(firebaseApp.f43491c.f43512g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp.a();
        Preconditions.checkNotEmpty(firebaseApp.f43491c.f43506a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp.a();
        String str = firebaseApp.f43491c.f43507b;
        Pattern pattern = Utils.f44591c;
        Preconditions.checkArgument(str.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp.a();
        Preconditions.checkArgument(Utils.f44591c.matcher(firebaseApp.f43491c.f43506a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(com.google.firebase.installations.local.PersistedInstallationEntry r6) {
        /*
            r5 = this;
            com.google.firebase.FirebaseApp r0 = r5.f44569a
            r0.a()
            java.lang.String r0 = r0.f43490b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            com.google.firebase.FirebaseApp r0 = r5.f44569a
            r0.a()
            java.lang.String r1 = "[DEFAULT]"
            java.lang.String r0 = r0.f43490b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L1e:
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r6 = r6.f()
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.f44616a
            if (r6 != r0) goto L5f
            com.google.firebase.components.Lazy r6 = r5.f44573e
            java.lang.Object r6 = r6.get()
            com.google.firebase.installations.local.IidStore r6 = (com.google.firebase.installations.local.IidStore) r6
            android.content.SharedPreferences r0 = r6.f44612a
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.f44612a     // Catch: java.lang.Throwable -> L42
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L42
            android.content.SharedPreferences r2 = r6.f44612a     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = "|S|id"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            goto L49
        L42:
            r6 = move-exception
            goto L5d
        L44:
            java.lang.String r2 = r6.a()     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
        L49:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L59
            com.google.firebase.installations.RandomFidGenerator r6 = r5.f44574f
            r6.getClass()
            java.lang.String r6 = com.google.firebase.installations.RandomFidGenerator.a()
            return r6
        L59:
            return r2
        L5a:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5a
            throw r6     // Catch: java.lang.Throwable -> L42
        L5d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            throw r6
        L5f:
            com.google.firebase.installations.RandomFidGenerator r6 = r5.f44574f
            r6.getClass()
            java.lang.String r6 = com.google.firebase.installations.RandomFidGenerator.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.e(com.google.firebase.installations.local.PersistedInstallationEntry):java.lang.String");
    }

    public final PersistedInstallationEntry f(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        String string = null;
        if (persistedInstallationEntry.c() != null && persistedInstallationEntry.c().length() == 11) {
            IidStore iidStore = (IidStore) this.f44573e.get();
            synchronized (iidStore.f44612a) {
                try {
                    String[] strArr = IidStore.f44611c;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 4) {
                            break;
                        }
                        String str = strArr[i2];
                        String string2 = iidStore.f44612a.getString("|T|" + iidStore.f44613b + CLConstants.SALT_DELIMETER + str, null);
                        if (string2 == null || string2.isEmpty()) {
                            i2++;
                        } else if (string2.startsWith("{")) {
                            try {
                                string = new JSONObject(string2).getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN);
                            } catch (JSONException unused) {
                            }
                        } else {
                            string = string2;
                        }
                    }
                } finally {
                }
            }
        }
        String str2 = string;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.f44570b;
        FirebaseApp firebaseApp = this.f44569a;
        firebaseApp.a();
        String str3 = firebaseApp.f43491c.f43506a;
        String strC = persistedInstallationEntry.c();
        FirebaseApp firebaseApp2 = this.f44569a;
        firebaseApp2.a();
        String str4 = firebaseApp2.f43491c.f43512g;
        FirebaseApp firebaseApp3 = this.f44569a;
        firebaseApp3.a();
        InstallationResponse installationResponseA = firebaseInstallationServiceClient.a(str3, strC, str4, firebaseApp3.f43491c.f43507b, str2);
        int iOrdinal = installationResponseA.d().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return persistedInstallationEntry.i();
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
        String strB = installationResponseA.b();
        String strC2 = installationResponseA.c();
        Utils utils = this.f44572d;
        utils.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        utils.f44593a.getClass();
        long seconds = timeUnit.toSeconds(System.currentTimeMillis());
        String strC3 = installationResponseA.a().c();
        long jD = installationResponseA.a().d();
        PersistedInstallationEntry.Builder builderH = persistedInstallationEntry.h();
        builderH.d(strB);
        builderH.f(PersistedInstallation.RegistrationStatus.f44619d);
        builderH.b(strC3);
        builderH.e(strC2);
        builderH.c(jD);
        builderH.g(seconds);
        return builderH.a();
    }

    public final void g(Exception exc) {
        synchronized (this.f44575g) {
            try {
                Iterator it = this.f44580l.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public final Task getId() {
        String str;
        d();
        synchronized (this) {
            str = this.f44578j;
        }
        if (str != null) {
            return Tasks.e(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.f44575g) {
            this.f44580l.add(getIdListener);
        }
        zzw zzwVar = taskCompletionSource.f39750a;
        this.f44576h.execute(new b(this, 1));
        return zzwVar;
    }

    public final void h(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f44575g) {
            try {
                Iterator it = this.f44580l.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).b(persistedInstallationEntry)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
