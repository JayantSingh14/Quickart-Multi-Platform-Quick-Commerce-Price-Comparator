package com.zeptoconsumerapp.AppServiceStarter;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AppServiceStarterModule extends ReactContextBaseJavaModule {
    public AppServiceStarterModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "AppServiceStarter";
    }

    @ReactMethod
    public final void startService(@NotNull String service, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            ServiceType serviceTypeValueOf = ServiceType.valueOf(service);
            Object obj = ServiceRegistry.f47322a;
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            ServiceRegistry.a(reactApplicationContext, serviceTypeValueOf, readableMap);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @ReactMethod
    public final void stopService(@NotNull String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            ServiceType serviceTypeValueOf = ServiceType.valueOf(service);
            Object obj = ServiceRegistry.f47322a;
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            ServiceRegistry.b(reactApplicationContext, serviceTypeValueOf);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }
}
