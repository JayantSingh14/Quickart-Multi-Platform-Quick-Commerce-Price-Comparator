package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class QueueFile implements Closeable, AutoCloseable {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f43905g = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f43906a;

    /* renamed from: b, reason: collision with root package name */
    public int f43907b;

    /* renamed from: c, reason: collision with root package name */
    public int f43908c;

    /* renamed from: d, reason: collision with root package name */
    public Element f43909d;

    /* renamed from: e, reason: collision with root package name */
    public Element f43910e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f43911f;

    public static class Element {

        /* renamed from: c, reason: collision with root package name */
        public static final Element f43914c = new Element(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f43915a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43916b;

        public Element(int i2, int i3) {
            this.f43915a = i2;
            this.f43916b = i3;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.f43915a);
            sb.append(", length = ");
            return android.support.v4.media.b.o(sb, this.f43916b, "]");
        }
    }

    /* loaded from: classes4.dex */
    public interface ElementReader {
        void a(InputStream inputStream, int i2);
    }

    public QueueFile(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.f43911f = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    T(bArr2, i2, iArr[i3]);
                    i2 += 4;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f43906a = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int iR = r(bArr, 0);
        this.f43907b = iR;
        if (iR > randomAccessFile2.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f43907b + ", Actual length: " + randomAccessFile2.length());
        }
        this.f43908c = r(bArr, 4);
        int iR2 = r(bArr, 8);
        int iR3 = r(bArr, 12);
        this.f43909d = l(iR2);
        this.f43910e = l(iR3);
    }

    public static void T(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public static int r(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public final void A(int i2, byte[] bArr, int i3) throws IOException {
        int iN = N(i2);
        int i4 = iN + i3;
        int i5 = this.f43907b;
        RandomAccessFile randomAccessFile = this.f43906a;
        if (i4 <= i5) {
            randomAccessFile.seek(iN);
            randomAccessFile.write(bArr, 0, i3);
            return;
        }
        int i6 = i5 - iN;
        randomAccessFile.seek(iN);
        randomAccessFile.write(bArr, 0, i6);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i6, i3 - i6);
    }

    public final int D() {
        if (this.f43908c == 0) {
            return 16;
        }
        Element element = this.f43910e;
        int i2 = element.f43915a;
        int i3 = this.f43909d.f43915a;
        return i2 >= i3 ? (i2 - i3) + 4 + element.f43916b + 16 : (((i2 + 4) + element.f43916b) + this.f43907b) - i3;
    }

    public final int N(int i2) {
        int i3 = this.f43907b;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    public final void O(int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr = {i2, i3, i4, i5};
        byte[] bArr = this.f43911f;
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            T(bArr, i6, iArr[i7]);
            i6 += 4;
        }
        RandomAccessFile randomAccessFile = this.f43906a;
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr);
    }

    public final void a(byte[] bArr) {
        int iN;
        int length = bArr.length;
        synchronized (this) {
            if (length >= 0) {
                if (length <= bArr.length) {
                    b(length);
                    boolean zE = e();
                    if (zE) {
                        iN = 16;
                    } else {
                        Element element = this.f43910e;
                        iN = N(element.f43915a + 4 + element.f43916b);
                    }
                    Element element2 = new Element(iN, length);
                    T(this.f43911f, 0, length);
                    A(iN, this.f43911f, 4);
                    A(iN + 4, bArr, length);
                    O(this.f43907b, this.f43908c + 1, zE ? iN : this.f43909d.f43915a, iN);
                    this.f43910e = element2;
                    this.f43908c++;
                    if (zE) {
                        this.f43909d = element2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public final void b(int i2) throws IOException {
        int i3 = i2 + 4;
        int iD = this.f43907b - D();
        if (iD >= i3) {
            return;
        }
        int i4 = this.f43907b;
        do {
            iD += i4;
            i4 <<= 1;
        } while (iD < i3);
        RandomAccessFile randomAccessFile = this.f43906a;
        randomAccessFile.setLength(i4);
        randomAccessFile.getChannel().force(true);
        Element element = this.f43910e;
        int iN = N(element.f43915a + 4 + element.f43916b);
        if (iN < this.f43909d.f43915a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f43907b);
            long j2 = iN - 4;
            if (channel.transferTo(16L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i5 = this.f43910e.f43915a;
        int i6 = this.f43909d.f43915a;
        if (i5 < i6) {
            int i7 = (this.f43907b + i5) - 16;
            O(i4, this.f43908c, i6, i7);
            this.f43910e = new Element(i7, this.f43910e.f43916b);
        } else {
            O(i4, this.f43908c, i6, i5);
        }
        this.f43907b = i4;
    }

    public final synchronized void c(ElementReader elementReader) {
        int iN = this.f43909d.f43915a;
        for (int i2 = 0; i2 < this.f43908c; i2++) {
            Element elementL = l(iN);
            elementReader.a(new ElementInputStream(elementL), elementL.f43916b);
            iN = N(elementL.f43915a + 4 + elementL.f43916b);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f43906a.close();
    }

    public final synchronized boolean e() {
        return this.f43908c == 0;
    }

    public final Element l(int i2) throws IOException {
        if (i2 == 0) {
            return Element.f43914c;
        }
        RandomAccessFile randomAccessFile = this.f43906a;
        randomAccessFile.seek(i2);
        return new Element(i2, randomAccessFile.readInt());
    }

    public final synchronized void s() {
        if (e()) {
            throw new NoSuchElementException();
        }
        if (this.f43908c == 1) {
            synchronized (this) {
                O(4096, 0, 0, 0);
                this.f43908c = 0;
                Element element = Element.f43914c;
                this.f43909d = element;
                this.f43910e = element;
                if (this.f43907b > 4096) {
                    RandomAccessFile randomAccessFile = this.f43906a;
                    randomAccessFile.setLength(4096);
                    randomAccessFile.getChannel().force(true);
                }
                this.f43907b = 4096;
            }
        } else {
            Element element2 = this.f43909d;
            int iN = N(element2.f43915a + 4 + element2.f43916b);
            x(iN, 0, this.f43911f, 4);
            int iR = r(this.f43911f, 0);
            O(this.f43907b, this.f43908c - 1, iN, this.f43910e.f43915a);
            this.f43908c--;
            this.f43909d = new Element(iN, iR);
        }
    }

    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.f43907b);
        sb.append(", size=");
        sb.append(this.f43908c);
        sb.append(", first=");
        sb.append(this.f43909d);
        sb.append(", last=");
        sb.append(this.f43910e);
        sb.append(", element lengths=[");
        try {
            c(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1

                /* renamed from: a, reason: collision with root package name */
                public boolean f43912a = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public final void a(InputStream inputStream, int i2) {
                    boolean z = this.f43912a;
                    StringBuilder sb2 = sb;
                    if (z) {
                        this.f43912a = false;
                    } else {
                        sb2.append(", ");
                    }
                    sb2.append(i2);
                }
            });
        } catch (IOException e2) {
            f43905g.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final void x(int i2, int i3, byte[] bArr, int i4) throws IOException {
        int iN = N(i2);
        int i5 = iN + i4;
        int i6 = this.f43907b;
        RandomAccessFile randomAccessFile = this.f43906a;
        if (i5 <= i6) {
            randomAccessFile.seek(iN);
            randomAccessFile.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - iN;
        randomAccessFile.seek(iN);
        randomAccessFile.readFully(bArr, i3, i7);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i3 + i7, i4 - i7);
    }

    /* loaded from: classes4.dex */
    public final class ElementInputStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public int f43917a;

        /* renamed from: b, reason: collision with root package name */
        public int f43918b;

        public ElementInputStream(Element element) {
            int i2 = element.f43915a + 4;
            Logger logger = QueueFile.f43905g;
            this.f43917a = QueueFile.this.N(i2);
            this.f43918b = element.f43916b;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            Logger logger = QueueFile.f43905g;
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = this.f43918b;
            if (i4 <= 0) {
                return -1;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            int i5 = this.f43917a;
            QueueFile queueFile = QueueFile.this;
            queueFile.x(i5, i2, bArr, i3);
            this.f43917a = queueFile.N(this.f43917a + i3);
            this.f43918b -= i3;
            return i3;
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            if (this.f43918b == 0) {
                return -1;
            }
            QueueFile queueFile = QueueFile.this;
            queueFile.f43906a.seek(this.f43917a);
            int i2 = queueFile.f43906a.read();
            this.f43917a = queueFile.N(this.f43917a + 1);
            this.f43918b--;
            return i2;
        }
    }
}
