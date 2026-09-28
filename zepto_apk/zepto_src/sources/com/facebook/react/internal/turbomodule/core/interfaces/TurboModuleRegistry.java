package com.facebook.react.internal.turbomodule.core.interfaces;

import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface TurboModuleRegistry {
    @NotNull
    List<String> getEagerInitModuleNames();

    @Nullable
    NativeModule getModule(@NotNull String str);

    @NotNull
    Collection<NativeModule> getModules();

    boolean hasModule(@NotNull String str);

    void invalidate();
}
