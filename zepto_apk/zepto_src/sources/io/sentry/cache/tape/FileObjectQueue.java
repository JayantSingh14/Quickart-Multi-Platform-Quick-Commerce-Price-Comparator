package io.sentry.cache.tape;

import io.sentry.cache.tape.ObjectQueue;
import io.sentry.cache.tape.QueueFile;
import io.sentry.cache.tape.QueueFile.ElementIterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;

/* loaded from: classes.dex */
final class FileObjectQueue<T> extends ObjectQueue<T> {

    /* renamed from: a, reason: collision with root package name */
    public final QueueFile f52687a;

    /* renamed from: b, reason: collision with root package name */
    public final DirectByteArrayOutputStream f52688b = new DirectByteArrayOutputStream();

    /* renamed from: c, reason: collision with root package name */
    public final ObjectQueue.Converter f52689c;

    public static final class DirectByteArrayOutputStream extends ByteArrayOutputStream {
        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    /* loaded from: classes3.dex */
    public final class QueueFileIterator implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f52690a;

        public QueueFileIterator(Iterator it) {
            this.f52690a = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f52690a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            return FileObjectQueue.this.f52689c.b((byte[]) ((QueueFile.ElementIterator) this.f52690a).next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f52690a.remove();
        }
    }

    public FileObjectQueue(QueueFile queueFile, ObjectQueue.Converter converter) {
        this.f52687a = queueFile;
        this.f52689c = converter;
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final void A(int i2) throws IOException {
        this.f52687a.Z(i2);
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final void b(Object obj) throws IOException {
        long j2;
        long j3;
        long j4;
        long jY0;
        long j5;
        long j6;
        DirectByteArrayOutputStream directByteArrayOutputStream = this.f52688b;
        directByteArrayOutputStream.reset();
        this.f52689c.a(obj, directByteArrayOutputStream);
        byte[] bArrA = directByteArrayOutputStream.a();
        int size = directByteArrayOutputStream.size();
        QueueFile queueFile = this.f52687a;
        queueFile.getClass();
        if (bArrA == null) {
            throw new NullPointerException("data == null");
        }
        if (size < 0 || size > bArrA.length) {
            throw new IndexOutOfBoundsException();
        }
        if (queueFile.f52702j) {
            throw new IllegalStateException("closed");
        }
        int i2 = queueFile.f52701i;
        if (i2 != -1 && queueFile.f52696d == i2) {
            queueFile.Z(1);
        }
        long j7 = size + 4;
        long j8 = queueFile.f52695c;
        if (queueFile.f52696d == 0) {
            j2 = 4;
            j4 = 32;
            j3 = 32;
        } else {
            QueueFile.Element element = queueFile.f52698f;
            long j9 = element.f52705a;
            j2 = 4;
            long j10 = queueFile.f52697e.f52705a;
            int i3 = element.f52706b;
            if (j9 >= j10) {
                j4 = (j9 - j10) + 4 + i3 + 32;
                j3 = 32;
            } else {
                j3 = 32;
                j4 = (((j9 + 4) + i3) + j8) - j10;
            }
        }
        long j11 = j8 - j4;
        if (j11 < j7) {
            do {
                j11 += j8;
                j8 <<= 1;
            } while (j11 < j7);
            queueFile.f52693a.setLength(j8);
            queueFile.f52693a.getChannel().force(true);
            long jY02 = queueFile.y0(queueFile.f52698f.f52705a + j2 + r4.f52706b);
            if (jY02 <= queueFile.f52697e.f52705a) {
                FileChannel channel = queueFile.f52693a.getChannel();
                channel.position(queueFile.f52695c);
                j5 = jY02 - j3;
                if (channel.transferTo(32L, j5, channel) != j5) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            } else {
                j5 = 0;
            }
            long j12 = queueFile.f52698f.f52705a;
            long j13 = queueFile.f52697e.f52705a;
            if (j12 < j13) {
                long j14 = (queueFile.f52695c + j12) - j3;
                j6 = j8;
                queueFile.z0(queueFile.f52696d, j6, j13, j14);
                queueFile.f52698f = new QueueFile.Element(j14, queueFile.f52698f.f52706b);
            } else {
                j6 = j8;
                queueFile.z0(queueFile.f52696d, j6, j13, j12);
            }
            queueFile.f52695c = j6;
            long j15 = j3;
            long j16 = j5;
            while (j16 > 0) {
                int iMin = (int) Math.min(j16, 4096);
                queueFile.s0(QueueFile.f52692k, iMin, j15);
                long j17 = iMin;
                j16 -= j17;
                j15 += j17;
            }
        }
        boolean z = queueFile.f52696d == 0;
        if (z) {
            jY0 = j3;
        } else {
            jY0 = queueFile.y0(queueFile.f52698f.f52705a + j2 + r4.f52706b);
        }
        QueueFile.Element element2 = new QueueFile.Element(jY0, size);
        byte[] bArr = queueFile.f52699g;
        QueueFile.D0(bArr, 0, size);
        queueFile.s0(bArr, 4, jY0);
        queueFile.s0(bArrA, size, jY0 + j2);
        queueFile.z0(queueFile.f52696d + 1, queueFile.f52695c, z ? jY0 : queueFile.f52697e.f52705a, jY0);
        queueFile.f52698f = element2;
        queueFile.f52696d++;
        queueFile.f52700h++;
        if (z) {
            queueFile.f52697e = element2;
        }
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final void clear() throws IOException {
        this.f52687a.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f52687a.close();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        QueueFile queueFile = this.f52687a;
        queueFile.getClass();
        return new QueueFileIterator(queueFile.new ElementIterator());
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final int size() {
        return this.f52687a.f52696d;
    }

    public final String toString() {
        return "FileObjectQueue{queueFile=" + this.f52687a + '}';
    }
}
