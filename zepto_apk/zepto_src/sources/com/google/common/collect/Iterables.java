package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Iterables {

    /* renamed from: com.google.common.collect.Iterables$1, reason: invalid class name */
    class AnonymousClass1 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.FluentIterable
        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterables$2, reason: invalid class name */
    class AnonymousClass2 extends FluentIterable<List<Object>> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterables$3, reason: invalid class name */
    class AnonymousClass3 extends FluentIterable<List<Object>> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterables$4, reason: invalid class name */
    class AnonymousClass4 extends FluentIterable<Object> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f42741b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f42742c;

        public AnonymousClass4(Iterable iterable, Predicate predicate) {
            this.f42741b = iterable;
            this.f42742c = predicate;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return Iterators.f(this.f42741b.iterator(), this.f42742c);
        }
    }

    /* renamed from: com.google.common.collect.Iterables$7, reason: invalid class name */
    class AnonymousClass7 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterables$8, reason: invalid class name */
    class AnonymousClass8 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.FluentIterable
        public final String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* renamed from: com.google.common.collect.Iterables$9, reason: invalid class name */
    class AnonymousClass9 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            Iterables.i(null, new Function() { // from class: com.google.common.collect.e

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f43171a = 0;

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    switch (this.f43171a) {
                        case 0:
                            return ((Iterable) obj).iterator();
                        default:
                            return ((Map) obj).keySet().iterator();
                    }
                }
            });
            throw null;
        }
    }

    public static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.FluentIterable
        public final String toString() {
            throw null;
        }
    }

    public static boolean a(Iterable iterable, Predicate predicate) {
        Iterator it = iterable.iterator();
        Preconditions.j(predicate, "predicate");
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (predicate.apply(it.next())) {
                break;
            }
            i2++;
        }
        return i2 != -1;
    }

    public static Iterable b(Iterable iterable, Predicate predicate) {
        iterable.getClass();
        return new AnonymousClass4(iterable, predicate);
    }

    public static Object c(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return androidx.fragment.app.e.k(1, list);
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object d(Collection collection) {
        Iterator it = collection.iterator();
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static Object e(Iterable iterable, Predicate predicate) {
        predicate.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean f(Iterable iterable, Predicate predicate) {
        boolean z = false;
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            predicate.getClass();
            while (it.hasNext()) {
                if (predicate.apply(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        List list = (List) iterable;
        predicate.getClass();
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!predicate.apply(obj)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, obj);
                    } catch (IllegalArgumentException unused) {
                        g(list, predicate, i3, i2);
                    } catch (UnsupportedOperationException unused2) {
                        g(list, predicate, i3, i2);
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        return i2 != i3;
    }

    public static void g(List list, Predicate predicate, int i2, int i3) {
        for (int size = list.size() - 1; size > i3; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            list.remove(i4);
        }
    }

    public static Object[] h(Collection collection) {
        return (collection instanceof Collection ? collection : Lists.a(collection.iterator())).toArray();
    }

    public static Iterable i(Collection collection, Function function) {
        collection.getClass();
        return new FluentIterable<Object>(collection, function) { // from class: com.google.common.collect.Iterables.5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Collection f42743b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function f42744c;

            {
                this.f42743b = collection;
                this.f42744c = function;
            }

            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return new Iterators.AnonymousClass6(this.f42743b.iterator(), this.f42744c);
            }
        };
    }
}
