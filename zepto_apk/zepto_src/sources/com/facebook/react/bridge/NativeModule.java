package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.zeptoconsumerapp.BuildConfig;
import javax.annotation.Nonnull;

@DoNotStrip
/* loaded from: classes.dex */
public interface NativeModule {
    default boolean canOverrideExistingModule() {
        return false;
    }

    @Nonnull
    String getName();

    void initialize();

    void invalidate();

    @Deprecated(forRemoval = BuildConfig.IS_HERMES_ENABLED, since = "Use invalidate method instead")
    default void onCatalystInstanceDestroy() {
    }
}
