package org.apache.xml.security.utils;

import java.io.IOException;
import java.io.OutputStream;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes5.dex */
public class UnsyncBufferedOutputStream extends OutputStream implements AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    private static ThreadLocal f57360d = new ThreadLocal() { // from class: org.apache.xml.security.utils.UnsyncBufferedOutputStream.1
        @Override // java.lang.ThreadLocal
        public synchronized Object initialValue() {
            return new byte[KEYRecord.Flags.FLAG2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final OutputStream f57361a;

    /* renamed from: c, reason: collision with root package name */
    int f57363c = 0;

    /* renamed from: b, reason: collision with root package name */
    final byte[] f57362b = (byte[]) f57360d.get();

    public UnsyncBufferedOutputStream(OutputStream outputStream) {
        this.f57361a = outputStream;
    }

    private final void a() throws IOException {
        int i2 = this.f57363c;
        if (i2 > 0) {
            this.f57361a.write(this.f57362b, 0, i2);
        }
        this.f57363c = 0;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f57361a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        if (this.f57363c >= 8192) {
            a();
        }
        byte[] bArr = this.f57362b;
        int i3 = this.f57363c;
        this.f57363c = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f57363c + i3;
        if (i4 > 8192) {
            a();
            if (i3 > 8192) {
                this.f57361a.write(bArr, i2, i3);
                return;
            }
            i4 = i3;
        }
        System.arraycopy(bArr, i2, this.f57362b, this.f57363c, i3);
        this.f57363c = i4;
    }
}
