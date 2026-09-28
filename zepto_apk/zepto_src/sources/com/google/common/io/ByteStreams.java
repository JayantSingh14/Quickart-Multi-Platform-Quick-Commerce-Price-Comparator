package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import org.xbill.DNS.KEYRecord;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class ByteStreams {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43233a = 0;

    /* renamed from: com.google.common.io.ByteStreams$1, reason: invalid class name */
    public class AnonymousClass1 extends OutputStream {
        public final String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            bArr.getClass();
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            bArr.getClass();
            Preconditions.l(i2, i3 + i2, bArr.length);
        }
    }

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        @Override // java.io.DataInput
        public final boolean readBoolean() {
            throw null;
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            throw null;
        }

        @Override // java.io.DataInput
        public final char readChar() {
            throw null;
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            throw null;
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            throw null;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) {
            throw null;
        }

        @Override // java.io.DataInput
        public final int readInt() {
            throw null;
        }

        @Override // java.io.DataInput
        public final String readLine() {
            throw null;
        }

        @Override // java.io.DataInput
        public final long readLong() {
            throw null;
        }

        @Override // java.io.DataInput
        public final short readShort() {
            throw null;
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            throw null;
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            throw null;
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            throw null;
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i2) {
            throw null;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i2, int i3) {
            throw null;
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        @Override // java.io.DataOutput
        public final void write(int i2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeBoolean(boolean z) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeByte(int i2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeBytes(String str) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeChar(int i2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeChars(String str) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeDouble(double d2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeFloat(float f2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeInt(int i2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeLong(long j2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeShort(int i2) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void writeUTF(String str) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void write(byte[] bArr) {
            throw null;
        }

        @Override // java.io.DataOutput
        public final void write(byte[] bArr, int i2, int i3) {
            throw null;
        }
    }

    static {
        new AnonymousClass1();
    }

    public static byte[] a(ArrayDeque arrayDeque, int i2) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i2) {
            return bArr;
        }
        int length = i2 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i2 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static void b(LittleEndianDataInputStream littleEndianDataInputStream, byte[] bArr, int i2, int i3) {
        bArr.getClass();
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.g(i3, "len (", ") cannot be negative"));
        }
        Preconditions.l(i2, i2 + i3, bArr.length);
        int i4 = 0;
        while (i4 < i3) {
            int i5 = littleEndianDataInputStream.read(bArr, i2 + i4, i3 - i4);
            if (i5 == -1) {
                break;
            } else {
                i4 += i5;
            }
        }
        if (i4 != i3) {
            throw new EOFException(android.support.v4.media.b.e(i4, i3, "reached end of stream after reading ", " bytes; ", " bytes expected"));
        }
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(KEYRecord.Flags.FLAG2, Math.max(128, Integer.highestOneBit(0) * 2));
        int i2 = 0;
        while (i2 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i2);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i3 = 0;
            while (i3 < iMin2) {
                int i4 = inputStream.read(bArr, i3, iMin2 - i3);
                if (i4 == -1) {
                    return a(arrayDeque, i2);
                }
                i3 += i4;
                i2 += i4;
            }
            iMin = Ints.f(iMin * (iMin < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return a(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static final class LimitedInputStream extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public long f43234a;

        /* renamed from: b, reason: collision with root package name */
        public long f43235b;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int available() {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f43234a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void mark(int i2) {
            ((FilterInputStream) this).in.mark(i2);
            this.f43235b = this.f43234a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            if (this.f43234a == 0) {
                return -1;
            }
            int i2 = ((FilterInputStream) this).in.read();
            if (i2 != -1) {
                this.f43234a--;
            }
            return i2;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f43235b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f43234a = this.f43235b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j2) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j2, this.f43234a));
            this.f43234a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            long j2 = this.f43234a;
            if (j2 == 0) {
                return -1;
            }
            int i4 = ((FilterInputStream) this).in.read(bArr, i2, (int) Math.min(i3, j2));
            if (i4 != -1) {
                this.f43234a -= i4;
            }
            return i4;
        }
    }
}
