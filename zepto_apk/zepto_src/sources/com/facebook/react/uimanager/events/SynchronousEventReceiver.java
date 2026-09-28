package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public interface SynchronousEventReceiver {
    void receiveEvent(int i2, int i3, String str, boolean z, WritableMap writableMap, int i4, boolean z2);
}
