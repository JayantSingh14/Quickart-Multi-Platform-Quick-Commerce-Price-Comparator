package net.jpountz.lz4;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import net.jpountz.lz4.LZ4FrameOutputStream;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

/* loaded from: classes3.dex */
public class LZ4FrameInputStream extends FilterInputStream implements AutoCloseable {
    static final String BLOCK_HASH_MISMATCH = "Block checksum mismatch";
    static final String DESCRIPTOR_HASH_MISMATCH = "Stream frame descriptor corrupted";
    static final int MAGIC_SKIPPABLE_BASE = 407710288;
    static final String NOT_SUPPORTED = "Stream unsupported";
    static final String PREMATURE_EOS = "Stream ended prematurely";
    private ByteBuffer buffer;
    private final XXHash32 checksum;
    private byte[] compressedBuffer;
    private final LZ4SafeDecompressor decompressor;
    private long expectedContentSize;
    private boolean firstFrameHeaderRead;
    private LZ4FrameOutputStream.FrameInfo frameInfo;
    private final byte[] headerArray;
    private final ByteBuffer headerBuffer;
    private int maxBlockSize;
    private byte[] rawBuffer;
    private final ByteBuffer readNumberBuff;
    private final boolean readSingleFrame;
    private long totalContentSize;

    public LZ4FrameInputStream(InputStream inputStream) throws IOException {
        this(inputStream, LZ4Factory.fastestInstance().safeDecompressor(), XXHashFactory.fastestInstance().hash32());
    }

    private boolean nextFrameInfo() throws IOException {
        while (true) {
            int i2 = 0;
            do {
                int i3 = ((FilterInputStream) this).in.read(this.readNumberBuff.array(), i2, 4 - i2);
                if (i3 < 0) {
                    if (!this.firstFrameHeaderRead) {
                        throw new IOException(PREMATURE_EOS);
                    }
                    if (i2 <= 0) {
                        return false;
                    }
                    throw new IOException(PREMATURE_EOS);
                }
                i2 += i3;
            } while (i2 < 4);
            int i4 = this.readNumberBuff.getInt(0);
            if (i4 == 407708164) {
                readHeader();
                return true;
            }
            if ((i4 >>> 4) != 25481893) {
                throw new IOException(NOT_SUPPORTED);
            }
            skippableFrame();
        }
    }

