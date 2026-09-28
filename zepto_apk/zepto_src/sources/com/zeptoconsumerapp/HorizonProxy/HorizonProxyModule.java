package com.zeptoconsumerapp.HorizonProxy;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.horizon.HorizonModule;
import com.zeptoconsumerapp.NetworkLogger.NetworkEventListener;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class HorizonProxyModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "HorizonProxy";

    @NotNull
    private final HorizonModule horizon;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonProxyModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        HorizonModule horizonModule = new HorizonModule(reactContext);
        this.horizon = horizonModule;
        reactContext.removeLifecycleEventListener(horizonModule);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void track(@NotNull String eventName, @NotNull String eventBody, @NotNull String type, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventBody, "eventBody");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (Intrinsics.b(eventName, "api_failed_event")) {
                JSONObject jSONObject = new JSONObject(eventBody);
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) NetworkEventListener.f47528g.get(jSONObject.getString("request_id"));
                if (copyOnWriteArrayList != null) {
                    jSONObject.put("steps", new JSONArray((Collection) copyOnWriteArrayList));
                    eventBody = jSONObject.toString();
                }
            }
        } catch (Exception unused) {
        } finally {
            this.horizon.track(eventName, eventBody, type, promise);
        }
    }
}
