package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

/* loaded from: classes4.dex */
public final class GenericGFPoly {

    /* renamed from: a, reason: collision with root package name */
    private final GenericGF f48913a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f48914b;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f48913a = genericGF;
        int length = iArr.length;
        int i2 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f48914b = iArr;
            return;
        }
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f48914b = new int[]{0};
            return;
        }
        int i3 = length - i2;
        int[] iArr2 = new int[i3];
        this.f48914b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, i3);
    }

    public int a(int i2) {
        if (i2 == 0) {
            return b(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.f48914b) {
                iA = GenericGF.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.f48914b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            iA2 = GenericGF.a(this.f48913a.c(i2, iA2), this.f48914b[i4]);
        }
        return iA2;
    }

    public int b() {
        return this.f48914b.length - 1;
    }

    public GenericGFPoly c(int i2) {
        if (i2 == 0) {
            return this.f48913a.b();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f48914b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f48913a.c(this.f48914b[i3], i2);
        }
        return new GenericGFPoly(this.f48913a, iArr);
    }

    public String toString() {
        char c2;
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iB2 = b(iB);
            if (iB2 != 0) {
                if (iB2 < 0) {
                    sb.append(" - ");
                    iB2 = -iB2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iB2 != 1) {
                    int iC = this.f48913a.c(iB2);
                    if (iC == 0) {
                        c2 = '1';
                    } else if (iC == 1) {
                        c2 = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
                    sb.append(c2);
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }

    public GenericGFPoly a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f48913a.b();
        }
        int length = this.f48914b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f48913a.c(this.f48914b[i4], i3);
        }
        return new GenericGFPoly(this.f48913a, iArr);
    }

    public int b(int i2) {
        return this.f48914b[(r0.length - 1) - i2];
    }

    public GenericGFPoly c(GenericGFPoly genericGFPoly) {
        if (!this.f48913a.equals(genericGFPoly.f48913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || genericGFPoly.c()) {
            return this.f48913a.b();
        }
        int[] iArr = this.f48914b;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.f48914b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = GenericGF.a(iArr3[i5], this.f48913a.c(i3, iArr2[i4]));
            }
        }
        return new GenericGFPoly(this.f48913a, iArr3);
    }

    public GenericGFPoly a(GenericGFPoly genericGFPoly) {
        if (!this.f48913a.equals(genericGFPoly.f48913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c()) {
            return genericGFPoly;
        }
        if (genericGFPoly.c()) {
            return this;
        }
        int[] iArr = this.f48914b;
        int[] iArr2 = genericGFPoly.f48914b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = GenericGF.a(iArr2[i2 - length], iArr[i2]);
        }
        return new GenericGFPoly(this.f48913a, iArr3);
    }

    public GenericGFPoly[] b(GenericGFPoly genericGFPoly) {
        if (!this.f48913a.equals(genericGFPoly.f48913a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.c()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly genericGFPolyB = this.f48913a.b();
        int iB = this.f48913a.b(genericGFPoly.b(genericGFPoly.b()));
        GenericGFPoly genericGFPolyA = this;
        while (genericGFPolyA.b() >= genericGFPoly.b() && !genericGFPolyA.c()) {
            int iB2 = genericGFPolyA.b() - genericGFPoly.b();
            int iC = this.f48913a.c(genericGFPolyA.b(genericGFPolyA.b()), iB);
            GenericGFPoly genericGFPolyA2 = genericGFPoly.a(iB2, iC);
            genericGFPolyB = genericGFPolyB.a(this.f48913a.b(iB2, iC));
            genericGFPolyA = genericGFPolyA.a(genericGFPolyA2);
        }
        return new GenericGFPoly[]{genericGFPolyB, genericGFPolyA};
    }

    public boolean c() {
        return this.f48914b[0] == 0;
    }

    public int[] a() {
        return this.f48914b;
    }
}
