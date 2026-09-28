package com.facebook.react.bridge;

import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
@UnstableReactNativeAPI
/* loaded from: classes.dex */
public interface UIManagerListener {
    void didDispatchMountItems(@NotNull UIManager uIManager);

    void didMountItems(@NotNull UIManager uIManager);

    void didScheduleMountItems(@NotNull UIManager uIManager);

    void willDispatchViewUpdates(@NotNull UIManager uIManager);

    void willMountItems(@NotNull UIManager uIManager);
}
