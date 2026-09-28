package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class ScatterSet<E> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1590a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1591b;

    /* renamed from: c, reason: collision with root package name */
    public int f1592c;

    @Metadata
    @SourceDebugExtension
    public class SetWrapper implements Set<E>, KMappedMarker {
        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator it = elements.iterator();
            if (!it.hasNext()) {
                return true;
            }
            it.next();
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            throw null;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return SequencesKt.l(new ScatterSet$SetWrapper$iterator$1(2, null));
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.b(this, array);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cc, code lost:
    
        if (((r8 & ((~r8) << 6)) & r20) == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ce, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Object[] objArr = this.f1591b;
        long[] jArr = this.f1590a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j2) < 128) {
                        Object obj = objArr[(i2 << 3) + i4];
                        iHashCode += obj != null ? obj.hashCode() : 0;
                    }
                    j2 >>= 8;
                }
                if (i3 != 8) {
                    return iHashCode;
                }
            }
            if (i2 == length) {
                return iHashCode;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008a A[PHI: r11
      0x008a: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0044, B:20:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r21 = this;
            r0 = r21
            androidx.collection.ScatterSet$toString$1 r1 = new androidx.collection.ScatterSet$toString$1
            r1.<init>()
            java.lang.String r2 = ", "
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = "prefix"
            java.lang.String r4 = "["
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "]"
            java.lang.String r5 = "postfix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "..."
            java.lang.String r6 = "truncated"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.lang.Object[] r4 = r0.f1591b
            long[] r7 = r0.f1590a
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L91
            r10 = 0
            r11 = 0
        L33:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L8a
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L50:
            if (r9 >= r14) goto L87
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r12 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L7c
            int r17 = r10 << 3
            int r17 = r17 + r9
            r18 = r15
            r15 = r4[r17]
            r0 = -1
            if (r11 != r0) goto L6b
            r6.append(r5)
            goto L94
        L6b:
            if (r11 == 0) goto L70
            r6.append(r2)
        L70:
            java.lang.Object r0 = r1.invoke(r15)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r11 = r11 + 1
            goto L7e
        L7c:
            r18 = r15
        L7e:
            long r12 = r12 >> r18
            int r9 = r9 + 1
            r0 = r21
            r15 = r18
            goto L50
        L87:
            r0 = r15
            if (r14 != r0) goto L91
        L8a:
            if (r10 == r8) goto L91
            int r10 = r10 + 1
            r0 = r21
            goto L33
        L91:
            r6.append(r3)
        L94:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.toString():java.lang.String");
    }
}
