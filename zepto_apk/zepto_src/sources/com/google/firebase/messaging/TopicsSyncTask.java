package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class TopicsSyncTask implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f44790f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f44791g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f44792h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f44793a;

    /* renamed from: b, reason: collision with root package name */
    public final Metadata f44794b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f44795c;

    /* renamed from: d, reason: collision with root package name */
    public final TopicsSubscriber f44796d;

    /* renamed from: e, reason: collision with root package name */
    public final long f44797e;

    @VisibleForTesting
    public class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public TopicsSyncTask f44798a;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.f44798a = topicsSyncTask;
        }

        public final void a() {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            TopicsSyncTask topicsSyncTask = TopicsSyncTask.this;
            topicsSyncTask.f44793a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public final synchronized void onReceive(Context context, Intent intent) {
            try {
                TopicsSyncTask topicsSyncTask = this.f44798a;
                if (topicsSyncTask == null) {
                    return;
                }
                if (topicsSyncTask.d()) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    TopicsSyncTask topicsSyncTask2 = this.f44798a;
                    topicsSyncTask2.f44796d.f44787f.schedule(topicsSyncTask2, 0L, TimeUnit.SECONDS);
                    context.unregisterReceiver(this);
                    this.f44798a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j2) {
        this.f44796d = topicsSubscriber;
        this.f44793a = context;
        this.f44797e = j2;
        this.f44794b = metadata;
        this.f44795c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean zBooleanValue;
        synchronized (f44790f) {
            try {
                Boolean bool = f44792h;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f44792h = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean b(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z;
    }

    public static boolean c(Context context) {
        boolean zBooleanValue;
        synchronized (f44790f) {
            try {
                Boolean bool = f44791g;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f44791g = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean d() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f44793a     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L12
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L12
            goto L15
        L12:
            r0 = move-exception
            goto L22
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1f
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            monitor-exit(r2)
            return r0
        L22:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSyncTask.d():boolean");
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        TopicsSubscriber topicsSubscriber = this.f44796d;
        Context context = this.f44793a;
        boolean zC = c(context);
        PowerManager.WakeLock wakeLock = this.f44795c;
        if (zC) {
            wakeLock.acquire(Constants.f44687a);
        }
        try {
            try {
                try {
                    topicsSubscriber.e(true);
                    if (!this.f44794b.d()) {
                        topicsSubscriber.e(false);
                        if (!c(context)) {
                            return;
                        }
                    } else if (!a(context) || d()) {
                        if (topicsSubscriber.g()) {
                            topicsSubscriber.e(false);
                        } else {
                            topicsSubscriber.h(this.f44797e);
                        }
                        if (!c(context)) {
                            return;
                        }
                    } else {
                        new ConnectivityChangeReceiver(this).a();
                        if (!c(context)) {
                            return;
                        }
                    }
                    wakeLock.release();
                } catch (IOException e2) {
                    Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e2.getMessage());
                    topicsSubscriber.e(false);
                    if (c(context)) {
                        wakeLock.release();
                    }
                }
            } catch (Throwable th) {
                if (c(context)) {
                    try {
                        wakeLock.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
                throw th;
            }
        } catch (RuntimeException unused2) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
