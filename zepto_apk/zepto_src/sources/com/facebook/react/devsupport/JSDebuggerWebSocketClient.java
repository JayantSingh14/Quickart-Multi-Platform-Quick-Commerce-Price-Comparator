package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes3.dex */
public class JSDebuggerWebSocketClient extends WebSocketListener {

    /* renamed from: a, reason: collision with root package name */
    public WebSocket f18850a;

    /* renamed from: b, reason: collision with root package name */
    public OkHttpClient f18851b;

    /* renamed from: c, reason: collision with root package name */
    public JSDebuggerCallback f18852c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f18853d = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f18854e = new ConcurrentHashMap();

    public interface JSDebuggerCallback {
        void onFailure(Exception exc);

        void onSuccess(String str);
    }

    @Override // okhttp3.WebSocketListener
    public final void a(RealWebSocket realWebSocket, int i2, String str) {
        this.f18850a = null;
    }

    @Override // okhttp3.WebSocketListener
    public final void d(RealWebSocket realWebSocket, Exception exc, Response response) {
        h("Websocket exception", exc);
    }

    @Override // okhttp3.WebSocketListener
    public final void e(String str, RealWebSocket realWebSocket) throws IOException {
        Integer numValueOf = null;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.beginObject();
            String strNextString = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (JsonToken.NULL == jsonReader.peek()) {
                    jsonReader.skipValue();
                } else if ("replyID".equals(strNextName)) {
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                } else if ("result".equals(strNextName)) {
                    strNextString = jsonReader.nextString();
                } else if ("error".equals(strNextName)) {
                    String strNextString2 = jsonReader.nextString();
                    h(strNextString2, new JavascriptException(strNextString2));
                }
            }
            if (numValueOf != null) {
                ConcurrentHashMap concurrentHashMap = this.f18854e;
                JSDebuggerCallback jSDebuggerCallback = (JSDebuggerCallback) concurrentHashMap.get(numValueOf);
                if (jSDebuggerCallback != null) {
                    concurrentHashMap.remove(numValueOf);
                    jSDebuggerCallback.onSuccess(strNextString);
                }
            }
        } catch (IOException e2) {
            if (numValueOf != null) {
                k(numValueOf.intValue(), e2);
            } else {
                h("Parsing response message from websocket failed", e2);
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public final void g(WebSocket webSocket, Response response) {
        this.f18850a = webSocket;
        JSDebuggerCallback jSDebuggerCallback = this.f18852c;
        Assertions.c(jSDebuggerCallback);
        jSDebuggerCallback.onSuccess(null);
        this.f18852c = null;
    }

    public final void h(String str, Exception exc) {
        FLog.h("JSDebuggerWebSocketClient", "Error occurred, shutting down websocket connection: ".concat(str), exc);
        i();
        JSDebuggerCallback jSDebuggerCallback = this.f18852c;
        if (jSDebuggerCallback != null) {
            ((WebsocketJavaScriptExecutor.AnonymousClass2) jSDebuggerCallback).onFailure(exc);
            this.f18852c = null;
        }
        ConcurrentHashMap concurrentHashMap = this.f18854e;
        Iterator it = concurrentHashMap.values().iterator();
        while (it.hasNext()) {
            ((JSDebuggerCallback) it.next()).onFailure(exc);
        }
        concurrentHashMap.clear();
    }

    public final void i() {
        WebSocket webSocket = this.f18850a;
        if (webSocket != null) {
            try {
                webSocket.c(1000, "End of session");
            } catch (Exception unused) {
            }
            this.f18850a = null;
        }
    }

    public final void j(int i2, String str) {
        WebSocket webSocket = this.f18850a;
        if (webSocket == null) {
            k(i2, new IllegalStateException("WebSocket connection no longer valid"));
            return;
        }
        try {
            webSocket.b(str);
        } catch (Exception e2) {
            k(i2, e2);
        }
    }

    public final void k(int i2, Exception exc) {
        ConcurrentHashMap concurrentHashMap = this.f18854e;
        JSDebuggerCallback jSDebuggerCallback = (JSDebuggerCallback) concurrentHashMap.get(Integer.valueOf(i2));
        if (jSDebuggerCallback != null) {
            concurrentHashMap.remove(Integer.valueOf(i2));
            jSDebuggerCallback.onFailure(exc);
        }
    }
}
