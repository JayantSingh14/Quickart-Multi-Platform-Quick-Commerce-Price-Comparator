package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableLongFloatMap extends LongFloatMap {
    public MutableLongFloatMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1455a = jArr;
        this.f1456b = LongSetKt.f1475a;
        this.f1457c = FloatSetKt.f1430a;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1458d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1455a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1456b = new long[iMax];
        this.f1457c = new float[iMax];
    }

    public MutableLongFloatMap() {
        this(6);
    }
}
