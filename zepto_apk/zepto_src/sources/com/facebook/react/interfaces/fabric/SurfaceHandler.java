package com.facebook.react.interfaces.fabric;

import com.facebook.react.bridge.NativeMap;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;

@ThreadSafe
@Metadata
/* loaded from: classes3.dex */
public interface SurfaceHandler {
    String getModuleName();

    int getSurfaceId();

    boolean isRunning();

    void setLayoutConstraints(int i2, int i3, int i4, int i5, boolean z, boolean z2, float f2);

    void setMountable(boolean z);

    void setProps(NativeMap nativeMap);
}
