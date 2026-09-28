package kotlinx.coroutines.internal;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        S1();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher O1() {
        return this;
    }

    public final void S1() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        S1();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        S1();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext coroutineContext) {
        S1();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        S1();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return e.l(']', "Dispatchers.Main[missing", "");
    }
}
