package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {729}, m = "processResultAndInvokeBlockRecoveringException")
/* loaded from: classes3.dex */
final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f55202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectImplementation f55203b;

    /* renamed from: c, reason: collision with root package name */
    public int f55204c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation selectImplementation, Continuation continuation) {
        super(continuation);
        this.f55203b = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 selectImplementation$processResultAndInvokeBlockRecoveringException$1;
        this.f55202a = obj;
        this.f55204c |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SelectImplementation.f55183f;
        SelectImplementation selectImplementation = this.f55203b;
        selectImplementation.getClass();
        int i2 = this.f55204c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f55204c = i2 - Integer.MIN_VALUE;
            selectImplementation$processResultAndInvokeBlockRecoveringException$1 = this;
        } else {
            selectImplementation$processResultAndInvokeBlockRecoveringException$1 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(selectImplementation, this);
        }
        Object obj2 = selectImplementation$processResultAndInvokeBlockRecoveringException$1.f55202a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = selectImplementation$processResultAndInvokeBlockRecoveringException$1.f55204c;
        if (i3 == 0) {
            ResultKt.b(obj2);
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        return obj2;
    }
}
