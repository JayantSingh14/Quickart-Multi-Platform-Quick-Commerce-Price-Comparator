package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.common.DetectorResult;
import in.juspay.widget.qrscanner.com.google.zxing.common.GridSampler;
import in.juspay.widget.qrscanner.com.google.zxing.common.PerspectiveTransform;
import in.juspay.widget.qrscanner.com.google.zxing.common.detector.MathUtils;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* loaded from: classes4.dex */
public class Detector {

    /* renamed from: a, reason: collision with root package name */
    private final BitMatrix f48960a;

    /* renamed from: b, reason: collision with root package name */
    private ResultPointCallback f48961b;

    public Detector(BitMatrix bitMatrix) {
        this.f48960a = bitMatrix;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
    
        if (r15 != r0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        return in.juspay.widget.qrscanner.com.google.zxing.common.detector.MathUtils.distance(r5, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008a, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = r3
            goto L3a
        L39:
            r12 = r11
        L3a:
            if (r4 >= r6) goto L3d
            r11 = r3
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L80
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            r16 = r0
            if (r15 != r3) goto L57
            r0 = r3
            r19 = r7
            r3 = r17
            goto L5c
        L57:
            r0 = 0
            r3 = r17
            r19 = r7
        L5c:
            in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix r7 = r3.f48960a
            boolean r2 = r7.get(r2, r10)
            if (r0 != r2) goto L6e
            r0 = 2
            if (r15 != r0) goto L6c
            float r0 = in.juspay.widget.qrscanner.com.google.zxing.common.detector.MathUtils.distance(r13, r14, r1, r4)
            return r0
        L6c:
            int r15 = r15 + 1
        L6e:
            int r9 = r9 + r8
            if (r9 <= 0) goto L78
            if (r14 != r6) goto L75
            r0 = 2
            goto L83
        L75:
            int r14 = r14 + r11
            int r9 = r9 - r19
        L78:
            int r13 = r13 + r12
            r7 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L80:
            r3 = r17
            r0 = r10
        L83:
            if (r15 != r0) goto L8a
            float r0 = in.juspay.widget.qrscanner.com.google.zxing.common.detector.MathUtils.distance(r5, r6, r1, r4)
            return r0
        L8a:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector.Detector.a(int, int, int, int):float");
    }

    private float b(int i2, int i3, int i4, int i5) {
        float width;
        float height;
        float fA = a(i2, i3, i4, i5);
        int width2 = i2 - (i4 - i2);
        int height2 = 0;
        if (width2 < 0) {
            width = i2 / (i2 - width2);
            width2 = 0;
        } else if (width2 >= this.f48960a.getWidth()) {
            width = ((this.f48960a.getWidth() - 1) - i2) / (width2 - i2);
            width2 = this.f48960a.getWidth() - 1;
        } else {
            width = 1.0f;
        }
        float f2 = i3;
        int i6 = (int) (f2 - ((i5 - i3) * width));
        if (i6 < 0) {
            height = f2 / (i3 - i6);
        } else if (i6 >= this.f48960a.getHeight()) {
            height = ((this.f48960a.getHeight() - 1) - i3) / (i6 - i3);
            height2 = this.f48960a.getHeight() - 1;
        } else {
            height2 = i6;
            height = 1.0f;
        }
        return (fA + a(i2, i3, (int) (((width2 - i2) * height) + i2), height2)) - 1.0f;
    }

    public DetectorResult detect() {
        return detect(null);
    }

    private float a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fB = b((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fB2 = b((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) {
        this.f48961b = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return a(new FinderPatternFinder(this.f48960a, this.f48961b).a(map));
    }

    public final float a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (a(resultPoint, resultPoint2) + a(resultPoint, resultPoint3)) / 2.0f;
    }

    private static int a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f2) throws NotFoundException {
        int iRound = (MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f2) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f2)) / 2;
        int i2 = iRound + 7;
        int i3 = i2 & 3;
        if (i3 == 0) {
            return iRound + 8;
        }
        if (i3 == 2) {
            return iRound + 6;
        }
        if (i3 != 3) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static BitMatrix a(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i2) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, perspectiveTransform);
    }

    public final DetectorResult a(FinderPatternInfo finderPatternInfo) throws FormatException, NotFoundException {
        AlignmentPattern alignmentPatternA;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fA = a(topLeft, topRight, bottomLeft);
        if (fA < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iA = a(topLeft, topRight, bottomLeft, fA);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(iA);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = bottomLeft.getX() + (topRight.getX() - topLeft.getX());
            float y = bottomLeft.getY() + (topRight.getY() - topLeft.getY());
            float f2 = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (((x - topLeft.getX()) * f2) + topLeft.getX());
            int y2 = (int) (((y - topLeft.getY()) * f2) + topLeft.getY());
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    alignmentPatternA = a(fA, x2, y2, i2);
                    break;
                } catch (NotFoundException unused) {
                }
            }
            alignmentPatternA = null;
        } else {
            alignmentPatternA = null;
        }
        return new DetectorResult(a(this.f48960a, a(topLeft, topRight, bottomLeft, alignmentPatternA, iA), iA), alignmentPatternA == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternA});
    }

    private static PerspectiveTransform a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        float x;
        float y;
        float f2;
        float f3 = i2 - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            f2 = f3 - 3.0f;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f2 = f3;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    public final AlignmentPattern a(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.f48960a.getWidth() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin < f4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i3 - i4);
        int iMin2 = Math.min(this.f48960a.getHeight() - 1, i3 + i4) - iMax2;
        if (iMin2 >= f4) {
            return new AlignmentPatternFinder(this.f48960a, iMax, iMax2, iMin, iMin2, f2, this.f48961b).a();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
