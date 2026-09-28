package com.facebook.react.devsupport;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public final class InspectorFlags {
    static {
        new InspectorFlags();
        DevSupportSoLoader.a();
    }

    private InspectorFlags() {
    }

    @JvmStatic
    @DoNotStrip
    public static final native boolean getFuseboxEnabled();

    @JvmStatic
    @DoNotStrip
    public static final native boolean getIsProfilingBuild();
}
