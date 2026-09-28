package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableObjectFloatMap<K> extends ObjectFloatMap<K> {
    public MutableObjectFloatMap(int i2) {
        long[] jArr = ScatterMapKt.f1589a;
        this.f1543a = jArr;
        this.f1544b = ContainerHelpersKt.f1612c;
        this.f1545c = FloatSetKt.f1430a;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1546d = iMax;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1543a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        this.f1544b = new Object[iMax];
        this.f1545c = new float[iMax];
    }

    public MutableObjectFloatMap() {
        this(6);
    }
}
