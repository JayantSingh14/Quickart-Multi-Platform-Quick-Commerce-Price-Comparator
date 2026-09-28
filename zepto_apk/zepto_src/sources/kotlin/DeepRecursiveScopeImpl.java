package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {

    /* renamed from: a, reason: collision with root package name */
    public Function3 f53515a;

    /* renamed from: b, reason: collision with root package name */
    public Unit f53516b;

    /* renamed from: c, reason: collision with root package name */
    public Continuation f53517c;

    /* renamed from: d, reason: collision with root package name */
    public Object f53518d;

    @Override // kotlin.DeepRecursiveScope
    public final void a(Unit unit, Continuation frame) {
        this.f53517c = frame;
        this.f53516b = unit;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.f53685a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f53517c = null;
        this.f53518d = obj;
    }
}
