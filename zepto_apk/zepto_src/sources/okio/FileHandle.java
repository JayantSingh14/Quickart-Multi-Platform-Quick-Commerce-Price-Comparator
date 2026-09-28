package okio;

import android.support.v4.media.b;
import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class FileHandle implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56931a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f56932b;

    /* renamed from: c, reason: collision with root package name */
    public int f56933c;

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f56934d = new ReentrantLock();

    @Metadata
    @SourceDebugExtension
    public static final class FileHandleSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        public final FileHandle f56935a;

        /* renamed from: b, reason: collision with root package name */
        public long f56936b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56937c;

        public FileHandleSink(FileHandle fileHandle) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.f56935a = fileHandle;
            this.f56936b = 0L;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56937c) {
                return;
            }
            this.f56937c = true;
            FileHandle fileHandle = this.f56935a;
            ReentrantLock reentrantLock = fileHandle.f56934d;
            reentrantLock.lock();
            try {
                int i2 = fileHandle.f56933c - 1;
                fileHandle.f56933c = i2;
                if (i2 == 0 && fileHandle.f56932b) {
                    Unit unit = Unit.f53572a;
                    reentrantLock.unlock();
                    fileHandle.a();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            if (this.f56937c) {
                throw new IllegalStateException("closed");
            }
            this.f56935a.b();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Timeout.f57001d;
        }

        @Override // okio.Sink
        public final void write(Buffer source, long j2) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f56937c) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.f56936b;
            FileHandle fileHandle = this.f56935a;
            fileHandle.getClass();
            SegmentedByteString.b(source.f56914b, 0L, j2);
            long j4 = j3 + j2;
            long j5 = j3;
            while (j5 < j4) {
                Segment segment = source.f56913a;
                Intrinsics.c(segment);
                int iMin = (int) Math.min(j4 - j5, segment.f56990c - segment.f56989b);
                fileHandle.l(j5, segment.f56988a, segment.f56989b, iMin);
                int i2 = segment.f56989b + iMin;
                segment.f56989b = i2;
                long j6 = iMin;
                j5 += j6;
                source.f56914b -= j6;
                if (i2 == segment.f56990c) {
                    source.f56913a = segment.a();
                    SegmentPool.a(segment);
                }
            }
            this.f56936b += j2;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class FileHandleSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final FileHandle f56938a;

        /* renamed from: b, reason: collision with root package name */
        public long f56939b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56940c;

        public FileHandleSource(FileHandle fileHandle, long j2) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.f56938a = fileHandle;
            this.f56939b = j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f56940c) {
                return;
            }
            this.f56940c = true;
            FileHandle fileHandle = this.f56938a;
            ReentrantLock reentrantLock = fileHandle.f56934d;
            reentrantLock.lock();
            try {
                int i2 = fileHandle.f56933c - 1;
                fileHandle.f56933c = i2;
                if (i2 == 0 && fileHandle.f56932b) {
                    Unit unit = Unit.f53572a;
                    reentrantLock.unlock();
                    fileHandle.a();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j2) {
            long j3;
            long j4;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.f56940c) {
                throw new IllegalStateException("closed");
            }
            long j5 = this.f56939b;
            FileHandle fileHandle = this.f56938a;
            fileHandle.getClass();
            if (j2 < 0) {
                throw new IllegalArgumentException(b.i(j2, "byteCount < 0: ").toString());
            }
            long j6 = j2 + j5;
            long j7 = j5;
            while (true) {
                if (j7 >= j6) {
                    j3 = -1;
                    break;
                }
                Segment segmentO1 = sink.o1(1);
                j3 = -1;
                long j8 = j6;
                int iC = fileHandle.c(j7, segmentO1.f56988a, segmentO1.f56990c, (int) Math.min(j6 - j7, 8192 - r10));
                if (iC == -1) {
                    if (segmentO1.f56989b == segmentO1.f56990c) {
                        sink.f56913a = segmentO1.a();
                        SegmentPool.a(segmentO1);
                    }
                    if (j5 == j7) {
                        j4 = -1;
                    }
                } else {
                    segmentO1.f56990c += iC;
                    long j9 = iC;
                    j7 += j9;
                    sink.f56914b += j9;
                    j6 = j8;
                }
            }
            j4 = j7 - j5;
            if (j4 != j3) {
                this.f56939b += j4;
            }
            return j4;
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Timeout.f57001d;
        }
    }

    public FileHandle(boolean z) {
        this.f56931a = z;
    }

    public static Sink r(FileHandle fileHandle) {
        if (!fileHandle.f56931a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = fileHandle.f56934d;
        reentrantLock.lock();
        try {
            if (fileHandle.f56932b) {
                throw new IllegalStateException("closed");
            }
            fileHandle.f56933c++;
            reentrantLock.unlock();
            return new FileHandleSink(fileHandle);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract int c(long j2, byte[] bArr, int i2, int i3);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f56934d;
        reentrantLock.lock();
        try {
            if (this.f56932b) {
                return;
            }
            this.f56932b = true;
            if (this.f56933c != 0) {
                return;
            }
            Unit unit = Unit.f53572a;
            reentrantLock.unlock();
            a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract long e();

    public final void flush() {
        if (!this.f56931a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f56934d;
        reentrantLock.lock();
        try {
            if (this.f56932b) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.f53572a;
            reentrantLock.unlock();
            b();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void l(long j2, byte[] bArr, int i2, int i3);

    public final long s() {
        ReentrantLock reentrantLock = this.f56934d;
        reentrantLock.lock();
        try {
            if (this.f56932b) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.f53572a;
            reentrantLock.unlock();
            return e();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Source x(long j2) {
        ReentrantLock reentrantLock = this.f56934d;
        reentrantLock.lock();
        try {
            if (this.f56932b) {
                throw new IllegalStateException("closed");
            }
            this.f56933c++;
            reentrantLock.unlock();
            return new FileHandleSource(this, j2);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
