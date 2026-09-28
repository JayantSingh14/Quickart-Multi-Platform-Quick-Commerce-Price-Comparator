package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {

    @Metadata
    @SourceDebugExtension
    public final class MutableMapWrapper extends ScatterMap<K, V>.MapWrapper implements Map<K, V>, KMutableMap {
        @Override // androidx.collection.ScatterMap.MapWrapper
        public final Set a() {
            return new MutableScatterMap$MutableMapWrapper$entries$1();
        }

        @Override // androidx.collection.ScatterMap.MapWrapper
        public final Set b() {
            return new MutableScatterMap$MutableMapWrapper$keys$1();
        }

        @Override // androidx.collection.ScatterMap.MapWrapper
        public final Collection c() {
            return new MutableScatterMap$MutableMapWrapper$values$1();
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public final void clear() {
            throw null;
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public final Object put(Object obj, Object obj2) {
            throw null;
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public final void putAll(Map from) {
            Intrinsics.checkNotNullParameter(from, "from");
            for (Map.Entry<K, V> entry : from.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public final Object remove(Object obj) {
            throw null;
        }
    }

    public MutableScatterMap(int i2) {
        long[] jArr;
        this.f1558a = ScatterMapKt.f1589a;
        Object[] objArr = ContainerHelpersKt.f1612c;
        this.f1559b = objArr;
        this.f1560c = objArr;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1561d = iMax;
        if (iMax == 0) {
            jArr = ScatterMapKt.f1589a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1558a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        ScatterMapKt.a(this.f1561d);
        this.f1559b = new Object[iMax];
        this.f1560c = new Object[iMax];
    }

    public MutableScatterMap() {
        this(6);
    }
}
