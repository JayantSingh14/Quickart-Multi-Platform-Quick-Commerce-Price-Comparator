package com.facebook.react.runtime.hermes;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class HermesInstance extends JSRuntimeFactory {

    @Metadata
    public static final class Companion {
        @JvmStatic
        @DoNotStrip
        @NotNull
        public final HybridData initHybrid(boolean z) {
            return HermesInstance.initHybrid(z);
        }
    }

    static {
        SoLoader.m("hermesinstancejni");
    }

    public HermesInstance() {
        super(initHybrid(false));
    }

    @JvmStatic
    @DoNotStrip
    @NotNull
    public static final native HybridData initHybrid(boolean z);
}
