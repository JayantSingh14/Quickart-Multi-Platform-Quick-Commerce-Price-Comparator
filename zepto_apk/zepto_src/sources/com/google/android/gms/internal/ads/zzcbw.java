package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcbw {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f25863a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final Object f25864b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public String f25865c = null;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f25866d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f25867e = new AtomicInteger(-1);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f25868f = new AtomicReference(null);

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f25869g = new AtomicReference(null);

    /* renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f25870h = new ConcurrentHashMap(9);

    /* renamed from: i, reason: collision with root package name */
    public final Object f25871i = new Object();

    public static final Bundle f(Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String str : map.keySet()) {
                try {
                    if (Objects.equals(str, CLConstants.FIELD_PAY_INFO_VALUE)) {
                        bundle.putDouble(str, Double.parseDouble((String) map.get(str)));
                    } else {
                        bundle.putString(str, (String) map.get(str));
                    }
                } catch (NullPointerException | NumberFormatException unused) {
                }
            }
        }
        return bundle;
    }

    public static final boolean g(Context context) throws ClassNotFoundException {
        zzbgb zzbgbVar = zzbgk.I0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzbdVar.f21153c.a(zzbgk.J0)).intValue()) {
            return false;
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.K0)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    public final boolean a(Context context) {
        int iIsGooglePlayServicesAvailable;
        zzbgb zzbgbVar = zzbgk.A0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !this.f25866d.get()) {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.L0)).booleanValue()) {
                AtomicInteger atomicInteger = this.f25867e;
                if (atomicInteger.get() == -1) {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
                    if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000) != 0 && ((iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000)) == 0 || iIsGooglePlayServicesAvailable == 2)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        atomicInteger.set(0);
                    } else {
                        atomicInteger.set(1);
                    }
                }
                if (atomicInteger.get() == 1) {
                }
            }
            return true;
        }
        return false;
    }

    public final String b(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.f25864b) {
            try {
                String str = this.f25865c;
                if (str != null) {
                    return str;
                }
                String str2 = (String) k(context, "getGmpAppId");
                this.f25865c = str2;
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String c(final Context context) {
        ExecutorService threadPoolExecutor;
        if (a(context)) {
            zzbgb zzbgbVar = zzbgk.G0;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            long jLongValue = ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue();
            if (jLongValue < 0) {
                return (String) k(context, "getAppInstanceId");
            }
            AtomicReference atomicReference = this.f25863a;
            if (atomicReference.get() == null) {
                if (ClientLibraryUtils.isPackageSide()) {
                    zzfxi zzfxiVar = zzfxk.f31990b;
                    zzfxj zzfxjVar = (zzfxj) zzfxiVar;
                    threadPoolExecutor = zzfxjVar.a(((Integer) zzbdVar.f21153c.a(zzbgk.H0)).intValue(), new zzcbu(this));
                } else {
                    zzbgb zzbgbVar2 = zzbgk.H0;
                    threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzbdVar.f21153c.a(zzbgbVar2)).intValue(), ((Integer) zzbdVar.f21153c.a(zzbgbVar2)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzcbu(this));
                }
                while (!atomicReference.compareAndSet(null, threadPoolExecutor) && atomicReference.get() == null) {
                }
            }
            try {
                return (String) ((ExecutorService) atomicReference.get()).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzcbv
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return (String) this.k(context, "getAppInstanceId");
                    }
                }).get(jLongValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    public final String d(Context context) {
        Object objK;
        if (a(context) && (objK = k(context, "generateEventId")) != null) {
            return objK.toString();
        }
        return null;
    }

    public final void e(Context context, String str, String str2, String str3, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i2);
            h(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 64 + String.valueOf(i2).length());
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i2);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
    }

    public final void h(Context context, String str, String str2, Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e2) {
                String strValueOf = String.valueOf(str2);
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Invalid event ID: ".concat(strValueOf), e2);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            AtomicReference atomicReference = this.f25868f;
            if (m(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
                ConcurrentHashMap concurrentHashMap = this.f25870h;
                Method declaredMethod = (Method) concurrentHashMap.get("logEventInternal");
                if (declaredMethod == null) {
                    try {
                        declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
                        concurrentHashMap.put("logEventInternal", declaredMethod);
                    } catch (Exception unused) {
                        l("logEventInternal", true);
                        declaredMethod = null;
                    }
                }
                try {
                    declaredMethod.invoke(atomicReference.get(), "am", str, bundle2);
                } catch (Exception unused2) {
                    l("logEventInternal", true);
                }
            }
        }
    }

    public final Method i(Context context, String str) throws NoSuchMethodException, SecurityException {
        ConcurrentHashMap concurrentHashMap = this.f25870h;
        Method method = (Method) concurrentHashMap.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, null);
            concurrentHashMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            l(str, false);
            return null;
        }
    }

    public final void j(Context context, String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AtomicReference atomicReference = this.f25868f;
        if (m(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
            ConcurrentHashMap concurrentHashMap = this.f25870h;
            Method declaredMethod = (Method) concurrentHashMap.get(str2);
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, String.class);
                    concurrentHashMap.put(str2, declaredMethod);
                } catch (Exception unused) {
                    l(str2, false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(atomicReference.get(), str);
                StringBuilder sb = new StringBuilder(str2.length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            } catch (Exception unused2) {
                l(str2, false);
            }
        }
    }

    public final Object k(Context context, String str) throws NoSuchMethodException, SecurityException {
        AtomicReference atomicReference = this.f25868f;
        if (!m(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
            return null;
        }
        try {
            return i(context, str).invoke(atomicReference.get(), null);
        } catch (Exception unused) {
            l(str, true);
            return null;
        }
    }

    public final void l(String str, boolean z) {
        AtomicBoolean atomicBoolean = this.f25866d;
        if (atomicBoolean.get()) {
            return;
        }
        String strS = android.support.v4.media.b.s(new StringBuilder(str.length() + 30), "Invoke Firebase method ", str, " error.");
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strS);
        if (z) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            atomicBoolean.set(true);
        }
    }

    public final boolean m(Context context, String str, AtomicReference atomicReference, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (atomicReference.get() != null) {
            return true;
        }
        try {
            Object objInvoke = context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context);
            while (!atomicReference.compareAndSet(null, objInvoke) && atomicReference.get() == null) {
            }
            return true;
        } catch (Exception unused) {
            l("getInstance", z);
            return false;
        }
    }
}
