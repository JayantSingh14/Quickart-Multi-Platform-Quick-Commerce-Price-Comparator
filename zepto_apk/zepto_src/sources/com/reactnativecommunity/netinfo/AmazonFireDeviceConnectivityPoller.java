package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes.dex */
public class AmazonFireDeviceConnectivityPoller {

    /* renamed from: b, reason: collision with root package name */
    public final ReactApplicationContext f46171b;

    /* renamed from: c, reason: collision with root package name */
    public final NetInfoModule f46172c;

    /* renamed from: e, reason: collision with root package name */
    public Handler f46174e;

    /* renamed from: a, reason: collision with root package name */
    public final Receiver f46170a = new Receiver();

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f46173d = new PollerTask();

    /* renamed from: f, reason: collision with root package name */
    public boolean f46175f = false;

    public interface ConnectivityChangedCallback {
        void onAmazonFireDeviceConnectivityChanged(boolean z);
    }

    public class PollerTask implements Runnable {
        public PollerTask() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = AmazonFireDeviceConnectivityPoller.this;
            if (amazonFireDeviceConnectivityPoller.f46175f) {
                amazonFireDeviceConnectivityPoller.f46171b.sendBroadcast(new Intent("com.amazon.tv.networkmonitor.CONNECTIVITY_CHECK"));
                amazonFireDeviceConnectivityPoller.f46174e.postDelayed(amazonFireDeviceConnectivityPoller.f46173d, 10000L);
            }
        }
    }

    public class Receiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f46177a = false;

        /* renamed from: b, reason: collision with root package name */
        public Boolean f46178b;

        public Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent == null ? null : intent.getAction();
            if ("com.amazon.tv.networkmonitor.INTERNET_DOWN".equals(action)) {
                z = false;
            } else if (!"com.amazon.tv.networkmonitor.INTERNET_UP".equals(action)) {
                return;
            } else {
                z = true;
            }
            Boolean bool = this.f46178b;
            if (bool == null || bool.booleanValue() != z) {
                this.f46178b = Boolean.valueOf(z);
                AmazonFireDeviceConnectivityPoller.this.f46172c.onAmazonFireDeviceConnectivityChanged(z);
            }
        }
    }

    public AmazonFireDeviceConnectivityPoller(ReactApplicationContext reactApplicationContext, NetInfoModule netInfoModule) {
        this.f46171b = reactApplicationContext;
        this.f46172c = netInfoModule;
    }

    public static boolean a() {
        if (!Build.MANUFACTURER.equals("Amazon")) {
            return false;
        }
        String str = Build.MODEL;
        return str.startsWith("AF") || str.startsWith("KF");
    }
}
