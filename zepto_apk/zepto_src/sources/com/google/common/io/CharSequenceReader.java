package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
final class CharSequenceReader extends Reader implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public String f43236a;

    /* renamed from: b, reason: collision with root package name */
    public int f43237b;

    /* renamed from: c, reason: collision with root package name */
    public int f43238c;

    public final void a() throws IOException {
        if (this.f43236a == null) {
            throw new IOException("reader closed");
        }
    }

    public final int b() {
        Objects.requireNonNull(this.f43236a);
        return this.f43236a.length() - this.f43237b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f43236a = null;
    }

    @Override // java.io.Reader
    public final synchronized void mark(int i2) {
        Preconditions.e("readAheadLimit (%s) may not be negative", i2, i2 >= 0);
        a();
        this.f43238c = this.f43237b;
    }

    @Override // java.io.Reader
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public final synchronized int read() {
        char cCharAt;
        a();
        Objects.requireNonNull(this.f43236a);
        if (b() > 0) {
            String str = this.f43236a;
            int i2 = this.f43237b;
            this.f43237b = i2 + 1;
            cCharAt = str.charAt(i2);
        } else {
            cCharAt = 65535;
        }
        return cCharAt;
    }

    @Override // java.io.Reader
    public final synchronized boolean ready() {
        a();
        return true;
    }

    @Override // java.io.Reader
    public final synchronized void reset() {
        a();
        this.f43237b = this.f43238c;
    }

    @Override // java.io.Reader
    public final synchronized long skip(long j2) {
        int iMin;
        Preconditions.c(j2, "n (%s) may not be negative", j2 >= 0);
        a();
        iMin = (int) Math.min(b(), j2);
        this.f43237b += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public final synchronized int read(char[] cArr, int i2, int i3) {
        Preconditions.l(i2, i2 + i3, cArr.length);
        a();
        Objects.requireNonNull(this.f43236a);
        if (!(b() > 0)) {
            return -1;
        }
        int iMin = Math.min(i3, b());
        for (int i4 = 0; i4 < iMin; i4++) {
            String str = this.f43236a;
            int i5 = this.f43237b;
            this.f43237b = i5 + 1;
            cArr[i2 + i4] = str.charAt(i5);
        }
        return iMin;
    }

    @Override // java.io.Reader, java.lang.Readable
    public final synchronized int read(CharBuffer charBuffer) {
        charBuffer.getClass();
        a();
        Objects.requireNonNull(this.f43236a);
        if (!(b() > 0)) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), b());
        for (int i2 = 0; i2 < iMin; i2++) {
            String str = this.f43236a;
            int i3 = this.f43237b;
            this.f43237b = i3 + 1;
            charBuffer.put(str.charAt(i3));
        }
        return iMin;
    }
}
