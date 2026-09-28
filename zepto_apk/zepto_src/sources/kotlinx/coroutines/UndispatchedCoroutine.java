package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal f54171e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(Continuation continuation, CoroutineContext coroutineContext) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.f54172a;
        super(continuation, coroutineContext.get(undispatchedMarker) == null ? coroutineContext.plus(undispatchedMarker) : coroutineContext);
        this.f54171e = new ThreadLocal();
        if (continuation.getContext().get(ContinuationInterceptor.y0) instanceof CoroutineDispatcher) {
            return;
        }
        Object objC = ThreadContextKt.c(coroutineContext, null);
        ThreadContextKt.a(coroutineContext, objC);
        C0(coroutineContext, objC);
    }

    public final boolean B0() {
        boolean z = this.threadLocalIsSet && this.f54171e.get() == null;
        this.f54171e.remove();
        return !z;
    }

    public final void C0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f54171e.set(new Pair(coroutineContext, obj));
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void u(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.f54171e.get();
            if (pair != null) {
                ThreadContextKt.a((CoroutineContext) pair.f53533a, pair.f53534b);
            }
            this.f54171e.remove();
        }
        Object objA = CompletionStateKt.a(obj);
        Continuation continuation = this.f55103d;
        CoroutineContext context = continuation.getContext();
        Object objC = ThreadContextKt.c(context, null);
        UndispatchedCoroutine undispatchedCoroutineC = objC != ThreadContextKt.f55109a ? CoroutineContextKt.c(continuation, context, objC) : null;
        try {
            this.f55103d.resumeWith(objA);
            Unit unit = Unit.f53572a;
            if (undispatchedCoroutineC == null || undispatchedCoroutineC.B0()) {
                ThreadContextKt.a(context, objC);
            }
        } catch (Throwable th) {
            if (undispatchedCoroutineC == null || undispatchedCoroutineC.B0()) {
                ThreadContextKt.a(context, objC);
            }
            throw th;
        }
    }
}
