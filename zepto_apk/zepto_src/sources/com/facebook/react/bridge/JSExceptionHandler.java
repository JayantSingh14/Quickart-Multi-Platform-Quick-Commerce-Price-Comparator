package com.facebook.react.bridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface JSExceptionHandler {
    void handleException(@NotNull Exception exc);
}
