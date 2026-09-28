package com.zeptoconsumerapp.NetworkLogger;

import android.content.Context;
import androidx.annotation.NonNull;
import com.chuckerteam.chucker.api.Chucker;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes.dex */
public class NetworkLoggerModule extends ReactContextBaseJavaModule {
    Context reactAppContext;

    public NetworkLoggerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactAppContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "NetworkLogger";
    }

    @ReactMethod
    public void launch() {
        Context context = this.reactAppContext;
        if (context != null) {
            Chucker.a(context);
        }
    }
}
