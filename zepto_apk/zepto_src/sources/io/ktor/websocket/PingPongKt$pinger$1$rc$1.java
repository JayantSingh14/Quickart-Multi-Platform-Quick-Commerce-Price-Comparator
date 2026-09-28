package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", l = {75, 79}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f51473a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SendChannel f51474b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f51475c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f51476d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PingPongKt$pinger$1$rc$1(SendChannel sendChannel, String str, BufferedChannel bufferedChannel, Continuation continuation) {
        super(2, continuation);
        this.f51474b = sendChannel;
        this.f51475c = str;
        this.f51476d = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PingPongKt$pinger$1$rc$1(this.f51474b, this.f51475c, this.f51476d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PingPongKt$pinger$1$rc$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r9 == r0) goto L19;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:20:0x0063). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f51473a
            java.lang.String r2 = r8.f51475c
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1e
            if (r1 == r4) goto L1a
            if (r1 != r3) goto L12
            kotlin.ResultKt.b(r9)
            goto L63
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            kotlin.ResultKt.b(r9)
            goto L58
        L1e:
            kotlin.ResultKt.b(r9)
            org.slf4j.Logger r9 = io.ktor.websocket.DefaultWebSocketSessionKt.f51435a
            java.lang.String r1 = "WebSocket Pinger: sending ping frame"
            r9.r(r1)
            io.ktor.websocket.Frame$Ping r9 = new io.ktor.websocket.Frame$Ping
            java.nio.charset.Charset r1 = kotlin.text.Charsets.f53957b
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8
            boolean r5 = kotlin.jvm.internal.Intrinsics.b(r1, r5)
            if (r5 == 0) goto L39
            byte[] r1 = kotlin.text.StringsKt.q(r2)
            goto L4a
        L39:
            java.nio.charset.CharsetEncoder r1 = r1.newEncoder()
            java.lang.String r5 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            int r5 = r2.length()
            byte[] r1 = io.ktor.utils.io.charsets.CharsetJVMKt.c(r1, r2, r5)
        L4a:
            r9.<init>(r1)
            r8.f51473a = r4
            kotlinx.coroutines.channels.SendChannel r1 = r8.f51474b
            java.lang.Object r9 = r1.o(r9, r8)
            if (r9 != r0) goto L58
            goto L62
        L58:
            r8.f51473a = r3
            kotlinx.coroutines.channels.BufferedChannel r9 = r8.f51476d
            java.lang.Object r9 = r9.K(r8)
            if (r9 != r0) goto L63
        L62:
            return r0
        L63:
            io.ktor.websocket.Frame$Pong r9 = (io.ktor.websocket.Frame.Pong) r9
            byte[] r1 = r9.f51442c
            java.nio.charset.Charset r4 = kotlin.text.Charsets.f53957b
            int r5 = r1.length
            java.lang.String r6 = new java.lang.String
            r7 = 0
            r6.<init>(r1, r7, r5, r4)
            boolean r1 = r6.equals(r2)
            if (r1 == 0) goto L8c
            org.slf4j.Logger r0 = io.ktor.websocket.DefaultWebSocketSessionKt.f51435a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "WebSocket Pinger: received valid pong frame "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.r(r9)
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L8c:
            org.slf4j.Logger r1 = io.ktor.websocket.DefaultWebSocketSessionKt.f51435a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "WebSocket Pinger: received invalid pong frame "
            r4.<init>(r5)
            r4.append(r9)
            java.lang.String r9 = ", continue waiting"
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r1.r(r9)
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1$rc$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
