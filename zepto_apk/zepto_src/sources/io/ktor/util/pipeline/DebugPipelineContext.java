package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@KtorDsl
@Metadata
/* loaded from: classes3.dex */
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {

    /* renamed from: b, reason: collision with root package name */
    public final List f50569b;

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineContext f50570c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50571d;

    /* renamed from: e, reason: collision with root package name */
    public int f50572e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext(Object context, List interceptors, Object subject, CoroutineContext coroutineContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f50569b = interceptors;
        this.f50570c = coroutineContext;
        this.f50571d = subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object a(Object obj, ContinuationImpl continuationImpl) {
        this.f50572e = 0;
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f50571d = obj;
        return e(continuationImpl);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final void c() {
        this.f50572e = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object d() {
        return this.f50571d;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object e(Continuation continuation) {
        int i2 = this.f50572e;
        if (i2 < 0) {
            return this.f50571d;
        }
        if (i2 < this.f50569b.size()) {
            return g(continuation);
        }
        this.f50572e = -1;
        return this.f50571d;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object f(Object obj, Continuation continuation) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f50571d = obj;
        return e(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = (io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1) r0
            int r1 = r0.f50576d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50576d = r1
            goto L18
        L13:
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = new io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f50574b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50576d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.util.pipeline.DebugPipelineContext r2 = r0.f50573a
            kotlin.ResultKt.b(r8)
            goto L35
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            kotlin.ResultKt.b(r8)
            r2 = r7
        L35:
            int r8 = r2.f50572e
            r4 = -1
            if (r8 != r4) goto L3b
            goto L45
        L3b:
            java.util.List r5 = r2.f50569b
            int r6 = r5.size()
            if (r8 < r6) goto L48
            r2.f50572e = r4
        L45:
            java.lang.Object r8 = r2.f50571d
            return r8
        L48:
            java.lang.Object r4 = r5.get(r8)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r8 = r8 + 1
            r2.f50572e = r8
            java.lang.String r8 = "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }"
            kotlin.jvm.internal.Intrinsics.d(r4, r8)
            java.lang.Object r8 = r2.f50571d
            r0.f50573a = r2
            r0.f50576d = r3
            java.lang.Object r8 = r4.invoke(r2, r8, r0)
            if (r8 != r1) goto L35
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.DebugPipelineContext.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f50570c;
    }
}
