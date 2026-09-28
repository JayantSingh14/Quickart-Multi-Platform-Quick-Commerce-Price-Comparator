package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.detector.MathUtils;

/* loaded from: classes4.dex */
public class ResultPoint {

    /* renamed from: a, reason: collision with root package name */
    private final float f48832a;

    /* renamed from: b, reason: collision with root package name */
    private final float f48833b;

    public ResultPoint(float f2, float f3) {
        this.f48832a = f2;
        this.f48833b = f3;
    }

    private static float a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f2 = resultPoint2.f48832a;
        float f3 = resultPoint2.f48833b;
        return ((resultPoint.f48833b - f3) * (resultPoint3.f48832a - f2)) - ((resultPoint.f48832a - f2) * (resultPoint3.f48833b - f3));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f48832a, resultPoint.f48833b, resultPoint2.f48832a, resultPoint2.f48833b);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        if (a(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f48832a == resultPoint.f48832a && this.f48833b == resultPoint.f48833b) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.f48832a;
    }

    public final float getY() {
        return this.f48833b;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f48833b) + (Float.floatToIntBits(this.f48832a) * 31);
    }

    public final String toString() {
        return "(" + this.f48832a + ',' + this.f48833b + ')';
    }
}
