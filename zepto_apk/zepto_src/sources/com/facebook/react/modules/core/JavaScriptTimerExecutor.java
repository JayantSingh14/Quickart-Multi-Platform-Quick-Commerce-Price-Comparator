package com.facebook.react.modules.core;

import com.facebook.react.bridge.WritableArray;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface JavaScriptTimerExecutor {
    void callIdleCallbacks(double d2);

    void callTimers(WritableArray writableArray);

    void emitTimeDriftWarning(String str);
}
