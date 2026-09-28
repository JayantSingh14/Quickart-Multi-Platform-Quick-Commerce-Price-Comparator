package com.facebook.imagepipeline.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {

    /* renamed from: c, reason: collision with root package name */
    public RepeatedPostprocessorRunner f18346c;

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public final synchronized void b(RepeatedPostprocessorRunner runner) {
        Intrinsics.checkNotNullParameter(runner, "runner");
        this.f18346c = runner;
    }
}
