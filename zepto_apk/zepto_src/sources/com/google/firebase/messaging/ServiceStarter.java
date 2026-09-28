package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;

@KeepForSdk
/* loaded from: classes.dex */
public class ServiceStarter {

    /* renamed from: e, reason: collision with root package name */
    public static ServiceStarter f44752e;

    /* renamed from: a, reason: collision with root package name */
    public String f44753a = null;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f44754b = null;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f44755c = null;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f44756d = new ArrayDeque();

    public static synchronized ServiceStarter a() {
        try {
            if (f44752e == null) {
                f44752e = new ServiceStarter();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f44752e;
    }

    public final boolean b(Context context) {
        if (this.f44755c == null) {
            this.f44755c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f44754b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f44755c.booleanValue();
    }

    public final boolean c(Context context) {
        if (this.f44754b == null) {
            this.f44754b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f44754b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f44754b.booleanValue();
    }
}
