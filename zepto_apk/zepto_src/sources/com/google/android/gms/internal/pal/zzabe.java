package com.google.android.gms.internal.pal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzabe implements Closeable, Flushable, AutoCloseable {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f37341g = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f37342h = new String[128];

    /* renamed from: a, reason: collision with root package name */
    public final StringWriter f37343a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37344b;

    /* renamed from: c, reason: collision with root package name */
    public int f37345c;

    /* renamed from: d, reason: collision with root package name */
    public final String f37346d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37347e;

    /* renamed from: f, reason: collision with root package name */
    public String f37348f;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f37342h[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f37342h;
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

    public zzabe(StringWriter stringWriter) {
        int[] iArr = new int[32];
        this.f37344b = iArr;
        this.f37345c = 0;
        if (iArr.length == 0) {
            this.f37344b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f37344b;
        int i2 = this.f37345c;
        this.f37345c = i2 + 1;
        iArr2[i2] = 6;
        this.f37346d = ":";
        this.f37343a = stringWriter;
    }

    public final int a() {
        int i2 = this.f37345c;
        if (i2 != 0) {
            return this.f37344b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void b(int i2, int i3, char c2) throws IOException {
        int iA = a();
        if (iA != i3 && iA != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.f37348f;
        if (str != null) {
            throw new IllegalStateException("Dangling name: ".concat(str));
        }
        this.f37345c--;
        this.f37343a.write(c2);
    }

    public final void c() throws IOException {
        int iA = a();
        if (iA == 1) {
            this.f37344b[this.f37345c - 1] = 2;
            return;
        }
        StringWriter stringWriter = this.f37343a;
        if (iA == 2) {
            stringWriter.append(',');
            return;
        }
        if (iA == 4) {
            stringWriter.append((CharSequence) this.f37346d);
            this.f37344b[this.f37345c - 1] = 5;
            return;
        }
        if (iA != 6) {
            if (iA != 7) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (!this.f37347e) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        }
        this.f37344b[this.f37345c - 1] = 7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f37343a.close();
        int i2 = this.f37345c;
        if (i2 > 1 || (i2 == 1 && this.f37344b[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f37345c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            java.io.StringWriter r0 = r7.f37343a
            r1 = 34
            r0.write(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L3a
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1e
            java.lang.String[] r6 = com.google.android.gms.internal.pal.zzabe.f37342h
            r5 = r6[r5]
            if (r5 != 0) goto L2b
            goto L37
        L1e:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L25
            java.lang.String r5 = "\\u2028"
            goto L2b
        L25:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L37
            java.lang.String r5 = "\\u2029"
        L2b:
            if (r4 >= r3) goto L32
            int r6 = r3 - r4
            r0.write(r8, r4, r6)
        L32:
            r0.write(r5)
            int r4 = r3 + 1
        L37:
            int r3 = r3 + 1
            goto Ld
        L3a:
            if (r4 >= r2) goto L40
            int r2 = r2 - r4
            r0.write(r8, r4, r2)
        L40:
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzabe.e(java.lang.String):void");
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.f37345c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f37343a.flush();
    }

    public final void l() throws IOException {
        if (this.f37348f != null) {
            int iA = a();
            if (iA == 5) {
                this.f37343a.write(44);
            } else if (iA != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.f37344b[this.f37345c - 1] = 4;
            e(this.f37348f);
            this.f37348f = null;
        }
    }
}
