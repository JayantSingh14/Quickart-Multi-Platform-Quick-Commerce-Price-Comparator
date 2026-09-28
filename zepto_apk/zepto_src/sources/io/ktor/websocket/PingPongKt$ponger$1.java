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
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", l = {WKSRecord.Service.NNTP, 32}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class PingPongKt$ponger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public SendChannel f51478a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f51479b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f51480c;

    /* renamed from: d, reason: collision with root package name */
    public int f51481d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f51482e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f51483f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PingPongKt$ponger$1(BufferedChannel bufferedChannel, BufferedChannel bufferedChannel2, Continuation continuation) {
        super(2, continuation);
        this.f51482e = bufferedChannel;
        this.f51483f = bufferedChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PingPongKt$ponger$1(this.f51482e, this.f51483f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PingPongKt$ponger$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r10 == r0) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[Catch: all -> 0x0017, TryCatch #1 {all -> 0x0017, blocks: (B:7:0x0012, B:19:0x0036, B:23:0x0048, B:25:0x0050, B:28:0x0075, B:14:0x0027, B:18:0x0032), top: B:39:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {all -> 0x0017, blocks: (B:7:0x0012, B:19:0x0036, B:23:0x0048, B:25:0x0050, B:28:0x0075, B:14:0x0027, B:18:0x0032), top: B:39:0x0006, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:8:0x0015). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r9.f51481d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlinx.coroutines.channels.ChannelIterator r1 = r9.f51480c
            kotlinx.coroutines.channels.ReceiveChannel r4 = r9.f51479b
            kotlinx.coroutines.channels.SendChannel r5 = r9.f51478a
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L17
        L15:
            r10 = r5
            goto L36
        L17:
            r10 = move-exception
            goto L7c
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L21:
            kotlinx.coroutines.channels.ChannelIterator r1 = r9.f51480c
            kotlinx.coroutines.channels.ReceiveChannel r4 = r9.f51479b
            kotlinx.coroutines.channels.SendChannel r5 = r9.f51478a
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L17
            goto L48
        L2b:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.channels.BufferedChannel r4 = r9.f51482e     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L82
            kotlinx.coroutines.channels.BufferedChannel r10 = r9.f51483f     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L82
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch: java.lang.Throwable -> L17
        L36:
            r9.f51478a = r10     // Catch: java.lang.Throwable -> L17
            r9.f51479b = r4     // Catch: java.lang.Throwable -> L17
            r9.f51480c = r1     // Catch: java.lang.Throwable -> L17
            r9.f51481d = r3     // Catch: java.lang.Throwable -> L17
            java.lang.Object r5 = r1.b(r9)     // Catch: java.lang.Throwable -> L17
            if (r5 != r0) goto L45
            goto L74
        L45:
            r8 = r5
            r5 = r10
            r10 = r8
        L48:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L17
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L17
            if (r10 == 0) goto L75
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L17
            io.ktor.websocket.Frame$Ping r10 = (io.ktor.websocket.Frame.Ping) r10     // Catch: java.lang.Throwable -> L17
            org.slf4j.Logger r6 = io.ktor.websocket.DefaultWebSocketSessionKt.f51435a     // Catch: java.lang.Throwable -> L17
            java.lang.String r7 = "Received ping message, sending pong message"
            r6.r(r7)     // Catch: java.lang.Throwable -> L17
            io.ktor.websocket.Frame$Pong r6 = new io.ktor.websocket.Frame$Pong     // Catch: java.lang.Throwable -> L17
            byte[] r10 = r10.f51442c     // Catch: java.lang.Throwable -> L17
            io.ktor.websocket.NonDisposableHandle r7 = io.ktor.websocket.NonDisposableHandle.f51460a     // Catch: java.lang.Throwable -> L17
            r6.<init>(r10, r7)     // Catch: java.lang.Throwable -> L17
            r9.f51478a = r5     // Catch: java.lang.Throwable -> L17
            r9.f51479b = r4     // Catch: java.lang.Throwable -> L17
            r9.f51480c = r1     // Catch: java.lang.Throwable -> L17
            r9.f51481d = r2     // Catch: java.lang.Throwable -> L17
            java.lang.Object r10 = r5.o(r6, r9)     // Catch: java.lang.Throwable -> L17
            if (r10 != r0) goto L15
        L74:
            return r0
        L75:
            kotlin.Unit r10 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L17
            r10 = 0
            r4.e(r10)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L82
            goto L82
        L7c:
            throw r10     // Catch: java.lang.Throwable -> L7d
        L7d:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r4, r10)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L82
            throw r0     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L82
        L82:
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$ponger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
