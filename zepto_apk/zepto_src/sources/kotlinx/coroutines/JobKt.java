package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes.dex */
public final class JobKt {
    public static JobImpl a() {
        return new JobImpl(null);
    }

    public static final void b(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key.f54121a);
        if (job != null) {
            job.e(cancellationException);
        }
    }

    public static final Object c(Job job, ContinuationImpl continuationImpl) {
        job.e(null);
        Object objT0 = job.T0(continuationImpl);
        return objT0 == CoroutineSingletons.f53689a ? objT0 : Unit.f53572a;
    }

    public static final void d(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.f54121a);
        if (job != null && !job.a()) {
            throw job.O();
        }
    }

    public static final Job e(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.f54121a);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static DisposableHandle f(Job job, JobNode jobNode) {
        return job instanceof JobSupport ? ((JobSupport) job).U(true, jobNode) : job.D(jobNode.l(), true, new JobKt__JobKt$invokeOnCompletion$1(jobNode));
    }
}
