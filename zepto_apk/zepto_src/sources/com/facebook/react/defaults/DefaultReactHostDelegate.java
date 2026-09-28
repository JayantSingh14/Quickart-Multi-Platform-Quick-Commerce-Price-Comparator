package com.facebook.react.defaults;

import com.brentvatne.common.react.r;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@DoNotStrip
@Metadata
@UnstableReactNativeAPI
/* loaded from: classes3.dex */
public final class DefaultReactHostDelegate implements ReactHostDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final String f18750a;

    /* renamed from: b, reason: collision with root package name */
    public final JSBundleLoader f18751b;

    /* renamed from: c, reason: collision with root package name */
    public final List f18752c;

    /* renamed from: d, reason: collision with root package name */
    public final JSRuntimeFactory f18753d;

    /* renamed from: e, reason: collision with root package name */
    public final r f18754e;

    /* renamed from: f, reason: collision with root package name */
    public final DefaultTurboModuleManagerDelegate.Builder f18755f;

    public DefaultReactHostDelegate(String jsMainModulePath, JSBundleLoader jsBundleLoader, List reactPackages, JSRuntimeFactory jsRuntimeFactory, r exceptionHandler, DefaultTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder) {
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleLoader, "jsBundleLoader");
        Intrinsics.checkNotNullParameter(reactPackages, "reactPackages");
        Intrinsics.checkNotNullParameter(jsRuntimeFactory, "jsRuntimeFactory");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        Intrinsics.checkNotNullParameter(turboModuleManagerDelegateBuilder, "turboModuleManagerDelegateBuilder");
        this.f18750a = jsMainModulePath;
        this.f18751b = jsBundleLoader;
        this.f18752c = reactPackages;
        this.f18753d = jsRuntimeFactory;
        this.f18754e = exceptionHandler;
        this.f18755f = turboModuleManagerDelegateBuilder;
    }

    public final void a(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f18754e.invoke(error);
        throw null;
    }
}
