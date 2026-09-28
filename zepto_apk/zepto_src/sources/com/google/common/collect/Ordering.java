package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class Ordering<T> implements Comparator<T> {

    @VisibleForTesting
    @J2ktIncompatible
    public static class ArbitraryOrdering extends Ordering<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f42990a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        public final AbstractMap f42991b;

        public ArbitraryOrdering() {
            MapMaker mapMaker = new MapMaker();
            mapMaker.b();
            this.f42991b = (AbstractMap) mapMaker.a();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentMap] */
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int iIdentityHashCode = System.identityHashCode(obj);
            int iIdentityHashCode2 = System.identityHashCode(obj2);
            if (iIdentityHashCode != iIdentityHashCode2) {
                return iIdentityHashCode < iIdentityHashCode2 ? -1 : 1;
            }
            ?? r0 = this.f42991b;
            Integer numValueOf = (Integer) r0.get(obj);
            AtomicInteger atomicInteger = this.f42990a;
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(atomicInteger.getAndIncrement());
                Integer num = (Integer) r0.putIfAbsent(obj, numValueOf);
                if (num != null) {
                    numValueOf = num;
                }
            }
            Integer numValueOf2 = (Integer) r0.get(obj2);
            if (numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(atomicInteger.getAndIncrement());
                Integer num2 = (Integer) r0.putIfAbsent(obj2, numValueOf2);
                if (num2 != null) {
                    numValueOf2 = num2;
                }
            }
            int iCompareTo = numValueOf.compareTo(numValueOf2);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            throw new AssertionError();
        }

        public final String toString() {
            return "Ordering.arbitrary()";
        }
    }

    @J2ktIncompatible
    public static class ArbitraryOrderingHolder {
        static {
            new ArbitraryOrdering();
        }
    }

    @VisibleForTesting
    public static class IncomparableValueException extends ClassCastException {
    }

    public static Ordering b(Comparator comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static Ordering c() {
        return NaturalOrdering.f42971c;
    }

    public final Ordering a(Comparator comparator) {
        return new CompoundOrdering(this, comparator);
    }

    public Ordering d() {
        return new NullsFirstOrdering(this);
    }

    public Ordering e() {
        return new NullsLastOrdering(this);
    }

    public final Ordering f(Function function) {
        return new ByFunctionOrdering(function, this);
    }

    public Ordering g() {
        return new ReverseOrdering(this);
    }
}
