package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface CloseableReferenceLeakTracker {

    @Metadata
    /* loaded from: classes3.dex */
    public interface Listener {
    }

    void a(SharedReference sharedReference);
}
