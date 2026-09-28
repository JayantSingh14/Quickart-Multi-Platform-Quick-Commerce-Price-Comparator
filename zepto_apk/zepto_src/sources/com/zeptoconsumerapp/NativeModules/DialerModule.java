package com.zeptoconsumerapp.NativeModules;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DialerModule extends ReactContextBaseJavaModule {

    @NotNull
    private final ReactApplicationContext context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @ReactMethod
    public final void dial(@NotNull String number, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + number));
            intent.addFlags(268435456);
            if (intent.resolveActivity(this.context.getPackageManager()) == null) {
                promise.reject("NO_DIALER", "No app to handle dial action");
            } else {
                this.context.startActivity(intent);
                promise.resolve(Boolean.TRUE);
            }
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }

    @NotNull
    public final ReactApplicationContext getContext() {
        return this.context;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "DialerModule";
    }
}
