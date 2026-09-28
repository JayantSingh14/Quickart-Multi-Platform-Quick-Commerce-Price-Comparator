package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableLongLongMap extends LongLongMap {
    public MutableLongLongMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1464a = jArr;
        long[] jArr2 = LongSetKt.f1475a;
        this.f1465b = jArr2;
        this.f1466c = jArr2;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1467d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1464a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1465b = new long[iMax];
        this.f1466c = new long[iMax];
    }

    public MutableLongLongMap() {
        this(6);
    }
}
