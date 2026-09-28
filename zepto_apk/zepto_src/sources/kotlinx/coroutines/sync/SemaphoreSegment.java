package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Segment;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class SemaphoreSegment extends Segment<SemaphoreSegment> {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f55256e;

    public SemaphoreSegment(long j2, SemaphoreSegment semaphoreSegment, int i2) {
        super(j2, semaphoreSegment, i2);
        this.f55256e = new AtomicReferenceArray(SemaphoreKt.f55253f);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int g() {
        return SemaphoreKt.f55253f;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void h(int i2, CoroutineContext coroutineContext) {
        this.f55256e.set(i2, SemaphoreKt.f55252e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f55105c + ", hashCode=" + hashCode() + ']';
    }
}
