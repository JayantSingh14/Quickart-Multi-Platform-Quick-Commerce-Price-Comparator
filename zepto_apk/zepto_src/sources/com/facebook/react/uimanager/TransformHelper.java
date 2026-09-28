package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class TransformHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f19491a = new AnonymousClass1();

    /* renamed from: com.facebook.react.uimanager.TransformHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends ThreadLocal<double[]> {
        @Override // java.lang.ThreadLocal
        public final double[] initialValue() {
            return new double[16];
        }
    }

    /* renamed from: com.facebook.react.uimanager.TransformHelper$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19492a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            f19492a = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19492a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static double a(ReadableMap readableMap, String str) {
        double d2;
        boolean z = true;
        if (readableMap.getType(str) == ReadableType.String) {
            String string = readableMap.getString(str);
            if (string.endsWith("rad")) {
                string = android.support.v4.media.a.k(3, 0, string);
            } else if (string.endsWith("deg")) {
                string = android.support.v4.media.a.k(3, 0, string);
                z = false;
            }
            d2 = Float.parseFloat(string);
        } else {
            d2 = readableMap.getDouble(str);
        }
        return z ? d2 : (d2 * 3.141592653589793d) / 180;
    }

    public static double b(String str, double d2) {
        try {
            return str.endsWith("%") ? (Double.parseDouble(str.substring(0, str.length() - 1)) * d2) / 100.0d : Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            FLog.q("ReactNative", "Invalid translate value: " + str);
            return 0.0d;
        }
    }

    public static void c(ReadableArray readableArray, double[] dArr, float f2, float f3, ReadableArray readableArray2, boolean z) {
        float[] fArr;
        int i2;
        int i3;
        int i4;
        int i5;
        double dB;
        int i6 = 0;
        double[] m2 = (double[]) f19491a.get();
        MatrixMathHelper.f(dArr);
        if (readableArray2 == null || (f3 == 0.0f && f2 == 0.0f)) {
            fArr = null;
        } else {
            float f4 = f2 / 2.0f;
            float f5 = f3 / 2.0f;
            float[] fArr2 = new float[3];
            fArr2[0] = f4;
            fArr2[1] = f5;
            fArr2[2] = 0.0f;
            int i7 = 0;
            while (i7 < readableArray2.size() && i7 < 3) {
                int i8 = AnonymousClass2.f19492a[readableArray2.getType(i7).ordinal()];
                if (i8 == 1) {
                    fArr2[i7] = (float) readableArray2.getDouble(i7);
                } else if (i8 == 2 && z) {
                    String string = readableArray2.getString(i7);
                    if (string.endsWith("%")) {
                        fArr2[i7] = ((i7 == 0 ? f2 : f3) * Float.parseFloat(string.substring(0, string.length() - 1))) / 100.0f;
                    }
                }
                i7++;
            }
            fArr = new float[]{(-f4) + fArr2[0], (-f5) + fArr2[1], fArr2[2]};
        }
        if (fArr != null) {
            MatrixMathHelper.f(m2);
            i2 = 2;
            i3 = 1;
            MatrixMathHelper.a(m2, fArr[0], fArr[1], fArr[2]);
            MatrixMathHelper.e(dArr, dArr, m2);
        } else {
            i2 = 2;
            i3 = 1;
        }
        int i9 = 16;
        if (readableArray.size() == 16 && readableArray.getType(0) == ReadableType.Number) {
            MatrixMathHelper.f(m2);
            for (int i10 = 0; i10 < readableArray.size(); i10++) {
                m2[i10] = readableArray.getDouble(i10);
            }
            MatrixMathHelper.e(dArr, dArr, m2);
        } else {
            int size = readableArray.size();
            int i11 = 0;
            while (i11 < size) {
                ReadableMap map = readableArray.getMap(i11);
                String strNextKey = map.keySetIterator().nextKey();
                MatrixMathHelper.f(m2);
                if ("matrix".equals(strNextKey)) {
                    ReadableArray array = map.getArray(strNextKey);
                    for (int i12 = i6; i12 < i9; i12++) {
                        m2[i12] = array.getDouble(i12);
                    }
                } else if ("perspective".equals(strNextKey)) {
                    double d2 = map.getDouble(strNextKey);
                    Intrinsics.checkNotNullParameter(m2, "m");
                    m2[11] = (-1) / d2;
                } else if ("rotateX".equals(strNextKey)) {
                    double dA = a(map, strNextKey);
                    Intrinsics.checkNotNullParameter(m2, "m");
                    m2[5] = Math.cos(dA);
                    m2[6] = Math.sin(dA);
                    m2[9] = -Math.sin(dA);
                    m2[10] = Math.cos(dA);
                } else if ("rotateY".equals(strNextKey)) {
                    double dA2 = a(map, strNextKey);
                    Intrinsics.checkNotNullParameter(m2, "m");
                    m2[i6] = Math.cos(dA2);
                    m2[i2] = -Math.sin(dA2);
                    m2[8] = Math.sin(dA2);
                    m2[10] = Math.cos(dA2);
                } else {
                    if (CLConstants.MODE_ROTATE.equals(strNextKey) || "rotateZ".equals(strNextKey)) {
                        i4 = i6;
                        i5 = i11;
                        double dA3 = a(map, strNextKey);
                        Intrinsics.checkNotNullParameter(m2, "m");
                        m2[i4] = Math.cos(dA3);
                        i3 = 1;
                        m2[1] = Math.sin(dA3);
                        m2[4] = -Math.sin(dA3);
                        m2[5] = Math.cos(dA3);
                    } else if ("scale".equals(strNextKey)) {
                        double d3 = map.getDouble(strNextKey);
                        Intrinsics.checkNotNullParameter(m2, "m");
                        m2[i6] = d3;
                        Intrinsics.checkNotNullParameter(m2, "m");
                        m2[5] = d3;
                    } else if ("scaleX".equals(strNextKey)) {
                        double d4 = map.getDouble(strNextKey);
                        Intrinsics.checkNotNullParameter(m2, "m");
                        m2[i6] = d4;
                    } else if ("scaleY".equals(strNextKey)) {
                        double d5 = map.getDouble(strNextKey);
                        Intrinsics.checkNotNullParameter(m2, "m");
                        m2[5] = d5;
                    } else {
                        if ("translate".equals(strNextKey)) {
                            ReadableArray array2 = map.getArray(strNextKey);
                            ReadableType type = array2.getType(i6);
                            ReadableType readableType = ReadableType.String;
                            double dB2 = (type == readableType && z) ? b(array2.getString(i6), f2) : array2.getDouble(i6);
                            i4 = i6;
                            int i13 = i3;
                            if (array2.getType(i13) == readableType && z) {
                                i5 = i11;
                                dB = b(array2.getString(i13), f3);
                            } else {
                                i5 = i11;
                                dB = array2.getDouble(i13);
                            }
                            MatrixMathHelper.a(m2, dB2, dB, array2.size() > i2 ? array2.getDouble(i2) : 0.0d);
                        } else {
                            i4 = i6;
                            i5 = i11;
                            if ("translateX".equals(strNextKey)) {
                                double dB3 = (map.getType(strNextKey) == ReadableType.String && z) ? b(map.getString(strNextKey), f2) : map.getDouble(strNextKey);
                                Intrinsics.checkNotNullParameter(m2, "m");
                                m2[12] = dB3;
                                m2[13] = 0.0d;
                            } else if ("translateY".equals(strNextKey)) {
                                double dB4 = (map.getType(strNextKey) == ReadableType.String && z) ? b(map.getString(strNextKey), f3) : map.getDouble(strNextKey);
                                Intrinsics.checkNotNullParameter(m2, "m");
                                m2[12] = 0.0d;
                                m2[13] = dB4;
                            } else if ("skewX".equals(strNextKey)) {
                                double dA4 = a(map, strNextKey);
                                Intrinsics.checkNotNullParameter(m2, "m");
                                m2[4] = Math.tan(dA4);
                            } else if ("skewY".equals(strNextKey)) {
                                double dA5 = a(map, strNextKey);
                                Intrinsics.checkNotNullParameter(m2, "m");
                                m2[1] = Math.tan(dA5);
                            } else {
                                FLog.q("ReactNative", "Unsupported transform type: " + strNextKey);
                            }
                        }
                        i3 = 1;
                    }
                    MatrixMathHelper.e(dArr, dArr, m2);
                    i11 = i5 + 1;
                    i6 = i4;
                    i9 = 16;
                    i2 = 2;
                }
                i4 = i6;
                i5 = i11;
                MatrixMathHelper.e(dArr, dArr, m2);
                i11 = i5 + 1;
                i6 = i4;
                i9 = 16;
                i2 = 2;
            }
        }
        int i14 = i6;
        if (fArr != null) {
            MatrixMathHelper.f(m2);
            MatrixMathHelper.a(m2, -fArr[i14], -fArr[i3], -fArr[2]);
            MatrixMathHelper.e(dArr, dArr, m2);
        }
    }
}
