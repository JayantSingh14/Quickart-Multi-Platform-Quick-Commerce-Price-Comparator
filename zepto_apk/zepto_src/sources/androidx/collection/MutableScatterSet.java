package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableScatterSet<E> extends ScatterSet<E> {

    @Metadata
    @SourceDebugExtension
    public final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, KMutableSet {
        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            throw null;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final void clear() {
            throw null;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            throw null;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public final boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            throw null;
        }
    }

    public MutableScatterSet(int i2) {
        long[] jArr;
        this.f1590a = ScatterMapKt.f1589a;
        this.f1591b = ContainerHelpersKt.f1612c;
        if (i2 < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        int iC = ScatterMapKt.c(i2);
        int iMax = iC > 0 ? Math.max(7, ScatterMapKt.b(iC)) : 0;
        this.f1592c = iMax;
        if (iMax == 0) {
            jArr = ScatterMapKt.f1589a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            ArraysKt.r(jArr);
        }
        this.f1590a = jArr;
        int i3 = iMax >> 3;
        long j2 = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j2)) | j2;
        ScatterMapKt.a(this.f1592c);
        this.f1591b = new Object[iMax];
    }

    public MutableScatterSet() {
        this(6);
    }
}
