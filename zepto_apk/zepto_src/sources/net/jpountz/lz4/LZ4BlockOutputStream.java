package net.jpountz.lz4;

import android.support.v4.media.b;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Checksum;
import net.jpountz.util.SafeUtils;
import net.jpountz.xxhash.XXHashFactory;

/* loaded from: classes3.dex */
public class LZ4BlockOutputStream extends FilterOutputStream implements AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int COMPRESSION_LEVEL_BASE = 10;
    static final int COMPRESSION_METHOD_LZ4 = 32;
    static final int COMPRESSION_METHOD_RAW = 16;
    static final int DEFAULT_SEED = -1756908916;
    static final int HEADER_LENGTH;
    static final byte[] MAGIC;
    static final int MAGIC_LENGTH;
    static final int MAX_BLOCK_SIZE = 33554432;
    static final int MIN_BLOCK_SIZE = 64;
    private final int blockSize;
    private final byte[] buffer;
    private final Checksum checksum;
    private final byte[] compressedBuffer;
    private final int compressionLevel;
    private final LZ4Compressor compressor;
    private boolean finished;
    private int o;
    private final boolean syncFlush;

    static {
        byte[] bArr = {76, 90, 52, 66, 108, 111, 99, 107};
        MAGIC = bArr;
        int length = bArr.length;
        MAGIC_LENGTH = length;
        HEADER_LENGTH = length + 13;
    }

    public LZ4BlockOutputStream(OutputStream outputStream, int i2, LZ4Compressor lZ4Compressor, Checksum checksum, boolean z) {
        super(outputStream);
        this.blockSize = i2;
        this.compressor = lZ4Compressor;
        this.checksum = checksum;
        this.compressionLevel = compressionLevel(i2);
        this.buffer = new byte[i2];
        byte[] bArr = new byte[lZ4Compressor.maxCompressedLength(i2) + HEADER_LENGTH];
        this.compressedBuffer = bArr;
        this.syncFlush = z;
        this.o = 0;
        this.finished = false;
        System.arraycopy(MAGIC, 0, bArr, 0, MAGIC_LENGTH);
    }

    private static int compressionLevel(int i2) {
        if (i2 < 64) {
            throw new IllegalArgumentException(b.f(i2, "blockSize must be >= 64, got "));
        }
        if (i2 <= MAX_BLOCK_SIZE) {
            return Math.max(0, 22 - Integer.numberOfLeadingZeros(i2 - 1));
        }
        throw new IllegalArgumentException(b.f(i2, "blockSize must be <= 33554432, got "));
    }

    private void ensureNotFinished() {
        if (this.finished) {
            throw new IllegalStateException("This stream is already closed");
        }
    }

    private void flushBufferedData() throws IOException {
        int i2;
        if (this.o == 0) {
            return;
        }
        this.checksum.reset();
        this.checksum.update(this.buffer, 0, this.o);
        int value = (int) this.checksum.getValue();
        LZ4Compressor lZ4Compressor = this.compressor;
        byte[] bArr = this.buffer;
        int i3 = this.o;
        byte[] bArr2 = this.compressedBuffer;
        int i4 = HEADER_LENGTH;
        int iCompress = lZ4Compressor.compress(bArr, 0, i3, bArr2, i4);
        int i5 = this.o;
        if (iCompress >= i5) {
            System.arraycopy(this.buffer, 0, this.compressedBuffer, i4, i5);
            i2 = 16;
        } else {
            i5 = iCompress;
            i2 = 32;
        }
        byte[] bArr3 = this.compressedBuffer;
        int i6 = MAGIC_LENGTH;
        bArr3[i6] = (byte) (i2 | this.compressionLevel);
        writeIntLE(i5, bArr3, i6 + 1);
        writeIntLE(this.o, this.compressedBuffer, i6 + 5);
        writeIntLE(value, this.compressedBuffer, i6 + 9);
        ((FilterOutputStream) this).out.write(this.compressedBuffer, 0, i4 + i5);
        this.o = 0;
    }

    private static void writeIntLE(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.close();
            ((FilterOutputStream) this).out = null;
        }
    }

    public void finish() throws IOException {
        ensureNotFinished();
        flushBufferedData();
        byte[] bArr = this.compressedBuffer;
        int i2 = MAGIC_LENGTH;
        bArr[i2] = (byte) (this.compressionLevel | 16);
        writeIntLE(0, bArr, i2 + 1);
        writeIntLE(0, this.compressedBuffer, i2 + 5);
        writeIntLE(0, this.compressedBuffer, i2 + 9);
        ((FilterOutputStream) this).out.write(this.compressedBuffer, 0, HEADER_LENGTH);
        this.finished = true;
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (((FilterOutputStream) this).out != null) {
            if (this.syncFlush) {
                flushBufferedData();
            }
            ((FilterOutputStream) this).out.flush();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "(out=" + ((FilterOutputStream) this).out + ", blockSize=" + this.blockSize + ", compressor=" + this.compressor + ", checksum=" + this.checksum + ")";
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ensureNotFinished();
        if (this.o == this.blockSize) {
            flushBufferedData();
        }
        byte[] bArr = this.buffer;
        int i3 = this.o;
        this.o = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        SafeUtils.checkRange(bArr, i2, i3);
        ensureNotFinished();
        while (true) {
            int i4 = this.o;
            int i5 = i4 + i3;
            int i6 = this.blockSize;
            if (i5 > i6) {
                int i7 = i6 - i4;
                System.arraycopy(bArr, i2, this.buffer, i4, i6 - i4);
                this.o = this.blockSize;
                flushBufferedData();
                i2 += i7;
                i3 -= i7;
            } else {
                System.arraycopy(bArr, i2, this.buffer, i4, i3);
                this.o += i3;
                return;
            }
        }
    }

    public LZ4BlockOutputStream(OutputStream outputStream, int i2, LZ4Compressor lZ4Compressor) {
        this(outputStream, i2, lZ4Compressor, XXHashFactory.fastestInstance().newStreamingHash32(DEFAULT_SEED).asChecksum(), false);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        ensureNotFinished();
        write(bArr, 0, bArr.length);
    }

    public LZ4BlockOutputStream(OutputStream outputStream, int i2) {
        this(outputStream, i2, LZ4Factory.fastestInstance().fastCompressor());
    }

    public LZ4BlockOutputStream(OutputStream outputStream) {
        this(outputStream, 65536);
    }
}
