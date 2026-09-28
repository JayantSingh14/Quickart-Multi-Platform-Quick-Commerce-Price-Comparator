package com.google.android.gms.ads.internal.util.client;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzftz;
import com.google.android.gms.internal.ads.zzfxl;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzf {

    /* renamed from: b, reason: collision with root package name */
    public static final zzfxl f21413b = new zzfxl(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public static final String f21414c = AdView.class.getName();

    /* renamed from: d, reason: collision with root package name */
    public static final String f21415d = InterstitialAd.class.getName();

    /* renamed from: e, reason: collision with root package name */
    public static final String f21416e = AdManagerAdView.class.getName();

    /* renamed from: f, reason: collision with root package name */
    public static final String f21417f = AdManagerInterstitialAd.class.getName();

    /* renamed from: g, reason: collision with root package name */
    public static final String f21418g = zzftz.class.getName();

    /* renamed from: h, reason: collision with root package name */
    public static final String f21419h = AdLoader.class.getName();

    /* renamed from: a, reason: collision with root package name */
    public float f21420a = -1.0f;

    public static final void a(Context context, String str, Bundle bundle, zze zzeVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString(AppsFlyerProperties.APP_ID, applicationContext.getPackageName());
        if (str == null) {
            int apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
            str = b.o(new StringBuilder(String.valueOf(apkVersion).length() + 10), apkVersion, ".254380000");
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(CLConstants.SHARED_PREFERENCE_ITEM_ID, "gmob-apps");
        for (String str2 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str2, bundle.getString(str2));
        }
        zzeVar.a(builderAppendQueryParameter.toString());
    }

    public static final int b(int i2, Context context) {
        return q(context.getResources().getDisplayMetrics(), i2);
    }

    public static final String c(Context context) {
        zzbgk.a(context);
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || r()) {
            string = "emulator";
        }
        return d(string, MessageDigestAlgorithms.MD5);
    }

    public static String d(String str, String str2) throws NoSuchAlgorithmException {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    public static final void h(BaseAdView baseAdView, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i2, int i3) {
        if (baseAdView.getChildCount() != 0) {
            return;
        }
        Context context = baseAdView.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i2);
        textView.setBackgroundColor(i3);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i2);
        int iB = b(3, context);
        int i4 = zzrVar.f21286f;
        int i5 = zzrVar.f21283c;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(i4 - iB, i5 - iB, 17));
        baseAdView.addView(frameLayout, i4, i5);
    }

    public static ActivityManager.MemoryInfo j(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (NullPointerException unused) {
            zzo.f("Error retrieving the memory information.");
            return memoryInfo;
        }
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith((String) zzbit.f25216d.c());
    }

    public static PreloadConfiguration p(zzft zzftVar) {
        String str = zzftVar.f21239a;
        if (AdFormat.a(zzftVar.f21240b) == null) {
            return null;
        }
        AdRequest.Builder builder = new AdRequest.Builder();
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzftVar.f21241c;
        List list = zzmVar.f21258e;
        zzej zzejVar = builder.f20979a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzejVar.f21167a.add((String) it.next());
            }
        }
        zzejVar.f21168b.putAll(zzmVar.f21266m);
        Bundle bundle = zzmVar.n;
        for (String str2 : bundle.keySet()) {
            builder.a(str2, bundle.getString(str2));
        }
        builder.e(zzmVar.x);
        String str3 = zzmVar.f21265l;
        if (str3 != null) {
            builder.f(str3);
        }
        builder.g(zzmVar.v);
        zzejVar.f21176j = zzmVar.p;
        new AdRequest(builder);
        new AdRequest(new AdRequest.Builder());
        return new PreloadConfiguration();
    }

    public static final int q(DisplayMetrics displayMetrics, int i2) {
        return (int) TypedValue.applyDimension(1, i2, displayMetrics);
    }

    public static final boolean r() {
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ac)).booleanValue();
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator")) {
            return true;
        }
        return zBooleanValue && Build.HARDWARE.contains("ranchu");
    }

    public final JSONArray e(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            f(jSONArray, it.next());
        }
        return jSONArray;
    }

    public final void f(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(l((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(e((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(n((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    public final void g(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Boolean[] boolArr;
        Long[] lArr;
        Double[] dArr;
        Integer[] numArr;
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.s)).booleanValue()) {
            str = String.valueOf(str);
        }
        if (obj instanceof Bundle) {
            jSONObject.put(str, m((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, l((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONObject.put(String.valueOf(str), e((Collection) obj));
            return;
        }
        if (obj instanceof Object[]) {
            jSONObject.put(str, e(Arrays.asList((Object[]) obj)));
            return;
        }
        int i2 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr == null) {
                numArr = new Integer[0];
            } else {
                int length = iArr.length;
                Integer[] numArr2 = new Integer[length];
                while (i2 < length) {
                    numArr2[i2] = Integer.valueOf(iArr[i2]);
                    i2++;
                }
                numArr = numArr2;
            }
            jSONObject.put(str, n(numArr));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr2 = (double[]) obj;
            if (dArr2 == null) {
                dArr = new Double[0];
            } else {
                int length2 = dArr2.length;
                Double[] dArr3 = new Double[length2];
                while (i2 < length2) {
                    dArr3[i2] = Double.valueOf(dArr2[i2]);
                    i2++;
                }
                dArr = dArr3;
            }
            jSONObject.put(str, n(dArr));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            if (jArr == null) {
                lArr = new Long[0];
            } else {
                int length3 = jArr.length;
                Long[] lArr2 = new Long[length3];
                while (i2 < length3) {
                    lArr2[i2] = Long.valueOf(jArr[i2]);
                    i2++;
                }
                lArr = lArr2;
            }
            jSONObject.put(str, n(lArr));
            return;
        }
        if (!(obj instanceof boolean[])) {
            jSONObject.put(str, obj);
            return;
        }
        boolean[] zArr = (boolean[]) obj;
        if (zArr == null) {
            boolArr = new Boolean[0];
        } else {
            int length4 = zArr.length;
            Boolean[] boolArr2 = new Boolean[length4];
            while (i2 < length4) {
                boolArr2[i2] = Boolean.valueOf(zArr[i2]);
                i2++;
            }
            boolArr = boolArr2;
        }
        jSONObject.put(str, n(boolArr));
    }

    public final int i(int i2, Context context) {
        if (this.f21420a < 0.0f) {
            synchronized (this) {
                try {
                    if (this.f21420a < 0.0f) {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        if (windowManager == null) {
                            return 0;
                        }
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        this.f21420a = displayMetrics.density;
                    }
                } finally {
                }
            }
        }
        return Math.round(i2 / this.f21420a);
    }

    public final void k(final Context context, String str, Bundle bundle) {
        a(context, str, bundle, new zze() { // from class: com.google.android.gms.ads.internal.util.client.zzd
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final /* synthetic */ zzt a(String str2) {
                new zzc(this.f21411a, context, str2).start();
                return zzt.f21443a;
            }
        });
    }

    public final JSONObject l(Map map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                g(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf(e2.getMessage())));
        }
    }

    public final JSONObject m(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            g(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final JSONArray n(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            f(jSONArray, obj);
        }
        return jSONArray;
    }
}
