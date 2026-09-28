package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", l = {64, WKSRecord.Service.NETRJS_3, WKSRecord.Service.SUPDUP}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class PingPongKt$pinger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Random f51463a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f51464b;

    /* renamed from: c, reason: collision with root package name */
    public int f51465c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f51466d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f51467e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function2 f51468f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f51469g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SendChannel f51470h;

    @Metadata
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", l = {WKSRecord.Protocol.RVD}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.PingPongKt$pinger$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f51471a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BufferedChannel f51472b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BufferedChannel bufferedChannel, Continuation continuation) {
            super(2, continuation);
            this.f51472b = bufferedChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f51472b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
            return CoroutineSingletons.f53689a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f51471a;
            if (i2 != 0 && i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            do {
                this.f51471a = 1;
            } while (this.f51472b.K(this) != coroutineSingletons);
            return coroutineSingletons;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PingPongKt$pinger$1(long j2, long j3, Function2 function2, BufferedChannel bufferedChannel, SendChannel sendChannel, Continuation continuation) {
        super(2, continuation);
        this.f51466d = j2;
        this.f51467e = j3;
        this.f51468f = function2;
        this.f51469g = bufferedChannel;
        this.f51470h = sendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BufferedChannel bufferedChannel = this.f51469g;
        return new PingPongKt$pinger$1(this.f51466d, this.f51467e, this.f51468f, bufferedChannel, this.f51470h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PingPongKt$pinger$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fa, code lost:
    
        if (((io.ktor.websocket.DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1) r1).invoke(r3, r19) == r2) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db A[Catch: CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00ff, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00ff, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00ff, TRY_LEAVE, TryCatch #0 {CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00ff, blocks: (B:7:0x0018, B:12:0x0029, B:12:0x0029, B:12:0x0029, B:31:0x00d7, B:31:0x00d7, B:31:0x00d7, B:33:0x00db, B:33:0x00db, B:33:0x00db, B:23:0x008c, B:23:0x008c, B:23:0x008c, B:27:0x00a0, B:27:0x00a0, B:27:0x00a0, B:15:0x0038, B:15:0x0038, B:15:0x0038), top: B:42:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Type inference failed for: r12v10, types: [kotlin.random.Random] */
    /* JADX WARN: Type inference failed for: r12v11, types: [kotlin.random.Random] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d2 -> B:31:0x00d7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
