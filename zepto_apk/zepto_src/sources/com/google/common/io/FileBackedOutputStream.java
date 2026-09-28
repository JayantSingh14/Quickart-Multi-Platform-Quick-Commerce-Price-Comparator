package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
/* loaded from: classes4.dex */
public final class FileBackedOutputStream extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public FileOutputStream f43245a;

    /* renamed from: b, reason: collision with root package name */
    public MemoryOutput f43246b;

    /* renamed from: com.google.common.io.FileBackedOutputStream$1, reason: invalid class name */
    class AnonymousClass1 extends ByteSource {
        public final void finalize() {
            try {
                throw null;
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }
    }

    /* renamed from: com.google.common.io.FileBackedOutputStream$2, reason: invalid class name */
    class AnonymousClass2 extends ByteSource {
    }

    public static class MemoryOutput extends ByteArrayOutputStream {
        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public final int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public final void a(int i2) throws IOException {
        MemoryOutput memoryOutput = this.f43246b;
        if (memoryOutput == null || memoryOutput.getCount() + i2 <= 0) {
            return;
        }
        File fileA = TempFileCreator.f43255a.a();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileA);
            fileOutputStream.write(this.f43246b.a(), 0, this.f43246b.getCount());
            fileOutputStream.flush();
            this.f43245a = fileOutputStream;
            this.f43246b = null;
        } catch (IOException e2) {
            fileA.delete();
            throw e2;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f43245a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final synchronized void flush() {
        this.f43245a.flush();
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        a(1);
        this.f43245a.write(i2);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i3) {
        a(i3);
        this.f43245a.write(bArr, i2, i3);
    }
}
