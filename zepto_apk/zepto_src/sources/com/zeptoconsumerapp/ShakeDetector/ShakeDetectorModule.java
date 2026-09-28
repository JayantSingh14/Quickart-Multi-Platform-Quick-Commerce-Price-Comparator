package com.zeptoconsumerapp.ShakeDetector;

import coil3.decode.a;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zeptoconsumerapp.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ShakeDetectorModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @Nullable
    private static ShakeSensor shakeSensor;

    @NotNull
    private final ReactApplicationContext reactContext;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShakeDetectorModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit register$lambda$0(ShakeDetectorModule shakeDetectorModule) {
        Utils.j(shakeDetectorModule.reactContext, "SHAKE_EVENT", null);
        return Unit.f53572a;
    }

    @ReactMethod
    public final void deregister() {
        ShakeSensor shakeSensor2 = shakeSensor;
        if (shakeSensor2 != null) {
            shakeSensor2.a();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ShakeDetector";
    }

    @ReactMethod
    public final void register() {
        if (shakeSensor == null) {
            shakeSensor = new ShakeSensor(this.reactContext, new a(this, 9));
        }
        ShakeSensor shakeSensor2 = shakeSensor;
        if (shakeSensor2 != null) {
            shakeSensor2.b();
        }
    }
}
