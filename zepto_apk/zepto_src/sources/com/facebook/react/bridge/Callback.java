package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface Callback {
    void invoke(@NotNull Object... objArr);
}
