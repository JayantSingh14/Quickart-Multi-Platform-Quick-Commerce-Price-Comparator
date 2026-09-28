package com.zeptoconsumerapp.Startup;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.ContextScope;

@Metadata
/* loaded from: classes.dex */
public final class AppCoroutineManager {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f47544a;

    /* renamed from: b, reason: collision with root package name */
    public static ContextScope f47545b;

    /* renamed from: c, reason: collision with root package name */
    public static ContextScope f47546c;

    /* renamed from: d, reason: collision with root package name */
    public static ContextScope f47547d;

    public static void a(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ContextScope contextScope = f47546c;
        if (contextScope != null) {
            BuildersKt.c(contextScope, null, block, 3);
        }
    }
}
