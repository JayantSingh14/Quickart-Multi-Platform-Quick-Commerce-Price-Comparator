package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", l = {236, 247, 247, 247, 240, 247, 247, 244, 247, 247}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$runOutgoingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f51426a;

    /* renamed from: b, reason: collision with root package name */
    public int f51427b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51428c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runOutgoingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation continuation) {
        super(2, continuation);
        this.f51428c = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this.f51428c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DefaultWebSocketSessionImpl$runOutgoingProcessor$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) != r0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) == r0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) != r0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) == r0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f7, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) != r0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0108, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r2.f51392a, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), r6) != r0) goto L57;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
