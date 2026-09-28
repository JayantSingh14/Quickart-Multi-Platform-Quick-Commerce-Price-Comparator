package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {453, 456}, m = "doSelectSuspend")
/* loaded from: classes.dex */
final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SelectImplementation f55198a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f55199b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SelectImplementation f55200c;

    /* renamed from: d, reason: collision with root package name */
    public int f55201d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$doSelectSuspend$1(SelectImplementation selectImplementation, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f55200c = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f55199b = obj;
        this.f55201d |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SelectImplementation.f55183f;
        return this.f55200c.h(this);
    }
}
