package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzgmr implements zzglz {

    /* renamed from: a, reason: collision with root package name */
    public long f32928a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f32929b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f32930c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f32931d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f32932e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f32933f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f32934g = -1;

    /* renamed from: h, reason: collision with root package name */
    public long f32935h = -1;

    /* renamed from: i, reason: collision with root package name */
    public final long f32936i = SystemClock.uptimeMillis();

    public static boolean d(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (view.getClass().getName().contains("DebugGestureViewWrapper")) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            Object objInvoke = view.getClass().getMethod("getAdConfiguration", null).invoke(view, null);
            Integer num = (Integer) objInvoke.getClass().getField("adType").get(objInvoke);
            num.intValue();
            String str = (String) objInvoke.getClass().getMethod("adTypeToString", Integer.TYPE).invoke(null, num);
            if (str.contains("INTERSTITIAL") || str.contains("APP_OPEN")) {
                return true;
            }
            return str.contains("REWARDED");
        } catch (NullPointerException | ReflectiveOperationException | SecurityException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final synchronized void a(HashMap map, Context context, View view) {
        WindowManager windowManager;
        try {
            this.f32931d = this.f32930c;
            this.f32930c = SystemClock.uptimeMillis();
            long j2 = this.f32932e;
            if (j2 != -1) {
                this.f32933f = j2;
            }
            DisplayMetrics displayMetrics = null;
            if ((Build.VERSION.SDK_INT < 33 || context.isUiContext()) && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                displayMetrics = new DisplayMetrics();
                try {
                    defaultDisplay.getRealMetrics(displayMetrics);
                } catch (NoSuchMethodError unused) {
                    defaultDisplay.getMetrics(displayMetrics);
                }
            }
            if (displayMetrics != null) {
                int i2 = displayMetrics.widthPixels * displayMetrics.heightPixels;
                if (view != null) {
                    int iMin = Math.min(view.getWidth(), displayMetrics.widthPixels) * Math.min(view.getHeight(), displayMetrics.heightPixels);
                    if (iMin + iMin >= i2 || (iMin == 0 && d(view))) {
                        this.f32932e = this.f32930c;
                    }
                }
                e(map);
            }
            this.f32932e = -1L;
            e(map);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final synchronized void b(HashMap map) {
        this.f32935h = this.f32934g;
        this.f32934g = SystemClock.uptimeMillis();
        e(map);
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final synchronized void c(HashMap map) {
        this.f32929b = this.f32928a;
        this.f32928a = SystemClock.uptimeMillis();
        e(map);
    }

    public final void e(HashMap map) {
        map.put("tcq", Long.valueOf(this.f32928a));
        map.put("tpq", Long.valueOf(this.f32929b));
        map.put("tcc", Long.valueOf(this.f32934g));
        map.put("tpc", Long.valueOf(this.f32935h));
        map.put("tpv", Long.valueOf(this.f32931d));
        map.put("tcv", Long.valueOf(this.f32930c));
        map.put("tchv", Long.valueOf(this.f32932e));
        map.put("tphv", Long.valueOf(this.f32933f));
        map.put("tst", Long.valueOf(this.f32936i));
    }
}
