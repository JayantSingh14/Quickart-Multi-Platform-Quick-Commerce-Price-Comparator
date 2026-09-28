package okhttp3.internal.http2;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.RealBufferedSink;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Http2Writer implements Closeable, AutoCloseable {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f56751f = Logger.getLogger(Http2.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSink f56752a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56753b;

    /* renamed from: c, reason: collision with root package name */
    public int f56754c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f56755d;

    /* renamed from: e, reason: collision with root package name */
    public final Hpack.Writer f56756e;

    @Metadata
    public static final class Companion {
    }

    public Http2Writer(RealBufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f56752a = sink;
        Buffer buffer = new Buffer();
        this.f56753b = buffer;
        this.f56754c = 16384;
        this.f56756e = new Hpack.Writer(buffer);
    }

    public final synchronized void a(Settings peerSettings) {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (this.f56755d) {
                throw new IOException("closed");
            }
            int i2 = this.f56754c;
            int i3 = peerSettings.f56764a;
            if ((i3 & 32) != 0) {
                i2 = peerSettings.f56765b[5];
            }
            this.f56754c = i2;
            if (((i3 & 2) != 0 ? peerSettings.f56765b[1] : -1) != -1) {
                Hpack.Writer writer = this.f56756e;
                int i4 = (i3 & 2) != 0 ? peerSettings.f56765b[1] : -1;
                writer.getClass();
                int iMin = Math.min(i4, 16384);
                int i5 = writer.f56648d;
                if (i5 != iMin) {
                    if (iMin < i5) {
                        writer.f56646b = Math.min(writer.f56646b, iMin);
                    }
                    writer.f56647c = true;
                    writer.f56648d = iMin;
                    int i6 = writer.f56652h;
                    if (iMin < i6) {
                        if (iMin == 0) {
                            Header[] headerArr = writer.f56649e;
                            ArraysKt.q(headerArr, null, 0, headerArr.length);
                            writer.f56650f = writer.f56649e.length - 1;
                            writer.f56651g = 0;
                            writer.f56652h = 0;
                        } else {
                            writer.a(i6 - iMin);
                        }
                    }
                }
            }
            c(0, 0, 4, 1);
            this.f56752a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(boolean z, int i2, Buffer buffer, int i3) {
        if (this.f56755d) {
            throw new IOException("closed");
        }
        c(i2, i3, 0, z ? 1 : 0);
        if (i3 > 0) {
            Intrinsics.c(buffer);
            this.f56752a.write(buffer, i3);
        }
    }

    public final void c(int i2, int i3, int i4, int i5) {
        Level level = Level.FINE;
        Logger logger = f56751f;
        if (logger.isLoggable(level)) {
            logger.fine(Http2.a(false, i2, i3, i4, i5));
        }
        if (i3 > this.f56754c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f56754c + ": " + i3).toString());
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            throw new IllegalArgumentException(b.f(i2, "reserved bit set: ").toString());
        }
        byte[] bArr = Util.f56394a;
        RealBufferedSink realBufferedSink = this.f56752a;
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        realBufferedSink.writeByte((i3 >>> 16) & 255);
        realBufferedSink.writeByte((i3 >>> 8) & 255);
        realBufferedSink.writeByte(i3 & 255);
        realBufferedSink.writeByte(i4 & 255);
        realBufferedSink.writeByte(i5 & 255);
        realBufferedSink.b(i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f56755d = true;
        this.f56752a.close();
    }

    public final synchronized void e(int i2, ErrorCode errorCode, byte[] debugData) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (this.f56755d) {
            throw new IOException("closed");
        }
        if (errorCode.f56626a == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        c(0, debugData.length + 8, 7, 0);
        this.f56752a.b(i2);
        this.f56752a.b(errorCode.f56626a);
        if (debugData.length != 0) {
            this.f56752a.write(debugData);
        }
        this.f56752a.flush();
    }

    public final synchronized void flush() {
        if (this.f56755d) {
            throw new IOException("closed");
        }
        this.f56752a.flush();
    }

    public final synchronized void l(boolean z, int i2, ArrayList headerBlock) {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.f56755d) {
            throw new IOException("closed");
        }
        this.f56756e.d(headerBlock);
        long j2 = this.f56753b.f56914b;
        long jMin = Math.min(this.f56754c, j2);
        int i3 = j2 == jMin ? 4 : 0;
        if (z) {
            i3 |= 1;
        }
        c(i2, (int) jMin, 1, i3);
        this.f56752a.write(this.f56753b, jMin);
        if (j2 > jMin) {
            long j3 = j2 - jMin;
            while (j3 > 0) {
                long jMin2 = Math.min(this.f56754c, j3);
                j3 -= jMin2;
                c(i2, (int) jMin2, 9, j3 == 0 ? 4 : 0);
                this.f56752a.write(this.f56753b, jMin2);
            }
        }
    }

    public final synchronized void r(int i2, int i3, boolean z) {
        if (this.f56755d) {
            throw new IOException("closed");
        }
        c(0, 8, 6, z ? 1 : 0);
        this.f56752a.b(i2);
        this.f56752a.b(i3);
        this.f56752a.flush();
    }

    public final synchronized void s(int i2, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f56755d) {
            throw new IOException("closed");
        }
        if (errorCode.f56626a == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        c(i2, 4, 3, 0);
        this.f56752a.b(errorCode.f56626a);
        this.f56752a.flush();
    }

    public final synchronized void x(int i2, long j2) {
        if (this.f56755d) {
            throw new IOException("closed");
        }
        if (j2 == 0 || j2 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
        }
        c(i2, 4, 8, 0);
        this.f56752a.b((int) j2);
        this.f56752a.flush();
    }
}
