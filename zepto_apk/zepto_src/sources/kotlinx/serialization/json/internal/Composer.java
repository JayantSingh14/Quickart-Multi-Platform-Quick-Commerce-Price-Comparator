package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class Composer {

    /* renamed from: a, reason: collision with root package name */
    public final JsonToStringWriter f56033a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f56034b;

    public Composer(JsonToStringWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.f56033a = writer;
        this.f56034b = true;
    }

    public void a() {
        this.f56034b = true;
    }

    public void b() {
        this.f56034b = false;
    }

    public void c() {
        this.f56034b = false;
    }

    public void d(byte b2) {
        this.f56033a.d(b2);
    }

    public final void e(char c2) {
        JsonToStringWriter jsonToStringWriter = this.f56033a;
        jsonToStringWriter.a(jsonToStringWriter.f56055b, 1);
        char[] cArr = jsonToStringWriter.f56054a;
        int i2 = jsonToStringWriter.f56055b;
        jsonToStringWriter.f56055b = i2 + 1;
        cArr[i2] = c2;
    }

    public void f(int i2) {
        this.f56033a.d(i2);
    }

    public void g(long j2) {
        this.f56033a.d(j2);
    }

    public final void h(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f56033a.c(v);
    }

    public void i(short s) {
        this.f56033a.d(s);
    }

    public void j(String text) {
        byte b2;
        Intrinsics.checkNotNullParameter(text, "value");
        JsonToStringWriter jsonToStringWriter = this.f56033a;
        Intrinsics.checkNotNullParameter(text, "text");
        jsonToStringWriter.a(jsonToStringWriter.f56055b, text.length() + 2);
        char[] cArr = jsonToStringWriter.f56054a;
        int i2 = jsonToStringWriter.f56055b;
        int i3 = i2 + 1;
        cArr[i2] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i3);
        int i4 = length + i3;
        int i5 = i3;
        while (i5 < i4) {
            char c2 = cArr[i5];
            byte[] bArr = StringOpsKt.f56106b;
            if (c2 < bArr.length && bArr[c2] != 0) {
                int length2 = text.length();
                for (int i6 = i5 - i3; i6 < length2; i6++) {
                    jsonToStringWriter.a(i5, 2);
                    char cCharAt = text.charAt(i6);
                    byte[] bArr2 = StringOpsKt.f56106b;
                    if (cCharAt >= bArr2.length || (b2 = bArr2[cCharAt]) == 0) {
                        int i7 = i5 + 1;
                        jsonToStringWriter.f56054a[i5] = cCharAt;
                        i5 = i7;
                    } else {
                        if (b2 == 1) {
                            String str = StringOpsKt.f56105a[cCharAt];
                            Intrinsics.c(str);
                            jsonToStringWriter.a(i5, str.length());
                            str.getChars(0, str.length(), jsonToStringWriter.f56054a, i5);
                            int length3 = str.length() + i5;
                            jsonToStringWriter.f56055b = length3;
                            i5 = length3;
                        } else {
                            char[] cArr2 = jsonToStringWriter.f56054a;
                            cArr2[i5] = '\\';
                            cArr2[i5 + 1] = (char) b2;
                            i5 += 2;
                            jsonToStringWriter.f56055b = i5;
                        }
                    }
                }
                jsonToStringWriter.a(i5, 1);
                jsonToStringWriter.f56054a[i5] = '\"';
                jsonToStringWriter.f56055b = i5 + 1;
                return;
            }
            i5++;
        }
        cArr[i4] = '\"';
        jsonToStringWriter.f56055b = i4 + 1;
    }

    public void k() {
    }

    public void l() {
    }
}
