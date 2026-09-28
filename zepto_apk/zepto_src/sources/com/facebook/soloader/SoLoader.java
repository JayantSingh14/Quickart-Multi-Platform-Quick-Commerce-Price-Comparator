package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Trace;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.react.soloader.OpenSourceMergedSoMapping;
import com.facebook.soloader.SysUtil;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import com.facebook.soloader.observer.Observer;
import com.facebook.soloader.observer.ObserverHolder;
import com.facebook.soloader.recovery.DefaultRecoveryStrategyFactory;
import com.facebook.soloader.recovery.RecoveryStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public class SoLoader {

    /* renamed from: b, reason: collision with root package name */
    public static InstrumentedSoFileLoader f20286b;

    /* renamed from: m, reason: collision with root package name */
    public static int f20297m;

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock f20287c = new ReentrantReadWriteLock();

    /* renamed from: d, reason: collision with root package name */
    public static Context f20288d = null;

    /* renamed from: e, reason: collision with root package name */
    public static volatile SoSource[] f20289e = null;

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f20290f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    public static DefaultRecoveryStrategyFactory f20291g = null;

    /* renamed from: h, reason: collision with root package name */
    public static final Set f20292h = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f20293i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static final Set f20294j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f20295k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static boolean f20296l = true;
    public static int n = 0;
    public static OpenSourceMergedSoMapping o = null;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f20285a = true;

    /* loaded from: classes3.dex */
    public interface AppType {
    }

    @NotThreadSafe
    /* loaded from: classes3.dex */
    public static class TestOnlyUtils {
    }

    /* loaded from: classes3.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        public WrongAbiError(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
            super(b.s(new StringBuilder("APK was built for a different platform. Supported ABIs: "), Arrays.toString(SysUtil.MarshmallowSysdeps.getSupportedAbis()), " error: ", str));
            initCause(unsatisfiedLinkError);
        }
    }

    public static void a(int i2, ArrayList arrayList) {
        ApplicationSoSource applicationSoSource = new ApplicationSoSource(f20288d, i2);
        LogUtil.a("Adding application source: " + applicationSoSource.toString());
        arrayList.add(0, applicationSoSource);
    }

    public static void b(ArrayList arrayList) {
        String strL = SysUtil.MarshmallowSysdeps.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str != null && !str.equals("")) {
            strL = b.l(str, ":", strL);
        }
        Iterator it = new HashSet(Arrays.asList(strL.split(":"))).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LogUtil.a("adding system library source: " + str2);
            arrayList.add(new DirectorySoSource(new File(str2), 2));
        }
    }

    public static void c(String str, String str2, int i2, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f20289e == null) {
                Log.e("SoLoader", "Could not load: " + str + " because SoLoader is not initialized");
                throw new UnsatisfiedLinkError("SoLoader not initialized, couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            if (threadPolicy == null) {
                threadPolicy = StrictMode.allowThreadDiskReads();
                z = true;
            } else {
                z = false;
            }
            if (f20285a) {
                if (str2 != null) {
                    Api18TraceUtils.a("SoLoader.loadLibrary[", str2, "]");
                }
                Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                try {
                    try {
                        for (SoSource soSource : f20289e) {
                            if (q(soSource, str, i2, threadPolicy)) {
                                if (z) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        throw SoLoaderDSONotFoundError.a(str, f20288d, f20289e);
                    } catch (IOException e2) {
                        SoLoaderULError soLoaderULError = new SoLoaderULError(str, e2.toString());
                        soLoaderULError.initCause(e2);
                        throw soLoaderULError;
                    }
                } finally {
                }
            } finally {
                if (f20285a) {
                    if (str2 != null) {
                        Trace.endSection();
                    }
                    Trace.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
            }
        } finally {
        }
    }

    public static int d(Context context) {
        int i2 = n;
        if (i2 != 0) {
            return i2;
        }
        if (context == null) {
            LogUtil.a("context is null, fallback to THIRD_PARTY_APP appType");
            return 1;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i3 = applicationInfo.flags;
        int i4 = (i3 & 1) != 0 ? (i3 & 128) != 0 ? 3 : 2 : 1;
        LogUtil.a("ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i4);
        return i4;
    }

    public static synchronized RecoveryStrategy e() {
        DefaultRecoveryStrategyFactory defaultRecoveryStrategyFactory;
        defaultRecoveryStrategyFactory = f20291g;
        return defaultRecoveryStrategyFactory == null ? null : defaultRecoveryStrategyFactory.a();
    }

    public static void f(int i2, Context context) {
        if (k()) {
            Log.w("SoLoader", "SoLoader already initialized");
            return;
        }
        Log.w("SoLoader", "Initializing SoLoader: " + i2);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            boolean zH = h(context);
            f20296l = zH;
            if (zH) {
                int iD = d(context);
                n = iD;
                if ((i2 & 128) == 0) {
                    if (iD == 2 || (context != null && (context.getApplicationInfo().flags & 268435456) == 0)) {
                        i2 |= 8;
                    }
                }
                i(i2, context);
                j(i2, context);
                LogUtil.c("SoLoader", "Init SoLoader delegate");
                NativeLoader.a(new NativeLoaderToSoLoaderDelegate());
            } else {
                g();
                LogUtil.c("SoLoader", "Init System Loader delegate");
                NativeLoader.a(new SystemDelegate());
            }
            Log.w("SoLoader", "SoLoader initialized: " + i2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static void g() {
        if (f20289e != null) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (f20289e == null) {
                f20289e = new SoSource[0];
            }
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f20287c.writeLock().unlock();
            throw th;
        }
    }

    public static boolean h(Context context) {
        String packageName;
        if (o != null) {
            return true;
        }
        Bundle bundle = null;
        try {
            packageName = context.getPackageName();
        } catch (Exception e2) {
            e = e2;
            packageName = null;
        }
        try {
            bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
        } catch (Exception e3) {
            e = e3;
            Log.w("SoLoader", "Unexpected issue with package manager (" + packageName + ")", e);
            return bundle == null ? true : true;
        }
        if (bundle == null && !bundle.getBoolean("com.facebook.soloader.enabled", true)) {
            return false;
        }
    }

    public static synchronized void i(int i2, Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
                } else {
                    context = applicationContext;
                }
                f20288d = context;
                f20291g = new DefaultRecoveryStrategyFactory(context, (i2 & 2048) != 0 ? 1 : 0);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f20286b != null) {
            return;
        }
        new SoFileLoaderImpl();
        f20286b = new InstrumentedSoFileLoader();
    }

    public static void init(Context context, int i2) throws IOException {
        f(i2, context);
    }

    public static void j(int i2, Context context) {
        int i3;
        int i4;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (f20289e != null) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (f20289e != null) {
                writeLock = reentrantReadWriteLock.writeLock();
            } else {
                f20297m = i2;
                ArrayList arrayList = new ArrayList();
                boolean z = (i2 & 512) != 0;
                boolean z2 = (i2 & 1024) != 0;
                if (z) {
                    SystemLoadWrapperSoSource systemLoadWrapperSoSource = new SystemLoadWrapperSoSource();
                    LogUtil.a("adding systemLoadWrapper source: " + systemLoadWrapperSoSource);
                    arrayList.add(0, systemLoadWrapperSoSource);
                } else if (z2) {
                    b(arrayList);
                    arrayList.add(0, new DirectSplitSoSource());
                } else {
                    b(arrayList);
                    if (context != null) {
                        if ((i2 & 1) != 0) {
                            int i5 = n;
                            if (i5 != 1) {
                                if (i5 != 2 && i5 != 3) {
                                    throw new RuntimeException("Unsupported app type, we should not reach here");
                                }
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            a(i4, arrayList);
                            LogUtil.a("Adding exo package source: lib-main");
                            arrayList.add(0, new ExoSoSource(context));
                        } else {
                            if (n == 2 || (context.getApplicationInfo().flags & 268435456) == 0) {
                                DirectApkSoSource directApkSoSource = new DirectApkSoSource(context);
                                LogUtil.a("validating/adding directApk source: " + directApkSoSource.toString());
                                if (!directApkSoSource.f20250c.isEmpty()) {
                                    arrayList.add(0, directApkSoSource);
                                }
                            }
                            int i6 = n;
                            if (i6 != 1) {
                                if (i6 != 2 && i6 != 3) {
                                    throw new RuntimeException("Unsupported app type, we should not reach here");
                                }
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            a(i3, arrayList);
                            boolean z3 = (i2 & 4096) != 0;
                            if ((f20297m & 8) == 0) {
                                arrayList.add(0, new BackupSoSource(context, "lib-main", !z3));
                            }
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                reentrantReadWriteLock.writeLock().lock();
                try {
                    int i7 = f20297m;
                    int i8 = (i7 & 2) != 0 ? 1 : 0;
                    if ((i7 & 256) != 0) {
                        i8 |= 4;
                    }
                    if ((i7 & 128) == 0) {
                        i8 |= 8;
                    }
                    reentrantReadWriteLock.writeLock().unlock();
                    int length = soSourceArr.length;
                    while (true) {
                        int i9 = length - 1;
                        if (length <= 0) {
                            break;
                        }
                        String str = "Preparing SO source: " + soSourceArr[i9];
                        if (LogUtil.b(4, "SoLoader")) {
                            Log.i("SoLoader", str);
                        }
                        boolean z4 = f20285a;
                        if (z4) {
                            Api18TraceUtils.a("SoLoader", Attributes.PREDEFINED_ATTRIBUTE_PREFIX, soSourceArr[i9].getClass().getSimpleName());
                        }
                        soSourceArr[i9].e(i8);
                        if (z4) {
                            Trace.endSection();
                        }
                        length = i9;
                    }
                    f20289e = soSourceArr;
                    f20290f.getAndIncrement();
                    String str2 = "init finish: " + f20289e.length + " SO sources prepared";
                    if (LogUtil.b(4, "SoLoader")) {
                        Log.i("SoLoader", str2);
                    }
                    writeLock = f20287c.writeLock();
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            writeLock.unlock();
        } catch (Throwable th) {
            reentrantReadWriteLock = f20287c;
            throw th;
        }
    }

    public static boolean k() {
        if (f20289e != null) {
            return true;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
        reentrantReadWriteLock.readLock().lock();
        try {
            boolean z = f20289e != null;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            f20287c.readLock().unlock();
            throw th;
        }
    }

    public static void l(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Observer[] observerArr = (Observer[]) ObserverHolder.f20309a.get();
        int i3 = 0;
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.i();
            }
        }
        try {
            p(str, null, null, i2 | 1, threadPolicy);
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                Observer[] observerArr2 = (Observer[]) ObserverHolder.f20309a.get();
                if (observerArr2 != null) {
                    int length = observerArr2.length;
                    while (i3 < length) {
                        observerArr2[i3].d();
                        i3++;
                    }
                }
            }
        }
    }

    public static void m(String str) {
        if (f20296l) {
            n(0, str);
        } else {
            NativeLoader.b(str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x013b, code lost:
    
        if (r8.equals("mapbufferjni") != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x013d, code lost:
    
        r0 = "reactnative";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        if (r8.equals("fabricjni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (r8.equals("jsinspector") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
    
        if (r8.equals("jscruntime") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
    
        if (r8.equals("jscexecutor") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
    
        if (r8.equals("uimanagerjni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        if (r8.equals("react_devsupportjni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cf, code lost:
    
        if (r8.equals("hermes_executor") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
    
        if (r8.equals("jsijniprofiler") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e3, code lost:
    
        if (r8.equals("hermesinstancejni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e6, code lost:
    
        r0 = "hermestooling";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e8, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f0, code lost:
    
        if (r8.equals("yoga") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f9, code lost:
    
        if (r8.equals("turbomodulejsijni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0102, code lost:
    
        if (r8.equals("react_newarchdefaults") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x010b, code lost:
    
        if (r8.equals("jscinstance") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x010e, code lost:
    
        r0 = "jsctooling";
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0117, code lost:
    
        if (r8.equals("react_featureflagsjni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0120, code lost:
    
        if (r8.equals("reactnativeblob") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0129, code lost:
    
        if (r8.equals("reactnativejni") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0132, code lost:
    
        if (r8.equals("rninstance") == false) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(int r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.n(int, java.lang.String):boolean");
    }

    public static boolean o(int i2, String str, String str2, String str3) {
        RecoveryStrategy recoveryStrategyE = null;
        while (true) {
            try {
                return p(str, str2, str3, i2, null);
            } catch (UnsatisfiedLinkError e2) {
                StringBuilder sbY = b.y("Running a recovery step for ", str, " due to ");
                sbY.append(e2.toString());
                Log.w("SoLoader", sbY.toString());
                ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
                reentrantReadWriteLock.writeLock().lock();
                if (recoveryStrategyE == null) {
                    try {
                        try {
                            recoveryStrategyE = e();
                            if (recoveryStrategyE == null) {
                                Log.w("SoLoader", "No recovery strategy");
                                throw e2;
                            }
                        } catch (Throwable th) {
                            reentrantReadWriteLock.writeLock().unlock();
                            throw th;
                        }
                    } catch (NoBaseApkException e3) {
                        Log.e("SoLoader", "Base APK not found during recovery", e3);
                        throw e3;
                    } catch (Exception e4) {
                        Log.e("SoLoader", "Got an exception during recovery, will throw the initial error instead", e4);
                        throw e2;
                    }
                }
                if (!r(e2, recoveryStrategyE)) {
                    reentrantReadWriteLock.writeLock().unlock();
                    Log.w("SoLoader", "Failed to recover");
                    throw e2;
                }
                f20290f.getAndIncrement();
                reentrantReadWriteLock.writeLock().unlock();
            }
        }
    }

    public static boolean p(String str, String str2, String str3, int i2, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        Object obj2;
        if (TextUtils.isEmpty(str2) || !f20294j.contains(str2)) {
            Set set = f20292h;
            if (!set.contains(str) || str3 != null) {
                synchronized (SoLoader.class) {
                    try {
                        if (!set.contains(str)) {
                            z = false;
                        } else {
                            if (str3 == null) {
                                return false;
                            }
                            z = true;
                        }
                        HashMap map = f20293i;
                        if (map.containsKey(str)) {
                            obj = map.get(str);
                        } else {
                            Object obj3 = new Object();
                            map.put(str, obj3);
                            obj = obj3;
                        }
                        HashMap map2 = f20295k;
                        if (map2.containsKey(str2)) {
                            obj2 = map2.get(str2);
                        } else {
                            Object obj4 = new Object();
                            map2.put(str2, obj4);
                            obj2 = obj4;
                        }
                        ReentrantReadWriteLock reentrantReadWriteLock = f20287c;
                        reentrantReadWriteLock.readLock().lock();
                        try {
                            synchronized (obj) {
                                if (!z) {
                                    if (set.contains(str)) {
                                        if (str3 == null) {
                                            reentrantReadWriteLock.readLock().unlock();
                                            return false;
                                        }
                                        z = true;
                                    }
                                    if (!z) {
                                        try {
                                            LogUtil.a("About to load: " + str);
                                            c(str, str2, i2, threadPolicy);
                                            LogUtil.a("Loaded: " + str);
                                            set.add(str);
                                        } catch (UnsatisfiedLinkError e2) {
                                            String message = e2.getMessage();
                                            if (message == null || !message.contains("unexpected e_machine:")) {
                                                throw e2;
                                            }
                                            throw new WrongAbiError(message.substring(message.lastIndexOf("unexpected e_machine:")), e2);
                                        }
                                    }
                                }
                                synchronized (obj2) {
                                    if ((i2 & 16) == 0 && str3 != null) {
                                        try {
                                            if (TextUtils.isEmpty(str2) || !f20294j.contains(str2)) {
                                                boolean z2 = f20285a;
                                                if (z2 && o == null) {
                                                    Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                                }
                                                try {
                                                    try {
                                                        LogUtil.a("About to invoke JNI_OnLoad for merged library " + str2 + ", which was merged into " + str);
                                                        OpenSourceMergedSoMapping openSourceMergedSoMapping = o;
                                                        if (openSourceMergedSoMapping == null) {
                                                            MergedSoMapping.a(str2);
                                                            throw null;
                                                        }
                                                        openSourceMergedSoMapping.a(str2);
                                                        f20294j.add(str2);
                                                        if (z2 && o == null) {
                                                            Trace.endSection();
                                                        }
                                                    } finally {
                                                    }
                                                } catch (UnsatisfiedLinkError e3) {
                                                    throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e3);
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                                reentrantReadWriteLock.readLock().unlock();
                                return !z;
                            }
                        } catch (Throwable th) {
                            f20287c.readLock().unlock();
                            throw th;
                        }
                    } finally {
                    }
                }
            }
        }
        return false;
    }

    public static boolean q(SoSource soSource, String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Observer[] observerArr = (Observer[]) ObserverHolder.f20309a.get();
        int i3 = 0;
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.j();
            }
        }
        try {
            return soSource.d(str, i2, threadPolicy) != 0;
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                Observer[] observerArr2 = (Observer[]) ObserverHolder.f20309a.get();
                if (observerArr2 != null) {
                    int length = observerArr2.length;
                    while (i3 < length) {
                        observerArr2[i3].a();
                        i3++;
                    }
                }
            }
        }
    }

    public static boolean r(UnsatisfiedLinkError unsatisfiedLinkError, RecoveryStrategy recoveryStrategy) {
        Observer[] observerArr = (Observer[]) ObserverHolder.f20309a.get();
        int i2 = 0;
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.l();
            }
        }
        try {
            return recoveryStrategy.a(unsatisfiedLinkError, f20289e);
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                Observer[] observerArr2 = (Observer[]) ObserverHolder.f20309a.get();
                if (observerArr2 != null) {
                    int length = observerArr2.length;
                    while (i2 < length) {
                        observerArr2[i2].e();
                        i2++;
                    }
                }
            }
        }
    }
}
