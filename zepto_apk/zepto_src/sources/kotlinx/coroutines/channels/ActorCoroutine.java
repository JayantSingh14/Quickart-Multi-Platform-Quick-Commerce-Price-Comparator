package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.ExceptionsKt;

@Metadata
/* loaded from: classes3.dex */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean Q(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.f54036c, th);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void e0(Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = ExceptionsKt.a(getClass().getSimpleName().concat(" was cancelled"), th);
            }
        }
        this.f54251d.r(cancellationExceptionA);
    }
}
