package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.d;
import com.google.firebase.crashlytics.internal.common.f;
import com.google.firebase.crashlytics.internal.common.g;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class FirebaseCrashlytics {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsCore f43696a;

    public FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.f43696a = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.d().b(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f43696a.a();
    }

    public void deleteUnsentReports() {
        this.f43696a.b();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f43696a.f43783g;
    }

    public boolean isCrashlyticsCollectionEnabled() {
        return this.f43696a.f43778b.b();
    }

    public void log(@NonNull String str) {
        CrashlyticsCore crashlyticsCore = this.f43696a;
        crashlyticsCore.p.f43874a.a(new g(crashlyticsCore, System.currentTimeMillis() - crashlyticsCore.f43780d, str));
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger.f43705a.f("A null value was passed to recordException. Ignoring.", null);
            return;
        }
        CrashlyticsCore crashlyticsCore = this.f43696a;
        crashlyticsCore.p.f43874a.a(new f(crashlyticsCore, th, Collections.EMPTY_MAP));
    }

    public void sendUnsentReports() {
        this.f43696a.g();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.f43696a.h(Boolean.valueOf(z));
    }

    public void setCustomKey(@NonNull String str, boolean z) {
        this.f43696a.i(str, Boolean.toString(z));
    }

    public void setCustomKeys(@NonNull CustomKeysAndValues customKeysAndValues) {
        customKeysAndValues.getClass();
        this.f43696a.getClass();
        throw null;
    }

    public void setUserId(@NonNull String str) {
        CrashlyticsCore crashlyticsCore = this.f43696a;
        crashlyticsCore.p.f43874a.a(new d(crashlyticsCore, str, 0));
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f43696a.h(bool);
    }

    public void setCustomKey(@NonNull String str, double d2) {
        this.f43696a.i(str, Double.toString(d2));
    }

    public void setCustomKey(@NonNull String str, float f2) {
        this.f43696a.i(str, Float.toString(f2));
    }

    public void setCustomKey(@NonNull String str, int i2) {
        this.f43696a.i(str, Integer.toString(i2));
    }

    public void setCustomKey(@NonNull String str, long j2) {
        this.f43696a.i(str, Long.toString(j2));
    }

    public void recordException(@NonNull Throwable th, @NonNull CustomKeysAndValues customKeysAndValues) {
        Map map = null;
        if (th == null) {
            Logger.f43705a.f("A null value was passed to recordException. Ignoring.", null);
            return;
        }
        customKeysAndValues.getClass();
        CrashlyticsCore crashlyticsCore = this.f43696a;
        crashlyticsCore.p.f43874a.a(new f(crashlyticsCore, th, map));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.f43696a.i(str, str2);
    }
}
