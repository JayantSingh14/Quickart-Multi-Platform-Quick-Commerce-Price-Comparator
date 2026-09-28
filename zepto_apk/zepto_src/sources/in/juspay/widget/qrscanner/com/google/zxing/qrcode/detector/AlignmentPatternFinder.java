package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class AlignmentPatternFinder {

    /* renamed from: a, reason: collision with root package name */
    private final BitMatrix f48951a;

    /* renamed from: c, reason: collision with root package name */
    private final int f48953c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48954d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48955e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48956f;

    /* renamed from: g, reason: collision with root package name */
    private final float f48957g;

    /* renamed from: i, reason: collision with root package name */
    private final ResultPointCallback f48959i;

    /* renamed from: b, reason: collision with root package name */
    private final List<AlignmentPattern> f48952b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f48958h = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, float f2, ResultPointCallback resultPointCallback) {
        this.f48951a = bitMatrix;
        this.f48953c = i2;
        this.f48954d = i3;
        this.f48955e = i4;
        this.f48956f = i5;
        this.f48957g = f2;
        this.f48959i = resultPointCallback;
    }

    private float a(int i2, int i3, int i4, int i5) {
        BitMatrix bitMatrix = this.f48951a;
        int height = bitMatrix.getHeight();
        int[] iArr = this.f48958h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bitMatrix.get(i3, i6)) {
            int i7 = iArr[1];
            if (i7 > i4) {
                break;
            }
            iArr[1] = i7 + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i4) {
            while (i6 >= 0 && !bitMatrix.get(i3, i6)) {
                int i8 = iArr[0];
                if (i8 > i4) {
                    break;
                }
                iArr[0] = i8 + 1;
                i6--;
            }
            if (iArr[0] > i4) {
                return Float.NaN;
            }
            int i9 = i2 + 1;
            while (i9 < height && bitMatrix.get(i3, i9)) {
                int i10 = iArr[1];
                if (i10 > i4) {
                    break;
                }
                iArr[1] = i10 + 1;
                i9++;
            }
            if (i9 != height && iArr[1] <= i4) {
                while (i9 < height && !bitMatrix.get(i3, i9)) {
                    int i11 = iArr[2];
                    if (i11 > i4) {
                        break;
                    }
                    iArr[2] = i11 + 1;
                    i9++;
                }
                int i12 = iArr[2];
                if (i12 <= i4 && Math.abs(((iArr[0] + iArr[1]) + i12) - i5) * 5 < i5 * 2 && a(iArr)) {
                    return a(iArr, i9);
                }
            }
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public AlignmentPattern a() throws NotFoundException {
        AlignmentPattern alignmentPatternA;
        AlignmentPattern alignmentPatternA2;
        int i2 = this.f48953c;
        int i3 = this.f48956f;
        int i4 = this.f48955e + i2;
        int i5 = (i3 / 2) + this.f48954d;
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f48951a.get(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f48951a.get(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (a(iArr) && (alignmentPatternA2 = a(iArr, i7, i8)) != null) {
                        return alignmentPatternA2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (a(iArr) && (alignmentPatternA = a(iArr, i7, i4)) != null) {
                return alignmentPatternA;
            }
        }
        if (this.f48952b.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return this.f48952b.get(0);
    }

    private AlignmentPattern a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i3);
        float fA2 = a(i2, (int) fA, iArr[1] * 2, i4);
        if (Float.isNaN(fA2)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.f48952b) {
            if (alignmentPattern.a(f2, fA2, fA)) {
                return alignmentPattern.b(fA2, fA, f2);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(fA, fA2, f2);
        this.f48952b.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.f48959i;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
        return null;
    }

    private boolean a(int[] iArr) {
        float f2 = this.f48957g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }
}
