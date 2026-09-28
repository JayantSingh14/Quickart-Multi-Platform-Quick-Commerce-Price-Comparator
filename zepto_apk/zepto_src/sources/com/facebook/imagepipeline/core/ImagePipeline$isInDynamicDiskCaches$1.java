package com.facebook.imagepipeline.core;

import bolts.Continuation;
import bolts.Task;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class ImagePipeline$isInDynamicDiskCaches$1<TTaskResult, TContinuationResult> implements Continuation {
    @Override // bolts.Continuation
    public final Object a(Task task) {
        if ((task.g() || task.h() || !((Boolean) task.f()).booleanValue()) && task.g()) {
            return Task.d(Boolean.FALSE);
        }
        throw null;
    }
}
