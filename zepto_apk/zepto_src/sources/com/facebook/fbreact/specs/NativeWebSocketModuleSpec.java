package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class NativeWebSocketModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "WebSocketModule";

    public NativeWebSocketModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void close(double d2, String str, double d3);

    @DoNotStrip
    @ReactMethod
    public abstract void connect(String str, @Nullable ReadableArray readableArray, ReadableMap readableMap, double d2);

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "WebSocketModule";
    }

    @DoNotStrip
    @ReactMethod
    public abstract void ping(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void send(String str, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void sendBinary(String str, double d2);
}
