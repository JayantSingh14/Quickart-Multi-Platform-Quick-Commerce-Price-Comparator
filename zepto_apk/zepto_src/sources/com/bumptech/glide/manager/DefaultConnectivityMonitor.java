package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16401a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityMonitor.ConnectivityListener f16402b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16403c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16404d;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f16405e = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z = defaultConnectivityMonitor.f16403c;
            boolean zB = DefaultConnectivityMonitor.b(context);
            defaultConnectivityMonitor.f16403c = zB;
            if (z != zB) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + defaultConnectivityMonitor.f16403c);
                }
                defaultConnectivityMonitor.f16402b.a(defaultConnectivityMonitor.f16403c);
            }
        }
    };

    public DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f16401a = context.getApplicationContext();
        this.f16402b = connectivityListener;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Preconditions.c(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void e() {
        if (this.f16404d) {
            this.f16401a.unregisterReceiver(this.f16405e);
            this.f16404d = false;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void i() {
        if (this.f16404d) {
            return;
        }
        Context context = this.f16401a;
        this.f16403c = b(context);
        try {
            context.registerReceiver(this.f16405e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f16404d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }
}
