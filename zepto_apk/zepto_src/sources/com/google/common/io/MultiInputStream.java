package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
final class MultiInputStream extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f43249a;

    @Override // java.io.InputStream
    public final int available() {
        InputStream inputStream = this.f43249a;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream inputStream = this.f43249a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f43249a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        InputStream inputStream = this.f43249a;
        if (inputStream == null) {
            return -1;
        }
        int i2 = inputStream.read();
        if (i2 != -1) {
            return i2;
        }
        close();
        throw null;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        InputStream inputStream = this.f43249a;
        if (inputStream == null || j2 <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j2);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f43249a.skip(j2 - 1) + 1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        bArr.getClass();
        InputStream inputStream = this.f43249a;
        if (inputStream == null) {
            return -1;
        }
        int i4 = inputStream.read(bArr, i2, i3);
        if (i4 != -1) {
            return i4;
        }
        close();
        throw null;
    }
}
