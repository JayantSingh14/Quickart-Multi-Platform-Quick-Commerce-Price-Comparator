package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableIntObjectMap<V> extends IntObjectMap<V> {
    public MutableIntObjectMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1447a = jArr;
        this.f1448b = IntSetKt.f1454a;
        this.f1449c = ContainerHelpersKt.f1612c;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1450d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1447a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1448b = new int[iMax];
        this.f1449c = new Object[iMax];
    }

    public MutableIntObjectMap() {
        this(6);
    }
}
