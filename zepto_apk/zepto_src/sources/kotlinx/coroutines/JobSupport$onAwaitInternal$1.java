package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobSupport.SelectOnAwaitCompletionHandler;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3<JobSupport, SelectInstance<?>, Object, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JobSupport jobSupport = (JobSupport) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.f54125a;
        jobSupport.getClass();
        while (true) {
            Object objA = JobSupport.f54125a.get(jobSupport);
            if (!(objA instanceof Incomplete)) {
                if (!(objA instanceof CompletedExceptionally)) {
                    objA = JobSupportKt.a(objA);
                }
                selectInstance.c(objA);
            } else if (jobSupport.i0(objA) >= 0) {
                selectInstance.d(JobKt.f(jobSupport, jobSupport.new SelectOnAwaitCompletionHandler(selectInstance)));
                break;
            }
        }
        return Unit.f53572a;
    }
}
