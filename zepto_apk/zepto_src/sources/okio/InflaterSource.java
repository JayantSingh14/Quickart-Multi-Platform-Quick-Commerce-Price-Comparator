package okio;

import android.support.v4.media.b;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class InflaterSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    public final RealBufferedSource f56957a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f56958b;

    /* renamed from: c, reason: collision with root package name */
    public int f56959c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f56960d;

    public InflaterSource(RealBufferedSource source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f56957a = source;
        this.f56958b = inflater;
    }

    public final long a(Buffer sink, long j2) {
        Inflater inflater = this.f56958b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
        }
        if (this.f56960d) {
            throw new IllegalStateException("closed");
        }
        if (j2 != 0) {
            try {
                Segment segmentO1 = sink.o1(1);
                int iMin = (int) Math.min(j2, 8192 - segmentO1.f56990c);
                boolean zNeedsInput = inflater.needsInput();
                RealBufferedSource realBufferedSource = this.f56957a;
                if (zNeedsInput && !realBufferedSource.a()) {
                    Segment segment = realBufferedSource.f56985b.f56913a;
                    Intrinsics.c(segment);
                    int i2 = segment.f56990c;
                    int i3 = segment.f56989b;
                    int i4 = i2 - i3;
                    this.f56959c = i4;
                    inflater.setInput(segment.f56988a, i3, i4);
                }
                int iInflate = inflater.inflate(segmentO1.f56988a, segmentO1.f56990c, iMin);
                int i5 = this.f56959c;
                if (i5 != 0) {
                    int remaining = i5 - inflater.getRemaining();
                    this.f56959c -= remaining;
                    realBufferedSource.k0(remaining);
                }
                if (iInflate > 0) {
                    segmentO1.f56990c += iInflate;
                    long j3 = iInflate;
                    sink.f56914b += j3;
                    return j3;
                }
                if (segmentO1.f56989b == segmentO1.f56990c) {
                    sink.f56913a = segmentO1.a();
                    SegmentPool.a(segmentO1);
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f56960d) {
            return;
        }
        this.f56958b.end();
        this.f56960d = true;
        this.f56957a.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long jA = a(sink, j2);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f56958b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f56957a.a());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f56957a.f56984a.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.d(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }
}
