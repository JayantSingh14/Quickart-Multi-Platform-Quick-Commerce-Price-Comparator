package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: classes.dex */
class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean Q(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.f54036c, th);
        return true;
    }
}
