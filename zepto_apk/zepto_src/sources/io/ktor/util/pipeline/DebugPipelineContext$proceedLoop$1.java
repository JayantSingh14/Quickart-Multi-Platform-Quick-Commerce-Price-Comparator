package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", l = {80}, m = "proceedLoop")
/* loaded from: classes3.dex */
final class DebugPipelineContext$proceedLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DebugPipelineContext f50573a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50574b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DebugPipelineContext f50575c;

    /* renamed from: d, reason: collision with root package name */
    public int f50576d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext$proceedLoop$1(DebugPipelineContext debugPipelineContext, Continuation continuation) {
        super(continuation);
        this.f50575c = debugPipelineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50574b = obj;
        this.f50576d |= Integer.MIN_VALUE;
        return this.f50575c.g(this);
    }
}
