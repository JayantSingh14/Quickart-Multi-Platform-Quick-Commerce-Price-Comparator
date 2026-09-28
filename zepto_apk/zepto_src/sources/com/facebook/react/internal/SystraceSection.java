package com.facebook.react.internal;

import androidx.tracing.Trace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SystraceSection implements AutoCloseable {
    public SystraceSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.b(sectionName);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        android.os.Trace.endSection();
    }
}
