package com.facebook.react.util;

import com.facebook.react.bridge.JavaScriptModule;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public interface RCTLog extends JavaScriptModule {
    void logIfNoNativeHook(@Nullable String str, @Nullable String str2);
}
