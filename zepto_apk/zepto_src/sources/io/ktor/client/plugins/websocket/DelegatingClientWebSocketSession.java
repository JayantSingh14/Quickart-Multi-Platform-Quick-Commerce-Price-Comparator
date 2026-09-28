package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
/* loaded from: classes3.dex */
public final class DelegatingClientWebSocketSession implements ClientWebSocketSession, WebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebSocketSession f49972a;

    public DelegatingClientWebSocketSession(HttpClientCall call, WebSocketSession session) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(session, "session");
        this.f49972a = session;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return this.f49972a.A();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        return this.f49972a.D0();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        return this.f49972a.Z();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object c1(Frame.Close close, Continuation continuation) {
        return this.f49972a.c1(close, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object n0(Continuation continuation) {
        return this.f49972a.n0(continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49972a.r();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        this.f49972a.y0(j2);
    }
}
