package com.facebook.react.config;

import com.facebook.proguard.annotations.DoNotStripAny;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Deprecated
@DoNotStripAny
@Metadata
/* loaded from: classes.dex */
public final class ReactFeatureFlags {

    @NotNull
    public static final ReactFeatureFlags INSTANCE = new ReactFeatureFlags();

    @JvmField
    public static boolean dispatchPointerEvents;

    private ReactFeatureFlags() {
    }
}
