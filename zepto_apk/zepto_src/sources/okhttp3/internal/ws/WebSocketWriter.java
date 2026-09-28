package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.RealBufferedSink;
import okio.Segment;
import okio.SegmentedByteString;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSink f56876a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f56877b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56878c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f56879d;

    /* renamed from: e, reason: collision with root package name */
    public final long f56880e;

    /* renamed from: f, reason: collision with root package name */
    public final Buffer f56881f;

    /* renamed from: g, reason: collision with root package name */
    public final Buffer f56882g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f56883h;

    /* renamed from: i, reason: collision with root package name */
    public MessageDeflater f56884i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f56885j;

    /* renamed from: k, reason: collision with root package name */
    public final Buffer.UnsafeCursor f56886k;

    public WebSocketWriter(RealBufferedSink sink, Random random, boolean z, boolean z2, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.f56876a = sink;
        this.f56877b = random;
        this.f56878c = z;
        this.f56879d = z2;
        this.f56880e = j2;
        this.f56881f = new Buffer();
        this.f56882g = sink.f56981b;
        this.f56885j = new byte[4];
        this.f56886k = new Buffer.UnsafeCursor();
    }

    public final void a(ByteString byteString, int i2) throws IOException {
        if (this.f56883h) {
            throw new IOException("closed");
        }
        int iD = byteString.d();
        if (iD > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        Buffer buffer = this.f56882g;
        buffer.O1(i2 | 128);
        buffer.O1(iD | 128);
        byte[] bArr = this.f56885j;
        Intrinsics.c(bArr);
        this.f56877b.nextBytes(bArr);
        buffer.w1(bArr);
        if (iD > 0) {
            long j2 = buffer.f56914b;
            buffer.s1(byteString);
            Buffer.UnsafeCursor unsafeCursor = this.f56886k;
            Intrinsics.c(unsafeCursor);
            buffer.j0(unsafeCursor);
            unsafeCursor.b(j2);
            WebSocketProtocol.b(unsafeCursor, bArr);
            unsafeCursor.close();
        }
        this.f56876a.flush();
    }

    public final void b(ByteString data, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.f56883h) {
            throw new IOException("closed");
        }
        Buffer buffer = this.f56881f;
        buffer.s1(data);
        int i3 = i2 | 128;
        if (this.f56878c && data.d() >= this.f56880e) {
            MessageDeflater messageDeflater = this.f56884i;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.f56879d);
                this.f56884i = messageDeflater;
            }
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Buffer buffer2 = messageDeflater.f56824b;
            if (buffer2.f56914b != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (messageDeflater.f56823a) {
                messageDeflater.f56825c.reset();
            }
            long j2 = buffer.f56914b;
            DeflaterSink deflaterSink = messageDeflater.f56826d;
            deflaterSink.write(buffer, j2);
            deflaterSink.flush();
            if (buffer2.V(buffer2.f56914b - r0.f56925a.length, MessageDeflaterKt.f56827a)) {
                long j3 = buffer2.f56914b - 4;
                Buffer.UnsafeCursor unsafeCursorJ0 = buffer2.j0(SegmentedByteString.f56899a);
                try {
                    unsafeCursorJ0.a(j3);
                    unsafeCursorJ0.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.a(unsafeCursorJ0, th);
                        throw th2;
                    }
                }
            } else {
                buffer2.O1(0);
            }
            buffer.write(buffer2, buffer2.f56914b);
            i3 = i2 | 192;
        }
        long j4 = buffer.f56914b;
        Buffer buffer3 = this.f56882g;
        buffer3.O1(i3);
        if (j4 <= 125) {
            buffer3.O1(((int) j4) | 128);
        } else if (j4 <= 65535) {
            buffer3.O1(254);
            buffer3.V1((int) j4);
        } else {
            buffer3.O1(255);
            Segment segmentO1 = buffer3.o1(8);
            int i4 = segmentO1.f56990c;
            byte[] bArr = segmentO1.f56988a;
            bArr[i4] = (byte) ((j4 >>> 56) & 255);
            bArr[i4 + 1] = (byte) ((j4 >>> 48) & 255);
            bArr[i4 + 2] = (byte) ((j4 >>> 40) & 255);
            bArr[i4 + 3] = (byte) ((j4 >>> 32) & 255);
            bArr[i4 + 4] = (byte) ((j4 >>> 24) & 255);
            bArr[i4 + 5] = (byte) ((j4 >>> 16) & 255);
            bArr[i4 + 6] = (byte) ((j4 >>> 8) & 255);
            bArr[i4 + 7] = (byte) (j4 & 255);
            segmentO1.f56990c = i4 + 8;
            buffer3.f56914b += 8;
        }
        byte[] bArr2 = this.f56885j;
        Intrinsics.c(bArr2);
        this.f56877b.nextBytes(bArr2);
        buffer3.w1(bArr2);
        if (j4 > 0) {
            Buffer.UnsafeCursor unsafeCursor = this.f56886k;
            Intrinsics.c(unsafeCursor);
            buffer.j0(unsafeCursor);
            unsafeCursor.b(0L);
            WebSocketProtocol.b(unsafeCursor, bArr2);
            unsafeCursor.close();
        }
        buffer3.write(buffer, j4);
        RealBufferedSink realBufferedSink = this.f56876a;
        if (realBufferedSink.f56982c) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer4 = realBufferedSink.f56981b;
        long j5 = buffer4.f56914b;
        if (j5 > 0) {
            realBufferedSink.f56980a.write(buffer4, j5);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        MessageDeflater messageDeflater = this.f56884i;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }
}
