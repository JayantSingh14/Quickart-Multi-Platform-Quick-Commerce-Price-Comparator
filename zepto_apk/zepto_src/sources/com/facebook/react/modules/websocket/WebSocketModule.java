package com.facebook.react.modules.websocket;

import android.support.v4.media.b;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.CustomClientBuilder;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = "WebSocketModule")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WebSocketModule extends NativeWebSocketModuleSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "WebSocketModule";

    @Nullable
    private static CustomClientBuilder customClientBuilder;

    @NotNull
    private final Map<Integer, ContentHandler> contentHandlers;

    @NotNull
    private final ForwardingCookieHandler cookieHandler;

    @NotNull
    private final Map<Integer, WebSocket> webSocketConnections;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final void a(Companion companion, OkHttpClient.Builder builder) {
            companion.getClass();
            CustomClientBuilder customClientBuilder = WebSocketModule.customClientBuilder;
            if (customClientBuilder != null) {
                customClientBuilder.apply();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.String b(com.facebook.react.modules.websocket.WebSocketModule.Companion r5, java.lang.String r6) {
            /*
                r5.getClass()
                java.net.URI r5 = new java.net.URI     // Catch: java.net.URISyntaxException -> L91
                r5.<init>(r6)     // Catch: java.net.URISyntaxException -> L91
                java.lang.String r0 = r5.getScheme()     // Catch: java.net.URISyntaxException -> L91
                if (r0 == 0) goto L50
                int r1 = r0.hashCode()     // Catch: java.net.URISyntaxException -> L91
                r2 = 3804(0xedc, float:5.33E-42)
                java.lang.String r3 = "http"
                if (r1 == r2) goto L48
                r2 = 118039(0x1cd17, float:1.65408E-40)
                java.lang.String r4 = "https"
                if (r1 == r2) goto L3d
                r2 = 3213448(0x310888, float:4.503E-39)
                if (r1 == r2) goto L31
                r2 = 99617003(0x5f008eb, float:2.2572767E-35)
                if (r1 == r2) goto L2a
                goto L50
            L2a:
                boolean r0 = r0.equals(r4)     // Catch: java.net.URISyntaxException -> L91
                if (r0 != 0) goto L38
                goto L50
            L31:
                boolean r0 = r0.equals(r3)     // Catch: java.net.URISyntaxException -> L91
                if (r0 != 0) goto L38
                goto L50
            L38:
                java.lang.String r3 = r5.getScheme()     // Catch: java.net.URISyntaxException -> L91
                goto L52
            L3d:
                java.lang.String r1 = "wss"
                boolean r0 = r0.equals(r1)     // Catch: java.net.URISyntaxException -> L91
                if (r0 != 0) goto L46
                goto L50
            L46:
                r3 = r4
                goto L52
            L48:
                java.lang.String r1 = "ws"
                boolean r0 = r0.equals(r1)     // Catch: java.net.URISyntaxException -> L91
                if (r0 != 0) goto L52
            L50:
                java.lang.String r3 = ""
            L52:
                int r0 = r5.getPort()     // Catch: java.net.URISyntaxException -> L91
                r1 = -1
                java.lang.String r2 = "format(...)"
                if (r0 == r1) goto L7a
                java.lang.String r0 = "%s://%s:%s"
                java.lang.String r1 = r5.getHost()     // Catch: java.net.URISyntaxException -> L91
                int r5 = r5.getPort()     // Catch: java.net.URISyntaxException -> L91
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.net.URISyntaxException -> L91
                java.lang.Object[] r5 = new java.lang.Object[]{r3, r1, r5}     // Catch: java.net.URISyntaxException -> L91
                r1 = 3
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)     // Catch: java.net.URISyntaxException -> L91
                java.lang.String r5 = java.lang.String.format(r0, r5)     // Catch: java.net.URISyntaxException -> L91
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)     // Catch: java.net.URISyntaxException -> L91
                return r5
            L7a:
                java.lang.String r0 = "%s://%s"
                java.lang.String r5 = r5.getHost()     // Catch: java.net.URISyntaxException -> L91
                java.lang.Object[] r5 = new java.lang.Object[]{r3, r5}     // Catch: java.net.URISyntaxException -> L91
                r1 = 2
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)     // Catch: java.net.URISyntaxException -> L91
                java.lang.String r5 = java.lang.String.format(r0, r5)     // Catch: java.net.URISyntaxException -> L91
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)     // Catch: java.net.URISyntaxException -> L91
                return r5
            L91:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Unable to set "
                java.lang.String r1 = " as default origin header"
                java.lang.String r6 = android.support.v4.media.b.D(r0, r6, r1)
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.Companion.b(com.facebook.react.modules.websocket.WebSocketModule$Companion, java.lang.String):java.lang.String");
        }

        public static void c(CustomClientBuilder customClientBuilder) {
            WebSocketModule.customClientBuilder = customClientBuilder;
        }
    }

    @Metadata
    public interface ContentHandler {
        void a(ByteString byteString, WritableMap writableMap);

        void b(String str, WritableMap writableMap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webSocketConnections = new ConcurrentHashMap();
        this.contentHandlers = new ConcurrentHashMap();
        this.cookieHandler = new ForwardingCookieHandler();
    }

    private final String getCookie(String str) {
        try {
            List list = (List) this.cookieHandler.get(new URI(Companion.b(Companion, str)), new HashMap()).get("Cookie");
            List list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                return (String) list.get(0);
            }
            return null;
        } catch (IOException unused) {
            throw new IllegalArgumentException(b.C("Unable to get cookie from ", str));
        } catch (URISyntaxException unused2) {
            throw new IllegalArgumentException(b.C("Unable to get cookie from ", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyWebSocketFailed(int i2, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str);
        sendEvent("websocketFailed", writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(str, writableMap);
        }
    }

    @JvmStatic
    public static final void setCustomClientBuilder(@Nullable CustomClientBuilder customClientBuilder2) {
        Companion.getClass();
        Companion.c(customClientBuilder2);
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void close(double d2, @Nullable String str, double d3) {
        int i2 = (int) d3;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            return;
        }
        try {
            webSocket.c((int) d2, str);
            this.webSocketConnections.remove(Integer.valueOf(i2));
            this.contentHandlers.remove(Integer.valueOf(i2));
        } catch (Exception e2) {
            FLog.h("ReactNative", "Could not close WebSocket connection for id " + i2, e2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void connect(@NotNull String url, @Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap, double d2) {
        boolean z;
        Intrinsics.checkNotNullParameter(url, "url");
        final int i2 = (int) d2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.b(10L, timeUnit);
        builder.d(10L, timeUnit);
        builder.c(0L, TimeUnit.MINUTES);
        Companion.a(Companion, builder);
        OkHttpClient okHttpClient = new OkHttpClient(builder);
        Request.Builder builder2 = new Request.Builder();
        builder2.h(Object.class, Integer.valueOf(i2));
        builder2.i(url);
        String cookie = getCookie(url);
        if (cookie != null) {
            builder2.a("Cookie", cookie);
        }
        if (readableMap != null && readableMap.hasKey("headers") && readableMap.getType("headers") == ReadableType.Map) {
            ReadableMap map = readableMap.getMap("headers");
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            z = false;
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                if (ReadableType.String == map.getType(strNextKey)) {
                    if (StringsKt.t(strNextKey, "origin", true)) {
                        z = true;
                    }
                    String string = map.getString(strNextKey);
                    if (string == null) {
                        throw new IllegalStateException(b.D("value for name ", strNextKey, " == null").toString());
                    }
                    builder2.a(strNextKey, string);
                } else {
                    FLog.q("ReactNative", "Ignoring: requested " + strNextKey + ", value not a string");
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            builder2.a("origin", Companion.b(Companion, url));
        }
        if (readableArray != null && readableArray.size() > 0) {
            StringBuilder sb = new StringBuilder("");
            int size = readableArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                String string2 = readableArray.getString(i3);
                String string3 = string2 != null ? StringsKt.b0(string2).toString() : null;
                if (!(string3 == null || string3.length() == 0) && !StringsKt.n(string3, ",", false)) {
                    sb.append(string3);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                String string4 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                builder2.a("Sec-WebSocket-Protocol", string4);
            }
        }
        okHttpClient.b(builder2.b(), new WebSocketListener() { // from class: com.facebook.react.modules.websocket.WebSocketModule.connect.2
            @Override // okhttp3.WebSocketListener
            public final void a(RealWebSocket webSocket, int i4, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
                writableMapCreateMap.putInt("code", i4);
                writableMapCreateMap.putString("reason", reason);
                WebSocketModule.this.sendEvent("websocketClosed", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public final void c(RealWebSocket websocket, int i4, String reason) {
                Intrinsics.checkNotNullParameter(websocket, "websocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                websocket.c(i4, reason);
            }

            @Override // okhttp3.WebSocketListener
            public final void d(RealWebSocket webSocket, Exception t, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(t, "t");
                WebSocketModule.this.notifyWebSocketFailed(i2, t.getMessage());
            }

            @Override // okhttp3.WebSocketListener
            public final void e(String text, RealWebSocket webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(text, "text");
                WritableMap writableMapCreateMap = Arguments.createMap();
                int i4 = i2;
                writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i4);
                writableMapCreateMap.putString("type", "text");
                WebSocketModule webSocketModule = WebSocketModule.this;
                ContentHandler contentHandler = (ContentHandler) webSocketModule.contentHandlers.get(Integer.valueOf(i4));
                if (contentHandler != null) {
                    contentHandler.b(text, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString("data", text);
                }
                webSocketModule.sendEvent("websocketMessage", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public final void f(RealWebSocket webSocket, ByteString bytes) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                WritableMap writableMapCreateMap = Arguments.createMap();
                int i4 = i2;
                writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i4);
                writableMapCreateMap.putString("type", "binary");
                WebSocketModule webSocketModule = WebSocketModule.this;
                ContentHandler contentHandler = (ContentHandler) webSocketModule.contentHandlers.get(Integer.valueOf(i4));
                if (contentHandler != null) {
                    contentHandler.a(bytes, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString("data", bytes.a());
                }
                webSocketModule.sendEvent("websocketMessage", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public final void g(WebSocket webSocket, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(response, "response");
                WebSocketModule webSocketModule = WebSocketModule.this;
                Map map2 = webSocketModule.webSocketConnections;
                int i4 = i2;
                map2.put(Integer.valueOf(i4), webSocket);
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i4);
                writableMapCreateMap.putString("protocol", response.b("Sec-WebSocket-Protocol", ""));
                webSocketModule.sendEvent("websocketOpen", writableMapCreateMap);
            }
        });
        ((ThreadPoolExecutor) okHttpClient.f56297a.a()).shutdown();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        Iterator<WebSocket> it = this.webSocketConnections.values().iterator();
        while (it.hasNext()) {
            it.next().c(DateUtils.SEMI_MONTH, null);
        }
        this.webSocketConnections.clear();
        this.contentHandlers.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void ping(double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i2));
        if (webSocket != null) {
            try {
                webSocket.a(ByteString.f56924d);
                return;
            } catch (Exception e2) {
                notifyWebSocketFailed(i2, e2.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap2.putInt("code", 0);
        writableMapCreateMap2.putString("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i2));
        this.contentHandlers.remove(Integer.valueOf(i2));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void send(@NotNull String message, double d2) {
        Intrinsics.checkNotNullParameter(message, "message");
        int i2 = (int) d2;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i2));
        if (webSocket != null) {
            try {
                webSocket.b(message);
                return;
            } catch (Exception e2) {
                notifyWebSocketFailed(i2, e2.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap2.putInt("code", 0);
        writableMapCreateMap2.putString("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i2));
        this.contentHandlers.remove(Integer.valueOf(i2));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void sendBinary(@NotNull String string, double d2) {
        Intrinsics.checkNotNullParameter(string, "base64String");
        int i2 = (int) d2;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i2));
        if (webSocket != null) {
            try {
                ByteString byteString = ByteString.f56924d;
                Intrinsics.checkNotNullParameter(string, "string");
                ByteString byteStringA = ByteString.Companion.a(string);
                if (byteStringA == null) {
                    throw new IllegalStateException("bytes == null");
                }
                webSocket.a(byteStringA);
                return;
            } catch (Exception e2) {
                notifyWebSocketFailed(i2, e2.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
        writableMapCreateMap2.putInt("code", 0);
        writableMapCreateMap2.putString("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i2));
        this.contentHandlers.remove(Integer.valueOf(i2));
    }

    public final void setContentHandler(int i2, @Nullable ContentHandler contentHandler) {
        if (contentHandler == null) {
            this.contentHandlers.remove(Integer.valueOf(i2));
        } else {
            this.contentHandlers.put(Integer.valueOf(i2), contentHandler);
        }
    }

    public final void sendBinary(@NotNull ByteString byteString, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            writableMapCreateMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
            writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "client is null");
            sendEvent("websocketFailed", writableMapCreateMap);
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, i2);
            writableMapCreateMap2.putInt("code", 0);
            writableMapCreateMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", writableMapCreateMap2);
            this.webSocketConnections.remove(Integer.valueOf(i2));
            this.contentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.a(byteString);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }
}
