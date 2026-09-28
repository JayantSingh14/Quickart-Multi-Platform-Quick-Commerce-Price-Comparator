package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: classes.dex */
public final class CoroutineScopeKt {
    public static final ContextScope a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.f54121a) == null) {
            coroutineContext = coroutineContext.plus(JobKt.a());
        }
        return new ContextScope(coroutineContext);
    }

    public static final void b(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.r().get(Job.Key.f54121a);
        if (job != null) {
            job.e(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
        }
    }

    public static final Object c(Function2 function2, Continuation frame) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(frame, frame.getContext());
        Object objA = UndispatchedKt.a(scopeCoroutine, scopeCoroutine, function2);
        if (objA == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objA;
    }
}
