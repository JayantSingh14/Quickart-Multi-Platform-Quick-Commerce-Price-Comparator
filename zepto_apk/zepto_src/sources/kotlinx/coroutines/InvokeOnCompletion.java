package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
final class InvokeOnCompletion extends JobNode {

    /* renamed from: e, reason: collision with root package name */
    public final Function1 f54120e;

    public InvokeOnCompletion(Function1 function1) {
        this.f54120e = function1;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        this.f54120e.invoke(th);
    }
}
