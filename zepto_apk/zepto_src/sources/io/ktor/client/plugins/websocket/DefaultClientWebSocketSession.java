package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultClientWebSocketSession implements ClientWebSocketSession, DefaultWebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSession f49971a;

    public DefaultClientWebSocketSession(HttpClientCall call, DefaultWebSocketSession delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f49971a = delegate;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return this.f49971a.A();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        return this.f49971a.D0();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        return this.f49971a.Z();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object c1(Frame.Close close, Continuation continuation) {
        return this.f49971a.c1(close, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object n0(Continuation continuation) {
        return this.f49971a.n0(continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49971a.r();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public final void s1(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        this.f49971a.s1(negotiatedExtensions);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        this.f49971a.y0(j2);
    }
}
