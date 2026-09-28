package com.facebook.react.modules.core;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public interface JSTimers extends JavaScriptModule {
    void callIdleCallbacks(double d2);

    void callTimers(@NotNull WritableArray writableArray);

    void emitTimeDriftWarning(@NotNull String str);
}
