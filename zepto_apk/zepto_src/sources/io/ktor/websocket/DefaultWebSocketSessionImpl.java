package io.ktor.websocket;

import com.google.android.gms.common.api.Api;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.Unconfined;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public final WebSocketSession f51392a;

    /* renamed from: b, reason: collision with root package name */
    public final CompletableDeferred f51393b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferedChannel f51394c;

    @NotNull
    private volatile /* synthetic */ int closed;

    /* renamed from: d, reason: collision with root package name */
    public final BufferedChannel f51395d;

    /* renamed from: e, reason: collision with root package name */
    public final JobImpl f51396e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f51397f;

    /* renamed from: g, reason: collision with root package name */
    public final CoroutineContext f51398g;

    /* renamed from: h, reason: collision with root package name */
    public final long f51399h;

    /* renamed from: i, reason: collision with root package name */
    public final long f51400i;

    /* renamed from: j, reason: collision with root package name */
    public final Deferred f51401j;

    @NotNull
    volatile /* synthetic */ Object pinger;

    @NotNull
    private volatile /* synthetic */ int started;
    public static final Frame.Pong n = new Frame.Pong(new byte[0], NonDisposableHandle.f51460a);

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51389k = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51390l = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51391m = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");

    @Metadata
    public static final class Companion {
    }

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long j2, long j3) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.f51392a = raw;
        this.pinger = null;
        CompletableDeferred completableDeferredA = CompletableDeferredKt.a();
        this.f51393b = completableDeferredA;
        this.f51394c = ChannelKt.a(8, null, 6);
        String property = System.getProperty("io.ktor.websocket.outgoingChannelCapacity");
        this.f51395d = ChannelKt.a(property != null ? Integer.parseInt(property) : 8, null, 6);
        this.closed = 0;
        JobImpl jobImpl = new JobImpl((Job) raw.r().get(Job.Key.f54121a));
        this.f51396e = jobImpl;
        this.f51397f = new ArrayList();
        this.started = 0;
        this.f51398g = raw.r().plus(jobImpl).plus(new CoroutineName("ws-default"));
        this.f51399h = j2;
        this.f51400i = j3;
        this.f51401j = completableDeferredA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.websocket.DefaultWebSocketSessionImpl r8, io.ktor.utils.io.core.BytePacketBuilder r9, io.ktor.websocket.Frame r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws io.ktor.websocket.FrameTooBigException {
        /*
            r8.getClass()
            boolean r0 = r11 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            if (r0 == 0) goto L16
            r0 = r11
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1) r0
            int r1 = r0.f51405d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f51405d = r1
            goto L1b
        L16:
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            r0.<init>(r8, r11)
        L1b:
            java.lang.Object r11 = r0.f51403b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51405d
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2e:
            int r8 = r0.f51402a
            kotlin.ResultKt.b(r11)
            goto L79
        L34:
            kotlin.ResultKt.b(r11)
            byte[] r10 = r10.f51442c
            int r10 = r10.length
            if (r9 == 0) goto L41
            int r11 = r9.A()
            goto L42
        L41:
            r11 = 0
        L42:
            int r10 = r10 + r11
            long r4 = (long) r10
            io.ktor.websocket.WebSocketSession r11 = r8.f51392a
            long r6 = r11.D0()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L80
            if (r9 == 0) goto L53
            r9.close()
        L53:
            io.ktor.websocket.CloseReason r9 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r2 = io.ktor.websocket.CloseReason.Codes.TOO_BIG
            java.lang.String r4 = "Frame is too big: "
            java.lang.String r5 = ". Max size is "
            java.lang.StringBuilder r4 = android.support.v4.media.b.u(r10, r4, r5)
            long r5 = r11.D0()
            r4.append(r5)
            java.lang.String r11 = r4.toString()
            r9.<init>(r2, r11)
            r0.f51402a = r10
            r0.f51405d = r3
            java.lang.Object r8 = io.ktor.websocket.WebSocketSessionKt.a(r8, r9, r0)
            if (r8 != r1) goto L78
            return r1
        L78:
            r8 = r10
        L79:
            io.ktor.websocket.FrameTooBigException r9 = new io.ktor.websocket.FrameTooBigException
            long r10 = (long) r8
            r9.<init>(r10)
            throw r9
        L80:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.a(io.ktor.websocket.DefaultWebSocketSessionImpl, io.ktor.utils.io.core.BytePacketBuilder, io.ktor.websocket.Frame, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        if (r2.e(r10, null, r0) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
    
        if (r6.o(r11, r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d8 -> B:14:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.websocket.DefaultWebSocketSessionImpl r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.c(io.ktor.websocket.DefaultWebSocketSessionImpl, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return this.f51394c;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        return this.f51392a.D0();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        return this.f51395d;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object c1(Frame.Close close, Continuation continuation) {
        Object objO = Z().o(close, continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objO != coroutineSingletons) {
            objO = Unit.f53572a;
        }
        return objO == coroutineSingletons ? objO : Unit.f53572a;
    }

    public final void d() {
        BufferedChannel bufferedChannelA;
        long j2 = this.f51399h;
        if (this.closed == 0 && j2 > 0) {
            SendChannel outgoing = this.f51392a.Z();
            long j3 = this.f51400i;
            DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 onTimeout = new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null);
            CoroutineName coroutineName = PingPongKt.f51461a;
            Intrinsics.checkNotNullParameter(this, "<this>");
            Intrinsics.checkNotNullParameter(outgoing, "outgoing");
            Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
            final JobImpl jobImplA = JobKt.a();
            bufferedChannelA = ChannelKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, 6);
            BuildersKt.c(this, CoroutineContext.Element.DefaultImpls.c(jobImplA, PingPongKt.f51462b), new PingPongKt$pinger$1(j2, j3, onTimeout, bufferedChannelA, outgoing, null), 2);
            CoroutineContext.Element element = this.f51398g.get(Job.Key.f54121a);
            Intrinsics.c(element);
            ((Job) element).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.websocket.PingPongKt$pinger$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    jobImplA.e(null);
                    return Unit.f53572a;
                }
            });
        } else {
            bufferedChannelA = null;
        }
        SendChannel sendChannel = (SendChannel) f51389k.getAndSet(this, bufferedChannelA);
        if (sendChannel != null) {
            sendChannel.d(null);
        }
        if (bufferedChannelA != null) {
            Object objI = bufferedChannelA.i(n);
            ChannelResult.Failed failed = ChannelResult.f54254b;
            boolean z = objI instanceof ChannelResult.Failed;
        }
        if (this.closed == 0 || bufferedChannelA == null) {
            return;
        }
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.IOException, java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(io.ktor.websocket.CloseReason r7, java.io.IOException r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1) r0
            int r1 = r0.f51434f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51434f = r1
            goto L18
        L13:
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f51432d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51434f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            io.ktor.websocket.CloseReason r7 = r0.f51431c
            java.lang.Throwable r8 = r0.f51430b
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r0.f51429a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2f
            goto La4
        L2f:
            r9 = move-exception
            goto Lb8
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.b(r9)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = io.ktor.websocket.DefaultWebSocketSessionImpl.f51390l
            boolean r9 = r9.compareAndSet(r6, r4, r3)
            if (r9 != 0) goto L48
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L48:
            org.slf4j.Logger r9 = io.ktor.websocket.DefaultWebSocketSessionKt.f51435a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Sending Close Sequence for session "
            r2.<init>(r5)
            r2.append(r6)
            java.lang.String r5 = " with reason "
            r2.append(r5)
            r2.append(r7)
            java.lang.String r5 = " and exception "
            r2.append(r5)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r9.r(r2)
            kotlinx.coroutines.JobImpl r9 = r6.f51396e
            r9.complete()
            if (r7 != 0) goto L7b
            io.ktor.websocket.CloseReason r7 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r9 = io.ktor.websocket.CloseReason.Codes.NORMAL
            java.lang.String r2 = ""
            r7.<init>(r9, r2)
        L7b:
            r6.d()     // Catch: java.lang.Throwable -> La0
            short r9 = r7.f51380a     // Catch: java.lang.Throwable -> La0
            java.util.LinkedHashMap r2 = io.ktor.websocket.CloseReason.Codes.f51382b     // Catch: java.lang.Throwable -> La0
            r2 = 1006(0x3ee, float:1.41E-42)
            if (r9 == r2) goto La3
            io.ktor.websocket.WebSocketSession r9 = r6.f51392a     // Catch: java.lang.Throwable -> La0
            kotlinx.coroutines.channels.SendChannel r9 = r9.Z()     // Catch: java.lang.Throwable -> La0
            io.ktor.websocket.Frame$Close r2 = new io.ktor.websocket.Frame$Close     // Catch: java.lang.Throwable -> La0
            r2.<init>(r7)     // Catch: java.lang.Throwable -> La0
            r0.f51429a = r6     // Catch: java.lang.Throwable -> La0
            r0.f51430b = r8     // Catch: java.lang.Throwable -> La0
            r0.f51431c = r7     // Catch: java.lang.Throwable -> La0
            r0.f51434f = r3     // Catch: java.lang.Throwable -> La0
            java.lang.Object r9 = r9.o(r2, r0)     // Catch: java.lang.Throwable -> La0
            if (r9 != r1) goto La3
            return r1
        La0:
            r9 = move-exception
            r0 = r6
            goto Lb8
        La3:
            r0 = r6
        La4:
            kotlinx.coroutines.CompletableDeferred r9 = r0.f51393b
            r9.r0(r7)
            if (r8 == 0) goto Lb5
            kotlinx.coroutines.channels.BufferedChannel r7 = r0.f51395d
            r7.s(r4, r8)
            kotlinx.coroutines.channels.BufferedChannel r7 = r0.f51394c
            r7.s(r4, r8)
        Lb5:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        Lb8:
            kotlinx.coroutines.CompletableDeferred r1 = r0.f51393b
            r1.r0(r7)
            if (r8 == 0) goto Lc9
            kotlinx.coroutines.channels.BufferedChannel r7 = r0.f51395d
            r7.s(r4, r8)
            kotlinx.coroutines.channels.BufferedChannel r7 = r0.f51394c
            r7.s(r4, r8)
        Lc9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.e(io.ktor.websocket.CloseReason, java.io.IOException, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object n0(Continuation continuation) {
        Object objN0 = this.f51392a.n0(continuation);
        return objN0 == CoroutineSingletons.f53689a ? objN0 : Unit.f53572a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f51398g;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public final void s1(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!f51391m.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        DefaultWebSocketSessionKt.f51435a.r("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.E(negotiatedExtensions, null, null, null, null, 63));
        this.f51397f.addAll(negotiatedExtensions);
        d();
        BufferedChannel outgoing = this.f51395d;
        CoroutineName coroutineName = PingPongKt.f51461a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(outgoing, "outgoing");
        BufferedChannel bufferedChannelA = ChannelKt.a(5, null, 6);
        BuildersKt.c(this, PingPongKt.f51461a, new PingPongKt$ponger$1(bufferedChannelA, outgoing, null), 2);
        CoroutineName coroutineName2 = DefaultWebSocketSessionKt.f51436b;
        Unconfined unconfined = Dispatchers.f54092b;
        BuildersKt.c(this, coroutineName2.plus(unconfined), new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this, bufferedChannelA, null), 2);
        BuildersKt.b(this, DefaultWebSocketSessionKt.f51437c.plus(unconfined), CoroutineStart.f54081d, new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this, null));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        this.f51392a.y0(j2);
    }
}
