package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public interface CatalystInstance extends MemoryPressureListener, JSInstance, JSBundleLoaderDelegate {
    static /* synthetic */ void getJSCallInvokerHolder$annotations() {
    }

    void addBridgeIdleDebugListener(@NotNull NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    @DoNotStrip
    void callFunction(@NotNull String str, @NotNull String str2, @Nullable NativeArray nativeArray);

    /* renamed from: destroy */
    void lambda$onNativeException$6();

    void extendNativeModules(@NotNull NativeModuleRegistry nativeModuleRegistry);

    @Deprecated
    @Nullable
    UIManager getFabricUIManager();

    @Deprecated
    @JvmName
    @NotNull
    CallInvokerHolder getJSCallInvokerHolder();

    @Nullable
    <T extends JavaScriptModule> T getJSModule(@NotNull Class<T> cls);

    @Deprecated
    @NotNull
    JavaScriptContextHolder getJavaScriptContextHolder();

    @NotNull
    NativeMethodCallInvokerHolder getNativeMethodCallInvokerHolder();

    @Nullable
    <T extends NativeModule> T getNativeModule(@NotNull Class<T> cls);

    @Nullable
    NativeModule getNativeModule(@NotNull String str);

    @NotNull
    Collection<NativeModule> getNativeModules();

    @NotNull
    ReactQueueConfiguration getReactQueueConfiguration();

    @Nullable
    RuntimeExecutor getRuntimeExecutor();

    @Nullable
    RuntimeScheduler getRuntimeScheduler();

    @Nullable
    String getSourceURL();

    <T extends NativeModule> boolean hasNativeModule(@NotNull Class<T> cls);

    boolean hasRunJSBundle();

    @VisibleForTesting
    void initialize();

    @Override // com.facebook.react.bridge.JSInstance
    @DoNotStrip
    void invokeCallback(int i2, @NotNull NativeArrayInterface nativeArrayInterface);

    boolean isDestroyed();

    void registerSegment(int i2, @NotNull String str);

    void removeBridgeIdleDebugListener(@NotNull NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    void runJSBundle();

    @Deprecated
    void setFabricUIManager(@NotNull UIManager uIManager);

    @VisibleForTesting
    void setGlobalVariable(@NotNull String str, @NotNull String str2);

    @Deprecated
    void setTurboModuleRegistry(@NotNull TurboModuleRegistry turboModuleRegistry);
}
