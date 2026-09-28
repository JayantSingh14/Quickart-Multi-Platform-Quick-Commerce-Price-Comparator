package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
/* loaded from: classes3.dex */
public final class RawWebSocketCommon implements WebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public long f51485a;

    @Metadata
    public static final class FlushRequest {
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        return this.f51485a;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        return null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object c1(Frame.Close close, Continuation continuation) {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.websocket.RawWebSocketCommon$flush$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = (io.ktor.websocket.RawWebSocketCommon$flush$1) r0
            int r1 = r0.f51488c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51488c = r1
            goto L1a
        L13:
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = new io.ktor.websocket.RawWebSocketCommon$flush$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r6 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r6
            r0.<init>(r5, r6)
        L1a:
            java.lang.Object r6 = r0.f51486a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f51488c
            r2 = 0
            if (r1 == 0) goto L46
            r3 = 1
            r4 = 3
            if (r1 == r3) goto L3e
            r3 = 2
            if (r1 == r3) goto L3a
            if (r1 != r4) goto L32
            kotlin.ResultKt.b(r6)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            kotlin.ResultKt.b(r6)
            goto L41
        L3e:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L44 kotlinx.coroutines.channels.ClosedSendChannelException -> L45
        L41:
            r0.f51488c = r4
            throw r2
        L44:
            throw r2
        L45:
            throw r2
        L46:
            kotlin.ResultKt.b(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.n0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return null;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        this.f51485a = j2;
    }
}
