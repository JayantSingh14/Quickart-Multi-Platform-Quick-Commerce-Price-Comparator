package com.smart.library.util.bspatch;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class BSPatchUtil {
    static {
        System.loadLibrary("bspatch");
    }

    @JvmStatic
    public static final native int bspatch(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