    private void readBlock() throws IOException {
        int i2 = readInt(((FilterInputStream) this).in);
        boolean z = (Integer.MIN_VALUE & i2) == 0;
        int iDecompress = i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (iDecompress == 0) {
            if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_CHECKSUM) && readInt(((FilterInputStream) this).in) != this.frameInfo.currentStreamHash()) {
                throw new IOException("Content checksum mismatch");
            }
            if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_SIZE) && this.expectedContentSize != this.totalContentSize) {
                throw new IOException("Size check mismatch");
            }
            this.frameInfo.finish();
            return;
        }
        byte[] bArr = z ? this.compressedBuffer : this.rawBuffer;
        if (iDecompress > this.maxBlockSize) {
            Locale locale = Locale.ROOT;
            throw new IOException(b.d(iDecompress, this.maxBlockSize, "Block size ", " exceeded max: "));
        }
        int i3 = 0;
        while (i3 < iDecompress) {
            int i4 = ((FilterInputStream) this).in.read(bArr, i3, iDecompress - i3);
            if (i4 < 0) {
                throw new IOException(PREMATURE_EOS);
            }
            i3 += i4;
        }
        if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.BLOCK_CHECKSUM) && readInt(((FilterInputStream) this).in) != this.checksum.hash(bArr, 0, iDecompress, 0)) {
            throw new IOException(BLOCK_HASH_MISMATCH);
        }
        if (z) {
            try {
                LZ4SafeDecompressor lZ4SafeDecompressor = this.decompressor;
                byte[] bArr2 = this.rawBuffer;
                iDecompress = lZ4SafeDecompressor.decompress(bArr, 0, iDecompress, bArr2, 0, bArr2.length);
            } catch (LZ4Exception e2) {
                throw new IOException(e2);
            }
        }
        if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_CHECKSUM)) {
            this.frameInfo.updateStreamHash(this.rawBuffer, 0, iDecompress);
        }
        this.totalContentSize += iDecompress;
        this.buffer.limit(iDecompress);
        this.buffer.rewind();
    }

    private void readHeader() throws IOException {
        this.headerBuffer.rewind();
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        byte b2 = (byte) (i2 & 255);
        LZ4FrameOutputStream.FLG flgFromByte = LZ4FrameOutputStream.FLG.fromByte(b2);
        this.headerBuffer.put(b2);
        byte b3 = (byte) (i3 & 255);
        LZ4FrameOutputStream.BD bdFromByte = LZ4FrameOutputStream.BD.fromByte(b3);
        this.headerBuffer.put(b3);
        this.frameInfo = new LZ4FrameOutputStream.FrameInfo(flgFromByte, bdFromByte);
        if (flgFromByte.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_SIZE)) {
            long j2 = readLong(((FilterInputStream) this).in);
            this.expectedContentSize = j2;
            this.headerBuffer.putLong(j2);
        }
        this.totalContentSize = 0L;
        byte bHash = (byte) ((this.checksum.hash(this.headerArray, 0, this.headerBuffer.position(), 0) >> 8) & 255);
        int i4 = ((FilterInputStream) this).in.read();
        if (i4 < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        if (bHash != ((byte) (i4 & 255))) {
            throw new IOException(DESCRIPTOR_HASH_MISMATCH);
        }
        int blockMaximumSize = this.frameInfo.getBD().getBlockMaximumSize();
        this.maxBlockSize = blockMaximumSize;
        this.compressedBuffer = new byte[blockMaximumSize];
        byte[] bArr = new byte[blockMaximumSize];
        this.rawBuffer = bArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.buffer = byteBufferWrap;
        byteBufferWrap.limit(0);
        this.firstFrameHeaderRead = true;
    }

    private int readInt(InputStream inputStream) throws IOException {
        int i2 = 0;
        do {
            int i3 = inputStream.read(this.readNumberBuff.array(), i2, 4 - i2);
            if (i3 < 0) {
                throw new IOException(PREMATURE_EOS);
            }
            i2 += i3;
        } while (i2 < 4);
        return this.readNumberBuff.getInt(0);
    }

    private long readLong(InputStream inputStream) throws IOException {
        int i2 = 0;
        do {
            int i3 = inputStream.read(this.readNumberBuff.array(), i2, 8 - i2);
            if (i3 < 0) {
                throw new IOException(PREMATURE_EOS);
            }
            i2 += i3;
        } while (i2 < 8);
        return this.readNumberBuff.getLong(0);
    }

    private void skippableFrame() throws IOException {
        int i2 = readInt(((FilterInputStream) this).in);
        byte[] bArr = new byte[1024];
        while (i2 > 0) {
            int i3 = ((FilterInputStream) this).in.read(bArr, 0, Math.min(i2, 1024));
            if (i3 < 0) {
                throw new IOException(PREMATURE_EOS);
            }
            i2 -= i3;
        }
        this.firstFrameHeaderRead = true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.buffer.remaining();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    public long getExpectedContentSize() throws IOException {
        if (!this.readSingleFrame) {
            throw new UnsupportedOperationException("Operation not permitted when multiple frames can be read");
        }
        if (this.firstFrameHeaderRead || nextFrameInfo()) {
            return this.expectedContentSize;
        }
        return -1L;
    }

    public boolean isExpectedContentSizeDefined() throws IOException {
        return this.readSingleFrame && (this.firstFrameHeaderRead || nextFrameInfo()) && this.expectedContentSize >= 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        throw new UnsupportedOperationException("mark not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        while (true) {
            if (this.firstFrameHeaderRead && this.buffer.remaining() != 0) {
                return this.buffer.get() & 255;
            }
            if ((!this.firstFrameHeaderRead || this.frameInfo.isFinished()) && ((this.firstFrameHeaderRead && this.readSingleFrame) || !nextFrameInfo())) {
                return -1;
            }
            readBlock();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        if (j2 <= 0) {
            return 0L;
        }
        while (true) {
            if (this.firstFrameHeaderRead && this.buffer.remaining() != 0) {
                long jMin = Math.min(j2, this.buffer.remaining());
                ByteBuffer byteBuffer = this.buffer;
                byteBuffer.position(byteBuffer.position() + ((int) jMin));
                return jMin;
            }
            if ((!this.firstFrameHeaderRead || this.frameInfo.isFinished()) && ((this.firstFrameHeaderRead && this.readSingleFrame) || !nextFrameInfo())) {
                return 0L;
            }
            readBlock();
        }
    }

    public LZ4FrameInputStream(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, LZ4Factory.fastestInstance().safeDecompressor(), XXHashFactory.fastestInstance().hash32(), z);
    }

    public LZ4FrameInputStream(InputStream inputStream, LZ4SafeDecompressor lZ4SafeDecompressor, XXHash32 xXHash32) throws IOException {
        this(inputStream, lZ4SafeDecompressor, xXHash32, false);
    }

    public LZ4FrameInputStream(InputStream inputStream, LZ4SafeDecompressor lZ4SafeDecompressor, XXHash32 xXHash32, boolean z) throws IOException {
        super(inputStream);
        byte[] bArr = new byte[15];
        this.headerArray = bArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.headerBuffer = byteBufferWrap.order(byteOrder);
        this.buffer = null;
        this.rawBuffer = null;
        this.maxBlockSize = -1;
        this.expectedContentSize = -1L;
        this.totalContentSize = 0L;
        this.firstFrameHeaderRead = false;
        this.frameInfo = null;
        this.readNumberBuff = ByteBuffer.allocate(8).order(byteOrder);
        this.decompressor = lZ4SafeDecompressor;
        this.checksum = xXHash32;
        this.readSingleFrame = z;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        while (true) {
            if (this.firstFrameHeaderRead && this.buffer.remaining() != 0) {
                int iMin = Math.min(i3, this.buffer.remaining());
                this.buffer.get(bArr, i2, iMin);
                return iMin;
            }
            if ((!this.firstFrameHeaderRead || this.frameInfo.isFinished()) && ((this.firstFrameHeaderRead && this.readSingleFrame) || !nextFrameInfo())) {
                return -1;
            }
            readBlock();
        }
    }
}
