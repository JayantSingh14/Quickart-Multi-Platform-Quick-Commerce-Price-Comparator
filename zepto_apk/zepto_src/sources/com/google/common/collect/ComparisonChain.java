package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ComparisonChain {

    /* renamed from: a, reason: collision with root package name */
    public static final ComparisonChain f42583a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final ComparisonChain f42584b = new InactiveComparisonChain(-1);

    /* renamed from: c, reason: collision with root package name */
    public static final ComparisonChain f42585c = new InactiveComparisonChain(1);

    /* renamed from: com.google.common.collect.ComparisonChain$1, reason: invalid class name */
    public class AnonymousClass1 extends ComparisonChain {
        public static ComparisonChain g(int i2) {
            return i2 < 0 ? ComparisonChain.f42584b : i2 > 0 ? ComparisonChain.f42585c : ComparisonChain.f42583a;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain a(int i2, int i3) {
            return g(i2 < i3 ? -1 : i2 > i3 ? 1 : 0);
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain b(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain c(Object obj, Object obj2, Comparator comparator) {
            return g(comparator.compare(obj, obj2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain d(boolean z, boolean z2) {
            return g(z == z2 ? 0 : z ? 1 : -1);
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain e(boolean z, boolean z2) {
            return g(z2 == z ? 0 : z2 ? 1 : -1);
        }

        @Override // com.google.common.collect.ComparisonChain
        public final int f() {
            return 0;
        }
    }

    public static final class InactiveComparisonChain extends ComparisonChain {

        /* renamed from: d, reason: collision with root package name */
        public final int f42586d;

        public InactiveComparisonChain(int i2) {
            this.f42586d = i2;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain a(int i2, int i3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain b(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain c(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain d(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain e(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final int f() {
            return this.f42586d;
        }
    }

    public abstract ComparisonChain a(int i2, int i3);

    public abstract ComparisonChain b(Comparable comparable, Comparable comparable2);

    public abstract ComparisonChain c(Object obj, Object obj2, Comparator comparator);

    public abstract ComparisonChain d(boolean z, boolean z2);

    public abstract ComparisonChain e(boolean z, boolean z2);

    public abstract int f();
}
