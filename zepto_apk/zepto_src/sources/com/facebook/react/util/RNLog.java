package com.facebook.react.util;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RNLog {
    public static final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.g("ReactNative", message);
    }

    public static void b(int i2, ReactApplicationContext reactApplicationContext, String str) {
        if (i2 < 5 || reactApplicationContext == null || !reactApplicationContext.hasActiveReactInstance() || str == null) {
            return;
        }
        ((RCTLog) reactApplicationContext.getJSModule(RCTLog.class)).logIfNoNativeHook((i2 == 2 || i2 == 3) ? "log" : (i2 == 4 || i2 == 5) ? "warn" : i2 != 6 ? "none" : "error", str);
    }

    public static final void c(ReactApplicationContext reactApplicationContext, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        b(5, reactApplicationContext, message);
        FLog.q("ReactNative", message);
    }
}
