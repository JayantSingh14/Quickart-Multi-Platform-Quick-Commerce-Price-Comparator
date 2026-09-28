package com.facebook.react.turbomodule.core.interfaces;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class BindingsInstallerHolder {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    public BindingsInstallerHolder(@NotNull HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }
}
