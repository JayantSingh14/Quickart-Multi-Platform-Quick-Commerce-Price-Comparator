package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobSupport.SelectOnJoinCompletionHandler;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class JobSupport$onJoin$1 extends FunctionReferenceImpl implements Function3<JobSupport, SelectInstance<?>, Object, Unit> {

    /* renamed from: b, reason: collision with root package name */
    public static final JobSupport$onJoin$1 f54145b = new JobSupport$onJoin$1(3, JobSupport.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JobSupport jobSupport = (JobSupport) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.f54125a;
        jobSupport.getClass();
        while (true) {
            Object obj4 = JobSupport.f54125a.get(jobSupport);
            if (!(obj4 instanceof Incomplete)) {
                selectInstance.c(Unit.f53572a);
                break;
            }
            if (jobSupport.i0(obj4) >= 0) {
                selectInstance.d(JobKt.f(jobSupport, jobSupport.new SelectOnJoinCompletionHandler(selectInstance)));
                break;
            }
        }
        return Unit.f53572a;
    }
}
