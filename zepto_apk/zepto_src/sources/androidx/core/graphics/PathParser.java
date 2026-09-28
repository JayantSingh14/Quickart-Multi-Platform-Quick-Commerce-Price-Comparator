package androidx.core.graphics;

import android.graphics.Path;
import android.support.v4.media.b;
import android.util.Log;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class PathParser {

    public static class ExtractFloatResult {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2812a;
    }

    public static boolean a(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            PathDataNode pathDataNode = pathDataNodeArr[i2];
            char c2 = pathDataNode.f2813a;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i2];
            if (c2 != pathDataNode2.f2813a || pathDataNode.f2814b.length != pathDataNode2.f2814b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] b(int i2, float[] fArr) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i2, length);
        float[] fArr2 = new float[i2];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f A[Catch: NumberFormatException -> 0x00b2, LOOP:3: B:25:0x006e->B:45:0x009f, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b2, blocks: (B:22:0x0054, B:24:0x0067, B:25:0x006e, B:27:0x0074, B:31:0x0080, B:45:0x009f, B:35:0x0089, B:40:0x0095, B:47:0x00a4, B:50:0x00b4, B:54:0x00bb, B:55:0x00be), top: B:70:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4 A[Catch: NumberFormatException -> 0x00b2, TryCatch #0 {NumberFormatException -> 0x00b2, blocks: (B:22:0x0054, B:24:0x0067, B:25:0x006e, B:27:0x0074, B:31:0x0080, B:45:0x009f, B:35:0x0089, B:40:0x0095, B:47:0x00a4, B:50:0x00b4, B:54:0x00bb, B:55:0x00be), top: B:70:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb A[Catch: NumberFormatException -> 0x00b2, TryCatch #0 {NumberFormatException -> 0x00b2, blocks: (B:22:0x0054, B:24:0x0067, B:25:0x006e, B:27:0x0074, B:31:0x0080, B:45:0x009f, B:35:0x0089, B:40:0x0095, B:47:0x00a4, B:50:0x00b4, B:54:0x00bb, B:55:0x00be), top: B:70:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.graphics.PathParser.PathDataNode[] c(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.c(java.lang.String):androidx.core.graphics.PathParser$PathDataNode[]");
    }

    public static Path d(String str) {
        Path path = new Path();
        try {
            PathDataNode.b(c(str), path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(str), e2);
        }
    }

    public static PathDataNode[] e(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    public static class PathDataNode {

        /* renamed from: a, reason: collision with root package name */
        public char f2813a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f2814b;

        public PathDataNode(float[] fArr, char c2) {
            this.f2813a = c2;
            this.f2814b = fArr;
        }

        public static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d4 = f2;
            double d5 = f3;
            double d6 = f6;
            double d7 = ((d5 * dSin) + (d4 * dCos)) / d6;
            double d8 = f7;
            double d9 = ((d5 * dCos) + ((-f2) * dSin)) / d8;
            double d10 = f5;
            double d11 = ((d10 * dSin) + (f4 * dCos)) / d6;
            double d12 = ((d10 * dCos) + ((-f4) * dSin)) / d8;
            double d13 = d7 - d11;
            double d14 = d9 - d12;
            double d15 = (d7 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d14 * d14) + (d13 * d13);
            if (d17 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d17);
                float fSqrt = (float) (Math.sqrt(d17) / 1.99999d);
                a(path, f2, f3, f4, f5, f6 * fSqrt, fSqrt * f7, f8, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d18);
            double d19 = dSqrt * d13;
            double d20 = dSqrt * d14;
            if (z == z2) {
                d2 = d15 - d20;
                d3 = d16 + d19;
            } else {
                d2 = d15 + d20;
                d3 = d16 - d19;
            }
            double dAtan2 = Math.atan2(d9 - d3, d7 - d2);
            double dAtan22 = Math.atan2(d12 - d3, d11 - d2) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d21 = d2 * d6;
            double d22 = d3 * d8;
            double d23 = (d21 * dCos) - (d22 * dSin);
            double d24 = (d22 * dCos) + (d21 * dSin);
            int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
            double dCos2 = Math.cos(radians);
            double dSin2 = Math.sin(radians);
            double dCos3 = Math.cos(dAtan2);
            double dSin3 = Math.sin(dAtan2);
            double d25 = dCos2;
            double d26 = -d6;
            double d27 = d26 * d25;
            double d28 = d8 * dSin2;
            double d29 = (d27 * dSin3) - (d28 * dCos3);
            double d30 = d26 * dSin2;
            double d31 = d8 * d25;
            double d32 = dAtan22 / iCeil;
            double d33 = (dCos3 * d31) + (dSin3 * d30);
            double d34 = d29;
            double d35 = d4;
            double d36 = d5;
            int i2 = 0;
            double d37 = dAtan2;
            while (i2 < iCeil) {
                double d38 = d37 + d32;
                double dSin4 = Math.sin(d38);
                double dCos4 = Math.cos(d38);
                double d39 = d25;
                double d40 = d6;
                double d41 = d23;
                double dA = b.a(d40, d39, dCos4, d41) - (d28 * dSin4);
                double d42 = dSin2;
                double dA2 = (d31 * dSin4) + b.a(d40, d42, dCos4, d24);
                double d43 = (d27 * dSin4) - (d28 * dCos4);
                double d44 = (dCos4 * d31) + (dSin4 * d30);
                double d45 = d38 - d37;
                double dTan = Math.tan(d45 / 2.0d);
                double dSqrt2 = ((Math.sqrt(b.a(dTan, 3.0d, dTan, 4.0d)) - 1.0d) * Math.sin(d45)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d34 * dSqrt2) + d35), (float) ((d33 * dSqrt2) + d36), (float) (dA - (dSqrt2 * d43)), (float) (dA2 - (dSqrt2 * d44)), (float) dA, (float) dA2);
                i2++;
                d32 = d32;
                iCeil = iCeil;
                d30 = d30;
                d37 = d38;
                d25 = d39;
                d34 = d43;
                d33 = d44;
                d36 = dA2;
                d35 = dA;
                d6 = d40;
                d23 = d41;
                dSin2 = d42;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(PathDataNode[] pathDataNodeArr, Path path) {
            int i2;
            int i3;
            PathDataNode pathDataNode;
            int i4;
            char c2;
            float f2;
            float f3;
            float f4;
            float f5;
            PathDataNode pathDataNode2;
            boolean z;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            Path path2 = path;
            float[] fArr = new float[6];
            int length = pathDataNodeArr.length;
            char c3 = 'm';
            int i5 = 0;
            char c4 = 'm';
            int i6 = 0;
            while (i6 < length) {
                PathDataNode pathDataNode3 = pathDataNodeArr[i6];
                char c5 = pathDataNode3.f2813a;
                float f14 = fArr[i5];
                float f15 = fArr[1];
                float f16 = fArr[2];
                float f17 = fArr[3];
                float f18 = fArr[4];
                float f19 = fArr[5];
                switch (c5) {
                    case 'A':
                    case WKSRecord.Service.SWIFT_RVF /* 97 */:
                        i2 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i2 = 6;
                        break;
                    case WKSRecord.Service.NETRJS_2 /* 72 */:
                    case 'V':
                    case 'h':
                    case 'v':
                        i2 = 1;
                        break;
                    case WKSRecord.Service.HOSTS2_NS /* 81 */:
                    case 'S':
                    case WKSRecord.Service.AUTH /* 113 */:
                    case WKSRecord.Service.SFTP /* 115 */:
                        i2 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path2.close();
                        path2.moveTo(f18, f19);
                        f14 = f18;
                        f16 = f14;
                        f15 = f19;
                        f17 = f15;
                    default:
                        i2 = 2;
                        break;
                }
                float f20 = f15;
                float f21 = f18;
                float f22 = f19;
                float f23 = f14;
                int i7 = i5;
                while (true) {
                    float[] fArr2 = pathDataNode3.f2814b;
                    if (i7 < fArr2.length) {
                        int i8 = i5;
                        if (c5 == 'A') {
                            i3 = i7;
                            pathDataNode = pathDataNode3;
                            float f24 = f23;
                            float f25 = f20;
                            i4 = i6;
                            c2 = c5;
                            int i9 = i3 + 5;
                            int i10 = i3 + 6;
                            a(path, f24, f25, fArr2[i9], fArr2[i10], fArr2[i3], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f ? 1 : i8, fArr2[i3 + 4] != 0.0f ? 1 : i8);
                            f16 = fArr2[i9];
                            f2 = fArr2[i10];
                            f17 = f2;
                            f3 = f16;
                        } else if (c5 == 'C') {
                            i3 = i7;
                            i4 = i6;
                            pathDataNode = pathDataNode3;
                            c2 = c5;
                            int i11 = i3 + 2;
                            int i12 = i3 + 3;
                            int i13 = i3 + 4;
                            int i14 = i3 + 5;
                            path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                            float f26 = fArr2[i13];
                            float f27 = fArr2[i14];
                            f16 = fArr2[i11];
                            f17 = fArr2[i12];
                            f2 = f27;
                            f3 = f26;
                        } else if (c5 != 'H') {
                            if (c5 == 'Q') {
                                i3 = i7;
                                i4 = i6;
                                pathDataNode = pathDataNode3;
                                c2 = c5;
                                int i15 = i3 + 1;
                                int i16 = i3 + 2;
                                int i17 = i3 + 3;
                                path2.quadTo(fArr2[i3], fArr2[i15], fArr2[i16], fArr2[i17]);
                                f4 = fArr2[i3];
                                float f28 = fArr2[i15];
                                f5 = fArr2[i16];
                                f17 = f28;
                                f2 = fArr2[i17];
                            } else if (c5 == 'V') {
                                i3 = i7;
                                i4 = i6;
                                pathDataNode = pathDataNode3;
                                f3 = f23;
                                c2 = c5;
                                path2.lineTo(f3, fArr2[i3]);
                                f2 = fArr2[i3];
                            } else if (c5 != 'a') {
                                if (c5 == 'c') {
                                    i3 = i7;
                                    int i18 = i3 + 2;
                                    int i19 = i3 + 3;
                                    int i20 = i3 + 4;
                                    int i21 = i3 + 5;
                                    path2.rCubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i18], fArr2[i19], fArr2[i20], fArr2[i21]);
                                    float f29 = fArr2[i18] + f23;
                                    float f30 = f20 + fArr2[i19];
                                    f23 += fArr2[i20];
                                    f20 += fArr2[i21];
                                    f16 = f29;
                                    f17 = f30;
                                } else if (c5 != 'h') {
                                    if (c5 != 'q') {
                                        if (c5 != 'v') {
                                            if (c5 == 'L') {
                                                i3 = i7;
                                                int i22 = i3 + 1;
                                                path2.lineTo(fArr2[i3], fArr2[i22]);
                                                f3 = fArr2[i3];
                                                f2 = fArr2[i22];
                                            } else if (c5 == 'M') {
                                                i3 = i7;
                                                f3 = fArr2[i3];
                                                f2 = fArr2[i3 + 1];
                                                if (i3 > 0) {
                                                    path2.lineTo(f3, f2);
                                                } else {
                                                    path2.moveTo(f3, f2);
                                                    f21 = f3;
                                                    f22 = f2;
                                                }
                                            } else if (c5 == 'S') {
                                                i3 = i7;
                                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                    f23 = (f23 * 2.0f) - f16;
                                                    f20 = (f20 * 2.0f) - f17;
                                                }
                                                float f31 = f23;
                                                float f32 = f20;
                                                int i23 = i3 + 1;
                                                int i24 = i3 + 2;
                                                int i25 = i3 + 3;
                                                path2.cubicTo(f31, f32, fArr2[i3], fArr2[i23], fArr2[i24], fArr2[i25]);
                                                f4 = fArr2[i3];
                                                float f33 = fArr2[i23];
                                                f5 = fArr2[i24];
                                                f17 = f33;
                                                f2 = fArr2[i25];
                                                i4 = i6;
                                                pathDataNode = pathDataNode3;
                                                c2 = c5;
                                            } else if (c5 == 'T') {
                                                i3 = i7;
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f23 = (f23 * 2.0f) - f16;
                                                    f20 = (f20 * 2.0f) - f17;
                                                }
                                                float f34 = f20;
                                                float f35 = fArr2[i3];
                                                int i26 = i3 + 1;
                                                path2.quadTo(f23, f34, f35, fArr2[i26]);
                                                f17 = f34;
                                                f3 = fArr2[i3];
                                                f2 = fArr2[i26];
                                                i4 = i6;
                                                pathDataNode = pathDataNode3;
                                                f16 = f23;
                                                c2 = c5;
                                            } else if (c5 == 'l') {
                                                i3 = i7;
                                                int i27 = i3 + 1;
                                                path2.rLineTo(fArr2[i3], fArr2[i27]);
                                                f23 += fArr2[i3];
                                                f9 = fArr2[i27];
                                            } else if (c5 == c3) {
                                                i3 = i7;
                                                float f36 = fArr2[i3];
                                                f23 += f36;
                                                float f37 = fArr2[i3 + 1];
                                                f20 += f37;
                                                if (i3 > 0) {
                                                    path2.rLineTo(f36, f37);
                                                } else {
                                                    path2.rMoveTo(f36, f37);
                                                    pathDataNode = pathDataNode3;
                                                    f3 = f23;
                                                    f21 = f3;
                                                    f2 = f20;
                                                    f22 = f2;
                                                    i4 = i6;
                                                    c2 = c5;
                                                }
                                            } else if (c5 == 's') {
                                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                    f10 = f20 - f17;
                                                    f11 = f23 - f16;
                                                } else {
                                                    f11 = 0.0f;
                                                    f10 = 0.0f;
                                                }
                                                int i28 = i7 + 1;
                                                int i29 = i7 + 2;
                                                int i30 = i7 + 3;
                                                i3 = i7;
                                                path2.rCubicTo(f11, f10, fArr2[i7], fArr2[i28], fArr2[i29], fArr2[i30]);
                                                f6 = fArr2[i3] + f23;
                                                f7 = f20 + fArr2[i28];
                                                f23 += fArr2[i29];
                                                f8 = fArr2[i30];
                                            } else if (c5 != 't') {
                                                i3 = i7;
                                            } else {
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f12 = f23 - f16;
                                                    f13 = f20 - f17;
                                                } else {
                                                    f13 = 0.0f;
                                                    f12 = 0.0f;
                                                }
                                                int i31 = i7 + 1;
                                                path2.rQuadTo(f12, f13, fArr2[i7], fArr2[i31]);
                                                float f38 = f12 + f23;
                                                float f39 = f20 + f13;
                                                float f40 = f23 + fArr2[i7];
                                                f20 += fArr2[i31];
                                                f17 = f39;
                                                i3 = i7;
                                                pathDataNode = pathDataNode3;
                                                f3 = f40;
                                                f16 = f38;
                                                f2 = f20;
                                                i4 = i6;
                                                c2 = c5;
                                            }
                                            i4 = i6;
                                            pathDataNode = pathDataNode3;
                                            c2 = c5;
                                        } else {
                                            i3 = i7;
                                            path2.rLineTo(0.0f, fArr2[i3]);
                                            f9 = fArr2[i3];
                                        }
                                        f20 += f9;
                                    } else {
                                        i3 = i7;
                                        int i32 = i3 + 1;
                                        int i33 = i3 + 2;
                                        int i34 = i3 + 3;
                                        path2.rQuadTo(fArr2[i3], fArr2[i32], fArr2[i33], fArr2[i34]);
                                        f6 = fArr2[i3] + f23;
                                        f7 = f20 + fArr2[i32];
                                        f23 += fArr2[i33];
                                        f8 = fArr2[i34];
                                    }
                                    f20 += f8;
                                    f16 = f6;
                                    f17 = f7;
                                } else {
                                    i3 = i7;
                                    path2.rLineTo(fArr2[i3], 0.0f);
                                    f23 += fArr2[i3];
                                }
                                pathDataNode = pathDataNode3;
                                f3 = f23;
                                f2 = f20;
                                i4 = i6;
                                c2 = c5;
                            } else {
                                i3 = i7;
                                int i35 = i3 + 5;
                                float f41 = fArr2[i35] + f23;
                                int i36 = i3 + 6;
                                float f42 = fArr2[i36] + f20;
                                float f43 = fArr2[i3];
                                float f44 = fArr2[i3 + 1];
                                float f45 = fArr2[i3 + 2];
                                if (fArr2[i3 + 3] != 0.0f) {
                                    pathDataNode2 = pathDataNode3;
                                    z = 1;
                                } else {
                                    pathDataNode2 = pathDataNode3;
                                    z = i8;
                                }
                                pathDataNode = pathDataNode2;
                                float f46 = f23;
                                c2 = c5;
                                float f47 = f20;
                                i4 = i6;
                                a(path, f46, f47, f41, f42, f43, f44, f45, z, fArr2[i3 + 4] != 0.0f ? 1 : i8);
                                f3 = f46 + fArr2[i35];
                                f2 = f47 + fArr2[i36];
                                f16 = f3;
                                f17 = f2;
                            }
                            f16 = f4;
                            f3 = f5;
                        } else {
                            i3 = i7;
                            pathDataNode = pathDataNode3;
                            c2 = c5;
                            f2 = f20;
                            i4 = i6;
                            path2.lineTo(fArr2[i3], f2);
                            f3 = fArr2[i3];
                        }
                        c5 = c2;
                        pathDataNode3 = pathDataNode;
                        i6 = i4;
                        i5 = i8;
                        c3 = 'm';
                        f23 = f3;
                        f20 = f2;
                        c4 = c5;
                        i7 = i3 + i2;
                        path2 = path;
                    }
                }
                int i37 = i5;
                fArr[i37] = f23;
                fArr[1] = f20;
                fArr[2] = f16;
                fArr[3] = f17;
                fArr[4] = f21;
                fArr[5] = f22;
                c4 = pathDataNode3.f2813a;
                i6++;
                path2 = path;
                i5 = i37;
                c3 = 'm';
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.f2813a = pathDataNode.f2813a;
            float[] fArr = pathDataNode.f2814b;
            this.f2814b = PathParser.b(fArr.length, fArr);
        }
    }
}
