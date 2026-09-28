package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class DispatchedTask<T> extends Task {

    /* renamed from: c, reason: collision with root package name */
    public int f54090c;

    public DispatchedTask(int i2) {
        this.f54090c = i2;
    }

    public abstract Continuation c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f54073a;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj;
    }

    public final void g(Throwable th) {
        CoroutineExceptionHandlerKt.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Continuation continuationC = c();
            Intrinsics.d(continuationC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuationC;
            ContinuationImpl continuationImpl = dispatchedContinuation.f55070e;
            Object obj = dispatchedContinuation.f55072g;
            CoroutineContext context = continuationImpl.getContext();
            Object objC = ThreadContextKt.c(context, obj);
            Job job = null;
            UndispatchedCoroutine undispatchedCoroutineC = objC != ThreadContextKt.f55109a ? CoroutineContextKt.c(continuationImpl, context, objC) : null;
            try {
                CoroutineContext context2 = continuationImpl.getContext();
                Object objH = h();
                Throwable thD = d(objH);
                if (thD == null) {
                    int i2 = this.f54090c;
                    boolean z = true;
                    if (i2 != 1 && i2 != 2) {
                        z = false;
                    }
                    if (z) {
                        job = (Job) context2.get(Job.Key.f54121a);
                    }
                }
                if (job != null && !job.a()) {
                    CancellationException cancellationExceptionO = job.O();
                    b(cancellationExceptionO);
                    Result.Companion companion = Result.f53538b;
                    continuationImpl.resumeWith(ResultKt.a(cancellationExceptionO));
                } else if (thD != null) {
                    Result.Companion companion2 = Result.f53538b;
                    continuationImpl.resumeWith(ResultKt.a(thD));
                } else {
                    Result.Companion companion3 = Result.f53538b;
                    continuationImpl.resumeWith(e(objH));
                }
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
        } catch (Throwable th2) {
            g(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }
}
