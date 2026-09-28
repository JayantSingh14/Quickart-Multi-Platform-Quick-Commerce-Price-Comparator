package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes.dex */
final /* synthetic */ class SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, SemaphoreSegment, SemaphoreSegment> {

    /* renamed from: b, reason: collision with root package name */
    public static final SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 f55246b = new SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i2 = SemaphoreKt.f55248a;
        return new SemaphoreSegment(((Number) obj).longValue(), (SemaphoreSegment) obj2, 0);
    }
}
