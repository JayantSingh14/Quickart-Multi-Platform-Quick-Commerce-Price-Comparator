package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzhyq implements Closeable, Flushable, AutoCloseable {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f34523j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f34524k = new String[128];

    /* renamed from: a, reason: collision with root package name */
    public final Writer f34525a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f34526b;

    /* renamed from: c, reason: collision with root package name */
    public int f34527c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhxh f34528d;

    /* renamed from: e, reason: collision with root package name */
    public final String f34529e;

    /* renamed from: f, reason: collision with root package name */
    public final String f34530f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f34531g;

    /* renamed from: h, reason: collision with root package name */
    public zzhxo f34532h;

    /* renamed from: i, reason: collision with root package name */
    public String f34533i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f34524k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f34524k;
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

    public zzhyq(Writer writer) {
        int[] iArr = new int[32];
        this.f34526b = iArr;
        boolean z = false;
        this.f34527c = 0;
        if (iArr.length == 0) {
            this.f34526b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f34526b;
        int i2 = this.f34527c;
        this.f34527c = i2 + 1;
        iArr2[i2] = 6;
        this.f34532h = zzhxo.f34473b;
        this.f34525a = writer;
        zzhxh zzhxhVar = zzhxh.f34464d;
        Objects.requireNonNull(zzhxhVar);
        this.f34528d = zzhxhVar;
        this.f34530f = ",";
        boolean z2 = zzhxhVar.f34467c;
        String str = zzhxhVar.f34465a;
        if (z2) {
            this.f34529e = ": ";
            if (str.isEmpty()) {
                this.f34530f = ", ";
            }
        } else {
            this.f34529e = ":";
        }
        if (str.isEmpty() && zzhxhVar.f34466b.isEmpty()) {
            z = true;
        }
        this.f34531g = z;
    }

    public final void a() throws IOException {
        if (this.f34533i != null) {
            e();
        }
        s();
        this.f34525a.write("null");
    }

    public final void b(int i2, int i3, char c2) throws IOException {
        int iC = c();
        if (iC != i3 && iC != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.f34533i;
        if (str != null) {
            throw new IllegalStateException("Dangling name: ".concat(str));
        }
        this.f34527c--;
        if (iC == i3) {
            r();
        }
        this.f34525a.write(c2);
    }

    public final int c() {
        int i2 = this.f34527c;
        if (i2 != 0) {
            return this.f34526b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f34525a.close();
        int i2 = this.f34527c;
        if (i2 > 1 || (i2 == 1 && this.f34526b[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f34527c = 0;
    }

    public final void e() throws IOException {
        if (this.f34533i != null) {
            int iC = c();
            if (iC == 5) {
                this.f34525a.write(this.f34530f);
            } else if (iC != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            r();
            this.f34526b[this.f34527c - 1] = 4;
            l(this.f34533i);
            this.f34533i = null;
        }
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.f34527c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f34525a.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            java.io.Writer r0 = r8.f34525a
            r1 = 34
            r0.write(r1)
            int r2 = r9.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L39
            int r5 = r3 + 1
            char r6 = r9.charAt(r3)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L20
            java.lang.String[] r7 = com.google.android.gms.internal.ads.zzhyq.f34524k
            r6 = r7[r6]
            if (r6 == 0) goto L37
            goto L2d
        L20:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L27
            java.lang.String r6 = "\\u2028"
            goto L2d
        L27:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L37
            java.lang.String r6 = "\\u2029"
        L2d:
            if (r4 >= r3) goto L33
            int r3 = r3 - r4
            r0.write(r9, r4, r3)
        L33:
            r0.write(r6)
            r4 = r5
        L37:
            r3 = r5
            goto Ld
        L39:
            if (r4 >= r2) goto L3f
            int r2 = r2 - r4
            r0.write(r9, r4, r2)
        L3f:
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyq.l(java.lang.String):void");
    }

    public final void r() throws IOException {
        if (this.f34531g) {
            return;
        }
        zzhxh zzhxhVar = this.f34528d;
        String str = zzhxhVar.f34465a;
        Writer writer = this.f34525a;
        writer.write(str);
        int i2 = this.f34527c;
        for (int i3 = 1; i3 < i2; i3++) {
            writer.write(zzhxhVar.f34466b);
        }
    }

    public final void s() throws IOException {
        int iC = c();
        if (iC == 1) {
            this.f34526b[this.f34527c - 1] = 2;
            r();
            return;
        }
        Writer writer = this.f34525a;
        if (iC == 2) {
            writer.append((CharSequence) this.f34530f);
            r();
        } else {
            if (iC == 4) {
                writer.append((CharSequence) this.f34529e);
                this.f34526b[this.f34527c - 1] = 5;
                return;
            }
            if (iC != 6) {
                if (iC != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f34532h != zzhxo.f34472a) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f34526b[this.f34527c - 1] = 7;
        }
    }
}
