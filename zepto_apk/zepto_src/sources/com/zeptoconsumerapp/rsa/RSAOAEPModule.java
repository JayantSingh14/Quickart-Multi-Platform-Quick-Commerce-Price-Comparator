package com.zeptoconsumerapp.rsa;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class RSAOAEPModule extends ReactContextBaseJavaModule {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RSAOAEPModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @ReactMethod
    public final void decrypt(@NotNull String privatePem, @NotNull String encryptedB64, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(privatePem, "privatePem");
        Intrinsics.checkNotNullParameter(encryptedB64, "encryptedB64");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(RSAUtil.b(RSAUtil.d(privatePem), encryptedB64));
        } catch (Exception e2) {
            promise.reject("ERR", e2);
        }
    }

    @ReactMethod
    public final void encrypt(@NotNull String publicBase64, @NotNull String json, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(publicBase64, "publicBase64");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(RSAUtil.c(RSAUtil.e(RSAUtil.a(publicBase64)), json));
        } catch (Exception e2) {
            promise.reject("ERR", e2);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RSAOAEP";
    }
}
