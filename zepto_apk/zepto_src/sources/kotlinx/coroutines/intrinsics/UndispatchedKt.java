package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UndispatchedKt {
    public static final Object a(ScopeCoroutine scopeCoroutine, ScopeCoroutine scopeCoroutine2, Function2 function2) {
        Object completedExceptionally;
        Object objA0;
        try {
            TypeIntrinsics.b(2, function2);
            completedExceptionally = function2.invoke(scopeCoroutine2, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(false, th);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (completedExceptionally == coroutineSingletons || (objA0 = scopeCoroutine.a0(completedExceptionally)) == JobSupportKt.f54147b) {
            return coroutineSingletons;
        }
        if (objA0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objA0).f54073a;
        }
        return JobSupportKt.a(objA0);
    }
}
