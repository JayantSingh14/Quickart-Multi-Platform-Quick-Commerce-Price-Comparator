package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NumbersKt {
    public static final void a(long j2, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        throw new IllegalArgumentException("Long value " + j2 + " of " + name + " doesn't fit into 32-bit integer");
    }
}
