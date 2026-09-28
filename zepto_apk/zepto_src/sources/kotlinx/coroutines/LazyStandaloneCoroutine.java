package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: classes3.dex */
final class LazyStandaloneCoroutine extends StandaloneCoroutine {

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f54153d;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, true, false);
        this.f54153d = IntrinsicsKt.a(this, this, function2);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void g0() {
        CancellableKt.a(this.f54153d, this);
    }
}
