package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.IOException;
import java.io.Writer;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
class AppendableWriter extends Writer implements AutoCloseable {
    public final void a() throws IOException {
        throw new IOException("Cannot write to a closed writer.");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c2) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c2) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer
    public final void write(int i2) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer
    public final void write(String str) throws IOException {
        str.getClass();
        a();
        throw null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
        a();
        throw null;
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i3) throws IOException {
        str.getClass();
        a();
        throw null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
        a();
        throw null;
    }
}
