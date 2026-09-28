package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.lang.Comparable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f42591a;

    /* renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42592a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f42592a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42592a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class AboveAll extends Cut<Comparable<?>> {

        /* renamed from: b, reason: collision with root package name */
        public static final AboveAll f42593b = new AboveAll("");

        @Override // com.google.common.collect.Cut
        /* renamed from: b */
        public final int compareTo(Cut cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        public final void c(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public final int compareTo(Object obj) {
            return ((Cut) obj) == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        public final void d(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public final Comparable e() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public final Comparable g() {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public final boolean h(Comparable comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        public final int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public final Comparable i() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public final BoundType l() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public final BoundType n() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public final Cut p() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public final Cut q() {
            throw new IllegalStateException();
        }

        public final String toString() {
            return "+∞";
        }
    }

    public static final class BelowAll extends Cut<Comparable<?>> {

        /* renamed from: b, reason: collision with root package name */
        public static final BelowAll f42594b = new BelowAll("");

        @Override // com.google.common.collect.Cut
        /* renamed from: b */
        public final int compareTo(Cut cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        public final void c(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public final int compareTo(Object obj) {
            return ((Cut) obj) == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        public final void d(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public final Comparable e() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public final Comparable g() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public final boolean h(Comparable comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        public final int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public final Comparable i() {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public final BoundType l() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public final BoundType n() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public final Cut p() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public final Cut q() {
            throw new AssertionError("this statement should be unreachable");
        }

        public final String toString() {
            return "-∞";
        }
    }

    public Cut(Comparable comparable) {
        this.f42591a = comparable;
    }

    public static BelowValue a(Comparable comparable) {
        comparable.getClass();
        return new BelowValue(comparable);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Cut cut) {
        if (cut == BelowAll.f42594b) {
            return 1;
        }
        if (cut == AboveAll.f42593b) {
            return -1;
        }
        Comparable comparable = cut.f42591a;
        Range range = Range.f42992c;
        int iCompareTo = this.f42591a.compareTo(comparable);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        boolean z = this instanceof AboveValue;
        if (z == (cut instanceof AboveValue)) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public abstract void c(StringBuilder sb);

    public abstract void d(StringBuilder sb);

    public Comparable e() {
        return this.f42591a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Cut) {
            try {
                if (compareTo((Cut) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract Comparable g();

    public abstract boolean h(Comparable comparable);

    public abstract int hashCode();

    public abstract Comparable i();

    public abstract BoundType l();

    public abstract BoundType n();

    public abstract Cut p();

    public abstract Cut q();

    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AboveValue(Comparable comparable) {
            super(comparable);
            comparable.getClass();
        }

        @Override // com.google.common.collect.Cut
        public final void c(StringBuilder sb) {
            sb.append('(');
            sb.append(this.f42591a);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public final void d(StringBuilder sb) {
            sb.append(this.f42591a);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        public final Comparable g() {
            return this.f42591a;
        }

        @Override // com.google.common.collect.Cut
        public final boolean h(Comparable comparable) {
            Range range = Range.f42992c;
            return this.f42591a.compareTo(comparable) < 0;
        }

        @Override // com.google.common.collect.Cut
        public final int hashCode() {
            return ~this.f42591a.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public final Comparable i() {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public final BoundType l() {
            return BoundType.f42528a;
        }

        @Override // com.google.common.collect.Cut
        public final BoundType n() {
            return BoundType.f42529b;
        }

        @Override // com.google.common.collect.Cut
        public final Cut p() {
            throw null;
        }

        public final String toString() {
            return "/" + this.f42591a + "\\";
        }

        @Override // com.google.common.collect.Cut
        public final Cut q() {
            return this;
        }
    }

    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        @Override // com.google.common.collect.Cut
        public final void c(StringBuilder sb) {
            sb.append('[');
            sb.append(this.f42591a);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public final void d(StringBuilder sb) {
            sb.append(this.f42591a);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        public final Comparable g() {
            throw null;
        }

        @Override // com.google.common.collect.Cut
        public final boolean h(Comparable comparable) {
            Range range = Range.f42992c;
            return this.f42591a.compareTo(comparable) <= 0;
        }

        @Override // com.google.common.collect.Cut
        public final int hashCode() {
            return this.f42591a.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public final Comparable i() {
            return this.f42591a;
        }

        @Override // com.google.common.collect.Cut
        public final BoundType l() {
            return BoundType.f42529b;
        }

        @Override // com.google.common.collect.Cut
        public final BoundType n() {
            return BoundType.f42528a;
        }

        @Override // com.google.common.collect.Cut
        public final Cut q() {
            throw null;
        }

        public final String toString() {
            return "\\" + this.f42591a + "/";
        }

        @Override // com.google.common.collect.Cut
        public final Cut p() {
            return this;
        }
    }
}
