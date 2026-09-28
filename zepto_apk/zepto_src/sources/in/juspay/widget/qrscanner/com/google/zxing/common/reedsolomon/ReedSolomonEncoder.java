package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class ReedSolomonEncoder {

    /* renamed from: a, reason: collision with root package name */
    private final GenericGF f48916a;

    /* renamed from: b, reason: collision with root package name */
    private final List<GenericGFPoly> f48917b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f48916a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.f48917b = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly a(int i2) {
        if (i2 >= this.f48917b.size()) {
            GenericGFPoly genericGFPolyC = (GenericGFPoly) e.k(1, this.f48917b);
            for (int size = this.f48917b.size(); size <= i2; size++) {
                GenericGF genericGF = this.f48916a;
                genericGFPolyC = genericGFPolyC.c(new GenericGFPoly(genericGF, new int[]{1, genericGF.a(genericGF.getGeneratorBase() + (size - 1))}));
                this.f48917b.add(genericGFPolyC);
            }
        }
        return this.f48917b.get(i2);
    }

    public void encode(int[] iArr, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i2;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly genericGFPolyA = a(i2);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrA = new GenericGFPoly(this.f48916a, iArr2).a(i2, 1).b(genericGFPolyA)[1].a();
        int length2 = i2 - iArrA.length;
        for (int i3 = 0; i3 < length2; i3++) {
            iArr[length + i3] = 0;
        }
        System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
    }
}
