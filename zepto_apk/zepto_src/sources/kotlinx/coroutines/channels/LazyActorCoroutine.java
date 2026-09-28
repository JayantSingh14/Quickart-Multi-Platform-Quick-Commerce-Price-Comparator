package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: classes3.dex */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f54421e = 0;

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final boolean d(Throwable th) {
        boolean zD = super.d(th);
        start();
        return zD;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void g0() {
        CancellableKt.a(null, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final Object i(Object obj) {
        start();
        return super.i(obj);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final Object o(Object obj, Continuation continuation) {
        start();
        Object objO = super.o(obj, continuation);
        return objO == CoroutineSingletons.f53689a ? objO : Unit.f53572a;
    }
}
