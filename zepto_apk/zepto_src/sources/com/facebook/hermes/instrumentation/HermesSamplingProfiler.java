package com.facebook.hermes.instrumentation;

import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class HermesSamplingProfiler {
    static {
        SoLoader.m("jsijniprofiler");
    }

    @JvmStatic
    public static final native void disable();

    @JvmStatic
    public static final native void dumpSampledTraceToFile(@NotNull String str);

    @JvmStatic
    public static final native void enable();
}
