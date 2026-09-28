package com.agontuk.RNFusedLocation;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RNFusedLocationModule extends ReactContextBaseJavaModule implements ActivityEventListener, LocationChangeListener {
    public static final String TAG = "RNFusedLocation";

    @Nullable
    private LocationProvider continuousLocationProvider;
    private final HashMap<LocationProvider, PendingLocationRequest> pendingRequests;

    /* loaded from: classes3.dex */
    public static class PendingLocationRequest {

        /* renamed from: a, reason: collision with root package name */
        public final Callback f14074a;

        /* renamed from: b, reason: collision with root package name */
        public final Callback f14075b;

        public PendingLocationRequest(Callback callback, Callback callback2) {
            this.f14074a = callback;
            this.f14075b = callback2;
        }
    }

    public RNFusedLocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.pendingRequests = new HashMap<>();
        Log.i(TAG, "RNFusedLocation initialized");
    }

    private LocationProvider createLocationProvider(boolean z) {
        ReactApplicationContext context = getContext();
        return (z || !LocationUtils.c(context)) ? new LocationManagerProvider(context, this) : new FusedLocationProvider(context, this);
    }

    private void emitEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private ReactApplicationContext getContext() {
        return getReactApplicationContext();
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void getCurrentPosition(ReadableMap readableMap, Callback callback, Callback callback2) {
        if (!LocationUtils.b(getContext())) {
            callback2.invoke(LocationUtils.a(LocationError.PERMISSION_DENIED, null));
            return;
        }
        LocationOptions locationOptionsA = LocationOptions.a(readableMap);
        LocationProvider locationProviderCreateLocationProvider = createLocationProvider(locationOptionsA.b());
        this.pendingRequests.put(locationProviderCreateLocationProvider, new PendingLocationRequest(callback, callback2));
        locationProviderCreateLocationProvider.d(locationOptionsA);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return TAG;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        LocationProvider locationProvider = this.continuousLocationProvider;
        if (locationProvider == null || !locationProvider.a(i2, i3)) {
            Iterator<LocationProvider> it = this.pendingRequests.keySet().iterator();
            while (it.hasNext() && !it.next().a(i2, i3)) {
            }
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationChangeListener
    public void onLocationChange(LocationProvider locationProvider, Location location) {
        WritableMap writableMapE = LocationUtils.e(location);
        if (locationProvider.equals(this.continuousLocationProvider)) {
            emitEvent("geolocationDidChange", writableMapE);
            return;
        }
        PendingLocationRequest pendingLocationRequest = this.pendingRequests.get(locationProvider);
        if (pendingLocationRequest != null) {
            pendingLocationRequest.f14074a.invoke(writableMapE);
            this.pendingRequests.remove(locationProvider);
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationChangeListener
    public void onLocationError(LocationProvider locationProvider, LocationError locationError, @Nullable String str) {
        WritableMap writableMapA = LocationUtils.a(locationError, str);
        if (locationProvider.equals(this.continuousLocationProvider)) {
            emitEvent("geolocationError", writableMapA);
            return;
        }
        PendingLocationRequest pendingLocationRequest = this.pendingRequests.get(locationProvider);
        if (pendingLocationRequest != null) {
            pendingLocationRequest.f14075b.invoke(writableMapA);
            this.pendingRequests.remove(locationProvider);
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if (!LocationUtils.b(getContext())) {
            emitEvent("geolocationError", LocationUtils.a(LocationError.PERMISSION_DENIED, null));
            return;
        }
        LocationOptions locationOptionsA = LocationOptions.a(readableMap);
        if (this.continuousLocationProvider == null) {
            this.continuousLocationProvider = createLocationProvider(locationOptionsA.b());
        }
        this.continuousLocationProvider.b(locationOptionsA);
    }

    @ReactMethod
    public void stopObserving() {
        LocationProvider locationProvider = this.continuousLocationProvider;
        if (locationProvider != null) {
            locationProvider.c();
            this.continuousLocationProvider = null;
        }
    }
}
