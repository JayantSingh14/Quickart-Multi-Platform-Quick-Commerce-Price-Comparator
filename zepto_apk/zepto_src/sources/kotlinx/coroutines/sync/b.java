package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutexImpl f55259a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner f55260b;

    public /* synthetic */ b(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.f55259a = mutexImpl;
        this.f55260b = cancellableContinuationWithOwner;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f55260b.getClass();
        this.f55259a.b(null);
        return Unit.f53572a;
    }
}
