package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.websocket.WebSocketException;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.channels.ActorKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OkHttpWebsocketSession extends WebSocketListener implements DefaultWebSocketSession {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f49422a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f49423b;

    /* renamed from: c, reason: collision with root package name */
    public final CompletableDeferred f49424c;

    /* renamed from: d, reason: collision with root package name */
    public final CompletableDeferred f49425d;

    /* renamed from: e, reason: collision with root package name */
    public final BufferedChannel f49426e;

    /* renamed from: f, reason: collision with root package name */
    public final CompletableDeferred f49427f;

    /* renamed from: g, reason: collision with root package name */
    public final SendChannel f49428g;

    public OkHttpWebsocketSession(OkHttpClient engine, OkHttpClient webSocketFactory, Request engineRequest, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(engineRequest, "engineRequest");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f49422a = webSocketFactory;
        this.f49423b = coroutineContext;
        this.f49424c = CompletableDeferredKt.a();
        this.f49425d = CompletableDeferredKt.a();
        this.f49426e = ChannelKt.a(0, null, 7);
        this.f49427f = CompletableDeferredKt.a();
        this.f49428g = ActorKt.a(this, new OkHttpWebsocketSession$outgoing$1(this, engineRequest, null));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final ReceiveChannel A() {
        return this.f49426e;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final long D0() {
        return Long.MAX_VALUE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final SendChannel Z() {
        return this.f49428g;
    }

    @Override // okhttp3.WebSocketListener
    public final void a(RealWebSocket webSocket, int i2, String reason) {
        Object objValueOf;
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.a(webSocket, i2, reason);
        short s = (short) i2;
        this.f49427f.r0(new CloseReason(reason, s));
        this.f49426e.d(null);
        SendChannel sendChannel = this.f49428g;
        StringBuilder sb = new StringBuilder("WebSocket session closed with code ");
        CloseReason.Codes codes = (CloseReason.Codes) CloseReason.Codes.f51382b.get(Short.valueOf(s));
        if (codes == null || (objValueOf = codes.toString()) == null) {
            objValueOf = Integer.valueOf(i2);
        }
        sb.append(objValueOf);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sendChannel.d(new CancellationException(sb.toString()));
    }

    @Override // okhttp3.WebSocketListener
    public final void c(RealWebSocket webSocket, int i2, String reason) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.c(webSocket, i2, reason);
        short s = (short) i2;
        this.f49427f.r0(new CloseReason(reason, s));
        try {
            ChannelsKt.c(this.f49428g, new Frame.Close(new CloseReason(reason, s)));
        } catch (Throwable unused) {
        }
        this.f49426e.d(null);
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

    @Override // okhttp3.WebSocketListener
    public final void d(RealWebSocket webSocket, Exception t, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(t, "t");
        super.d(webSocket, t, response);
        this.f49427f.c(t);
        this.f49425d.c(t);
        this.f49426e.s(false, t);
        this.f49428g.d(t);
    }

    @Override // okhttp3.WebSocketListener
    public final void e(String text, RealWebSocket webSocket) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(text, "text");
        super.e(text, webSocket);
        BufferedChannel bufferedChannel = this.f49426e;
        byte[] data = text.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
        Intrinsics.checkNotNullParameter(data, "data");
        ChannelsKt.c(bufferedChannel, new Frame.Text(true, data, false, false, false));
    }

    @Override // okhttp3.WebSocketListener
    public final void f(RealWebSocket webSocket, ByteString bytes) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        super.f(webSocket, bytes);
        BufferedChannel bufferedChannel = this.f49426e;
        byte[] data = bytes.y();
        Intrinsics.checkNotNullParameter(data, "data");
        ChannelsKt.c(bufferedChannel, new Frame.Binary(true, data, false, false, false));
    }

    @Override // okhttp3.WebSocketListener
    public final void g(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        super.g(webSocket, response);
        this.f49425d.r0(response);
    }

    public final CompletableDeferred h() {
        return this.f49425d;
    }

    public final void i() {
        this.f49424c.r0(this);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final Object n0(Continuation continuation) {
        return Unit.f53572a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49423b;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public final void s1(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!negotiatedExtensions.isEmpty()) {
            throw new IllegalArgumentException("Extensions are not supported.");
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    public final void y0(long j2) {
        throw new WebSocketException("Max frame size switch is not supported in OkHttp engine.");
    }
}
