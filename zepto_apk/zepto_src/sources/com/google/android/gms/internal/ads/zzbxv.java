package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbxv implements zzbxx {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f25677l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public static zzbxx f25678m;
    public static zzbxx n;
    public static zzbxx o;
    public static Boolean p;

    /* renamed from: b, reason: collision with root package name */
    public final Context f25680b;

    /* renamed from: e, reason: collision with root package name */
    public final VersionInfoParcel f25683e;

    /* renamed from: f, reason: collision with root package name */
    public final PackageInfo f25684f;

    /* renamed from: g, reason: collision with root package name */
    public final String f25685g;

    /* renamed from: h, reason: collision with root package name */
    public final String f25686h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f25688j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f25689k;

    /* renamed from: a, reason: collision with root package name */
    public final Object f25679a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f25681c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f25682d = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f25687i = new AtomicBoolean();

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbxv(android.content.Context r4, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f25679a = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r3.f25681c = r0
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r3.f25682d = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r3.f25687i = r0
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto L2c
            android.content.Context r4 = r4.getApplicationContext()
        L2c:
            r3.f25680b = r4
            r3.f25683e = r5
            com.google.android.gms.internal.ads.zzbgb r5 = com.google.android.gms.internal.ads.zzbgk.L8
            com.google.android.gms.ads.internal.client.zzbd r0 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r0 = r0.f21153c
            java.lang.Object r5 = r0.a(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0 = 0
            if (r5 == 0) goto L4d
            com.google.android.gms.internal.ads.zzfxl r5 = com.google.android.gms.ads.internal.util.client.zzf.f21413b
            if (r4 == 0) goto L4d
            android.content.pm.ApplicationInfo r5 = r4.getApplicationInfo()
            if (r5 != 0) goto L4f
        L4d:
            r4 = r0
            goto L5e
        L4f:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            r1 = 0
            android.content.pm.PackageInfo r4 = r5.getPackageInfo(r4, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
        L5e:
            r3.f25684f = r4
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.z8
            com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r1 = r5.f21153c
            java.lang.Object r1 = r1.a(r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r2 = "unknown"
            if (r1 == 0) goto L7f
            com.google.android.gms.internal.ads.zzfxl r1 = com.google.android.gms.ads.internal.util.client.zzf.f21413b
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getCountry()
            goto L80
        L7f:
            r1 = r2
        L80:
            r3.f25685g = r1
            com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c
            java.lang.Object r4 = r5.a(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto Lad
            android.content.Context r4 = r3.f25680b
            com.google.android.gms.internal.ads.zzfxl r5 = com.google.android.gms.ads.internal.util.client.zzf.f21413b
            if (r4 != 0) goto L97
            goto Lae
        L97:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r4 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            java.lang.String r5 = "com.android.vending"
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            if (r4 != 0) goto La6
            goto Lae
        La6:
            int r4 = r4.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            goto Lae
        Lad:
            r0 = r2
        Lae:
            r3.f25686h = r0
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.v8
            com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c
            java.lang.Object r4 = r5.a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto Lc9
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r3.f25689k = r4
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxv.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzbxx c(Context context) {
        synchronized (f25677l) {
            try {
                if (f25678m == null) {
                    if (h(context)) {
                        f25678m = new zzbxv(context, VersionInfoParcel.b());
                    } else {
                        f25678m = new zzbxw();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f25678m;
    }

    public static zzbxx d(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (f25677l) {
            try {
                if (o == null) {
                    boolean z = false;
                    if (((Boolean) zzbic.f25123c.c()).booleanValue()) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t8)).booleanValue() || ((Boolean) zzbic.f25121a.c()).booleanValue()) {
                            z = true;
                        }
                    }
                    if (h(context)) {
                        zzbxv zzbxvVar = new zzbxv(context, versionInfoParcel);
                        zzbxvVar.i();
                        Thread.setDefaultUncaughtExceptionHandler(new zzbxs(zzbxvVar, Thread.getDefaultUncaughtExceptionHandler()));
                        o = zzbxvVar;
                    } else if (!z || context == null) {
                        o = new zzbxw();
                    } else {
                        zzbxv zzbxvVar2 = new zzbxv(context, versionInfoParcel);
                        zzbxvVar2.f25688j = true;
                        zzbxvVar2.i();
                        Thread.setDefaultUncaughtExceptionHandler(new zzbxs(zzbxvVar2, Thread.getDefaultUncaughtExceptionHandler()));
                        o = zzbxvVar2;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:11:0x002b, B:14:0x0039, B:15:0x0040), top: B:20:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbxx e(android.content.Context r4) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbxv.f25677l
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbxx r1 = com.google.android.gms.internal.ads.zzbxv.n     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L40
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.u8     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzbgi r3 = r2.f21153c     // Catch: java.lang.Throwable -> L37
            java.lang.Object r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L37
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L37
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L39
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.t8     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c     // Catch: java.lang.Throwable -> L37
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L37
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L37
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L39
            if (r4 == 0) goto L39
            com.google.android.gms.internal.ads.zzbxv r1 = new com.google.android.gms.internal.ads.zzbxv     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.b()     // Catch: java.lang.Throwable -> L37
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzbxv.n = r1     // Catch: java.lang.Throwable -> L37
            goto L40
        L37:
            r4 = move-exception
            goto L44
        L39:
            com.google.android.gms.internal.ads.zzbxw r4 = new com.google.android.gms.internal.ads.zzbxw     // Catch: java.lang.Throwable -> L37
            r4.<init>()     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzbxv.n = r4     // Catch: java.lang.Throwable -> L37
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzbxx r4 = com.google.android.gms.internal.ads.zzbxv.n
            return r4
        L44:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxv.e(android.content.Context):com.google.android.gms.internal.ads.zzbxx");
    }

    public static String f(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        synchronized (f25677l) {
            try {
                if (p == null) {
                    p = Boolean.valueOf(com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e.nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Qd)).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (p.booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t8)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxx
    public final void a(String str, Throwable th) {
        if (this.f25688j) {
            return;
        }
        b(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbxx
    public final void b(Throwable th, String str, float f2) {
        Throwable th2;
        boolean zIsCallerInstantApp;
        String packageName;
        PackageInfo packageInfo;
        ActivityManager.MemoryInfo memoryInfoJ;
        String strD;
        Context context = this.f25680b;
        if (this.f25688j) {
            return;
        }
        zzfxl zzfxlVar = com.google.android.gms.ads.internal.util.client.zzf.f21413b;
        if (((Boolean) zzbit.f25217e.c()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.L2)).booleanValue() && stackTrace != null && stackTrace.length == 0 && com.google.android.gms.ads.internal.util.client.zzf.o(th3.getClass().getName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (com.google.android.gms.ads.internal.util.client.zzf.o(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z) {
                    th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String strF = f(th);
            String str2 = "";
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P9)).booleanValue() && (strD = com.google.android.gms.ads.internal.util.client.zzf.d(f(th), MessageDigestAlgorithms.SHA_256)) != null) {
                str2 = strD;
            }
            double d2 = f2;
            double dRandom = Math.random();
            int i2 = f2 > 0.0f ? (int) (1.0f / f2) : 1;
            if (dRandom < d2) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    zIsCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
                } catch (Throwable th4) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error fetching instant app info", th4);
                    zIsCallerInstantApp = false;
                }
                try {
                    packageName = context.getPackageName();
                } catch (Throwable unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Cannot obtain package name, proceeding.");
                    packageName = com.google.ads.interactivemedia.v3.impl.data.zzck.UNKNOWN_CONTENT_TYPE;
                }
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zIsCallerInstantApp)).appendQueryParameter(CLConstants.SHARED_PREFERENCE_ITEM_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE);
                int i3 = Build.VERSION.SDK_INT;
                Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("api", String.valueOf(i3));
                String str3 = Build.MANUFACTURER;
                String strS = Build.MODEL;
                if (!strS.startsWith(str3)) {
                    strS = android.support.v4.media.b.s(new StringBuilder(androidx.fragment.app.e.g(1, str3) + strS.length()), str3, StringUtils.SPACE, strS);
                }
                Uri.Builder builderAppendQueryParameter3 = builderAppendQueryParameter2.appendQueryParameter(LogSubCategory.Context.DEVICE, strS);
                VersionInfoParcel versionInfoParcel = this.f25683e;
                Uri.Builder builderAppendQueryParameter4 = builderAppendQueryParameter3.appendQueryParameter("js", versionInfoParcel.f21400a).appendQueryParameter(AppsFlyerProperties.APP_ID, packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strF);
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                Uri.Builder builderAppendQueryParameter5 = builderAppendQueryParameter4.appendQueryParameter("eids", TextUtils.join(",", zzbdVar.f21151a.a())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "829525209").appendQueryParameter("rc", PaymentConstants.ENVIRONMENT.DEV).appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbit.f25215c.c())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(context))).appendQueryParameter("lite", true != versionInfoParcel.f21404e ? "0" : "1");
                if (!TextUtils.isEmpty(str2)) {
                    builderAppendQueryParameter5.appendQueryParameter("hash", str2);
                }
                zzbgb zzbgbVar = zzbgk.A8;
                zzbgi zzbgiVar = zzbdVar.f21153c;
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue() && (memoryInfoJ = com.google.android.gms.ads.internal.util.client.zzf.j(context)) != null) {
                    builderAppendQueryParameter5.appendQueryParameter("available_memory", Long.toString(memoryInfoJ.availMem));
                    builderAppendQueryParameter5.appendQueryParameter("total_memory", Long.toString(memoryInfoJ.totalMem));
                    builderAppendQueryParameter5.appendQueryParameter("is_low_memory", true != memoryInfoJ.lowMemory ? "0" : "1");
                }
                if (((Boolean) zzbgiVar.a(zzbgk.z8)).booleanValue()) {
                    String str4 = this.f25685g;
                    if (!TextUtils.isEmpty(str4)) {
                        builderAppendQueryParameter5.appendQueryParameter("countrycode", str4);
                    }
                    String str5 = this.f25686h;
                    if (!TextUtils.isEmpty(str5)) {
                        builderAppendQueryParameter5.appendQueryParameter("psv", str5);
                    }
                    if (i3 >= 26) {
                        packageInfo = WebView.getCurrentWebViewPackage();
                    } else if (context == null) {
                        packageInfo = null;
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.webview", 128);
                        } catch (PackageManager.NameNotFoundException unused2) {
                        }
                    }
                    if (packageInfo != null) {
                        builderAppendQueryParameter5.appendQueryParameter("wvvc", Integer.toString(packageInfo.versionCode));
                        builderAppendQueryParameter5.appendQueryParameter("wvvn", packageInfo.versionName);
                        builderAppendQueryParameter5.appendQueryParameter("wvpn", packageInfo.packageName);
                    }
                }
                PackageInfo packageInfo2 = this.f25684f;
                if (packageInfo2 != null) {
                    builderAppendQueryParameter5.appendQueryParameter("appvc", String.valueOf(packageInfo2.versionCode));
                    builderAppendQueryParameter5.appendQueryParameter("appvn", packageInfo2.versionName);
                }
                arrayList2.add(builderAppendQueryParameter5.toString());
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    final String str6 = (String) it.next();
                    final com.google.android.gms.ads.internal.util.client.zzu zzuVar = new com.google.android.gms.ads.internal.util.client.zzu(context, null);
                    this.f25682d.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxu
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzuVar.b(str6, null);
                        }
                    });
                }
            }
        }
    }

    public final void g(Throwable th) throws NoSuchAlgorithmException {
        Context context;
        SharedPreferences sharedPreferences;
        if (th != null) {
            boolean zO = false;
            boolean zEquals = false;
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zO |= com.google.android.gms.ads.internal.util.client.zzf.o(stackTraceElement.getClassName());
                    zEquals |= zzbxv.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.v8)).intValue();
            if (iIntValue > 0) {
                HashSet hashSet = this.f25689k;
                if (hashSet.size() >= iIntValue) {
                    return;
                }
                String strD = com.google.android.gms.ads.internal.util.client.zzf.d(f(th), MessageDigestAlgorithms.SHA_256);
                if (strD == null) {
                    strD = "";
                }
                if (hashSet.contains(strD)) {
                    return;
                } else {
                    hashSet.add(strD);
                }
            }
            if (!zO || zEquals) {
                return;
            }
            if (!this.f25688j) {
                a("", th);
            }
            if (this.f25687i.getAndSet(true) || !((Boolean) zzbic.f25123c.c()).booleanValue() || (sharedPreferences = (context = this.f25680b).getSharedPreferences("admob", 0)) == null) {
                return;
            }
            sharedPreferences.edit().putInt("crash_without_write", zzbfv.b(context, "crash_without_write") + 1).commit();
        }
    }

    public final void i() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return;
        }
        synchronized (this.f25679a) {
            this.f25681c.put(thread, Boolean.TRUE);
        }
        thread.setUncaughtExceptionHandler(new zzbxt(this, thread.getUncaughtExceptionHandler()));
    }
}
