package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class SyncTask implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f44767a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f44768b;

    /* renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f44769c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f44770d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public SyncTask f44771a;

        /* renamed from: b, reason: collision with root package name */
        public Context f44772b;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f44771a = syncTask;
        }

        public final void a() {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            SyncTask syncTask = this.f44771a;
            if (syncTask != null) {
                Context context = syncTask.f44769c.f44702c;
                this.f44772b = context;
                context.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f44771a;
            if (syncTask != null && syncTask.a()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                SyncTask syncTask2 = this.f44771a;
                syncTask2.f44769c.getClass();
                FirebaseMessaging.b(0L, syncTask2);
                Context context2 = this.f44772b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f44771a = null;
            }
        }
    }

    public SyncTask(FirebaseMessaging firebaseMessaging, long j2) {
        this.f44769c = firebaseMessaging;
        this.f44767a = j2;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.f44702c.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f44768b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public final boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f44769c.f44702c.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean b() throws IOException {
        try {
            if (this.f44769c.a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e2) {
            String message = e2.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e2.getMessage() != null) {
                    throw e2;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e2.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceStarter serviceStarterA = ServiceStarter.a();
        FirebaseMessaging firebaseMessaging = this.f44769c;
        boolean zC = serviceStarterA.c(firebaseMessaging.f44702c);
        PowerManager.WakeLock wakeLock = this.f44768b;
        if (zC) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.f44710k = true;
                }
                if (!firebaseMessaging.f44709j.d()) {
                    synchronized (firebaseMessaging) {
                        firebaseMessaging.f44710k = false;
                    }
                    if (ServiceStarter.a().c(firebaseMessaging.f44702c)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (ServiceStarter.a().b(firebaseMessaging.f44702c) && !a()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (ServiceStarter.a().c(firebaseMessaging.f44702c)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (b()) {
                    synchronized (firebaseMessaging) {
                        firebaseMessaging.f44710k = false;
                    }
                } else {
                    firebaseMessaging.n(this.f44767a);
                }
                if (ServiceStarter.a().c(firebaseMessaging.f44702c)) {
                    wakeLock.release();
                }
            } catch (IOException e2) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e2.getMessage() + ". Won't retry the operation.");
                synchronized (firebaseMessaging) {
                    firebaseMessaging.f44710k = false;
                    if (ServiceStarter.a().c(firebaseMessaging.f44702c)) {
                        wakeLock.release();
                    }
                }
            }
        } catch (Throwable th) {
            if (ServiceStarter.a().c(firebaseMessaging.f44702c)) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
