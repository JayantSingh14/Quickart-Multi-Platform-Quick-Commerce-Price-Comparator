package io.ktor.websocket;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1", f = "DefaultWebSocketSession.kt", l = {301}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 extends SuspendLambda implements Function2<CloseReason, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f51423a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51424b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51425c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation continuation) {
        super(2, continuation);
        this.f51425c = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 = new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this.f51425c, continuation);
        defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1.f51424b = obj;
        return defaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1) create((CloseReason) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f51423a;
        if (i2 == 0) {
            ResultKt.b(obj);
            CloseReason closeReason = (CloseReason) this.f51424b;
            IOException iOException = new IOException("Ping timeout");
            this.f51423a = 1;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DefaultWebSocketSessionImpl.f51389k;
            if (this.f51425c.e(closeReason, iOException, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
