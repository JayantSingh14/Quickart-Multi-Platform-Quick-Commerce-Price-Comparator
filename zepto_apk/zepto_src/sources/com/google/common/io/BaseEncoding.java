package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class BaseEncoding {

    /* renamed from: a, reason: collision with root package name */
    public static final BaseEncoding f43222a;

    /* renamed from: com.google.common.io.BaseEncoding$1, reason: invalid class name */
    class AnonymousClass1 extends ByteSink {
    }

    /* renamed from: com.google.common.io.BaseEncoding$2, reason: invalid class name */
    class AnonymousClass2 extends ByteSource {
    }

    /* renamed from: com.google.common.io.BaseEncoding$3, reason: invalid class name */
    class AnonymousClass3 extends Reader implements AutoCloseable {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // java.io.Reader
        public final int read() {
            throw null;
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i2, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$4, reason: invalid class name */
    class AnonymousClass4 implements Appendable {
        @Override // java.lang.Appendable
        public final Appendable append(char c2) {
            throw null;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$5, reason: invalid class name */
    class AnonymousClass5 extends Writer implements AutoCloseable {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(int i2) {
            throw null;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Alphabet {

        /* renamed from: a, reason: collision with root package name */
        public final String f43223a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f43224b;

        /* renamed from: c, reason: collision with root package name */
        public final int f43225c;

        /* renamed from: d, reason: collision with root package name */
        public final int f43226d;

        /* renamed from: e, reason: collision with root package name */
        public final int f43227e;

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f43228f;

        public Alphabet(String str, char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            int i2 = 0;
            while (true) {
                if (i2 >= cArr.length) {
                    this.f43223a = str;
                    this.f43224b = cArr;
                    try {
                        int length = cArr.length;
                        RoundingMode roundingMode = RoundingMode.UNNECESSARY;
                        int iD = IntMath.d(length);
                        this.f43225c = iD;
                        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                        int i3 = 1 << (3 - iNumberOfTrailingZeros);
                        this.f43226d = i3;
                        this.f43227e = iD >> iNumberOfTrailingZeros;
                        this.f43228f = bArr;
                        boolean[] zArr = new boolean[i3];
                        for (int i4 = 0; i4 < this.f43227e; i4++) {
                            int i5 = this.f43225c;
                            RoundingMode roundingMode2 = RoundingMode.CEILING;
                            zArr[IntMath.c(i4 * 8, i5)] = true;
                        }
                        return;
                    } catch (ArithmeticException e2) {
                        throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
                    }
                }
                char c2 = cArr[i2];
                if (!(c2 < 128)) {
                    throw new IllegalArgumentException(Strings.a("Non-ASCII character: %s", Character.valueOf(c2)));
                }
                if (!(bArr[c2] == -1)) {
                    throw new IllegalArgumentException(Strings.a("Duplicate character: %s", Character.valueOf(c2)));
                }
                bArr[c2] = (byte) i2;
                i2++;
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Alphabet)) {
                return false;
            }
            Alphabet alphabet = (Alphabet) obj;
            alphabet.getClass();
            return Arrays.equals(this.f43224b, alphabet.f43224b);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f43224b) + 1237;
        }

        public final String toString() {
            return this.f43223a;
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {

        /* renamed from: d, reason: collision with root package name */
        public final char[] f43229d;

        public Base16Encoding() {
            Alphabet alphabet = new Alphabet("base16()", "0123456789ABCDEF".toCharArray());
            super(alphabet, (Character) null);
            this.f43229d = new char[512];
            char[] cArr = alphabet.f43224b;
            Preconditions.f(cArr.length == 16);
            for (int i2 = 0; i2 < 256; i2++) {
                char[] cArr2 = this.f43229d;
                cArr2[i2] = cArr[i2 >>> 4];
                cArr2[i2 | 256] = cArr[i2 & 15];
            }
        }
    }

    public static final class Base64Encoding extends StandardBaseEncoding {
        public Base64Encoding(String str, String str2) {
            Alphabet alphabet = new Alphabet(str, str2.toCharArray());
            super(alphabet, (Character) '=');
            Preconditions.f(alphabet.f43224b.length == 64);
        }
    }

    public static final class DecodingException extends IOException {
    }

    public static final class SeparatedBaseEncoding extends BaseEncoding {
        public final String toString() {
            return "null.withSeparator(\"null\", 0)";
        }
    }

    static {
        new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
        new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        f43222a = new Base16Encoding();
    }

    public static class StandardBaseEncoding extends BaseEncoding {

        /* renamed from: b, reason: collision with root package name */
        public final Alphabet f43230b;

        /* renamed from: c, reason: collision with root package name */
        public final Character f43231c;

        /* renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding$1, reason: invalid class name */
        class AnonymousClass1 extends OutputStream implements AutoCloseable {

            /* renamed from: a, reason: collision with root package name */
            public int f43232a;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                if (this.f43232a <= 0) {
                    throw null;
                }
                throw null;
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public final void flush() {
                throw null;
            }

            @Override // java.io.OutputStream
            public final void write(int i2) {
                this.f43232a += 8;
                throw null;
            }
        }

        /* renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding$2, reason: invalid class name */
        class AnonymousClass2 extends InputStream implements AutoCloseable {
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                throw null;
            }

            @Override // java.io.InputStream
            public final int read() {
                throw null;
            }

            @Override // java.io.InputStream
            public final int read(byte[] bArr, int i2, int i3) {
                int i4 = i3 + i2;
                Preconditions.l(i2, i4, bArr.length);
                if (i2 >= i4) {
                    return 0;
                }
                throw null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public StandardBaseEncoding(com.google.common.io.BaseEncoding.Alphabet r3, java.lang.Character r4) {
            /*
                r2 = this;
                r2.<init>()
                r2.f43230b = r3
                if (r4 == 0) goto L17
                char r0 = r4.charValue()
                byte[] r3 = r3.f43228f
                int r1 = r3.length
                if (r0 >= r1) goto L17
                r3 = r3[r0]
                r0 = -1
                if (r3 == r0) goto L17
                r3 = 0
                goto L18
            L17:
                r3 = 1
            L18:
                java.lang.String r0 = "Padding character %s was already in alphabet"
                com.google.common.base.Preconditions.h(r3, r0, r4)
                r2.f43231c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.<init>(com.google.common.io.BaseEncoding$Alphabet, java.lang.Character):void");
        }

        public final boolean equals(Object obj) {
            if (obj instanceof StandardBaseEncoding) {
                StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
                if (this.f43230b.equals(standardBaseEncoding.f43230b) && Objects.equals(this.f43231c, standardBaseEncoding.f43231c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f43230b.hashCode() ^ Objects.hashCode(this.f43231c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            Alphabet alphabet = this.f43230b;
            sb.append(alphabet);
            if (8 % alphabet.f43225c != 0) {
                Character ch2 = this.f43231c;
                if (ch2 == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(ch2);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public StandardBaseEncoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()), (Character) '=');
        }
    }
}
