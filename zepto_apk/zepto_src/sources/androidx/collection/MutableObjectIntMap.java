package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    public MutableObjectIntMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1547a = jArr;
        this.f1548b = ContainerHelpersKt.f1612c;
        this.f1549c = IntSetKt.f1454a;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1550d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1547a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1548b = new Object[iMax];
        this.f1549c = new int[iMax];
    }

    public MutableObjectIntMap() {
        this(6);
    }
}
