package okhttp3.internal.ws;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import androidx.work.impl.c;
import coil3.network.internal.UtilsKt;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.EventListener$Companion$NONE$1;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection$newWebSocketStreams$1;
import okhttp3.internal.ws.WebSocketReader;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.SegmentedByteString;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.time.DateUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final List x = CollectionsKt.H(Protocol.HTTP_1_1);

    /* renamed from: a, reason: collision with root package name */
    public final Request f56832a;

    /* renamed from: b, reason: collision with root package name */
    public final WebSocketListener f56833b;

    /* renamed from: c, reason: collision with root package name */
    public final Random f56834c;

    /* renamed from: d, reason: collision with root package name */
    public final long f56835d;

    /* renamed from: e, reason: collision with root package name */
    public WebSocketExtensions f56836e;

    /* renamed from: f, reason: collision with root package name */
    public final long f56837f;

    /* renamed from: g, reason: collision with root package name */
    public final String f56838g;

    /* renamed from: h, reason: collision with root package name */
    public RealCall f56839h;

    /* renamed from: i, reason: collision with root package name */
    public Task f56840i;

    /* renamed from: j, reason: collision with root package name */
    public WebSocketReader f56841j;

    /* renamed from: k, reason: collision with root package name */
    public WebSocketWriter f56842k;

    /* renamed from: l, reason: collision with root package name */
    public final TaskQueue f56843l;

    /* renamed from: m, reason: collision with root package name */
    public String f56844m;
    public RealConnection$newWebSocketStreams$1 n;
    public final ArrayDeque o;
    public final ArrayDeque p;
    public long q;
    public boolean r;
    public int s;
    public String t;
    public boolean u;
    public int v;
    public boolean w;

    @Metadata
    public static final class Close {

        /* renamed from: a, reason: collision with root package name */
        public final int f56848a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f56849b;

        public Close(ByteString byteString, int i2) {
            this.f56848a = i2;
            this.f56849b = byteString;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Message {

        /* renamed from: a, reason: collision with root package name */
        public final int f56850a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f56851b;

        public Message(ByteString data, int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f56850a = i2;
            this.f56851b = data;
        }
    }

    @Metadata
    public static abstract class Streams implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public final RealBufferedSource f56852a;

        /* renamed from: b, reason: collision with root package name */
        public final RealBufferedSink f56853b;

        public Streams(RealBufferedSource source, RealBufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.f56852a = source;
            this.f56853b = sink;
        }
    }

    @Metadata
    public final class WriterTask extends Task {
        public WriterTask() {
            super(b.r(new StringBuilder(), RealWebSocket.this.f56844m, " writer"), true);
        }

        @Override // okhttp3.internal.concurrent.Task
        public final long a() {
            RealWebSocket realWebSocket = RealWebSocket.this;
            try {
                return realWebSocket.k() ? 0L : -1L;
            } catch (IOException e2) {
                realWebSocket.f(e2, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long j2, long j3) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.f56832a = originalRequest;
        this.f56833b = listener;
        this.f56834c = random;
        this.f56835d = j2;
        this.f56836e = null;
        this.f56837f = j3;
        this.f56843l = taskRunner.e();
        this.o = new ArrayDeque();
        this.p = new ArrayDeque();
        this.s = -1;
        if (!UtilsKt.HTTP_METHOD_GET.equals(originalRequest.f56332b)) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.f56332b).toString());
        }
        ByteString byteString = ByteString.f56924d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.f53572a;
        this.f56838g = Base64.b(ByteString.Companion.d(SegmentedByteString.f56900b, bArr).f56925a);
    }

    @Override // okhttp3.WebSocket
    public final boolean a(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return j(bytes, 2);
    }

    @Override // okhttp3.WebSocket
    public final boolean b(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ByteString byteString = ByteString.f56924d;
        return j(ByteString.Companion.c(text), 1);
    }

    @Override // okhttp3.WebSocket
    public final boolean c(int i2, String str) {
        ByteString byteStringC;
        synchronized (this) {
            try {
                String strA = WebSocketProtocol.a(i2);
                if (strA != null) {
                    throw new IllegalArgumentException(strA.toString());
                }
                if (str != null) {
                    ByteString byteString = ByteString.f56924d;
                    byteStringC = ByteString.Companion.c(str);
                    if (byteStringC.f56925a.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                } else {
                    byteStringC = null;
                }
                if (!this.u && !this.r) {
                    this.r = true;
                    this.p.add(new Close(byteStringC, i2));
                    i();
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final void cancel() {
        RealCall realCall = this.f56839h;
        Intrinsics.c(realCall);
        realCall.cancel();
    }

    public final void d(Response response, Exchange exchange) throws ProtocolException {
        Intrinsics.checkNotNullParameter(response, "response");
        int i2 = response.f56353d;
        if (i2 != 101) {
            StringBuilder sb = new StringBuilder("Expected HTTP 101 response but was '");
            sb.append(i2);
            sb.append(' ');
            throw new ProtocolException(e.t(sb, response.f56352c, '\''));
        }
        String strB = response.b("Connection", null);
        if (!"Upgrade".equalsIgnoreCase(strB)) {
            throw new ProtocolException(e.l('\'', "Expected 'Connection' header value 'Upgrade' but was '", strB));
        }
        String strB2 = response.b("Upgrade", null);
        if (!"websocket".equalsIgnoreCase(strB2)) {
            throw new ProtocolException(e.l('\'', "Expected 'Upgrade' header value 'websocket' but was '", strB2));
        }
        String strB3 = response.b("Sec-WebSocket-Accept", null);
        ByteString byteString = ByteString.f56924d;
        String strB4 = Base64.b(ByteString.Companion.c(this.f56838g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c(MessageDigestAlgorithms.SHA_1).f56925a);
        if (strB4.equals(strB3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strB4 + "' but was '" + strB3 + '\'');
    }

    public final void e(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        Request request = this.f56832a;
        if (request.a("Sec-WebSocket-Extensions") != null) {
            f(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient.Builder builderC = client.c();
        EventListener$Companion$NONE$1 eventListener = EventListener.f56243a;
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        builderC.f56314e = new c(eventListener, 11);
        List protocols = x;
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        ArrayList arrayListF0 = CollectionsKt.f0(protocols);
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!arrayListF0.contains(protocol) && !arrayListF0.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayListF0).toString());
        }
        if (arrayListF0.contains(protocol) && arrayListF0.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayListF0).toString());
        }
        if (arrayListF0.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayListF0).toString());
        }
        if (arrayListF0.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayListF0.remove(Protocol.SPDY_3);
        if (!arrayListF0.equals(builderC.t)) {
            builderC.C = null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayListF0);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
        builderC.t = listUnmodifiableList;
        OkHttpClient okHttpClient = new OkHttpClient(builderC);
        Request.Builder builderB = request.b();
        builderB.d("Upgrade", "websocket");
        builderB.d("Connection", "Upgrade");
        builderB.d("Sec-WebSocket-Key", this.f56838g);
        builderB.d("Sec-WebSocket-Version", "13");
        builderB.d("Sec-WebSocket-Extensions", "permessage-deflate");
        final Request requestB = builderB.b();
        RealCall realCall = new RealCall(okHttpClient, requestB, true);
        this.f56839h = realCall;
        realCall.l0(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException e2) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e2, "e");
                this.f56855a.f(e2, null);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.f56362m;
                try {
                    this.f56855a.d(response, exchange);
                    RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1C = exchange.c();
                    Headers responseHeaders = response.f56355f;
                    Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                    int size = responseHeaders.size();
                    int i2 = 0;
                    int i3 = 0;
                    boolean z = false;
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = false;
                    Integer intOrNull = null;
                    Integer intOrNull2 = null;
                    while (i3 < size) {
                        if (StringsKt.t(responseHeaders.f(i3), "Sec-WebSocket-Extensions", true)) {
                            String strM = responseHeaders.m(i3);
                            int i4 = i2;
                            boolean z5 = true;
                            while (i4 < strM.length()) {
                                Headers headers = responseHeaders;
                                int iG = Util.g(strM, ',', i4, i2, 4);
                                int iF = Util.f(strM, ';', i4, iG);
                                String strA = Util.A(i4, iF, strM);
                                int i5 = iF + 1;
                                int i6 = size;
                                if (StringsKt.t(strA, "permessage-deflate", z5)) {
                                    if (z) {
                                        z4 = true;
                                    }
                                    while (true) {
                                        i4 = i5;
                                        while (i4 < iG) {
                                            int iF2 = Util.f(strM, ';', i4, iG);
                                            int iF3 = Util.f(strM, '=', i4, iF2);
                                            String strA2 = Util.A(i4, iF3, strM);
                                            String strH = iF3 < iF2 ? StringsKt.H(Util.A(iF3 + 1, iF2, strM), "\"") : null;
                                            i5 = iF2 + 1;
                                            if (StringsKt.t(strA2, "client_max_window_bits", true)) {
                                                if (intOrNull != null) {
                                                    z4 = true;
                                                }
                                                intOrNull = strH != null ? StringsKt.toIntOrNull(strH) : null;
                                                if (intOrNull != null) {
                                                    break;
                                                }
                                                i4 = i5;
                                                z4 = true;
                                            } else if (StringsKt.t(strA2, "client_no_context_takeover", true)) {
                                                z4 = strH != null ? true : z2 ? true : z4;
                                                i4 = i5;
                                                z2 = true;
                                            } else {
                                                if (StringsKt.t(strA2, "server_max_window_bits", true)) {
                                                    if (intOrNull2 != null) {
                                                        z4 = true;
                                                    }
                                                    intOrNull2 = strH != null ? StringsKt.toIntOrNull(strH) : null;
                                                    if (intOrNull2 != null) {
                                                        break;
                                                    }
                                                } else if (StringsKt.t(strA2, "server_no_context_takeover", true)) {
                                                    z4 = strH != null ? true : z3 ? true : z4;
                                                    i4 = i5;
                                                    z3 = true;
                                                }
                                                i4 = i5;
                                                z4 = true;
                                            }
                                        }
                                    }
                                    responseHeaders = headers;
                                    size = i6;
                                    i2 = 0;
                                    z = true;
                                } else {
                                    i4 = i5;
                                    responseHeaders = headers;
                                    size = i6;
                                    i2 = 0;
                                    z4 = true;
                                }
                                z5 = true;
                            }
                        }
                        i3++;
                        responseHeaders = responseHeaders;
                        size = size;
                        i2 = 0;
                    }
                    this.f56855a.f56836e = new WebSocketExtensions(z, intOrNull, z2, intOrNull2, z3, z4);
                    if (z4 || intOrNull != null || (intOrNull2 != null && !new IntRange(8, 15, 1).c1(intOrNull2.intValue()))) {
                        RealWebSocket realWebSocket = this.f56855a;
                        synchronized (realWebSocket) {
                            realWebSocket.p.clear();
                            realWebSocket.c(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        this.f56855a.g(Util.f56400g + " WebSocket " + requestB.f56331a.g(), realConnection$newWebSocketStreams$1C);
                        RealWebSocket realWebSocket2 = this.f56855a;
                        realWebSocket2.f56833b.g(realWebSocket2, response);
                        this.f56855a.h();
                    } catch (Exception e2) {
                        this.f56855a.f(e2, null);
                    }
                } catch (IOException e3) {
                    this.f56855a.f(e3, response);
                    Util.c(response);
                    if (exchange != null) {
                        exchange.a(-1L, true, true, null);
                    }
                }
            }
        });
    }

    public final void f(Exception e2, Response response) {
        Intrinsics.checkNotNullParameter(e2, "e");
        synchronized (this) {
            if (this.u) {
                return;
            }
            this.u = true;
            RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1 = this.n;
            this.n = null;
            WebSocketReader webSocketReader = this.f56841j;
            this.f56841j = null;
            WebSocketWriter webSocketWriter = this.f56842k;
            this.f56842k = null;
            this.f56843l.f();
            Unit unit = Unit.f53572a;
            try {
                this.f56833b.d(this, e2, response);
            } finally {
                if (realConnection$newWebSocketStreams$1 != null) {
                    Util.c(realConnection$newWebSocketStreams$1);
                }
                if (webSocketReader != null) {
                    Util.c(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.c(webSocketWriter);
                }
            }
        }
    }

    public final void g(String name, RealConnection$newWebSocketStreams$1 streams) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.f56836e;
        Intrinsics.c(webSocketExtensions);
        synchronized (this) {
            try {
                this.f56844m = name;
                this.n = streams;
                this.f56842k = new WebSocketWriter(streams.f56853b, this.f56834c, webSocketExtensions.f56857a, webSocketExtensions.f56859c, this.f56837f);
                this.f56840i = new WriterTask();
                long j2 = this.f56835d;
                if (j2 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j2);
                    final String str = name + " ping";
                    this.f56843l.c(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1
                        @Override // okhttp3.internal.concurrent.Task
                        public final long a() {
                            WebSocketWriter webSocketWriter;
                            RealWebSocket realWebSocket = this;
                            synchronized (realWebSocket) {
                                try {
                                    if (!realWebSocket.u && (webSocketWriter = realWebSocket.f56842k) != null) {
                                        int i2 = realWebSocket.w ? realWebSocket.v : -1;
                                        realWebSocket.v++;
                                        realWebSocket.w = true;
                                        Unit unit = Unit.f53572a;
                                        if (i2 != -1) {
                                            StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                                            sb.append(realWebSocket.f56835d);
                                            sb.append("ms (after ");
                                            realWebSocket.f(new SocketTimeoutException(b.o(sb, i2 - 1, " successful ping/pongs)")), null);
                                        } else {
                                            try {
                                                ByteString payload = ByteString.f56924d;
                                                Intrinsics.checkNotNullParameter(payload, "payload");
                                                webSocketWriter.a(payload, 9);
                                            } catch (IOException e2) {
                                                realWebSocket.f(e2, null);
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.p.isEmpty()) {
                    i();
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f56841j = new WebSocketReader(streams.f56852a, this, webSocketExtensions.f56857a, webSocketExtensions.f56861e);
    }

    public final void h() throws IOException {
        while (this.s == -1) {
            WebSocketReader webSocketReader = this.f56841j;
            Intrinsics.c(webSocketReader);
            webSocketReader.b();
            if (!webSocketReader.f56871i) {
                int i2 = webSocketReader.f56868f;
                if (i2 != 1 && i2 != 2) {
                    StringBuilder sb = new StringBuilder("Unknown opcode: ");
                    byte[] bArr = Util.f56394a;
                    String hexString = Integer.toHexString(i2);
                    Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
                    sb.append(hexString);
                    throw new ProtocolException(sb.toString());
                }
                while (!webSocketReader.f56867e) {
                    long j2 = webSocketReader.f56869g;
                    Buffer buffer = webSocketReader.f56874l;
                    if (j2 > 0) {
                        webSocketReader.f56863a.s(buffer, j2);
                    }
                    if (webSocketReader.f56870h) {
                        if (webSocketReader.f56872j) {
                            MessageInflater messageInflater = webSocketReader.f56875m;
                            if (messageInflater == null) {
                                messageInflater = new MessageInflater(webSocketReader.f56866d);
                                webSocketReader.f56875m = messageInflater;
                            }
                            Intrinsics.checkNotNullParameter(buffer, "buffer");
                            Buffer buffer2 = messageInflater.f56829b;
                            if (buffer2.f56914b != 0) {
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            Inflater inflater = messageInflater.f56830c;
                            if (messageInflater.f56828a) {
                                inflater.reset();
                            }
                            buffer2.g0(buffer);
                            buffer2.U1(org.xbill.DNS.Message.MAXLENGTH);
                            long bytesRead = inflater.getBytesRead() + buffer2.f56914b;
                            do {
                                messageInflater.f56831d.a(buffer, Long.MAX_VALUE);
                            } while (inflater.getBytesRead() < bytesRead);
                        }
                        RealWebSocket realWebSocket = webSocketReader.f56864b;
                        WebSocketListener webSocketListener = realWebSocket.f56833b;
                        if (i2 == 1) {
                            String text = buffer.A1();
                            Intrinsics.checkNotNullParameter(text, "text");
                            webSocketListener.e(text, realWebSocket);
                        } else {
                            ByteString bytes = buffer.s0(buffer.f56914b);
                            Intrinsics.checkNotNullParameter(bytes, "bytes");
                            webSocketListener.f(realWebSocket, bytes);
                        }
                    } else {
                        while (!webSocketReader.f56867e) {
                            webSocketReader.b();
                            if (!webSocketReader.f56871i) {
                                break;
                            } else {
                                webSocketReader.a();
                            }
                        }
                        if (webSocketReader.f56868f != 0) {
                            StringBuilder sb2 = new StringBuilder("Expected continuation opcode. Got: ");
                            int i3 = webSocketReader.f56868f;
                            byte[] bArr2 = Util.f56394a;
                            String hexString2 = Integer.toHexString(i3);
                            Intrinsics.checkNotNullExpressionValue(hexString2, "toHexString(this)");
                            sb2.append(hexString2);
                            throw new ProtocolException(sb2.toString());
                        }
                    }
                }
                throw new IOException("closed");
            }
            webSocketReader.a();
        }
    }

    public final void i() {
        byte[] bArr = Util.f56394a;
        Task task = this.f56840i;
        if (task != null) {
            this.f56843l.c(task, 0L);
        }
    }

    public final synchronized boolean j(ByteString byteString, int i2) {
        if (!this.u && !this.r) {
            if (this.q + byteString.d() > 16777216) {
                c(DateUtils.SEMI_MONTH, null);
                return false;
            }
            this.q += byteString.d();
            this.p.add(new Message(byteString, i2));
            i();
            return true;
        }
        return false;
    }

    public final boolean k() {
        String str;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        int i2;
        RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1;
        String strA;
        synchronized (this) {
            try {
                if (this.u) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.f56842k;
                Object objPoll = this.o.poll();
                Object obj = null;
                if (objPoll == null) {
                    Object objPoll2 = this.p.poll();
                    if (objPoll2 instanceof Close) {
                        i2 = this.s;
                        str = this.t;
                        if (i2 != -1) {
                            realConnection$newWebSocketStreams$1 = this.n;
                            this.n = null;
                            webSocketReader = this.f56841j;
                            this.f56841j = null;
                            webSocketWriter = this.f56842k;
                            this.f56842k = null;
                            this.f56843l.f();
                        } else {
                            ((Close) objPoll2).getClass();
                            TaskQueue taskQueue = this.f56843l;
                            final String str2 = this.f56844m + " cancel";
                            taskQueue.c(new Task(str2) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1
                                @Override // okhttp3.internal.concurrent.Task
                                public final long a() {
                                    this.cancel();
                                    return -1L;
                                }
                            }, TimeUnit.MILLISECONDS.toNanos(DateUtils.MILLIS_PER_MINUTE));
                            realConnection$newWebSocketStreams$1 = null;
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                    } else {
                        if (objPoll2 == null) {
                            return false;
                        }
                        str = null;
                        webSocketReader = null;
                        webSocketWriter = null;
                        i2 = -1;
                        realConnection$newWebSocketStreams$1 = null;
                    }
                    obj = objPoll2;
                } else {
                    str = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                    i2 = -1;
                    realConnection$newWebSocketStreams$1 = null;
                }
                Unit unit = Unit.f53572a;
                try {
                    if (objPoll != null) {
                        Intrinsics.c(webSocketWriter2);
                        ByteString payload = (ByteString) objPoll;
                        Intrinsics.checkNotNullParameter(payload, "payload");
                        webSocketWriter2.a(payload, 10);
                    } else if (obj instanceof Message) {
                        Message message = (Message) obj;
                        Intrinsics.c(webSocketWriter2);
                        webSocketWriter2.b(message.f56851b, message.f56850a);
                        synchronized (this) {
                            this.q -= message.f56851b.d();
                        }
                    } else {
                        if (!(obj instanceof Close)) {
                            throw new AssertionError();
                        }
                        Close close = (Close) obj;
                        Intrinsics.c(webSocketWriter2);
                        int i3 = close.f56848a;
                        ByteString byteString = close.f56849b;
                        ByteString byteStringS0 = ByteString.f56924d;
                        if (i3 != 0 || byteString != null) {
                            if (i3 != 0 && (strA = WebSocketProtocol.a(i3)) != null) {
                                throw new IllegalArgumentException(strA.toString());
                            }
                            Buffer buffer = new Buffer();
                            buffer.V1(i3);
                            if (byteString != null) {
                                buffer.s1(byteString);
                            }
                            byteStringS0 = buffer.s0(buffer.f56914b);
                        }
                        try {
                            webSocketWriter2.a(byteStringS0, 8);
                            if (realConnection$newWebSocketStreams$1 != null) {
                                WebSocketListener webSocketListener = this.f56833b;
                                Intrinsics.c(str);
                                webSocketListener.a(this, i2, str);
                            }
                        } finally {
                            webSocketWriter2.f56883h = true;
                        }
                    }
                    return true;
                } finally {
                    if (realConnection$newWebSocketStreams$1 != null) {
                        Util.c(realConnection$newWebSocketStreams$1);
                    }
                    if (webSocketReader != null) {
                        Util.c(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.c(webSocketWriter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
