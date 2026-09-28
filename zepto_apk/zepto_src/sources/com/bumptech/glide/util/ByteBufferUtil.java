package com.bumptech.glide.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
public final class ByteBufferUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f16504a = new AtomicReference();

    public static final class SafeArray {

        /* renamed from: a, reason: collision with root package name */
        public final int f16507a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16508b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f16509c;

        public SafeArray(byte[] bArr, int i2, int i3) {
            this.f16509c = bArr;
            this.f16507a = i2;
            this.f16508b = i3;
        }
    }

    public static MappedByteBuffer a(File file) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > TTL.MAX_VALUE) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        SafeArray safeArray = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (safeArray != null && safeArray.f16507a == 0) {
            if (safeArray.f16508b == safeArray.f16509c.length) {
                return byteBuffer.array();
            }
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void c(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream d(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static class ByteBufferStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16505a;

        /* renamed from: b, reason: collision with root package name */
        public int f16506b = -1;

        public ByteBufferStream(ByteBuffer byteBuffer) {
            this.f16505a = byteBuffer;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f16505a.remaining();
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int i2) {
            this.f16506b = this.f16505a.position();
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read() {
            ByteBuffer byteBuffer = this.f16505a;
            if (byteBuffer.hasRemaining()) {
                return byteBuffer.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            int i2 = this.f16506b;
            if (i2 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f16505a.position(i2);
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            ByteBuffer byteBuffer = this.f16505a;
            if (!byteBuffer.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j2, byteBuffer.remaining());
            byteBuffer.position((int) (byteBuffer.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            ByteBuffer byteBuffer = this.f16505a;
            if (!byteBuffer.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i3, byteBuffer.remaining());
            byteBuffer.get(bArr, i2, iMin);
            return iMin;
        }
    }
}
