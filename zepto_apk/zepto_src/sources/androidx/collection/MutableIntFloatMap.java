package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableIntFloatMap extends IntFloatMap {
    public MutableIntFloatMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1434a = jArr;
        this.f1435b = IntSetKt.f1454a;
        this.f1436c = FloatSetKt.f1430a;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1437d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1434a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1435b = new int[iMax];
        this.f1436c = new float[iMax];
    }

    public MutableIntFloatMap() {
        this(6);
    }
}
