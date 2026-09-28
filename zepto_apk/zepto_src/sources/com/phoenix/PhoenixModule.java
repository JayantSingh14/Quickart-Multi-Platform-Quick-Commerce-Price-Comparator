package com.phoenix;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.phoenix.Phoenix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "Phoenix";

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoenixModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public static /* synthetic */ void updateInternalStagingUserType$default(PhoenixModule phoenixModule, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        phoenixModule.updateInternalStagingUserType(bool);
    }

    public static /* synthetic */ void updateUserType$default(PhoenixModule phoenixModule, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        phoenixModule.updateUserType(bool);
    }

    @ReactMethod
    public final void checkUpdate(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        PhoenixUpdateManager.f46124a.a();
        promise.resolve(Unit.f53572a);
    }

    @ReactMethod
    public final void divide(double d2, double d3, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Double.valueOf(d2 / d3));
    }

    @ReactMethod
    public final void downloadBundle(@NotNull String bundleUrl, @NotNull String hash, int i2, int i3, @Nullable Integer num, @NotNull Promise promise) {
        Promise promise2;
        Intrinsics.checkNotNullParameter(bundleUrl, "bundleUrl");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Intrinsics.checkNotNullParameter(bundleUrl, "bundleUrl");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(promise, "promise");
            promise2 = promise;
            try {
                BuildersKt.c(CoroutineScopeKt.a(Dispatchers.f54091a), null, new Phoenix$Companion$downloadBundle$1(bundleUrl, hash, i2, i3, num, promise2, null), 3);
            } catch (Exception e2) {
                e = e2;
                Exception exc = e;
                promise2.reject("PHOENIX_ERROR", "Failed to download bundle: " + exc.getMessage(), exc);
            }
        } catch (Exception e3) {
            e = e3;
            promise2 = promise;
        }
    }

    @ReactMethod
    public final void getBundleCurrentBundleVersion(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve("v1");
    }

    @ReactMethod
    public final void getBundlesByAppVersion(int i2, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(promise, "promise");
        PhoenixBundleList.f46120a.b(i2, promise);
    }

    @ReactMethod
    public final void getInternalStagingUserType(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Phoenix.Companion.d()));
    }

    @ReactMethod
    public final void getManifestData(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Phoenix.Companion.f());
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void getUserType(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Phoenix.Companion.g()));
    }

    @ReactMethod
    public final void multiply(double d2, double d3, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Double.valueOf(d2 * d3));
    }

    @ReactMethod
    public final void updateInternalStagingUserType(@Nullable Boolean bool) {
        if (bool != null) {
            Phoenix.Companion.h(bool.booleanValue());
        } else {
            Phoenix.Companion.h(false);
        }
    }

    @ReactMethod
    public final void updateUserType(@Nullable Boolean bool) {
        if (bool != null) {
            Phoenix.Companion.i(bool.booleanValue());
        } else {
            Phoenix.Companion.i(false);
        }
    }
}
