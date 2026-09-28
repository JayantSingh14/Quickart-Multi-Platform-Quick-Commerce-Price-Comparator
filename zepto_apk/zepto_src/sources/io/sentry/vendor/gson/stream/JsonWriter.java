package io.sentry.vendor.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable, AutoCloseable {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f53159i = new String[128];

    /* renamed from: a, reason: collision with root package name */
    public final Writer f53160a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f53161b;

    /* renamed from: c, reason: collision with root package name */
    public int f53162c;

    /* renamed from: d, reason: collision with root package name */
    public String f53163d;

    /* renamed from: e, reason: collision with root package name */
    public String f53164e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f53165f;

    /* renamed from: g, reason: collision with root package name */
    public String f53166g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f53167h;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f53159i[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f53159i;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] iArr = new int[32];
        this.f53161b = iArr;
        this.f53162c = 0;
        if (iArr.length == 0) {
            this.f53161b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f53161b;
        int i2 = this.f53162c;
        this.f53162c = i2 + 1;
        iArr2[i2] = 6;
        this.f53164e = ":";
        this.f53167h = true;
        this.f53160a = writer;
    }

    public final void a() throws IOException {
        int iL = l();
        if (iL == 1) {
            this.f53161b[this.f53162c - 1] = 2;
            c();
            return;
        }
        Writer writer = this.f53160a;
        if (iL == 2) {
            writer.append(',');
            c();
        } else {
            if (iL == 4) {
                writer.append((CharSequence) this.f53164e);
                this.f53161b[this.f53162c - 1] = 5;
                return;
            }
            if (iL != 6) {
                if (iL != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f53165f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f53161b[this.f53162c - 1] = 7;
        }
    }

    public final void b(int i2, int i3, char c2) throws IOException {
        int iL = l();
        if (iL != i3 && iL != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f53166g != null) {
            throw new IllegalStateException("Dangling name: " + this.f53166g);
        }
        this.f53162c--;
        if (iL == i3) {
            c();
        }
        this.f53160a.write(c2);
    }

    public final void c() throws IOException {
        if (this.f53163d == null) {
            return;
        }
        Writer writer = this.f53160a;
        writer.write(10);
        int i2 = this.f53162c;
        for (int i3 = 1; i3 < i2; i3++) {
            writer.write(this.f53163d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f53160a.close();
        int i2 = this.f53162c;
        if (i2 > 1 || (i2 == 1 && this.f53161b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f53162c = 0;
    }

    public final void e() throws IOException {
        if (this.f53166g != null) {
            if (!this.f53167h) {
                this.f53166g = null;
                return;
            }
            s();
        }
        a();
        this.f53160a.write("null");
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.f53162c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f53160a.flush();
    }

    public final int l() {
        int i2 = this.f53162c;
        if (i2 != 0) {
            return this.f53161b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String[] r0 = io.sentry.vendor.gson.stream.JsonWriter.f53159i
            java.io.Writer r1 = r8.f53160a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        Lf:
            if (r4 >= r3) goto L3a
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L1e
            r6 = r0[r6]
            if (r6 != 0) goto L2b
            goto L37
        L1e:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L25
            java.lang.String r6 = "\\u2028"
            goto L2b
        L25:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L37
            java.lang.String r6 = "\\u2029"
        L2b:
            if (r5 >= r4) goto L32
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L32:
            r1.write(r6)
            int r5 = r4 + 1
        L37:
            int r4 = r4 + 1
            goto Lf
        L3a:
            if (r5 >= r3) goto L40
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L40:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.JsonWriter.r(java.lang.String):void");
    }

    public final void s() throws IOException {
        if (this.f53166g != null) {
            int iL = l();
            if (iL == 5) {
                this.f53160a.write(44);
            } else if (iL != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            c();
            this.f53161b[this.f53162c - 1] = 4;
            r(this.f53166g);
            this.f53166g = null;
        }
    }
}
