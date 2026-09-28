package io.sentry.cache.tape;

import android.support.v4.media.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class QueueFile implements Closeable, Iterable<byte[]>, AutoCloseable {

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f52692k = new byte[4096];

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f52693a;

    /* renamed from: b, reason: collision with root package name */
    public final File f52694b;

    /* renamed from: c, reason: collision with root package name */
    public long f52695c;

    /* renamed from: d, reason: collision with root package name */
    public int f52696d;

    /* renamed from: e, reason: collision with root package name */
    public Element f52697e;

    /* renamed from: f, reason: collision with root package name */
    public Element f52698f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f52699g = new byte[32];

    /* renamed from: h, reason: collision with root package name */
    public int f52700h = 0;

    /* renamed from: i, reason: collision with root package name */
    public final int f52701i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f52702j;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f52703a = -1;

        public Builder(File file) {
        }
    }

    public static final class Element {

        /* renamed from: c, reason: collision with root package name */
        public static final Element f52704c = new Element(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final long f52705a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52706b;

        public Element(long j2, int i2) {
            this.f52705a = j2;
            this.f52706b = i2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Element.class.getSimpleName());
            sb.append("[position=");
            sb.append(this.f52705a);
            sb.append(", length=");
            return b.o(sb, this.f52706b, "]");
        }
    }

    /* loaded from: classes3.dex */
    public final class ElementIterator implements Iterator<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        public int f52707a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f52708b;

        /* renamed from: c, reason: collision with root package name */
        public int f52709c;

        public ElementIterator() {
            this.f52708b = QueueFile.this.f52697e.f52705a;
            this.f52709c = QueueFile.this.f52700h;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            QueueFile queueFile = QueueFile.this;
            if (queueFile.f52702j) {
                throw new IllegalStateException("closed");
            }
            if (queueFile.f52700h == this.f52709c) {
                return this.f52707a != queueFile.f52696d;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public final byte[] next() throws IOException {
            byte[] bArr = QueueFile.f52692k;
            QueueFile queueFile = QueueFile.this;
            if (queueFile.f52702j) {
                throw new IllegalStateException("closed");
            }
            if (queueFile.f52700h != this.f52709c) {
                throw new ConcurrentModificationException();
            }
            int i2 = queueFile.f52696d;
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            if (this.f52707a >= i2) {
                throw new NoSuchElementException();
            }
            try {
                Element elementR = queueFile.r(this.f52708b);
                int i3 = elementR.f52706b;
                long j2 = elementR.f52705a;
                byte[] bArr2 = new byte[i3];
                long j3 = j2 + 4;
                long jY0 = queueFile.y0(j3);
                this.f52708b = jY0;
                if (!queueFile.n0(bArr2, i3, jY0)) {
                    this.f52707a = queueFile.f52696d;
                    return bArr;
                }
                this.f52708b = queueFile.y0(j3 + i3);
                this.f52707a++;
                return bArr2;
            } catch (IOException e2) {
                throw e2;
            } catch (OutOfMemoryError unused) {
                queueFile.l0();
                this.f52707a = queueFile.f52696d;
                return bArr;
            }
        }

        @Override // java.util.Iterator
        public final void remove() throws IOException {
            QueueFile queueFile = QueueFile.this;
            if (queueFile.f52700h != this.f52709c) {
                throw new ConcurrentModificationException();
            }
            if (queueFile.f52696d == 0) {
                throw new NoSuchElementException();
            }
            if (this.f52707a != 1) {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
            queueFile.Z(1);
            this.f52709c = queueFile.f52700h;
            this.f52707a--;
        }
    }

    public QueueFile(File file, RandomAccessFile randomAccessFile, int i2) throws IOException {
        this.f52694b = file;
        this.f52693a = randomAccessFile;
        this.f52701i = i2;
        s();
    }

    public static int A(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public static void D0(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public static long N(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 56) + ((bArr[i2 + 1] & 255) << 48) + ((bArr[i2 + 2] & 255) << 40) + ((bArr[i2 + 3] & 255) << 32) + ((bArr[i2 + 4] & 255) << 24) + ((bArr[i2 + 5] & 255) << 16) + ((bArr[i2 + 6] & 255) << 8) + (bArr[i2 + 7] & 255);
    }

    public static RandomAccessFile b(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(-2147483647);
                randomAccessFile.writeLong(4096L);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        return new RandomAccessFile(file, "rwd");
    }

    public static void j1(byte[] bArr, int i2, long j2) {
        bArr[i2] = (byte) (j2 >> 56);
        bArr[i2 + 1] = (byte) (j2 >> 48);
        bArr[i2 + 2] = (byte) (j2 >> 40);
        bArr[i2 + 3] = (byte) (j2 >> 32);
        bArr[i2 + 4] = (byte) (j2 >> 24);
        bArr[i2 + 5] = (byte) (j2 >> 16);
        bArr[i2 + 6] = (byte) (j2 >> 8);
        bArr[i2 + 7] = (byte) j2;
    }

    public final void Z(int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "Cannot remove negative (", ") number of elements."));
        }
        if (i2 == 0) {
            return;
        }
        int i3 = this.f52696d;
        if (i2 == i3) {
            clear();
            return;
        }
        if (i3 == 0) {
            throw new NoSuchElementException();
        }
        if (i2 > i3) {
            throw new IllegalArgumentException(b.o(b.u(i2, "Cannot remove more elements (", ") than present in queue ("), this.f52696d, ")."));
        }
        Element element = this.f52697e;
        long j2 = element.f52705a;
        int iA = element.f52706b;
        long jY0 = j2;
        long j3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j3 += iA + 4;
            jY0 = y0(jY0 + 4 + iA);
            byte[] bArr = this.f52699g;
            if (!n0(bArr, 4, jY0)) {
                return;
            }
            iA = A(bArr, 0);
        }
        z0(this.f52696d - i2, this.f52695c, jY0, this.f52698f.f52705a);
        this.f52696d -= i2;
        this.f52700h++;
        this.f52697e = new Element(jY0, iA);
        while (j3 > 0) {
            int iMin = (int) Math.min(j3, 4096);
            s0(f52692k, iMin, j2);
            long j4 = iMin;
            j3 -= j4;
            j2 += j4;
        }
    }

    public final void clear() throws IOException {
        if (this.f52702j) {
            throw new IllegalStateException("closed");
        }
        z0(0, 4096L, 0L, 0L);
        this.f52693a.seek(32L);
        this.f52693a.write(f52692k, 0, 4064);
        this.f52696d = 0;
        Element element = Element.f52704c;
        this.f52697e = element;
        this.f52698f = element;
        if (this.f52695c > 4096) {
            this.f52693a.setLength(4096L);
            this.f52693a.getChannel().force(true);
        }
        this.f52695c = 4096L;
        this.f52700h++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f52702j = true;
        this.f52693a.close();
    }

    @Override // java.lang.Iterable
    public final Iterator<byte[]> iterator() {
        return new ElementIterator();
    }

    public final void l0() throws IOException {
        this.f52693a.close();
        File file = this.f52694b;
        file.delete();
        this.f52693a = b(file);
        s();
    }

    public final boolean n0(byte[] bArr, int i2, long j2) throws IOException {
        try {
            long jY0 = y0(j2);
            long j3 = i2 + jY0;
            long j4 = this.f52695c;
            if (j3 <= j4) {
                this.f52693a.seek(jY0);
                this.f52693a.readFully(bArr, 0, i2);
                return true;
            }
            int i3 = (int) (j4 - jY0);
            this.f52693a.seek(jY0);
            this.f52693a.readFully(bArr, 0, i3);
            this.f52693a.seek(32L);
            this.f52693a.readFully(bArr, i3, i2 - i3);
            return true;
        } catch (EOFException unused) {
            l0();
            return false;
        } catch (IOException e2) {
            throw e2;
        } catch (Throwable unused2) {
            l0();
            return false;
        }
    }

    public final Element r(long j2) {
        Element element = Element.f52704c;
        if (j2 != 0) {
            byte[] bArr = this.f52699g;
            if (n0(bArr, 4, j2)) {
                return new Element(j2, A(bArr, 0));
            }
        }
        return element;
    }

    public final void s() throws IOException {
        this.f52693a.seek(0L);
        RandomAccessFile randomAccessFile = this.f52693a;
        byte[] bArr = this.f52699g;
        randomAccessFile.readFully(bArr);
        this.f52695c = N(bArr, 4);
        this.f52696d = A(bArr, 12);
        long jN = N(bArr, 16);
        long jN2 = N(bArr, 24);
        if (this.f52695c <= this.f52693a.length()) {
            if (this.f52695c <= 32) {
                throw new IOException(b.p(new StringBuilder("File is corrupt; length stored in header ("), this.f52695c, ") is invalid."));
            }
            this.f52697e = r(jN);
            this.f52698f = r(jN2);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f52695c + ", Actual length: " + this.f52693a.length());
    }

    public final void s0(byte[] bArr, int i2, long j2) throws IOException {
        long jY0 = y0(j2);
        long j3 = i2 + jY0;
        long j4 = this.f52695c;
        if (j3 <= j4) {
            this.f52693a.seek(jY0);
            this.f52693a.write(bArr, 0, i2);
            return;
        }
        int i3 = (int) (j4 - jY0);
        this.f52693a.seek(jY0);
        this.f52693a.write(bArr, 0, i3);
        this.f52693a.seek(32L);
        this.f52693a.write(bArr, i3, i2 - i3);
    }

    public final String toString() {
        return "QueueFile{file=" + this.f52694b + ", zero=true, length=" + this.f52695c + ", size=" + this.f52696d + ", first=" + this.f52697e + ", last=" + this.f52698f + '}';
    }

    public final long y0(long j2) {
        long j3 = this.f52695c;
        return j2 < j3 ? j2 : (j2 + 32) - j3;
    }

    public final void z0(int i2, long j2, long j3, long j4) throws IOException {
        this.f52693a.seek(0L);
        byte[] bArr = this.f52699g;
        D0(bArr, 0, -2147483647);
        j1(bArr, 4, j2);
        D0(bArr, 12, i2);
        j1(bArr, 16, j3);
        j1(bArr, 24, j4);
        this.f52693a.write(bArr, 0, 32);
    }
}
