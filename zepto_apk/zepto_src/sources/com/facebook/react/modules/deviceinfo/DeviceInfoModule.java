package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = NativeDeviceInfoSpec.NAME)
@Metadata
/* loaded from: classes.dex */
public final class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    private float fontScale;

    @Nullable
    private ReadableMap previousDisplayMetrics;

    @Nullable
    private ReactApplicationContext reactApplicationContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DisplayMetricsHolder.f(reactContext);
        this.fontScale = reactContext.getResources().getConfiguration().fontScale;
        reactContext.addLifecycleEventListener(this);
        this.reactApplicationContext = reactContext;
    }

    public final void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext != null) {
            if (!reactApplicationContext.hasActiveReactInstance()) {
                ReactSoftExceptionLogger.logSoftException(NativeDeviceInfoSpec.NAME, new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
                return;
            }
            WritableNativeMap writableNativeMapA = DisplayMetricsHolder.a(this.fontScale);
            ReadableMap readableMap = this.previousDisplayMetrics;
            if (readableMap == null) {
                this.previousDisplayMetrics = writableNativeMapA.copy();
            } else {
                if (writableNativeMapA.equals(readableMap)) {
                    return;
                }
                this.previousDisplayMetrics = writableNativeMapA.copy();
                reactApplicationContext.emitDeviceEvent("didUpdateDimensions", writableNativeMapA);
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceInfoSpec
    @NotNull
    public Map<String, Object> getTypedExportedConstants() {
        WritableNativeMap writableNativeMapA = DisplayMetricsHolder.a(this.fontScale);
        this.previousDisplayMetrics = writableNativeMapA.copy();
        return MapsKt.g(new Pair("Dimensions", writableNativeMapA.toHashMap()));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        Resources resources;
        Configuration configuration;
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        Float fValueOf = (reactApplicationContext == null || (resources = reactApplicationContext.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Float.valueOf(configuration.fontScale);
        if (fValueOf == null || Intrinsics.a(this.fontScale, fValueOf)) {
            return;
        }
        this.fontScale = fValueOf.floatValue();
        emitUpdateDimensionsEvent();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(@NotNull Context context) {
        super(null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reactApplicationContext = null;
        DisplayMetricsHolder.f(context);
        this.fontScale = context.getResources().getConfiguration().fontScale;
    }
}
