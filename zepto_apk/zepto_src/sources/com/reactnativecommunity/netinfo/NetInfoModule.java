package com.reactnativecommunity.netinfo;

import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller;

@ReactModule(name = NetInfoModule.NAME)
/* loaded from: classes.dex */
public class NetInfoModule extends ReactContextBaseJavaModule implements AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback {
    public static final String NAME = "RNCNetInfo";
    private final AmazonFireDeviceConnectivityPoller mAmazonConnectivityChecker;
    private final ConnectivityReceiver mConnectivityReceiver;
    private int numberOfListeners;

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.numberOfListeners = 0;
        this.mConnectivityReceiver = new NetworkCallbackConnectivityReceiver(reactApplicationContext);
        this.mAmazonConnectivityChecker = new AmazonFireDeviceConnectivityPoller(reactApplicationContext, this);
    }

    @ReactMethod
    public void addListener(String str) {
        this.numberOfListeners++;
        this.mConnectivityReceiver.f46184e = true;
    }

    @ReactMethod
    public void getCurrentState(String str, Promise promise) {
        promise.resolve(this.mConnectivityReceiver.a(str));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        this.mConnectivityReceiver.c();
        AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = this.mAmazonConnectivityChecker;
        amazonFireDeviceConnectivityPoller.getClass();
        if (AmazonFireDeviceConnectivityPoller.a()) {
            AmazonFireDeviceConnectivityPoller.Receiver receiver = amazonFireDeviceConnectivityPoller.f46170a;
            if (!receiver.f46177a) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_DOWN");
                intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_UP");
                amazonFireDeviceConnectivityPoller.f46171b.registerReceiver(receiver, intentFilter);
                receiver.f46177a = true;
            }
            if (amazonFireDeviceConnectivityPoller.f46175f) {
                return;
            }
            Handler handler = new Handler();
            amazonFireDeviceConnectivityPoller.f46174e = handler;
            amazonFireDeviceConnectivityPoller.f46175f = true;
            handler.post(amazonFireDeviceConnectivityPoller.f46173d);
        }
    }

    @Override // com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback
    public void onAmazonFireDeviceConnectivityChanged(boolean z) {
        ConnectivityReceiver connectivityReceiver = this.mConnectivityReceiver;
        connectivityReceiver.f46188i = Boolean.valueOf(z);
        connectivityReceiver.e(connectivityReceiver.f46185f, connectivityReceiver.f46186g, connectivityReceiver.f46187h);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = this.mAmazonConnectivityChecker;
        amazonFireDeviceConnectivityPoller.getClass();
        if (AmazonFireDeviceConnectivityPoller.a()) {
            if (amazonFireDeviceConnectivityPoller.f46175f) {
                amazonFireDeviceConnectivityPoller.f46175f = false;
                amazonFireDeviceConnectivityPoller.f46174e.removeCallbacksAndMessages(null);
                amazonFireDeviceConnectivityPoller.f46174e = null;
            }
            AmazonFireDeviceConnectivityPoller.Receiver receiver = amazonFireDeviceConnectivityPoller.f46170a;
            if (receiver.f46177a) {
                amazonFireDeviceConnectivityPoller.f46171b.unregisterReceiver(receiver);
                receiver.f46177a = false;
            }
        }
        this.mConnectivityReceiver.d();
        this.mConnectivityReceiver.f46184e = false;
    }

    @ReactMethod
    public void removeListeners(Integer num) {
        int iIntValue = this.numberOfListeners - num.intValue();
        this.numberOfListeners = iIntValue;
        if (iIntValue == 0) {
            this.mConnectivityReceiver.f46184e = false;
        }
    }
}
