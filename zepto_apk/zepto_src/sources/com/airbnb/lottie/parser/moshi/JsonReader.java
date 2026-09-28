package com.airbnb.lottie.parser.moshi;

import android.support.v4.media.b;
import java.io.Closeable;
import java.util.Arrays;
import okio.RealBufferedSource;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f14746e = new String[128];

    /* renamed from: a, reason: collision with root package name */
    public int f14747a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f14748b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f14749c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f14750d;

    public static final class Options {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f14751a;

        /* renamed from: b, reason: collision with root package name */
        public final okio.Options f14752b;

        public Options(String[] strArr, okio.Options options) {
            this.f14751a = strArr;
            this.f14752b = options;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x006d, TryCatch #0 {IOException -> 0x006d, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x005b), top: B:30:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.airbnb.lottie.parser.moshi.JsonReader.Options a(java.lang.String... r12) {
            /*
                int r0 = r12.length     // Catch: java.io.IOException -> L6d
                okio.ByteString[] r0 = new okio.ByteString[r0]     // Catch: java.io.IOException -> L6d
                okio.Buffer r1 = new okio.Buffer     // Catch: java.io.IOException -> L6d
                r1.<init>()     // Catch: java.io.IOException -> L6d
                r2 = 0
                r3 = r2
            La:
                int r4 = r12.length     // Catch: java.io.IOException -> L6d
                if (r3 >= r4) goto L5b
                r4 = r12[r3]     // Catch: java.io.IOException -> L6d
                java.lang.String[] r5 = com.airbnb.lottie.parser.moshi.JsonReader.f14746e     // Catch: java.io.IOException -> L6d
                r6 = 34
                r1.O1(r6)     // Catch: java.io.IOException -> L6d
                int r7 = r4.length()     // Catch: java.io.IOException -> L6d
                r8 = r2
                r9 = r8
            L1c:
                if (r8 >= r7) goto L45
                char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L6d
                r11 = 128(0x80, float:1.794E-43)
                if (r10 >= r11) goto L2b
                r10 = r5[r10]     // Catch: java.io.IOException -> L6d
                if (r10 != 0) goto L38
                goto L42
            L2b:
                r11 = 8232(0x2028, float:1.1535E-41)
                if (r10 != r11) goto L32
                java.lang.String r10 = "\\u2028"
                goto L38
            L32:
                r11 = 8233(0x2029, float:1.1537E-41)
                if (r10 != r11) goto L42
                java.lang.String r10 = "\\u2029"
            L38:
                if (r9 >= r8) goto L3d
                r1.W1(r9, r8, r4)     // Catch: java.io.IOException -> L6d
            L3d:
                r1.X1(r10)     // Catch: java.io.IOException -> L6d
                int r9 = r8 + 1
            L42:
                int r8 = r8 + 1
                goto L1c
            L45:
                if (r9 >= r7) goto L4a
                r1.W1(r9, r7, r4)     // Catch: java.io.IOException -> L6d
            L4a:
                r1.O1(r6)     // Catch: java.io.IOException -> L6d
                r1.k0()     // Catch: java.io.IOException -> L6d
                long r4 = r1.f56914b     // Catch: java.io.IOException -> L6d
                okio.ByteString r4 = r1.s0(r4)     // Catch: java.io.IOException -> L6d
                r0[r3] = r4     // Catch: java.io.IOException -> L6d
                int r3 = r3 + 1
                goto La
            L5b:
                com.airbnb.lottie.parser.moshi.JsonReader$Options r1 = new com.airbnb.lottie.parser.moshi.JsonReader$Options     // Catch: java.io.IOException -> L6d
                java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L6d
                java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L6d
                int r2 = okio.Options.f56967d     // Catch: java.io.IOException -> L6d
                okio.Options r0 = okio.Options.Companion.b(r0)     // Catch: java.io.IOException -> L6d
                r1.<init>(r12, r0)     // Catch: java.io.IOException -> L6d
                return r1
            L6d:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.Options.a(java.lang.String[]):com.airbnb.lottie.parser.moshi.JsonReader$Options");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Token {

        /* renamed from: a, reason: collision with root package name */
        public static final Token f14753a;

        /* renamed from: b, reason: collision with root package name */
        public static final Token f14754b;

        /* renamed from: c, reason: collision with root package name */
        public static final Token f14755c;

        /* renamed from: d, reason: collision with root package name */
        public static final Token f14756d;

        /* renamed from: e, reason: collision with root package name */
        public static final Token f14757e;

        /* renamed from: f, reason: collision with root package name */
        public static final Token f14758f;

        /* renamed from: g, reason: collision with root package name */
        public static final Token f14759g;

        /* renamed from: h, reason: collision with root package name */
        public static final Token f14760h;

        /* renamed from: i, reason: collision with root package name */
        public static final Token f14761i;

        /* renamed from: j, reason: collision with root package name */
        public static final Token f14762j;

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ Token[] f14763k;

        static {
            Token token = new Token("BEGIN_ARRAY", 0);
            f14753a = token;
            Token token2 = new Token("END_ARRAY", 1);
            f14754b = token2;
            Token token3 = new Token("BEGIN_OBJECT", 2);
            f14755c = token3;
            Token token4 = new Token("END_OBJECT", 3);
            f14756d = token4;
            Token token5 = new Token("NAME", 4);
            f14757e = token5;
            Token token6 = new Token("STRING", 5);
            f14758f = token6;
            Token token7 = new Token("NUMBER", 6);
            f14759g = token7;
            Token token8 = new Token("BOOLEAN", 7);
            f14760h = token8;
            Token token9 = new Token("NULL", 8);
            f14761i = token9;
            Token token10 = new Token("END_DOCUMENT", 9);
            f14762j = token10;
            f14763k = new Token[]{token, token2, token3, token4, token5, token6, token7, token8, token9, token10};
        }

        public static Token valueOf(String str) {
            return (Token) Enum.valueOf(Token.class, str);
        }

        public static Token[] values() {
            return (Token[]) f14763k.clone();
        }
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f14746e[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f14746e;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader l(RealBufferedSource realBufferedSource) {
        return new JsonUtf8Reader(realBufferedSource);
    }

    public abstract void A();

    public final void D(String str) throws JsonEncodingException {
        StringBuilder sbX = b.x(str, " at path ");
        sbX.append(j());
        throw new JsonEncodingException(sbX.toString());
    }

    public abstract void E();

    public abstract String K0();

    public abstract String X();

    public abstract void a();

    public abstract void b();

    public abstract boolean c();

    public abstract boolean e();

    public final String j() {
        int i2 = this.f14747a;
        int[] iArr = this.f14748b;
        String[] strArr = this.f14749c;
        int[] iArr2 = this.f14750d;
        StringBuilder sb = new StringBuilder("$");
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(iArr2[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = strArr[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public abstract void k();

    public abstract double nextDouble();

    public abstract int nextInt();

    public abstract Token r();

    public final void s(int i2) {
        int i3 = this.f14747a;
        int[] iArr = this.f14748b;
        if (i3 == iArr.length) {
            if (i3 == 256) {
                throw new JsonDataException("Nesting too deep at " + j());
            }
            this.f14748b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f14749c;
            this.f14749c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f14750d;
            this.f14750d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f14748b;
        int i4 = this.f14747a;
        this.f14747a = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract void t();

    public abstract int x(Options options);
}
