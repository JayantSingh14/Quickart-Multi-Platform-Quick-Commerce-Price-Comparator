package com.facebook.common.closeables;

import com.brentvatne.common.react.r;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class AutoCloseableDelegate<T extends Closeable> extends AutoCleanupDelegate<T> {
    public AutoCloseableDelegate() {
        r cleanupFunction = AutoCleanupDelegateKt.f17067a;
        Intrinsics.checkNotNullParameter(cleanupFunction, "cleanupFunction");
    }
}
