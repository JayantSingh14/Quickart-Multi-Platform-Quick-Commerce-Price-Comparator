package org.apache.xml.security.utils;

import java.io.OutputStream;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes5.dex */
public class UnsyncByteArrayOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadLocal f57364a = new ThreadLocal() { // from class: org.apache.xml.security.utils.UnsyncByteArrayOutputStream.1
        @Override // java.lang.ThreadLocal
        public synchronized Object initialValue() {
            return new byte[KEYRecord.Flags.FLAG2];
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private int f57366c = KEYRecord.Flags.FLAG2;

    /* renamed from: d, reason: collision with root package name */
    private int f57367d = 0;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f57365b = (byte[]) f57364a.get();

    private void a(int i2) {
        int i3 = this.f57366c;
        while (i2 > i3) {
            i3 <<= 2;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f57365b, 0, bArr, 0, this.f57367d);
        this.f57365b = bArr;
        this.f57366c = i3;
    }

    public void b() {
        this.f57367d = 0;
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        int i3 = this.f57367d + 1;
        if (i3 > this.f57366c) {
            a(i3);
        }
        byte[] bArr = this.f57365b;
        int i4 = this.f57367d;
        this.f57367d = i4 + 1;
        bArr[i4] = (byte) i2;
    }

    public byte[] a() {
        int i2 = this.f57367d;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f57365b, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        int length = this.f57367d + bArr.length;
        if (length > this.f57366c) {
            a(length);
        }
        System.arraycopy(bArr, 0, this.f57365b, this.f57367d, bArr.length);
        this.f57367d = length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4 = this.f57367d + i3;
        if (i4 > this.f57366c) {
            a(i4);
        }
        System.arraycopy(bArr, i2, this.f57365b, this.f57367d, i3);
        this.f57367d = i4;
    }
}
