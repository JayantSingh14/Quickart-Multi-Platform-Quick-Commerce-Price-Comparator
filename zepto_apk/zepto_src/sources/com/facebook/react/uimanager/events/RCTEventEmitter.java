package com.facebook.react.uimanager.events;

import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
@DoNotStripAny
@Metadata
/* loaded from: classes.dex */
public interface RCTEventEmitter extends JavaScriptModule {
    @Deprecated
    void receiveEvent(int i2, @NotNull String str, @Nullable WritableMap writableMap);

    @Deprecated
    void receiveTouches(@NotNull String str, @NotNull WritableArray writableArray, @NotNull WritableArray writableArray2);
}
