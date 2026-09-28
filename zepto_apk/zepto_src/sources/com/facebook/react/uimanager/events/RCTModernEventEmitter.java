package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface RCTModernEventEmitter extends RCTEventEmitter {
    void receiveEvent(int i2, int i3, @NotNull String str, @Nullable WritableMap writableMap);

    void receiveEvent(int i2, int i3, @NotNull String str, boolean z, int i4, @Nullable WritableMap writableMap, int i5);

    @Deprecated
    void receiveTouches(@NotNull TouchEvent touchEvent);
}
