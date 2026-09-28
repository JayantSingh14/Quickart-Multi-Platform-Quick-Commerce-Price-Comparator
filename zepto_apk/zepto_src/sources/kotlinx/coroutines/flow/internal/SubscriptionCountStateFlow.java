package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class SubscriptionCountStateFlow extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.f54878d;
            Intrinsics.c(objArr);
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.f54879e + ((int) ((n() + this.f54881g) - this.f54879e))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void v(int i2) {
        synchronized (this) {
            Object[] objArr = this.f54878d;
            Intrinsics.c(objArr);
            p(Integer.valueOf(((Number) objArr[((int) ((this.f54879e + ((int) ((n() + this.f54881g) - this.f54879e))) - 1)) & (objArr.length - 1)]).intValue() + i2));
        }
    }
}
