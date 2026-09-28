package com.google.firebase.crashlytics.internal;

import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f43705a = new Logger();

    public final boolean a(int i2) {
        return 4 <= i2 || Log.isLoggable("FirebaseCrashlytics", i2);
    }

    public final void b(String str, IOException iOException) {
        if (a(3)) {
            Log.d("FirebaseCrashlytics", str, iOException);
        }
    }

    public final void c(String str, Exception exc) {
        if (a(6)) {
            Log.e("FirebaseCrashlytics", str, exc);
        }
    }

    public final void d(String str) {
        if (a(4)) {
            Log.i("FirebaseCrashlytics", str, null);
        }
    }

    public final void e(String str) {
        if (a(2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
    }

    public final void f(String str, Exception exc) {
        if (a(5)) {
            Log.w("FirebaseCrashlytics", str, exc);
        }
    }
}
