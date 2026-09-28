package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

/* loaded from: classes4.dex */
public final class ReedSolomonDecoder {

    /* renamed from: a, reason: collision with root package name */
    private final GenericGF f48915a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.f48915a = genericGF;
    }

    private int[] a(GenericGFPoly genericGFPoly) throws ReedSolomonException {
        int iB = genericGFPoly.b();
        if (iB == 1) {
            return new int[]{genericGFPoly.b(1)};
        }
        int[] iArr = new int[iB];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f48915a.getSize() && i2 < iB; i3++) {
            if (genericGFPoly.a(i3) == 0) {
                iArr[i2] = this.f48915a.b(i3);
                i2++;
            }
        }
        if (i2 == iB) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    public void decode(int[] iArr, int i2) throws ReedSolomonException {
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.f48915a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            GenericGF genericGF = this.f48915a;
            int iA = genericGFPoly.a(genericGF.a(genericGF.getGeneratorBase() + i3));
            iArr2[(i2 - 1) - i3] = iA;
            if (iA != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        GenericGFPoly[] genericGFPolyArrA = a(this.f48915a.b(i2, 1), new GenericGFPoly(this.f48915a, iArr2), i2);
        GenericGFPoly genericGFPoly2 = genericGFPolyArrA[0];
        GenericGFPoly genericGFPoly3 = genericGFPolyArrA[1];
        int[] iArrA = a(genericGFPoly2);
        int[] iArrA2 = a(genericGFPoly3, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.f48915a.c(iArrA[i4]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = GenericGF.a(iArr[length], iArrA2[i4]);
        }
    }

    private int[] a(GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iB = this.f48915a.b(iArr[i2]);
            int iC = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 != i3) {
                    int iC2 = this.f48915a.c(iArr[i3], iB);
                    iC = this.f48915a.c(iC, (iC2 & 1) == 0 ? iC2 | 1 : iC2 & (-2));
                }
            }
            iArr2[i2] = this.f48915a.c(genericGFPoly.a(iB), this.f48915a.b(iC));
            if (this.f48915a.getGeneratorBase() != 0) {
                iArr2[i2] = this.f48915a.c(iArr2[i2], iB);
            }
        }
        return iArr2;
    }

    private GenericGFPoly[] a(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i2) throws ReedSolomonException {
        if (genericGFPoly.b() >= genericGFPoly2.b()) {
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly2;
        }
        GenericGFPoly genericGFPolyB = this.f48915a.b();
        GenericGFPoly genericGFPolyA = this.f48915a.a();
        while (true) {
            GenericGFPoly genericGFPoly3 = genericGFPolyA;
            GenericGFPoly genericGFPoly4 = genericGFPolyB;
            genericGFPolyB = genericGFPoly3;
            if (genericGFPoly.b() < i2 / 2) {
                int iB = genericGFPolyB.b(0);
                if (iB == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iB2 = this.f48915a.b(iB);
                return new GenericGFPoly[]{genericGFPolyB.c(iB2), genericGFPoly.c(iB2)};
            }
            if (genericGFPoly.c()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly genericGFPolyB2 = this.f48915a.b();
            int iB3 = this.f48915a.b(genericGFPoly.b(genericGFPoly.b()));
            while (genericGFPoly2.b() >= genericGFPoly.b() && !genericGFPoly2.c()) {
                int iB4 = genericGFPoly2.b() - genericGFPoly.b();
                int iC = this.f48915a.c(genericGFPoly2.b(genericGFPoly2.b()), iB3);
                genericGFPolyB2 = genericGFPolyB2.a(this.f48915a.b(iB4, iC));
                genericGFPoly2 = genericGFPoly2.a(genericGFPoly.a(iB4, iC));
            }
            genericGFPolyA = genericGFPolyB2.c(genericGFPolyB).a(genericGFPoly4);
            if (genericGFPoly2.b() >= genericGFPoly.b()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            GenericGFPoly genericGFPoly5 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly5;
        }
    }
}
