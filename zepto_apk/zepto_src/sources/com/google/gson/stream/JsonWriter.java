package com.google.gson.stream;

import com.google.gson.FormattingStyle;
import com.google.gson.Strictness;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable, AutoCloseable {

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f45486l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f45487m = new String[128];
    public static final String[] n;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f45488a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f45489b;

    /* renamed from: c, reason: collision with root package name */
    public int f45490c;

    /* renamed from: d, reason: collision with root package name */
    public FormattingStyle f45491d;

    /* renamed from: e, reason: collision with root package name */
    public String f45492e;

    /* renamed from: f, reason: collision with root package name */
    public String f45493f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f45494g;

    /* renamed from: h, reason: collision with root package name */
    public Strictness f45495h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f45496i;

    /* renamed from: j, reason: collision with root package name */
    public String f45497j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f45498k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f45487m[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f45487m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] iArr = new int[32];
        this.f45489b = iArr;
        this.f45490c = 0;
        if (iArr.length == 0) {
            this.f45489b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f45489b;
        int i2 = this.f45490c;
        this.f45490c = i2 + 1;
        iArr2[i2] = 6;
        this.f45495h = Strictness.f45266b;
        this.f45498k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f45488a = writer;
        A(FormattingStyle.f45220d);
    }

    public final void A(FormattingStyle formattingStyle) {
        Objects.requireNonNull(formattingStyle);
        this.f45491d = formattingStyle;
        this.f45493f = ",";
        if (formattingStyle.f45224c) {
            this.f45492e = ": ";
            if (formattingStyle.f45222a.isEmpty()) {
                this.f45493f = ", ";
            }
        } else {
            this.f45492e = ":";
        }
        this.f45494g = this.f45491d.f45222a.isEmpty() && this.f45491d.f45223b.isEmpty();
    }

    public final void D(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.f45495h = strictness;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f45496i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.n
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f45487m
        L9:
            java.io.Writer r1 = r8.f45488a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.N(java.lang.String):void");
    }

    public void O(double d2) throws IOException {
        l0();
        if (this.f45495h == Strictness.f45265a || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            a();
            this.f45488a.append((CharSequence) Double.toString(d2));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
    }

    public void T(long j2) throws IOException {
        l0();
        a();
        this.f45488a.write(Long.toString(j2));
    }

    public void V(Boolean bool) throws IOException {
        if (bool == null) {
            s();
            return;
        }
        l0();
        a();
        this.f45488a.write(bool.booleanValue() ? "true" : "false");
    }

    public void Z(Number number) throws IOException {
        if (number == null) {
            s();
            return;
        }
        l0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !f45486l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (this.f45495h != Strictness.f45265a) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        a();
        this.f45488a.append((CharSequence) string);
    }

    public final void a() throws IOException {
        int iX = x();
        if (iX == 1) {
            this.f45489b[this.f45490c - 1] = 2;
            r();
            return;
        }
        Writer writer = this.f45488a;
        if (iX == 2) {
            writer.append((CharSequence) this.f45493f);
            r();
        } else {
            if (iX == 4) {
                writer.append((CharSequence) this.f45492e);
                this.f45489b[this.f45490c - 1] = 5;
                return;
            }
            if (iX != 6) {
                if (iX != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f45495h != Strictness.f45265a) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f45489b[this.f45490c - 1] = 7;
        }
    }

    public void b() throws IOException {
        l0();
        a();
        int i2 = this.f45490c;
        int[] iArr = this.f45489b;
        if (i2 == iArr.length) {
            this.f45489b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f45489b;
        int i3 = this.f45490c;
        this.f45490c = i3 + 1;
        iArr2[i3] = 1;
        this.f45488a.write(91);
    }

    public final void c(int i2, int i3, char c2) throws IOException {
        int iX = x();
        if (iX != i3 && iX != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f45497j != null) {
            throw new IllegalStateException("Dangling name: " + this.f45497j);
        }
        this.f45490c--;
        if (iX == i3) {
            r();
        }
        this.f45488a.write(c2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f45488a.close();
        int i2 = this.f45490c;
        if (i2 > 1 || (i2 == 1 && this.f45489b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f45490c = 0;
    }

    public void e() throws IOException {
        c(1, 2, ']');
    }

    public void flush() throws IOException {
        if (this.f45490c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f45488a.flush();
    }

    public void j0(String str) throws IOException {
        if (str == null) {
            s();
            return;
        }
        l0();
        a();
        N(str);
    }

    public void k() throws IOException {
        l0();
        a();
        int i2 = this.f45490c;
        int[] iArr = this.f45489b;
        if (i2 == iArr.length) {
            this.f45489b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f45489b;
        int i3 = this.f45490c;
        this.f45490c = i3 + 1;
        iArr2[i3] = 3;
        this.f45488a.write(WKSRecord.Service.NTP);
    }

    public void k0(boolean z) throws IOException {
        l0();
        a();
        this.f45488a.write(z ? "true" : "false");
    }

    public void l(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f45497j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iX = x();
        if (iX != 3 && iX != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f45497j = str;
    }

    public final void l0() throws IOException {
        if (this.f45497j != null) {
            int iX = x();
            if (iX == 5) {
                this.f45488a.write(this.f45493f);
            } else if (iX != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            r();
            this.f45489b[this.f45490c - 1] = 4;
            N(this.f45497j);
            this.f45497j = null;
        }
    }

    public final void r() throws IOException {
        if (this.f45494g) {
            return;
        }
        String str = this.f45491d.f45222a;
        Writer writer = this.f45488a;
        writer.write(str);
        int i2 = this.f45490c;
        for (int i3 = 1; i3 < i2; i3++) {
            writer.write(this.f45491d.f45223b);
        }
    }

    public JsonWriter s() throws IOException {
        if (this.f45497j != null) {
            if (!this.f45498k) {
                this.f45497j = null;
                return this;
            }
            l0();
        }
        a();
        this.f45488a.write("null");
        return this;
    }

    public void t() throws IOException {
        c(3, 5, '}');
    }

    public final int x() {
        int i2 = this.f45490c;
        if (i2 != 0) {
            return this.f45489b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}
