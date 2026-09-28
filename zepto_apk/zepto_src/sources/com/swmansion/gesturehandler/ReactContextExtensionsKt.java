package com.swmansion.gesturehandler;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ReactContextExtensionsKt {
    public static final void a(ReactApplicationContext reactApplicationContext, Event event) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            NativeModule nativeModule = reactApplicationContext.getNativeModule((Class<NativeModule>) UIManagerModule.class);
            Intrinsics.c(nativeModule);
            ((UIManagerModule) nativeModule).getEventDispatcher().g(event);
        } catch (NullPointerException e2) {
            throw new Exception("Couldn't get an instance of UIManagerModule. Gesture Handler is unable to send an event.", e2);
        }
    }
}
