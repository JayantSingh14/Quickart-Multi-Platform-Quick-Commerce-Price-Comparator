package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Cut;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.lang.Comparable;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Range f42992c = new Range(Cut.BelowAll.f42594b, Cut.AboveAll.f42593b);

    /* renamed from: a, reason: collision with root package name */
    public final Cut f42993a;

    /* renamed from: b, reason: collision with root package name */
    public final Cut f42994b;

    /* renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42995a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f42995a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42995a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class LowerBoundFn implements Function<Range, Cut> {

        /* renamed from: a, reason: collision with root package name */
        public static final LowerBoundFn f42996a = new LowerBoundFn();

        @Override // com.google.common.base.Function
        public final Cut apply(Range range) {
            return range.f42993a;
        }
    }

    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final Ordering f42997a = new RangeLexOrdering();

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Range range = (Range) obj;
            Range range2 = (Range) obj2;
            return ComparisonChain.f42583a.b(range.f42993a, range2.f42993a).b(range.f42994b, range2.f42994b).f();
        }
    }

    public static class UpperBoundFn implements Function<Range, Cut> {

        /* renamed from: a, reason: collision with root package name */
        public static final UpperBoundFn f42998a = new UpperBoundFn();

        @Override // com.google.common.base.Function
        public final Cut apply(Range range) {
            return range.f42994b;
        }
    }

    public Range(Cut cut, Cut cut2) {
        cut.getClass();
        this.f42993a = cut;
        cut2.getClass();
        this.f42994b = cut2;
        if (cut.compareTo(cut2) > 0 || cut == Cut.AboveAll.f42593b || cut2 == Cut.BelowAll.f42594b) {
            StringBuilder sb = new StringBuilder("Invalid range: ");
            StringBuilder sb2 = new StringBuilder(16);
            cut.c(sb2);
            sb2.append("..");
            cut2.d(sb2);
            sb.append(sb2.toString());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static Range b(Comparable comparable, BoundType boundType) {
        int iOrdinal = boundType.ordinal();
        Cut.AboveAll aboveAll = Cut.AboveAll.f42593b;
        if (iOrdinal == 0) {
            return new Range(new Cut.AboveValue(comparable), aboveAll);
        }
        if (iOrdinal == 1) {
            return new Range(Cut.a(comparable), aboveAll);
        }
        throw new AssertionError();
    }

    public static Range g(Comparable comparable, BoundType boundType, Comparable comparable2, BoundType boundType2) {
        BoundType boundType3 = BoundType.f42528a;
        return new Range(boundType == boundType3 ? new Cut.AboveValue(comparable) : Cut.a(comparable), boundType2 == boundType3 ? Cut.a(comparable2) : new Cut.AboveValue(comparable2));
    }

    public static Range h(Comparable comparable, BoundType boundType) {
        int iOrdinal = boundType.ordinal();
        Cut.BelowAll belowAll = Cut.BelowAll.f42594b;
        if (iOrdinal == 0) {
            return new Range(belowAll, Cut.a(comparable));
        }
        if (iOrdinal == 1) {
            return new Range(belowAll, new Cut.AboveValue(comparable));
        }
        throw new AssertionError();
    }

    public final boolean a(Comparable comparable) {
        comparable.getClass();
        return this.f42993a.h(comparable) && !this.f42994b.h(comparable);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return a((Comparable) obj);
    }

    public final boolean c() {
        return this.f42994b != Cut.AboveAll.f42593b;
    }

    public final Range d(Range range) {
        Cut cut = range.f42993a;
        Cut cut2 = this.f42993a;
        int iCompareTo = cut2.compareTo(cut);
        Cut cut3 = this.f42994b;
        Cut cut4 = range.f42994b;
        int iCompareTo2 = cut3.compareTo(cut4);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return range;
        }
        if (iCompareTo < 0) {
            cut2 = range.f42993a;
        }
        if (iCompareTo2 > 0) {
            cut3 = cut4;
        }
        Preconditions.d(this, range, "intersection is undefined for disconnected ranges %s and %s", cut2.compareTo(cut3) <= 0);
        return new Range(cut2, cut3);
    }

    public final boolean e(Range range) {
        return this.f42993a.compareTo(range.f42994b) <= 0 && range.f42993a.compareTo(this.f42994b) <= 0;
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            if (this.f42993a.equals(range.f42993a) && this.f42994b.equals(range.f42994b)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f42993a.equals(this.f42994b);
    }

    public final int hashCode() {
        return (this.f42993a.hashCode() * 31) + this.f42994b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(16);
        this.f42993a.c(sb);
        sb.append("..");
        this.f42994b.d(sb);
        return sb.toString();
    }
}
