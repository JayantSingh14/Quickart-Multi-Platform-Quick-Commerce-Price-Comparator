package com.facebook.react.modules.core;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public interface RCTNativeAppEventEmitter extends JavaScriptModule {
    void emit(@NotNull String str, @Nullable Object obj);
}
