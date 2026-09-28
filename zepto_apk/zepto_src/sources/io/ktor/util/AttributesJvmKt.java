package io.ktor.util;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class AttributesJvmKt {
    public static final Attributes a() {
        return new ConcurrentSafeAttributes();
    }
}
