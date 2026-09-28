package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
class MultiReader extends Reader implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public Reader f43250a;

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Reader reader = this.f43250a;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f43250a = null;
            }
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i2, int i3) throws IOException {
        cArr.getClass();
        Reader reader = this.f43250a;
        if (reader == null) {
            return -1;
        }
        int i4 = reader.read(cArr, i2, i3);
        if (i4 != -1) {
            return i4;
        }
        close();
        throw null;
    }

    @Override // java.io.Reader
    public final boolean ready() {
        Reader reader = this.f43250a;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public final long skip(long j2) throws IOException {
        Reader reader;
        Preconditions.g(j2 >= 0, "n is negative");
        if (j2 <= 0 || (reader = this.f43250a) == null) {
            return 0L;
        }
        long jSkip = reader.skip(j2);
        if (jSkip > 0) {
            return jSkip;
        }
        close();
        throw null;
    }
}
