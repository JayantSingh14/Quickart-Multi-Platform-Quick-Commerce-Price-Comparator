package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineContext f54036c;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            S((Job) coroutineContext.get(Job.Key.f54121a));
        }
        this.f54036c = coroutineContext.plus(this);
    }

    public final void A0(CoroutineStart coroutineStart, AbstractCoroutine abstractCoroutine, Function2 function2) {
        Object objInvoke;
        int iOrdinal = coroutineStart.ordinal();
        if (iOrdinal == 0) {
            CancellableKt.b(function2, abstractCoroutine, this);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                Intrinsics.checkNotNullParameter(function2, "<this>");
                Intrinsics.checkNotNullParameter(this, "completion");
                Continuation continuationB = IntrinsicsKt.b(IntrinsicsKt.a(abstractCoroutine, this, function2));
                Result.Companion companion = Result.f53538b;
                continuationB.resumeWith(Unit.f53572a);
                return;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullParameter(this, "completion");
            try {
                CoroutineContext coroutineContext = this.f54036c;
                Object objC = ThreadContextKt.c(coroutineContext, null);
                try {
                    Intrinsics.checkNotNullParameter(this, "frame");
                    if (function2 instanceof BaseContinuationImpl) {
                        TypeIntrinsics.b(2, function2);
                        objInvoke = function2.invoke(abstractCoroutine, this);
                    } else {
                        objInvoke = IntrinsicsKt.c(function2, abstractCoroutine, this);
                    }
                    ThreadContextKt.a(coroutineContext, objC);
                    if (objInvoke != CoroutineSingletons.f53689a) {
                        Result.Companion companion2 = Result.f53538b;
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    ThreadContextKt.a(coroutineContext, objC);
                    throw th;
                }
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.f53538b;
                resumeWith(ResultKt.a(th2));
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String B() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void R(CompletionHandlerException completionHandlerException) {
        CoroutineExceptionHandlerKt.a(this.f54036c, completionHandlerException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void f0(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            x0(obj);
            return;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        w0(CompletedExceptionally.f54072b.get(completedExceptionally) != 0, completedExceptionally.f54073a);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f54036c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f54036c;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            obj = new CompletedExceptionally(false, thA);
        }
        Object objA0 = a0(obj);
        if (objA0 == JobSupportKt.f54147b) {
            return;
        }
        u(objA0);
    }

    public void x0(Object obj) {
    }

    public void w0(boolean z, Throwable th) {
    }
}
