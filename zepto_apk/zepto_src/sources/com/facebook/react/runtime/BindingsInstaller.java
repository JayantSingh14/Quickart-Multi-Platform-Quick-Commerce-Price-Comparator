package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public abstract class BindingsInstaller {

    @NotNull
    private static final Companion Companion = new Companion();

    @DoNotStrip
    @Nullable
    private final HybridData mHybridData;

    @Metadata
    public static final class Companion {
    }

    static {
        SoLoader.m("rninstance");
    }

    public BindingsInstaller(@Nullable HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
