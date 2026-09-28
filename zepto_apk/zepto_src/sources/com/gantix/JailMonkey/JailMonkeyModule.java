package com.gantix.JailMonkey;

import android.os.Debug;
import android.provider.Settings;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.gantix.JailMonkey.Rooted.RootedCheck;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class JailMonkeyModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;

    public JailMonkeyModule(ReactApplicationContext reactApplicationContext, boolean z) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        RootedCheck rootedCheck = new RootedCheck(getReactApplicationContext());
        HashMap map = new HashMap();
        map.put("isJailBroken", Boolean.valueOf(rootedCheck.b()));
        map.put("rootedDetectionMethods", rootedCheck.a());
        Boolean bool = Boolean.FALSE;
        map.put("hookDetected", bool);
        map.put("canMockLocation", bool);
        map.put("isOnExternalStorage", bool);
        map.put("AdbEnabled", bool);
        return map;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "JailMonkey";
    }

    @ReactMethod
    public void isDebuggedMode(Promise promise) {
        boolean z = true;
        if (!Debug.isDebuggerConnected() && (this.reactContext.getApplicationContext().getApplicationInfo().flags & 2) == 0) {
            z = false;
        }
        promise.resolve(Boolean.valueOf(z));
    }

    @ReactMethod
    public void isDevelopmentSettingsMode(Promise promise) {
        promise.resolve(Boolean.valueOf(Settings.Global.getInt(this.reactContext.getContentResolver(), "development_settings_enabled", 0) == 1));
    }
}
