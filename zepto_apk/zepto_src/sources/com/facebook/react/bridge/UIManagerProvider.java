package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public interface UIManagerProvider {
    @Nullable
    UIManager createUIManager(@NotNull ReactApplicationContext reactApplicationContext);
}
