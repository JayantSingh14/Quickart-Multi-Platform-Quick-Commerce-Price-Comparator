package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class JSRuntimeFactory {

    @NotNull
    private static final Companion Companion = new Companion();

    @NotNull
    private final HybridData mHybridData;

    @Metadata
    public static final class Companion {
    }

    static {
        SoLoader.m("rninstance");
    }

    public JSRuntimeFactory(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }
}
