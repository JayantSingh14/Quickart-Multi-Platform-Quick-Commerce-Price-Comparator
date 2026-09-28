package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FinderPatternFinder {

    /* renamed from: f, reason: collision with root package name */
    private static final EstimatedModuleComparator f48964f = new EstimatedModuleComparator();

    /* renamed from: a, reason: collision with root package name */
    private final BitMatrix f48965a;

    /* renamed from: b, reason: collision with root package name */
    private final List<FinderPattern> f48966b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f48967c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f48968d;

    /* renamed from: e, reason: collision with root package name */
    private final ResultPointCallback f48969e;

    public static final class EstimatedModuleComparator implements Comparator<FinderPattern>, Serializable {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    private static double a(FinderPattern finderPattern, FinderPattern finderPattern2) {
        double x = finderPattern.getX() - finderPattern2.getX();
        double y = finderPattern.getY() - finderPattern2.getY();
        return (y * y) + (x * x);
    }

    private float b(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        BitMatrix bitMatrix = this.f48965a;
        int height = bitMatrix.getHeight();
        int[] iArrB = b();
        int i9 = i2;
        while (i9 >= 0 && bitMatrix.get(i3, i9)) {
            iArrB[2] = iArrB[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !bitMatrix.get(i3, i9)) {
            int i10 = iArrB[1];
            if (i10 > i4) {
                break;
            }
            iArrB[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArrB[1] <= i4) {
            while (i9 >= 0 && bitMatrix.get(i3, i9) && (i8 = iArrB[0]) <= i4) {
                iArrB[0] = i8 + 1;
                i9--;
            }
            if (iArrB[0] > i4) {
                return Float.NaN;
            }
            int i11 = i2 + 1;
            while (i11 < height && bitMatrix.get(i3, i11)) {
                iArrB[2] = iArrB[2] + 1;
                i11++;
            }
            if (i11 == height) {
                return Float.NaN;
            }
            while (i11 < height && !bitMatrix.get(i3, i11) && (i7 = iArrB[3]) < i4) {
                iArrB[3] = i7 + 1;
                i11++;
            }
            if (i11 != height && iArrB[3] < i4) {
                while (i11 < height && bitMatrix.get(i3, i11) && (i6 = iArrB[4]) < i4) {
                    iArrB[4] = i6 + 1;
                    i11++;
                }
                int i12 = iArrB[4];
                if (i12 < i4 && Math.abs(((((iArrB[0] + iArrB[1]) + iArrB[2]) + iArrB[3]) + i12) - i5) * 5 < i5 * 2 && c(iArrB)) {
                    return a(iArrB, i11);
                }
            }
        }
        return Float.NaN;
    }

    private boolean c() {
        int size = this.f48966b.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float estimatedModuleSize = 0.0f;
        for (FinderPattern finderPattern : this.f48966b) {
            if (finderPattern.getCount() >= 2) {
                i2++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.f48966b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - f2);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    public static boolean d(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.f48965a = bitMatrix;
        this.f48966b = new ArrayList();
        this.f48968d = new int[5];
        this.f48969e = resultPointCallback;
    }

    private float a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        BitMatrix bitMatrix = this.f48965a;
        int width = bitMatrix.getWidth();
        int[] iArrB = b();
        int i9 = i2;
        while (i9 >= 0 && bitMatrix.get(i9, i3)) {
            iArrB[2] = iArrB[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !bitMatrix.get(i9, i3)) {
            int i10 = iArrB[1];
            if (i10 > i4) {
                break;
            }
            iArrB[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArrB[1] <= i4) {
            while (i9 >= 0 && bitMatrix.get(i9, i3) && (i8 = iArrB[0]) <= i4) {
                iArrB[0] = i8 + 1;
                i9--;
            }
            if (iArrB[0] > i4) {
                return Float.NaN;
            }
            int i11 = i2 + 1;
            while (i11 < width && bitMatrix.get(i11, i3)) {
                iArrB[2] = iArrB[2] + 1;
                i11++;
            }
            if (i11 == width) {
                return Float.NaN;
            }
            while (i11 < width && !bitMatrix.get(i11, i3) && (i7 = iArrB[3]) < i4) {
                iArrB[3] = i7 + 1;
                i11++;
            }
            if (i11 != width && iArrB[3] < i4) {
                while (i11 < width && bitMatrix.get(i11, i3) && (i6 = iArrB[4]) < i4) {
                    iArrB[4] = i6 + 1;
                    i11++;
                }
                int i12 = iArrB[4];
                if (i12 < i4 && Math.abs(((((iArrB[0] + iArrB[1]) + iArrB[2]) + iArrB[3]) + i12) - i5) * 5 < i5 && c(iArrB)) {
                    return a(iArrB, i11);
                }
            }
        }
        return Float.NaN;
    }

    public static void b(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean c(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector.FinderPattern[] d() throws in.juspay.widget.qrscanner.com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector.FinderPatternFinder.d():in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector.FinderPattern[]");
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int[] b() {
        a(this.f48968d);
        return this.f48968d;
    }

    private int a() {
        if (this.f48966b.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.f48966b) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.f48967c = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    public final FinderPatternInfo a(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.f48965a.getHeight();
        int width = this.f48965a.getWidth();
        int i2 = (height * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean zC = false;
        while (i3 < height && !zC) {
            a(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                if (this.f48965a.get(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (c(iArr) && a(iArr, i3, i4)) {
                    if (this.f48967c) {
                        zC = c();
                    } else {
                        int iA = a();
                        int i6 = iArr[2];
                        if (iA > i6) {
                            i3 += (iA - i6) - 2;
                            i4 = width - 1;
                        }
                    }
                    a(iArr);
                    i2 = 2;
                    i5 = 0;
                } else {
                    b(iArr);
                    i5 = 3;
                }
                i4++;
            }
            if (c(iArr) && a(iArr, i3, width)) {
                i2 = iArr[0];
                if (this.f48967c) {
                    zC = c();
                }
            }
            i3 += i2;
        }
        FinderPattern[] finderPatternArrD = d();
        ResultPoint.orderBestPatterns(finderPatternArrD);
        return new FinderPatternInfo(finderPatternArrD);
    }

    public static void a(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    private boolean a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArrB = b();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.f48965a.get(i3 - i7, i2 - i7)) {
            iArrB[2] = iArrB[2] + 1;
            i7++;
        }
        if (iArrB[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.f48965a.get(i3 - i7, i2 - i7)) {
            iArrB[1] = iArrB[1] + 1;
            i7++;
        }
        if (iArrB[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.f48965a.get(i3 - i7, i2 - i7)) {
            iArrB[0] = iArrB[0] + 1;
            i7++;
        }
        if (iArrB[0] == 0) {
            return false;
        }
        int height = this.f48965a.getHeight();
        int width = this.f48965a.getWidth();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= height || (i6 = i3 + i8) >= width || !this.f48965a.get(i6, i9)) {
                break;
            }
            iArrB[2] = iArrB[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= height || (i5 = i3 + i8) >= width || this.f48965a.get(i5, i10)) {
                break;
            }
            iArrB[3] = iArrB[3] + 1;
            i8++;
        }
        if (iArrB[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= height || (i4 = i3 + i8) >= width || !this.f48965a.get(i4, i11)) {
                break;
            }
            iArrB[4] = iArrB[4] + 1;
            i8++;
        }
        if (iArrB[4] == 0) {
            return false;
        }
        return d(iArrB);
    }

    public final boolean a(int[] iArr, int i2, int i3) {
        int i4 = 0;
        int i5 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i3);
        float fB = b(i2, iA, iArr[2], i5);
        if (!Float.isNaN(fB)) {
            int i6 = (int) fB;
            float fA = a(iA, i6, iArr[2], i5);
            if (!Float.isNaN(fA) && a(i6, (int) fA)) {
                float f2 = i5 / 7.0f;
                while (true) {
                    if (i4 < this.f48966b.size()) {
                        FinderPattern finderPattern = this.f48966b.get(i4);
                        if (finderPattern.a(f2, fB, fA)) {
                            this.f48966b.set(i4, finderPattern.b(fB, fA, f2));
                            break;
                        }
                        i4++;
                    } else {
                        FinderPattern finderPattern2 = new FinderPattern(fA, fB, f2);
                        this.f48966b.add(finderPattern2);
                        ResultPointCallback resultPointCallback = this.f48969e;
                        if (resultPointCallback != null) {
                            resultPointCallback.foundPossibleResultPoint(finderPattern2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
