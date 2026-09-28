package fr.greweb.reactnativeviewshot;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public abstract class NativeRNViewShotSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNViewShot";

    public NativeRNViewShotSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void captureRef(@Nullable Double d2, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void captureScreen(ReadableMap readableMap, Promise promise);

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @DoNotStrip
    @ReactMethod
    public abstract void releaseCapture(String str);
}
