package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata
/* loaded from: classes.dex */
final class ProducerCoroutine<E> extends ChannelCoroutine<E> implements ProducerScope<E> {
    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel b() {
        return this;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void w0(boolean z, Throwable th) {
        if (this.f54251d.s(false, th) || z) {
            return;
        }
        CoroutineExceptionHandlerKt.a(this.f54036c, th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0(Object obj) {
        this.f54251d.d(null);
    }
}
