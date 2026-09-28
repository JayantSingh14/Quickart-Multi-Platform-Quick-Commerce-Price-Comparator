package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

@Deprecated
@ObsoleteCoroutinesApi
@Metadata
/* loaded from: classes3.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    /* renamed from: a, reason: collision with root package name */
    public final BroadcastChannelImpl f54419a = new BroadcastChannelImpl();

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean d(Throwable th) {
        return this.f54419a.d(null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void h(Function1 function1) {
        this.f54419a.h(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object i(Object obj) {
        return this.f54419a.i(obj);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object o(Object obj, Continuation continuation) {
        return this.f54419a.o(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean p() {
        throw null;
    }
}
