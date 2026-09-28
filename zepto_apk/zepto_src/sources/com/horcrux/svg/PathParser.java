package com.horcrux.svg;

import android.graphics.Path;
import java.util.ArrayList;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
class PathParser {

    /* renamed from: a, reason: collision with root package name */
    public static float f45795a;

    /* renamed from: b, reason: collision with root package name */
    public static int f45796b;

    /* renamed from: c, reason: collision with root package name */
    public static int f45797c;

    /* renamed from: d, reason: collision with root package name */
    public static String f45798d;

    /* renamed from: e, reason: collision with root package name */
    public static Path f45799e;

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList f45800f;

    /* renamed from: g, reason: collision with root package name */
    public static float f45801g;

    /* renamed from: h, reason: collision with root package name */
    public static float f45802h;

    /* renamed from: i, reason: collision with root package name */
    public static float f45803i;

    /* renamed from: j, reason: collision with root package name */
    public static float f45804j;

    /* renamed from: k, reason: collision with root package name */
    public static float f45805k;

    /* renamed from: l, reason: collision with root package name */
    public static float f45806l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f45807m;

    /* JADX WARN: Removed duplicated region for block: B:57:0x01d1 A[LOOP:0: B:56:0x01cf->B:57:0x01d1, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(float r26, float r27, float r28, boolean r29, boolean r30, float r31, float r32) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.PathParser.a(float, float, float, boolean, boolean, float, float):void");
    }

    public static void b(float f2, float f3, float f4, float f5, float f6, float f7) {
        i();
        f45801g = f6;
        f45802h = f7;
        Path path = f45799e;
        float f8 = f45795a;
        path.cubicTo(f2 * f8, f3 * f8, f4 * f8, f5 * f8, f6 * f8, f8 * f7);
        f45800f.add(new PathElement(ElementType.f45651a, new Point[]{new Point(f2, f3), new Point(f4, f5), new Point(f6, f7)}));
    }

    public static void c(float f2, float f3) {
        i();
        f45801g = f2;
        f45803i = f2;
        f45802h = f3;
        f45804j = f3;
        Path path = f45799e;
        float f4 = f45795a;
        path.lineTo(f2 * f4, f4 * f3);
        f45800f.add(new PathElement(ElementType.f45653c, new Point[]{new Point(f2, f3)}));
    }

    public static void d(float f2, float f3) {
        f45801g = f2;
        f45803i = f2;
        f45805k = f2;
        f45802h = f3;
        f45804j = f3;
        f45806l = f3;
        Path path = f45799e;
        float f4 = f45795a;
        path.moveTo(f2 * f4, f4 * f3);
        f45800f.add(new PathElement(ElementType.f45652b, new Point[]{new Point(f2, f3)}));
    }

    public static Path e(String str) throws NumberFormatException {
        f45800f = new ArrayList();
        Path path = new Path();
        f45799e = path;
        if (str == null) {
            return path;
        }
        f45797c = str.length();
        f45798d = str;
        f45796b = 0;
        f45801g = 0.0f;
        f45802h = 0.0f;
        f45803i = 0.0f;
        f45804j = 0.0f;
        f45805k = 0.0f;
        f45806l = 0.0f;
        f45807m = false;
        char c2 = ' ';
        while (f45796b < f45797c) {
            k();
            int i2 = f45796b;
            if (i2 >= f45797c) {
                return f45799e;
            }
            boolean z = true;
            boolean z2 = c2 != ' ';
            char cCharAt = f45798d.charAt(i2);
            if (!z2 && cCharAt != 'M' && cCharAt != 'm') {
                throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f45796b), f45798d));
            }
            switch (cCharAt) {
                case 'A':
                case 'C':
                case WKSRecord.Service.NETRJS_2 /* 72 */:
                case 'L':
                case 'M':
                case WKSRecord.Service.HOSTS2_NS /* 81 */:
                case 'S':
                case 'T':
                case 'V':
                case 'Z':
                case WKSRecord.Service.SWIFT_RVF /* 97 */:
                case 'c':
                case 'h':
                case Type.EUI48 /* 108 */:
                case 'm':
                case WKSRecord.Service.AUTH /* 113 */:
                case WKSRecord.Service.SFTP /* 115 */:
                case 't':
                case 'v':
                case 'z':
                    f45796b++;
                    z = false;
                    c2 = cCharAt;
                    break;
                default:
                    if (((cCharAt < '0' || cCharAt > '9') && cCharAt != '.' && cCharAt != '-' && cCharAt != '+') || !z2) {
                        throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f45796b), f45798d));
                    }
                    if (c2 != 'Z' && c2 != 'z') {
                        if (c2 != 'M' && c2 != 'm') {
                            z = false;
                            break;
                        } else if (!Character.isUpperCase(c2)) {
                            c2 = 'l';
                            break;
                        } else {
                            c2 = 'L';
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException(android.support.v4.media.b.D("Unexpected number after 'z' (s=", f45798d, ")"));
                    }
                    break;
            }
            boolean zIsUpperCase = Character.isUpperCase(c2);
            switch (c2) {
                case 'A':
                    a(g(), g(), g(), f(), f(), g(), g());
                    break;
                case 'C':
                    float fG = g();
                    float fG2 = g();
                    float fG3 = g();
                    float fG4 = g();
                    float fG5 = g();
                    float fG6 = g();
                    f45803i = fG3;
                    f45804j = fG4;
                    b(fG, fG2, fG3, fG4, fG5, fG6);
                    break;
                case WKSRecord.Service.NETRJS_2 /* 72 */:
                    c(g(), f45802h);
                    break;
                case 'L':
                    c(g(), g());
                    break;
                case 'M':
                    d(g(), g());
                    break;
                case WKSRecord.Service.HOSTS2_NS /* 81 */:
                    h(g(), g(), g(), g());
                    break;
                case 'S':
                    float fG7 = g();
                    float fG8 = g();
                    float fG9 = g();
                    float fG10 = g();
                    float f2 = (f45801g * 2.0f) - f45803i;
                    float f3 = (f45802h * 2.0f) - f45804j;
                    f45803i = fG7;
                    f45804j = fG8;
                    b(f2, f3, fG7, fG8, fG9, fG10);
                    break;
                case 'T':
                    h((f45801g * 2.0f) - f45803i, (f45802h * 2.0f) - f45804j, g(), g());
                    break;
                case 'V':
                    c(f45801g, g());
                    break;
                case 'Z':
                case 'z':
                    if (f45807m) {
                        f45801g = f45805k;
                        f45802h = f45806l;
                        f45807m = false;
                        f45799e.close();
                        f45800f.add(new PathElement(ElementType.f45654d, new Point[]{new Point(f45801g, f45802h)}));
                        break;
                    }
                    break;
                case WKSRecord.Service.SWIFT_RVF /* 97 */:
                    a(g(), g(), g(), f(), f(), g() + f45801g, g() + f45802h);
                    break;
                case 'c':
                    float fG11 = g();
                    float fG12 = g();
                    float fG13 = g();
                    float fG14 = g();
                    float fG15 = g();
                    float fG16 = g();
                    float f4 = f45801g;
                    float f5 = fG11 + f4;
                    float f6 = f45802h;
                    float f7 = fG13 + f4;
                    float f8 = fG14 + f6;
                    f45803i = f7;
                    f45804j = f8;
                    b(f5, fG12 + f6, f7, f8, fG15 + f4, fG16 + f6);
                    break;
                case 'h':
                    c(g() + f45801g, f45802h + 0.0f);
                    break;
                case Type.EUI48 /* 108 */:
                    c(g() + f45801g, g() + f45802h);
                    break;
                case 'm':
                    d(g() + f45801g, g() + f45802h);
                    break;
                case WKSRecord.Service.AUTH /* 113 */:
                    float fG17 = g();
                    float fG18 = g();
                    float fG19 = g();
                    float fG20 = g();
                    float f9 = f45801g;
                    float f10 = f45802h;
                    h(fG17 + f9, fG18 + f10, fG19 + f9, fG20 + f10);
                    break;
                case WKSRecord.Service.SFTP /* 115 */:
                    float fG21 = g();
                    float fG22 = g();
                    float fG23 = g();
                    float fG24 = g();
                    float f11 = f45801g;
                    float f12 = fG21 + f11;
                    float f13 = f45802h;
                    float f14 = fG22 + f13;
                    float f15 = (f11 * 2.0f) - f45803i;
                    float f16 = (f13 * 2.0f) - f45804j;
                    f45803i = f12;
                    f45804j = f14;
                    b(f15, f16, f12, f14, fG23 + f11, fG24 + f13);
                    break;
                case 't':
                    float fG25 = g();
                    float fG26 = g();
                    float f17 = f45801g;
                    float f18 = f45802h;
                    h((f17 * 2.0f) - f45803i, (f18 * 2.0f) - f45804j, fG25 + f17, fG26 + f18);
                    break;
                case 'v':
                    c(f45801g + 0.0f, g() + f45802h);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Unexpected comand '%c' (s=%s)", Character.valueOf(c2), f45798d));
            }
            if (z) {
                c2 = zIsUpperCase ? 'M' : 'm';
            }
        }
        return f45799e;
    }

    public static boolean f() {
        k();
        char cCharAt = f45798d.charAt(f45796b);
        if (cCharAt != '0' && cCharAt != '1') {
            throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(f45796b), f45798d));
        }
        int i2 = f45796b + 1;
        f45796b = i2;
        if (i2 < f45797c && f45798d.charAt(i2) == ',') {
            f45796b++;
        }
        k();
        return cCharAt == '1';
    }

    public static float g() throws NumberFormatException {
        int i2;
        char cCharAt;
        if (f45796b == f45797c) {
            throw new Error(android.support.v4.media.b.D("Unexpected end (s=", f45798d, ")"));
        }
        k();
        int i3 = f45796b;
        if (i3 == f45797c) {
            throw new Error(android.support.v4.media.b.D("Unexpected end (s=", f45798d, ")"));
        }
        char cCharAt2 = f45798d.charAt(i3);
        if (cCharAt2 == '-' || cCharAt2 == '+') {
            int i4 = f45796b + 1;
            f45796b = i4;
            cCharAt2 = f45798d.charAt(i4);
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            j();
            int i5 = f45796b;
            if (i5 < f45797c) {
                cCharAt2 = f45798d.charAt(i5);
            }
        } else if (cCharAt2 != '.') {
            throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt2), Integer.valueOf(f45796b), f45798d));
        }
        if (cCharAt2 == '.') {
            f45796b++;
            j();
            int i6 = f45796b;
            if (i6 < f45797c) {
                cCharAt2 = f45798d.charAt(i6);
            }
        }
        if ((cCharAt2 == 'e' || cCharAt2 == 'E') && (i2 = f45796b + 1) < f45797c && (cCharAt = f45798d.charAt(i2)) != 'm' && cCharAt != 'x') {
            int i7 = f45796b + 1;
            f45796b = i7;
            char cCharAt3 = f45798d.charAt(i7);
            if (cCharAt3 == '+' || cCharAt3 == '-') {
                f45796b++;
                j();
            } else {
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt3), Integer.valueOf(f45796b), f45798d));
                }
                j();
            }
        }
        String strSubstring = f45798d.substring(i3, f45796b);
        float f2 = Float.parseFloat(strSubstring);
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw new IllegalArgumentException(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", strSubstring, Integer.valueOf(i3), Integer.valueOf(f45796b), f45798d));
        }
        k();
        int i8 = f45796b;
        if (i8 < f45797c && f45798d.charAt(i8) == ',') {
            f45796b++;
        }
        return f2;
    }

    public static void h(float f2, float f3, float f4, float f5) {
        f45803i = f2;
        f45804j = f3;
        float f6 = f2 * 2.0f;
        float f7 = f3 * 2.0f;
        b((f45801g + f6) / 3.0f, (f45802h + f7) / 3.0f, (f4 + f6) / 3.0f, (f5 + f7) / 3.0f, f4, f5);
    }

    public static void i() {
        if (f45807m) {
            return;
        }
        f45805k = f45801g;
        f45806l = f45802h;
        f45807m = true;
    }

    public static void j() {
        while (true) {
            int i2 = f45796b;
            if (i2 >= f45797c || !Character.isDigit(f45798d.charAt(i2))) {
                return;
            } else {
                f45796b++;
            }
        }
    }

    public static void k() {
        while (true) {
            int i2 = f45796b;
            if (i2 >= f45797c || !Character.isWhitespace(f45798d.charAt(i2))) {
                return;
            } else {
                f45796b++;
            }
        }
    }
}
