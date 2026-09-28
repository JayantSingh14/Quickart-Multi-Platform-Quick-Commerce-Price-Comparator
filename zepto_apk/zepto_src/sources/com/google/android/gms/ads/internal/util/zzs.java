package com.google.android.gms.ads.internal.util;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.LocaleManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebSettings;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.activity.i;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.ScrollingView;
import androidx.fragment.app.e;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzcii;
import com.google.android.gms.internal.ads.zzcjy;
import com.google.android.gms.internal.ads.zzckt;
import com.google.android.gms.internal.ads.zzdud;
import com.google.android.gms.internal.ads.zzdxd;
import com.google.android.gms.internal.ads.zzdxe;
import com.google.android.gms.internal.ads.zzfhr;
import com.google.android.gms.internal.ads.zzfhu;
import com.google.android.gms.internal.ads.zzgpo;
import com.google.android.gms.internal.ads.zzgqp;
import com.google.android.gms.internal.ads.zzgym;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogSubCategory;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzs {

    /* renamed from: l, reason: collision with root package name */
    public static final zzf f21608l = new zzf(Looper.getMainLooper());

    /* renamed from: g, reason: collision with root package name */
    public String f21615g;

    /* renamed from: h, reason: collision with root package name */
    public volatile String f21616h;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f21609a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f21610b = new AtomicReference(null);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f21611c = new AtomicReference(new Bundle());

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f21612d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public boolean f21613e = true;

    /* renamed from: f, reason: collision with root package name */
    public final Object f21614f = new Object();

    /* renamed from: i, reason: collision with root package name */
    public boolean f21617i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21618j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ExecutorService f21619k = Executors.newSingleThreadExecutor();

    public static final String A(final Context context, String str) {
        String strR;
        String str2;
        if (str == null) {
            return R();
        }
        try {
            if (zzce.f21559b == null) {
                zzce.f21559b = new zzce();
            }
            zzce zzceVar = zzce.f21559b;
            if (TextUtils.isEmpty(zzceVar.f21560a)) {
                if (ClientLibraryUtils.isPackageSide()) {
                    str2 = (String) zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcc
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            Context context2 = context;
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                zze.k("User agent is already initialized on Google Play Services.");
                                return string;
                            }
                            zze.k("User agent is not initialized on Google Play Services. Initializing.");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context2);
                            SharedPreferencesUtils.publishWorldReadableSharedPreferences(context2, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
                            return defaultUserAgent;
                        }
                    });
                } else {
                    final Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                    str2 = (String) zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcd
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            SharedPreferences sharedPreferences;
                            boolean z = false;
                            Context context2 = remoteContext;
                            Context context3 = context;
                            if (context2 != null) {
                                zze.k("Attempting to read user agent from Google Play Services.");
                                sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            } else {
                                zze.k("Attempting to read user agent from local cache.");
                                sharedPreferences = context3.getSharedPreferences("admob_user_agent", 0);
                                z = true;
                            }
                            String string = sharedPreferences.getString("user_agent", "");
                            if (TextUtils.isEmpty(string)) {
                                zze.k("Reading user agent from WebSettings");
                                string = WebSettings.getDefaultUserAgent(context3);
                                if (z) {
                                    sharedPreferences.edit().putString("user_agent", string).apply();
                                    zze.k("Persisting user agent.");
                                }
                            }
                            return string;
                        }
                    });
                }
                zzceVar.f21560a = str2;
            }
            strR = zzceVar.f21560a;
        } catch (Exception unused) {
            strR = null;
        }
        if (TextUtils.isEmpty(strR)) {
            strR = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(strR)) {
            strR = R();
        }
        String strS = b.s(new StringBuilder(e.g(10, strR) + str.length()), strR, " (Mobile; ", str);
        try {
            if (Wrappers.packageManager(context).isCallerInstantApp()) {
                StringBuilder sb = new StringBuilder(strS.length() + 4);
                sb.append(strS);
                sb.append(";aia");
                strS = sb.toString();
            }
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.getUserAgent", e2);
        }
        return strS.concat(")");
    }

    public static ArrayList J() {
        zzbgb zzbgbVar = zzbgk.f25011a;
        ArrayList arrayListB = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.b();
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzgqp.a(zzgpo.b(',')).c((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    zze.k("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public static String K(String str, String str2) {
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ str2.charAt(i2 % str2.length()));
        }
        return new String(charArray);
    }

    public static zzq L(Context context) {
        zzq zzqVar = new zzq(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
        if (Build.VERSION.SDK_INT < 33) {
            Locale locale = context.getResources().getConfiguration().getLocales().get(0);
            return new zzq(locale.getLanguage(), locale.getCountry());
        }
        LocaleManager localeManagerB = i.b(context.getSystemService(i.k()));
        if (localeManagerB == null || localeManagerB.getSystemLocales().isEmpty()) {
            return zzqVar;
        }
        Locale locale2 = localeManagerB.getSystemLocales().get(0);
        return new zzq(locale2.getLanguage(), locale2.getCountry());
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean N(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L9
        L7:
            r2 = r0
            goto L13
        L9:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L7
            android.app.Activity r2 = (android.app.Activity) r2
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.N(android.view.View):boolean");
    }

    public static final void O(final Context context, final WebSettings webSettings) {
        zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzf zzfVar = zzs.f21608l;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings2 = webSettings;
                webSettings2.setDatabasePath(absolutePath);
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g1)).booleanValue()) {
                    webSettings2.setTextZoom(100);
                }
                webSettings2.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static final void P(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final String Q(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return x(y(context));
    }

    public static final String R() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(StringUtils.SPACE);
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String S() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : b.s(new StringBuilder(e.g(1, str) + str2.length()), str, StringUtils.SPACE, str2);
    }

    public static final HashMap T(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (strOptString != null) {
                            hashSet.add(strOptString);
                        }
                    }
                    map.put(next, hashSet);
                }
            }
            return map;
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.getMapOfFileNamesToKeysFromJsonString", e2);
            return map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long a(View view) {
        float fMin = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            fMin = Math.min(fMin, view2.getAlpha());
            view = view2.getParent();
        } while (fMin > 0.0f);
        return Math.round((fMin >= 0.0f ? fMin : 0.0f) * 100.0f);
    }

    public static final int b(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollView) {
                return 1;
            }
            if (parent instanceof AbsListView) {
                return 2;
            }
            if (parent instanceof HorizontalScrollView) {
                return 3;
            }
            if (parent instanceof ScrollingView) {
                return 4;
            }
        }
        return 0;
    }

    public static final zzbo c(Context context) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(null).newInstance(null);
            if (!(objNewInstance instanceof IBinder)) {
                int i2 = zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) objNewInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return iInterfaceQueryLocalInterface instanceof zzbo ? (zzbo) iInterfaceQueryLocalInterface : new zzbm(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("Failed to instantiate WorkManagerUtil", e2);
            return null;
        }
    }

    public static final boolean d(Context context, String str) {
        Context contextA = zzbzk.a(context);
        return Wrappers.packageManager(contextA).checkPermission(str, contextA.getPackageName()) == 0;
    }

    public static final boolean e(String str) {
        if (!com.google.android.gms.ads.internal.util.client.zzl.e()) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.R5;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzbdVar.f21153c.a(zzbgk.T5);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S5);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error loading class.", th);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.isLiteSdk", th);
            return false;
        }
    }

    public static final boolean g(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                        return !powerManager.isScreenOn();
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean h(Context context) {
        try {
            Bundle bundleY = y(context);
            String string = bundleY.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (TextUtils.isEmpty(x(bundleY))) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    public static final boolean i(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final void j(int i2, View view) {
        String str;
        int i3;
        int iHeight;
        int iWidth;
        String str2;
        String str3;
        String strA;
        zzfhr zzfhrVarV;
        zzfhu zzfhuVarE;
        View childAt = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = childAt.getContext().getPackageName();
            if (childAt instanceof zzdud) {
                childAt = ((zzdud) childAt).getChildAt(0);
            }
            if ((childAt instanceof com.google.android.gms.ads.formats.zzh) || (childAt instanceof NativeAdView)) {
                str = "NATIVE";
                i3 = 1;
            } else {
                str = "UNKNOWN";
                i3 = 0;
            }
            if (childAt.getLocalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            long jA = a(childAt);
            childAt.getLocationOnScreen(iArr);
            int i4 = iArr[0];
            int i5 = iArr[1];
            String str4 = "none";
            if (!(childAt instanceof zzcjy) || (zzfhuVarE = ((zzcjy) childAt).e()) == null) {
                str2 = str;
                str3 = "none";
            } else {
                str3 = zzfhuVarE.f31167b;
                int iHashCode = childAt.hashCode();
                str2 = str;
                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(iHashCode).length());
                sb.append(str3);
                sb.append(":");
                sb.append(iHashCode);
                childAt.setContentDescription(sb.toString());
            }
            if (!(childAt instanceof zzcii) || (zzfhrVarV = ((zzcii) childAt).v()) == null) {
                strA = str2;
            } else {
                strA = zzfhr.a(zzfhrVarV.f31150b);
                i3 = zzfhrVarV.f31153e;
                str4 = zzfhrVarV.E;
            }
            Locale locale = Locale.US;
            String str5 = "<Ad hashCode=" + childAt.hashCode() + ", package=" + packageName + ", adNetCls=" + str4 + ", gwsQueryId=" + str3 + ", format=" + strA + ", impType=" + i3 + ", class=" + childAt.getClass().getName() + ", x=" + i4 + ", y=" + i5 + ", width=" + childAt.getWidth() + ", height=" + childAt.getHeight() + ", vWidth=" + iWidth + ", vHeight=" + iHeight + ", alpha=" + jA + ", state=" + Integer.toString(i2, 2) + ">";
            int i6 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e(str5);
        } catch (Exception e2) {
            int i7 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Failure getting view location.", e2);
        }
    }

    public static final AlertDialog.Builder k(Context context) {
        zzu zzuVar = com.google.android.gms.ads.internal.zzt.C.f21682f;
        return new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
    }

    public static final void l(Context context, zzfhr zzfhrVar, zzdxe zzdxeVar) {
        zzdxd zzdxdVarA = zzdxeVar.a();
        zzdxdVarA.b("action", "can_show");
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zzs zzsVar = zztVar.f21679c;
        zzdxdVarA.b("foreground", true != g(context) ? "1" : "0");
        zzdxdVarA.b("fg_al", true == zztVar.f21683g.e() ? "1" : "0");
        if (zzfhrVar != null) {
            List list = zzfhrVar.t;
            if (!list.isEmpty()) {
                zzdxdVarA.b("ancn", (String) list.get(0));
            }
            zzdxdVarA.b("ad_format", zzfhr.a(zzfhrVar.f31150b));
        }
        zzdxdVarA.c();
    }

    public static final boolean m(zzfhr zzfhrVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ge)).booleanValue() && zzfhrVar != null && zzfhrVar.f31153e == 4;
    }

    public static final int n(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            String strConcat = "Could not parse value:".concat(e2.toString());
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
            return 0;
        }
    }

    public static final HashMap o(Uri uri) {
        String encodedQuery;
        if (uri == null) {
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t)).booleanValue()) {
            HashMap map = new HashMap();
            for (String str : uri.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    map.put(str, uri.getQueryParameter(str));
                }
            }
            return map;
        }
        HashMap map2 = new HashMap();
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            int i2 = 0;
            while (true) {
                int iIndexOf = encodedQuery.indexOf(38, i2);
                int length = encodedQuery.length();
                if (iIndexOf != -1) {
                    length = iIndexOf;
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i2);
                if (iIndexOf2 > length || iIndexOf2 == -1) {
                    iIndexOf2 = length;
                }
                map2.put(Uri.decode(encodedQuery.substring(i2, iIndexOf2)), iIndexOf2 == length ? "" : Uri.decode(encodedQuery.substring(iIndexOf2 + 1, length)));
                if (iIndexOf == -1) {
                    break;
                }
                i2 = iIndexOf + 1;
            }
        }
        return map2;
    }

    public static final int[] p(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static final int[] q(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArr = (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
        return new int[]{zzbbVar.f21142a.i(iArr[0], activity), zzbbVar.f21142a.i(iArr[1], activity)};
    }

    public static final boolean r(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = com.google.android.gms.ads.internal.zzt.C.f21679c.f21613e || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || N(view);
        long jA = a(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z)) {
            zzbgb zzbgbVar = zzbgk.H1;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                zzbgb zzbgbVar2 = zzbgk.Jb;
                if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar2)).booleanValue() || jA >= ((Integer) r6.a(zzbgk.Lb)).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int s(int i2) {
        if (i2 >= 5000) {
            return i2;
        }
        if (i2 <= 0) {
            return 60000;
        }
        String strU = e.u(new StringBuilder(String.valueOf(i2).length() + 86), "HTTP timeout too low: ", i2, " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        int i3 = zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strU);
        return 60000;
    }

    public static final void t(Context context, Intent intent) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.gc)).booleanValue()) {
            try {
                context.startActivity(intent);
                return;
            } catch (Throwable unused) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
        }
        try {
            try {
                context.startActivity(intent);
            } catch (Throwable unused2) {
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } catch (SecurityException e2) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.startActivityWithUnknownContext", e2);
        }
    }

    public static final void u(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            P(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 26);
            sb.append("Opening ");
            sb.append(string);
            sb.append(" in a new browser.");
            String string2 = sb.toString();
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string2);
        } catch (ActivityNotFoundException e2) {
            int i3 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("No browser is found.", e2);
        }
    }

    public static final void v(Context context, Intent intent, zzdxe zzdxeVar, String str) {
        zzbgb zzbgbVar = zzbgk.le;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        zzbgi zzbgiVar2 = zzbdVar.f21153c;
        if (!((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue() || !(context instanceof zzckt)) {
            t(context, intent);
            return;
        }
        try {
            Uri data = intent.getData();
            if (data == null || data.toString() == null || !data.toString().matches((String) zzbgiVar2.a(zzbgk.ne))) {
                t(context, intent);
                return;
            }
            ((zzckt) context).a(intent);
            if (!((Boolean) zzbgiVar2.a(zzbgk.me)).booleanValue() || zzdxeVar == null) {
                return;
            }
            zzdxd zzdxdVarA = zzdxeVar.a();
            zzdxdVarA.b("action", "hila");
            if (str == null) {
                str = "";
            }
            zzdxdVarA.b("gqi", str);
            zzdxdVarA.e();
        } catch (ActivityNotFoundException e2) {
            e = e2;
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.startActivityForResult", e);
            t(context, intent);
        } catch (SecurityException e3) {
            e = e3;
            int i22 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.startActivityForResult", e);
            t(context, intent);
        } catch (Exception e4) {
            int i3 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e4);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.startActivityForResult", e4);
            t(context, intent);
        }
    }

    public static boolean w(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = (Pattern) atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String x(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return !TextUtils.isEmpty(string) ? (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "" : "";
    }

    public static Bundle y(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            zze.l("Error getting metadata", e2);
            return null;
        }
    }

    public static final void z(CustomTabsIntent.Builder builder, Bundle bundle) {
        if (bundle.isEmpty()) {
            return;
        }
        int i2 = bundle.getInt("h", -1);
        Intent intent = builder.f1343a;
        if (i2 >= 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Invalid value for the initialHeightPx argument");
            }
            intent.putExtra("androidx.browser.customtabs.extra.INITIAL_ACTIVITY_HEIGHT_PX", i2);
            intent.putExtra("androidx.browser.customtabs.extra.ACTIVITY_HEIGHT_RESIZE_BEHAVIOR", 0);
        }
        int i3 = bundle.getInt("cbp", -1);
        if (i3 < 0 || i3 > 2) {
            return;
        }
        if (i3 < 0 || i3 > 2) {
            throw new IllegalArgumentException("Invalid value for the position argument");
        }
        intent.putExtra("androidx.browser.customtabs.extra.CLOSE_BUTTON_POSITION", i3);
    }

    public final void B(Context context, String str, HttpURLConnection httpURLConnection, int i2) {
        int iS = s(i2);
        String strU = e.u(new StringBuilder(String.valueOf(iS).length() + 28), "HTTP timeout: ", iS, " milliseconds.");
        int i3 = zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e(strU);
        httpURLConnection.setConnectTimeout(iS);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(iS);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", E(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final void C(Context context) {
        if (this.f21617i) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbgk.a(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fc)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzr(this), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzr(this), intentFilter, 4);
        }
        this.f21617i = true;
    }

    public final void D(Context context) {
        if (this.f21618j) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbgk.a(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fc)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzp(), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzp(), intentFilter, 4);
        }
        this.f21618j = true;
    }

    public final String E(Context context, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.sc)).booleanValue()) {
            if (this.f21616h != null) {
                return this.f21616h;
            }
            this.f21616h = A(context, str);
            return this.f21616h;
        }
        synchronized (this.f21614f) {
            try {
                String str2 = this.f21615g;
                if (str2 != null) {
                    return str2;
                }
                String strA = A(context, str);
                this.f21615g = strA;
                return strA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ListenableFuture F(final Uri uri) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.ads.internal.util.zzo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzf zzfVar = zzs.f21608l;
                zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                return zzs.o(uri);
            }
        }, this.f21619k);
    }

    public final void G(final Context context, final String str, Bundle bundle) {
        Bundle bundleB;
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        bundle.putString(LogSubCategory.Context.DEVICE, S());
        zzbgb zzbgbVar = zzbgk.f25011a;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        bundle.putString("eids", TextUtils.join(",", zzbdVar.f21151a.a()));
        if (bundle.isEmpty()) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty or null bundle.");
        } else {
            final String str2 = (String) zzbdVar.f21153c.a(zzbgk.Hb);
            boolean andSet = this.f21612d.getAndSet(true);
            AtomicReference atomicReference = this.f21611c;
            if (!andSet) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.ads.internal.util.zzm
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str3) {
                        this.f21599a.f21611c.set(zzac.b(context, str2));
                    }
                };
                if (TextUtils.isEmpty(str2)) {
                    bundleB = Bundle.EMPTY;
                } else {
                    PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    bundleB = zzac.b(context, str2);
                }
                atomicReference.set(bundleB);
            }
            bundle.putAll((Bundle) atomicReference.get());
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        com.google.android.gms.ads.internal.util.client.zzf.a(context, str, bundle, new com.google.android.gms.ads.internal.util.client.zze() { // from class: com.google.android.gms.ads.internal.util.zzl
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final com.google.android.gms.ads.internal.util.client.zzt a(String str3) {
                zzf zzfVar2 = zzs.f21608l;
                zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                new zzbt(context, str, str3, null).b();
                return com.google.android.gms.ads.internal.util.client.zzt.f21443a;
            }
        });
    }

    public final boolean H(String str) {
        return w(str, this.f21609a, (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B0));
    }

    public final boolean I(String str) {
        return w(str, this.f21610b, (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (com.google.android.gms.ads.internal.util.client.zzf.r() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M(android.content.Context r12, android.net.Uri r13, android.os.Bundle r14) {
        /*
            r11 = this;
            if (r12 != 0) goto L9
            java.lang.String r12 = "Trying to open chrome custom tab on a null context"
            com.google.android.gms.ads.internal.util.zze.k(r12)
            r12 = 3
            return r12
        L9:
            boolean r0 = r12 instanceof android.app.Activity
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            java.lang.String r2 = "android.intent.action.VIEW"
            if (r0 != 0) goto L21
            android.content.Intent r14 = new android.content.Intent
            r14.<init>(r2)
            r14.setData(r13)
            r14.addFlags(r1)
            r12.startActivity(r14)
            r12 = 2
            return r12
        L21:
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.o5
            com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r4 = r3.f21153c
            java.lang.Object r0 = r4.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
            r4 = 5
            if (r0 == 0) goto L70
            androidx.browser.customtabs.CustomTabsIntent$Builder r0 = new androidx.browser.customtabs.CustomTabsIntent$Builder
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.internal.ads.zzbhj r1 = r1.n
            androidx.browser.customtabs.CustomTabsSession r1 = r1.b()
            r0.<init>(r1)
            z(r0, r14)
            androidx.browser.customtabs.CustomTabsIntent r14 = r0.a()
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.B5
            java.lang.Object r0 = r3.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L63
            com.google.android.gms.ads.internal.client.zzbb r0 = com.google.android.gms.ads.internal.client.zzbb.f21141g
            com.google.android.gms.ads.internal.util.client.zzf r0 = r0.f21142a
            boolean r0 = com.google.android.gms.ads.internal.util.client.zzf.r()
            if (r0 == 0) goto L63
            goto Lbe
        L63:
            android.content.Intent r0 = r14.f1341a
            java.lang.String r1 = com.google.android.gms.internal.ads.zzijw.a(r12)
            r0.setPackage(r1)
            r14.a(r12, r13)
            return r4
        L70:
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.m5
            java.lang.Object r0 = r3.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lbf
            com.google.android.gms.internal.ads.zzbhl r7 = new com.google.android.gms.internal.ads.zzbhl
            r7.<init>()
            com.google.android.gms.ads.internal.util.zzk r5 = new com.google.android.gms.ads.internal.util.zzk
            r6 = r11
            r9 = r12
            r10 = r13
            r8 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            r7.f25066d = r5
            r12 = r9
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.browser.customtabs.CustomTabsClient r13 = r7.f25064b
            if (r13 == 0) goto L96
            goto Lbe
        L96:
            java.lang.String r13 = com.google.android.gms.internal.ads.zzijw.a(r12)
            if (r13 == 0) goto Lbe
            com.google.android.gms.internal.ads.zzijx r14 = new com.google.android.gms.internal.ads.zzijx
            r14.<init>(r7)
            r7.f25065c = r14
            android.content.Context r0 = r12.getApplicationContext()
            r14.f1351a = r0
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.support.customtabs.action.CustomTabsService"
            r0.<init>(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto Lb9
            r0.setPackage(r13)
        Lb9:
            r13 = 33
            r12.bindService(r0, r14, r13)
        Lbe:
            return r4
        Lbf:
            r9 = r12
            r10 = r13
            android.content.Intent r12 = new android.content.Intent
            r12.<init>(r2)
            r12.setData(r10)
            r12.addFlags(r1)
            r9.startActivity(r12)
            r12 = 9
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.M(android.content.Context, android.net.Uri, android.os.Bundle):int");
    }
}
