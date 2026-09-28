package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<LazyActorCoroutine<?>, SelectInstance<?>, Object, Unit> {
    public LazyActorCoroutine$onSend$1() {
        super(3, LazyActorCoroutine.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LazyActorCoroutine lazyActorCoroutine = (LazyActorCoroutine) obj;
        int i2 = LazyActorCoroutine.f54421e;
        lazyActorCoroutine.g0();
        BufferedChannel bufferedChannel = lazyActorCoroutine.f54251d;
        bufferedChannel.getClass();
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.f54227b;
        TypeIntrinsics.b(3, bufferedChannel$onSend$1);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.f54228b;
        TypeIntrinsics.b(3, bufferedChannel$onSend$2);
        new SelectClause2Impl(bufferedChannel, bufferedChannel$onSend$1, bufferedChannel$onSend$2).a().invoke(lazyActorCoroutine, (SelectInstance) obj2, obj3);
        return Unit.f53572a;
    }
}
