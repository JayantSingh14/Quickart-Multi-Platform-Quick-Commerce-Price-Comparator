package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput, AutoCloseable {
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i2) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i2);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i2) throws IOException {
        writeShort(i2);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            writeShort(str.charAt(i2));
        }
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d2) throws IOException {
        writeLong(Double.doubleToLongBits(d2));
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f2) throws IOException {
        writeInt(Float.floatToIntBits(f2));
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2 & 255);
        ((FilterOutputStream) this).out.write((i2 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i2 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i2 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j2) throws IOException {
        long jReverseBytes = Long.reverseBytes(j2);
        byte[] bArr = new byte[8];
        for (int i2 = 7; i2 >= 0; i2--) {
            bArr[i2] = (byte) (255 & jReverseBytes);
            jReverseBytes >>= 8;
        }
        write(bArr, 0, 8);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2 & 255);
        ((FilterOutputStream) this).out.write((i2 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
