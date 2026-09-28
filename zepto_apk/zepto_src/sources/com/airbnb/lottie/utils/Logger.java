package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.network.NetworkFetcher;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final LogcatLogger f14793a = new LogcatLogger();

    public static void a() {
        f14793a.getClass();
        NetworkFetcher networkFetcher = L.f14106a;
    }

    public static void b(String str) {
        f14793a.getClass();
        HashSet hashSet = LogcatLogger.f14792a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        hashSet.add(str);
    }

    public static void c(String str, Throwable th) {
        f14793a.getClass();
        HashSet hashSet = LogcatLogger.f14792a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        hashSet.add(str);
    }
}
