package com.sparkfabrikreactnativeidfaaaid;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class ReactNativeIdfaAaidModule extends ReactContextBaseJavaModule {

    @NotNull
    private final ReactApplicationContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeIdfaAaidModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @ReactMethod
    public final void getAdvertisingInfo(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        try {
            AdvertisingIdClient.Info infoA = AdvertisingIdClient.a(this.reactContext);
            Intrinsics.checkNotNullExpressionValue(infoA, "getAdvertisingIdInfo(...)");
            writableNativeMap.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, infoA.a());
            writableNativeMap.putBoolean("isAdTrackingLimited", false);
        } catch (Exception e2) {
            Log.e(getName(), "Failed to connect to Advertising ID provider.");
            promise.reject("Error getting aaid.", e2);
        }
        promise.resolve(writableNativeMap);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ReactNativeIdfaAaid";
    }
}
