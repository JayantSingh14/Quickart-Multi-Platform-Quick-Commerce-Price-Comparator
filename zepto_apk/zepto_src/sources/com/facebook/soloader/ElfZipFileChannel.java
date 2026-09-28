package com.facebook.soloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class ElfZipFileChannel implements ElfByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f20260a;

    /* renamed from: b, reason: collision with root package name */
    public final ZipEntry f20261b;

    /* renamed from: c, reason: collision with root package name */
    public final ZipFile f20262c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20263d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20264e = true;

    /* renamed from: f, reason: collision with root package name */
    public long f20265f = 0;

    public ElfZipFileChannel(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        this.f20262c = zipFile;
        this.f20261b = zipEntry;
        this.f20263d = zipEntry.getSize();
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        this.f20260a = inputStream;
        if (inputStream != null) {
            return;
        }
        throw new IOException(zipEntry.getName() + "'s InputStream is null");
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public final int R(ByteBuffer byteBuffer, long j2) throws IOException {
        if (this.f20260a == null) {
            throw new IOException("InputStream is null");
        }
        int iRemaining = byteBuffer.remaining();
        long j3 = this.f20263d;
        long j4 = j3 - j2;
        if (j4 <= 0) {
            return -1;
        }
        int i2 = (int) j4;
        if (iRemaining > i2) {
            iRemaining = i2;
        }
        InputStream inputStream = this.f20260a;
        ZipEntry zipEntry = this.f20261b;
        if (inputStream == null) {
            throw new IOException(zipEntry.getName() + "'s InputStream is null");
        }
        long j5 = this.f20265f;
        if (j2 != j5) {
            if (j2 > j3) {
                j2 = j3;
            }
            if (j2 >= j5) {
                inputStream.skip(j2 - j5);
            } else {
                inputStream.close();
                InputStream inputStream2 = this.f20262c.getInputStream(zipEntry);
                this.f20260a = inputStream2;
                if (inputStream2 == null) {
                    throw new IOException(zipEntry.getName() + "'s InputStream is null");
                }
                inputStream2.skip(j2);
            }
            this.f20265f = j2;
        }
        if (byteBuffer.hasArray()) {
            this.f20260a.read(byteBuffer.array(), 0, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else {
            byte[] bArr = new byte[iRemaining];
            this.f20260a.read(bArr, 0, iRemaining);
            byteBuffer.put(bArr, 0, iRemaining);
        }
        this.f20265f += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.f20260a;
        if (inputStream != null) {
            inputStream.close();
            this.f20264e = false;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.f20264e;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        return R(byteBuffer, this.f20265f);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }
}
