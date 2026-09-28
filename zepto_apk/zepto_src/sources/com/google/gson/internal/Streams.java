package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Streams {

    /* loaded from: classes4.dex */
    public static final class AppendableWriter extends Writer implements AutoCloseable {

        public static class CurrentWrite implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            public char[] f45334a;

            /* renamed from: b, reason: collision with root package name */
            public String f45335b;

            @Override // java.lang.CharSequence
            public final char charAt(int i2) {
                return this.f45334a[i2];
            }

            @Override // java.lang.CharSequence
            public final int length() {
                return this.f45334a.length;
            }

            @Override // java.lang.CharSequence
            public final CharSequence subSequence(int i2, int i3) {
                return new String(this.f45334a, i2, i3 - i2);
            }

            @Override // java.lang.CharSequence
            public final String toString() {
                if (this.f45335b == null) {
                    this.f45335b = new String(this.f45334a);
                }
                return this.f45335b;
            }
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Writer append(CharSequence charSequence) {
            throw null;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
        }

        @Override // java.io.Writer
        public final void write(int i2) {
            throw null;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(String str, int i2, int i3) {
            Objects.requireNonNull(str);
            throw null;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Writer append(CharSequence charSequence, int i2, int i3) {
            throw null;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i2, int i3) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            throw null;
        }
    }

    public static JsonElement a(JsonReader jsonReader) {
        boolean z;
        try {
            try {
                jsonReader.j0();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return (JsonElement) TypeAdapters.z.b(jsonReader);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return JsonNull.f45255a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }
}
