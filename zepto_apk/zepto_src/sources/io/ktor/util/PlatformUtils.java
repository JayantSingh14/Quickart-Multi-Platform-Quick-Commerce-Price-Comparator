package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PlatformUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f50503a;

    static {
        PlatformUtils platformUtils = new PlatformUtils();
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
        String property = System.getProperty("io.ktor.development");
        boolean z = false;
        if (property != null && Boolean.parseBoolean(property)) {
            z = true;
        }
        f50503a = z;
        Intrinsics.checkNotNullParameter(platformUtils, "<this>");
    }
}
