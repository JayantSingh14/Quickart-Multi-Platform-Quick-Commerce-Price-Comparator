package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class ReconnectingWebSocket extends WebSocketListener {

    /* renamed from: a, reason: collision with root package name */
    public final String f19212a;

    /* renamed from: c, reason: collision with root package name */
    public final OkHttpClient f19214c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19216e;

    /* renamed from: f, reason: collision with root package name */
    public WebSocket f19217f;

    /* renamed from: g, reason: collision with root package name */
    public JSPackagerClient f19218g;

    /* renamed from: h, reason: collision with root package name */
    public final ConnectionCallback f19219h;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19215d = false;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f19213b = new Handler(Looper.getMainLooper());

    public interface ConnectionCallback {
        void D();

        void a();
    }

    public interface MessageCallback {
    }

    public ReconnectingWebSocket(String str, JSPackagerClient jSPackagerClient, ConnectionCallback connectionCallback) {
        this.f19212a = str;
        this.f19218g = jSPackagerClient;
        this.f19219h = connectionCallback;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.b(10L, timeUnit);
        builder.d(10L, timeUnit);
        builder.c(0L, TimeUnit.MINUTES);
        this.f19214c = new OkHttpClient(builder);
    }

    @Override // okhttp3.WebSocketListener
    public final synchronized void a(RealWebSocket realWebSocket, int i2, String str) {
        try {
            this.f19217f = null;
            if (!this.f19215d) {
                ConnectionCallback connectionCallback = this.f19219h;
                if (connectionCallback != null) {
                    connectionCallback.D();
                }
                i();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okhttp3.WebSocketListener
    public final synchronized void d(RealWebSocket realWebSocket, Exception exc, Response response) {
        try {
            if (this.f19217f != null) {
                FLog.h("ReconnectingWebSocket", "Error occurred, shutting down websocket connection: Websocket exception", exc);
                WebSocket webSocket = this.f19217f;
                if (webSocket != null) {
                    try {
                        webSocket.c(1000, "End of session");
                    } catch (Exception unused) {
                    }
                    this.f19217f = null;
                }
            }
            if (!this.f19215d) {
                ConnectionCallback connectionCallback = this.f19219h;
                if (connectionCallback != null) {
                    connectionCallback.D();
                }
                i();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okhttp3.WebSocketListener
    public final synchronized void e(String str, RealWebSocket realWebSocket) {
        JSPackagerClient jSPackagerClient = this.f19218g;
        if (jSPackagerClient != null) {
            jSPackagerClient.b(str);
        }
    }

    @Override // okhttp3.WebSocketListener
    public final synchronized void f(RealWebSocket realWebSocket, ByteString byteString) {
        if (this.f19218g != null) {
            FLog.q("JSPackagerClient", "Websocket received message with payload of unexpected type binary");
        }
    }

    @Override // okhttp3.WebSocketListener
    public final synchronized void g(WebSocket webSocket, Response response) {
        this.f19217f = webSocket;
        this.f19216e = false;
        ConnectionCallback connectionCallback = this.f19219h;
        if (connectionCallback != null) {
            connectionCallback.a();
        }
    }

    public final void h() {
        if (this.f19215d) {
            throw new IllegalStateException("Can't connect closed client");
        }
        Request.Builder builder = new Request.Builder();
        builder.i(this.f19212a);
        this.f19214c.b(builder.b(), this);
    }

    public final void i() {
        if (this.f19215d) {
            throw new IllegalStateException("Can't reconnect closed client");
        }
        if (!this.f19216e) {
            FLog.q("ReconnectingWebSocket", "Couldn't connect to \"" + this.f19212a + "\", will silently retry");
            this.f19216e = true;
        }
        this.f19213b.postDelayed(new Runnable() { // from class: com.facebook.react.packagerconnection.ReconnectingWebSocket.1
            @Override // java.lang.Runnable
            public final void run() {
                ReconnectingWebSocket reconnectingWebSocket = ReconnectingWebSocket.this;
                synchronized (reconnectingWebSocket) {
                    if (!reconnectingWebSocket.f19215d) {
                        reconnectingWebSocket.h();
                    }
                }
            }
        }, 2000L);
    }

    public final synchronized void j(String str) {
        WebSocket webSocket = this.f19217f;
        if (webSocket == null) {
            throw new ClosedChannelException();
        }
        webSocket.b(str);
    }
}
