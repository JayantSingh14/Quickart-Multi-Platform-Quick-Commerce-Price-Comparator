package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class DataCollectionArbiter {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f43804a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseApp f43805b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f43806c;

    /* renamed from: d, reason: collision with root package name */
    public TaskCompletionSource f43807d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f43808e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f43809f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f43810g;

    /* renamed from: h, reason: collision with root package name */
    public final TaskCompletionSource f43811h;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Boolean boolValueOf;
        Object obj = new Object();
        this.f43806c = obj;
        this.f43807d = new TaskCompletionSource();
        this.f43808e = false;
        this.f43809f = false;
        this.f43811h = new TaskCompletionSource();
        firebaseApp.a();
        Context context = firebaseApp.f43489a;
        this.f43805b = firebaseApp;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        this.f43804a = sharedPreferences;
        if (sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.f43809f = false;
            boolValueOf = Boolean.valueOf(sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        this.f43810g = boolValueOf == null ? a(context) : boolValueOf;
        synchronized (obj) {
            try {
                if (b()) {
                    this.f43807d.d(null);
                    this.f43808e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Boolean a(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.f43705a.c("Could not read data collection permission from manifest", e2);
        }
        Boolean boolValueOf = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        if (boolValueOf == null) {
            this.f43809f = false;
            return null;
        }
        this.f43809f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolValueOf));
    }

    public final synchronized boolean b() {
        boolean zJ;
        Boolean bool = this.f43810g;
        if (bool != null) {
            zJ = bool.booleanValue();
        } else {
            try {
                zJ = this.f43805b.j();
            } catch (IllegalStateException unused) {
                zJ = false;
            }
        }
        Logger.f43705a.b(android.support.v4.media.b.m("Crashlytics automatic data collection ", zJ ? "ENABLED" : "DISABLED", " by ", this.f43810g == null ? "global Firebase setting" : this.f43809f ? "firebase_crashlytics_collection_enabled manifest flag" : "API", CLConstants.DOT_SALT_DELIMETER), null);
        return zJ;
    }
}
