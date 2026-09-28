package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection$newWebSocketStreams$1;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSocketReader implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSource f56863a;

    /* renamed from: b, reason: collision with root package name */
    public final RealWebSocket f56864b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56865c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f56866d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f56867e;

    /* renamed from: f, reason: collision with root package name */
    public int f56868f;

    /* renamed from: g, reason: collision with root package name */
    public long f56869g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f56870h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f56871i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f56872j;

    /* renamed from: k, reason: collision with root package name */
    public final Buffer f56873k;

    /* renamed from: l, reason: collision with root package name */
    public final Buffer f56874l;

    /* renamed from: m, reason: collision with root package name */
    public MessageInflater f56875m;
    public final byte[] n;

    @Metadata
    public interface FrameCallback {
    }

    public WebSocketReader(RealBufferedSource source, RealWebSocket frameCallback, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.f56863a = source;
        this.f56864b = frameCallback;
        this.f56865c = z;
        this.f56866d = z2;
        this.f56873k = new Buffer();
        this.f56874l = new Buffer();
        this.n = null;
    }

    public final void a() {
        String reason;
        short sZ0;
        RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        long j2 = this.f56869g;
        Buffer buffer = this.f56873k;
        if (j2 > 0) {
            this.f56863a.s(buffer, j2);
        }
        int i2 = this.f56868f;
        RealWebSocket realWebSocket = this.f56864b;
        switch (i2) {
            case 8:
                long j3 = buffer.f56914b;
                if (j3 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j3 != 0) {
                    sZ0 = buffer.z0();
                    reason = buffer.A1();
                    String strA = WebSocketProtocol.a(sZ0);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    reason = "";
                    sZ0 = 1005;
                }
                Intrinsics.checkNotNullParameter(reason, "reason");
                if (sZ0 == -1) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                synchronized (realWebSocket) {
                    try {
                        if (realWebSocket.s != -1) {
                            throw new IllegalStateException("already closed");
                        }
                        realWebSocket.s = sZ0;
                        realWebSocket.t = reason;
                        realConnection$newWebSocketStreams$1 = null;
                        if (realWebSocket.r && realWebSocket.p.isEmpty()) {
                            RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$12 = realWebSocket.n;
                            realWebSocket.n = null;
                            webSocketReader = realWebSocket.f56841j;
                            realWebSocket.f56841j = null;
                            webSocketWriter = realWebSocket.f56842k;
                            realWebSocket.f56842k = null;
                            realWebSocket.f56843l.f();
                            realConnection$newWebSocketStreams$1 = realConnection$newWebSocketStreams$12;
                        } else {
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    realWebSocket.f56833b.c(realWebSocket, sZ0, reason);
                    if (realConnection$newWebSocketStreams$1 != null) {
                        realWebSocket.f56833b.a(realWebSocket, sZ0, reason);
                    }
                    this.f56867e = true;
                    return;
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
            case 9:
                ByteString payload = buffer.s0(buffer.f56914b);
                synchronized (realWebSocket) {
                    try {
                        Intrinsics.checkNotNullParameter(payload, "payload");
                        if (!realWebSocket.u && (!realWebSocket.r || !realWebSocket.p.isEmpty())) {
                            realWebSocket.o.add(payload);
                            realWebSocket.i();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            case 10:
                ByteString payload2 = buffer.s0(buffer.f56914b);
                synchronized (realWebSocket) {
                    Intrinsics.checkNotNullParameter(payload2, "payload");
                    realWebSocket.w = false;
                }
                return;
            default:
                StringBuilder sb = new StringBuilder("Unknown control opcode: ");
                int i3 = this.f56868f;
                byte[] bArr = Util.f56394a;
                String hexString = Integer.toHexString(i3);
                Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
                sb.append(hexString);
                throw new ProtocolException(sb.toString());
        }
    }

    public final void b() {
        boolean z;
        if (this.f56867e) {
            throw new IOException("closed");
        }
        RealBufferedSource realBufferedSource = this.f56863a;
        long jH = realBufferedSource.f56984a.timeout().h();
        Source source = realBufferedSource.f56984a;
        source.timeout().b();
        try {
            byte bE = realBufferedSource.e();
            byte[] bArr = Util.f56394a;
            source.timeout().g(jH, TimeUnit.NANOSECONDS);
            int i2 = bE & 15;
            this.f56868f = i2;
            int i3 = 0;
            boolean z2 = (bE & 128) != 0;
            this.f56870h = z2;
            boolean z3 = (bE & 8) != 0;
            this.f56871i = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (bE & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.f56865c) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.f56872j = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((bE & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((bE & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte bE2 = realBufferedSource.e();
            boolean z5 = (bE2 & 128) != 0;
            if (z5) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j2 = bE2 & 127;
            this.f56869g = j2;
            Buffer buffer = realBufferedSource.f56985b;
            if (j2 == 126) {
                this.f56869g = realBufferedSource.O() & 65535;
            } else if (j2 == 127) {
                realBufferedSource.j0(8L);
                long jV0 = buffer.v0();
                this.f56869g = jV0;
                if (jV0 < 0) {
                    StringBuilder sb = new StringBuilder("Frame length 0x");
                    String hexString = Long.toHexString(this.f56869g);
                    Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
                    sb.append(hexString);
                    sb.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sb.toString());
                }
            }
            if (this.f56871i && this.f56869g > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (!z5) {
                return;
            }
            byte[] sink = this.n;
            Intrinsics.c(sink);
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                realBufferedSource.j0(sink.length);
                buffer.t0(sink);
            } catch (EOFException e2) {
                while (true) {
                    long j3 = buffer.f56914b;
                    if (j3 <= 0) {
                        throw e2;
                    }
                    int i4 = buffer.read(sink, i3, (int) j3);
                    if (i4 == -1) {
                        throw new AssertionError();
                    }
                    i3 += i4;
                }
            }
        } catch (Throwable th) {
            source.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        MessageInflater messageInflater = this.f56875m;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }
}
