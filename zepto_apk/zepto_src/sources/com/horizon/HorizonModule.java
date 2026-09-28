package com.horizon;

import android.content.Context;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zeptonow.horizon.HorizonSDK;
import com.zeptonow.horizon.di.DependencyContainer;
import com.zeptonow.horizon.domain.EventManager;
import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.LogLevel;
import com.zeptonow.horizon.utils.PlatformContext;
import com.zeptonow.horizon.utils.RNBridge;
import com.zeptonow.horizon.utils.RNBridgeEvent;
import defpackage.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class HorizonModule extends ReactContextBaseJavaModule implements LifecycleEventListener, RNBridge {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "Horizon";
    private int listenerCount;

    @NotNull
    private final ReactApplicationContext reactContext;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        reactContext.addLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(Promise promise) {
        promise.resolve(null);
        return Unit.f53572a;
    }

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        DefaultLogger defaultLoggerA;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        int i2 = this.listenerCount + 1;
        this.listenerCount = i2;
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        boolean z = i2 > 0;
        DependencyContainer dependencyContainer2 = HorizonSDK.f47830a;
        if (dependencyContainer2 == null || (defaultLoggerA = dependencyContainer2.a()) == null) {
            return;
        }
        defaultLoggerA.f48236b = z;
    }

    @Override // com.zeptonow.horizon.utils.RNBridge
    public void emit(@NotNull RNBridgeEvent event, @NotNull String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(event.name(), data);
    }

    @ReactMethod
    public final void flushEvents() {
        EventManager eventManager;
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        DependencyContainer dependencyContainer2 = HorizonSDK.f47830a;
        if (dependencyContainer2 == null || (eventManager = (EventManager) dependencyContainer2.o.getValue()) == null) {
            return;
        }
        eventManager.a();
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void init(@NotNull String configJson, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        Context applicationContext = this.reactContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        HorizonSDK.b(new PlatformContext(applicationContext), configJson, this, new b(promise, 7));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        shutdown();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @ReactMethod
    public final void removeListeners(int i2) {
        DefaultLogger defaultLoggerA;
        int i3 = this.listenerCount - i2;
        this.listenerCount = i3;
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        boolean z = i3 > 0;
        DependencyContainer dependencyContainer2 = HorizonSDK.f47830a;
        if (dependencyContainer2 == null || (defaultLoggerA = dependencyContainer2.a()) == null) {
            return;
        }
        defaultLoggerA.f48236b = z;
    }

    @ReactMethod
    public final void setHeaders(@NotNull String headersJson) {
        Intrinsics.checkNotNullParameter(headersJson, "headersJson");
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        HorizonSDK.c(headersJson);
    }

    @ReactMethod
    public final void setLogLevel(@NotNull String logLevel) {
        DefaultLogger defaultLoggerA;
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        try {
            DependencyContainer dependencyContainer2 = HorizonSDK.f47830a;
            if (dependencyContainer2 == null || (defaultLoggerA = dependencyContainer2.a()) == null) {
                return;
            }
            LogLevel level = LogLevel.valueOf(logLevel);
            Intrinsics.checkNotNullParameter(level, "level");
            defaultLoggerA.f48237c = level;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @ReactMethod
    public final void shutdown() {
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        HorizonSDK.d();
    }

    @ReactMethod
    public final void track(@NotNull String eventName, @NotNull String eventBody, @NotNull String type, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventBody, "eventBody");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DependencyContainer dependencyContainer = HorizonSDK.f47830a;
        HorizonSDK.e(new Event(eventName, eventBody, EventType.valueOf(type)));
        promise.resolve(null);
    }
}
