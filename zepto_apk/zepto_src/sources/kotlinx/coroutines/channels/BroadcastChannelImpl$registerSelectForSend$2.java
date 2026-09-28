package kotlinx.coroutines.channels;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", l = {240}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54189a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BroadcastChannelImpl f54190b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f54191c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SelectInstance f54192d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl broadcastChannelImpl, Object obj, SelectInstance selectInstance, Continuation continuation) {
        super(2, continuation);
        this.f54190b = broadcastChannelImpl;
        this.f54191c = obj;
        this.f54192d = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.f54190b, this.f54191c, this.f54192d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54189a;
        boolean z = true;
        BroadcastChannelImpl broadcastChannelImpl = this.f54190b;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                Object obj2 = this.f54191c;
                this.f54189a = 1;
                if (broadcastChannelImpl.o(obj2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Throwable th) {
            if (!broadcastChannelImpl.p() || (!(th instanceof ClosedSendChannelException) && broadcastChannelImpl.z() != th)) {
                throw th;
            }
            z = false;
        }
        ReentrantLock reentrantLock = broadcastChannelImpl.f54187l;
        SelectInstance selectInstance = this.f54192d;
        reentrantLock.lock();
        HashMap map = broadcastChannelImpl.o;
        try {
            map.put(selectInstance, z ? Unit.f53572a : BufferedChannelKt.f54246l);
            Intrinsics.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            Unit unit = Unit.f53572a;
            if (((SelectImplementation) selectInstance).m(broadcastChannelImpl, unit) != TrySelectDetailedResult.f55213b) {
                map.remove(selectInstance);
            }
            reentrantLock.unlock();
            return unit;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
