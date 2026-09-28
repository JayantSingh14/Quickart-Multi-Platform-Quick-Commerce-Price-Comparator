package com.facebook.react.bridge;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface NotThreadSafeBridgeIdleDebugListener {
    void onBridgeDestroyed();

    void onTransitionToBridgeBusy();

    void onTransitionToBridgeIdle();
}
