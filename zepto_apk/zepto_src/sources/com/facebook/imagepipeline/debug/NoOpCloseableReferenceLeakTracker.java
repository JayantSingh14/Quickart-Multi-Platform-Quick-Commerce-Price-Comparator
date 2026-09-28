package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NoOpCloseableReferenceLeakTracker implements CloseableReferenceLeakTracker {
    @Override // com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker
    public final void a(SharedReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
    }
}
