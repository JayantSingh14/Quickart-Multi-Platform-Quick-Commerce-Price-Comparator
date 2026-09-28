package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@KtorDsl
@Metadata
/* loaded from: classes.dex */
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public final Object f50587a;

    public PipelineContext(Object context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f50587a = context;
    }

    public abstract Object a(Object obj, ContinuationImpl continuationImpl);

    public abstract void c();

    public abstract Object d();

    public abstract Object e(Continuation continuation);

    public abstract Object f(Object obj, Continuation continuation);
}
