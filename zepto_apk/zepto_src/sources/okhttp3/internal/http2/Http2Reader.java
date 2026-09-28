package okhttp3.internal.http2;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Http2Connection;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata
/* loaded from: classes.dex */
public final class Http2Reader implements Closeable, AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f56717d;

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSource f56718a;

    /* renamed from: b, reason: collision with root package name */
    public final ContinuationSource f56719b;

    /* renamed from: c, reason: collision with root package name */
    public final Hpack.Reader f56720c;

    @Metadata
    public static final class Companion {
        public static int a(int i2, int i3, int i4) throws IOException {
            if ((i3 & 8) != 0) {
                i2--;
            }
            if (i4 <= i2) {
                return i2 - i4;
            }
            throw new IOException(b.d(i4, i2, "PROTOCOL_ERROR padding ", " > remaining length "));
        }
    }

    @Metadata
    public static final class ContinuationSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final RealBufferedSource f56721a;

        /* renamed from: b, reason: collision with root package name */
        public int f56722b;

        /* renamed from: c, reason: collision with root package name */
        public int f56723c;

        /* renamed from: d, reason: collision with root package name */
        public int f56724d;

        /* renamed from: e, reason: collision with root package name */
        public int f56725e;

        /* renamed from: f, reason: collision with root package name */
        public int f56726f;

        public ContinuationSource(RealBufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f56721a = source;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j2) throws IOException {
            int i2;
            int iA;
            Intrinsics.checkNotNullParameter(sink, "sink");
            do {
                int i3 = this.f56725e;
                RealBufferedSource realBufferedSource = this.f56721a;
                if (i3 == 0) {
                    realBufferedSource.k0(this.f56726f);
                    this.f56726f = 0;
                    if ((this.f56723c & 4) == 0) {
                        i2 = this.f56724d;
                        int iT = Util.t(realBufferedSource);
                        this.f56725e = iT;
                        this.f56722b = iT;
                        int iE = realBufferedSource.e() & 255;
                        this.f56723c = realBufferedSource.e() & 255;
                        Logger logger = Http2Reader.f56717d;
                        if (logger.isLoggable(Level.FINE)) {
                            ByteString byteString = Http2.f56653a;
                            logger.fine(Http2.a(true, this.f56724d, this.f56722b, iE, this.f56723c));
                        }
                        iA = realBufferedSource.A() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        this.f56724d = iA;
                        if (iE != 9) {
                            throw new IOException(iE + " != TYPE_CONTINUATION");
                        }
                    }
                } else {
                    long j3 = realBufferedSource.read(sink, Math.min(j2, i3));
                    if (j3 != -1) {
                        this.f56725e -= (int) j3;
                        return j3;
                    }
                }
                return -1L;
            } while (iA == i2);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.f56721a.f56984a.timeout();
        }
    }

    @Metadata
    public interface Handler {
    }

    static {
        Logger logger = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(Http2::class.java.name)");
        f56717d = logger;
    }

    public Http2Reader(RealBufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56718a = source;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.f56719b = continuationSource;
        this.f56720c = new Hpack.Reader(continuationSource);
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x0254, code lost:
    
        throw new java.io.IOException(android.support.v4.media.b.f(r12, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r21, final okhttp3.internal.http2.Http2Connection.ReaderRunnable r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.a(boolean, okhttp3.internal.http2.Http2Connection$ReaderRunnable):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        throw new java.io.IOException(android.support.v4.media.b.f(r7, "Header index too large "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b(int r6, int r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.b(int, int, int, int):java.util.List");
    }

    public final void c(Http2Connection.ReaderRunnable readerRunnable, int i2) throws EOFException {
        RealBufferedSource realBufferedSource = this.f56718a;
        realBufferedSource.A();
        realBufferedSource.e();
        byte[] bArr = Util.f56394a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56718a.close();
    }
}
