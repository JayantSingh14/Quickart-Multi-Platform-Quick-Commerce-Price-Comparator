package com.facebook.react.defaults;

import android.content.Context;
import com.brentvatne.common.react.r;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.runtime.JSCInstance;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.zeptoconsumerapp.MainApplication$reactNativeHost$1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DefaultReactHost {

    /* renamed from: a, reason: collision with root package name */
    public static ReactHostImpl f18749a;

    public static final ReactHostImpl a(Context context, MainApplication$reactNativeHost$1 reactNativeHost) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        if (reactNativeHost == null) {
            throw new IllegalArgumentException("You can call getDefaultReactHost only with instances of DefaultReactNativeHost");
        }
        reactNativeHost.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList packageList = reactNativeHost.e();
        Intrinsics.checkNotNullExpressionValue(packageList, "getPackages(...)");
        String jsMainModulePath = reactNativeHost.d();
        Intrinsics.checkNotNullExpressionValue(jsMainModulePath, "getJSMainModuleName(...)");
        String strB = reactNativeHost.b();
        Boolean boolI = reactNativeHost.i();
        boolean zBooleanValue = boolI != null ? boolI.booleanValue() : true;
        EmptyList cxxReactPackageProviders = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter("index.android.bundle", "jsBundleAssetPath");
        Intrinsics.checkNotNullParameter(cxxReactPackageProviders, "cxxReactPackageProviders");
        r exceptionHandler = new r(10);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter("index.android.bundle", "jsBundleAssetPath");
        Intrinsics.checkNotNullParameter(cxxReactPackageProviders, "cxxReactPackageProviders");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        if (f18749a == null) {
            JSBundleLoader jSBundleLoaderCreateAssetLoader = strB != null ? StringsKt.O(strB, "assets://", false) ? JSBundleLoader.createAssetLoader(context, strB, true) : JSBundleLoader.createFileLoader(strB) : JSBundleLoader.createAssetLoader(context, "assets://".concat("index.android.bundle"), true);
            JSRuntimeFactory hermesInstance = zBooleanValue ? new HermesInstance() : new JSCInstance();
            DefaultTurboModuleManagerDelegate.Builder builder = new DefaultTurboModuleManagerDelegate.Builder();
            EmptyIterator emptyIterator = (EmptyIterator) cxxReactPackageProviders.iterator();
            if (emptyIterator.hasNext()) {
                emptyIterator.next();
                throw null;
            }
            Intrinsics.c(jSBundleLoaderCreateAssetLoader);
            DefaultReactHostDelegate defaultReactHostDelegate = new DefaultReactHostDelegate(jsMainModulePath, jSBundleLoaderCreateAssetLoader, packageList, hermesInstance, exceptionHandler, builder);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.register(componentFactory);
            f18749a = new ReactHostImpl(context, defaultReactHostDelegate, componentFactory, false);
        }
        ReactHostImpl reactHostImpl = f18749a;
        Intrinsics.d(reactHostImpl, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return reactHostImpl;
    }
}
