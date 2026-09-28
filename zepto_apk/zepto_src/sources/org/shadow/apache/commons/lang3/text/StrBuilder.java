package org.shadow.apache.commons.lang3.text;

import android.support.v4.media.b;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.List;
import org.shadow.apache.commons.lang3.builder.Builder;

/* loaded from: classes5.dex */
public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {

    /* renamed from: a, reason: collision with root package name */
    public char[] f57764a = new char[32];

    /* renamed from: b, reason: collision with root package name */
    public int f57765b;

    public class StrBuilderTokenizer extends StrTokenizer {
        @Override // org.shadow.apache.commons.lang3.text.StrTokenizer
        public final List e(char[] cArr, int i2) {
            cArr.getClass();
            return super.e(cArr, i2);
        }
    }

    public class StrBuilderWriter extends Writer implements AutoCloseable {
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

        @Override // java.io.Writer
        public final void write(char[] cArr) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(String str) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(String str, int i2, int i3) {
            throw null;
        }
    }

    public final StrBuilder a(String str) {
        int length;
        if (str != null && (length = str.length()) > 0) {
            int i2 = this.f57765b;
            d(i2 + length);
            str.getChars(0, length, this.f57764a, i2);
            this.f57765b += length;
        }
        return this;
    }

    @Override // java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(char c2) {
        b(c2);
        return this;
    }

    public final void b(char c2) {
        d(this.f57765b + 1);
        char[] cArr = this.f57764a;
        int i2 = this.f57765b;
        this.f57765b = i2 + 1;
        cArr[i2] = c2;
    }

    public final void c(char[] cArr, int i2, int i3) {
        if (cArr == null) {
            return;
        }
        if (i2 < 0 || i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException(b.f(i3, "Invalid startIndex: "));
        }
        if (i3 < 0 || i2 + i3 > cArr.length) {
            throw new StringIndexOutOfBoundsException(b.f(i3, "Invalid length: "));
        }
        if (i3 > 0) {
            int i4 = this.f57765b;
            d(i4 + i3);
            System.arraycopy(cArr, i2, this.f57764a, i4, i3);
            this.f57765b += i3;
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        if (i2 < 0 || i2 >= this.f57765b) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        return this.f57764a[i2];
    }

    public final void d(int i2) {
        char[] cArr = this.f57764a;
        if (i2 > cArr.length) {
            char[] cArr2 = new char[i2 * 2];
            this.f57764a = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.f57765b);
        }
    }

    public final String e(int i2, int i3) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        int i4 = this.f57765b;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i2 <= i3) {
            return new String(this.f57764a, i2, i3 - i2);
        }
        throw new StringIndexOutOfBoundsException("end < start");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StrBuilder)) {
            return false;
        }
        StrBuilder strBuilder = (StrBuilder) obj;
        if (this != strBuilder) {
            int i2 = this.f57765b;
            if (i2 == strBuilder.f57765b) {
                char[] cArr = this.f57764a;
                char[] cArr2 = strBuilder.f57764a;
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    if (cArr[i3] == cArr2[i3]) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        char[] cArr = this.f57764a;
        int i2 = 0;
        for (int i3 = this.f57765b - 1; i3 >= 0; i3--) {
            i2 = (i2 * 31) + cArr[i3];
        }
        return i2;
    }

    public final boolean isEmpty() {
        return this.f57765b == 0;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f57765b;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i3 > this.f57765b) {
            throw new StringIndexOutOfBoundsException(i3);
        }
        if (i2 <= i3) {
            return e(i2, i3);
        }
        throw new StringIndexOutOfBoundsException(i3 - i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return new String(this.f57764a, 0, this.f57765b);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence instanceof StrBuilder) {
                StrBuilder strBuilder = (StrBuilder) charSequence;
                int i2 = strBuilder.f57765b;
                if (i2 > 0) {
                    int i3 = this.f57765b;
                    d(i3 + i2);
                    System.arraycopy(strBuilder.f57764a, 0, this.f57764a, i3, i2);
                    this.f57765b += i2;
                    return this;
                }
            } else if (charSequence instanceof StringBuilder) {
                StringBuilder sb = (StringBuilder) charSequence;
                int length = sb.length();
                if (length > 0) {
                    int i4 = this.f57765b;
                    d(i4 + length);
                    sb.getChars(0, length, this.f57764a, i4);
                    this.f57765b += length;
                    return this;
                }
            } else {
                if (!(charSequence instanceof StringBuffer)) {
                    if (!(charSequence instanceof CharBuffer)) {
                        a(charSequence.toString());
                        return this;
                    }
                    CharBuffer charBuffer = (CharBuffer) charSequence;
                    if (!charBuffer.hasArray()) {
                        a(charBuffer.toString());
                        return this;
                    }
                    int iRemaining = charBuffer.remaining();
                    int i5 = this.f57765b;
                    d(i5 + iRemaining);
                    System.arraycopy(charBuffer.array(), charBuffer.position() + charBuffer.arrayOffset(), this.f57764a, i5, iRemaining);
                    this.f57765b += iRemaining;
                    return this;
                }
                StringBuffer stringBuffer = (StringBuffer) charSequence;
                int length2 = stringBuffer.length();
                if (length2 > 0) {
                    int i6 = this.f57765b;
                    d(i6 + length2);
                    stringBuffer.getChars(0, length2, this.f57764a, i6);
                    this.f57765b += length2;
                }
            }
        }
        return this;
    }

    public class StrBuilderReader extends Reader implements AutoCloseable {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.Reader
        public final void mark(int i2) {
            throw null;
        }

        @Override // java.io.Reader
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i2, int i3) {
            int i4;
            if (i2 < 0 || i3 < 0 || i2 > cArr.length || (i4 = i2 + i3) > cArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            throw null;
        }

        @Override // java.io.Reader
        public final boolean ready() {
            throw null;
        }

        @Override // java.io.Reader
        public final void reset() {
            throw null;
        }

        @Override // java.io.Reader
        public final long skip(long j2) {
            throw null;
        }

        @Override // java.io.Reader
        public final int read() {
            throw null;
        }
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) {
        String string;
        int i4;
        if (charSequence != null && (string = charSequence.toString()) != null) {
            if (i2 >= 0 && i2 <= string.length()) {
                if (i3 < 0 || (i4 = i2 + i3) > string.length()) {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
                if (i3 > 0) {
                    int i5 = this.f57765b;
                    d(i5 + i3);
                    string.getChars(i2, i4, this.f57764a, i5);
                    this.f57765b += i3;
                }
            } else {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
        }
        return this;
    }
}
