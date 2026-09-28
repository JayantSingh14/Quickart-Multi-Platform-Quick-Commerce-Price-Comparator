package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.Writer;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class CharStreams {

    public static final class NullWriter extends Writer implements AutoCloseable {
        static {
            new NullWriter();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Writer append(char c2) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
        }

        public final String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public final void write(int i2) {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Writer append(CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            Preconditions.l(i2, i3 + i2, cArr.length);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Appendable append(char c2) {
            return this;
        }

        @Override // java.io.Writer
        public final void write(String str, int i2, int i3) {
            Preconditions.l(i2, i3 + i2, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer
        public final void write(String str) {
            str.getClass();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i3) {
            append(charSequence, i2, i3);
            return this;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr) {
            cArr.getClass();
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Writer append(CharSequence charSequence, int i2, int i3) {
            Preconditions.l(i2, i3, charSequence == null ? 4 : charSequence.length());
            return this;
        }
    }
}
