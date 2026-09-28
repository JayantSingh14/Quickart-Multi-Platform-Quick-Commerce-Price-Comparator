package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface AppRegistry extends JavaScriptModule {
    void runApplication(@NotNull String str, @NotNull WritableMap writableMap);

    void startHeadlessTask(int i2, @NotNull String str, @NotNull WritableMap writableMap);

    void unmountApplicationComponentAtRootTag(int i2);
}
